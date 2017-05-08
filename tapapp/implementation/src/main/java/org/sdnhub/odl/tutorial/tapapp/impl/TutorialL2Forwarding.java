/*
 * Copyright (C) 2015 SDN Hub

 Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3.
 You may not use this file except in compliance with this License.
 You may obtain a copy of the License at

    http://www.gnu.org/licenses/gpl-3.0.txt

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 implied.

 *
 */

package org.sdnhub.odl.tutorial.tapapp.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.NotificationProviderService;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev100924.MacAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.DropActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.OutputActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwTosActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwTtlActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.drop.action._case.DropActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.output.action._case.OutputActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.nw.tos.action._case.SetNwTosActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.nw.ttl.action._case.SetNwTtlActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.Table;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.TableKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.FlowAdded;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.FlowRemoved;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.FlowUpdated;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.NodeErrorNotification;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.NodeExperimenterErrorNotification;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.SalFlowListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.SwitchFlowRemoved;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.InstructionsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.MatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.ApplyActionsCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.MeterCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.apply.actions._case.ApplyActionsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.Instruction;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.InstructionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.InstructionKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.MeterId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.PacketProcessingListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.PacketProcessingService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.PacketReceived;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.TransmitPacketInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.TransmitPacketInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggered.TriggeredEventType;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.EventTriggeredBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFoundBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketTypeBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketTypeBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketTypeBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketTypeBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ConnectedHosts;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CookieToFlowid;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeaderBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Ipv4PacketHeader;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Ipv4PacketHeaderBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.KnownEtherType;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.KnownHardwareType;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.KnownIpProtocols;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.KnownOperation;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.LocalIpv4Prefix;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapSpec;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeaderBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHostBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHostKey;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.Cookie;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.CookieKey;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.BlockCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.DropAndNotifyCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.NotifyCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.SetRateLimitEventCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.tap.spec.Tap;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.tap.spec.TapKey;
import org.opendaylight.yangtools.concepts.Registration;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.sdnhub.odl.tutorial.utils.GenericTransactionUtils;
import org.sdnhub.odl.tutorial.utils.PacketParsingUtils;
import org.sdnhub.odl.tutorial.utils.inventory.InventoryUtils;
import org.sdnhub.odl.tutorial.utils.openflow13.MatchUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
@SuppressWarnings("deprecation")

class EventDetection {
	String tapId;
	String flowId;
	long triggerCount;
	long triggerDuration;
	boolean notify;
	boolean block;
	boolean rateLimit;
	boolean dropandnotify;
	Queue eventQueue = new LinkedList();
	
	EventDetection(String tapId, String flowId, long triggerCount, long triggerDuration,
			boolean block, boolean notify, boolean rateLimit, boolean dropandnotify){
		this.tapId = tapId;
		this.flowId = flowId;
		this.triggerCount = triggerCount;
		this.triggerDuration = triggerDuration;
		this.block = block;
		this.notify = notify;
		this.rateLimit = rateLimit;
		this.dropandnotify = dropandnotify;
	}
	
	void incrementCount(long second){
		eventQueue.add(second);
	}
	
	void removeOldInstances(long second){
		if (eventQueue.size() > 1){
			while (second - (long)eventQueue.element() > triggerDuration ){
				eventQueue.remove();
				if (eventQueue.size() == 1) break;
			}
		}
	}
	void resetEventCounter (long second){
		eventQueue.clear();
		incrementCount(second);
	}
	boolean getBlockValue () {return this.block;}
	boolean getNotifyValue () {return this.notify;}
	boolean getRateLimit() {return this.rateLimit;}
	boolean getDropAndNotify () {return this.dropandnotify;}
	
	String getTapId() {return this.tapId;}
	String getFlowId() {return this.flowId;}
	
	boolean detectEvent(long second){
		removeOldInstances(second);
		incrementCount(second);
		if (eventQueue.size() > triggerCount){
			//eventQueue.clear();
			return true;
		}
		return false;
	}
}
///////////---------------------------------------------------------////////////////////
public class TutorialL2Forwarding  implements AutoCloseable, PacketProcessingListener, SalFlowListener {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final static long FLOOD_PORT_NUMBER = 0xfffffffbL;
    private final static long TABLE_PORT_NUMBER = 0xfffffff9L;
    private final static long CONTROLLER_PORT_NUMBER = 0xfffffffdL;
    private static final int TOS_POSITION = 15;
    
    //Members specific to this class
    private Map<String, NodeConnectorId> macTable = new HashMap <String, NodeConnectorId>();
    private boolean firstime = true;
	HashMap<String, EventDetection> eventMap = new HashMap<String, EventDetection>();
	HashMap<String, EventDetection> arpFloodHandler = new HashMap<String, EventDetection>();
	private final AtomicLong meterId = new AtomicLong();
    Date date = new Date();
    //Members related to MD-SAL operations
	private List<Registration> registrations;
	private DataBroker dataBroker;
	private PacketProcessingService packetProcessingService;
	private NotificationProviderService notificationService;
	private ActiveSDNAssignment activeSDNAssignment;
	private int watiBeforeNotifying = 0; 
	private int currentWait = 0;
	
    /////////////////////////////////////////////////////////////////////////////////////	
    public TutorialL2Forwarding(DataBroker dataBroker, NotificationProviderService notificationService, RpcProviderRegistry rpcProviderRegistry, 
    		ActiveSDNAssignment activeSDNAssignment) {
    	this.activeSDNAssignment = activeSDNAssignment;
    	//Store the data broker for reading/writing from inventory store
        this.dataBroker = dataBroker;
        this.notificationService = notificationService;

        //EventTriggeredBuilder eventBuilder = new EventTriggeredBuilder();
        //eventBuilder.setEventId("1");
        //notificationService.publish(eventBuilder.build());
        
        //Get access to the packet processing service for making RPC calls later
        this.packetProcessingService = rpcProviderRegistry.getRpcService(PacketProcessingService.class);        

    	//List used to track notification (both data change and YANG-defined) listener registrations
    	this.registrations = Lists.newArrayList(); 

        //Register this object for receiving notifications when there are PACKET_INs
        registrations.add(notificationService.registerNotificationListener(this));
        
  	}
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void close() throws Exception {
        for (Registration registration : registrations) {
        	registration.close();
        }
        registrations.clear();
    }
   
