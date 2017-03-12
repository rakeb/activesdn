package org.sdnhub.odl.tutorial.tapapp.impl;

import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInput;

public interface RepeatFunction {

	InstallFlowInput performFunction (NodeConnectorId outputPort, Ipv4Prefix dstIp, Ipv4Prefix srcIp, NodeId nodeid);
	InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix curDstIp,
			Ipv4Prefix newDstIp, Ipv4Prefix curSrcIp, Ipv4Prefix newSrcIp, boolean setMac,
			NodeId nodeid);
}
