package org.sdnhub.odl.tutorial.tapapp.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.NotificationProviderService;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ActivesdnListener;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ActivesdnService;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ConstructTopology;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventSpecs.EventAction;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered.TriggeredEventType;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowIsRemoved;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowStatisticReceived;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.InstallFlowRuleInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.InstallNetworkPathInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IsLinkFlooded;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SendPacketOutInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetNetworkTopologyOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapService;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

enum TrafficProtocolType {
	TCP, UDP, ICMP, IP
};

//@SuppressWarnings("unused")
public class ActiveSDNAssignment implements ActivesdnListener{
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final static String DROP = "DROP";
    private final static String TABLE = "TABLE";
    private ActivesdnService activeSDNService;
    private TapService tapService;
    
//    private final AtomicLong eventID = new AtomicLong();
    private HashMap<String, ConnectedHostInfo> hostTable = new HashMap<String, ConnectedHostInfo>();
    private HashMap<String, List<String>> installedPaths = new HashMap<String, List<String>>();
    
    public HashMap<String, Integer> criticalLinks = new HashMap<String, Integer>();
    /**
     * List of Switch Statistics Snapshot against per Switch ID
     */
    public HashMap<Integer, List<SwitchStatsSnapshot>> networkStatistics = new HashMap<Integer, List<SwitchStatsSnapshot>>();
    
    /**
     * Number of snapshots(array list size) taken against the sourceIp(string)
     */
    public HashMap<Integer, SwitchStatsSnapshot> currentSwitchStats = new HashMap<Integer, SwitchStatsSnapshot>();
    public HashMap<String, ArrayList<Boolean>> sourceIpConfidence = new HashMap<String, ArrayList<Boolean>>();
    public List<String> blockedIPs = Lists.newArrayList();
    public List<String> throttledIPs = Lists.newArrayList();
    public List<String> listOfNewComers = Lists.newArrayList();
    List<String>whiteListedSources = Lists.newArrayList();
    public List<String> serverIPs = Lists.newArrayList();
    List<Integer> edgeSwitches = Lists.newArrayList();
    private NetworkGraph topology;
	public boolean isSpecialMutationStarted;
    
    public static final int FLOW_PRIORITY = 300;
    
	@SuppressWarnings("deprecation")
	public ActiveSDNAssignment(DataBroker dataBroker, NotificationProviderService notificationService, 
			RpcProviderRegistry rpcProviderRegistry, NetworkGraph topology) {
        this.activeSDNService = rpcProviderRegistry.getRpcService(ActivesdnService.class);
        
        this.tapService = rpcProviderRegistry.getRpcService(TapService.class);
        notificationService.registerNotificationListener(this);
        this.topology = topology;
	}

	@Override
	public void onNewHostFound(NewHostFound notification) {
		ConnectedHostInfo connectedHost = new ConnectedHostInfo(
				notification.getHostMacAddress(), notification.getHostIpAddress(), 
				notification.getSwitchConnectedTo(), notification.getPortConnectedTo());
		hostTable.put(notification.getHostIpAddress(), connectedHost);
		edgeSwitches.add(notification.getSwitchConnectedTo());
	}

	@Override
	public void onConstructTopology(ConstructTopology notification) {
		try {
			Future<RpcResult<GetNetworkTopologyOutput>> topologyFutureOutput = tapService.getNetworkTopology();
			if (topologyFutureOutput != null){
				GetNetworkTopologyOutput topologyOutput = topologyFutureOutput.get().getResult();
				topology = new NetworkGraph(topologyOutput);
			}
		} catch (Exception e){
			LOG.debug("Exception reached." , e);
		}
	}
	