    public void clearConfiguration(){
    	macTable.clear();
    	eventMap.clear();
    	arpFloodHandler.clear();
    	firstime = true;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    public byte [] craftArpReply (PacketReceived notification, ArpPacket arpPacket){
    	
    	//Arrays.copyOfRange(payload, DST_MAC_START_POSITION, DST_MAC_END_POSITION)
    	byte[] payload = notification.getPayload();
        byte[] dstMacRaw = PacketParsingUtils.extractDstMac(payload);
        byte[] srcMacRaw = PacketParsingUtils.extractSrcMac(payload);
        byte[] etherTypeRaw = PacketParsingUtils.extractEtherType(notification.getPayload());
    	return null;
    }
    /////////////////////////////////////////////////////////////////////////////
    public ArpPacket decode(byte [] data) {
        
        //ArpPacketReceivedBuilder arpReceivedBuilder = new ArpPacketReceivedBuilder();

        // Find the latest packet in the packet-chain, which is an
        // EthernetPacket
        //List<PacketChain> packetChainList = ethernetPacketReceived.getPacketChain();
        //EthernetPacket ethernetPacket = (EthernetPacket) packetChainList.get(packetChainList.size() - 1).getPacket();
        //int bitOffset = ethernetPacket.getPayloadOffset() * NetUtils.NumBitsInAByte;
        int bitOffset = 14 * NetUtils.NumBitsInAByte; //14 bytes of Ethernet header

        ArpPacketBuilder builder = new ArpPacketBuilder();
        
        try {
            // Decode the hardware-type (HTYPE) and protocol-type (PTYPE) fields

            builder.setHardwareType(KnownHardwareType
                    .forValue(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 0, 16))));
            builder.setProtocolType(
                    KnownEtherType.forValue(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 16, 16))));

            // Decode the hardware-length and protocol-length fields
            builder.setHardwareLength(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 32, 8)));
            builder.setProtocolLength(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 40, 8)));

            // Decode the operation field
            builder.setOperation(
                    KnownOperation.forValue(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 48, 16))));

            // Decode the address fields
            int indexSrcProtAdd = 64 + 8 * builder.getHardwareLength();
            int indexDstHardAdd = indexSrcProtAdd + 8 * builder.getProtocolLength();
            int indexDstProtAdd = indexDstHardAdd + 8 * builder.getHardwareLength();
            if (builder.getHardwareType().equals(KnownHardwareType.Ethernet)) {
                builder.setSourceHardwareAddress(HexEncode.bytesToHexStringFormat(
                        BitBufferHelper.getBits(data, bitOffset + 64, 8 * builder.getHardwareLength())));
                builder.setDestinationHardwareAddress(HexEncode.bytesToHexStringFormat(
                        BitBufferHelper.getBits(data, bitOffset + indexDstHardAdd, 8 * builder.getHardwareLength())));
            } else {
                LOG.debug(
                        "Unknown HardwareType -- sourceHardwareAddress and destinationHardwareAddress are not decoded");
            }

            if (builder.getProtocolType().equals(KnownEtherType.Ipv4)
                    || builder.getProtocolType().equals(KnownEtherType.Ipv6)) {
                builder.setSourceProtocolAddress(InetAddress.getByAddress(
                        BitBufferHelper.getBits(data, bitOffset + indexSrcProtAdd, 8 * builder.getProtocolLength()))
                        .getHostAddress());
                builder.setDestinationProtocolAddress(InetAddress.getByAddress(
                        BitBufferHelper.getBits(data, bitOffset + indexDstProtAdd, 8 * builder.getProtocolLength()))
                        .getHostAddress());
            } else {
                LOG.debug(
                        "Unknown ProtocolType -- sourceProtocolAddress and destinationProtocolAddress are not decoded");
            }
        } catch (BufferException | UnknownHostException e) {
            LOG.debug("Exception while decoding APR packet", e.getMessage());
        }

        return builder.build();
        //return null;
    }
 
    /////////////////////////////////////////////////////////////////////////////////////
    public Ipv4PacketHeader ipv4Decode(byte [] data){
    	
    	int bitOffset = 14 * NetUtils.NumBitsInAByte; //14 bytes of Ethernet header

        Ipv4PacketHeaderBuilder builder = new Ipv4PacketHeaderBuilder();
        
        try {
            builder.setVersion(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset, 4)));
            if (builder.getVersion().intValue() != 4) {
                LOG.debug("Version should be 4, but is {}", builder.getVersion());
            }
            
            //Dscp val = new Dscp(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 8, 6)));
            
            short dscpValue = BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 8, 6));
            
            builder.setIhl(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 4, 4)));
            //builder.setDscp(new Dscp(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 8, 6))));
            builder.setDscp(dscpValue);
            builder.setEcn(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 14, 2)));
            builder.setIpv4Length(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 16, 16)));
            builder.setId(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 32, 16)));

            // Decode the flags -- Reserved, DF (Don't Fragment), MF (More
            // Fragments)
            builder.setReservedFlag(1 == (BitBufferHelper.getBits(data, bitOffset + 48, 1)[0] & 0xff));
            if (builder.isReservedFlag()) {
                LOG.debug("Reserved flag should be 0, but is 1.");
            }
            // "& 0xff" removes the sign of the Java byte
            builder.setDfFlag(1 == (BitBufferHelper.getBits(data, bitOffset + 49, 1)[0] & 0xff));
            builder.setMfFlag(1 == (BitBufferHelper.getBits(data, bitOffset + 50, 1)[0] & 0xff));

            builder.setFragmentOffset(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 51, 13)));
            builder.setTtl(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 64, 8)));
            builder.setProtocol(KnownIpProtocols
                    .forValue(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 72, 8))));
            builder.setChecksum(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 80, 16)));

            builder.setSourceIpv4(InetAddress.getByAddress(BitBufferHelper.getBits(data, bitOffset + 96, 32)).getHostAddress());
            builder.setDestinationIpv4(InetAddress.getByAddress(BitBufferHelper.getBits(data, bitOffset + 128, 32)).getHostAddress());
            
            //builder.setSourceIpv4(Ipv4Prefix.getDefaultInstance(
            //        InetAddress.getByAddress(BitBufferHelper.getBits(data, bitOffset + 96, 32)).getHostAddress()).getValue());
            //builder.setDestinationIpv4(Ipv4Prefix.getDefaultInstance(
            //        InetAddress.getByAddress(BitBufferHelper.getBits(data, bitOffset + 128, 32)).getHostAddress()).getValue());

            // Decode the optional "options" parameter
            int optionsSize = (builder.getIhl() - 5) * 32;
            if (optionsSize > 0) {
                builder.setIpv4Options(BitBufferHelper.getBits(data, bitOffset + 160, optionsSize));
            }

            // Decode the IPv4 Payload
            int payloadStartInBits = bitOffset + 160 + optionsSize;
            int payloadEndInBits = data.length * NetUtils.NumBitsInAByte - payloadStartInBits
                    - 4 * NetUtils.NumBitsInAByte;
            int start = payloadStartInBits / NetUtils.NumBitsInAByte;
            int end = start + payloadEndInBits / NetUtils.NumBitsInAByte;
            builder.setPayloadOffset(start);
            builder.setPayloadLength(end - start);
            builder.setPayload(data);

        } //catch (BufferException | UnknownHostException e) {
        catch (Exception e) {
            LOG.debug("Exception while decoding IPv4 packet", e.getMessage());
        }

        return builder.build();
    }
 
    /////////////////////////////////////////////////////////////////////////////////////
    public IcmpPacketHeader icmpDecode(Ipv4PacketHeader ipv4Packet){

         int bitOffset = ipv4Packet.getPayloadOffset() * NetUtils.NumBitsInAByte;
         byte[] data = ipv4Packet.getPayload();

         IcmpPacketHeaderBuilder builder = new IcmpPacketHeaderBuilder();
         try {
             // Decode the ICMP type and ICMP code
             builder.setType(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 0, 8)));
             builder.setCode(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset + 8, 8)));

             // Decode the checksum
             builder.setCrc(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 16, 16)));

             // Decode the identifier and sequence number
             builder.setIdentifier(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 32, 16)));
             builder.setSequenceNumber(BitBufferHelper.getInt(BitBufferHelper.getBits(data, bitOffset + 48, 16)));

             // Decode the ICMP Payload
             int payloadStartInBits = bitOffset + 64;
             int payloadEndInBits = data.length * NetUtils.NumBitsInAByte - payloadStartInBits - 4 * NetUtils.NumBitsInAByte;
             int start = payloadStartInBits / NetUtils.NumBitsInAByte;
             int end = start + payloadEndInBits / NetUtils.NumBitsInAByte;
             builder.setPayloadOffset(start);
             builder.setPayloadLength(end - start);
         } catch (BufferException e) {
             LOG.debug("Exception while decoding ICMP packet", e.getMessage());
         }
             
         return builder.build();
    }

    public TcpPacketHeader tcpPacketDecode(byte[] payload) {
    	int bitOffset = 34 * NetUtils.NumBitsInAByte; //14 bytes of Ethernet header (14 + 60) TCP header
		TcpPacketHeaderBuilder tcpPacketHeaderBuilder = new TcpPacketHeaderBuilder();
//		tcpPacketHeaderBuilder.setVersion(BitBufferHelper.getShort(BitBufferHelper.getBits(data, bitOffset, 4)));
		try {
			tcpPacketHeaderBuilder.setSourcePort(BitBufferHelper.getShort(BitBufferHelper.getBits(payload, bitOffset, 16)));
			tcpPacketHeaderBuilder.setDestPort(BitBufferHelper.getShort(BitBufferHelper.getBits(payload, bitOffset +16 , 16)));
			tcpPacketHeaderBuilder.setSequenceNumber(BitBufferHelper.getInt(BitBufferHelper.getBits(payload, bitOffset + 32, 32)));
			tcpPacketHeaderBuilder.setSynFlag(1 == (BitBufferHelper.getBits(payload, bitOffset + 103 + 7, 1)[0] & 0xff));
			tcpPacketHeaderBuilder.setRstFlag(1 == (BitBufferHelper.getBits(payload, bitOffset + 103 + 6, 1)[0] & 0xff));
			tcpPacketHeaderBuilder.setAckFlag(1 == (BitBufferHelper.getBits(payload, bitOffset + 103 + 4, 1)[0] & 0xff));
			tcpPacketHeaderBuilder.setFinFlag(1 == (BitBufferHelper.getBits(payload, bitOffset + 103 + 8, 1)[0] & 0xff));
		} catch (BufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return tcpPacketHeaderBuilder.build();
	}
   
    public String extractPayload(Ipv4PacketHeader ipv4Packet){
//<<<<<<< HEAD
//    	boolean tcpHeader = (ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Tcp.getIntValue() ? true : false);
//    	boolean udpHeader = (ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Udp.getIntValue() ? true : false);
//    	LOG.debug(ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Tcp.getIntValue() ? "It is TCP Header" : "It is UDP Header");
//    	int totalLength = ipv4Packet.getIpv4Length();
//    	LOG.debug("Total Packet Length {}", totalLength);
//    	int headerLength = ipv4Packet.getPayloadLength();
//    	LOG.debug("IP Header Length {} ", headerLength);
//    	//int payloadLength = totalLength - headerLength - (tcpHeader ? 20 : 8);
//    	int payloadLength = totalLength - 40;
//    	LOG.debug("Payload Length {}", payloadLength);
//    	int payloadOffset = 14 + 40;// headerLength + (tcpHeader ? 20 : 8);
//    	LOG.debug("Payload offset in bytes {}", payloadOffset);
//    	payloadOffset *= NetUtils.NumBitsInAByte;
//    	LOG.debug("Payload offset in bits {}", payloadOffset);
//=======
//    	boolean tcpHeader = (ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Tcp.getIntValue() ? true : false);
//    	boolean udpHeader = (ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Udp.getIntValue() ? true : false);
    	LOG.debug(ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Tcp.getIntValue() ? "It is TCP Header" : "It is UDP Header");
    	int totalLength = ipv4Packet.getIpv4Length();
//    	LOG.debug("Total Packet Length {}", totalLength);
    	int headerLength = ipv4Packet.getPayloadLength();
//    	LOG.debug("IP Header Length {} ", headerLength);
    	//int payloadLength = totalLength - headerLength - (tcpHeader ? 20 : 8);
    	int payloadLength = totalLength - 40;
//    	LOG.debug("Payload Length {}", payloadLength);
    	int payloadOffset = 14 + 40;// headerLength + (tcpHeader ? 20 : 8);
//    	LOG.debug("Payload offset in bytes {}", payloadOffset);
    	payloadOffset *= NetUtils.NumBitsInAByte;
//    	LOG.debug("Payload offset in bits {}", payloadOffset);
//>>>>>>> master
    	String payload = "";
    	
    	try {
    		if (payloadLength > 0){
        		LOG.debug("Payload available in the packet with length: {}", payloadLength);
        		for (int i = 0; i < payloadLength; i++) {
        			payload = payload + Character.toString((char) BitBufferHelper.getShort(BitBufferHelper.getBits(ipv4Packet.getPayload(), payloadOffset, 8)));
        			payloadOffset += 8;
//        			LOG.debug("Payload {}", payload);
				}
        	}
        	else {
        		LOG.debug("There is no payload in the packet");
        	}
    	}
    	catch (Exception e){
    		LOG.debug("Exception reached in payload decoding {}", e);
    		return null;
    	}
    	
    	//TCP header length is 20 bytes
    	//IP header lenght is 20 bytes
    	//UDP header lenght is 8 bytes
    	return payload;
    	
    }
    ////////////////////////////////////////////////////////////////////////////
    @Override
	public void onPacketReceived(PacketReceived notification) {
    	//LOG.debug("         ---------------------------------------------------------------------     ");
    	//LOG.debug("Received packet notification {}", notification.getMatch());
    	//LOG.debug("         ---------------------------------------------------------------------     ");
    	byte[] payload = notification.getPayload();
       	ArpPacket arpPacket = null;
        //Ignore LLDP packets, or you will be in big trouble
        byte[] etherTypeRaw = PacketParsingUtils.extractEtherType(notification.getPayload());
        int etherType = (0x0000ffff & ByteBuffer.wrap(etherTypeRaw).getShort());
        if (etherType == 0x88cc) {
        	return;
        }
        NodeConnectorRef ingressNodeConnectorRef = notification.getIngress();
        NodeRef ingressNodeRef = InventoryUtils.getNodeRef(ingressNodeConnectorRef);
        NodeConnectorId ingressNodeConnectorId = InventoryUtils.getNodeConnectorId(ingressNodeConnectorRef);
        NodeId ingressNodeId = InventoryUtils.getNodeId(ingressNodeConnectorRef);
        
        NodeConnectorId floodNodeConnectorId = InventoryUtils.getNodeConnectorId(ingressNodeId, FLOOD_PORT_NUMBER);
    	NodeConnectorRef floodNodeConnectorRef = InventoryUtils.getNodeConnectorRef(floodNodeConnectorId);
    	
    	NodeConnectorId tableNodeConnectorId = InventoryUtils.getNodeConnectorId(ingressNodeId, TABLE_PORT_NUMBER);
    	NodeConnectorRef tableNodeConnectorRef = InventoryUtils.getNodeConnectorRef(tableNodeConnectorId);
    	
    	//NodeConnectorId controllerNodeConnectorId = InventoryUtils.getNodeConnectorId(ingressNodeId, CONTROLLER_PORT_NUMBER);
    	//NodeConnectorRef controllerNodeConnectorRef = InventoryUtils.getNodeConnectorRef(controllerNodeConnectorId);
    	
        
        if (etherType == 0x0806){ //ARP packet
        	if (this.firstime == true){
        		this.firstime = false;
        		//ConstructTopologyBuilder topologyBuilder = new ConstructTopologyBuilder();
        		//this.notificationService.publish(topologyBuilder.build());
        		//this.activeSDNAssignment.onConstructTopology(topologyBuilder.build());
        	}
        	arpPacket = decode(payload);
        	LocalIpv4Prefix srcipPrefix = new LocalIpv4Prefix(arpPacket.getSourceProtocolAddress() + "/32");
    		InstanceIdentifier<ConnectedHost> hostIID = InstanceIdentifier.builder(ConnectedHosts.class)
    				.child(ConnectedHost.class, new ConnectedHostKey(srcipPrefix))
    				.build();
    		ConnectedHost host = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, hostIID);
    		if (host == null){
    			//EventDetection eventDetection = new EventDetection(arpPacket.getDestinationHardwareAddress(), 
    			//		arpPacket.getSourceProtocolAddress(), 15, 20, true, false, false,false);
                //arpFloodHandler.put(arpPacket.getDestinationHardwareAddress(), eventDetection);
                
    			ConnectedHostBuilder hostBuilder = new ConnectedHostBuilder();
    			hostBuilder.setHostIpAddress(srcipPrefix);
    			hostBuilder.setHostMacAddress(new MacAddress(arpPacket.getSourceHardwareAddress()));
    			hostBuilder.setNodeConnectedTo(ingressNodeId);
    			hostBuilder.setNodeConnectorConnectedTo(ingressNodeConnectorId);
    			InstanceIdentifier<ConnectedHost> newhostIID = InstanceIdentifier.builder(ConnectedHosts.class)
        				.child(ConnectedHost.class, new ConnectedHostKey(srcipPrefix))
        				.build();
    			GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.OPERATIONAL, 
    					newhostIID, hostBuilder.build(), true);
    			//LOG.debug("         ---------------------------------------------------------------------     ");
            	//LOG.debug("A new Host is learnt from ARP packet with IP {} and MAC {}", hostBuilder.getHostIpAddress(), hostBuilder.getHostMacAddress());
            	//LOG.debug("         ---------------------------------------------------------------------     ");
            	//----------------------------------------
            	NewHostFoundBuilder hostFoundBuilder = new NewHostFoundBuilder();
            	hostFoundBuilder.setHostIpAddress(hostBuilder.getHostIpAddress().getValue());
            	hostFoundBuilder.setHostMacAddress(hostBuilder.getHostMacAddress().getValue());
            	hostFoundBuilder.setSwitchConnectedTo(Integer.parseInt(hostBuilder.getNodeConnectedTo().getValue().split(":")[1]));
				hostFoundBuilder.setPortConnectedTo(Integer.parseInt(hostBuilder.getNodeConnectorConnectedTo().getValue().split(":")[2]));
				//this.notificationService.publish(hostFoundBuilder.build());
				this.activeSDNAssignment.onNewHostFound(hostFoundBuilder.build());
    		}
    		
    		EventTriggeredBuilder eventBuilder = new EventTriggeredBuilder();
    		eventBuilder.setTriggeredEventType(TriggeredEventType.NoFlowRuleEvent);
    		eventBuilder.setEventId("0");
    		eventBuilder.setInPortNumber(Integer.parseInt(ingressNodeConnectorId.getValue().split(":")[2]));
    		eventBuilder.setSwitchId(Integer.parseInt(ingressNodeId.getValue().split(":")[1]));
    		eventBuilder.setPayload(notification.getPayload());
    		//------------------------------------------------------------
    		ArpPacketTypeBuilder arpPacketBuilder = new ArpPacketTypeBuilder(); 
    		arpPacketBuilder.setEthernetSrcMacAddress(arpPacket.getSourceHardwareAddress());
    		arpPacketBuilder.setEthernetType(Integer.toString(etherType));
    		
    		arpPacketBuilder.setHardwareType(Integer.toString(arpPacket.getHardwareType().getIntValue()));
    		arpPacketBuilder.setProtocolType(arpPacket.getProtocolType().name());
    		arpPacketBuilder.setHardwareAddressLength((int)arpPacket.getHardwareLength());
    		arpPacketBuilder.setProtocolAddressLength((int)arpPacket.getProtocolLength());
    		arpPacketBuilder.setOpcode(arpPacket.getOperation().name());
    		arpPacketBuilder.setSenderHardwareAddress(arpPacket.getSourceHardwareAddress());
    		arpPacketBuilder.setSenderProtocolAddress(arpPacket.getSourceProtocolAddress());
    		arpPacketBuilder.setTargetHardwareAddress(arpPacket.getDestinationHardwareAddress());
    		arpPacketBuilder.setTargetProtocolAddress(arpPacket.getDestinationProtocolAddress());
    		//------------------------------------------------------------
    		eventBuilder.setPacketType(arpPacketBuilder.build());
    		//this.notificationService.publish(eventBuilder.build());
    		//this.activeSDNAssignment.onEventTriggered(eventBuilder.build());
    		ApplyActionsBuilder aab = new ApplyActionsBuilder();
 	        ActionBuilder ab = new ActionBuilder();
 	        List<Action> actionList = Lists.newArrayList();

 	        SetNwTtlActionBuilder nwTtlActionBuilder = new SetNwTtlActionBuilder();
 	        nwTtlActionBuilder.setNwTtl((short)1);
 	        ab.setAction(new SetNwTtlActionCaseBuilder().setSetNwTtlAction(nwTtlActionBuilder.build()).build());
 	        ab.setKey(new ActionKey(0));
 	        ab.setOrder(0);
 	        actionList.add(ab.build());
    		packetOut(ingressNodeRef, notification.getPayload(), actionList, ingressNodeConnectorRef, floodNodeConnectorRef);
    		//long timeMillis = System.currentTimeMillis();
			//long second = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
			//if (arpFloodHandler.containsKey(arpPacket.getDestinationHardwareAddress())){
            // 	if (arpFloodHandler.get(arpPacket.getDestinationHardwareAddress()).detectEvent(second) == false){
            // 		List<Action> actionList = Lists.newArrayList();
        	//		packetOut(ingressNodeRef, notification.getPayload(), actionList, ingressNodeConnectorRef, floodNodeConnectorRef);
            // 	}
            // }
    		
    		
        	return; 
        }
        else if (etherType == 0x0800) { //IP packet
        	Ipv4PacketHeader ipv4Packet = ipv4Decode(notification.getPayload());
        	EventTriggeredBuilder eventBuilder = new EventTriggeredBuilder();
        	if (ipv4Packet != null){
        		eventBuilder.setEventId("0");
        		eventBuilder.setInPortNumber(Integer.parseInt(ingressNodeConnectorId.getValue().split(":")[2]));
        		eventBuilder.setSwitchId(Integer.parseInt(ingressNodeId.getValue().split(":")[1]));
        		eventBuilder.setPayload(notification.getPayload());
        		if (ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Tcp.getIntValue()){
        			eventBuilder.setStringPayload(extractPayload(ipv4Packet));
        		}
        		else {
        			eventBuilder.setStringPayload("");
        		}
        		//----------------------------------------------------------
        		if (ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Icmp.getIntValue()){
        			IcmpPacketTypeBuilder icmpBuilder = new IcmpPacketTypeBuilder();
        			icmpBuilder.setDestinationAddress(ipv4Packet.getDestinationIpv4() + "/32");
        			icmpBuilder.setSourceAddress(ipv4Packet.getSourceIpv4() + "/32");
        			icmpBuilder.setDscpValue(ipv4Packet.getDscp());
        			icmpBuilder.setEcn(ipv4Packet.getEcn());
        			icmpBuilder.setFragmentOffset(ipv4Packet.getFragmentOffset());
        			icmpBuilder.setHeaderChecksum(ipv4Packet.getChecksum());
        			icmpBuilder.setIdentification(ipv4Packet.getId());
        			icmpBuilder.setIhl(ipv4Packet.getIhl());
        			icmpBuilder.setProtocol((short)ipv4Packet.getProtocol().getIntValue());
        			icmpBuilder.setTotalLength(ipv4Packet.getIpv4Length());
        			icmpBuilder.setTtl(ipv4Packet.getTtl());
        			icmpBuilder.setVersion(ipv4Packet.getVersion());
        			icmpBuilder.setMfFlag(ipv4Packet.isMfFlag() ? true : false);
        			icmpBuilder.setDfFlag(ipv4Packet.isDfFlag() ? true : false);
        			icmpBuilder.setReservedFlag(ipv4Packet.isReservedFlag() ? true : false);
        			icmpBuilder.setIpv4Options(ipv4Packet.getIpv4Options());
        			
        			//---------------------------------
        			IcmpPacketHeader icmpPacket = icmpDecode(ipv4Packet);
        			icmpBuilder.setType(icmpPacket.getType());
        			icmpBuilder.setCode(icmpPacket.getCode());
        			icmpBuilder.setCrc(icmpPacket.getCrc());
        			icmpBuilder.setIdentifier(icmpPacket.getIdentifier());
        			icmpBuilder.setSequenceNumber(icmpPacket.getSequenceNumber());
        			icmpBuilder.setIcmpPayloadLength(icmpPacket.getPayloadLength());
        			icmpBuilder.setIcmpPayloadOffset(icmpPacket.getPayloadOffset());
        			eventBuilder.setPacketType(icmpBuilder.build());
        		}
        		else if (ipv4Packet.getProtocol().getIntValue() == KnownIpProtocols.Tcp.getIntValue()) {
        			TcpPacketHeader tcpPacketHeader = tcpPacketDecode(notification.getPayload());
        			LOG.debug("TCP packet received, Payload {}", notification.getPayload());
        			
        			TcpPacketTypeBuilder tcpPacketTypeBuilder = new TcpPacketTypeBuilder();
        			tcpPacketTypeBuilder.setSourcePort(tcpPacketHeader.getSourcePort());
        			tcpPacketTypeBuilder.setDestPort(tcpPacketHeader.getDestPort());
        			tcpPacketTypeBuilder.setSequenceNumber(tcpPacketHeader.getSequenceNumber());
        			tcpPacketTypeBuilder.setSynFlag(tcpPacketHeader.isSynFlag() ? true : false);
        			tcpPacketTypeBuilder.setFinFlag(tcpPacketHeader.isFinFlag() ? true : false);
        			tcpPacketTypeBuilder.setRstFlag(tcpPacketHeader.isRstFlag()? true : false);
        			tcpPacketTypeBuilder.setAckFlag(tcpPacketHeader.isAckFlag() ? true : false);
        			if (tcpPacketHeader.isSynFlag()){
        				LOG.debug("We have recevied SYN Packet");
        			}
        			
        			tcpPacketTypeBuilder.setDestinationAddress(ipv4Packet.getDestinationIpv4() + "/32");
        			tcpPacketTypeBuilder.setSourceAddress(ipv4Packet.getSourceIpv4() + "/32");
        			tcpPacketTypeBuilder.setDscpValue(ipv4Packet.getDscp());
        			tcpPacketTypeBuilder.setEcn(ipv4Packet.getEcn());
        			tcpPacketTypeBuilder.setFragmentOffset(ipv4Packet.getFragmentOffset());
        			tcpPacketTypeBuilder.setHeaderChecksum(ipv4Packet.getChecksum());
        			tcpPacketTypeBuilder.setIdentification(ipv4Packet.getId());
        			tcpPacketTypeBuilder.setIhl(ipv4Packet.getIhl());
        			tcpPacketTypeBuilder.setProtocol((short)ipv4Packet.getProtocol().getIntValue());
        			tcpPacketTypeBuilder.setTotalLength(ipv4Packet.getIpv4Length());
        			tcpPacketTypeBuilder.setTtl(ipv4Packet.getTtl());
        			tcpPacketTypeBuilder.setVersion(ipv4Packet.getVersion());
        			tcpPacketTypeBuilder.setMfFlag(ipv4Packet.isMfFlag() ? true : false);
        			tcpPacketTypeBuilder.setDfFlag(ipv4Packet.isDfFlag() ? true : false);
        			tcpPacketTypeBuilder.setReservedFlag(ipv4Packet.isReservedFlag() ? true : false);
        			tcpPacketTypeBuilder.setIpv4Options(ipv4Packet.getIpv4Options());
        			eventBuilder.setPacketType(tcpPacketTypeBuilder.build());
        			
        			LOG.debug("The whole TCP Packet is: {}", tcpPacketTypeBuilder.toString());
				}
        		else { ////////////Packet Type IP packet only
        			Ipv4PacketTypeBuilder ipv4Builder = new Ipv4PacketTypeBuilder();
        			ipv4Builder.setDestinationAddress(ipv4Packet.getDestinationIpv4() + "/32");
        			ipv4Builder.setSourceAddress(ipv4Packet.getSourceIpv4() + "/32");
        			ipv4Builder.setDscpValue(ipv4Packet.getDscp());
        			ipv4Builder.setEcn(ipv4Packet.getEcn());
        			ipv4Builder.setFragmentOffset(ipv4Packet.getFragmentOffset());
        			ipv4Builder.setHeaderChecksum(ipv4Packet.getChecksum());
        			ipv4Builder.setIdentification(ipv4Packet.getId());
        			ipv4Builder.setIhl(ipv4Packet.getIhl());
        			ipv4Builder.setProtocol((short)ipv4Packet.getProtocol().getIntValue());
        			ipv4Builder.setTotalLength(ipv4Packet.getIpv4Length());
        			ipv4Builder.setTtl(ipv4Packet.getTtl());
        			ipv4Builder.setVersion(ipv4Packet.getVersion());
        			ipv4Builder.setMfFlag(ipv4Packet.isMfFlag() ? true : false);
        			ipv4Builder.setDfFlag(ipv4Packet.isDfFlag() ? true : false);
        			ipv4Builder.setReservedFlag(ipv4Packet.isReservedFlag() ? true : false);
        			ipv4Builder.setIpv4Options(ipv4Packet.getIpv4Options());
        			eventBuilder.setPacketType(ipv4Builder.build());
        		}
        	}
            ///////////////////////////////////////////////////////////////////
            //Check the packet_in Reason
            //PacketInReason.OFPRNOMATCH.getIntValue();
            if (notification.getPacketInReason().getName().
        			equals("org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.NoMatch")){
            	//LOG.debug("         ---------------------------------------------------------------------     ");
            	//LOG.debug("Packet_IN is called because of NoMatch Reason");
            	//LOG.debug("         ---------------------------------------------------------------------     ");
            	eventBuilder.setTriggeredEventType(TriggeredEventType.NoFlowRuleEvent);
        		//this.notificationService.publish(eventBuilder.build());
        		this.activeSDNAssignment.onEventTriggered(eventBuilder.build());
            	
            }
            else if (notification.getPacketInReason().getName().
    			equals("org.opendaylight.yang.gen.v1.urn.opendaylight.packet.service.rev130709.SendToController")){     	
        	//LOG.debug("         ---------------------------------------------------------------------     ");
        	//LOG.debug("Packet_IN is called because of Signature Event Reason");
        	//LOG.debug("         ---------------------------------------------------------------------     ");

        	//String cookieId = ingressNodeId.toString() + "." + notification.getFlowCookie().toString();
        	String cookieId = notification.getFlowCookie().toString(); //as we don't add nodeId to cookieId anymore
        	//may because like flowID, the switch doesn't support user defined strings
			//long second = date.getSeconds();
			long timeMillis = System.currentTimeMillis();
			long second = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
			Cookie cookie;
			Tap tap;
			String flowId;
			String tapId;
			boolean notify = false;
			boolean block = false;
			boolean limitRate = false;
			boolean dropandnotify = false;
             
             if (eventMap.containsKey(cookieId)){
             	if (eventMap.get(cookieId).detectEvent(second) == true){ //providing seconds as arguments
             		if (eventMap.get(cookieId).getBlockValue() == true){
             			//We have to drop the packet and any subsequent packets as well.
             			ApplyActionsBuilder aab = new ApplyActionsBuilder();
             	        ActionBuilder ab = new ActionBuilder();
             	        List<Action> actionList = Lists.newArrayList();

             	        ActionBuilder abDrop = new ActionBuilder();
             	        DropActionBuilder dropActionBuilder = new DropActionBuilder();
             	        abDrop.setAction(new DropActionCaseBuilder().setDropAction(dropActionBuilder.build()).build());
             	        abDrop.setOrder(0);
             	        abDrop.setKey(new ActionKey(0));
             	        actionList.add(abDrop.build());
             	        packetOut(ingressNodeRef, notification.getPayload(), actionList, ingressNodeConnectorRef, tableNodeConnectorRef);
             	       
             		} else if (eventMap.get(cookieId).getDropAndNotify() == true){
              		    //We have to drop the packet and any subsequent packets as well.
              			ApplyActionsBuilder aab = new ApplyActionsBuilder();
              	        ActionBuilder ab = new ActionBuilder();
              	        List<Action> actionList = Lists.newArrayList();

              	        ActionBuilder abDrop = new ActionBuilder();
              	        DropActionBuilder dropActionBuilder = new DropActionBuilder();
              	        abDrop.setAction(new DropActionCaseBuilder().setDropAction(dropActionBuilder.build()).build());
              	        abDrop.setOrder(0);
              	        abDrop.setKey(new ActionKey(0));
              	        actionList.add(abDrop.build());
              	        packetOut(ingressNodeRef, notification.getPayload(), actionList, ingressNodeConnectorRef, tableNodeConnectorRef);
              	        if (this.currentWait++ >= this.watiBeforeNotifying) {
	              	        //eventMap.get(cookieId).resetEventCounter(second);
	              	        eventBuilder.setTriggeredEventType(TriggeredEventType.SubscribedEvent);
	              	        eventBuilder.setEventId(eventMap.get(cookieId).getFlowId());
	              	        this.currentWait = 0;
	              	        this.activeSDNAssignment.onEventTriggered(eventBuilder.build());
              	        }
             		}
             		//End of If it should be blocked or report 
             		else if (eventMap.get(cookieId).getNotifyValue() == true){
             			//LOG.debug("         ---------------------------------------------------------------------     ");
             			//LOG.debug("Notification is reaised about the event.");
             			//LOG.debug("         ---------------------------------------------------------------------     ");
             			//----------------------------------------------------
             			 List<Action> actionList = Lists.newArrayList();
                         // Set TOS to precedence 1: immediate so that it doesn't trigger the same signature flow rule again
                         ActionBuilder ab = new ActionBuilder();
                         SetNwTosActionBuilder setTosBuilder = new SetNwTosActionBuilder();
                         int tos = 32;
                         setTosBuilder.setTos(tos);
                         ab.setAction(new SetNwTosActionCaseBuilder().setSetNwTosAction(setTosBuilder.build()).build());
                         ab.setOrder(0);
                         ab.setKey(new ActionKey(0));
                         actionList.add(ab.build());
                         //payload[TOS_POSITION] = (byte)tos;
                         //LOG.debug("         ---------------------------------------------------------------------     ");
              			 //LOG.debug("Forwarding packet after event notification.");
              			 //LOG.debug("         ---------------------------------------------------------------------     ");
                         // Set output action
                         //ActionBuilder abOutput = new ActionBuilder();
                         OutputActionBuilder output = new OutputActionBuilder();
                         output.setOutputNodeConnector(tableNodeConnectorId);
                         output.setMaxLength(65535); //Send full packet and No buffer
                         ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                         ab.setOrder(1);
                         ab.setKey(new ActionKey(1));
                         actionList.add(ab.build());
                         packetOut(ingressNodeRef, notification.getPayload(), actionList,ingressNodeConnectorRef, tableNodeConnectorRef);
             			//------------------------------------------------------
                         eventMap.get(cookieId).resetEventCounter(second);
             			eventBuilder.setTriggeredEventType(TriggeredEventType.SubscribedEvent);
             			eventBuilder.setEventId(eventMap.get(cookieId).getFlowId());
                		//this.notificationService.publish(eventBuilder.build());
                		this.activeSDNAssignment.onEventTriggered(eventBuilder.build());
             		} // End of Else part of the If whether it should be blocked or reported
             		else if (eventMap.get(cookieId).getRateLimit() == true){
             			InstanceIdentifier<Tap> tapIID = InstanceIdentifier.builder(TapSpec.class)
                         		.child(Tap.class, new TapKey(eventMap.get(cookieId).getTapId()))
                         		.build();
                         tap = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, tapIID);
                         if (tap == null) {
                        	 LOG.debug("         ---------------------------------------------------------------------     ");
                        	 LOG.debug("Strangly there is no tap of value {}.", eventMap.get(cookieId).getTapId());
                        	 LOG.debug("         ---------------------------------------------------------------------     ");
                         } 
                         else {
                        	 InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
                             		.child(Node.class, new NodeKey(tap.getNode()))
                             		.augmentation(FlowCapableNode.class)
                             		.child(Table.class, new TableKey((short)0))
                             		.child(Flow.class, new FlowKey(new FlowId(eventMap.get(cookieId).getFlowId())))
                             		.build();
                        	 Flow flow = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID);
                        	 if (flow != null){
                        		 programRateLimitingFlowRule(tap.getNode(), flow, tap, ingressNodeConnectorId);
                        		 
                      	         ActionBuilder ab = new ActionBuilder();
                      	         List<Action> actionList = Lists.newArrayList();
                      	        
                        		 //LOG.debug("         ---------------------------------------------------------------------     ");
                        		 //LOG.debug("Forwarding packet after installing new Meter.");
                        		 //LOG.debug("         ---------------------------------------------------------------------     ");
                                 // Set output action
                                 //ActionBuilder abOutput = new ActionBuilder();
                                 OutputActionBuilder output = new OutputActionBuilder();
                                 output.setOutputNodeConnector(tableNodeConnectorId);
                                 output.setMaxLength(65535); //Send full packet and No buffer
                                 ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                                 ab.setOrder(1);
                                 ab.setKey(new ActionKey(1));
                                 actionList.add(ab.build());
                                 packetOut(ingressNodeRef, notification.getPayload(), actionList,ingressNodeConnectorRef, tableNodeConnectorRef);
                        	 }
                        	 
                         }
                         
             		}
             	} // End of detect event if
             	else{ //Event has not yet occurred so we have to forward the packet normally                   
                    List<Action> actionList = Lists.newArrayList();
                    // Set TOS to precedence 1: immediate so that it doesn't trigger the same signature flow rule again
                    ActionBuilder ab = new ActionBuilder();
                    SetNwTosActionBuilder setTosBuilder = new SetNwTosActionBuilder();
                    int tos = 32;
                    setTosBuilder.setTos(tos);
                    ab.setAction(new SetNwTosActionCaseBuilder().setSetNwTosAction(setTosBuilder.build()).build());
                    ab.setOrder(0);
                    ab.setKey(new ActionKey(0));
                    actionList.add(ab.build());
                    //payload[TOS_POSITION] = (byte)tos;
                    //LOG.debug("         ---------------------------------------------------------------------     ");
         			//LOG.debug("No Event now forwarding packet.");
         			//LOG.debug("         ---------------------------------------------------------------------     ");
                    // Set output action
                    //ActionBuilder abOutput = new ActionBuilder();
                    OutputActionBuilder output = new OutputActionBuilder();
                    output.setOutputNodeConnector(tableNodeConnectorId);
                    output.setMaxLength(65535); //Send full packet and No buffer
                    ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                    ab.setOrder(1);
                    ab.setKey(new ActionKey(1));
                    actionList.add(ab.build());
                    packetOut(ingressNodeRef, notification.getPayload(), actionList,ingressNodeConnectorRef, tableNodeConnectorRef);
             	}
             } // End of check if already contain this event in local map now handing else part 
             else {
             	InstanceIdentifier<Cookie> cookieIID = InstanceIdentifier.builder(CookieToFlowid.class)
                 		.child(Cookie.class, new CookieKey(cookieId))
                 		.build();
                 cookie = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, cookieIID);
                 if (cookie == null) {
                	 //LOG.debug("         ---------------------------------------------------------------------     ");
                	 //LOG.debug("There is no cookie present and Packet_IN is called explicitly by some other flow rule than signature.");
                	 //LOG.debug("         ---------------------------------------------------------------------     ");
                	 eventBuilder.setTriggeredEventType(TriggeredEventType.ControllerFlowRuleEvent);
                	 eventBuilder.setEventId(cookieId);
                	 //this.notificationService.publish(eventBuilder.build());
             		 this.activeSDNAssignment.onEventTriggered(eventBuilder.build());
                 }
                 else {
                	 tapId = cookie.getTapid();
                     InstanceIdentifier<Tap> tapIID = InstanceIdentifier.builder(TapSpec.class)
                     		.child(Tap.class, new TapKey(tapId))
                     		.build();
                     tap = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, tapIID);
                     if (tap == null) {
                    	 LOG.debug("         ---------------------------------------------------------------------     ");
                    	 LOG.debug("Strangly there is no tap of value {}.", tapId);
                    	 LOG.debug("         ---------------------------------------------------------------------     ");
                    	 return;
                     }
                     flowId = cookie.getFlowid();
                     if (tap.getTapActions() instanceof BlockCase) {
                    	 block = true;
                     }
                  	 else if (tap.getTapActions() instanceof NotifyCase){
                  		 notify = true;
                  	 }
                  	 else if (tap.getTapActions() instanceof SetRateLimitEventCase){
                  		 limitRate = true;
                  	 }
                  	 else if (tap.getTapActions() instanceof DropAndNotifyCase){
                  		DropAndNotifyCase notifycase = (DropAndNotifyCase) tap.getTapActions(); 
                  		 this.watiBeforeNotifying = notifycase.getDropAndNotify().getHoldNotification();
                  		 dropandnotify = true;
                  	 }
                     EventDetection eventDetection = new EventDetection(tapId, 
                    		 flowId, tap.getCount(), tap.getDuration(), block, notify, limitRate, dropandnotify);
                     eventMap.put(cookieId, eventDetection);
                     if (eventMap.get(cookieId).detectEvent(second) == true)
                     {
                    	 if (eventMap.get(cookieId).getBlockValue() == true){
                  			//We have to drop the packet and any subsequent packets as well.
                  			ApplyActionsBuilder aab = new ApplyActionsBuilder();
                  	        ActionBuilder ab = new ActionBuilder();
                  	        List<Action> actionList = Lists.newArrayList();

                  	        ActionBuilder abDrop = new ActionBuilder();
                  	        DropActionBuilder dropActionBuilder = new DropActionBuilder();
                  	        abDrop.setAction(new DropActionCaseBuilder().setDropAction(dropActionBuilder.build()).build());
                  	        abDrop.setOrder(0);
                  	        abDrop.setKey(new ActionKey(0));
                  	        actionList.add(abDrop.build());
                  	        packetOut(ingressNodeRef, notification.getPayload(), actionList, ingressNodeConnectorRef, tableNodeConnectorRef);
                  		} else if (eventMap.get(cookieId).getDropAndNotify() == true){
                  		    //We have to drop the packet and any subsequent packets as well.
                  			ApplyActionsBuilder aab = new ApplyActionsBuilder();
                  	        ActionBuilder ab = new ActionBuilder();
                  	        List<Action> actionList = Lists.newArrayList();

                  	        ActionBuilder abDrop = new ActionBuilder();
                  	        DropActionBuilder dropActionBuilder = new DropActionBuilder();
                  	        abDrop.setAction(new DropActionCaseBuilder().setDropAction(dropActionBuilder.build()).build());
                  	        abDrop.setOrder(0);
                  	        abDrop.setKey(new ActionKey(0));
                  	        actionList.add(abDrop.build());
                  	        packetOut(ingressNodeRef, notification.getPayload(), actionList, ingressNodeConnectorRef, tableNodeConnectorRef);
                  	        if (this.currentWait++ >= this.watiBeforeNotifying) {
	                  	        //eventMap.get(cookieId).resetEventCounter(second);
	                  	        eventBuilder.setTriggeredEventType(TriggeredEventType.SubscribedEvent);
	                  	        eventBuilder.setEventId(eventMap.get(cookieId).getFlowId());
	                  	        this.currentWait = 0;
	                  	        this.activeSDNAssignment.onEventTriggered(eventBuilder.build());
                  	        }
                  	        
                  		} else if (eventMap.get(cookieId).getNotifyValue() == true){
                 			//LOG.debug("         ---------------------------------------------------------------------     ");
                 			//LOG.debug("Notification is reaised about the event.");
                 			//LOG.debug("         ---------------------------------------------------------------------     ");
                 			//-----------------------------------------------
                 			List<Action> actionList = Lists.newArrayList();
                            // Set TOS to precedence 1: immediate so that it doesn't trigger the same signature flow rule again
                            ActionBuilder ab = new ActionBuilder();
                            SetNwTosActionBuilder setTosBuilder = new SetNwTosActionBuilder();
                            int tos = 32;
                            setTosBuilder.setTos(tos);
                            ab.setAction(new SetNwTosActionCaseBuilder().setSetNwTosAction(setTosBuilder.build()).build());
                            ab.setOrder(0);
                            ab.setKey(new ActionKey(0));
                            actionList.add(ab.build());
                            //payload[TOS_POSITION] = (byte)tos;
                            //LOG.debug("         ---------------------------------------------------------------------     ");
                 			//LOG.debug("Forwarding packet after event notification.");
                 			//LOG.debug("         ---------------------------------------------------------------------     ");
                            // Set output action
                            //ActionBuilder abOutput = new ActionBuilder();
                            OutputActionBuilder output = new OutputActionBuilder();
                            output.setOutputNodeConnector(tableNodeConnectorId);
                            output.setMaxLength(65535); //Send full packet and No buffer
                            ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                            ab.setOrder(1);
                            ab.setKey(new ActionKey(1));
                            actionList.add(ab.build());
                            packetOut(ingressNodeRef, notification.getPayload(), actionList,ingressNodeConnectorRef, tableNodeConnectorRef);
                 			//-----------------------------------------------
                            eventMap.get(cookieId).resetEventCounter(second);
                 			eventBuilder.setTriggeredEventType(TriggeredEventType.SubscribedEvent);
                 			eventBuilder.setEventId(eventMap.get(cookieId).getFlowId());
                 			//this.notificationService.publish(eventBuilder.build());
                    		this.activeSDNAssignment.onEventTriggered(eventBuilder.build());
                 		} // End of Else part of the If whether it should be blocked or reported
                 		else if (eventMap.get(cookieId).getRateLimit() == true){
                        	 InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
                             		.child(Node.class, new NodeKey(tap.getNode()))
                             		.augmentation(FlowCapableNode.class)
                             		.child(Table.class, new TableKey((short)0))
                             		.child(Flow.class, new FlowKey(new FlowId(eventMap.get(cookieId).getFlowId())))
                             		.build();
                        	 Flow flow = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID);
                        	 if (flow != null){
                        		 programRateLimitingFlowRule(tap.getNode(), flow, tap, ingressNodeConnectorId);
                        		 
                      	         ActionBuilder ab = new ActionBuilder();
                      	         List<Action> actionList = Lists.newArrayList();
                      	        
                        		 //LOG.debug("         ---------------------------------------------------------------------     ");
                        		 //LOG.debug("Forwarding packet after installing new Meter.");
                        		 //LOG.debug("         ---------------------------------------------------------------------     ");
                                 // Set output action
                                 //ActionBuilder abOutput = new ActionBuilder();
                                 OutputActionBuilder output = new OutputActionBuilder();
                                 output.setOutputNodeConnector(tableNodeConnectorId);
                                 output.setMaxLength(65535); //Send full packet and No buffer
                                 ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                                 ab.setOrder(1);
                                 ab.setKey(new ActionKey(1));
                                 actionList.add(ab.build());
                                 packetOut(ingressNodeRef, notification.getPayload(), actionList,ingressNodeConnectorRef, tableNodeConnectorRef);
                        	 }
                 		} // End of Block if
                     } // End if event detected 
                     else{ //Event is not triggered so forward the packet normally
                    	 List<Action> actionList = Lists.newArrayList();
                         // Set TOS to precedence 1: immediate so that it doesn't trigger the same signature flow rule again
                         ActionBuilder ab = new ActionBuilder();
                         SetNwTosActionBuilder setTosBuilder = new SetNwTosActionBuilder();
                         int tos = 32;
                         setTosBuilder.setTos(tos);
                         ab.setAction(new SetNwTosActionCaseBuilder().setSetNwTosAction(setTosBuilder.build()).build());
                         ab.setOrder(0);
                         ab.setKey(new ActionKey(0));
                         actionList.add(ab.build());
                         //payload[TOS_POSITION] = (byte)tos;
                         //LOG.debug("         ---------------------------------------------------------------------     ");
              			 //LOG.debug("No Event now forwarding packet.");
              			 //LOG.debug("         ---------------------------------------------------------------------     ");
                         // Set output action
                         //ActionBuilder abOutput = new ActionBuilder();
                         OutputActionBuilder output = new OutputActionBuilder();
                         output.setOutputNodeConnector(tableNodeConnectorId);
                         output.setMaxLength(60); //Send full packet and No buffer
                         ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                         ab.setOrder(1);
                         ab.setKey(new ActionKey(1));
                         actionList.add(ab.build());
                         packetOut(ingressNodeRef, notification.getPayload(), actionList, ingressNodeConnectorRef, tableNodeConnectorRef);
                     }
                 } // End of else checking if Tap was present or not.                
             } //
        } //End Packet_IN Controller Reason

     }
 
     
    }
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    private void packetOut(NodeRef egressNodeRef, byte[] payload, List<Action> actionList, 
			NodeConnectorRef ingressNodeConnectorRef, NodeConnectorRef egressNodeConnectorRef) {
		Preconditions.checkNotNull(packetProcessingService);
        
		
		TransmitPacketInputBuilder inputbuilder = new TransmitPacketInputBuilder();
        inputbuilder.setPayload(payload);
        if (actionList != null) inputbuilder.setAction(actionList);
        inputbuilder.setNode(egressNodeRef);
        inputbuilder.setEgress(egressNodeConnectorRef);
        //inputbuilder.setEgress(tableNodeConnectorRef);
        inputbuilder.setIngress(ingressNodeConnectorRef);
        
        
        TransmitPacketInput input = inputbuilder.build();
 
        packetProcessingService.transmitPacket(input);
	
               
		//LOG.debug("         ---------------------------------------------------------------------     ");
		//LOG.debug("Packet_out is sent on egress port  " + egressNodeConnectorRef.getValue());
		//LOG.debug("         ---------------------------------------------------------------------     ");
    }    
    
    /////////////////////////////////////////////////////////////////////////////////////	
    private void programRateLimitingFlowRule(NodeId nodeId, Flow flow, Tap tap, 
    		NodeConnectorId ingressNodeConnectorId) {
    	
    	SetRateLimitEventCase rateLimitCase = (SetRateLimitEventCase) tap.getTapActions();
    	NodeConnectorId egressNodeConnectorId = rateLimitCase.getSetRateLimitAction().getEgressPort(); 
    			//rateLimitCase.getSetRateLimit()
		////////////-----------------------------------------------------
    	/// Generate a meter of the given specification
    	////////////------------------------------------------------------
		MeterId mID = new MeterId((long) 100 + meterId.incrementAndGet());
	    String meterName = "NodeId_" + tap.getNode().getValue() + "_Meter_" + mID.getValue();
	     
	    switch (rateLimitCase.getSetRateLimitAction().getMeterType()){
	    case MeterKbps:
	    	InventoryUtils.createMeter(dataBroker, tap.getNode(), mID.getValue(), meterName, 
     			rateLimitCase.getSetRateLimitAction().getBandRate(), 
     			rateLimitCase.getSetRateLimitAction().getBandBurstSize(), 
     			rateLimitCase.getSetRateLimitAction().getDropRate(),
     			rateLimitCase.getSetRateLimitAction().getDropBurstSize(), InventoryUtils.EnumMeterFlags.KBPS);
 		break;
 		case MeterPktps:
 			InventoryUtils.createMeter(dataBroker, tap.getNode(), mID.getValue(), meterName, 
     			rateLimitCase.getSetRateLimitAction().getBandRate(), 
     			rateLimitCase.getSetRateLimitAction().getBandBurstSize(), 
     			rateLimitCase.getSetRateLimitAction().getDropRate(),
     			rateLimitCase.getSetRateLimitAction().getDropBurstSize(), InventoryUtils.EnumMeterFlags.PKPTS);
 			break;
 		case MeterBurst:
 			InventoryUtils.createMeter(dataBroker, tap.getNode(), mID.getValue(), meterName, 
     			rateLimitCase.getSetRateLimitAction().getBandRate(), 
     			rateLimitCase.getSetRateLimitAction().getBandBurstSize(), 
     			rateLimitCase.getSetRateLimitAction().getDropRate(),
     			rateLimitCase.getSetRateLimitAction().getDropBurstSize(), InventoryUtils.EnumMeterFlags.BURSTS);
 			break;
 		case MeterStats:
 			InventoryUtils.createMeter(dataBroker, tap.getNode(), mID.getValue(), meterName, 
     			rateLimitCase.getSetRateLimitAction().getBandRate(), 
     			rateLimitCase.getSetRateLimitAction().getBandBurstSize(), 
     			rateLimitCase.getSetRateLimitAction().getDropRate(),
     			rateLimitCase.getSetRateLimitAction().getDropBurstSize(), InventoryUtils.EnumMeterFlags.STATS);
 			break;
 		}
	    
	    int instructionIndex = 0;
        // Instructions List Stores Individual Instructions
        InstructionsBuilder isb = new InstructionsBuilder();
        List<Instruction> instructions = Lists.newArrayList();
        InstructionBuilder ib = new InstructionBuilder();
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        ActionBuilder ab = new ActionBuilder();
        List<Action> actionList = Lists.newArrayList();
        
        org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.
	    instruction.instruction.meter._case.MeterBuilder meterB = new org.opendaylight.
	    yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.meter._case.MeterBuilder();
	    meterB.setMeterId(mID);
        
        ib.setInstruction(new MeterCaseBuilder().setMeter(meterB.build()).build());
        ib.setOrder(instructionIndex);
        ib.setKey(new InstructionKey(instructionIndex++));
        instructions.add(ib.build());

        
        // Set output action
        OutputActionBuilder output = new OutputActionBuilder();
        output.setOutputNodeConnector(egressNodeConnectorId);
        output.setMaxLength(65535); //Send full packet and No buffer
        ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
        ab.setOrder(0);
        ab.setKey(new ActionKey(0));
        actionList.add(ab.build());
        
        // Create Apply Actions Instruction
        aab.setAction(actionList);
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setOrder(instructionIndex);
        ib.setKey(new InstructionKey(instructionIndex++));
        instructions.add(ib.build());

        // Create Flow
        FlowBuilder flowBuilder = new FlowBuilder();
        flowBuilder.setMatch(flow.getMatch());

        flowBuilder.setId(flow.getId());
        flowBuilder.setBarrier(true);
        flowBuilder.setTableId((short)0);
        flowBuilder.setKey(flow.getKey());
        flowBuilder.setPriority(3000);
        flowBuilder.setFlowName(flow.getFlowName());
        flowBuilder.setHardTimeout(0);
        flowBuilder.setIdleTimeout(0);
        flowBuilder.setInstructions(isb.setInstruction(instructions).build());
        

        InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
                .child(Node.class, new NodeKey(nodeId))
                .augmentation(FlowCapableNode.class)
                .child(Table.class, new TableKey(flowBuilder.getTableId()))
                .child(Flow.class, flowBuilder.getKey())
                .build();
        GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), true);
    }
    
    /////////////////////////////////////////////////////////////////////////////////////	
    private void programL2Flow(NodeId nodeId, String dstMac, NodeConnectorId ingressNodeConnectorId, NodeConnectorId egressNodeConnectorId) {
    	
    
        //Creating match object
        MatchBuilder matchBuilder = new MatchBuilder();
        MatchUtils.createEthDstMatch(matchBuilder, new MacAddress(dstMac), null);
        MatchUtils.createInPortMatch(matchBuilder, ingressNodeConnectorId);

        // Instructions List Stores Individual Instructions
        InstructionsBuilder isb = new InstructionsBuilder();
        List<Instruction> instructions = Lists.newArrayList();
        InstructionBuilder ib = new InstructionBuilder();
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        ActionBuilder ab = new ActionBuilder();
        List<Action> actionList = Lists.newArrayList();

        
        // Set output action
        OutputActionBuilder output = new OutputActionBuilder();
        output.setOutputNodeConnector(egressNodeConnectorId);
        output.setMaxLength(65535); //Send full packet and No buffer
        ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
        ab.setOrder(0);
        ab.setKey(new ActionKey(0));
        actionList.add(ab.build());
        
      
        // Create Apply Actions Instruction
        aab.setAction(actionList);
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setOrder(0);
        ib.setKey(new InstructionKey(0));
        instructions.add(ib.build());

        // Create Flow
        FlowBuilder flowBuilder = new FlowBuilder();
        flowBuilder.setMatch(matchBuilder.build());

        String flowId = "L2_Rule_" + dstMac;
        flowBuilder.setId(new FlowId(flowId));
        FlowKey key = new FlowKey(new FlowId(flowId));
        flowBuilder.setBarrier(true);
        flowBuilder.setTableId((short)0);
        flowBuilder.setKey(key);
        flowBuilder.setPriority(32768);
        flowBuilder.setFlowName(flowId);
        flowBuilder.setHardTimeout(0);
        flowBuilder.setIdleTimeout(0);
        flowBuilder.setInstructions(isb.setInstruction(instructions).build());
        

        InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
                .child(Node.class, new NodeKey(nodeId))
                .augmentation(FlowCapableNode.class)
                .child(Table.class, new TableKey(flowBuilder.getTableId()))
                .child(Flow.class, flowBuilder.getKey())
                .build();
        GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), true);
    }
   /*
	@Override
	public void onPacketReceived(PacketReceived notification) {
		// TODO Auto-generated method stub
		
	}
	 */
	@Override
	public void onNodeExperimenterErrorNotification(
			NodeExperimenterErrorNotification notification) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onNodeErrorNotification(NodeErrorNotification notification) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFlowRemoved(FlowRemoved notification) {
		//FlowIsRemovedBuilder flowRemovedBuilder = new FlowIsRemovedBuilder();
		//NodeRef nodeRef = notification.getNode();
		//NodeId nodeId = nodeRef.getValue()
		//        .firstKeyOf(Node.class, NodeKey.class)
		////        .getId();
		//flowRemovedBuilder.setSwitchId(Integer.parseInt(nodeId.getValue().split(":")[1]));
		//flowRemovedBuilder.setFlowId(notification.getFlowName());
		//this.activeSDNAssignment.onFlowIsRemoved(flowRemovedBuilder.build());
		
	}
	@Override
	public void onFlowAdded(FlowAdded notification) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSwitchFlowRemoved(SwitchFlowRemoved notification) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFlowUpdated(FlowUpdated notification) {
		// TODO Auto-generated method stub
		
	}
}
