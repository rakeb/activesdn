package org.sdnhub.odl.tutorial.tapapp.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.NotificationProviderService;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev100924.MacAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.DropActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.OutputActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwDstActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwSrcActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwTosActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwTtlActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetTpDstActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetTpSrcActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.address.address.Ipv4;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.Table;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.TableKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.statistics.rev130819.AggregateFlowStatisticsUpdate;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.statistics.rev130819.FlowStatisticsData;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.statistics.rev130819.FlowsStatisticsUpdate;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.statistics.rev130819.OpendaylightFlowStatisticsListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.statistics.rev130819.OpendaylightFlowStatisticsService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.queues.Queue;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.queues.QueueKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.queue.rev130925.QueueId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.Instructions;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.ApplyActionsCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.apply.actions._case.ApplyActions;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.Instruction;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.match.layer._3.match.Ipv4Match;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.match.layer._4.match.TcpMatch;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.PacketProcessingService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.TransmitPacketInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.FlowCapableNodeConnectorStatisticsData;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.NodeConnectorStatisticsUpdate;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.OpendaylightPortStatisticsListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.node.connector.statistics.and.port.number.map.NodeConnectorStatisticsAndPortNumberMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.queue.statistics.rev131216.FlowCapableNodeConnectorQueueStatisticsData;
import org.opendaylight.yang.gen.v1.urn.opendaylight.queue.statistics.rev131216.OpendaylightQueueStatisticsListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.queue.statistics.rev131216.QueueStatisticsUpdate;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.*;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received.SwitchStatistics;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received.SwitchStatisticsBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRulesBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.hosts.output.HostsInfo;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.hosts.output.HostsInfoBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatisticBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded.FloodedLinks;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded.FloodedLinksBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.special.mutation.input.HMi;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.AddTapInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.AddTapOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ConnectedHosts;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.LocalIpv4Prefix;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MutateIpInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MutateIpOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ReRouteEngineInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ReRouteEngineOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveATapFromSwitchInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveATapFromSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveFlowsFromSwitchInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveFlowsFromSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapService;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1Builder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.BlockCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.DropAndNotifyCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.NotifyCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.block._case.BlockActionBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotifyBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.notify._case.NotifyActionBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.DropPacketCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToControllerCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToFloodCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstIpv4AddressCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetIpv4TosCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetIpv4TtlCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetPortQueueCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetSourceIpv4AddressCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetTcpDstPortCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetTcpSrcPortCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.drop.packet._case.DropPacketBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.forward.to.controller._case.ForwardToControllerBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.forward.to.flood._case.ForwardToFloodBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.forward.to.port._case.ForwardToPortBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.ipv4.address._case.SetDstIpv4AddressBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.ipv4.tos._case.SetIpv4TosBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.ipv4.ttl._case.SetIpv4TtlBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.port.queue._case.SetQueueBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.source.ipv4.address._case.SetSourceIpv4AddressBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.tcp.dst.port._case.SetTcpDstPortBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.tcp.src.port._case.SetTcpSrcPortBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActions;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActionsBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlowBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.BothCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.DstOnlyCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.SourceOnlyCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.both._case.BothBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.dst.only._case.DstOnlyBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.source.only._case.SourceOnlyBuilder;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.concepts.Registration;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.sdnhub.odl.tutorial.utils.GenericTransactionUtils;
import org.sdnhub.odl.tutorial.utils.inventory.InventoryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.queue.statistics.rev131216.flow.capable.node.connector.queue.statistics.FlowCapableNodeConnectorQueueStatistics;

//Previously it is called ActivesdnAPI
@SuppressWarnings("deprecation")
public class ActivesdnServiceImpl implements ActivesdnService, OpendaylightFlowStatisticsListener, OpendaylightPortStatisticsListener, OpendaylightQueueStatisticsListener{

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private final static long FLOOD_PORT_NUMBER = 0xfffffffbL;
    private final static long TABLE_PORT_NUMBER = 0xfffffff9L;
    private final static long CONTROLLER_PORT_NUMBER = 0xfffffffdL;
	private final static String FLOOD = "FLOOD";
    private final static String DROP = "DROP";
    private final static String CONTROLLER = "CONTROLLER";
    private final static String TABLE = "TABLE";
    private DataBroker dataBroker;
    private NotificationProviderService notificationService;
    private TapService tapService;
    public final AtomicLong eventID = new AtomicLong();
    private PacketProcessingService packetProcessingService;
    private OpendaylightFlowStatisticsService statisticsService;
    private List<Registration> registrations = Lists.newArrayList();
    public List<Integer> listOfSwitchesForStats = Lists.newArrayList();
    public HashMap<String, Integer> listOfSwitchPortsForStats = new HashMap<String, Integer>(); //this will contain node connector id in string 
    private boolean firstTime = true;
    private boolean portFirstTime = true;
    private boolean queueFirstTime = true;
    private long startTime, previousTime, reportingTime = 50; 
    private long portStartTime, portPreviousTime, portReportingTime = 50;
    private long queueStartTime, queuePreviousTime, queueReportingTime = 51;
    private long observedQueueErrors = 0, observedReceiveDrops = 0, observedTransmitDrops = 0;
    private long delayedNotification = 0; 
    private boolean skip = true;
    private int pathMutationFlowPriority = 350;
    public Timer timer;
    public boolean hasTimerStarted = false;
    
    private ActiveSDNAssignment activeSdnApp = TapServiceImpl.getActiveSDNAssignment();
    
	public ActivesdnServiceImpl(DataBroker dataBroker, NotificationProviderService notificationService, RpcProviderRegistry rpcProviderRegistry) {
		//Store the data broker for reading/writing from inventory store
        this.dataBroker = dataBroker;
        this.notificationService = notificationService;
        //Object used for flow programming through RPC calls
        this.tapService = rpcProviderRegistry.getRpcService(TapService.class);
        this.statisticsService = rpcProviderRegistry.getRpcService(OpendaylightFlowStatisticsService.class);
        rpcProviderRegistry.addRpcImplementation(ActivesdnService.class, this);
        this.packetProcessingService = rpcProviderRegistry.getRpcService(PacketProcessingService.class);
        
        //InstanceIdentifier<Nodes> nodesIID = InstanceIdentifier.builder(Nodes.class)
        //		.build();
        //registerDataChangeListeners(nodesIID, false);
        
        timer = new Timer();
        
        this.notificationService.registerNotificationListener(this);
	}
	
	private void registerDataChangeListeners(InstanceIdentifier<?> iid, boolean configStore) {
        Preconditions.checkNotNull(dataBroker);
        //List<Registration> registrations = Lists.newArrayList();
        try {
            //Register listener for config updates and topology
            //InstanceIdentifier<TapSpec> tapSpecIID = InstanceIdentifier.builder(TapSpec.class)
            //        .build();
            ListenerRegistration<DataChangeListener> registration;
            if (configStore == true){
            	//registration = dataBroker.registerDataChangeListener(LogicalDatastoreType.CONFIGURATION, iid, this, AsyncDataBroker.DataChangeScope.SUBTREE);
            	registration = dataBroker.registerDataChangeListener(
                        LogicalDatastoreType.CONFIGURATION,
                        iid, (DataChangeListener) this, AsyncDataBroker.DataChangeScope.SUBTREE);
            } else {
            	registration = dataBroker.registerDataChangeListener(
                        LogicalDatastoreType.OPERATIONAL,
                        iid, (DataChangeListener) this, AsyncDataBroker.DataChangeScope.SUBTREE);
            }
            
            LOG.debug("         ---------------------------------------------------------------------     ");
            LOG.debug("DataChangeListener registered with MD-SAL for path {}", iid);
            LOG.debug("         ---------------------------------------------------------------------     ");
            this.registrations.add(registration);
            //this.registrations.add(registration);

        } catch (Exception e) {
            LOG.error("Exception reached {}", e);
        }
        //return registrations;
    }