	private void sendingPacketOut(EventTriggered notification) {
		SendPacketOutInputBuilder packetOutBuilder = new SendPacketOutInputBuilder();
		packetOutBuilder.setSwitchId(notification.getSwitchId());
		packetOutBuilder.setInPortNumber(notification
				.getInPortNumber());
		packetOutBuilder.setPayload(notification.getPayload()); 
		packetOutBuilder.setOutputPort(TABLE);
		
		this.activeSDNService.sendPacketOut(packetOutBuilder.build());
	}
	
	/**
	 * Checks whether path is already installed or not. If not then install a path for TCP, UDP and ICMP protocol
	 * @param packetHeaderFields
	 * @return Return <code>false</code> if install nothing, <code>true</code> if installs a path.
	 */
	private boolean installPath(Ipv4PacketHeaderFields packetHeaderFields) {
		ConnectedHostInfo srcHost = hostTable.get(packetHeaderFields.getSourceAddress());
		ConnectedHostInfo dstHost = hostTable.get(packetHeaderFields.getDestinationAddress());
		String forwardPathKey = srcHost.getHostIP() + ":" + dstHost.getHostIP();
		String reversePathKey = dstHost.getHostIP() + ":" + srcHost.getHostIP();
		
		if (installedPaths.containsKey(forwardPathKey) || installedPaths.containsKey(reversePathKey)){
			LOG.debug("=========================================================================================");
			LOG.debug("Path is already installed between nodes     " + srcHost.getHostIP() + " and " + dstHost.getHostIP());
			LOG.debug("=========================================================================================");
			
			return false;
		} else {
			LOG.debug("     ==================================================================     ");
			LOG.debug("Installing a path using forwardPathKey {}, and installed pathSize {}", forwardPathKey, installedPaths.size());
			LOG.debug("     ==================================================================     ");
			
			InstallNetworkPathInputBuilder pathInputBuilder = new InstallNetworkPathInputBuilder();
			
			pathInputBuilder.setSrcIpAddress(packetHeaderFields.getSourceAddress());
			pathInputBuilder.setDstIpAddress(packetHeaderFields.getDestinationAddress());
			pathInputBuilder.setFlowPriority(FLOW_PRIORITY);
			
			List<Integer> pathNodes = Lists.newArrayList();
			List<String> path = topology.findShortestPath(
					srcHost.getSwitchConnectedTo(), dstHost.getSwitchConnectedTo());
			if (path != null) {
				LOG.debug("==================================================================     ");
				LOG.debug("Path found for installing is {}", path.toString());
				LOG.debug("==================================================================     ");
				
				for (String node : path){
					pathNodes.add(Integer.parseInt(node));
				}
				pathInputBuilder.setSwitchesInPath(pathNodes);
				installedPaths.put(forwardPathKey, path);
			}
			pathInputBuilder.setTypeOfTraffic(TrafficType.ICMP);
			this.activeSDNService.installNetworkPath(pathInputBuilder.build());
			
			return true;
		}
	}

