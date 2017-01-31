/*
 * Copyright (C) 2014 SDN Hub

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
package org.sdnhub.odl.tutorial.utils.inventory;


import java.util.ArrayList;
import java.util.List;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.meters.Meter;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.meters.MeterBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.meters.MeterKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.service.rev130918.AddMeterInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.service.rev130918.RemoveMeterInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.service.rev130918.UpdateMeterInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.BandId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.MeterBandType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.MeterFlags;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.MeterId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.band.type.band.type.DropBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.meter.MeterBandHeaders;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.meter.MeterBandHeadersBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.meter.meter.band.headers.MeterBandHeader;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.meter.meter.band.headers.MeterBandHeaderBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.meter.meter.band.headers.meter.band.header.MeterBandTypes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.meter.meter.band.headers.meter.band.header.MeterBandTypesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.band.type.band.type.Drop;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.band.type.band.type.DropBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.band.type.band.type.DscpRemarkBuilder;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.sdnhub.odl.tutorial.utils.GenericTransactionUtils;



//////////////////////////////////------------------------/////////////////
public final class InventoryUtils {
    public static final String OPENFLOW_NODE_PREFIX = "openflow:";
    public enum EnumMeterFlags {
    	KBPS,
        PKPTS,
        BURSTS,
        STATS
    }

    public static NodeRef getNodeRef(NodeId nodeId) {
        return new NodeRef(InstanceIdentifier.builder(Nodes.class)
            .child(Node.class, new NodeKey(nodeId))
            .build());
    }

	public static NodeRef getNodeRef(NodeConnectorRef nodeConnectorRef) {
        InstanceIdentifier<Node> nodeIID = nodeConnectorRef.getValue()
    		.firstIdentifierOf(Node.class);
        return new NodeRef(nodeIID);
	}

    public static NodeBuilder getNodeBuilder(NodeId nodeId) {
        NodeBuilder builder = new NodeBuilder()
        	.setId(nodeId)
        	.setKey(new NodeKey(nodeId));
        return builder;
    }

    public static NodeBuilder getNodeBuilder(String dpid) {
        String nodeName = OPENFLOW_NODE_PREFIX + dpid;
        NodeBuilder builder = new NodeBuilder();
        builder.setId(new NodeId(nodeName));
        builder.setKey(new NodeKey(builder.getId()));
        return builder;
    }

	public static NodeId getNodeId(NodeConnectorRef nodeConnectorRef) {
		return nodeConnectorRef.getValue()
	        .firstKeyOf(Node.class, NodeKey.class)
	        .getId();
	}
	
    public static NodeId getNodeId(NodeConnectorId nodeConnectorId) {
    	if (nodeConnectorId == null)
    		return null;
    	String[] tokens = nodeConnectorId.getValue().split(":");
    	if (tokens.length == 3)
    		return new NodeId(OPENFLOW_NODE_PREFIX + Long.parseLong(tokens[1]));
    	else
    		return null;
    }

    public static NodeConnectorId getNodeConnectorId(NodeId nodeId, long portNumber) {
    	if (nodeId == null)
    		return null;
    	String nodeConnectorIdStr = nodeId.getValue() + ":" + portNumber;
		return new NodeConnectorId(nodeConnectorIdStr);
    }

    public static NodeConnectorRef getNodeConnectorRef(NodeConnectorId nodeConnectorId) {
    	NodeId nodeId = getNodeId(nodeConnectorId);
        return new NodeConnectorRef(InstanceIdentifier.builder(Nodes.class)
                .child(Node.class, new NodeKey(nodeId))
                .child(NodeConnector.class, new NodeConnectorKey(nodeConnectorId))
                .build());
    }

    public static NodeConnectorBuilder getNodeConnectorBuilder(NodeConnectorId nodeConnectorId) {
        NodeConnectorBuilder builder = new NodeConnectorBuilder()
        	.setId(nodeConnectorId)
        	.setKey(new NodeConnectorKey(nodeConnectorId));
        return builder;
    }

	public static NodeConnectorId getNodeConnectorId(NodeConnectorRef nodeConnectorRef) {
        return nodeConnectorRef.getValue()
            .firstKeyOf(NodeConnector.class, NodeConnectorKey.class)
            .getId();
	}
	
	 public static NodeConnectorRef getControllerNodeConnectorRef(NodeId nodeId) {
	        return new NodeConnectorRef(InstanceIdentifier.builder(Nodes.class)
	                .child(Node.class, new NodeKey(nodeId))
	                .child(NodeConnector.class, new NodeConnectorKey(new NodeConnectorId(nodeId.getValue() + ":CONTROLLER")))
	                .build());
	        
	        //NodeConnectorRef ncRef = new NodeConnectorRef(InstanceIdentifier.<Nodes>builder(Nodes.class)
	        //        .<Node, NodeKey>child(Node.class, node.getKey())
	        //        .<NodeConnector, NodeConnectorKey>child(NodeConnector.class,
	        //                new NodeConnectorKey(new NodeConnectorId(node.getId().getValue() + ":LOCAL")))
	        //        .build());
	 }
	 
	 public static NodeConnectorRef getTableNodeConnectorRef(NodeId nodeId) {
	        return new NodeConnectorRef(InstanceIdentifier.builder(Nodes.class)
	                .child(Node.class, new NodeKey(nodeId))
	                .child(NodeConnector.class, new NodeConnectorKey(new NodeConnectorId(nodeId.getValue() + ":TABLE")))
	                .build());

	 }
	 
	 public static NodeConnectorRef getFloodNodeConnectorRef(NodeId nodeId) {
	        return new NodeConnectorRef(InstanceIdentifier.builder(Nodes.class)
	                .child(Node.class, new NodeKey(nodeId))
	                .child(NodeConnector.class, new NodeConnectorKey(new NodeConnectorId(nodeId.getValue() + ":FLOOD")))
	                .build());

	 }
	
	public static Meter createMeter(DataBroker dataBroker, NodeId nodeId, long meterId, String meterName,
			long bandRate, long bandBurstSize,
			long dropRate, long burstSize, EnumMeterFlags meterFlag){
		
		//This functions creates a meter that is installed in the switch
		/*    
	    MeterBandTypesBuilder meterBandTypesBuilder = new MeterBandTypesBuilder();

	    MeterBandType meterBandType = new MeterBandType(true,false,false);
        meterBandTypesBuilder.setFlags(meterBandType);
        
        DropBuilder drop = new DropBuilder();
        drop.setDropBurstSize(burstSize);
        drop.setDropRate(dropRate);
        Drop drp = drop.build();
        
        MeterBandHeaderBuilder meterBandHeaderBuilder = new MeterBandHeaderBuilder();
        meterBandHeaderBuilder.setBandId(new BandId((long)1));
        meterBandHeaderBuilder.setBandType(drp);
        meterBandHeaderBuilder.setBandBurstSize(bandBurstSize);
        meterBandHeaderBuilder.setBandRate(bandRate);
        meterBandHeaderBuilder.setMeterBandTypes(meterBandTypesBuilder.build());
        
        MeterBandHeader mbh = meterBandHeaderBuilder.build();
        
        List<MeterBandHeader> meterBandList = new ArrayList<MeterBandHeader>();
        meterBandList.add(mbh);
        
        MeterBandHeadersBuilder mbhsBuilder = new MeterBandHeadersBuilder();
        mbhsBuilder.setMeterBandHeader(meterBandList);
        
        MeterBandHeaders mbheaders = mbhsBuilder.build();
	    
        MeterBuilder meterBuilder = new MeterBuilder();
        meterBuilder.setMeterBandHeaders(mbheaders);

        MeterId mID = new MeterId(meterId);
		MeterKey meterKey = new MeterKey(mID);
                
        meterBuilder.setKey(meterKey);
        meterBuilder.setMeterId(mID);
        meterBuilder.setMeterName(meterName);
        meterBuilder.setContainerName(meterName);

 
        MeterFlags flagV = null;
        switch (meterFlag) {
        case KBPS:
        	flagV = new MeterFlags(false, true, false, false);
            break;
        case PKPTS:
        	flagV = new MeterFlags(false, false, true, false);
            break;
        case BURSTS:
        	flagV = new MeterFlags(true, false, false, false);
            break;
        case STATS:
        	flagV = new MeterFlags(false, false, false, true);
            break;
        }
     
        meterBuilder.setFlags(flagV);
        
	    InstanceIdentifier<Meter> meterIID = InstanceIdentifier.builder(Nodes.class)
	    	 .child(Node.class, new NodeKey(nodeId))
	    	 .augmentation(FlowCapableNode.class)
	    	 .child(Meter.class, meterKey)
	    	 .build();
	    
	    GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, 
	    		meterIID, meterBuilder.build(), true);
	   
        return meterBuilder.build();
        */
		
		 	long id = 12;
		 	String originalMeterName = "Foo";
	        MeterKey key = new MeterKey(new MeterId(id));
	        MeterBuilder meter = new MeterBuilder();
	        meter.setContainerName("abcd");
	        meter.setKey(key);
	        meter.setMeterId(new MeterId(9L));
	        meter.setMeterName(originalMeterName);
	        meter.setFlags(new MeterFlags(true, false, false, false));
	        MeterBandHeadersBuilder bandHeaders = new MeterBandHeadersBuilder();
	        List<MeterBandHeader> bandHdr = new ArrayList<MeterBandHeader>();
	        MeterBandHeaderBuilder bandHeader = new MeterBandHeaderBuilder();
	        bandHeader.setBandRate((long) 234);
	        bandHeader.setBandBurstSize((long) 444);
	        DscpRemarkBuilder dscpRemark = new DscpRemarkBuilder();
	        dscpRemark.setDscpRemarkBurstSize((long) 5);
	        dscpRemark.setPrecLevel((short) 1);
	        dscpRemark.setDscpRemarkRate((long) 12);
	        bandHeader.setBandType(dscpRemark.build());
	        MeterBandTypesBuilder bandTypes = new MeterBandTypesBuilder();
	        MeterBandType bandType = new MeterBandType(false, true, false);
	        bandTypes.setFlags(bandType);
	        bandHeader.setMeterBandTypes(bandTypes.build());
	        bandHeader.setBandId(new BandId(0L));
	        bandHdr.add(bandHeader.build());
	        bandHeaders.setMeterBandHeader(bandHdr);
	        meter.setMeterBandHeaders(bandHeaders.build());

	        
	        InstanceIdentifier<Meter> meterIID = InstanceIdentifier.builder(Nodes.class)
	   	    	 .child(Node.class, new NodeKey(nodeId))
	   	    	 .augmentation(FlowCapableNode.class)
	   	    	 .child(Meter.class, key)
	   	    	 .build();
	   	    
	   	    GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, 
	   	    		meterIID, meter.build(), true);
	        return meter.build();
    }
}