	@Override
	public Future<RpcResult<InstallFlowRuleOutput>> installFlowRule(
			InstallFlowRuleInput input) {
		NodeId nodeId = new NodeId("openflow:" + input.getSwitchId().toString());
		
		NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
		if (input.getInPortId() != 0){
			newFlowBuilder.setInPort(InventoryUtils.getNodeConnectorId(nodeId, input.getInPortId()));
		}
		
		newFlowBuilder.setDstIpAddress((input.getDstIpAddress() != null ? 
				new Ipv4Prefix(input.getDstIpAddress()) : null));
		newFlowBuilder.setSrcIpAddress((input.getSrcIpAddress() != null ? 
				new Ipv4Prefix(input.getSrcIpAddress()) : null));
	
		
		newFlowBuilder.setDstMacAddress((input.getDstMacAddress() != null ? 
				new MacAddress(input.getDstMacAddress()) : null));
		newFlowBuilder.setSrcMacAddress((input.getSrcMacAddress() != null ? 
				new MacAddress(input.getSrcMacAddress()) : null));
		
		newFlowBuilder.setTrafficMatch(input.getTypeOfTraffic() != null ? input.getTypeOfTraffic() : null);
		newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
		newFlowBuilder.setHardTimeout(input.getHardTimeout());
		newFlowBuilder.setFlowPriority(input.getFlowPriority());
		
		long actionIndex = 1;
		List<AssociatedActions> actionList = Lists.newArrayList();
		AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
		
		if (input.getActionSetDstIpv4Address() != null){
			SetDstIpv4AddressBuilder setDstIPBuilder = new SetDstIpv4AddressBuilder();
			setDstIPBuilder.setValue(new Ipv4Prefix(input.getActionSetDstIpv4Address()));
			actionBuilder.setFlowActions(new SetDstIpv4AddressCaseBuilder().
					setSetDstIpv4Address(setDstIPBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		
		if (input.getActionSetSourceIpv4Address() != null){
			SetSourceIpv4AddressBuilder setSrcIPBuilder = new SetSourceIpv4AddressBuilder();
			setSrcIPBuilder.setValue(new Ipv4Prefix(input.getActionSetSourceIpv4Address()));
			actionBuilder.setFlowActions(new SetSourceIpv4AddressCaseBuilder().
					setSetSourceIpv4Address(setSrcIPBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		
		if (input.getActionSetIpv4Tos() != null){
			SetIpv4TosBuilder setTosBuilder = new SetIpv4TosBuilder();
			setTosBuilder.setValue(input.getActionSetIpv4Tos());
			actionBuilder.setFlowActions(new SetIpv4TosCaseBuilder().
					setSetIpv4Tos(setTosBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		
		if (input.getActionSetTcpSrcPort() != null) {
			SetTcpSrcPortBuilder setSrcPortBuilder = new SetTcpSrcPortBuilder();
			setSrcPortBuilder.setPortNumber(input.getActionSetTcpSrcPort());
			actionBuilder.setFlowActions(new SetTcpSrcPortCaseBuilder().
					setSetTcpSrcPort(setSrcPortBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		
		if (input.getActionSetTcpDstPort() != null) {
			SetTcpDstPortBuilder setDstPortBuilder = new SetTcpDstPortBuilder();
			setDstPortBuilder.setPortNumber(input.getActionSetTcpDstPort());
			actionBuilder.setFlowActions(new SetTcpDstPortCaseBuilder().
					setSetTcpDstPort(setDstPortBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		
		if (input.getActionSetIpv4Ttl() != null) {
			SetIpv4TtlBuilder ttlBuilder = new SetIpv4TtlBuilder();
			ttlBuilder.setTtlValue(input.getActionSetIpv4Ttl());
			actionBuilder.setFlowActions(new SetIpv4TtlCaseBuilder().
					setSetIpv4Ttl(ttlBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		
		if (input.getActionOutputPort() == FLOOD){
			ForwardToFloodBuilder floodBuilder = new ForwardToFloodBuilder();
			actionBuilder.setFlowActions(new ForwardToFloodCaseBuilder().
					setForwardToFlood(floodBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		else if (input.getActionOutputPort() == CONTROLLER) {
    		ForwardToControllerBuilder controllerBuilder = new ForwardToControllerBuilder();
    		actionBuilder.setFlowActions(new ForwardToControllerCaseBuilder().
    				setForwardToController(controllerBuilder.build()).build());
    		actionBuilder.setId(actionIndex++);
    		actionList.add(actionBuilder.build());
		}
		else if (input.getActionOutputPort() == DROP){
			DropPacketBuilder dropBuilder = new DropPacketBuilder();
			actionBuilder.setFlowActions(new DropPacketCaseBuilder().
					setDropPacket(dropBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		else if (input.getActionSetPortQueue() != null){
			SetQueueBuilder queueBuilder = new SetQueueBuilder();
			queueBuilder.setQueueId((long)input.getActionSetPortQueue());
			NodeConnectorId outputPort = InventoryUtils.getNodeConnectorId(nodeId, (long) Integer.parseInt(input.getActionOutputPort()));
			queueBuilder.setEgressPort(outputPort);
			
			actionBuilder.setFlowActions(new SetPortQueueCaseBuilder().setSetQueue(queueBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
		else 
		{
			ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
			NodeConnectorId outputPort = InventoryUtils.getNodeConnectorId(nodeId, (long) Integer.parseInt(input.getActionOutputPort()));
			forwardBuilder.setOutputNodeConnector(outputPort);
			actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
					setForwardToPort(forwardBuilder.build()).build());
			actionBuilder.setId(actionIndex++);
			actionList.add(actionBuilder.build());
		}
    	
		InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
		installFlowBuilder.setNode(nodeId);
		installFlowBuilder.setNewFlow(newFlowBuilder.build());
		installFlowBuilder.setAssociatedActions(actionList);
		installFlowBuilder.setFlowId(BigInteger.valueOf(eventID.incrementAndGet()).toString());
		
		InstallFlowRuleOutputBuilder output = new InstallFlowRuleOutputBuilder();
		try {
			Future<RpcResult<InstallFlowOutput>> futureOutput;
			futureOutput = tapService.installFlow(installFlowBuilder.build());
					
			if (futureOutput != null){
				InstallFlowOutput installOutput = futureOutput.get().getResult();
				output.setFlowId(installFlowBuilder.getFlowId());
				output.setStatus(installOutput.getStatus());
				return RpcResultBuilder.success(output.build()).buildFuture();
			}
		} catch (Exception e) {
			LOG.error("Exception reached in InstallFlowRule RPC {} --------", e);
			return null;
		}
		return null;
	}

	@Override
	public Future<RpcResult<SubscribeEventOutput>> subscribeEvent(
			SubscribeEventInput input) {
		//LOG.debug("         ---------------------------------------------------------------------     ");
		// LOG.debug("Subscribe event is called..................");
		// LOG.debug("         ---------------------------------------------------------------------     ");
		Tap1Builder tapInputBuilder = new Tap1Builder();
		NodeId nodeId = new NodeId("openflow:" + input.getSwitchId().toString());
		tapInputBuilder.setNode(nodeId);
		if (input.getInPortId() != null) {
			tapInputBuilder.setInPortConnector(InventoryUtils.getNodeConnectorId(nodeId, input.getInPortId()));
		}
		
		tapInputBuilder.setId(BigInteger.valueOf(eventID.incrementAndGet()).toString());
		tapInputBuilder.setCount(input.getCount());
		tapInputBuilder.setDuration(input.getDuration());
		tapInputBuilder.setSourceIpAddress(input.getSrcIpAddress() != null ? 
				new LocalIpv4Prefix(input.getSrcIpAddress()) : null);
		tapInputBuilder.setDstIpAddress(input.getDstIpAddress() != null ? 
				new LocalIpv4Prefix(input.getDstIpAddress()) : null);
		tapInputBuilder.setSourceMacAddress(input.getSrcMacAddress() != null ? 
				new MacAddress(input.getSrcMacAddress()) : null);
		tapInputBuilder.setDstMacAddress(input.getDstMacAddress() != null ? 
				new MacAddress(input.getDstMacAddress()) : null);
		//tapInputBuilder.setId("1");
		if (input.getTrafficProtocol() != null){
			tapInputBuilder.setTrafficMatch(input.getTrafficProtocol());
		}
		switch (input.getEventAction()) {
			case DROP:
				BlockActionBuilder blockBuilder = new BlockActionBuilder();
				tapInputBuilder.setTapActions(new BlockCaseBuilder().
						setBlockAction(blockBuilder.build()).build());
				break;
			case NOTIFY:
				NotifyActionBuilder notifyBuilder = new NotifyActionBuilder();
				tapInputBuilder.setTapActions(new NotifyCaseBuilder().
						setNotifyAction(notifyBuilder.build()).build());
				break;
			case DROPANDNOTIFY:
				DropAndNotifyBuilder dropAndNotifyBuilder = new DropAndNotifyBuilder();
				dropAndNotifyBuilder.setHoldNotification(input.getHoldNotification());
				tapInputBuilder.setTapActions(new DropAndNotifyCaseBuilder().
						setDropAndNotify(dropAndNotifyBuilder.build()).build());
				break;
		}
		List<Tap1> tapList = Lists.newArrayList();
		tapList.add(tapInputBuilder.build());
		AddTapInputBuilder inputBuilder = new AddTapInputBuilder();
		inputBuilder.setTap1(tapList);
		
		SubscribeEventOutputBuilder eventOutputBuilder = new SubscribeEventOutputBuilder();
		try {
			Future<RpcResult<AddTapOutput>> tapFutureOutput = tapService.addTap(inputBuilder.build());
			if (tapFutureOutput != null){
				AddTapOutput tapOutput = tapFutureOutput.get().getResult();
				eventOutputBuilder.setStatus(tapOutput.getStatus());
				eventOutputBuilder.setEventId(tapInputBuilder.getId());
				return RpcResultBuilder.success(eventOutputBuilder.build()).buildFuture();
			}
		} catch (Exception e){
			LOG.error("Exception reached in Subscribe Event RPC {} --------", e);
			return null;
		}
		return null;
	}
	
	@Override
	public Future<RpcResult<InstallNetworkPathOutput>> installNetworkPath(
			InstallNetworkPathInput input) {
		InstallPathInputBuilder installPathBuilder = new InstallPathInputBuilder();
		try {
			if (input.getDstIpAddress() != null){
				installPathBuilder.setDstIpAddress(new Ipv4Prefix(input.getDstIpAddress()));
			}
			else {
				String exception = "No Destination IP is provided.";
				throw new Exception(exception);
			}
			if (input.getSrcIpAddress() != null) {
				installPathBuilder.setSrcIpAddress(new Ipv4Prefix(input.getSrcIpAddress()));
			}
			else {
				String exception = "No Source IP is provided.";
				throw new Exception(exception);
			}
			if (input.getSwitchesInPath()!= null){
				List<NodeId> nodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					nodeList.add(nodeId);
				}
				installPathBuilder.setPathNodes(nodeList);
			}
			else {
				String exception = "No Path is provided.";
				throw new Exception(exception);
			}
			if (input.getTypeOfTraffic() != null){
				installPathBuilder.setTrafficMatch(input.getTypeOfTraffic());
			}
			//else {
			//	installPathBuilder.setTrafficMatch(TrafficType.TCP);
			//}
			installPathBuilder.setFlowPriority(input.getFlowPriority());
			installPathBuilder.setIdleTimeout(input.getIdleTimeout());
			installPathBuilder.setHardTimeout(input.getHardTimeout());
			///-------------------------------
			Future<RpcResult<InstallPathOutput>> pathFutureOutput =  
			tapService.installPath(installPathBuilder.build());
			if (pathFutureOutput != null) {
				InstallNetworkPathOutput output = new InstallNetworkPathOutputBuilder().
						setStatus(pathFutureOutput.get().getResult().getStatus()).build();
				return RpcResultBuilder.success(output).buildFuture();
			}
			else {
				String exception = "No Path could be installed.";
				throw new Exception(exception);
			}
		} catch (Exception e){
			LOG.error("Exception reached in InstallNetworkPath RPC {} --------", e);
			return null;
		}
	}
	
	@Override
	public Future<RpcResult<RedirectOutput>> redirect(
			RedirectInput input) {
		InstallInspectionPathInputBuilder installPathBuilder = new InstallInspectionPathInputBuilder();
		try {
			if (input.getDstIpAddress() != null){
				installPathBuilder.setDstIpAddress(new Ipv4Prefix(input.getDstIpAddress()));
			}
			else {
				String exception = "No Destination IP is provided.";
				throw new Exception(exception);
			}
			if (input.getSrcIpAddress() != null) {
				installPathBuilder.setSrcIpAddress(new Ipv4Prefix(input.getSrcIpAddress()));
			}
			else {
				String exception = "No Source IP is provided.";
				throw new Exception(exception);
			}
			if (input.getSwitchesInPath()!= null){
				List<NodeId> nodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					nodeList.add(nodeId);
				}
				installPathBuilder.setPathNodes(nodeList);
			}
			else {
				String exception = "No Path is provided.";
				throw new Exception(exception);
			}
			if (input.getTypeOfTraffic() != null){
				installPathBuilder.setTrafficMatch(input.getTypeOfTraffic());
			}
			//else {
			//	installPathBuilder.setTrafficMatch(TrafficType.TCP);
			//}
			installPathBuilder.setFlowPriority(input.getFlowPriority());
			installPathBuilder.setIdleTimeout(input.getIdleTimeout());
			installPathBuilder.setHardTimeout(input.getHardTimeout());
			//-------------------------
			NodeId nodeId = new NodeId("openflow:" + input.getInspectionSwitchId().toString());
			installPathBuilder.setInspectionSwitchId(nodeId);
			if (input.getInspectionSwitchPortId() == "CONTROLLER"){
				installPathBuilder.setInpsectionSwitchPort(InventoryUtils.getNodeConnectorId(nodeId, CONTROLLER_PORT_NUMBER));
			}
			else {
				installPathBuilder.setInpsectionSwitchPort(InventoryUtils.getNodeConnectorId(nodeId,Integer.parseInt(input.getInspectionSwitchPortId())));
			}

			///-------------------------------
			Future<RpcResult<InstallInspectionPathOutput>> pathFutureOutput = tapService.installInspectionPath(installPathBuilder.build());
			if (pathFutureOutput != null) {
				RedirectOutput output = new RedirectOutputBuilder().
						setStatus(pathFutureOutput.get().getResult().getStatus()).build();
				return RpcResultBuilder.success(output).buildFuture();
			}
			else {
				String exception = "No Path could be installed.";
				throw new Exception(exception);
			}
		} catch (Exception e){
			LOG.error("Exception reached in InstallNetworkPath RPC {} --------", e);
			return null;
		}
	}
	
	@Override
	public Future<RpcResult<CreateSrcOnlyTunnelOutput>> createSrcOnlyTunnel(
			CreateSrcOnlyTunnelInput input) {
		MutateIpInputBuilder mutateIpBuilder = new MutateIpInputBuilder();
		try {
			if (input.getDstIpAddress() == null || input.getCurrentSrcIpAddress() == null || 
					input.getNewSrcIpAddress() == null || input.getSwitchesInPath()== null) {
				String exception = "Incomplete Data is provided and some parameter has null value.";
				throw new Exception(exception);
			}
			else {
				mutateIpBuilder.setDstIpAddress(new Ipv4Prefix(input.getDstIpAddress()));
				mutateIpBuilder.setSrcIpAddress(new Ipv4Prefix(input.getCurrentSrcIpAddress()));
				List<NodeId> nodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					nodeList.add(nodeId);
				}
				mutateIpBuilder.setPathNodes(nodeList);
				
				SourceOnlyBuilder srcOnlyBuilder = new SourceOnlyBuilder();
				srcOnlyBuilder.setNewSrcIpAddress(new Ipv4Prefix(input.getNewSrcIpAddress()));
				SourceOnlyCaseBuilder srcOnlyCaseBuilder = new SourceOnlyCaseBuilder();
				srcOnlyCaseBuilder.setSourceOnly(srcOnlyBuilder.build());
				mutateIpBuilder.setMutationEnd(srcOnlyCaseBuilder.build());
				mutateIpBuilder.setFlowPriority(input.getFlowPriority());
				mutateIpBuilder.setIdleTimeout(input.getIdleTimeout());
				mutateIpBuilder.setHardTimeout(input.getHardTimeout());
				///-------------------------------
				Future<RpcResult<MutateIpOutput>> mutateIpFutureOutput =  
				tapService.mutateIp(mutateIpBuilder.build());
				if (mutateIpFutureOutput != null) {
					CreateSrcOnlyTunnelOutput output = new CreateSrcOnlyTunnelOutputBuilder().
							setStatus(mutateIpFutureOutput.get().getResult().getStatus()).build();
					return RpcResultBuilder.success(output).buildFuture();
				}
				else {
					String exception = "No Tunnel could be installed.";
					throw new Exception(exception);
				}
			}
		} catch (Exception e){
			LOG.error("Exception reached in Create Source Only Tunnel RPC {} --------", e);
			return null;
		}
	}
	
	@Override
	public Future<RpcResult<CreateDstOnlyTunnelOutput>> createDstOnlyTunnel(
			CreateDstOnlyTunnelInput input) {
		MutateIpInputBuilder mutateIpBuilder = new MutateIpInputBuilder();
		try {
			if (input.getCurrentDstIpAddress() == null || input.getSrcIpAddress() == null || 
					input.getNewDstIpAddress() == null || input.getSwitchesInPath()== null) {
				String exception = "Incomplete Data is provided and some parameter has null value.";
				throw new Exception(exception);
			}
			else {
				mutateIpBuilder.setDstIpAddress(new Ipv4Prefix(input.getCurrentDstIpAddress()));
				mutateIpBuilder.setSrcIpAddress(new Ipv4Prefix(input.getSrcIpAddress()));
				
				if(input.getSwitchesInPath() != null) {
					List<NodeId> nodeList = Lists.newArrayList();
					for (int node: input.getSwitchesInPath()){
						NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
						nodeList.add(nodeId);
					}
					mutateIpBuilder.setPathNodes(nodeList);
				}
				
				DstOnlyBuilder dstOnlyBuilder = new DstOnlyBuilder();
				dstOnlyBuilder.setNewDstIpAddress(new Ipv4Prefix(input.getNewDstIpAddress()));
				DstOnlyCaseBuilder dstOnlyCaseBuilder = new DstOnlyCaseBuilder();
				dstOnlyCaseBuilder.setDstOnly(dstOnlyBuilder.build());
				mutateIpBuilder.setMutationEnd(dstOnlyCaseBuilder.build());
				mutateIpBuilder.setFlowPriority(input.getFlowPriority());
				mutateIpBuilder.setIdleTimeout(input.getIdleTimeout());
				mutateIpBuilder.setHardTimeout(input.getHardTimeout());
				///-------------------------------
				Future<RpcResult<MutateIpOutput>> mutateIpFutureOutput =  
				tapService.mutateIp(mutateIpBuilder.build());
				if (mutateIpFutureOutput != null) {
					CreateDstOnlyTunnelOutput output = new CreateDstOnlyTunnelOutputBuilder().
							setStatus(mutateIpFutureOutput.get().getResult().getStatus()).build();
					return RpcResultBuilder.success(output).buildFuture();
				}
				else {
					String exception = "No Tunnel could be installed.";
					throw new Exception(exception);
				}
			}
		} catch (Exception e){
			LOG.error("Exception reached in Create Destination Only Tunnel RPC {} --------", e);
			return null;
		}
	}
	
	@Override
	public Future<RpcResult<CreateSrcDstTunnelOutput>> createSrcDstTunnel(
			CreateSrcDstTunnelInput input) {
		MutateIpInputBuilder mutateIpBuilder = new MutateIpInputBuilder();
		try {
			if (input.getCurrentDstIpAddress() == null || input.getCurrentSrcIpAddress() == null || 
					input.getNewDstIpAddress() == null || input.getNewSrcIpAddress() == null || 
					input.getSwitchesInPath()== null) {
				String exception = "Incomplete Data is provided and some parameter has null value.";
				throw new Exception(exception);
			}
			else {
				mutateIpBuilder.setDstIpAddress(new Ipv4Prefix(input.getCurrentDstIpAddress()));
				mutateIpBuilder.setSrcIpAddress(new Ipv4Prefix(input.getCurrentSrcIpAddress()));
				List<NodeId> nodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					nodeList.add(nodeId);
				}
				mutateIpBuilder.setPathNodes(nodeList);
				
				BothBuilder bothBuilder = new BothBuilder();
				bothBuilder.setNewDstIpAddress(new Ipv4Prefix(input.getNewDstIpAddress()));
				bothBuilder.setNewSrcIpAddress(new Ipv4Prefix(input.getNewSrcIpAddress()));
				BothCaseBuilder bothCaseBuilder = new BothCaseBuilder();
				bothCaseBuilder.setBoth(bothBuilder.build());
				mutateIpBuilder.setMutationEnd(bothCaseBuilder.build());
				mutateIpBuilder.setFlowPriority(input.getFlowPriority());
				mutateIpBuilder.setIdleTimeout(input.getIdleTimeout());
				mutateIpBuilder.setHardTimeout(input.getHardTimeout());
				///-------------------------------
				Future<RpcResult<MutateIpOutput>> mutateIpFutureOutput =  
				tapService.mutateIp(mutateIpBuilder.build());
				if (mutateIpFutureOutput != null) {
					CreateSrcDstTunnelOutput output = new CreateSrcDstTunnelOutputBuilder().
							setStatus(mutateIpFutureOutput.get().getResult().getStatus()).build();
					return RpcResultBuilder.success(output).buildFuture();
				}
				else {
					String exception = "No Tunnel could be installed.";
					throw new Exception(exception);
				}
			}
		} catch (Exception e){
			LOG.error("Exception reached in Create Source Destination lTunnel RPC {} --------", e);
			return null;
		}
	}
	
	/***
	 * TODO this is not completed, when not yet implemented, 
	 * take code from ActivesdnAssignment class
	 */
	@Override
	public Future<RpcResult<IpMutateOutput>> ipMutate(IpMutateInput input) {
		IpMutateEngineInputBuilder ipMutateEngineInputBuilder = new IpMutateEngineInputBuilder();
		try {
			if (input.getRipSrc() == null || input.getRipDst() == null || 
					input.getVipSrc() == null || input.getVipDst() == null) {
				String exception = "Incomplete Data is provided and some parameter has null value.";
				throw new Exception(exception);
			}
			else {
				ipMutateEngineInputBuilder.setRipSrc(new Ipv4Prefix(input.getRipSrc()));
				ipMutateEngineInputBuilder.setRipDst(new Ipv4Prefix(input.getRipDst()));
				ipMutateEngineInputBuilder.setVipSrc(new Ipv4Prefix(input.getVipSrc()));
				ipMutateEngineInputBuilder.setVipDst(new Ipv4Prefix(input.getVipDst()));
				
				String forwardPathKey = input.getRipSrc() + ":" + input.getRipDst();
				String reversePathKey = input.getRipDst() + ":" + input.getRipSrc();

				HashMap<String, List<String>> installedPaths = activeSdnApp.getInstalledPaths();
				List<String> path = installedPaths.get(forwardPathKey);
				if (path == null) {
					path = installedPaths.get(reversePathKey);
					path = Lists.reverse(path); // path needed to get it in right order
				} 
				if (path == null) {
					LOG.error("No Path found for IP mutation between src {}: dst {}", input.getRipSrc(), input.getRipDst());
					String exception = "IP mutation failed";
					throw new Exception(exception);
				}
				
				List<NodeId> nodeList = Lists.newArrayList();
				for (String node : path) {
					NodeId nodeId = new NodeId("openflow:" + node);
					nodeList.add(nodeId);
				}
				
				ipMutateEngineInputBuilder.setPathNodes(nodeList);
				
				ipMutateEngineInputBuilder.setFlowPriority(400);
				ipMutateEngineInputBuilder.setIdleTimeout(0);
				ipMutateEngineInputBuilder.setHardTimeout(0);
				///-------------------------------
				Future<RpcResult<IpMutateEngineOutput>> mutateIpFutureOutput =  
				tapService.ipMutateEngine(ipMutateEngineInputBuilder.build());
				if (mutateIpFutureOutput != null) {
					IpMutateOutput output = new IpMutateOutputBuilder().
							setStatus(mutateIpFutureOutput.get().getResult().getStatus()).build();
					return RpcResultBuilder.success(output).buildFuture();
				}
				else {
					String exception = "No Tunnel could be installed.";
					throw new Exception(exception);
				}
			}
		} catch (Exception e){
			LOG.error("Exception reached in Create Source Destination lTunnel RPC {} --------", e);
			return null;
		}
	}
	
	@Override
	public Future<RpcResult<SpecialMutationOutput>> specialMutation(
			SpecialMutationInput input) {

		// H1-->(H3,H8),(H4,H11),
		// H2-->(H1,H5),(H3,H9),(H4,H12),
		// H3-->(H1,H6),(H4,H13),
		// H4-->(H1,H7),(H3,H10),
		try {
			List<HMi> hMi = input.getHMi();
			Integer n = input.getN();
			List<String> unusedIpRange = new ArrayList<String>(
					input.getUnusedIpRange()); // we are not interested to change the input

			List<SpecialMutationHost> mutationHosts = new ArrayList<SpecialMutationHost>();

			Collection<ConnectedHostInfo> allHost = activeSdnApp.getHostTable()
					.values();
			for (ConnectedHostInfo host : allHost) {
				mutationHosts.add(new SpecialMutationHost(host, hMi, n,
						unusedIpRange));
			}

			combination(mutationHosts, mutationHosts.size(), 2);
			writeFile(mutationHosts, "dns_mapping.txt");
			Future<RpcResult<IpMutateOutput>> status = generateSpecialMutationFlows(mutationHosts);
			if (status != null) {
				SpecialMutationOutput specialMutationOutput = new SpecialMutationOutputBuilder().setStatus(status.get().getResult().getStatus()).build();
				activeSdnApp.isSpecialMutationStarted = true;
				return RpcResultBuilder.success(specialMutationOutput).buildFuture();
			} else {
				String exception = "Special mutation failed.";
				throw new Exception(exception);
			}
		} catch (Exception e) {
			LOG.error("Exception reached in Create Source Destination lTunnel RPC {} --------", e);
			return null;
		}
	}
	
	/**
	 * We implement this function for only to use in spetial mutation
	 * @param rIpSrc
	 * @param vIpSrc
	 * @param rIpDst
	 * @param vIpDst
	 * @return 
	 */
	Future<RpcResult<IpMutateOutput>> callIpMutation(String rIpSrc, String vIpSrc, String rIpDst, String vIpDst) {
//		String forwardPathKey = rIpSrc + ":" + rIpDst;
//		String reversePathKey = rIpDst + ":" + rIpSrc;
//		List<Integer> pathNodes = Lists.newArrayList();
		
//		HashMap<String, List<String>> installedPaths = activeSdnApp.getInstalledPaths();
//		List<String> path = installedPaths.get(forwardPathKey);
//		if (path == null) {
//			path = installedPaths.get(reversePathKey);
//		} 
//		if (path == null) {
//			LOG.error("No Path found for special mutation between src {}: dst {}", rIpSrc, rIpDst);
//			return null;
//		}
		
//		for (String node : path) {
//			pathNodes.add(Integer.parseInt(node));
//		}
		
		IpMutateInputBuilder ipMutateInputBuilder = new IpMutateInputBuilder();
		
		ipMutateInputBuilder.setRipSrc(rIpSrc);
		ipMutateInputBuilder.setVipSrc(vIpSrc);
		ipMutateInputBuilder.setRipDst(rIpDst);
		ipMutateInputBuilder.setVipDst(vIpDst);
		
		return ipMutate(ipMutateInputBuilder.build());
	}
	
	public static <T> void combinationUtil(List<T> arr, Object data[],
			int start, int end, int index, int r) {
		if (index == r) {
			SpecialMutationHost src = (SpecialMutationHost) data[0];
			SpecialMutationHost dst = (SpecialMutationHost) data[1];
			src.updateMutationPair(dst);
			dst.updateMutationPair(src);
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr.get(i);
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

	public static <T> void combination(List<T> arr, int n, int r) {
		Object data[] = new Object[r];
		combinationUtil(arr, data, 0, n - 1, 0, r);
	}
	
	Future<RpcResult<IpMutateOutput>> generateSpecialMutationFlows(List<SpecialMutationHost> mutationHosts){
		Future<RpcResult<IpMutateOutput>> status = null;
		for (SpecialMutationHost host : mutationHosts) {
			String rIpSrc = host.hostName;
			String vIpSrc = host.hostName;
			String rIpDst;
			String vIpDst;
			
			for (SpecialMutationHost.Pair pair : host.mutationPair) {
				rIpDst = (String) pair.getDest();
				vIpDst = (String) pair.getMutatedDst();
				
				status = callIpMutation(rIpSrc, vIpSrc, rIpDst, vIpDst);
			}
		}
		
		return status;
	}

	/**
	 * This will create a file containing all mutated flows 
	 * @param mutationHosts
	 * @param fileName
	 * @throws IOException
	 */
	public static void writeFile(List<SpecialMutationHost> mutationHosts,
			String fileName) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(fileName));

		for (SpecialMutationHost host : mutationHosts) {
			pw.write(host.hostName + "-->");
			for (SpecialMutationHost.Pair pair : host.mutationPair) {
				pw.write("(");
				pw.write((String) pair.getDest());
				pw.write(",");
				pw.write((String) pair.getMutatedDst());
				pw.write("),");
			}
			pw.write("\n");
		}

		pw.close();
	}
	
	@Override
	public Future<RpcResult<ReRouteOutput>> reRoute(ReRouteInput input) {
//		MovePathInputBuilder movePathBuilder = new MovePathInputBuilder();
		ReRouteEngineInputBuilder reRouteEngineInputBuilder = new ReRouteEngineInputBuilder();
		try {
			if (input.getDstIpAddress() == null || input.getSrcIpAddress() == null || 
					input.getSwitchesInOldPath() == null || input.getSwitchesInNewPath()== null) {
				String exception = "Incomplete Data is provided and some parameter has null value.";
				throw new Exception(exception);
			}
			else {
				reRouteEngineInputBuilder.setDstIpAddress(new Ipv4Prefix(input.getDstIpAddress()));
				reRouteEngineInputBuilder.setSrcIpAddress(new Ipv4Prefix(input.getSrcIpAddress()));
				List<NodeId> oldNodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInOldPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					oldNodeList.add(nodeId);
				}
				reRouteEngineInputBuilder.setOldPathNodes(oldNodeList);
				
				List<NodeId> newNodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInNewPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					newNodeList.add(nodeId);
				}
				reRouteEngineInputBuilder.setNewPathNodes(newNodeList);
				reRouteEngineInputBuilder.setRemoveOldPath(input.isRemoveOldPath());
				reRouteEngineInputBuilder.setFlowPriority(input.getFlowPriority());
				reRouteEngineInputBuilder.setIdleTimeout(input.getIdleTimeout());
				reRouteEngineInputBuilder.setHardTimeout(input.getHardTimeout());

				Future<RpcResult<ReRouteEngineOutput>> reRouteEngineOutput = tapService.reRouteEngine(reRouteEngineInputBuilder.build());
				if (reRouteEngineOutput != null) {
					ReRouteOutput output = new ReRouteOutputBuilder().
							setStatus(reRouteEngineOutput.get().getResult().getStatus()).build();
					return RpcResultBuilder.success(output).buildFuture();
				}
				else {
					String exception = "Path could not be re routed.";
					throw new Exception(exception);
				}
			}
		} catch (Exception e){
			LOG.error("Exception reached in Re Route RPC {} --------", e);
			return null;
		}
	}
	
	public boolean doPathMutate(String srcIp, String dstIp) {
		
		LOG.debug("		==============---------------=================----------------------");
    	LOG.debug("		Starting Path Mutation ...");
    	LOG.debug("		==============---------------=================----------------------");
		
		ConnectedHostInfo srcHost = activeSdnApp.getHostTable().get(srcIp);
		ConnectedHostInfo dstHost = activeSdnApp.getHostTable().get(dstIp);
		String forwardPathKey = srcHost.getHostIP() + ":" + dstHost.getHostIP();
		String reversePathKey = dstHost.getHostIP() + ":" + srcHost.getHostIP();
		String key = null;	
		
		List<String> oldPath = null;
		
		HashMap<String, List<String>> installedPaths = activeSdnApp.getInstalledPaths();
		
		if (installedPaths.containsKey(forwardPathKey)){
			oldPath = installedPaths.get(forwardPathKey);
			key = forwardPathKey;
		} 
		
		if(installedPaths.containsKey(reversePathKey)) {
			oldPath = installedPaths.get(reversePathKey);
			key = reversePathKey;
		}
		
		if (oldPath == null) {
			LOG.debug("     ==================================================================     ");
			LOG.debug("   Abroting path mutation as because there is no old path found in src {} <--> dst {}", srcIp, dstIp);
			LOG.debug("     ==================================================================     ");
			return false;
		}
		
		LOG.debug("     ==================================================================     ");
		LOG.debug("   	In path mutation oldPath {}", oldPath.toString());
		LOG.debug("     ==================================================================     ");
			
		ReRouteInputBuilder reRouteInputBuilder = new ReRouteInputBuilder();
		reRouteInputBuilder.setSrcIpAddress(srcIp);
		reRouteInputBuilder.setDstIpAddress(dstIp);
		reRouteInputBuilder.setRemoveOldPath(false);
		reRouteInputBuilder.setFlowPriority(pathMutationFlowPriority); // staring value 350
		pathMutationFlowPriority++;
		reRouteInputBuilder.setIdleTimeout(20);	//usually after x seconds of idle time, get rid of this path
		
		List<Integer> oldPathNodes = Lists.newArrayList(); //List of switches along the old path
		for (String node : oldPath){
			oldPathNodes.add(Integer.parseInt(node));
		}
		reRouteInputBuilder.setSwitchesInOldPath(oldPathNodes); //list of switches along the new path
		
		int srcSwitchNumber = srcHost.getSwitchConnectedTo();
		int dstSwitchNumber = dstHost.getSwitchConnectedTo();
		
		List<Integer> newPathNodes = Lists.newArrayList();
		List<String> path = Utility.getDifferntPath(activeSdnApp.getTopology().findAllPaths(srcSwitchNumber, dstSwitchNumber), oldPath);
		
		if (path != null) {
			LOG.debug("     ==================================================================     ");
			LOG.debug("   	In path mutation new Path {}", path.toString());
			LOG.debug("     ==================================================================     ");
			
			for (String node : path){
				newPathNodes.add(Integer.parseInt(node));
			}
			reRouteInputBuilder.setSwitchesInNewPath(newPathNodes);
			LOG.debug("     ==================================================================     ");
			LOG.debug("   	Mutating path form oldPath {} newPath {}", oldPath, path);
			LOG.debug("      ==================================================================     ");
			installedPaths.put(key, path);
			this.reRoute(reRouteInputBuilder.build());
			
			LOG.debug("		==============---------------=================----------------------");
	    	LOG.debug("		Path Mutation ends...");
	    	LOG.debug("		==============---------------=================----------------------");
			
			return true;
		}
		else {
			LOG.debug("     ==================================================================     ");
			LOG.debug("   	Abroting path mutation as because there is no new path found in src {} <--> dst {}", srcIp, dstIp);
			LOG.debug("     ==================================================================     ");
			
			return false;
		}
	}
	
	@Override
	public Future<RpcResult<PathMutateOutput>> pathMutate(PathMutateInput input) {
		LOG.debug("Path Mutation RPC starts with Input: {}", input.toString());
		
		PathMutateOutputBuilder pathMutateOutputBuilder = new PathMutateOutputBuilder();
		PathMutateOutput output;
		String status;

		final String srcIp = input.getSrc().get(0);
    	final String dstIp = input.getDst().get(0);
    	
    	int pattern = input.getPattern();
    	if (pattern == 0) {
    		if (hasTimerStarted) {
				timer.cancel();
				hasTimerStarted = false;
			}
    		doPathMutate(srcIp, dstIp);
    	} else if(pattern == -1) {
    		//stopping any previous call of path mutation
    		timer.cancel();
    		hasTimerStarted = false;
		} else {
			if (!hasTimerStarted) {
				timer.cancel();
			}
    		TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                	doPathMutate(srcIp, dstIp);
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, pattern * 1000);
            hasTimerStarted = true;
    	}
    	
    	LOG.debug("Path Mutation RPC ends.");
    	
    	status = "Path mutation successfull";
		output = pathMutateOutputBuilder.setStatus(status).build();
		return RpcResultBuilder.success(output).buildFuture();

		
//		ConnectedHostInfo srcHost = activeSdnApp.getHostTable().get(srcIp);
//		ConnectedHostInfo dstHost = activeSdnApp.getHostTable().get(dstIp);
//		String forwardPathKey = srcHost.getHostIP() + ":" + dstHost.getHostIP();
//		String reversePathKey = dstHost.getHostIP() + ":" + srcHost.getHostIP();
//		String key = null;	
//		
//		List<String> oldPath = null;
//		
//		HashMap<String, List<String>> installedPaths = activeSdnApp.getInstalledPaths();
//		
//		if (installedPaths.containsKey(forwardPathKey)){
//			oldPath = installedPaths.get(forwardPathKey);
//			key = forwardPathKey;
//		} 
//		
//		if(installedPaths.containsKey(reversePathKey)) {
//			oldPath = installedPaths.get(reversePathKey);
//			key = reversePathKey;
//		}
//		
//		if (oldPath == null) {
//			LOG.debug("     ==================================================================     ");
//			LOG.debug("   Abroting path mutation as because there is no old path found in src {} <--> dst {}", srcIp, dstIp);
//			LOG.debug("     ==================================================================     ");
//			status = "Path mutation failed as there is no current path found";
//			output = pathMutateOutputBuilder.setStatus(status).build();
//			return RpcResultBuilder.success(output).buildFuture();
//		}
//		
//		LOG.debug("     ==================================================================     ");
//		LOG.debug("   	In path mutation oldPath {}", oldPath.toString());
//		LOG.debug("     ==================================================================     ");
//			
//		ReRouteInputBuilder reRouteInputBuilder = new ReRouteInputBuilder();
//		reRouteInputBuilder.setSrcIpAddress(srcIp);
//		reRouteInputBuilder.setDstIpAddress(dstIp);
//		reRouteInputBuilder.setFlowPriority(pathMutationFlowPriority); // staring value 300
//		pathMutationFlowPriority++;
//		reRouteInputBuilder.setHardTimeout(input.getPattern());
//		
//		List<Integer> oldPathNodes = Lists.newArrayList(); //List of switches along the old path
//		for (String node : oldPath){
//			oldPathNodes.add(Integer.parseInt(node));
//		}
//		reRouteInputBuilder.setSwitchesInOldPath(oldPathNodes); //list of switches along the new path
//		
//		int srcSwitchNumber = srcHost.getSwitchConnectedTo();
//		int dstSwitchNumber = dstHost.getSwitchConnectedTo();
//		
//		reRouteInputBuilder.setSwitchesInOldPath(oldPathNodes); //list of switches along the new path
//		
//		List<Integer> newPathNodes = Lists.newArrayList();
//		List<String> path = Utility.getDifferntPath(activeSdnApp.getTopology().findAllPaths(srcSwitchNumber, dstSwitchNumber), oldPath);
//		
//		if (path != null) {
//			LOG.debug("     ==================================================================     ");
//			LOG.debug("   	In path mutation new Path {}", path.toString());
//			LOG.debug("     ==================================================================     ");
//			
//			for (String node : path){
//				newPathNodes.add(Integer.parseInt(node));
//			}
//			reRouteInputBuilder.setSwitchesInNewPath(newPathNodes);
//			LOG.debug("     ==================================================================     ");
//			LOG.debug("   	Mutating path form oldPath {} newPath {}", oldPath, path);
//			LOG.debug("      ==================================================================     ");
//			installedPaths.put(key, path);
//			this.reRoute(reRouteInputBuilder.build());
//			
//			status = "Path mutation successfull";
//			output = pathMutateOutputBuilder.setStatus(status).build();
//			return RpcResultBuilder.success(output).buildFuture();
//		}
//		else {
//			LOG.debug("     ==================================================================     ");
//			LOG.debug("   	Abroting path mutation as because there is no new path found in src {} <--> dst {}", srcIp, dstIp);
//			LOG.debug("     ==================================================================     ");
//			
//			status = "Path mutation failed as there is no new path found";
//			output = pathMutateOutputBuilder.setStatus(status).build();
//			return RpcResultBuilder.success(output).buildFuture();
//		}
	}
	
	
	@Override
	public Future<RpcResult<MigrateNetworkPathOutput>> migrateNetworkPath(
			MigrateNetworkPathInput input) {
		MigratePathInputBuilder migratePathInputBuilder = new MigratePathInputBuilder();
		try {
			if (input.getOldDstIpAddress() == null || input.getNewDstIpAddress() == null || 
					input.getSwitchesInOldPath() == null || input.getSwitchesInNewPath()== null
					|| input.getOldSrcIpAddress() == null) {
				String exception = "Incomplete Data is provided and some parameter has null value.";
				throw new Exception(exception);
			} else {
				migratePathInputBuilder.setOldDstIpAddress(new Ipv4Prefix(input.getOldDstIpAddress()));
				migratePathInputBuilder.setNewDstIpAddress(new Ipv4Prefix(input.getNewDstIpAddress()));
				migratePathInputBuilder.setOldSrcIpAddress(new Ipv4Prefix(input.getOldSrcIpAddress()));
				if (input.getNewSrcIpAddress() != null) {
					migratePathInputBuilder.setNewSrcIpAddress(new Ipv4Prefix(input.getNewSrcIpAddress()));
				}
				
				List<NodeId> oldNodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInOldPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					oldNodeList.add(nodeId);
				}
				migratePathInputBuilder.setOldPathNodes(oldNodeList);
				
				List<NodeId> newNodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInNewPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					newNodeList.add(nodeId);
				}
				migratePathInputBuilder.setNewPathNodes(newNodeList);
				
				migratePathInputBuilder.setFlowPriority(input.getFlowPriority());
				migratePathInputBuilder.setIdleTimeout(input.getIdleTimeout());
				migratePathInputBuilder.setHardTimeout(input.getHardTimeout());

				Future<RpcResult<MigratePathOutput>> migratePathFutureOutput = tapService.migratePath(migratePathInputBuilder.build());
				if (migratePathFutureOutput != null) {
					MigrateNetworkPathOutput output = new MigrateNetworkPathOutputBuilder().
							setStatus(migratePathFutureOutput.get().getResult().getStatus()).build();
					return RpcResultBuilder.success(output).buildFuture();
				}
				else {
					String exception = "Path could not be migrated.";
					throw new Exception(exception);
				}
			}
		} catch (Exception e){
			LOG.error("Exception reached in Migrate Path RPC {} --------", e);
			return null;
		}
	}
	
	
	@Override
	public Future<RpcResult<RemoveAllFlowsFromASwitchOutput>> removeAllFlowsFromASwitch(
			RemoveAllFlowsFromASwitchInput input) {
		RemoveFlowsFromSwitchInputBuilder removeFlowsBuilder = new RemoveFlowsFromSwitchInputBuilder();
		NodeId nodeId = new NodeId("openflow:" + input.getSwitchId().toString());
		try {
			Future<RpcResult<RemoveFlowsFromSwitchOutput>> removeFlowsFutureOutput =
					tapService.removeFlowsFromSwitch(removeFlowsBuilder.build());
			if (removeFlowsFutureOutput != null) {
				RemoveAllFlowsFromASwitchOutput output = new RemoveAllFlowsFromASwitchOutputBuilder().
						setStatus(removeFlowsFutureOutput.get().getResult().getStatus()).build();
				return RpcResultBuilder.success(output).buildFuture();
			}
			else {
				String exception = "Flows couldn't be removed from switch " + input.getSwitchId().toString();
				throw new Exception(exception);
			}
		}catch (Exception e){
			LOG.error("Exception reached in RemoveAllFlowsFromASwitch RPC {} --------", e);
			return null;
		}
	}
	
	@Override
	public Future<RpcResult<GetAllHostsOutput>> getAllHosts() {
		InstanceIdentifier<ConnectedHosts> hostIID = InstanceIdentifier.builder(ConnectedHosts.class).build();
				
		ConnectedHosts hosts = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, hostIID);
		if (hosts != null){
			long hostId = 1;
			GetAllHostsOutputBuilder getHostOutputBuilder = new GetAllHostsOutputBuilder();
			List<HostsInfo> hostList = Lists.newArrayList();
			for (ConnectedHost host: hosts.getConnectedHost()){
				HostsInfoBuilder hostBuilder = new HostsInfoBuilder();
				hostBuilder.setHostIpAddress(host.getHostIpAddress());
				hostBuilder.setHostMacAddress(host.getHostMacAddress());
				hostBuilder.setNodeConnectedTo(host.getNodeConnectedTo());
				hostBuilder.setNodeConnectorConnectedTo(host.getNodeConnectorConnectedTo());
				hostBuilder.setId(hostId++);
				hostList.add(hostBuilder.build());
			}
			getHostOutputBuilder.setHostsInfo(hostList);
			return RpcResultBuilder.success(getHostOutputBuilder.build()).buildFuture();
		}
		return null;
	}
	
	@Override
	public Future<RpcResult<GetAllFlowRulesFromASwitchOutput>> getAllFlowRulesFromASwitch(
			GetAllFlowRulesFromASwitchInput input) {
		NodeId nodeId = new NodeId("openflow:" + input.getSwitchId().toString());
		TableKey tableKey = new TableKey((short)0);
		InstanceIdentifier<Table> tableIID = InstanceIdentifier.builder(Nodes.class)
        		.child(Node.class, new NodeKey(nodeId))
        		.augmentation(FlowCapableNode.class)
        		.child(Table.class, tableKey).build();
		
		Table table = GenericTransactionUtils.readData(this.dataBroker, LogicalDatastoreType.CONFIGURATION, tableIID);
		if (table != null){
			//LOG.debug("Table is not empty");
			if (table.getFlow() != null) {
				int flowCount = 0;
				List<Flow> flows = table.getFlow();
				GetAllFlowRulesFromASwitchOutputBuilder flowRulesOutputBuilder = new GetAllFlowRulesFromASwitchOutputBuilder();
				List<FlowRules> flowRuleList = Lists.newArrayList();
				//LOG.debug("Number of Flow Rules in Node {}", flows.size());
				for (Iterator<Flow> iterator = flows.iterator(); iterator.hasNext();) {
					flowCount++;
					FlowKey flowKey = iterator.next().getKey();
			        InstanceIdentifier<Flow> flowIID = InstanceIdentifier.create(Nodes.class)
			        		.child(Node.class, new NodeKey(nodeId))
			        		.augmentation(FlowCapableNode.class)
			        		.child(Table.class, tableKey)
			        		.child(Flow.class, flowKey);
			        Flow flow = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID);
			        //LOG.debug("Flow is read from Configuration database");
			        if (flow != null){
			        	//LOG.debug("Flow is not null");
			        	FlowRulesBuilder flowBuilder = new FlowRulesBuilder();
			        	////---------Extract Flow properties information
			        	if (flow.getId() != null){
			        		flowBuilder.setFlowId(flow.getId().getValue());
			        		//LOG.debug("FlowID {}", flow.getId().getValue());
			        		if (flow.getId().getValue().equals("0")) continue;
			        	}
			        	flowBuilder.setFlowPriority(flow.getPriority() != null ? flow.getPriority() : 0);
			        	flowBuilder.setIdleTimeout(flow.getIdleTimeout() != null ? flow.getIdleTimeout() : 0);
			        	flowBuilder.setHardTimeout(flow.getHardTimeout() != null ? flow.getHardTimeout() : 0);
			        	flowBuilder.setSwitchId(input.getSwitchId());
			        	//LOG.debug("Setting matching criteria");
			        	///---------------Extract IP and MAC address information
			        	//LOG.debug("Source MAC");
			        	if (flow.getMatch().getEthernetMatch().getEthernetSource() != null){
			        		flowBuilder.setSrcMacAddress(
			        				flow.getMatch().getEthernetMatch().getEthernetSource().getAddress().getValue());
			        		//LOG.debug("Source Mac Address {}", flowBuilder.getSrcMacAddress());
			        	}
			        	//LOG.debug("DST MAC");
			        	if (flow.getMatch().getEthernetMatch().getEthernetDestination() != null){
			        		flowBuilder.setDstMacAddress(
			        				flow.getMatch().getEthernetMatch().getEthernetDestination().getAddress().getValue());
			        		//LOG.debug("Dst Mac Address {}", flowBuilder.getDstMacAddress());
			        	}
			        	//LOG.debug("INPORT");
			        	if (flow.getMatch().getInPort() != null){
			        		flowBuilder.setInPortId((long)Integer.parseInt(flow.getMatch().getInPort().getValue().split(":")[2]));
			        		//LOG.debug("Inport {}", flowBuilder.getInPortId());
			        	}
			        	//LOG.debug("SRC DST IP");
			        	if (flow.getMatch().getLayer3Match() != null){
			        		Ipv4Match ipv4Match = (Ipv4Match) flow.getMatch().getLayer3Match();
			        		if (ipv4Match.getIpv4Source() != null) {
			        			flowBuilder.setSrcIpAddress(ipv4Match.getIpv4Source().getValue());
			        			//LOG.debug("Src IP Address {}", flowBuilder.getSrcIpAddress());
			        		}
			        		if (ipv4Match.getIpv4Destination() != null) {
			        			flowBuilder.setDstIpAddress(ipv4Match.getIpv4Destination().getValue());
			        			//LOG.debug("Dst IP Address {}", flowBuilder.getDstIpAddress());
			        		}
			        	}
			        	//----------Extract Port Information
			        	//LOG.debug("SRC DST Port");
			        	if (flow.getMatch().getLayer4Match() != null) {
			        		TcpMatch tcpMatch = (TcpMatch) flow.getMatch().getLayer4Match();
			        		if (tcpMatch.getTcpDestinationPort() != null) {
			        			flowBuilder.setDstPort(tcpMatch.getTcpDestinationPort().getValue());
			        			//LOG.debug("Dst Port {}", flowBuilder.getDstPort());
			        		}
			        		if (tcpMatch.getTcpSourcePort() != null) {
			        			flowBuilder.setSrcPort(tcpMatch.getTcpSourcePort().getValue());
			        			//LOG.debug("Src Port {}", flowBuilder.getSrcPort());
			        		}
			        	}
			        	///---------------Extract Network Protocol information
			        	//LOG.debug("ICMP HTTP HTTPS");
			        	if (flow.getMatch().getIpMatch().getIpProtocol() != null){
			        		if (flow.getMatch().getIpMatch().getIpProtocol().shortValue() == 1){
			        			flowBuilder.setTypeOfTraffic(TrafficType.ICMP);
			        			//LOG.debug("ICMP Protocol");
			        		}
			        		if (flow.getMatch().getIpMatch().getIpProtocol().shortValue() == 6){
			        			flowBuilder.setTypeOfTraffic(TrafficType.TCP);
			        			//LOG.debug("TCP Protocol");
			        			if (flow.getMatch().getEthernetMatch().getEthernetType() != null) {
					        		if (flow.getMatch().getEthernetMatch().getEthernetType().getType().getValue() == 0x0800){
					        			if (flow.getMatch().getLayer4Match() != null) {
					        				TcpMatch tcpMatch = (TcpMatch) flow.getMatch().getLayer4Match();
					        				if (tcpMatch.getTcpDestinationPort() != null) {
					        					if (tcpMatch.getTcpDestinationPort().getValue() == 80) {
					        						flowBuilder.setTypeOfTraffic(TrafficType.HTTP);
					        						//LOG.debug("HTTP Protocol");
					        					}
					        					if (tcpMatch.getTcpDestinationPort().getValue() == 443) {
					        						flowBuilder.setTypeOfTraffic(TrafficType.HTTPS);
					        						//LOG.debug("HTTPS Protocol");
					        					}
					        				}
					        			}
					        		}
					        	}
			        		}
			        		if (flow.getMatch().getIpMatch().getIpProtocol().shortValue() == 17){
			        			flowBuilder.setTypeOfTraffic(TrafficType.UDP);
			        			//LOG.debug("UDP Protocol");
			        			if (flow.getMatch().getEthernetMatch().getEthernetType() != null) {
					        		if (flow.getMatch().getEthernetMatch().getEthernetType().getType().getValue() == 0x0800){
					        			if (flow.getMatch().getLayer4Match() != null) {
					        				TcpMatch tcpMatch = (TcpMatch) flow.getMatch().getLayer4Match();
					        				if (tcpMatch.getTcpDestinationPort() != null) {
					        					if (tcpMatch.getTcpDestinationPort().getValue() == 53) {
					        						flowBuilder.setTypeOfTraffic(TrafficType.DNS);
					        						//LOG.debug("DNS Protocol");
					        					}
					        					if (tcpMatch.getTcpDestinationPort().getValue() == 67) {
					        						flowBuilder.setTypeOfTraffic(TrafficType.DHCP);
					        						//LOG.debug("DHCP Protocol");
					        					}
					        				}
					        			}
					        		}
					        	}
			        		}
			        		
			        	} 
			        	//---------------Extract ARP Traffic Info ---------------
			        	if (flow.getMatch().getEthernetMatch().getEthernetType() != null) {
			        		if (flow.getMatch().getEthernetMatch().getEthernetType().getType().getValue() == 0x0806){
			        			flowBuilder.setTypeOfTraffic(TrafficType.ARP);
			        			//LOG.debug("ARP Protocol");
			        		}
			        	}
			        	//LOG.debug("Creating Instructions ....");
			        	//----------------------------Extract Action Information ---------------------
			        	Instructions instructions = flow.getInstructions();
			        	for (Instruction instruction : instructions.getInstruction()){
			        		ApplyActionsCase applyActionCase = (ApplyActionsCase) instruction.getInstruction();
			        		ApplyActions applyAction = applyActionCase.getApplyActions();
			        		for (Action action : applyAction.getAction()) {
			        			if (action.getAction() instanceof OutputActionCase) {
			        				OutputActionCase outputCase = (OutputActionCase) action.getAction();
			        				String outputPort = outputCase.getOutputAction().getOutputNodeConnector().getValue().split(":")[2];
			        				flowBuilder.setActionOutputPort(outputPort);
			        				//LOG.debug("Outport Case and port {}", outputPort);
			        			} else if (action.getAction() instanceof DropActionCase){
			        				flowBuilder.setActionOutputPort("0");
			        				//LOG.debug("Drop Action Case");
			        			} else if (action.getAction() instanceof SetNwSrcActionCase) {
			        				SetNwSrcActionCase setNwSrcCase = (SetNwSrcActionCase) action.getAction();
			        				Ipv4 ipv4Address = (Ipv4) setNwSrcCase.getSetNwSrcAction().getAddress();
			        				flowBuilder.setActionSetSourceIpv4Address(ipv4Address.getIpv4Address().getValue());
			        				
			        			} else if (action.getAction() instanceof SetNwDstActionCase) {
			        				SetNwDstActionCase setNwDstCase = (SetNwDstActionCase) action.getAction();
			        				Ipv4 ipv4Address = (Ipv4) setNwDstCase.getSetNwDstAction().getAddress();
			        				flowBuilder.setActionSetDstIpv4Address(ipv4Address.getIpv4Address().getValue());
			        				
			        			} else if (action.getAction() instanceof SetTpSrcActionCase) {
			        				SetTpSrcActionCase setTpCase = (SetTpSrcActionCase) action.getAction();
			        				flowBuilder.setActionSetTcpSrcPort(setTpCase.getSetTpSrcAction().getPort().getValue());
			        				
			        			} else if (action.getAction() instanceof SetTpDstActionCase) {
			        				SetTpDstActionCase setTpCase = (SetTpDstActionCase) action.getAction();
			        				flowBuilder.setActionSetTcpDstPort(setTpCase.getSetTpDstAction().getPort().getValue());
			        				
			        			} else if (action.getAction() instanceof SetNwTosActionCase) {
			        				SetNwTosActionCase setNwTosCase = (SetNwTosActionCase) action.getAction();
			        				flowBuilder.setActionSetIpv4Tos(setNwTosCase.getSetNwTosAction().getTos());
			        				
			        			} else if (action.getAction() instanceof SetNwTtlActionCase) {
			        				SetNwTtlActionCase setNwTtlCase = (SetNwTtlActionCase) action.getAction();
			        				flowBuilder.setActionSetIpv4Ttl(setNwTtlCase.getSetNwTtlAction().getNwTtl());
			        			}
			        		}
			        	}
			        	//LOG.debug("Adding Flow Builder to list");
			        	flowRuleList.add(flowBuilder.build());
			        }///////////////////--------------------End of IF Flow != NULL
				} //...................End of For loop Iterating through Flows
				// ------------ Create output object of the RPC
				//LOG.debug("Generating List");
				flowRulesOutputBuilder.setFlowRules(flowRuleList);
				//LOG.debug("Exiting");
				return RpcResultBuilder.success(flowRulesOutputBuilder.build()).buildFuture();
			} // End of IF No Flows IN Table 0
		} //End of IF There Are no Tables in the Switch
		
		return null;
	}
	
	@Override
	public Future<RpcResult<RemoveAFlowRuleFromSwitchOutput>> removeAFlowRuleFromSwitch(
			RemoveAFlowRuleFromSwitchInput input) {
		RemoveAFlowFromSwitchInputBuilder flowRemoveInputBuilder = new RemoveAFlowFromSwitchInputBuilder();
		flowRemoveInputBuilder.setFlowKey(input.getFlowKey());
		flowRemoveInputBuilder.setTableId((short) 0);
		flowRemoveInputBuilder.setNodeId(new NodeId("openflow:" + Integer.toString(input.getSwitchId())));
		Future<RpcResult<RemoveAFlowFromSwitchOutput>> output = this.tapService.removeAFlowFromSwitch(flowRemoveInputBuilder.build());
		if (output != null) {
			RemoveAFlowRuleFromSwitchOutputBuilder outputBuilder = new RemoveAFlowRuleFromSwitchOutputBuilder();
			outputBuilder.setStatus("Flow with ID " + input.getFlowKey() + " is successfully removed from Switch " + Integer.toString(input.getSwitchId()));
			return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
		}
		return null;
	}
	
	@Override
	public Future<RpcResult<RemoveEventFromSwitchOutput>> removeEventFromSwitch(
			RemoveEventFromSwitchInput input) {
		RemoveATapFromSwitchInputBuilder removeTapInputBuilder = new RemoveATapFromSwitchInputBuilder();
		removeTapInputBuilder.setNode(new NodeId("openflow:" + input.getSwitchId()));
		removeTapInputBuilder.setTapId(input.getEventId());
		Future<RpcResult<RemoveATapFromSwitchOutput>> output = this.tapService.removeATapFromSwitch(removeTapInputBuilder.build());
		if (output != null) {
			RemoveEventFromSwitchOutputBuilder outputBuilder = new RemoveEventFromSwitchOutputBuilder();
			outputBuilder.setStatus("Event with ID" + input.getEventId() + " From switch " + Integer.toString(input.getSwitchId()));
			return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
		}
		return null;
	}
	
	@Override
	public Future<RpcResult<SendPacketOutOutput>> sendPacketOut(
			SendPacketOutInput input) {
		NodeId nodeId = new NodeId("openflow:" + Integer.toString(input.getSwitchId()));
		NodeRef ingressNodeRef = InventoryUtils.getNodeRef(nodeId);

		NodeConnectorId ingressPortId;
		if (input.getInPortNumber() == -1) {
			ingressPortId = InventoryUtils.getNodeConnectorId(nodeId, CONTROLLER_PORT_NUMBER);
		}
		else {
			ingressPortId = new NodeConnectorId(nodeId.getValue() + 
					":" + Integer.toString((int)input.getInPortNumber()));
		}
		NodeConnectorRef ingressPortRef = InventoryUtils.getNodeConnectorRef(ingressPortId);
		
		NodeConnectorId egressPortId;
		NodeConnectorRef egressPortRef;
		if (input.getOutputPort() == FLOOD){
			egressPortId = InventoryUtils.getNodeConnectorId(nodeId, FLOOD_PORT_NUMBER);
			egressPortRef = InventoryUtils.getNodeConnectorRef(egressPortId);
		}
		else if (input.getOutputPort() == CONTROLLER) {
			egressPortId = InventoryUtils.getNodeConnectorId(nodeId, CONTROLLER_PORT_NUMBER);
			egressPortRef = InventoryUtils.getNodeConnectorRef(egressPortId);
		} 
		else if (input.getOutputPort() == TABLE){
			egressPortId = InventoryUtils.getNodeConnectorId(nodeId, TABLE_PORT_NUMBER);
			egressPortRef = InventoryUtils.getNodeConnectorRef(egressPortId);
		}
		else {
			egressPortId = new NodeConnectorId(nodeId.getValue() + 
					":" + input.getOutputPort());
			egressPortRef = InventoryUtils.getNodeConnectorRef(egressPortId);
		}
		if (input.getOutputPort() == DROP) {
			return null;
		}
		TransmitPacketInputBuilder inputbuilder = new TransmitPacketInputBuilder();
        inputbuilder.setPayload(input.getPayload());
        inputbuilder.setNode(ingressNodeRef);
        inputbuilder.setEgress(egressPortRef);
        inputbuilder.setIngress(ingressPortRef);
         
        packetProcessingService.transmitPacket(inputbuilder.build());
        SendPacketOutOutputBuilder outputBuilder = new SendPacketOutOutputBuilder();
        outputBuilder.setStatus("Packet out is sent.");
       
		return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
		
		//Handle the Drop Port Case explicitly not just by ignoring.
	}

	@Override
	public Future<RpcResult<InstallPathSegmentOutput>> installPathSegment(
			InstallPathSegmentInput input) {
		InstallPathBwNodesInputBuilder installPathBuilder = new InstallPathBwNodesInputBuilder();
		try {
			if (input.getDstIpAddress() != null){
				installPathBuilder.setDstIpAddress(new Ipv4Prefix(input.getDstIpAddress()));
			}
			else {
				String exception = "No Destination IP is provided.";
				throw new Exception(exception);
			}
			if (input.getSrcIpAddress() != null) {
				installPathBuilder.setSrcIpAddress(new Ipv4Prefix(input.getSrcIpAddress()));
			}
			else {
				String exception = "No Source IP is provided.";
				throw new Exception(exception);
			}
			if (input.getSwitchesInPath()!= null){
				List<NodeId> nodeList = Lists.newArrayList();
				for (int node: input.getSwitchesInPath()){
					NodeId nodeId = new NodeId("openflow:" + Integer.toString(node));
					nodeList.add(nodeId);
				}
				installPathBuilder.setPathNodes(nodeList);
			}
			else {
				String exception = "No Path is provided.";
				throw new Exception(exception);
			}
			//if (input.getTypeOfTraffic() != null){
			//	installPathBuilder.setTrafficMatch(input.getTypeOfTraffic());
			//}
			//else {
			//	installPathBuilder.setTrafficMatch(TrafficType.TCP);
			//}
			installPathBuilder.setFlowPriority(input.getFlowPriority());
			installPathBuilder.setIdleTimeout(input.getIdleTimeout());
			installPathBuilder.setHardTimeout(input.getHardTimeout());
			///-------------------------------
			Future<RpcResult<InstallPathBwNodesOutput>> pathFutureOutput =  
			tapService.installPathBwNodes(installPathBuilder.build());
			if (pathFutureOutput != null) {
				InstallPathSegmentOutput output = new InstallPathSegmentOutputBuilder().
						setStatus(pathFutureOutput.get().getResult().getStatus()).build();
				return RpcResultBuilder.success(output).buildFuture();
			}
			else {
				String exception = "No Path could be installed.";
				throw new Exception(exception);
			}
		} catch (Exception e){
			LOG.error("Exception reached in InstallNetworkPath RPC {} --------", e);
			return null;
		}
	}
	////////////////////////////-------------------------------/////////////////////////////////
	//////----------------------Events generated---------------------------------------/////////
	////////////////////////////---------------------------------///////////////////////////////
	
	
	private List<Node> getNodes() {
		
		InstanceIdentifier<Nodes> nodesIID = InstanceIdentifier.create(Nodes.class);
		Nodes nodes = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, nodesIID);
		if (nodes == null) {
			throw new RuntimeException("nodes are not found, pls add the node.");
			
		}
		
		return nodes.getNode();
	
	  //ReadOnlyTransaction readOnlyTransaction = dataProviderService.newReadOnlyTransaction();
	  //Nodes nodes = TestProviderTransactionUtil.getDataObject(readOnlyTransaction,nodesID)
		 
	}
	
	@Override
	public Future<RpcResult<GetFlowStatisticsOutput>> getFlowStatistics(GetFlowStatisticsInput input) {
		//LOG.debug("--------Fetching Flow Statistics for Switch {}------", input.getSwitchId());
		int flowCount = 0;
		int flowStatsCount = 0;
		NodeId nodeId = new NodeId("openflow:" + input.getSwitchId().toString());
	
		//List<Node> nodes = getNodes();
		//for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
		List<FlowStatistic> flowStats = Lists.newArrayList();
		
		if (nodeId != null){
			//NodeKey nodeKey = iterator.next().getKey();
			NodeKey nodeKey = new NodeKey(nodeId);
			//LOG.debug("========================================================");
			//LOG.debug("---------------NodeID {} ------", nodeKey.getId().getValue());
			InstanceIdentifier<FlowCapableNode> nodeRef = InstanceIdentifier
					.create(Nodes.class).child(Node.class, nodeKey)
					.augmentation(FlowCapableNode.class);
			FlowCapableNode node = GenericTransactionUtils.readData(dataBroker, 
				   LogicalDatastoreType.CONFIGURATION, nodeRef);

			if (node != null) {
				List<Table> tables = node.getTable();
				for (Iterator<Table> iterator2 = tables.iterator(); iterator2.hasNext();) {
					TableKey tableKey = iterator2.next().getKey();
					InstanceIdentifier<Table> tableRef = InstanceIdentifier
							.create(Nodes.class).child(Node.class, nodeKey)
							.augmentation(FlowCapableNode.class).child(Table.class, tableKey);
					Table table = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, tableRef); 
					if (table != null) {
						//LOG.debug(" ");
						//LOG.debug("--Reading from the table TableID {} ------", tableKey.getId());
						if (table.getFlow() != null) {
							//LOG.debug("-----Found Flows in the table and now reading flow");
							List<Flow> flows = table.getFlow();
							for (Iterator<Flow> iterator3 = flows.iterator(); iterator3.hasNext();) {
								//LOG.debug(" ");
								flowCount++;
								Flow fl = iterator3.next();
								//FlowKey flowKey = iterator3.next().getKey();
								FlowKey flowKey = fl.getKey();
								//FlowCookie flCookie = fl.getCookie();
								FlowId flowId = fl.getId();
								//LOG.debug("--FlowID {}, FlowKey {} ------", flowId.getValue()
								//		, flowKey.getId().getValue());
								InstanceIdentifier<Flow> flowRef = InstanceIdentifier
										.create(Nodes.class).child(Node.class, nodeKey)
										.augmentation(FlowCapableNode.class)
										.child(Table.class, tableKey)
										.child(Flow.class, flowKey);
								Flow flow = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, flowRef); 
								if (flow != null) {
						        	//------------------------------
									FlowStatisticsData data = flow
											.getAugmentation(FlowStatisticsData.class);
									//LOG.debug(" ");
									//LOG.debug("---------------Reading statistics for Flow ID {}", flow.getId().getValue());
									if (null != data) {
										flowStatsCount++;
										//LOG.debug("--------------------------------------------");
										//LOG.debug("Byte Count {}, Packet Count {}", 
										//		data.getFlowStatistics().getByteCount().getValue().toString()
										//		,data.getFlowStatistics().getPacketCount().getValue().toString());
										//LOG.debug("---------------------------------------------");
										FlowStatisticBuilder flowStatsBuilder = new FlowStatisticBuilder();
										//LOG.debug("----------FlowKey {} ", flowKey.getId().getValue());
										flowStatsBuilder.setFlowId(flowKey.getId().getValue());
										flowStatsBuilder.setPacketCount(data.getFlowStatistics().getPacketCount().getValue());
										flowStatsBuilder.setByteCount(data.getFlowStatistics().getByteCount().getValue());
										flowStatsBuilder.setDuration(data.getFlowStatistics().getDuration().getSecond().getValue());
										///====================================
										if (flow.getMatch().getLayer3Match() != null){
											//LOG.debug("Fetching Layer3 header");
							        		Ipv4Match ipv4Match = (Ipv4Match) flow.getMatch().getLayer3Match();
							        		if (ipv4Match.getIpv4Source() != null) {
							        			//LOG.debug("Source IP address --- {}", ipv4Match.getIpv4Source().getValue());
							        			flowStatsBuilder.setSrcIpAddress(ipv4Match.getIpv4Source().getValue());
							        		}
							        		if (ipv4Match.getIpv4Destination() != null) {
							        			//LOG.debug("Destination IP address --- {}", ipv4Match.getIpv4Destination().getValue());
							        			flowStatsBuilder.setDstIpAddress(ipv4Match.getIpv4Destination().getValue());
							        		}
							        	}
										//----------Extract Port Information
							        	if (flow.getMatch().getLayer4Match() != null) {
							        		//LOG.debug("Fetching Layer4Match");
							        		TcpMatch tcpMatch = (TcpMatch) flow.getMatch().getLayer4Match();
							        		if (tcpMatch.getTcpDestinationPort() != null) {
							        			//LOG.debug("TCP Destination port -- {}", tcpMatch.getTcpDestinationPort().getValue());
							        			flowStatsBuilder.setDstPort(tcpMatch.getTcpDestinationPort().getValue());
							        		}
							        		if (tcpMatch.getTcpSourcePort() != null) {
							        			//LOG.debug("TCP Source port -- {}", tcpMatch.getTcpSourcePort().getValue());
							        			flowStatsBuilder.setSrcPort(tcpMatch.getTcpSourcePort().getValue());
							        		}
							        	}
							        	///---------------Extract Network Protocol information
							        	//LOG.debug("Checking IP Protocol");
							        	if (flow.getMatch().getIpMatch() != null){
							        		//LOG.debug("Protocol Number");
							        		if (flow.getMatch().getIpMatch().getIpProtocol() != null){
							        			//LOG.debug("IP Protocol Number {} ", flow.getMatch().getIpMatch().getIpProtocol().shortValue());
							        			if (flow.getMatch().getIpMatch().getIpProtocol().shortValue() == 1){
								        			//LOG.debug("ICMP Protocol.");
								        			flowStatsBuilder.setTypeOfTraffic(TrafficType.ICMP);
								        		}
								        		if (flow.getMatch().getIpMatch().getIpProtocol().shortValue() == 6){
								        			//LOG.debug("TCP Protocol");
								        			flowStatsBuilder.setTypeOfTraffic(TrafficType.TCP);
								        		}
								        		if (flow.getMatch().getIpMatch().getIpProtocol().shortValue() == 17){
								        			//LOG.debug("UDP Protocol");
								        			flowStatsBuilder.setTypeOfTraffic(TrafficType.UDP);
								        		}	
							        		}						        		
							        	} 
										///====================================
										
										flowStats.add(flowStatsBuilder.build());
										//ci.print(data);
									}
								}
							}
						}
					}
				}
		   	}
		}

		//if (flowCount == flowStatsCount) {
		if (flowStatsCount > 0) {
			//LOG.debug("flowStats - Success");
			GetFlowStatisticsOutputBuilder outputBuilder = new GetFlowStatisticsOutputBuilder();
			outputBuilder.setStatus("FlowStats is a success");
			outputBuilder.setSwitchId(input.getSwitchId());
			outputBuilder.setFlowStatistic(flowStats);
			return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
		} else {
			//LOG.debug("flowStats - Failed");
			GetFlowStatisticsOutputBuilder outputBuilder = new GetFlowStatisticsOutputBuilder();
			outputBuilder.setStatus("FlowStats is a success");
			outputBuilder.setSwitchId(input.getSwitchId());
			outputBuilder.setFlowStatistic(null);
			//LOG
			//.debug("System fetchs stats data in 50 seconds interval, so pls wait and try again.");
			return RpcResultBuilder.success(outputBuilder.build()).buildFuture();	
		}
	}
	
	@Override
	public void onAggregateFlowStatisticsUpdate(
			AggregateFlowStatisticsUpdate notification) {
		
//		LOG.debug("onAggregateFlowStatisticUpdate Called");
		
		List<SwitchStatistics> switchStats = Lists.newArrayList();

		if (listOfSwitchesForStats.isEmpty()){
			LOG.debug("There are no subscribed switches available for statistic collection");
			return;
		}
		
		LOG.debug("onAggregateFlowStatisticUpdate Called");
		
		for (Iterator<Integer> swItr = listOfSwitchesForStats.iterator(); swItr.hasNext();){
			int switchId = swItr.next();
			LOG.debug(" ");
			
			try {
				Future<RpcResult<GetFlowStatisticsOutput>> futureOutput = 
						this.getFlowStatistics(new GetFlowStatisticsInputBuilder().setSwitchId(switchId).build());
				if (futureOutput != null){
					GetFlowStatisticsOutput flowStatsOutput = futureOutput.get().getResult();
					if (flowStatsOutput.getFlowStatistic() == null) {
						LOG.debug("Stats are not available for Switch {}", switchId);
						SwitchStatisticsBuilder switchStatsBuilder = new SwitchStatisticsBuilder();
						switchStatsBuilder.setSwitchId(switchId);
						switchStatsBuilder.setFlowStatistic(null);
						switchStats.add(switchStatsBuilder.build());
					}
					else {
						LOG.debug("Collecting stats for SwitchID {}", switchId);
						SwitchStatisticsBuilder switchStatsBuilder = new SwitchStatisticsBuilder();
						switchStatsBuilder.setSwitchId(switchId);
						switchStatsBuilder.setFlowStatistic(flowStatsOutput.getFlowStatistic());
						switchStats.add(switchStatsBuilder.build());
					}
				}
			} catch (Exception e) {
				LOG.error("Exception reached in Fetching Switch Statistics {} --------", e);
			}
		}
		if (switchStats.isEmpty() == false) {
			FlowStatisticReceivedBuilder flowStatsReceivedBuilder = new FlowStatisticReceivedBuilder();
			flowStatsReceivedBuilder.setSwitchStatistics(switchStats);
    		this.notificationService.publish(flowStatsReceivedBuilder.build());
    		//this.activeSDNAssignment.onConstructTopology(topologyBuilder.build());
		}
		else {
			LOG.debug("There are no stats available for subscribed switches.");
		}
		//int switchId = Integer.parseInt(notification.getId().getValue().split(":")[1]);
	}

	@Override
	public void onFlowsStatisticsUpdate(FlowsStatisticsUpdate notification) {	

//		LOG.debug("onFlowStatisticUpdate Called");
		
		long timeMillis = System.currentTimeMillis();
		long seconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
		if (firstTime == true){
			previousTime = startTime = seconds;
			firstTime = false;
		}
		else if (seconds - previousTime < reportingTime){
			return;
		}

		previousTime = seconds;
		List<SwitchStatistics> switchStats = Lists.newArrayList();

		if (listOfSwitchesForStats.isEmpty()){
//			LOG.debug("There are no subscribed switches and links available for statistic collection");
			return;
		}
		
		LOG.debug("onFlowStatisticUpdate Called");
		LOG.debug("Fetching statistics from the subscribed switches and links in the network...");
		
		for (Iterator<Integer> swItr = listOfSwitchesForStats.iterator(); swItr.hasNext();){
			int switchId = swItr.next();
			try {
				Future<RpcResult<GetFlowStatisticsOutput>> futureOutput = 
						this.getFlowStatistics(new GetFlowStatisticsInputBuilder().setSwitchId(switchId).build());
				if (futureOutput != null){
					GetFlowStatisticsOutput flowStatsOutput = futureOutput.get().getResult();
					if (flowStatsOutput.getFlowStatistic() == null) {
						//LOG.debug("Stats are not available for Switch {}", switchId);
						SwitchStatisticsBuilder switchStatsBuilder = new SwitchStatisticsBuilder();
						switchStatsBuilder.setSwitchId(switchId);
						switchStatsBuilder.setFlowStatistic(null);
						switchStats.add(switchStatsBuilder.build());
					}
					else {
						//LOG.debug("Collecting stats for SwitchID {}", switchId);
						SwitchStatisticsBuilder switchStatsBuilder = new SwitchStatisticsBuilder();
						switchStatsBuilder.setSwitchId(switchId);
						switchStatsBuilder.setFlowStatistic(flowStatsOutput.getFlowStatistic());
						switchStats.add(switchStatsBuilder.build());
					}
				}
			} catch (Exception e) {
				LOG.error("Exception reached in Fetching Switch Statistics {} --------", e);
			}
		}
		if (switchStats.isEmpty() == false) {
			FlowStatisticReceivedBuilder flowStatsReceivedBuilder = new FlowStatisticReceivedBuilder();
			flowStatsReceivedBuilder.setSwitchStatistics(switchStats);
			flowStatsReceivedBuilder.setStatsTime(seconds);
    		this.notificationService.publish(flowStatsReceivedBuilder.build());
    		//this.activeSDNAssignment.onConstructTopology(topologyBuilder.build());
		}
		else {
			LOG.debug("There are no stats available for subscribed switches.");
		}
		//int switchId = Integer.parseInt(notification.getId().getValue().split(":")[1]);
		
		//int switchId = Integer.parseInt(notification.getId().getValue().split(":")[1]);
		//this.getFlowStatistics(new GetFlowStatisticsInputBuilder().setSwitchId(switchId).build());
		/*
		List<FlowAndStatisticsMapList> flowStatMapList = Lists.newArrayList();
			flowStatMapList = notification.getFlowAndStatisticsMapList();
		if (flowStatMapList != null){
			int count = 0;
			for (Iterator<FlowAndStatisticsMapList> mapIterator = flowStatMapList.iterator(); 
					mapIterator.hasNext();){
				FlowAndStatisticsMapList map = mapIterator.next();
				if (map.getFlowId() != null) {
					LOG.debug(".........");
					LOG.debug("FlowId   {}", map.getFlowId().getValue());
					LOG.debug("Flow Byte Count  {}", map.getByteCount().getValue());
					LOG.debug("Flow Packet Count {}", map.getPacketCount().getValue());
				}
				else {
					LOG.debug("No flows are available {}", ++count);
				}
			}
		}
		else {
			LOG.debug("Currently there are no statistics available");
		}
		*/
		
	}

	@Override
	public Future<RpcResult<UnsubscribeForStatsFromSwitchOutput>> unsubscribeForStatsFromSwitch(
			UnsubscribeForStatsFromSwitchInput input) {
		
		LOG.debug("unsubscribeForStatsFromSwitch Called");
		
		if (listOfSwitchesForStats.contains(input.getSwitchId())){
			listOfSwitchesForStats.remove(input.getSwitchId());
			LOG.debug("Switch ID {} is un-subscribed and no statistic will be collected for it.", input.getSwitchId());
		}
		else {
			LOG.debug("Switch ID {} is not already subscribed for stat collection.", input.getSwitchId());
		}
		UnsubscribeForStatsFromSwitchOutputBuilder outputBuilder = new UnsubscribeForStatsFromSwitchOutputBuilder();
		outputBuilder.setStatus("UnSubscribing was successful");
		return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
	}
	
	@Override
	public Future<RpcResult<SubscribeForStatsFromSwitchOutput>> subscribeForStatsFromSwitch(
			SubscribeForStatsFromSwitchInput input) {
		
		LOG.debug("subscribeForStatsFromSwitch Called");
		
		List<Integer> switchIDs = input.getSwitchIds();
		
		for (Integer switchID : switchIDs) {
			if (listOfSwitchesForStats.contains(switchID)){
				LOG.debug("Switch ID {} is already subscribed.", switchID);
			}
			else {
				listOfSwitchesForStats.add(switchID);
				LOG.debug("Switch ID {} is subscribed for statistic collection", switchID);
			}
		}
		
		
		//LOG.debug("returning control");
		SubscribeForStatsFromSwitchOutputBuilder outputBuilder = new SubscribeForStatsFromSwitchOutputBuilder();
		outputBuilder.setStatus("Subscribing was successful");
		return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
	}
	
	@Override
	public void onNodeConnectorStatisticsUpdate(
			NodeConnectorStatisticsUpdate notification) {

		//if (skip == true) return;
		for (Iterator<NodeConnectorStatisticsAndPortNumberMap> portStatItr = 
				notification.getNodeConnectorStatisticsAndPortNumberMap().iterator(); 
				portStatItr.hasNext();){
			NodeConnectorStatisticsAndPortNumberMap portStats = portStatItr.next();
			if (portStats.getReceiveDrops().intValue() > 0 || portStats.getTransmitDrops().intValue() > 0
					|| portStats.getReceiveErrors().intValue() > 0 || portStats.getTransmitErrors().intValue() > 0){
				LOG.debug("NodeConnectorID {}", portStats.getNodeConnectorId().getValue());
				LOG.debug("PacketReceiveDrops {}", portStats.getReceiveDrops());
				LOG.debug("PacketTransmitDrops {}", portStats.getTransmitDrops());
				LOG.debug("Packets Received {}", portStats.getPackets().getReceived());
				LOG.debug("Packets Transmitted {}", portStats.getPackets().getTransmitted());
				LOG.debug("Packets Transmit Errors {}", portStats.getTransmitErrors());
				LOG.debug("Packets Receive Errors {}", portStats.getReceiveErrors());
				LOG.debug("-----------------------------------------------");
			}
		}
		long timeMillis = System.currentTimeMillis();
		long seconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
		if (portFirstTime == true){
			portPreviousTime = portStartTime = seconds;
			//listOfSwitchPortsForStats.put("openflow:1:1", 10);
			portFirstTime = false;
		}
		else if (seconds - portPreviousTime < portReportingTime){
			return;
		}
		//LOG.debug("--------------------------onPortStatisticUpdate Called -----------------");
		//LOG.debug(" ");
		portPreviousTime = seconds;
		//List<SwitchStatistics> switchStats = Lists.newArrayList();

		if (listOfSwitchPortsForStats.isEmpty()){
			//LOG.debug("There are no ports (links) subscribed for flood checking.");
			return;
		}
		delayedNotification += 1;
		IsLinkFloodedBuilder linkFlooded = new IsLinkFloodedBuilder();
		List<FloodedLinks> listOfFloodedLinks = Lists.newArrayList(); 

		for (String portId : listOfSwitchPortsForStats.keySet()){
			int switchId = Integer.parseInt(portId.split(":")[1]);
			int connectorId = Integer.parseInt(portId.split(":")[2]);
			GetPortStatisticsInputBuilder portStatsInputBuilder = new GetPortStatisticsInputBuilder();
			portStatsInputBuilder.setConnectorId(connectorId);
			portStatsInputBuilder.setSwitchId(switchId);
			try {
				Future<RpcResult<GetPortStatisticsOutput>> futureOutput = 
						getPortStatistics(portStatsInputBuilder.build());
				if (futureOutput != null){
					GetPortStatisticsOutput portStatsOutput = futureOutput.get().getResult();
					if (portStatsOutput != null){
						FloodedLinksBuilder floodedLinkBuilder = new FloodedLinksBuilder();
						//--------For the time being there is only one link and we assume that is flooded
//						floodedLinkBuilder.setLinkId(portId);
//						floodedLinkBuilder.setPacketDropObserved((long)5);
//						listOfFloodedLinks.add(floodedLinkBuilder.build());
						//--------------------------------------------
						if (portStatsOutput.getReceiveDrops() > 0){
							LOG.debug("");
							LOG.debug("GetReceivedDrops = {} ", portStatsOutput.getReceiveDrops());
							floodedLinkBuilder.setLinkId(portId);
							floodedLinkBuilder.setPacketDropObserved(portStatsOutput.getReceiveDrops() - observedReceiveDrops);
							listOfFloodedLinks.add(floodedLinkBuilder.build());
							observedReceiveDrops = portStatsOutput.getReceiveDrops();
							LOG.debug("------------------------------------------------------------------");
							LOG.debug("Packet Received Dropped {0} on Switch {1} and Port {2}",floodedLinkBuilder.getPacketDropObserved(), switchId, portId);
							LOG.debug("------------------------------------------------------------------");
						} else if (portStatsOutput.getTransmitDrops() > 0){
							LOG.debug("");
							LOG.debug("GetTransmitDrops = {} ", portStatsOutput.getTransmitDrops());
							floodedLinkBuilder.setLinkId(portId);
							floodedLinkBuilder.setPacketDropObserved(portStatsOutput.getTransmitDrops() - observedTransmitDrops);
							listOfFloodedLinks.add(floodedLinkBuilder.build());
							observedTransmitDrops = portStatsOutput.getTransmitDrops();
							LOG.debug("------------------------------------------------------------------");
							LOG.debug("Packet Transmit Dropped {0} on Switch {1} and Port {2}",floodedLinkBuilder.getPacketDropObserved(), switchId, portId);
							LOG.debug("------------------------------------------------------------------");
						} else if (portStatsOutput.getTotalTransmitted() > 0){
							//LOG.debug("GetTotalTransmitted = {} ", portStatsOutput.getTotalTransmitted());							
						} else if (portStatsOutput.getTotalReceived() > 0){
							//LOG.debug("GetTotalReceived = {} ", portStatsOutput.getTotalReceived());							
						}
						
					}
				}
			} catch (Exception e){
				LOG.debug("Exception Reached {}", e);
			}
		}
		//if (delayedNotification > 0) {
		if (listOfFloodedLinks.isEmpty() == false){
			linkFlooded.setFloodedLinks(listOfFloodedLinks);
			this.notificationService.publish(linkFlooded.build());
		}
		//}
	}

	@Override
	public Future<RpcResult<SubscribeForLinkFloodingCheckOutput>> subscribeForLinkFloodingCheck(
			SubscribeForLinkFloodingCheckInput input) {
		String nodeConnector = "openflow:" + input.getSwitchId().toString() 
				+ ":" + input.getConnectorId().toString();
		if (listOfSwitchPortsForStats.containsKey(nodeConnector)){
			LOG.debug("Port ID {} of Switch {} is already subscribed.", input.getConnectorId(), input.getSwitchId());
		}
		else {
			listOfSwitchPortsForStats.put(nodeConnector, input.getDropThreshold());
			LOG.debug("Port ID {} of Switch {} is subscribed for statistics.", input.getConnectorId(), input.getSwitchId());			
		}
		SubscribeForLinkFloodingCheckOutputBuilder outputBuilder = new SubscribeForLinkFloodingCheckOutputBuilder();
		outputBuilder.setStatus("Subscribing port statistics was successful");
		return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
	}

	@Override
	public Future<RpcResult<UnsubscribeForLinkFloodingCheckOutput>> unsubscribeForLinkFloodingCheck(
			UnsubscribeForLinkFloodingCheckInput input) {
		String nodeConnector = "openflow:" + input.getSwitchId().toString() 
				+ ":" + input.getConnectorId().toString();
		if (listOfSwitchPortsForStats.containsKey(nodeConnector)){
			listOfSwitchPortsForStats.remove(nodeConnector);
			LOG.debug("Port ID {} of Switch {} is removed from subscription.", input.getConnectorId(), input.getSwitchId());
		}
		else {
			LOG.debug("Port ID {} of Switch {} is not subscribed for statistics.", input.getConnectorId(), input.getSwitchId());			
		}
		UnsubscribeForLinkFloodingCheckOutputBuilder outputBuilder = new UnsubscribeForLinkFloodingCheckOutputBuilder();
		outputBuilder.setStatus("Unsubscribing port statistics was successful");
		return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
	}

	@Override
	public Future<RpcResult<GetPortStatisticsOutput>> getPortStatistics(
			GetPortStatisticsInput input) {
		//LOG.debug("");
		//LOG.debug("Fetching Port Statistics for Switch {} and Port {}", input.getSwitchId(), input.getConnectorId());
		int nodeConnectorCount = 0;
		int nodeConnectorStatsCount = 0;
		NodeId nodeId = new NodeId("openflow:" + input.getSwitchId().toString());
		String portId = nodeId.getValue() + ":" + input.getConnectorId().toString();
		NodeConnectorId nodeConnectorId = new NodeConnectorId(portId);
		NodeConnectorKey portKey = new NodeConnectorKey(nodeConnectorId); 
		//for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
		if (nodeId != null){
			NodeKey nodeKey =  new NodeKey(nodeId);
			InstanceIdentifier<Node> nodeRef = InstanceIdentifier.create(Nodes.class)
					.child(Node.class, nodeKey);
			Node node = GenericTransactionUtils.readData(dataBroker, 
					LogicalDatastoreType.OPERATIONAL, nodeRef);
			if (node != null) {
				if (node.getNodeConnector() != null) {
					List<NodeConnector> ports = node.getNodeConnector();
					//FlowCapableNodeConnectorQueueStatistics queueData = ports.get(0).getAugmentation(FlowCapableNodeConnectorQueueStatistics.class);
					for (Iterator<NodeConnector> iterator2 = ports.iterator(); 
							iterator2.hasNext();) {
						nodeConnectorCount++;
						NodeConnectorKey nodeConnectorKey = iterator2.next().getKey();
						//if (nodeConnectorKey.getId().getValue() != portId) {continue;}
						if (nodeConnectorKey.equals(portKey) == false) {continue;}
						InstanceIdentifier<NodeConnector> connectorRef = InstanceIdentifier
								.create(Nodes.class).child(Node.class, nodeKey)
								.child(NodeConnector.class, nodeConnectorKey);
						NodeConnector nodeConnector = GenericTransactionUtils.readData(dataBroker, 
								LogicalDatastoreType.OPERATIONAL, connectorRef);
						if (nodeConnector != null) {
							FlowCapableNodeConnectorStatisticsData data = nodeConnector
									.getAugmentation(FlowCapableNodeConnectorStatisticsData.class);
							//FlowCapableNodeConnectorQueueStatistics queueData = nodeConnector.getAugmentation(FlowCapableNodeConnectorQueueStatistics.class);
							
							
							if (null != data) {
								nodeConnectorStatsCount++;
								//LOG.debug("ReceivedDrops {}", data.getFlowCapableNodeConnectorStatistics().getReceiveDrops());
								//LOG.debug("TransmitDrops {}", data.getFlowCapableNodeConnectorStatistics().getTransmitDrops());
								//LOG.debug("Packets {}", data.getFlowCapableNodeConnectorStatistics().getPackets());
								
								GetPortStatisticsOutputBuilder output = new GetPortStatisticsOutputBuilder();
								output.setTotalReceived(data.getFlowCapableNodeConnectorStatistics().getPackets().getReceived().longValue());
								output.setTotalTransmitted(data.getFlowCapableNodeConnectorStatistics().getPackets().getTransmitted().longValue());
								output.setTransmitDrops(data.getFlowCapableNodeConnectorStatistics().getTransmitDrops().longValue());
								output.setReceiveDrops(data.getFlowCapableNodeConnectorStatistics().getReceiveDrops().longValue());
								return RpcResultBuilder.success(output.build()).buildFuture();
							}
						}
					}
				}
			}
		}
		GetPortStatisticsOutput output = null;
		return RpcResultBuilder.success(output).buildFuture();
	}

	@Override
	public void onQueueStatisticsUpdate(QueueStatisticsUpdate notification) {
		//LOG.debug("Queue Statistics is called -----------");
		long timeMillis = System.currentTimeMillis();
		long seconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
		if (queueFirstTime == true){
			queuePreviousTime = queueStartTime = seconds;
			//listOfSwitchPortsForStats.put("openflow:1:1", 10);
			queueFirstTime = false;
		}
		else if (seconds - queuePreviousTime < queueReportingTime){
			return;
		}
		//LOG.debug("--------------------------onPortStatisticUpdate Called -----------------");
		//LOG.debug(" ");
		queuePreviousTime = seconds;
		//List<SwitchStatistics> switchStats = Lists.newArrayList();
	
		if (listOfSwitchPortsForStats.isEmpty()){
			//LOG.debug("There are no ports (Queues)  ------ subscribed.");
			return;
		}
		IsLinkFloodedBuilder linkFlooded = new IsLinkFloodedBuilder();
		List<FloodedLinks> listOfFloodedLinks = Lists.newArrayList();
		
		for (String portId : listOfSwitchPortsForStats.keySet()){
			NodeConnectorId nodeConnectorId = new NodeConnectorId(portId);
			NodeId nodeId = InventoryUtils.getNodeId(nodeConnectorId);
			int switchId = Integer.parseInt(portId.split(":")[1]);
			int connectorId = Integer.parseInt(portId.split(":")[2]);
			
			InstanceIdentifier<FlowCapableNodeConnectorQueueStatisticsData> queue0IID = InstanceIdentifier.create(Nodes.class)
					.child(Node.class, new NodeKey(nodeId)) 
	                .child(NodeConnector.class, new NodeConnectorKey(new NodeConnectorId(nodeConnectorId))) 
	                .augmentation(FlowCapableNodeConnector.class) 
	                .child(Queue.class, new QueueKey(new QueueId((long)0))) 
	                .augmentation(FlowCapableNodeConnectorQueueStatisticsData.class);
			FlowCapableNodeConnectorQueueStatisticsData queue0Stats = GenericTransactionUtils
					.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, queue0IID);
			if (queue0Stats != null){
				long transmittedPackets = queue0Stats.getFlowCapableNodeConnectorQueueStatistics().getTransmittedPackets().getValue().longValue();
				long transmissionErrors = queue0Stats.getFlowCapableNodeConnectorQueueStatistics().getTransmissionErrors().getValue().longValue();
				//Error larger than threshold [=listOfSwitchPortsForStats.get(portId)]
				if (transmissionErrors - observedQueueErrors > listOfSwitchPortsForStats.get(portId)){
					LOG.debug("");
					LOG.debug("SwitchID {} , LinkID {}", switchId, connectorId);
					//LOG.debug("QueueID {}", 0);
					LOG.debug("Dropped Packets {}", transmissionErrors - observedQueueErrors);
					LOG.debug("Transmitted Packets {}", transmittedPackets);
					LOG.debug("------------------------------");
					
					FloodedLinksBuilder floodedLinkBuilder = new FloodedLinksBuilder();
					floodedLinkBuilder.setLinkId(portId);
					floodedLinkBuilder.setPacketDropObserved(transmissionErrors - observedQueueErrors);
					listOfFloodedLinks.add(floodedLinkBuilder.build());
					observedQueueErrors = transmissionErrors;
				}
				else {
					LOG.debug("");
					LOG.debug("SwitchID {} , LinkID {}", switchId, connectorId);
					//LOG.debug("QueueID {}", 0);
					LOG.debug("Dropped Packets {}", transmissionErrors - observedQueueErrors);
					LOG.debug("Transmitted Packets {}", transmittedPackets);
					LOG.debug("------------------------------");
				}
			}
			/*InstanceIdentifier<FlowCapableNodeConnectorQueueStatisticsData> queue1IID = InstanceIdentifier.create(Nodes.class)
					.child(Node.class, new NodeKey(nodeId)) 
	                .child(NodeConnector.class, new NodeConnectorKey(new NodeConnectorId(nodeConnectorId))) 
	                .augmentation(FlowCapableNodeConnector.class) 
	                .child(Queue.class, new QueueKey(new QueueId((long)1))) 
	                .augmentation(FlowCapableNodeConnectorQueueStatisticsData.class);
			FlowCapableNodeConnectorQueueStatisticsData queue1Stats = GenericTransactionUtils
					.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, queue0IID);*/
		}
		
		if (listOfFloodedLinks.isEmpty() == false){
			linkFlooded.setFloodedLinks(listOfFloodedLinks);
			this.notificationService.publish(linkFlooded.build());
		}
	}

	@Override
	public Future<RpcResult<CheckUdpIcmpFlowsOutput>> checkUdpIcmpFlows(
			CheckUdpIcmpFlowsInput input) {
		
		LOG.debug("Check Udp Icmp Flows called with Input {}", input.toString());
		
		CheckUdpIcmpFlowsOutputBuilder builder = new CheckUdpIcmpFlowsOutputBuilder();
		CheckUdpIcmpFlowsOutput output;
		
		long udpBytes = 0;
		long icmpBytes = 0;
		long totalBytes = 0;

		List<String> flowIDs = Lists.newArrayList();
		
		SwitchStatsSnapshot s = activeSdnApp.currentSwitchStats.get(input.getSwitchId());
		
		for (String flowId : s.listOfFlows.keySet()){
			FlowStatsTuple flowTuple = s.listOfFlows.get(flowId);
			if (activeSdnApp.blockedIPs.contains(flowTuple.srcIPAddress)){continue;}
			if (activeSdnApp.throttledIPs.contains(flowTuple.srcIPAddress)){continue;}
			if (activeSdnApp.serverIPs.contains(flowTuple.srcIPAddress)){continue;}
			if (activeSdnApp.whiteListedSources.contains(flowTuple.srcIPAddress)){continue;}
			totalBytes += flowTuple.byteCount;
			if (flowTuple.traffic == TrafficProtocolType.ICMP) {
				icmpBytes += flowTuple.byteCount;
			}
			else if (flowTuple.traffic == TrafficProtocolType.UDP) {
				if (flowTuple.byteCount == 0){continue;}
				udpBytes += flowTuple.byteCount;
				flowIDs.add(flowId);
			}
		}
		//LOG.debug("UDP Bytes {} and Total bytes {}", udpBytes, totalBytes);
		if (((float)udpBytes / (float)totalBytes) * 100 >= input.getAnomalousRate()){
			//LOG.debug("///////////////////////UDP Rate found //////////////");
			
			output = builder.setFlowIds(flowIDs).build();
			
			return RpcResultBuilder.success(output).buildFuture();
		}
		//else if (((float)udpBytes / (float)totalBytes) * 100 >= anomalousRate){
		//	return true;
		//}
		else {
			output = builder.setFlowIds(null).build();
			return RpcResultBuilder.success(output).buildFuture();
		}
	}

	@Override
	public Future<RpcResult<CheckElephantTcpFlowOutput>> checkElephantTcpFlow(
			CheckElephantTcpFlowInput input) {
		
		LOG.debug("Check Elephant TCP flows with Input {}", input.toString());
		CheckElephantTcpFlowOutputBuilder builder = new CheckElephantTcpFlowOutputBuilder();
		CheckElephantTcpFlowOutput output;
		
		
		List<String> elephantFlows = Lists.newArrayList();
		
		SwitchStatsSnapshot s = activeSdnApp.currentSwitchStats.get(input.getSwitchId());
		
		LOG.debug("Checking Elephant Flows ......................");
		
		ArrayList<Long> flowBytes = new ArrayList<Long>();
		for (String flowId : s.listOfFlows.keySet()){ 
			if (s.listOfFlows.get(flowId).traffic == TrafficProtocolType.UDP){continue;}
			if (activeSdnApp.blockedIPs.contains(s.listOfFlows.get(flowId).srcIPAddress)){continue;}
			if (activeSdnApp.throttledIPs.contains(s.listOfFlows.get(flowId).srcIPAddress)){continue;}
			if (s.listOfFlows.get(flowId).srcIPAddress == "") {continue;}
			if (activeSdnApp.serverIPs.contains(s.listOfFlows.get(flowId).srcIPAddress)) {continue;}
			if (activeSdnApp.whiteListedSources.contains(s.listOfFlows.get(flowId).srcIPAddress)){continue;}
			if (s.listOfFlows.get(flowId).byteCount > 0){
				flowBytes.add(s.listOfFlows.get(flowId).byteCount);
			}
		}
		
		if (flowBytes.size() < 1) {
			output = builder.setFlowIds(elephantFlows).build();
			return RpcResultBuilder.success(output).buildFuture();
		}
		
		Collections.sort(flowBytes);
		int median = flowBytes.size() / 2;
		long baseLineValue = flowBytes.get(median);
		
		for (String flowId : s.listOfFlows.keySet()){
			if (s.listOfFlows.get(flowId).traffic == TrafficProtocolType.UDP){continue;}
			if (activeSdnApp.blockedIPs.contains(s.listOfFlows.get(flowId).srcIPAddress)){continue;}
			if (activeSdnApp.throttledIPs.contains(s.listOfFlows.get(flowId).srcIPAddress)){continue;}
			if (s.listOfFlows.get(flowId).srcIPAddress == "") {continue;}
			if (activeSdnApp.serverIPs.contains(s.listOfFlows.get(flowId).srcIPAddress)) {continue;}
			if (activeSdnApp.whiteListedSources.contains(s.listOfFlows.get(flowId).srcIPAddress)){continue;}
			if (s.listOfFlows.get(flowId).byteCount > (baseLineValue * input.getAnomalousThreshold()) ){
				//String entry = currentSwitchStats.get(switchId).listOfFlows.get(flowId).flowId 
				//		+ "," + currentSwitchStats.get(switchId).listOfFlows.get(flowId).srcIPAddress;
				String entry = s.listOfFlows.get(flowId).flowId;
				elephantFlows.add(entry);
			}
		}
		output = builder.setFlowIds(elephantFlows).build();
		return RpcResultBuilder.success(output).buildFuture();
	}

	@Override
	public Future<RpcResult<CheckNewComersOutput>> checkNewComers(
			CheckNewComersInput input) {
		
		LOG.debug("Check New Comer Ratio with Input {}", input.toString());
		
		CheckNewComersOutputBuilder builder = new CheckNewComersOutputBuilder();
		CheckNewComersOutput output;
		
		int newComerRatio;
		int currentNumberofFlows = 0;	//This is to check how many total flows we have seen in current
										// windows so that we can calculate the ratio of new comers
		activeSdnApp.listOfNewComers.clear();
		for (String srcIp : activeSdnApp.sourceIpConfidence.keySet()){
			if (activeSdnApp.throttledIPs.contains(srcIp)){continue;} //if some IP has already been throttled then we'll not consider it
			if (activeSdnApp.blockedIPs.contains(srcIp)){continue;}
			if (activeSdnApp.whiteListedSources.contains(srcIp)){continue;}
			//LOG.debug("---------------Current Source IP {} ", srcIp);
			int noOfSnapshots = activeSdnApp.sourceIpConfidence.get(srcIp).size();
			if (activeSdnApp.sourceIpConfidence.get(srcIp).get(noOfSnapshots - 1) == true){
				currentNumberofFlows += 1;
				//LOG.debug("CurrentNumberofFlows {}", currentNumberofFlows);
			}
			int srcIPFrequency = 0;
			if ( noOfSnapshots > input.getSlidingWindowSize()) {
				srcIPFrequency = Collections.frequency(activeSdnApp.sourceIpConfidence.get(srcIp).
						subList(noOfSnapshots - input.getSlidingWindowSize(), noOfSnapshots - 1), true);
				//LOG.debug("srcIPFrequency {}", srcIPFrequency);
			}
			else {
				srcIPFrequency = Collections.frequency(activeSdnApp.sourceIpConfidence.get(srcIp), true);
				//LOG.debug("srcIPFrequency {}", srcIPFrequency);
			}
			//if (((float) srcIPFrequency / (float) slidingWindowSize) * 100 < newComerThreshold){
			if (srcIPFrequency < input.getNewComerThreshold()){
				//whiteListedIPs.add(srcIp);
				activeSdnApp.listOfNewComers.add(srcIp);
				//LOG.debug("srcIP Added {}", srcIp);
			}
		}
		newComerRatio =  (int) ((((float) activeSdnApp.listOfNewComers.size()) / ((float) currentNumberofFlows))*100);
		output = builder.setNewComerRatio(newComerRatio).build();
		
		return RpcResultBuilder.success(output).buildFuture();
	}

	@Override
	public Future<RpcResult<LimitFlowOutput>> limitFlow(LimitFlowInput input) {
		
		LOG.debug("Limit flow called with Input {}", input.toString());
		
		LimitFlowOutput output;
		LimitFlowOutputBuilder builder = new LimitFlowOutputBuilder();
		
		
		int currentSnapshotIndex = activeSdnApp.networkStatistics.get(input.getSwitchId()).size() - 1;
		SwitchStatsSnapshot snapshot = activeSdnApp.networkStatistics.get(input.getSwitchId()).get(currentSnapshotIndex);
		for (String flowId : snapshot.listOfFlows.keySet()){
			if (snapshot.listOfFlows.get(flowId).srcIPAddress.equals(input.getSourceIp())){
				FlowStatsTuple flowTuple = snapshot.listOfFlows.get(flowId);
				InstallFlowRuleInputBuilder flowRuleInputBuilder = new InstallFlowRuleInputBuilder();
				
				flowRuleInputBuilder.setInPortId((long)0);
				flowRuleInputBuilder.setSwitchId(input.getSwitchId());
				flowRuleInputBuilder.setSrcIpAddress(flowTuple.srcIPAddress);
				flowRuleInputBuilder.setDstIpAddress(flowTuple.dstIPAddress);
				flowRuleInputBuilder.setFlowPriority(300);
				flowRuleInputBuilder.setIdleTimeout(0);
				flowRuleInputBuilder.setHardTimeout(0);
				flowRuleInputBuilder.setActionOutputPort(Integer.toString(input.getFloodedLink()));
				//As we have only two queues available with Queue IDs 0 & 1. 0 default port with full speed, however
				//1 is used for throttling the rate. In future, if we use more queues then it should be made more 
				//dynamic
				flowRuleInputBuilder.setActionSetPortQueue(1);
				//if (flowTuple.traffic != null){
					//if (flowTuple.traffic == TrafficProtocolType.ICMP){
						flowRuleInputBuilder.setTypeOfTraffic(TrafficType.ICMP);
						this.installFlowRule(flowRuleInputBuilder.build());
					//}
					//else if (flowTuple.traffic == TrafficProtocolType.TCP){
						flowRuleInputBuilder.setTypeOfTraffic(TrafficType.TCP);
						this.installFlowRule(flowRuleInputBuilder.build());
					//}
					//else if (flowTuple.traffic == TrafficProtocolType.UDP){
						//LOG.debug("UDP flow rule found ");
						flowRuleInputBuilder.setTypeOfTraffic(TrafficType.UDP);				
						this.installFlowRule(flowRuleInputBuilder.build());
					//}
				//}	
			}
		}
				
		if (!activeSdnApp.throttledIPs.contains(input.getSourceIp())){
			LOG.debug("Source IP {} is Throttled. ", input.getSourceIp());
			activeSdnApp.throttledIPs.add(input.getSourceIp());
		}
		
		String status = "Flow limiting successfull";
		output = builder.setStatus(status).build();
		return RpcResultBuilder.success(output).buildFuture();
	}

	@Override
	public Future<RpcResult<BlockFlowOutput>> blockFlow(BlockFlowInput input) {
		BlockFlowOutput output;
		BlockFlowOutputBuilder builder = new BlockFlowOutputBuilder();
		String status;
		
		int currentSnapshotIndex = activeSdnApp.networkStatistics.get(input.getSwitchId()).size() - 1;
		SwitchStatsSnapshot snapshot = activeSdnApp.networkStatistics.get(input.getSwitchId()).get(currentSnapshotIndex);
		if (snapshot.listOfFlows.containsKey(input.getFlowId())){
			FlowStatsTuple flowTuple = snapshot.listOfFlows.get(input.getFlowId());
			if (activeSdnApp.serverIPs.contains(flowTuple.srcIPAddress)){
				status = "Server IP will not going to block";
				output = builder.setStatus(status).build();
				return RpcResultBuilder.success(output).buildFuture();
			}
			InstallFlowRuleInputBuilder flowRuleInputBuilder = new InstallFlowRuleInputBuilder();
			
			flowRuleInputBuilder.setInPortId((long)0);
			flowRuleInputBuilder.setSwitchId(input.getSwitchId());
			flowRuleInputBuilder.setSrcIpAddress(flowTuple.srcIPAddress);
			flowRuleInputBuilder.setDstIpAddress(flowTuple.dstIPAddress);
			flowRuleInputBuilder.setFlowPriority(300);
			flowRuleInputBuilder.setIdleTimeout(0);
			flowRuleInputBuilder.setHardTimeout(0);
			//This will set the output port to Drop so that packet belongs to this flow will be immediately dropped.
			flowRuleInputBuilder.setActionOutputPort(DROP);
			if (input.getType().equals("UDP")){
				flowRuleInputBuilder.setTypeOfTraffic(TrafficType.UDP);
				this.installFlowRule(flowRuleInputBuilder.build());
			}
			else if (input.getType().equals("Elephant")){
				flowRuleInputBuilder.setTypeOfTraffic(TrafficType.TCP);
				this.installFlowRule(flowRuleInputBuilder.build());
			}
			else if (input.getType().equals("NewComers")){
				if (flowTuple.traffic != null){
					if (flowTuple.traffic == TrafficProtocolType.ICMP){
						flowRuleInputBuilder.setTypeOfTraffic(TrafficType.ICMP);
					}
					else if (flowTuple.traffic == TrafficProtocolType.TCP){
						flowRuleInputBuilder.setTypeOfTraffic(TrafficType.TCP);
					}
					else if (flowTuple.traffic == TrafficProtocolType.UDP){
						//LOG.debug("UDP flow rule found ");
						flowRuleInputBuilder.setTypeOfTraffic(TrafficType.UDP);						
					}
				}	
				this.installFlowRule(flowRuleInputBuilder.build());
			}
		
			if (!activeSdnApp.blockedIPs.contains(flowTuple.srcIPAddress)){
				LOG.debug("Source IP {} is blocked.", flowTuple.srcIPAddress);
				activeSdnApp.blockedIPs.add(flowTuple.srcIPAddress);
			}
		}
		
		status = "Flow successfully blocked";
		output = builder.setStatus(status).build();
		return RpcResultBuilder.success(output).buildFuture();
	}

	@Override
	public Future<RpcResult<FindPotentialFloodedLinkOutput>> findPotentialFloodedLink(
			FindPotentialFloodedLinkInput input) {

		String criticalLink = "";
		activeSdnApp.criticalLinks.clear();

		for (List<String> path : activeSdnApp.getInstalledPaths().values()) {
			for (int index = 1; index < path.size() - 2; index++) {
				// Currently I have made this to ensure that I find Critical
				// link in the middle of the network
				// and not with the edge routers
				String link = path.get(index) + ":" + path.get(index + 1);
				String revLink = path.get(index + 1) + ":" + path.get(index);
				if (activeSdnApp.criticalLinks.containsKey(link)) {
					activeSdnApp.criticalLinks.put(link, activeSdnApp.criticalLinks.get(link) + 1);
				} else if (activeSdnApp.criticalLinks.containsKey(revLink)) {
					activeSdnApp.criticalLinks.put(revLink, activeSdnApp.criticalLinks.get(revLink) + 1);
				} else {
					activeSdnApp.criticalLinks.put(link, 1);
				}
			}
		}

		int maxValue = (Collections.max(activeSdnApp.criticalLinks.values())); // This will return max value in the Hashmap

		for (Entry<String, Integer> entry : activeSdnApp.criticalLinks.entrySet()) { // Iterate through hashmap
			// if (entry.getKey().contains("11") ||
			// entry.getKey().contains("5")) {continue;}
			if (entry.getValue() == maxValue) {
				LOG.debug("     ^^^^^^^^^^^^^^==============================^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^     ");
				LOG.debug("                    Critical Link = {} ",
						entry.getKey());
				LOG.debug("     ^^^^^^^^^^^^^^==============================^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^     ");
				criticalLink = entry.getKey();
				break;
			}
		}
		
		int leftSwitch = Integer.parseInt(criticalLink.split(":")[0]);
		int rightSwitch = Integer.parseInt(criticalLink.split(":")[1]);
		LinkInfo link = activeSdnApp.getTopology().findLink(leftSwitch, rightSwitch);
		
		FindPotentialFloodedLinkOutput output;
		FindPotentialFloodedLinkOutputBuilder builder = new FindPotentialFloodedLinkOutputBuilder();
		builder.setCriticalLink(criticalLink);
		builder.setLeftSwitch(leftSwitch);
		builder.setLeftSwitchPort(link.getLeftSwitchPortNumber());
		builder.setRightSwitch(rightSwitch);
		builder.setRightSwitchPort(link.getRightSwitchPortNumber());
		output = builder.build();
		return RpcResultBuilder.success(output).buildFuture();
	}

	

//	@Override
//	public Future<RpcResult<FindPotentialFloodedLinkOutput>> findPotentialFloodedLink(
//			FindPotentialFloodedLinkInput input) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