	@Override
	public void onEventTriggered(EventTriggered notification) {
		boolean isPathAlreadyExist = false;
//		LOG.debug("     ==================================================================     ");
//		LOG.debug("                    Event Triggered is called.");
//		LOG.debug("     ==================================================================     ");
		
		if (notification.getPacketType() instanceof Ipv4PacketType) {
			Ipv4PacketType ipv4Packet = (Ipv4PacketType) notification.getPacketType();
			if (!(hostTable.containsKey(ipv4Packet.getSourceAddress()) && 
					hostTable.containsKey(ipv4Packet.getDestinationAddress()))){
				LOG.debug("=====================================================================================");
				LOG.debug("	For this IP Packet, either source or destination host is not available in the Host Table");
				LOG.debug("=====================================================================================");
				return;
			}
		} else if (notification.getPacketType() instanceof IcmpPacketType) {
			IcmpPacketType icmpPacket = (IcmpPacketType) notification.getPacketType();
			if (!(hostTable.containsKey(icmpPacket.getSourceAddress()) && 
					hostTable.containsKey(icmpPacket.getDestinationAddress()))){
				LOG.debug("=================================================================================");
				LOG.debug("	For this ICMP Packet, either source or destination host is not available in the Host Table");
				LOG.debug("=================================================================================");
				return;
			}
		} else if (notification.getPacketType() instanceof TcpPacketType) {
			TcpPacketType tcpPacketType = (TcpPacketType) notification.getPacketType();
			if (!(hostTable.containsKey(tcpPacketType.getSourceAddress()) && hostTable
					.containsKey(tcpPacketType.getDestinationAddress()))) {
				LOG.debug("=================================================================================");
				LOG.debug("	For this TCP Packet, either source or destination host is not available in the Host Table");
				LOG.debug("=================================================================================");
				return;
			}
		}
		//============================================================================================
		if (notification.getTriggeredEventType() == TriggeredEventType.NoFlowRuleEvent) {
			//If conditions checks if the Event is triggered because the switch couldn't find any flow rule
			if (notification.getPacketType() instanceof Ipv4PacketType) {
				//This condition checks if the the Packet received in the notification is of an IP Version 4 Packet
				//you can get IP packet fields by using .get methods, e.g., ipv4Packet.getDestinationAddress()
				@SuppressWarnings("unused")
				Ipv4PacketType ipv4Packet = (Ipv4PacketType) notification.getPacketType();
			}
			else if (notification.getPacketType() instanceof IcmpPacketType) {
				//This condition checks if the the Packet received in the notification is of an ICMP Packet
				//you can get ICMP packet fields by using .get methods, e.g., icmpPacket.getCrc()
				@SuppressWarnings("unused")
				IcmpPacketType icmpPacket = (IcmpPacketType) notification.getPacketType();
			}
		} 
		else if (notification.getTriggeredEventType() == TriggeredEventType.ControllerFlowRuleEvent) {
			//If conditions checks if the Event is triggered because of a flow rule that 
			//explicitly forwards the packet to the controller. You can get the flow rule id from notification.getEventId()
			
			///We need the handle the special case where if the switch receives a packet who it was forwarding before but as 
			// the path is migrated away due to link failure or attack. Now, there will now path exists for this packet but that 
			// path doesn't contain current ingress node. So, the packet may stuck in an infinite loop between the controller and switch
			
			////------------------------------------------------------------------------------------------------------
			/////////////                   Handling IPv4 Traffic        /////////////////////////////////////////////  
			////------------------------------------------------------------------------------------------------------
			if (notification.getPacketType() instanceof Ipv4PacketType) {
				LOG.debug("IPV4 packet found in On Event Triggered");
				Ipv4PacketType ipv4Packet = (Ipv4PacketType) notification.getPacketType();
				
				isPathAlreadyExist = !installPath(ipv4Packet);
				sendingPacketOut(notification);
				
				if (isPathAlreadyExist) {
					return;
				}
			}
			////-----------------------------------------------------------------------------------------------------
			/////////////                   Handling TCP Traffic        /////////////////////////////////////////////  
			////-----------------------------------------------------------------------------------------------------
			else if (notification.getPacketType() instanceof TcpPacketType) {
				LOG.debug("TCP packet found in On Event Triggered");
			}
			////------------------------------------------------------------------------------------------------------
			/////////////                   Handling ICMP Traffic        /////////////////////////////////////////////  
			////------------------------------------------------------------------------------------------------------
			else if (notification.getPacketType() instanceof IcmpPacketType) {
				LOG.debug("ICMP packet found in On Event Triggered");
				IcmpPacketType icmpPacket = (IcmpPacketType) notification.getPacketType();

				// example of simple subscribe event
				IcmpPacketType icmpPacketType = (IcmpPacketType) notification.getPacketType();
				installPath(icmpPacket);
				sendingPacketOut(notification);
				
				simpleSubscribeEvent(icmpPacketType); //icmp block event
				
				
			} /// End of ICMP Packet
		} /// End of ControllerEVentIF
		
		else if (notification.getTriggeredEventType() == TriggeredEventType.SubscribedEvent) {
			LOG.debug("Subscribed Event called!");
			//If conditions checks if the Event is triggered because of a subscribed event is triggered 
			//you can find the event id from notification.getEventId()
			if (notification.getPacketType() instanceof Ipv4PacketType) {
				@SuppressWarnings("unused")
				Ipv4PacketType ipv4Packet = (Ipv4PacketType) notification.getPacketType();
			}
			else if (notification.getPacketType() instanceof IcmpPacketType) {
				LOG.debug("Inside SubscribedEvent packet type: ICMP");
				IcmpPacketType icmpPacket = (IcmpPacketType) notification.getPacketType();
				ConnectedHostInfo srcHost = hostTable.get(icmpPacket.getSourceAddress());
				ConnectedHostInfo dstHost = hostTable.get(icmpPacket.getDestinationAddress());
				String forwardPathKey = srcHost.getHostIP() + ":" + dstHost.getHostIP();
				String reversePathKey = dstHost.getHostIP() + ":" + srcHost.getHostIP();
				
				LOG.debug("     ==================================================================     ");
				LOG.debug("      SubscribedEvent called for src {} to dst {}", srcHost.getHostIP(), dstHost.getHostIP());
				LOG.debug("     ==================================================================     ");
				
				LOG.debug("     ==================================================================     ");
				LOG.debug("      We will simply block the flow");
				LOG.debug("     ==================================================================     ");
				
				
				List<String> path = null;
				if (installedPaths.containsKey(forwardPathKey)){
					path = installedPaths.get(forwardPathKey);
					
				} else if (installedPaths.containsKey(reversePathKey)) {
					path = installedPaths.get(reversePathKey);
				} else {
					LOG.debug("     ==================================================================     ");
					LOG.debug("		No oldPath found. returning without blocking...");
					LOG.debug("     ==================================================================     ");
					return;
				}
				
				blockIP(srcHost.getHostIP(), dstHost.getHostIP(), TrafficType.ICMP, Integer.parseInt(path.get(0)), 0);
			}
		}

		/*
		if (notification.getPacketType() instanceof ArpPacketType){
			//This condition checks if the the Packet received in the notification is of an ARP Packet
			//you can get ARP packet fields by using .get methods, e.g., arpPacket.getEthernetSrcMacAddress()
			ArpPacketType arpPacket = (ArpPacketType) notification.getPacketType();
		*/	
		
	}

	public boolean simpleSubscribeEvent(IcmpPacketType icmpPacket) {
		ConnectedHostInfo srcHost = hostTable.get(icmpPacket.getSourceAddress());
		ConnectedHostInfo dstHost = hostTable.get(icmpPacket.getDestinationAddress());
		String forwardPathKey = srcHost.getHostIP() + ":" + dstHost.getHostIP();
		String reversePathKey = dstHost.getHostIP() + ":" + srcHost.getHostIP();
		
		List<String> path = null;
		if (installedPaths.containsKey(forwardPathKey)){
			path = installedPaths.get(forwardPathKey);
			
		} else if (installedPaths.containsKey(reversePathKey)) {
			path = installedPaths.get(reversePathKey);
		} else {
			LOG.debug("     ==================================================================     ");
			LOG.debug("		No oldPath found");
			LOG.debug("     ==================================================================     ");
			return false;
		}
		
		LOG.debug("     ==================================================================     ");
		LOG.debug("      Event subscription started for Switch Number: {}", path.get(0));
		LOG.debug("     ==================================================================     ");
		
		
		SubscribeEventInputBuilder eventInputBuilder = new SubscribeEventInputBuilder();
		eventInputBuilder.setCount((long)5);
		eventInputBuilder.setSrcIpAddress(icmpPacket.getSourceAddress());
		eventInputBuilder.setDstIpAddress(icmpPacket.getDestinationAddress());
		eventInputBuilder.setDuration((long)10);
		eventInputBuilder.setSwitchId(Integer.parseInt(path.get(0)));
		eventInputBuilder.setTrafficProtocol(TrafficType.ICMP);
		eventInputBuilder.setEventAction(EventAction.NOTIFY);
//		eventInputBuilder.setHoldNotification(5);
		
		this.activeSDNService.subscribeEvent(eventInputBuilder.build());
		return true;
	}

	/**
	 * Install a flow rule to Drops packets depending on the parameter 
	 * @param srcIp
	 * @param dstIp
	 * @param trafficType
	 * @param switchId
	 */
	private void blockIP(String srcIp, String dstIp, TrafficType trafficType, int switchId, int hardTimeOut) {
		
		LOG.debug("     ==================================================================     ");
		LOG.debug("     Blocking IP Source {} to Destination {} starts ", srcIp, dstIp);
		LOG.debug("     ==================================================================     ");
		
		InstallFlowRuleInputBuilder flowRuleInputBuilder = new InstallFlowRuleInputBuilder();
		
		flowRuleInputBuilder.setInPortId((long)0);
		flowRuleInputBuilder.setSwitchId(switchId);
		
		if (srcIp != null) {
			flowRuleInputBuilder.setSrcIpAddress(srcIp);
		}
			
		if(dstIp != null) {
			flowRuleInputBuilder.setDstIpAddress(dstIp);
		}
			
		if(trafficType != null) {
			flowRuleInputBuilder.setTypeOfTraffic(trafficType);
		}
			
		
		flowRuleInputBuilder.setFlowPriority(FLOW_PRIORITY + 30000);
		flowRuleInputBuilder.setIdleTimeout(0);
		flowRuleInputBuilder.setHardTimeout(0);
		flowRuleInputBuilder.setHardTimeout(0);
		
		flowRuleInputBuilder.setActionOutputPort(DROP);
		this.activeSDNService.installFlowRule(flowRuleInputBuilder.build());
		
		LOG.debug("     ==================================================================     ");
		LOG.debug("     Blocking IP Source {} to Destination {} ends ", srcIp, dstIp);
		LOG.debug("     ==================================================================     ");
		
	}

	/*
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 ////------------------------------subscribeEvent() Function example  ----------------------------------------////
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 SubscribeEventInputBuilder eventInputBuilder = new SubscribeEventInputBuilder();
		eventInputBuilder.setSwitchId(1);
		
		eventInputBuilder.setDstMacAddress("00:00:00:00:00:02");
		eventInputBuilder.setSrcMacAddress("00:00:00:00:00:01");
		eventInputBuilder.setDstIpAddress("10.0.0.2/32");
		eventInputBuilder.setSrcIpAddress("10.0.0.1/32");
		eventInputBuilder.setTrafficProtocol(TrafficType.ICMP);
		//eventInputBuilder.setTrafficProtocol(TrafficType.HTTP);
		//eventInputBuilder.setTrafficProtocol(TrafficType.DNS);
		eventInputBuilder.setInPortId((long)1);
		
		eventInputBuilder.setCount((long)10);
		eventInputBuilder.setDuration((long)20);

		//eventInputBuilder.setEventAction(EventAction.DROP); //OR
		eventInputBuilder.setEventAction(EventAction.NOTIFY); //OR
		eventInputBuilder.setEventAction(EventAction.DROPANDNOTIFY);
		eventInputBuilder.setHoldNotification(5); //number of instances e.g., 5 pings
		//This value is used only for Drop & Notify case where if you want to 
		 * hold notification immediately after drop. You could use this to create a malicious behavior where sowe 
		 * switch started dropping packets and then you either migratePath or create a tunnel to escape
		 * Please check the example for clarification.
		
		this.activeSDNService.subscribeEvent(eventInputBuilder.build());
	 
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 ////------------------------------installFlowRule() Function example  ---------------------------------------////
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 InstallFlowRuleInputBuilder flowRuleInputBuilder = new InstallFlowRuleInputBuilder();
		
		flowRuleInputBuilder.setSwitchId(1);
		flowRuleInputBuilder.setInPortId((long)1);
		flowRuleInputBuilder.setSrcIpAddress("10.0.0.1/32");
		flowRuleInputBuilder.setDstIpAddress("10.0.0.2/32");
		flowRuleInputBuilder.setSrcMacAddress("00:00:00:00:00:01");
		flowRuleInputBuilder.setDstMacAddress("00:00:00:00:00:02");
		flowRuleInputBuilder.setTypeOfTraffic(TrafficType.ICMP); //this is basically the traffic protocol
		flowRuleInputBuilder.setTypeOfTraffic(TrafficType.HTTP); //and more types
		flowRuleInputBuilder.setSrcPort(10000); //Source Port
		flowRuleInputBuilder.setDstPort(10000); //Destination Port
		
		flowRuleInputBuilder.setFlowPriority(100);
		flowRuleInputBuilder.setIdleTimeout(300);
		flowRuleInputBuilder.setHardTimeout(1000);
		
		//You can perform multiple actions
		//This will change the destination IP address field of the packet to new IP
		flowRuleInputBuilder.setActionSetDstIpv4Address("10.0.0.20/32");
		//This will change the source IP address field of the packet to new IP
		flowRuleInputBuilder.setActionSetSourceIpv4Address("10.0.0.10/32");
		//This will change the TTL value of the IP header to new value
		flowRuleInputBuilder.setActionSetIpv4Ttl((short)1);
		//This will change the Destination port value of the TCP header to new value
		flowRuleInputBuilder.setActionSetTcpDstPort(8000);
		//This will change the Source port value of the TCP header to new value
		flowRuleInputBuilder.setActionSetTcpSrcPort(8000);
		//This will change the TOS field value of the IP header. Please read online about the function of this field
		flowRuleInputBuilder.setActionSetIpv4Tos(4);
		//This will set the output port value for the flow rule
		flowRuleInputBuilder.setActionOutputPort("2");
		//This will set the output port to Flood so that packet belongs to this flow will be flooded.
		flowRuleInputBuilder.setActionOutputPort(FLOOD);
		//This will set the output port to Controller so that packet belongs to this flow will be sent to controller.
		flowRuleInputBuilder.setActionOutputPort(CONTROLLER);
		//This will set the output port to Drop so that packet belongs to this flow will be immediately dropped.
		flowRuleInputBuilder.setActionOutputPort(DROP);
		
		this.activeSDNService.installFlowRule(flowRuleInputBuilder.build());
		
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 ////------------------------------sendPacketOut() Function example  -----------------------------------------////
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 SendPacketOutInputBuilder packetOutBuilder = new SendPacketOutInputBuilder();
		packetOutBuilder.setSwitchId(1);
		packetOutBuilder.setInPortNumber(1);
		packetOutBuilder.setPayload(notification.getPayload()); //This sets the payload as received during PacketIn
		packetOutBuilder.setOutputPort("2"); // OR 
		packetOutBuilder.setOutputPort(FLOOD); // OR
		packetOutBuilder.setOutputPort(DROP); // OR
		packetOutBuilder.setOutputPort(CONTROLLER);

		this.activeSDNService.sendPacketOut(packetOutBuilder.build());
					
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------installNetworkPath() Function example  ------------------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	InstallNetworkPathInputBuilder pathInputBuilder = new InstallNetworkPathInputBuilder();
		pathInputBuilder.setSrcIpAddress("10.0.0.1/32");
		pathInputBuilder.setDstIpAddress("10.0.0.8/32");
		pathInputBuilder.setFlowPriority(300);
		pathInputBuilder.setIdleTimeout(60);
		pathInputBuilder.setHardTimeout(400); //values in seconds
		List<Integer> pathNodes = Lists.newArrayList(); //list of switches along the path
		pathNodes.add(1);
		pathNodes.add(2);
		pathNodes.add(3);
		pathNodes.add(4);
		pathNodes.add(5);
		pathNodes.add(6);
		pathNodes.add(7);
		pathNodes.add(8);
		pathInputBuilder.setSwitchesInPath(pathNodes);
		
		this.activeSDNService.installNetworkPath(pathInputBuilder.build());
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------migrateNetworkPath() Function example  ------------------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		ReRouteInputBuilder reRouteInputBuilder = new ReRouteInputBuilder();
		reRouteInputBuilder.setSrcIpAddress("10.0.0.1/32");
		reRouteInputBuilder.setDstIpAddress("10.0.0.8/32");
		reRouteInputBuilder.setFlowPriority(300);
		reRouteInputBuilder.setIdleTimeout(90);
		reRouteInputBuilder.setHardTimeout(0);
		
		List<Integer> oldPathNodes = Lists.newArrayList(); //List of switches along the old path
		oldPathNodes.add(3);
		oldPathNodes.add(2);
		oldPathNodes.add(1);
		oldPathNodes.add(5);
		oldPathNodes.add(7);
		reRouteInputBuilder.setSwitchesInOldPath(oldPathNodes); //list of switches along the new path
		
		List<Integer> newPathNodes = Lists.newArrayList();
		newPathNodes.add(3);
		newPathNodes.add(2);
		newPathNodes.add(5);
		newPathNodes.add(7);
		reRouteInputBuilder.setSwitchesInNewPath(oldPathNodes);
		this.activeSDNService.reRoute(reRouteInputBuilder.build());
						
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------createSrcDstTunnel() Function example  ------------------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	CreateSrcDstTunnelInputBuilder srcDstTunnelBuilder = new CreateSrcDstTunnelInputBuilder();
		srcDstTunnelBuilder.setCurrentSrcIpAddress("10.0.0.1/32");
		srcDstTunnelBuilder.setNewSrcIpAddress("10.0.0.10/32");
		srcDstTunnelBuilder.setCurrentDstIpAddress("10.0.0.8/32");
		srcDstTunnelBuilder.setNewDstIpAddress("10.0.0.80/32");
		srcDstTunnelBuilder.setFlowPriority(400);
		srcDstTunnelBuilder.setIdleTimeout(0);
		srcDstTunnelBuilder.setHardTimeout(0); //if you want the flow to remain forever in the switch
		
		List<Integer> pathNodes = Lists.newArrayList();
		pathNodes.add(1);
		pathNodes.add(2);
		pathNodes.add(3);
		pathNodes.add(4);
		pathNodes.add(5);
		pathNodes.add(6);
		pathNodes.add(7);
		pathNodes.add(8);
		srcDstTunnelBuilder.setSwitchesInPath(pathNodes);
		
		this.activeSDNService.createSrcDstTunnel(srcDstTunnelBuilder.build());
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------createSrcOnlyTunnel() Function example  -----------------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	CreateSrcOnlyTunnelInputBuilder srcOnlyTunnelBuilder = new CreateSrcOnlyTunnelInputBuilder();
		srcOnlyTunnelBuilder.setCurrentSrcIpAddress("10.0.0.1/32");
		srcOnlyTunnelBuilder.setNewSrcIpAddress("10.0.0.10/32");
		srcOnlyTunnelBuilder.setDstIpAddress("10.0.0.8/32");
		srcOnlyTunnelBuilder.setFlowPriority(400);
		srcOnlyTunnelBuilder.setIdleTimeout(0);
		srcOnlyTunnelBuilder.setHardTimeout(0); //if you want the flow to remain forever in the switch
		
		List<Integer> pathNodes = Lists.newArrayList();
		pathNodes.add(1);
		pathNodes.add(2);
		pathNodes.add(3);
		pathNodes.add(4);
		pathNodes.add(5);
		pathNodes.add(6);
		pathNodes.add(7);
		pathNodes.add(8);
		srcOnlyTunnelBuilder.setSwitchesInPath(pathNodes);
		
		this.activeSDNService.createSrcOnlyTunnel(srcOnlyTunnelBuilder.build());
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------createDstOnlyTunnel() Function example  -----------------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	CreateDstOnlyTunnelInputBuilder dstOnlyTunnelBuilder = new CreateDstOnlyTunnelInputBuilder();
		dstOnlyTunnelBuilder.setSrcIpAddress("10.0.0.1/32");
		dstOnlyTunnelBuilder.setCurrentDstIpAddress("10.0.0.8/32");
		dstOnlyTunnelBuilder.setNewDstIpAddress("10.0.0.80/32");
		dstOnlyTunnelBuilder.setFlowPriority(400);
		dstOnlyTunnelBuilder.setIdleTimeout(0);
		dstOnlyTunnelBuilder.setHardTimeout(0); //if you want the flow to remain forever in the switch
		
		List<Integer> pathNodes = Lists.newArrayList();
		pathNodes.add(1);
		pathNodes.add(2);
		pathNodes.add(3);
		pathNodes.add(4);
		pathNodes.add(5);
		pathNodes.add(6);
		pathNodes.add(7);
		pathNodes.add(8);
		dstOnlyTunnelBuilder.setSwitchesInPath(pathNodes);
		
		this.activeSDNService.createDstOnlyTunnel(dstOnlyTunnelBuilder.build());
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------removeAllFlowsFromASwitch() Function example  -----------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	RemoveAllFlowsFromASwitchInputBuilder removeFlowsInputBuilder = new RemoveAllFlowsFromASwitchInputBuilder();
		removeFlowsInputBuilder.setSwitchId(1);
		
		this.activeSDNService.removeAllFlowsFromASwitch(removeFlowsInputBuilder.build()); 
		
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------removeAFlowRuleFromSwitch() Function example  -----------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	RemoveAFlowRuleFromSwitchInputBuilder removeFlowInputBuilder = new RemoveAFlowRuleFromSwitchInputBuilder();
		//you have to provide a flowkey/flowID value. When you use function to get all flows from a switch
		//each flow will have a unique id and you can use that to delete a flow from the switch
		removeFlowInputBuilder.setFlowKey("value"); 
		removeFlowInputBuilder.setSwitchId(1);
		this.activeSDNService.removeAFlowRuleFromSwitch(removeFlowInputBuilder.build());
	
	 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------removeEventFromSwitch() Function example  -----------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	RemoveEventFromSwitchInputBuilder removeEvent = new RemoveEventFromSwitchInputBuilder();
		//When you create an event you should keep a copy of that event locally.
		removeEvent.setEventId("value");
		removeEvent.setSwitchId(1);
		this.activeSDNService.removeEventFromSwitch(removeEvent.build());
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////------------------------------getSwitchFlowTable() Function example  -----------------------------////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	you can call this function to get all flows rules from a switch. This function will automatically populate a local 
	HashMap data structure called networkConfiguration<SwitchID, ListOfFlowRules>  
	
		getSwitchFlowTable (int switchId)
		
		
	 */

	public HashMap<String, ConnectedHostInfo> getHostTable() {
		return hostTable;
	}

	public HashMap<String, List<String>> getInstalledPaths() {
		return installedPaths;
	}

	public NetworkGraph getTopology() {
		return topology;
	}
	@Override
	public void onFlowStatisticReceived(FlowStatisticReceived notification) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFlowIsRemoved(FlowIsRemoved notification) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onIsLinkFlooded(IsLinkFlooded notification) {
		// TODO Auto-generated method stub
		
	}

	public void updateInstalledPaths(NodeId sourceId, NodeId neighborId,
			Object object) {
		// TODO Auto-generated method stub
		
	}

	public void clearConfiguration() {
		// TODO Auto-generated method stub
		
	}
}
