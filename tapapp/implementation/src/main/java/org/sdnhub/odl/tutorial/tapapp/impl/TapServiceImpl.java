package org.sdnhub.odl.tutorial.tapapp.impl;

import java.math.BigInteger;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.NotificationProviderService;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.DropActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.OutputActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetDlDstActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetDlSrcActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwDstActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwSrcActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwTosActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetNwTtlActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetQueueActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetTpDstActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.SetTpSrcActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.drop.action._case.DropActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.output.action._case.OutputActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.dl.dst.action._case.SetDlDstActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.dl.src.action._case.SetDlSrcActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.nw.dst.action._case.SetNwDstActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.nw.src.action._case.SetNwSrcActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.nw.tos.action._case.SetNwTosActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.nw.ttl.action._case.SetNwTtlActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.queue.action._case.SetQueueActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.tp.dst.action._case.SetTpDstActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.set.tp.src.action._case.SetTpSrcActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.address.address.Ipv4;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.address.address.Ipv4Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNodeUpdated;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.Table;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.TableKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.SalFlowService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.FlowCookie;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.InstructionsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.MatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.ApplyActionsCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.apply.actions._case.ApplyActionsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.Instruction;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.InstructionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.InstructionKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRemoved;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorUpdated;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRemoved;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeUpdated;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.OpendaylightInventoryListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.meter.types.rev130918.MeterId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.AddTapInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.AddTapOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.AddTapOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CheckingInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CheckingOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CheckingOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ConnectedHosts;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CookieToFlowid;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CookieToFlowidBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetAllHostsOnSwitchInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetAllHostsOnSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetAllLinksOfSwitchInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetAllLinksOfSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetAllLinksOfSwitchOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetAllSwitchesOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetAllSwitchesOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetNetworkTopologyOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetNetworkTopologyOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowRepository;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallInspectionPathOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesInputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathBwNodesOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallPathOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.LocalIpv4Prefix;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MigratePathOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MovePathInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MovePathOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MovePathOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MutateIpInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MutateIpOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MutateIpOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NodeNeighbors;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NodeNeighborsBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAFlowFromSwitchOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveATapFromSwitchInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveATapFromSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveATapFromSwitchOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAllTapsFromSwitchInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAllTapsFromSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveAllTapsFromSwitchOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveFlowsFromSwitchInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveFlowsFromSwitchOutput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.RemoveFlowsFromSwitchOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapService;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapSpec;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TapSpecBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHost;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.connected.hosts.ConnectedHostKey;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.Cookie;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.CookieBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.CookieKey;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.DropPacketCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToControllerCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToControllerCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToFloodCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstIpv4AddressCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstIpv4AddressCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetIpv4TosCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetIpv4TtlCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetPortQueueCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetRateLimitCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetSourceIpv4AddressCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetSourceIpv4AddressCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetSrcMacAddressCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetSrcMacAddressCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetTcpDstPortCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetTcpSrcPortCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.forward.to.controller._case.ForwardToControllerBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.forward.to.port._case.ForwardToPortBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.ipv4.address._case.SetDstIpv4AddressBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddressBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.source.ipv4.address._case.SetSourceIpv4AddressBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddressBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getallhostsonswitch.output.HostsInfo;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinksBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActions;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActionsBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlowBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.repository.NewFlow1;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.BothCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.DstOnlyCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.mutate.ip.input.mutation.end.SourceOnlyCase;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNodeBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNodeKey;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.NeighborsBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.NeighborsKey;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.tap.spec.Tap;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.tap.spec.TapBuilder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.tap.spec.TapKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Link;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.concepts.Registration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.sdnhub.odl.tutorial.utils.GenericTransactionUtils;
import org.sdnhub.odl.tutorial.utils.inventory.InventoryUtils;
import org.sdnhub.odl.tutorial.utils.openflow13.MatchUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;

// Previously it is called TutorialTapProvider
public class TapServiceImpl implements AutoCloseable, DataChangeListener, OpendaylightInventoryListener, TapService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    //Members related to MD-SAL operations
    private List<Registration> registrations = Lists.newArrayList();
    private DataBroker dataBroker;
    private SalFlowService salFlowService;
    private final AtomicLong flowCookie = new AtomicLong();
    private HashMap<NodeId, List<String>> flowsInstalled = new HashMap<NodeId, List<String>>();
    private HashMap<NodeId, List<String>> tapsInstalled = new HashMap<NodeId, List<String>>();
    private HashMap<String, String> pathFlows = new HashMap<String, String>();
    private HashMap<String, List<String>> allInstalledFlows = new HashMap<>();
    private TutorialL2Forwarding tutorialL2Forwarding;
    private ActivesdnServiceImpl activeSDNApi;
	private ActiveSDNAssignment activeSDNAssignment;
	private NetworkGraph topology;
	private HashMap<NodeConnectorId, NodeId> linkNeighbor = new HashMap<NodeConnectorId, NodeId>();
	private boolean pathRule = false;
	
	//Member Functions
//////////////////////////////////////////////////////////////////////////////	
    		
    public TapServiceImpl(DataBroker dataBroker, NotificationProviderService notificationService, RpcProviderRegistry rpcProviderRegistry) {
    	topology = new NetworkGraph();
    	this.activeSDNAssignment = new ActiveSDNAssignment(dataBroker, notificationService, rpcProviderRegistry, topology);
    	this.tutorialL2Forwarding = new TutorialL2Forwarding(dataBroker, notificationService, rpcProviderRegistry, this.activeSDNAssignment);
    	this.activeSDNApi = new ActivesdnServiceImpl(dataBroker, notificationService, rpcProviderRegistry);
    	
        //Store the data broker for reading/writing from inventory store
        this.dataBroker = dataBroker;
        //Object used for flow programming through RPC calls
        this.salFlowService = rpcProviderRegistry.getRpcService(SalFlowService.class);
        rpcProviderRegistry.addRpcImplementation(TapService.class, this);
        //initialize all containers in the data store to avoid initialization issues
        WriteTransaction transaction = dataBroker.newWriteOnlyTransaction();
        InstanceIdentifier<TapSpec> newTapSpecIID = InstanceIdentifier.create(TapSpec.class);
        TapSpec tapSpec = new TapSpecBuilder().build();
        transaction.put(LogicalDatastoreType.CONFIGURATION, newTapSpecIID, tapSpec);
        
        InstanceIdentifier<CookieToFlowid> cookieIID = InstanceIdentifier.create(CookieToFlowid.class);
        CookieToFlowid cookie = new CookieToFlowidBuilder().build();
        transaction.put(LogicalDatastoreType.CONFIGURATION, cookieIID, cookie);
        
        InstanceIdentifier<NodeNeighbors> neighborsIID = InstanceIdentifier.create(NodeNeighbors.class);
        NodeNeighbors neighbor = new NodeNeighborsBuilder().build();
        transaction.put(LogicalDatastoreType.CONFIGURATION, neighborsIID, neighbor);
        //------------------------------------------------
        //List used to track notification (both data change and YANG-defined) listener registrations
        //this.registrations = registerDataChangeListeners();
        InstanceIdentifier<TapSpec> tapSpecIID = InstanceIdentifier.builder(TapSpec.class)
                .build();
        registerDataChangeListeners(tapSpecIID, true);
        
        InstanceIdentifier<InstallFlowRepository> flowIID = InstanceIdentifier.builder(InstallFlowRepository.class)
        		.build();
        registerDataChangeListeners(flowIID, true);
        
        String topologyId = "flow:1";
		InstanceIdentifier<Link> topologyLinkIdentifier = InstanceIdentifier.builder(NetworkTopology.class)
        .child(Topology.class, new TopologyKey(new TopologyId(topologyId))).child(Link.class).build();
		registerDataChangeListeners(topologyLinkIdentifier, false);

        //Register this object for receiving notifications when there are New switches
        registrations.add(notificationService.registerNotificationListener(this));
        
    }
 
    public void close() throws Exception {
        for (Registration registration : registrations) {
            registration.close();
        }
        for (NodeId nodeId : flowsInstalled.keySet()){
        	for (String flowId: flowsInstalled.get(nodeId)){
                String flowIdStr = flowId;
                	
            	FlowBuilder flowBuilder = new FlowBuilder();
            	FlowKey key = new FlowKey(new FlowId(flowIdStr));
            	flowBuilder.setFlowName(flowIdStr);
            	flowBuilder.setKey(key);
            	flowBuilder.setId(new FlowId(flowIdStr));
            	flowBuilder.setTableId((short)0);
                	
            	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
            			.child(Node.class, new NodeKey(nodeId))
            			.augmentation(FlowCapableNode.class)
            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
            			.build();
                	
            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
            }
        }
        for (NodeId nodeId : tapsInstalled.keySet()){
        	for (String tapId: tapsInstalled.get(nodeId)){
                //String flowIdStr = "Tap_" + tapId + "_NodeID_" + nodeId.getValue();
        		String flowIdStr = tapId;
                //remove tap from tap-spec datastore	
                InstanceIdentifier<Tap> tapIID = InstanceIdentifier.builder(TapSpec.class)
                		.child(Tap.class, new TapKey(tapId))
                		.build();
                TapBuilder tapB = new TapBuilder();
                tapB.setId(tapId);
                GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, tapIID, tapB.build(), false);
                
                //Remove Tap from the switch
            	FlowBuilder flowBuilder = new FlowBuilder();
            	FlowKey key = new FlowKey(new FlowId(flowIdStr));
            	flowBuilder.setFlowName(flowIdStr);
            	flowBuilder.setKey(key);
            	flowBuilder.setId(new FlowId(flowIdStr));
            	flowBuilder.setTableId((short)0);
                	
            	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
            			.child(Node.class, new NodeKey(nodeId))
            			.augmentation(FlowCapableNode.class)
            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
            			.build();
                	
            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
            }
        }
        flowsInstalled.clear();
        registrations.clear();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //private List<Registration> registerDataChangeListeners(InstanceIdentifier<?> iid) {
    private void registerDataChangeListeners(InstanceIdentifier<?> iid, boolean configStore) {
        Preconditions.checkNotNull(dataBroker);
        //List<Registration> registrations = Lists.newArrayList();
        try {
            //Register listener for config updates and topology
            //InstanceIdentifier<TapSpec> tapSpecIID = InstanceIdentifier.builder(TapSpec.class)
            //        .build();
            ListenerRegistration<DataChangeListener> registration;
            if (configStore == true){
            	registration = dataBroker.registerDataChangeListener(
                        LogicalDatastoreType.CONFIGURATION,
                        iid, this, AsyncDataBroker.DataChangeScope.SUBTREE);
            } else {
            	registration = dataBroker.registerDataChangeListener(
                        LogicalDatastoreType.OPERATIONAL,
                        iid, this, AsyncDataBroker.DataChangeScope.SUBTREE);
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
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onDataChanged(AsyncDataChangeEvent<InstanceIdentifier<?>, DataObject> change) {   	
        //LOG.debug("Data changed: {} created, {} updated, {} removed",
        //        change.getCreatedData().size(), change.getUpdatedData().size(), change.getRemovedPaths().size());
        DataObject dataObject;
       
        // Iterate over any created nodes or interfaces
        //change.get-- provides a set but here as we are using it as iterator therefore we use ().entrySet()
        
        for (Map.Entry<InstanceIdentifier<?>, DataObject> entry : change.getCreatedData().entrySet()) {
            dataObject = entry.getValue();
            //LOG.debug("ADDED Path {}, Object {}", entry.getKey(), dataObject);
            if (dataObject instanceof Tap){
            	programTap((Tap)dataObject);
            }
            else if (dataObject instanceof NewFlow1){
            	callProgramFlow((NewFlow1)dataObject);
            }
            else if (dataObject instanceof Link){
            	//LOG.debug("==============---------------=================----------------------");
            	//LOG.debug("A new link is added in the topology.");
            	//LOG.debug("==============---------------=================----------------------");

            	populateANeighor((Link) dataObject);
            }
        }

        // Iterate over any deleted nodes or interfaces
        Map<InstanceIdentifier<?>, DataObject> originalData = change.getOriginalData();
        for (InstanceIdentifier<?> path : change.getRemovedPaths()) {
        	
            dataObject = originalData.get(path);
            
            //LOG.debug("REMOVED Path {}, Object {}", path, dataObject);
            if (dataObject instanceof Tap){
            	removeTap((Tap)dataObject);
            }
            else if (dataObject instanceof NewFlow1){
            	removeFlow((NewFlow1)dataObject);
            }
            else if (dataObject instanceof Link){
            	//LOG.debug("==============----*******************-----------=================----------------------");
            	//LOG.debug("A new link is deleted from the topology.");
            	//LOG.debug("==============----******************-----------=================----------------------");
            	//deleteANeighbor((Link) dataObject);
            }
        }

        for (Map.Entry<InstanceIdentifier<?>, DataObject> entry : change.getUpdatedData().entrySet()) {
            dataObject = entry.getValue();
            DataObject originalDataObject = originalData.get(entry.getKey());
            LOG.debug("UPDATED Path {}, New Object {}, Old Object {}", entry.getKey(), dataObject, originalDataObject);
        }
       
    }
    /////////////////////////////////////////////////////////////////////////////////////    
    private void programTap(Tap tap) {

        NodeId nodeId = tap.getNode();
        String tapId = tap.getId();
        LOG.debug("         ---------------------------------------------------------------------     ");
		LOG.debug("ProgramTap is called for Node {}", nodeId);
		LOG.debug("         ---------------------------------------------------------------------     ");
        //Creating match object
        MatchBuilder matchBuilder = new MatchBuilder();   
        
        if (tap.getSourceMacAddress() != null){
			MatchUtils.createEthSrcMatch(matchBuilder, tap.getSourceMacAddress());
		}	
		if (tap.getDstMacAddress() != null){
			MatchUtils.createEthDstMatch(matchBuilder, tap.getDstMacAddress(), null);
		}
		if (tap.getSourceIpAddress() != null){
			MatchUtils.createSrcL3IPv4Match(matchBuilder, new Ipv4Prefix(tap.getSourceIpAddress().getValue()));
		}
		if (tap.getDstIpAddress() != null){
			MatchUtils.createDstL3IPv4Match(matchBuilder, new Ipv4Prefix(tap.getDstIpAddress().getValue()));
		}
        
        if (tap.getTrafficMatch() != null) {
            Integer dlType = null;
            Short nwProto = null;
            Integer tpPort = null;
            switch (tap.getTrafficMatch()) {
            case ARP:
                dlType = 0x806;
                break;
            case ICMP:
                dlType = 0x800;
                nwProto = 1;
                break;
            case TCP:
                dlType = 0x800;
                nwProto = 6;
                break;
            case HTTP:
                dlType = 0x800;
                nwProto = 6;
                tpPort = 80;
                break;
            case HTTPS:
                dlType = 0x800;
                nwProto = 6;
                tpPort = 443;
                break;
            case UDP:
                dlType = 0x800;
                nwProto = 0x11;
                break;
            case DNS:
                dlType = 0x800;
                nwProto = 0x11;
                tpPort = 53;
                break;
            case DHCP:
                dlType = 0x800;
                nwProto = 0x11;
                tpPort = 67;
            }
            if (dlType != null) {
                MatchUtils.createEtherTypeMatch(matchBuilder, dlType.longValue());
            }
            if (nwProto != null) {
                MatchUtils.createIpProtocolMatch(matchBuilder, nwProto);
                if (tpPort != null && nwProto == 6) {
                    MatchUtils.createSetDstTcpMatch(matchBuilder, new PortNumber(tpPort));
                } else if (tpPort != null && nwProto == 17) {
                    MatchUtils.createSetDstUdpMatch(matchBuilder, new PortNumber(tpPort));
                }
            }
        }
        MatchUtils.createIPv4BestEffortTOSMatch(matchBuilder, (short)0);
                
        NodeConnectorId inPortId1 = null;
		if (tap.getInPortConnector() != null){
			NodeConnectorId inPortId = tap.getInPortConnector();
		    MatchUtils.createInPortMatch(matchBuilder, inPortId);
		}

    	List<Instruction> instructions = Lists.newArrayList();
        InstructionBuilder ib = new InstructionBuilder();
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        ActionBuilder ab = new ActionBuilder();
        List<Action> actionList = Lists.newArrayList();

		NodeConnectorRef controllerPortRef = InventoryUtils.getControllerNodeConnectorRef(nodeId);
        NodeConnectorId controllerPortId = InventoryUtils.getNodeConnectorId(controllerPortRef);
            
        int outputIndex = 0;
        OutputActionBuilder output = new OutputActionBuilder();
        output.setOutputNodeConnector(controllerPortId);
        output.setMaxLength(65535); //Send full packet and No buffer
        ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
        ab.setKey(new ActionKey(outputIndex));
        ab.setOrder(outputIndex++);
        actionList.add(ab.build());

        // Create Apply Actions Instruction
        aab.setAction(actionList);
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setOrder(0);
        ib.setKey(new InstructionKey(0));
        instructions.add(ib.build());
            
        // Instructions List Stores Individual Instructions
        InstructionsBuilder isb = new InstructionsBuilder();
        isb.setInstruction(instructions);
        
        //FlowCookie flowck = new FlowCookie(BigInteger.valueOf(flowCookie.incrementAndGet()));
        //String cookieID = nodeId.toString() + "." + flowck.toString();

        //String flowIdStr = "Tap_" + tapId + "_NodeID_" + nodeId.getValue();
        FlowCookie flowck = new FlowCookie(BigInteger.valueOf((long)Integer.parseInt(tapId)));
        String flowIdStr = tapId;
        
        FlowBuilder flowBuilder = new FlowBuilder();
        FlowKey key = new FlowKey(new FlowId(flowIdStr));

        flowBuilder.setKey(key);
        flowBuilder.setId(new FlowId(flowIdStr));
        flowBuilder.setFlowName(flowIdStr);
        flowBuilder.setTableId((short)0);
        flowBuilder.setBarrier(true);
        flowBuilder.setPriority(30000);
        flowBuilder.setHardTimeout(0);
        flowBuilder.setIdleTimeout(0);
        flowBuilder.setCookie(flowck);
        flowBuilder.setCookieMask(flowck);
        
        flowBuilder.setMatch(matchBuilder.build());
        flowBuilder.setInstructions(isb.build());
     
        //Program flow by adding it to the flow table in the opendaylight-inventory
        InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
        		.child(Node.class, new NodeKey(nodeId))
        		.augmentation(FlowCapableNode.class)
        		.child(Table.class, new TableKey(flowBuilder.getTableId()))
        		.child(Flow.class, new FlowKey(flowBuilder.getKey()))
        		.build();
        
        GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), true);

        CookieBuilder cookieBuilder = new CookieBuilder();
        cookieBuilder.setId(flowck.toString());
        //cookieBuilder.setId(flowIdStr);
        cookieBuilder.setTapid(tapId);
        cookieBuilder.setFlowid(flowIdStr);
        
        Cookie cookie = cookieBuilder.build();
        
        InstanceIdentifier<Cookie> cookieIID = InstanceIdentifier.builder(CookieToFlowid.class)
        		.child(Cookie.class, new CookieKey(flowck.toString()))
        		.build();
        
        boolean cookieAdded = GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, cookieIID, cookie, true);
        if (cookieAdded == true){
        	LOG.debug("         ---------------------------------------------------------------------     ");
    		LOG.debug("Cookied is successfully added {}", flowck.toString());
    		LOG.debug("         ---------------------------------------------------------------------     ");
        }
            
            /*
            CookieToFlowidBuilder cookieFlowBuilder = new CookieToFlowidBuilder();
            cookieFlowBuilder.setCookie(cookieID);
            cookieFlowBuilder.setTapid(tapId);
            cookieFlowBuilder.setFlowid(flowIdStr);
            CookieToFlowid cookieFlow = cookieFlowBuilder.build();
            
            InstanceIdentifier<CookieToFlowid> cookieFlowIID = InstanceIdentifier.builder(CookieToFlowid.class).build();
 
            MeterKey meterKey = new MeterKey(new MeterId((long) 2000));
            InstanceIdentifier<Meter> meterIID = InstanceIdentifier.builder(Nodes.class)
            		.child(Node.class, new NodeKey(nodeId))
            		.augmentation(FlowCapableNode.class)
            		.child(Meter.class, meterKey)
            		.build();
            
            long BURST_SIZE = 10;
            long DROP_RATE = 100;

            */
    }
    /////////////////////////////////////////////////////////////////////////////////////
    private void removeTap(Tap tap) {
    	NodeId nodeId = tap.getNode();
    	String tapId = tap.getId();
    	NodeConnectorId  srcNodeConnector = tap.getInPortConnector();
    	//String flowIdStr = "Tap_" + tapId + "_NodeID_" + nodeId.getValue();
    	String flowIdStr = tapId;
    	
    	FlowBuilder flowBuilder = new FlowBuilder();
    	FlowKey key = new FlowKey(new FlowId(flowIdStr));
    	flowBuilder.setFlowName(flowIdStr);
    	flowBuilder.setKey(key);
    	flowBuilder.setId(new FlowId(flowIdStr));
    	flowBuilder.setTableId((short)0);
    	
    	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
    			.child(Node.class, new NodeKey(nodeId))
    			.augmentation(FlowCapableNode.class)
    			.child(Table.class, new TableKey(flowBuilder.getTableId()))
    			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
    			.build();
    	
    	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
    	
    }
    /////////////////////////////////////////////////////////////////////////////////////   
    private void removeFlow(NewFlow1 flow1) {
    	//Fix this issue of passing nodeid to removeflow
    	//NodeId nodeId = flow1.getNode();
    
    	NodeId nodeId = new NodeId("openflow:1");
    	String flowId = flow1.getId();
    	NodeConnectorId  srcNodeConnector = flow1.getInPort();
        //String flowIdStr = "Flow_" + flowId + "SrcPort" + srcNodeConnector.toString();
        String flowIdStr = flowId;
        	
    	FlowBuilder flowBuilder = new FlowBuilder();
    	FlowKey key = new FlowKey(new FlowId(flowIdStr));
    	flowBuilder.setFlowName(flowIdStr);
    	flowBuilder.setKey(key);
    	flowBuilder.setId(new FlowId(flowIdStr));
    	flowBuilder.setTableId((short)0);
        	
    	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
    			.child(Node.class, new NodeKey(nodeId))
    			.augmentation(FlowCapableNode.class)
    			.child(Table.class, new TableKey(flowBuilder.getTableId()))
    			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
    			.build();
        	
    	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
    	
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onNodeRemoved(NodeRemoved nodeRemoved) {
        LOG.debug("Node removed {}", nodeRemoved);
        
      //Remove all flows using RPC call to MD-SAL Flow Service
        NodeId nodeId = nodeRemoved.getNodeRef().getValue().firstKeyOf(Node.class).getId();
        //InstanceIdentifier<Node> nodeIID = InstanceIdentifier.builder(Nodes.class)
        //		.child(Node.class, new NodeKey(nodeId))
        //		.build();
        //NodeBuilder nodeBuilder = new NodeBuilder(); 
        //GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, nodeIID, nodeBuilder.build(), false);
        LOG.debug("   ************************************************    ");
        LOG.debug(" Node ID     =     "    + nodeId.getValue());
        LOG.debug("   ************************************************    ");
        
        if (flowsInstalled.containsKey(nodeId)){
        	for (String flowId: flowsInstalled.get(nodeId)){
                String flowIdStr = flowId;
                	
            	FlowBuilder flowBuilder = new FlowBuilder();
            	FlowKey key = new FlowKey(new FlowId(flowIdStr));
            	flowBuilder.setFlowName(flowIdStr);
            	flowBuilder.setKey(key);
            	flowBuilder.setId(new FlowId(flowIdStr));
            	flowBuilder.setTableId((short)0);
                	
            	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
            			.child(Node.class, new NodeKey(nodeId))
            			.augmentation(FlowCapableNode.class)
            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
            			.build();
                	
            	boolean result = GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
            	if (result == true) {
            		LOG.debug("   ************************************************    ");
                    LOG.debug(" Flow is removed with ID     =     "    + flowId);
                    LOG.debug("   ************************************************    ");
                    
            	}
            	else {
            		LOG.debug("   ************************************************    ");
                    LOG.debug(" No Flow exists with ID     =     "    + flowId);
                    LOG.debug("   ************************************************    ");
            	}
            }
        	flowsInstalled.remove(nodeId);
        }
        /////////////////////////////////////////////
        if (tapsInstalled.containsKey(nodeId)) {
        	for (String tapId: tapsInstalled.get(nodeId)){
        		String flowIdStr = tapId;
                //remove tap from tap-spec datastore	
                InstanceIdentifier<Tap> tapIID = InstanceIdentifier.builder(TapSpec.class)
                		.child(Tap.class, new TapKey(tapId))
                		.build();
                TapBuilder tapB = new TapBuilder();
                tapB.setId(tapId);
                GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, tapIID, tapB.build(), false);
                
                //Remove Tap from the switch
            	FlowBuilder flowBuilder = new FlowBuilder();
            	FlowKey key = new FlowKey(new FlowId(flowIdStr));
            	flowBuilder.setFlowName(flowIdStr);
            	flowBuilder.setKey(key);
            	flowBuilder.setId(new FlowId(flowIdStr));
            	flowBuilder.setTableId((short)0);
                	
            	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
            			.child(Node.class, new NodeKey(nodeId))
            			.augmentation(FlowCapableNode.class)
            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
            			.build();
                	
            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
            }
        	tapsInstalled.remove(nodeId);
        }
        this.activeSDNAssignment.clearConfiguration();
        this.tutorialL2Forwarding.clearConfiguration();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onNodeConnectorRemoved(NodeConnectorRemoved nodeConnectorRemoved) {
    	NodeConnectorId linkId = nodeConnectorRemoved.getNodeConnectorRef().
    			getValue().firstKeyOf(NodeConnector.class).getId();
    	NodeId nodeId = InventoryUtils.getNodeId(linkId);
    	
    	LOG.debug("-----------------=====================--------------------------");
        LOG.debug("Node connector is removed {}", linkId);
        LOG.debug("-----------------=====================--------------------------");
        //if (linkNeighbor.containsKey(linkId)){
        //	NodeId neighborId = linkNeighbor.get(linkId);
        //	linkNeighbor.remove(linkId);
        //	deleteANeighbor(nodeId, linkId, neighborId);
        //}
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onNodeUpdated(NodeUpdated nodeUpdated) {
        LOG.debug("Node updated {}", nodeUpdated);
        NodeId nodeId = nodeUpdated.getId();
        
        FlowCapableNodeUpdated switchDesc = nodeUpdated.getAugmentation(FlowCapableNodeUpdated.class);
        if (switchDesc != null) {
            LOG.info("Node {}, OpenFlow description {}", nodeId, switchDesc);
        }

        //==================================================
    
        MatchBuilder matchBuilder = new MatchBuilder();
        //Integer dlType = 0x806;
        //MatchUtils.createEtherTypeMatch(matchBuilder, dlType.longValue());
        
        List<Instruction> instructions = Lists.newArrayList();
        InstructionBuilder ib = new InstructionBuilder();
        
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        ActionBuilder ab = new ActionBuilder();
        List<Action> actionList = Lists.newArrayList();
        
		OutputActionBuilder output = new OutputActionBuilder();
        output.setMaxLength(65535);
        Uri value = new Uri("CONTROLLER");
        output.setOutputNodeConnector(value);
        ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
        ab.setOrder(0);
        ab.setKey(new ActionKey(0));
        actionList.add(ab.build());
        
        aab.setAction(actionList);
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setOrder(0);
        ib.setKey(new InstructionKey(1));
        
        instructions.add(ib.build());
        
        /* Instructions List Stores Individual Instructions
        ApplyActionsBuilder aab1 = new ApplyActionsBuilder();
        ActionBuilder ab1 = new ActionBuilder();
        List<Action> actionList1 = Lists.newArrayList();
        
		OutputActionBuilder output1 = new OutputActionBuilder();
        output1.setMaxLength(65535);
        Uri value1 = new Uri("FLOOD");
        output1.setOutputNodeConnector(value1);
        ab1.setAction(new OutputActionCaseBuilder().setOutputAction(output1.build()).build());
        ab1.setOrder(0);
        ab1.setKey(new ActionKey(0));
        actionList1.add(ab1.build());
        
        aab1.setAction(actionList1);
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab1.build()).build());
        ib.setOrder(1);
        ib.setKey(new InstructionKey(2));
        instructions.add(ib.build());
        */
        InstructionsBuilder isb = new InstructionsBuilder();
        isb.setInstruction(instructions);
        
        String flowIdStr = "0";
        FlowBuilder flowBuilder = new FlowBuilder();
        FlowKey key = new FlowKey(new FlowId(flowIdStr));

        flowBuilder.setKey(key);
        flowBuilder.setId(new FlowId(flowIdStr));
        flowBuilder.setFlowName(flowIdStr);
        flowBuilder.setTableId((short)0);
        flowBuilder.setBarrier(true);
        flowBuilder.setPriority(150);
        flowBuilder.setHardTimeout(0);
        flowBuilder.setIdleTimeout(0);
        
        //flowBuilder.setCookieMask(flowck);
        //flowBuilder.setStrict(false);
            
        flowBuilder.setMatch(matchBuilder.build());
        flowBuilder.setInstructions(isb.build());
        
        LOG.debug("         ---------------------------------------------------------------------     ");
		LOG.debug("Installing ARP flow Entry.");
		LOG.debug("         ---------------------------------------------------------------------     ");
		
        //Program flow by adding it to the flow table in the opendaylight-inventory
        InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
        		.child(Node.class, new NodeKey(nodeId))
        		.augmentation(FlowCapableNode.class)
        		.child(Table.class, new TableKey(flowBuilder.getTableId()))
        		.child(Flow.class, new FlowKey(flowBuilder.getKey()))
        		.build();
        
        boolean status = GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), true);
        if (status == true){
        	LOG.debug("         ---------------------------------------------------------------------     ");
    		LOG.debug("					   Flow is added on node startup");
    		LOG.debug("         ---------------------------------------------------------------------     ");
        }
       
      /*
        InstallFlowInputBuilder flowInputBuilder = new InstallFlowInputBuilder();
        flowInputBuilder.setNode(nodeId);
        
        List<AssociatedActions> actionList = Lists.newArrayList();
		AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
		ForwardToControllerBuilder controllerBuilder = new ForwardToControllerBuilder();
		actionBuilder.setFlowActions(new ForwardToControllerCaseBuilder().
				setForwardToController(controllerBuilder.build()).build());
		actionBuilder.setId((long)0);
		actionList.add(actionBuilder.build());
		flowInputBuilder.setAssociatedActions(actionList);
		
		NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
		//newFlowBuilder.setTrafficMatch(TrafficType.ARP);
		newFlowBuilder.setFlowPriority(150);
		newFlowBuilder.setIdleTimeout(0);
		newFlowBuilder.setHardTimeout(0);
		flowInputBuilder.setNewFlow(newFlowBuilder.build());
		
		this.installFlow(flowInputBuilder.build());
 */
        //I assume that in my case it is always due to node added so we don't need to remove flows.
        //Remove all flows using RPC call to MD-SAL Flow Service
        //RemoveFlowInputBuilder flowBuilder = new RemoveFlowInputBuilder()
        //    .setBarrier(true)
        //    .setNode(InventoryUtils.getNodeRef(nodeId));
        //salFlowService.removeFlow(flowBuilder.build());
    }
    /////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onNodeConnectorUpdated(NodeConnectorUpdated nodeConnectorUpdated) {
        //LOG.debug("NodeConnector updated {}", nodeConnectorUpdated);
        NodeId nodeId = InventoryUtils.getNodeId(nodeConnectorUpdated.getNodeConnectorRef());
        NodeConnectorId linkId = InventoryUtils.getNodeConnectorId(nodeConnectorUpdated.getNodeConnectorRef());
    	
    	LOG.debug("-----------------=====================--------------------------");
        LOG.debug("Node connector is removed {}", linkId);
        LOG.debug("-----------------=====================--------------------------");
        if (linkNeighbor.containsKey(linkId)){
        	NodeId neighborId = linkNeighbor.get(linkId);
        	linkNeighbor.remove(linkId);
        	deleteANeighbor(nodeId, linkId, neighborId);
        }
        //FlowCapableNodeConnectorUpdated portDesc = nodeConnectorUpdated.getAugmentation(FlowCapableNodeConnectorUpdated.class);
        //if (portDesc != null) {
        //    LOG.info("Node {}, OpenFlow Port description {}", nodeId, portDesc);
        //}
    }
    /////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Future<RpcResult<AddTapOutput>> addTap(AddTapInput input) {
		LOG.debug("         ---------------------------------------------------------------------     ");
		LOG.debug("Add Tap RPC is Called.");
		LOG.debug("         ---------------------------------------------------------------------     ");
		
		List<Tap1> tap1 = input.getTap1();
		Tap1 tappy = tap1.get(0);
		
		TapBuilder tapBuilder = new TapBuilder();
		tapBuilder.setId(tappy.getId());
		tapBuilder.setNode(tappy.getNode());
		if (tappy.getInPortConnector() != null){
			tapBuilder.setInPortConnector(tappy.getInPortConnector());
		}
		if (tappy.getSourceIpAddress() != null){
			tapBuilder.setSourceIpAddress(tappy.getSourceIpAddress());
		}
		if (tappy.getSourceMacAddress() != null){
			tapBuilder.setSourceMacAddress(tappy.getSourceMacAddress());
		}
		if (tappy.getDstIpAddress() != null){
			tapBuilder.setDstIpAddress(tappy.getDstIpAddress());
		}
		if (tappy.getDstMacAddress() != null){
			tapBuilder.setDstMacAddress(tappy.getDstMacAddress());
		}
		if (tappy.getTrafficMatch() != null){
			tapBuilder.setTrafficMatch(tappy.getTrafficMatch());
		}
		tapBuilder.setCount(tappy.getCount());
		tapBuilder.setDuration(tappy.getDuration());
		tapBuilder.setTapActions(tappy.getTapActions());
		
		

		LOG.debug("         ---------------------------------------------------------------------     ");
		LOG.debug("Finished building the TapBuilder.");
		LOG.debug("         ---------------------------------------------------------------------     ");
		Tap tap = tapBuilder.build();
		
		InstanceIdentifier<Tap> tapIID = InstanceIdentifier.create(TapSpec.class)
				.child(Tap.class, new TapKey(tappy.getId()));

		GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, tapIID, tap, true);
		
		String output_msg = "Tap is added to CONFIG Datastore";
		LOG.debug("         ---------------------------------------------------------------------     ");
		LOG.debug("Tap info added to CONFIG Datastore {}", tap);
		LOG.debug("         ---------------------------------------------------------------------     ");
		
		AddTapOutput output = new AddTapOutputBuilder()
        .setStatus(output_msg)
        .build();
		
		if (tapsInstalled.containsKey(tappy.getNode())){
        	tapsInstalled.get(tappy.getNode()).add(tappy.getId());
        }
        else {
        	List<String> list = Lists.newArrayList();
        	list.add(tappy.getId());
        	tapsInstalled.put(tappy.getNode(), list);
        }
		
		/*
		InstanceIdentifier<MalEvents> eventIID = InstanceIdentifier.builder(MalEvents.class).build();
		MalEventBuilder eventBuilder = new MalEventBuilder();
		eventBuilder.setCount((long)0);
		eventBuilder.setId(tappy.getId());
		MalEvent event = eventBuilder.build();
		MalEventsBuilder eventsBuilder = new MalEventsBuilder();
		eventsBuilder.setMalEvent(event);
		MalEvents malEvents = eventsBuilder.build();
		
		GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, eventIID, malEvents, true);
		LOG.debug("Event info added to CONFIG Datastore {}", malEvents);
		*/
		
		return RpcResultBuilder.success(output).buildFuture();	
	}	
    /////////////////////////////////////////////////////////////////////////////////////	
	private void callProgramFlow(NewFlow1 flow1){
		//Fix this as well
		/*
		NewFlowBuilder flowBuilder = new NewFlowBuilder();
		flowBuilder.setDstMacAddress(flow1.getDstMacAddress());
		flowBuilder.setSrcMacAddress(flow1.getSrcMacAddress());
		flowBuilder.setSrcIpAddress(flow1.getSrcIpAddress());
		flowBuilder.setDstIpAddress(flow1.getDstIpAddress());
		flowBuilder.setInPort(flow1.getInPort());
		flowBuilder.setId(flow1.getId());
		flowBuilder.setNode(flow1.getNode());
		flowBuilder.setOutPort(flow1.getOutPort());
		flowBuilder.setTrafficMatch(flow1.getTrafficMatch());
		flowBuilder.setCustomInfo(flow1.getCustomInfo());
		
		NewFlow flow = flowBuilder.build();
		boolean status = programFlow(flow);
		if (status == true){
			LOG.debug("Flow successfully installed {}", flow);
		}
		else {
			LOG.debug("Flow can't be installed.");
		}
		*/
	}
    /////////////////////////////////////////////////////////////////////////////////////	
	private String programFlow(NodeId nodeId, String flowKey, NewFlow flow, List<AssociatedActions> actions){
		
		//LOG.debug("         ---------------------------------------------------------------------     ");
		//LOG.debug("ProgramFlow is called for Node {}, Matching Criteria {}, Actions {}", nodeId, flow, actions);
		//LOG.debug("         ---------------------------------------------------------------------     ");
		long idleTimeOut = 0;
		long hardTimeOut = 0;
		long priority = 3000;
		MatchBuilder matchBuilder = new MatchBuilder();
        
		if (flow.getSrcMacAddress() != null){
			MatchUtils.createEthSrcMatch(matchBuilder, flow.getSrcMacAddress());
		}	
		if (flow.getDstMacAddress() != null){
			MatchUtils.createEthDstMatch(matchBuilder, flow.getDstMacAddress(), null);
		}
		if (flow.getSrcIpAddress() != null){
			MatchUtils.createSrcL3IPv4Match(matchBuilder, flow.getSrcIpAddress());
		}
		if (flow.getDstIpAddress() != null){
			MatchUtils.createDstL3IPv4Match(matchBuilder, flow.getDstIpAddress());
		}
		//LOG.debug("         ---------------------------------------------------------------------     ");
		//LOG.debug("Just finished creating source and destination IP and MAC addresses");
		//LOG.debug("         ---------------------------------------------------------------------     ");
		
        if (flow.getTrafficMatch() != null) {
            Integer dlType = null;
            Short nwProto = null;
            Integer tpPort = null;
            switch (flow.getTrafficMatch()) {
            case ARP:
                dlType = 0x806;
                idleTimeOut = 0;
                hardTimeOut = 0;
                break;
            case ICMP:
                dlType = 0x800;
                nwProto = 1;
                idleTimeOut = 0;
                hardTimeOut = 0;
                break;
            case TCP:
                dlType = 0x800;
                nwProto = 6;
                idleTimeOut = 0;
                hardTimeOut = 0;
                priority = 3000;
                break;
            case HTTP:
                dlType = 0x800;
                nwProto = 6;
                tpPort = 80;
                break;
            case HTTPS:
                dlType = 0x800;
                nwProto = 6;
                tpPort = 443;
                break;
            case UDP:
                dlType = 0x800;
                nwProto = 0x11;
                idleTimeOut = 0;
                hardTimeOut = 0;
                priority = 3000;
                break;
            case DNS:
                dlType = 0x800;
                nwProto = 0x11;
                tpPort = 53;
                break;
            case DHCP:
                dlType = 0x800;
                nwProto = 0x11;
                tpPort = 67;
                break;
            case CUSTOM:
            	dlType = flow.getCustomInfo().getDlType();
            	nwProto = flow.getCustomInfo().getNwProto();
            	tpPort = flow.getCustomInfo().getTpDst();
            	break;
            }
            if (dlType != null) {
                MatchUtils.createEtherTypeMatch(matchBuilder, dlType.longValue());
            }
            if (nwProto != null) {
                MatchUtils.createIpProtocolMatch(matchBuilder, nwProto);
                if (tpPort != null && nwProto == 6) {
                    MatchUtils.createSetDstTcpMatch(matchBuilder, new PortNumber(tpPort));
                } else if (tpPort != null && nwProto == 17) {
                    MatchUtils.createSetDstUdpMatch(matchBuilder, new PortNumber(tpPort));
                }
            }
        }
        
        //LOG.debug("         ---------------------------------------------------------------------     ");
		//LOG.debug("Just finished creating Traffic Type Information");
		//LOG.debug("         ---------------------------------------------------------------------     ");
		
		NodeConnectorId inPortId = null;
		if (flow.getInPort() != null){
			inPortId = flow.getInPort();
		    MatchUtils.createInPortMatch(matchBuilder, inPortId);
		}
		
        //LOG.debug("         ---------------------------------------------------------------------     ");
		//LOG.debug("Just starting creating Instruction and actions");
		//LOG.debug("         -------------------------------------------------------------------     ");
		
    	List<Instruction> instructions = Lists.newArrayList();
        InstructionBuilder ib = new InstructionBuilder();
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        ActionBuilder ab = new ActionBuilder();
        List<Action> actionList = Lists.newArrayList();

        //For each sink node connector
        int outputIndex = 0;
        boolean setTos = true;
        boolean limitRate = true;
        int instructionIndex = 0;
        //meter-kbps
       
        for (AssociatedActions action: actions) {
        	if (action.getFlowActions() instanceof SetRateLimitCase) {
        		SetRateLimitCase rateLimitCase = (SetRateLimitCase) action.getFlowActions();
        		
        		MeterId mID = new MeterId((long) 1);
        		String meterName = "NodeId_" + nodeId.getValue() + "_Meter_" + mID.getValue();

        		switch (rateLimitCase.getSetRateLimit().getMeterType()){
        		case MeterKbps:
        			InventoryUtils.createMeter(dataBroker, nodeId, mID.getValue(), meterName, 
            				rateLimitCase.getSetRateLimit().getBandRate(), 
            				rateLimitCase.getSetRateLimit().getBandBurstSize(), 
            				rateLimitCase.getSetRateLimit().getDropRate(),
            				rateLimitCase.getSetRateLimit().getDropBurstSize(), InventoryUtils.EnumMeterFlags.KBPS);
        			break;
        		case MeterPktps:
        			InventoryUtils.createMeter(dataBroker, nodeId, mID.getValue(), meterName, 
            				rateLimitCase.getSetRateLimit().getBandRate(), 
            				rateLimitCase.getSetRateLimit().getBandBurstSize(), 
            				rateLimitCase.getSetRateLimit().getDropRate(),
            				rateLimitCase.getSetRateLimit().getDropBurstSize(), InventoryUtils.EnumMeterFlags.PKPTS);
        			break;
        		case MeterBurst:
        			InventoryUtils.createMeter(dataBroker, nodeId, mID.getValue(), meterName, 
            				rateLimitCase.getSetRateLimit().getBandRate(), 
            				rateLimitCase.getSetRateLimit().getBandBurstSize(), 
            				rateLimitCase.getSetRateLimit().getDropRate(),
            				rateLimitCase.getSetRateLimit().getDropBurstSize(), InventoryUtils.EnumMeterFlags.BURSTS);
        			break;
        		case MeterStats:
        			InventoryUtils.createMeter(dataBroker, nodeId, mID.getValue(), meterName, 
            				rateLimitCase.getSetRateLimit().getBandRate(), 
            				rateLimitCase.getSetRateLimit().getBandBurstSize(), 
            				rateLimitCase.getSetRateLimit().getDropRate(),
            				rateLimitCase.getSetRateLimit().getDropBurstSize(), InventoryUtils.EnumMeterFlags.STATS);
        			
        			break;      			
        		}
        		
                //org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.
                //instruction.instruction.meter._case.MeterBuilder meterB = new org.opendaylight.
                //yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.meter._case.MeterBuilder();
                //meterB.setMeterId(mID);
                
                //ib.setInstruction(new MeterCaseBuilder().setMeter(meterB.build()).build());
                //ib.setOrder(instructionIndex);
                //ib.setKey(new InstructionKey(instructionIndex++));
                //instructions.add(ib.build());
                
                //rateLimitCase.getSetRateLimit
                OutputActionBuilder output = new OutputActionBuilder();
                output.setOutputNodeConnector(rateLimitCase.getSetRateLimit().getEgressPort());
                output.setMaxLength(65535); //Send full packet and No buffer
                
                ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                ab.setKey(new ActionKey(outputIndex));
                ab.setOrder(outputIndex++);
                actionList.add(ab.build());
                //break;
        	}
  
        	else if (action.getFlowActions() instanceof SetPortQueueCase){
        		SetPortQueueCase portQueueCase = (SetPortQueueCase) action.getFlowActions();
        		SetQueueActionCaseBuilder queueActionCaseBuilder = new SetQueueActionCaseBuilder();
        		SetQueueActionBuilder queueActionBuilder = new SetQueueActionBuilder();
        		queueActionBuilder.setQueueId(portQueueCase.getSetQueue().getQueueId());
        		ab.setAction(new SetQueueActionCaseBuilder().setSetQueueAction(queueActionBuilder.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        		
        		//rateLimitCase.getSetRateLimit
                OutputActionBuilder output = new OutputActionBuilder();
                output.setOutputNodeConnector(portQueueCase.getSetQueue().getEgressPort());
                output.setMaxLength(65535); //Send full packet and No buffer
                ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                ab.setKey(new ActionKey(outputIndex));
                ab.setOrder(outputIndex++);
                actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof ForwardToPortCase) {
        		ForwardToPortCase forwardtoPortCase = (ForwardToPortCase) action.getFlowActions();
        		OutputActionBuilder output = new OutputActionBuilder();
                output.setOutputNodeConnector(forwardtoPortCase.getForwardToPort().getOutputNodeConnector());
                output.setMaxLength(65535); //Send full packet and No buffer
                ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                ab.setKey(new ActionKey(outputIndex));
                ab.setOrder(outputIndex++);
                actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof ForwardToControllerCase){
        		ForwardToControllerCase forwardtoControllerCase = (ForwardToControllerCase) action.getFlowActions();
        		OutputActionBuilder output = new OutputActionBuilder();
                output.setMaxLength(65535);
                Uri value = new Uri("CONTROLLER");
                output.setOutputNodeConnector(value);
                ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                ab.setOrder(0);
                ab.setKey(new ActionKey(0));
                actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof ForwardToFloodCase){
        		ForwardToFloodCase forwardtoFloodCase = (ForwardToFloodCase) action.getFlowActions();
        		OutputActionBuilder output = new OutputActionBuilder();
                output.setMaxLength(65535);
                Uri value = new Uri("FLOOD");
                output.setOutputNodeConnector(value);
                ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
                ab.setOrder(0);
                ab.setKey(new ActionKey(0));
                actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof DropPacketCase){
        		DropPacketCase dropPacketCase = (DropPacketCase) action.getFlowActions();
        		DropActionBuilder dropAction = new DropActionBuilder();
        		ab.setAction(new DropActionCaseBuilder().setDropAction(dropAction.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof SetSourceIpv4AddressCase){
        		SetSourceIpv4AddressCase sourceIpv4Case = (SetSourceIpv4AddressCase) action.getFlowActions();
        		SetNwSrcActionBuilder nwSrcActionB = new SetNwSrcActionBuilder();
        		Ipv4Builder ipv4CaseBuilder = new Ipv4Builder();
        		ipv4CaseBuilder.setIpv4Address(sourceIpv4Case.getSetSourceIpv4Address().getValue());
        		Ipv4 ipv4Case = ipv4CaseBuilder.build();
        		nwSrcActionB.setAddress(ipv4Case);
        		ab.setAction(new SetNwSrcActionCaseBuilder().setSetNwSrcAction(nwSrcActionB.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof SetDstIpv4AddressCase){
        		SetDstIpv4AddressCase dstIpv4Case = (SetDstIpv4AddressCase) action.getFlowActions();
        		SetNwDstActionBuilder nwDstActionB = new SetNwDstActionBuilder();
        		Ipv4Builder ipv4CaseBuilder = new Ipv4Builder();
        		ipv4CaseBuilder.setIpv4Address(dstIpv4Case.getSetDstIpv4Address().getValue());
        		Ipv4 ipv4Case = ipv4CaseBuilder.build();
        		nwDstActionB.setAddress(ipv4Case);
        		ab.setAction(new SetNwDstActionCaseBuilder().setSetNwDstAction(nwDstActionB.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof SetDstMacAddressCase){
        		SetDstMacAddressCase dstMacCase = (SetDstMacAddressCase) action.getFlowActions();
        		SetDlDstActionBuilder dlDstActionB = new SetDlDstActionBuilder();
        		dlDstActionB.setAddress(dstMacCase.getSetDstMacAddress().getValue());
        		ab.setAction(new SetDlDstActionCaseBuilder().setSetDlDstAction(dlDstActionB.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof SetSrcMacAddressCase){
        		SetSrcMacAddressCase srcMacCase = (SetSrcMacAddressCase) action.getFlowActions();
        		SetDlSrcActionBuilder dlSrcActionB = new SetDlSrcActionBuilder();
        		dlSrcActionB.setAddress(srcMacCase.getSetSrcMacAddress().getValue());
        		ab.setAction(new SetDlSrcActionCaseBuilder().setSetDlSrcAction(dlSrcActionB.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof SetIpv4TosCase){
        		SetIpv4TosCase ipv4TosCase = (SetIpv4TosCase) action.getFlowActions();
        		SetNwTosActionBuilder nwTosCaseBuilder = new SetNwTosActionBuilder();
        		nwTosCaseBuilder.setTos(ipv4TosCase.getSetIpv4Tos().getValue());
        		ab.setAction(new SetNwTosActionCaseBuilder().setSetNwTosAction(nwTosCaseBuilder.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        		setTos = false;
        	}
        	else if (action.getFlowActions() instanceof SetTcpSrcPortCase){
        		SetTcpSrcPortCase tcpSrcPortCase = (SetTcpSrcPortCase) action.getFlowActions();
        		SetTpSrcActionBuilder tpSrcActionBuilder = new SetTpSrcActionBuilder();
        		tpSrcActionBuilder.setPort(new PortNumber(tcpSrcPortCase.getSetTcpSrcPort().getPortNumber()));
        		ab.setAction(new SetTpSrcActionCaseBuilder().setSetTpSrcAction(tpSrcActionBuilder.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof SetTcpDstPortCase){
        		SetTcpDstPortCase tcpDstPortCase = (SetTcpDstPortCase) action.getFlowActions();
        		SetTpDstActionBuilder tpDstActionBuilder = new SetTpDstActionBuilder();
        		tpDstActionBuilder.setPort(new PortNumber(tcpDstPortCase.getSetTcpDstPort().getPortNumber()));
        		ab.setAction(new SetTpDstActionCaseBuilder().setSetTpDstAction(tpDstActionBuilder.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        	}
        	else if (action.getFlowActions() instanceof SetIpv4TtlCase){
        		SetIpv4TtlCase ipv4TtlCase = (SetIpv4TtlCase) action.getFlowActions();
        		SetNwTtlActionBuilder nwTtlActionBuilder = new SetNwTtlActionBuilder();
        		nwTtlActionBuilder.setNwTtl((short)ipv4TtlCase.getSetIpv4Ttl().getTtlValue());
        		ab.setAction(new SetNwTtlActionCaseBuilder().setSetNwTtlAction(nwTtlActionBuilder.build()).build());
        		ab.setKey(new ActionKey(outputIndex));
        		ab.setOrder(outputIndex++);
        		actionList.add(ab.build());
        	}
        }

        if (setTos == true){
    		SetNwTosActionBuilder nwTosCaseBuilder = new SetNwTosActionBuilder();
    		nwTosCaseBuilder.setTos((int)0);
    		ab.setAction(new SetNwTosActionCaseBuilder().setSetNwTosAction(nwTosCaseBuilder.build()).build());
    		ab.setKey(new ActionKey(outputIndex));
    		ab.setOrder(outputIndex++);
    		actionList.add(ab.build());
        }
        // Create Apply Actions Instruction
        aab.setAction(actionList);
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setOrder(instructionIndex);
        ib.setKey(new InstructionKey(instructionIndex++));
        
        instructions.add(ib.build());
        // Instructions List Stores Individual Instructions
        InstructionsBuilder isb = new InstructionsBuilder();
        isb.setInstruction(instructions);
        
        //FlowCookie flowck = new FlowCookie(BigInteger.valueOf(flowCookie.incrementAndGet()));
        FlowCookie flowck = new FlowCookie(BigInteger.valueOf((long) Integer.parseInt(flowKey)));
        
        String cookieID = nodeId.toString() + "." + flowck.toString();

        //LOG.debug("         ---------------------------------------------------------------------     ");
		//LOG.debug("Just starting creating Flow Builder");
		//LOG.debug("         ---------------------------------------------------------------------     ");
		
        //String flowIdStr = "Node_" + nodeId.getValue() + "_Flow_" + flowck.getValue().toString();
		String flowIdStr = flowck.getValue().toString();
        
        /*
         * Write code here to insert this flow information in local repository
         */
		
        FlowBuilder flowBuilder = new FlowBuilder();
        FlowKey key = new FlowKey(new FlowId(flowIdStr));

        flowBuilder.setKey(key);
        flowBuilder.setId(new FlowId(flowIdStr));
        flowBuilder.setFlowName(flowIdStr);
        flowBuilder.setTableId((short)0);
        flowBuilder.setBarrier(true);
        flowBuilder.setPriority(flow.getFlowPriority());
        flowBuilder.setHardTimeout(flow.getHardTimeout());
        flowBuilder.setIdleTimeout(flow.getIdleTimeout());
        flowBuilder.setCookie(flowck);
        

        //flowBuilder.setCookieMask(flowck);
        //flowBuilder.setStrict(false);
            
        flowBuilder.setMatch(matchBuilder.build());
        flowBuilder.setInstructions(isb.build());
        
        //LOG.debug("         ---------------------------------------------------------------------     ");
		//LOG.debug("Installing Flow to the switch through node repository.");
		//LOG.debug("         ---------------------------------------------------------------------     ");
		
        //Program flow by adding it to the flow table in the opendaylight-inventory
        InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
        		.child(Node.class, new NodeKey(nodeId))
        		.augmentation(FlowCapableNode.class)
        		.child(Table.class, new TableKey(flowBuilder.getTableId()))
        		.child(Flow.class, new FlowKey(flowBuilder.getKey()))
        		.build();
        if (flowsInstalled.containsKey(nodeId)){
        	flowsInstalled.get(nodeId).add(flowIdStr);
        }
        else {
        	List<String> list = Lists.newArrayList();
        	list.add(flowIdStr);
        	flowsInstalled.put(nodeId, list);
        }
        
        boolean result = GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), true);
        if (result == true) {
        	if (pathRule == true) {
        		String installedRuleKey = nodeId.getValue() + ":" + flow.getDstIpAddress().getValue();
        		pathFlows.put(installedRuleKey, flowIdStr);
        		
        		//keep a track of all flow rules which is installed
        		List uniqueFlowIDs;
        		if(allInstalledFlows.containsKey(installedRuleKey)) {
        			uniqueFlowIDs = allInstalledFlows.get(installedRuleKey);
        		} else {
					uniqueFlowIDs = Lists.newArrayList();
					allInstalledFlows.put(installedRuleKey, uniqueFlowIDs);
				}
        		uniqueFlowIDs.add(flowIdStr);
        		//
        		
        		pathRule = false;
        	}
        	
        	return flowIdStr;
        }
        else return null; 
	}
    /////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public Future<RpcResult<InstallFlowOutput>> installFlow(InstallFlowInput input) {
		
		//LOG.debug("         ---------------------------------------------------------------------     ");
		//LOG.debug("InstallFlow RPC is called with Input Object {}", input);
		//LOG.debug("         ---------------------------------------------------------------------     ");
		NodeId nodeId = input.getNode();
		NewFlow flow = input.getNewFlow();
		List<AssociatedActions> actions = input.getAssociatedActions();

		String flowIdStr;
		if (input.getFlowId() == null) {
			String flowId = BigInteger.valueOf(this.activeSDNApi.eventID.incrementAndGet()).toString();
			flowIdStr = programFlow(nodeId, flowId, flow, actions);
		} 
		else {
			flowIdStr = programFlow(nodeId, input.getFlowId(), flow, actions);
		}
		
		
		if (flowIdStr != null){
			String output_msg = "Flow is Installed in the Switch";
			//LOG.debug("         ---------------------------------------------------------------------     ");
			//LOG.debug("Flow is Installed to the switch {}", flow);
			//LOG.debug("         ---------------------------------------------------------------------     ");
			
			InstallFlowOutputBuilder output = new InstallFlowOutputBuilder();
			output.setStatus(output_msg);
			output.setFlowId(flowIdStr);
			return RpcResultBuilder.success(output.build()).buildFuture();
		}
		else{
			return null;
		}
	}
    /////////////////////////////////////////////////////////////////////////////////////	
	private List<Node> getNodes() {
		  InstanceIdentifier<Nodes> nodesIID = InstanceIdentifier.create(Nodes.class);
		  Nodes nodes = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, 
				  nodesIID);
				  
		  if (nodes == null) {
		   throw new RuntimeException("nodes are not found, pls add the node.");
		  }
		  return nodes.getNode();
	}
    /////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Future<RpcResult<GetAllSwitchesOutput>> getAllSwitches() {
		LOG.debug("         ---------------------------------------------------------------------     \n");
		LOG.debug("getAllSwitches RPC is called {}");
		LOG.debug("         ---------------------------------------------------------------------     \n");
		InstanceIdentifier<Nodes> nodesIID = InstanceIdentifier.create(Nodes.class);
		  Nodes nodes = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, 
				  nodesIID);
				  
		  if (nodes == null) {
			  LOG.debug("nodes are not found, pls add the node.");
			  return null;
		  }
		  List<NodeId> switchIds = Lists.newArrayList();
		  List<Node> switches = nodes.getNode();
		  for (Iterator<Node> iterator = switches.iterator(); iterator.hasNext();) {
			  NodeKey nodeKey = iterator.next().getKey();
			  switchIds.add(nodeKey.getId());
		  }
		  
		  GetAllSwitchesOutputBuilder allSwitchesOutput = new GetAllSwitchesOutputBuilder();
		  allSwitchesOutput.setNodes(switchIds);
		  GetAllSwitchesOutput output = allSwitchesOutput.build();
		  return RpcResultBuilder.success(output).buildFuture();
	}
    /////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Future<RpcResult<GetAllLinksOfSwitchOutput>> getAllLinksOfSwitch(
			GetAllLinksOfSwitchInput input) {
		// Returns all the ports of a switch
		List<NodeConnectorId> portIds = Lists.newArrayList();
		
		NodeKey nodeKey = new NodeKey(input.getNode());
		InstanceIdentifier<Node> nodeRef = InstanceIdentifier.create(Nodes.class)
				.child(Node.class, nodeKey);
		
		Node node = GenericTransactionUtils.readData(dataBroker, 
				LogicalDatastoreType.OPERATIONAL, nodeRef);
		if (node != null){
			if (node.getNodeConnector() != null) {
			     List<NodeConnector> ports = node.getNodeConnector();
			     for (Iterator<NodeConnector> iterator2 = ports.iterator(); iterator2
			    	       .hasNext();) {
			    	 NodeConnectorKey nodeConnectorKey = iterator2.next().getKey();
			    	 //test(InventoryUtils.getNodeConnectorRef(nodeConnectorKey.getId()));
			    	 portIds.add(nodeConnectorKey.getId());
			     }
			     GetAllLinksOfSwitchOutputBuilder outputBuilder = new GetAllLinksOfSwitchOutputBuilder();
			     outputBuilder.setLinks(portIds);
			     return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
			}
			else{
				LOG.debug("There are no ports available on Node {}", input.getNode());
				return null;
			}
		}
		else{
			LOG.debug("There are no ports available on Node {}", input.getNode());
			return null;
		}
	}
    /////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public Future<RpcResult<GetNetworkTopologyOutput>> getNetworkTopology() {
		String topologyId = "flow:1";
		InstanceIdentifier<Topology> topologyInstanceIdentifier = InstanceIdentifier.builder(NetworkTopology.class)
        .child(Topology.class, new TopologyKey(new TopologyId(topologyId))).build();
		Topology topology = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, topologyInstanceIdentifier);
		long linkIndex = 0;
		List<NetworkLinks> networkLinks = new ArrayList<NetworkLinks>();
		List<String> addedLinks = new ArrayList<String>();
		if (topology != null){
			List<Link> links = topology.getLink();
	        if (links == null || links.isEmpty()) {
	        	LOG.debug("         ---------------------------------------------------------------------     \n");
	            LOG.debug("No Links in the Topology");
	            LOG.debug("         ---------------------------------------------------------------------     \n");
	        }
	        else {
		        List<Link> internalLinks = new ArrayList<>();
		        for (Link link : links) {
		            if (!(link.getLinkId().getValue().contains("host"))) {
		                internalLinks.add(link);
		                NodeId sourceNodeId = new NodeId(link.getSource().getSourceNode().getValue());
			            NodeRef sourceNodeRef = InventoryUtils.getNodeRef(sourceNodeId);
			            NodeConnectorId sourceNodConnectorId = new NodeConnectorId(link.getSource().getSourceTp().getValue());
			            NodeConnectorRef sourceNodeConnectorRef = InventoryUtils.getNodeConnectorRef(sourceNodConnectorId);
			            
			            NodeId dstNodeId = new NodeId(link.getDestination().getDestNode().getValue());
			            NodeRef dstNodeRef = InventoryUtils.getNodeRef(dstNodeId);
			            NodeConnectorId dstNodConnectorId = new NodeConnectorId(link.getDestination().getDestTp().getValue());
			            NodeConnectorRef dstNodeConnectorRef = InventoryUtils.getNodeConnectorRef(dstNodConnectorId);
			           
			            String linkId = sourceNodeId.getValue() + "_" + dstNodeId.getValue();
			            if (!addedLinks.contains(linkId)){
			            	addedLinks.add(linkId);
			            	NetworkLinksBuilder netLinksBuilder = new NetworkLinksBuilder();
				            netLinksBuilder.setId(linkId);
				            netLinksBuilder.setSrcNode(sourceNodeId);
				            netLinksBuilder.setSrcNodeConnector(sourceNodConnectorId);
				            netLinksBuilder.setDstNode(dstNodeId);
				            netLinksBuilder.setDstNodeConnector(dstNodConnectorId);
				            NetworkLinks netLinks = netLinksBuilder.build();
				            networkLinks.add(netLinks);
			            }
			            String linkId1 = dstNodeId.getValue() + "_" + sourceNodeId.getValue();
			            if (!addedLinks.contains(linkId1)){
			            	addedLinks.add(linkId1);
			            	NetworkLinksBuilder netLinksBuilder = new NetworkLinksBuilder();
				            netLinksBuilder.setId(linkId1);
				            netLinksBuilder.setSrcNode(dstNodeId);
				            netLinksBuilder.setSrcNodeConnector(dstNodConnectorId);
				            netLinksBuilder.setDstNode(sourceNodeId);
				            netLinksBuilder.setDstNodeConnector(sourceNodConnectorId);
				            NetworkLinks netLinks = netLinksBuilder.build();
				            networkLinks.add(netLinks);
			            }       
			            
			            //LOG.debug("         ---------------------------------------------------------------------     \n");
			            //LOG.debug("LinkId {},  linkSource {}, LinksrcTP {}, linkdst {}, linkdsttp {}", link.getLinkId().getValue(),
			            //		link.getSource().getSourceNode().getValue(), link.getSource().getSourceTp().getValue(),
			            //		link.getDestination().getDestNode().getValue(), link.getDestination().getDestNode().getValue());
			            //LOG.debug("         ---------------------------------------------------------------------     \n");
		            }
		            //LOG.debug("         ---------------------------------------------------------------------     \n");
		            //LOG.debug("LinkId {},  linkSource {}, LinksrcTP {}, linkdst {}, linkdsttp {}", link.getLinkId().getValue(),
		            //		link.getSource().getSourceNode().getValue(), link.getSource().getSourceTp().getValue(),
		            //		link.getDestination().getDestNode().getValue(), link.getDestination().getDestNode().getValue());
		            //LOG.debug("         ---------------------------------------------------------------------     \n");
		        }
		        ////////////
		        GetNetworkTopologyOutputBuilder output = new GetNetworkTopologyOutputBuilder();
		        output.setNetworkLinks(networkLinks);
		        this.populateNeighors(output.build());
		        return RpcResultBuilder.success(output.build()).buildFuture();
	        }
		}
		return null;
	}
    /////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Future<RpcResult<CheckingOutput>> checking(CheckingInput input) {
		LOG.debug("         ---------------------------------------------------------------------     \n");
		LOG.debug("getAllSwitches RPC is called {}");
		LOG.debug("         ---------------------------------------------------------------------     \n");
		String note = input.getNote();
		CheckingOutputBuilder output = new CheckingOutputBuilder();
		output.setMsg(note + "_ho gaya na");
		return RpcResultBuilder.success(output.build()).buildFuture();
	}
    /////////////////////////////////////////////////////////////////////////////////////
	public String convertTime(long time){
	    Date date = new Date(time);
	    Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
	    return format.format(date);
	}
/*

	@Override
	public Future<RpcResult<GetAllHostsOnSwitchOutput>> getAllHostsOnSwitch(
			GetAllHostsOnSwitchInput input) {
		List<NodeConnectorId> portIds = Lists.newArrayList();
		List<HostsInfo> hosts = new ArrayList<HostsInfo>();
		
		
		NodeKey nodeKey = new NodeKey(input.getNode());
		InstanceIdentifier<Node> nodeRef = InstanceIdentifier.create(Nodes.class)
				.child(Node.class, nodeKey);
		
		Node node = GenericTransactionUtils.readData(dataBroker, 
				LogicalDatastoreType.OPERATIONAL, nodeRef);
		List<Addresses> addresses = null;
		if (node != null){
			if (node.getNodeConnector() != null) {
			     List<NodeConnector> ports = node.getNodeConnector();
			     long hostIndex = 0;
			     for (Iterator<NodeConnector> iterator2 = ports.iterator(); iterator2
			    	       .hasNext();) {
			    	 NodeConnectorKey nodeConnectorKey = iterator2.next().getKey();
			    	 //iterator2 is the nodeconnetor
			    	 portIds.add(nodeConnectorKey.getId());
			    	 NodeConnector nc = null;
			    	 nc = (NodeConnector) GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, 
			    			 (InstanceIdentifier<NodeConnector>) iterator2);
			    	 if (nc != null) {
			    		 AddressCapableNodeConnector acnc = (AddressCapableNodeConnector) nc
				                    .getAugmentation(AddressCapableNodeConnector.class);
			    		 if (acnc != null && acnc.getAddresses() != null) {
			                 // Search for this mac-ip pair in the existing address
			                 // observations & update last-seen timestamp
			    			 
			                 addresses = acnc.getAddresses();
			                 MacAddress hostMacAddress = addresses.get(0).getMac();
			                 IpAddress hostIpAddress = addresses.get(0).getIp();
			                 String firstSeen = convertTime((long) addresses.get(0).getFirstSeen());
			                 String lastSeen = convertTime((long)addresses.get(0).getLastSeen());
			                 
			                 HostsInfoBuilder hostInfoBuilder = new HostsInfoBuilder();
			                 hostInfoBuilder.setHostFirstSeen(firstSeen);
			                 hostInfoBuilder.setHostLastSeen(lastSeen);
			                 hostInfoBuilder.setHostIpAddress(hostIpAddress.getIpv4Address().getValue());
			                 hostInfoBuilder.setHostMacAddress(hostMacAddress.getValue());
			                 hostInfoBuilder.setId(++hostIndex);
			                 
			                 HostsInfo hostInfo = hostInfoBuilder.build();
			                 hosts.add(hostInfo);
			    		 }
			            
			    	 }
			            
			     }
			     GetAllHostsOnSwitchOutputBuilder output = new GetAllHostsOnSwitchOutputBuilder();
			     output.setHostsInfo(hosts);
			     return RpcResultBuilder.success(output.build()).buildFuture();
			     
			}
			else{
				LOG.debug("         ---------------------------------------------------------------------     \n");
				LOG.debug("There are no Hosts available on Node ");
				LOG.debug("         ---------------------------------------------------------------------     \n");
				return null;
			}
		}
		else{
			LOG.debug("         ---------------------------------------------------------------------     \n");
			LOG.debug("There are no ports available on Node ");
			LOG.debug("         ---------------------------------------------------------------------     \n");
			return null;
			
		}
	}
	


    private void test(NodeConnectorRef nodeConnectorRef){
    	

       // Read existing address observations from data tree
        ReadWriteTransaction readWriteTransaction = dataBroker.newReadWriteTransaction();

        NodeConnector nc = null;
        try {
          Optional<DataObject> dataObjectOptional = (Optional<DataObject>) readWriteTransaction.read(LogicalDatastoreType.OPERATIONAL, 
        		  nodeConnectorRef.getValue()).get();// not recommended option, one should implement listener on retuned ListenableFuture
          if(dataObjectOptional.isPresent())
            nc = (NodeConnector) dataObjectOptional.get(); 
        } catch(Exception e) {
        	LOG.debug("something");
          readWriteTransaction.commit();
          throw new RuntimeException("Error reading from operational store, node connector : " + nodeConnectorRef, e);
        }
        if(nc == null) {
          readWriteTransaction.commit();
          return;
        }
        InstanceIdentifier<Addresses> addrCapableNodeConnectors=InstanceIdentifier.builder(Nodes.class)
        		.child(org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node.class)
        		.child(NodeConnector.class).augmentation(AddressCapableNodeConnector.class)
        		.child(Addresses.class).build();
    }
    */
    /////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public Future<RpcResult<GetAllHostsOnSwitchOutput>> getAllHostsOnSwitch(
			GetAllHostsOnSwitchInput input) {
		List<NodeConnectorId> portIds = Lists.newArrayList();
		List<HostsInfo> hosts = new ArrayList<HostsInfo>();
		
		
			  
		return null;
	}
	/////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public Future<RpcResult<RemoveFlowsFromSwitchOutput>> removeFlowsFromSwitch(
			RemoveFlowsFromSwitchInput input) {
		NodeId nodeId = input.getNode();
		if (flowsInstalled.containsKey(nodeId)){
			for (String flowId: flowsInstalled.get(nodeId)){
                String flowIdStr = flowId;
                	
            	FlowBuilder flowBuilder = new FlowBuilder();
            	FlowKey key = new FlowKey(new FlowId(flowIdStr));
            	flowBuilder.setFlowName(flowIdStr);
            	flowBuilder.setKey(key);
            	flowBuilder.setId(new FlowId(flowIdStr));
            	flowBuilder.setTableId((short)0);
                	
            	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
            			.child(Node.class, new NodeKey(nodeId))
            			.augmentation(FlowCapableNode.class)
            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
            			.build();
                	
            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
            }
			flowsInstalled.remove(nodeId);
			RemoveFlowsFromSwitchOutputBuilder output = new RemoveFlowsFromSwitchOutputBuilder();
			output.setStatus("Flows removed from " + nodeId.getValue());
			
			return RpcResultBuilder.success(output.build()).buildFuture();
		}
		else {
			RemoveFlowsFromSwitchOutputBuilder output = new RemoveFlowsFromSwitchOutputBuilder();
			output.setStatus("No flows Installed by Agile Api on " + nodeId.getValue());
			
			return RpcResultBuilder.success(output.build()).buildFuture();
		}
		
		
	}
	/////////////////////////////////////////////////////////////////////////////////////
	private Neighbors getPortInformation (NodeId currNode, NodeId neighborNode){
		InstanceIdentifier<Neighbors> neighborIID = InstanceIdentifier.builder(NodeNeighbors.class)
				.child(CurrNode.class, new CurrNodeKey(currNode))
				.child(Neighbors.class, new NeighborsKey(neighborNode))
				.build();
		Neighbors neighbor = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION
				, neighborIID);
		if (neighbor != null){
			return neighbor;
		}
		else{
			LOG.debug("         -------------------------------------------             ");
			LOG.debug("NodeID {} is not Neighbor of {} .", neighborNode, currNode);
			LOG.debug("         -------------------------------------------             ");
			return null;
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////
	private ConnectedHost getHostInfo(String ipAddress){
		LocalIpv4Prefix srcipPrefix = new LocalIpv4Prefix(ipAddress);
		InstanceIdentifier<ConnectedHost> hostIID = InstanceIdentifier.builder(ConnectedHosts.class)
				.child(ConnectedHost.class, new ConnectedHostKey(srcipPrefix))
				.build();
		ConnectedHost host = GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.OPERATIONAL, hostIID);
		if (host != null){
			return host;
		}
		else {
			LOG.debug("         -------------------------------------------             ");
			LOG.debug("Host with IP {} not found in the repository.", ipAddress);
			LOG.debug("         -------------------------------------------             ");
			return null;
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////
	private void deleteANeighbor(NodeId sourceId, NodeConnectorId sourceConnectorId, NodeId neighborId){
		LOG.debug("==============---------------=================----------------------");
    	LOG.debug("Removing link {} between srcNode {}  and dstNode {}.", 
    			sourceConnectorId.getValue(), sourceId.getValue(), neighborId.getValue());
    	LOG.debug("==============---------------=================----------------------");
		
        NodeId sourceNodeId = sourceId;
        NodeConnectorId sourceNodeConnectorId = sourceConnectorId;
        NodeId dstNodeId = neighborId;
        //NodeConnectorId dstNodeConnectorId = new NodeConnectorId(link.getDestination().getDestTp().getValue());
        
        int leftSwitch = Integer.parseInt(sourceNodeId.getValue().split(":")[1]);
		int rightSwitch = Integer.parseInt(dstNodeId.getValue().split(":")[1]);
		
		topology.removelinkInfo(leftSwitch, rightSwitch);
		
		NeighborsBuilder srcNeighBuilder = new NeighborsBuilder();
		srcNeighBuilder.setNeighborNodeId(dstNodeId);
		InstanceIdentifier<Neighbors> srcNeighborIID = InstanceIdentifier.builder(NodeNeighbors.class)
				.child(CurrNode.class, new CurrNodeKey(new NodeId(sourceNodeId)))
				.child(Neighbors.class, new NeighborsKey(dstNodeId))
				.build();
		Neighbors neighbor = (Neighbors) GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION, srcNeighborIID);
		linkNeighbor.remove(neighbor.getNeighPort());
		GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, 
				srcNeighborIID, srcNeighBuilder.build(), false);
		
		NeighborsBuilder dstNeighBuilder = new NeighborsBuilder();
		dstNeighBuilder.setNeighborNodeId(sourceNodeId);
		InstanceIdentifier<Neighbors> neighborIID = InstanceIdentifier.builder(NodeNeighbors.class)
				.child(CurrNode.class, new CurrNodeKey(new NodeId(dstNodeId)))
				.child(Neighbors.class, new NeighborsKey(sourceNodeId))
				.build();
		GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, 
				neighborIID, dstNeighBuilder.build(), false);
		
		LOG.debug("==============---------------=================----------------------");
    	LOG.debug("calling update installed paths function");
    	LOG.debug("==============---------------=================----------------------");
		this.activeSDNAssignment.updateInstalledPaths(sourceId, neighborId, null);
	}
	private void populateANeighor(Link link){
		
		LOG.debug("--------------------------------------------------");
        LOG.debug("ADDED Link between SourceNodeConnector {} and DstNodeConnector {}", 
        		link.getSource().getSourceNode().getValue(), 
        		link.getDestination().getDestNode().getValue());
        LOG.debug("---------------------------------------------------");

    	if (!(link.getLinkId().getValue().contains("host"))) {
            NodeId sourceNodeId = new NodeId(link.getSource().getSourceNode().getValue());
            //NodeRef sourceNodeRef = InventoryUtils.getNodeRef(sourceNodeId);
            NodeConnectorId sourceNodeConnectorId = new NodeConnectorId(link.getSource().getSourceTp().getValue());
            //NodeConnectorRef sourceNodeConnectorRef = InventoryUtils.getNodeConnectorRef(sourceNodeConnectorId);
            
            NodeId dstNodeId = new NodeId(link.getDestination().getDestNode().getValue());
            //NodeRef dstNodeRef = InventoryUtils.getNodeRef(dstNodeId);
            NodeConnectorId dstNodeConnectorId = new NodeConnectorId(link.getDestination().getDestTp().getValue());
            //NodeConnectorRef dstNodeConnectorRef = InventoryUtils.getNodeConnectorRef(dstNodeConnectorId);
            
            int leftSwitch = Integer.parseInt(sourceNodeId.getValue().split(":")[1]);
    		int rightSwitch = Integer.parseInt(dstNodeId.getValue().split(":")[1]);
    		int leftSwitchPortNumber = Integer.parseInt(sourceNodeConnectorId.getValue().split(":")[2]);
    		int rightSwitchPortNumber = Integer.parseInt(dstNodeConnectorId.getValue().split(":")[2]);
    		
    		topology.addLinkInfo(leftSwitch, rightSwitch, leftSwitchPortNumber, rightSwitchPortNumber);
    		if (linkNeighbor.containsKey(sourceNodeConnectorId) == false){
    			linkNeighbor.put(sourceNodeConnectorId, dstNodeId);
    		}
    		if (linkNeighbor.containsKey(dstNodeConnectorId) == false){
    			linkNeighbor.put(dstNodeConnectorId, sourceNodeId);
    		}
    		InstanceIdentifier<CurrNode> currNodeIID = InstanceIdentifier.builder(NodeNeighbors.class)
					.child(CurrNode.class, new CurrNodeKey(new NodeId(sourceNodeId)))
					.build();
			CurrNode currentNode = (CurrNode) GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION,
					currNodeIID);
			if (currentNode == null){
				CurrNodeBuilder cNodeBuilder = new CurrNodeBuilder();
				cNodeBuilder.setCurrNodeId(sourceNodeId);
				List<Neighbors> neighList = Lists.newArrayList();
				
				NeighborsBuilder neighBuilder = new NeighborsBuilder();
				neighBuilder.setNeighborNodeId(dstNodeId);
				neighBuilder.setSrcPort(sourceNodeConnectorId);
				neighBuilder.setNeighPort(dstNodeConnectorId);
				neighList.add(neighBuilder.build());
				cNodeBuilder.setNeighbors(neighList);
				
				GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION,
						currNodeIID, cNodeBuilder.build(), true);
			}
			else {
				if (currentNode.getNeighbors().contains(dstNodeId) == false) {
					NeighborsBuilder neighBuilder = new NeighborsBuilder();
					neighBuilder.setNeighborNodeId(dstNodeId);
					neighBuilder.setSrcPort(sourceNodeConnectorId);
					neighBuilder.setNeighPort(dstNodeConnectorId);
					currentNode.getNeighbors().add(neighBuilder.build());
					InstanceIdentifier<Neighbors> neighborIID = InstanceIdentifier.builder(NodeNeighbors.class)
							.child(CurrNode.class, new CurrNodeKey(new NodeId(sourceNodeId)))
							.child(Neighbors.class, new NeighborsKey(dstNodeId))
							.build();
					GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, 
							neighborIID, neighBuilder.build(), true);
				}
			}
			/////////////////////////////////////////////////////
			/////////////Now add Bidrectional information
			InstanceIdentifier<CurrNode> dstNodeIID = InstanceIdentifier.builder(NodeNeighbors.class)
					.child(CurrNode.class, new CurrNodeKey(new NodeId(dstNodeId)))
					.build();
			CurrNode dstNode = (CurrNode) GenericTransactionUtils.readData(dataBroker, LogicalDatastoreType.CONFIGURATION,
					dstNodeIID);
			if (dstNode == null){
				CurrNodeBuilder cNodeBuilder = new CurrNodeBuilder();
				cNodeBuilder.setCurrNodeId(dstNodeId);
				List<Neighbors> neighList = Lists.newArrayList();
				
				NeighborsBuilder neighBuilder = new NeighborsBuilder();
				neighBuilder.setNeighborNodeId(sourceNodeId);
				neighBuilder.setSrcPort(dstNodeConnectorId);
				neighBuilder.setNeighPort(sourceNodeConnectorId);
				neighList.add(neighBuilder.build());
				cNodeBuilder.setNeighbors(neighList);
				
				GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION,
						dstNodeIID, cNodeBuilder.build(), true);
			}
			else {
				if (dstNode.getNeighbors().contains(sourceNodeId) == false) {
					NeighborsBuilder neighBuilder = new NeighborsBuilder();
					neighBuilder.setNeighborNodeId(sourceNodeId);
					neighBuilder.setSrcPort(dstNodeConnectorId);
					neighBuilder.setNeighPort(sourceNodeConnectorId);
					dstNode.getNeighbors().add(neighBuilder.build());
					InstanceIdentifier<Neighbors> neighborIID = InstanceIdentifier.builder(NodeNeighbors.class)
							.child(CurrNode.class, new CurrNodeKey(new NodeId(dstNodeId)))
							.child(Neighbors.class, new NeighborsKey(sourceNodeId))
							.build();
					GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, 
							neighborIID, neighBuilder.build(), true);
				}
			}
    	}
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	private void populateNeighors(GetNetworkTopologyOutput topology){
		HashMap<String, CurrNodeBuilder> hpnodeBuilders = new HashMap<String, CurrNodeBuilder>();
		List<NetworkLinks> links = topology.getNetworkLinks();
		for (NetworkLinks link : links){
			String linkId = link.getId();
			NodeId currentNodeId = link.getSrcNode();
			if (hpnodeBuilders.containsKey(currentNodeId.getValue())){
				NeighborsBuilder neighBuilder = new NeighborsBuilder();
				neighBuilder.setNeighborNodeId(link.getDstNode());
				neighBuilder.setSrcPort(link.getSrcNodeConnector());
				neighBuilder.setNeighPort(link.getDstNodeConnector());
				hpnodeBuilders.get(currentNodeId.getValue()).getNeighbors().add(neighBuilder.build());
			}
			else {
				CurrNodeBuilder cNodeBuilder = new CurrNodeBuilder();
				cNodeBuilder.setCurrNodeId(currentNodeId);
				List<Neighbors> neighList = Lists.newArrayList();
				cNodeBuilder.setNeighbors(neighList);
				
				NeighborsBuilder neighBuilder = new NeighborsBuilder();
				neighBuilder.setNeighborNodeId(link.getDstNode());
				neighBuilder.setSrcPort(link.getSrcNodeConnector());
				neighBuilder.setNeighPort(link.getDstNodeConnector());
				cNodeBuilder.getNeighbors().add(neighBuilder.build());
				hpnodeBuilders.put(currentNodeId.getValue(), cNodeBuilder);
			}
		} //end of for
		
		for (String nodeIdKey: hpnodeBuilders.keySet()){
			InstanceIdentifier<CurrNode> currNodeIID = InstanceIdentifier.builder(NodeNeighbors.class)
					.child(CurrNode.class, new CurrNodeKey(new NodeId(nodeIdKey)))
					.build();
			GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION,
					currNodeIID, hpnodeBuilders.get(nodeIdKey).build(), true);
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Future<RpcResult<InstallPathOutput>> installPath(
			final InstallPathInput input) {
		// This RPC installs a path between a source-destination pair
		List<NodeId> pathNodes = input.getPathNodes();
		InstallPathOutputBuilder output = new InstallPathOutputBuilder();
		
		RepeatFunction func = new RepeatFunction() {	
			@Override
			public InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix dstIp,
					Ipv4Prefix srcIp, NodeId nodeid) {
				AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
				ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
				forwardBuilder.setOutputNodeConnector(outputPort);
				
				actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
						setForwardToPort(forwardBuilder.build()).build());
				actionBuilder.setId((long)1);
				List<AssociatedActions> actionList = Lists.newArrayList();
				actionList.add(actionBuilder.build());
				
				NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
				newFlowBuilder.setSrcIpAddress(srcIp);
				newFlowBuilder.setDstIpAddress(dstIp);
				newFlowBuilder.setTrafficMatch(input.getTrafficMatch());
				newFlowBuilder.setFlowPriority(input.getFlowPriority());
				newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
				newFlowBuilder.setHardTimeout(input.getHardTimeout());
				
				InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
				installFlowBuilder.setNode(nodeid);
				
				installFlowBuilder.setNewFlow(newFlowBuilder.build());
				installFlowBuilder.setAssociatedActions(actionList);
				//--------------------------------------------
				//pathFlows.put(dstIp.getValue()+ ":" + nodeid.getValue(), value)
				//--------------------------------------------
				return installFlowBuilder.build();
				
			}

			@Override
			public InstallFlowInput performFunction(NodeConnectorId outputPort,
					Ipv4Prefix curDstIp, Ipv4Prefix newDstIp,
					Ipv4Prefix curSrcIp, Ipv4Prefix newSrcIp, boolean setMac, NodeId nodeid) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		int index = 0;
		try {
			for (; index < pathNodes.size(); index++){
				//Future<RpcResult<InstallFlowOutput>> futureOutput = null;
				//Future<RpcResult<InstallFlowOutput>> futureOutput1 = null;
				if (index == 0){ // got the first switch
					ConnectedHost host = getHostInfo(input.getSrcIpAddress().getValue());
					//forwarding direction rule i.e., switch -> src
					if (host != null){
						pathRule = true;
						this.installFlow(func.performFunction(host.getNodeConnectorConnectedTo(), 
								input.getSrcIpAddress(), input.getDstIpAddress(), pathNodes.get(index)));
					}
					
					//if there are more than one switch
					if (index + 1 < pathNodes.size()){
						//forwarding direction rule i.e., src -> dst (switch to switch)
						Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index+1));
						if (neighbor != null){
							pathRule = true;
							this.installFlow(func.performFunction(neighbor.getSrcPort(), 
									input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
						}
					}
					else {
						ConnectedHost host1 = getHostInfo(input.getDstIpAddress().getValue());
						//forwarding direction rule i.e., switch -> src
						if (host1 != null){
							pathRule = true;
							this.installFlow(func.performFunction(host1.getNodeConnectorConnectedTo(), 
									input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
						}
					}
				}/////////////////////////////////////////////////////////////////
				//we have more than one switch
				else if (index - 1 >= 0 && index + 1 < pathNodes.size()){
					//forwarding direction rule i.e., src -> dst
					Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index+1));
					if (neighbor != null){
						pathRule = true;
						this.installFlow(func.performFunction(neighbor.getSrcPort(), 
								input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
					}
					//Reverse direction rule  i.e., dst -> src
					Neighbors neighbor1 = getPortInformation(pathNodes.get(index), pathNodes.get(index-1));
					if (neighbor1 != null){
						pathRule = true;
						this.installFlow(func.performFunction(neighbor1.getSrcPort(), 
								input.getSrcIpAddress(), input.getDstIpAddress(), pathNodes.get(index)));
					}
				}/////////////////////////////////////////////////////////////////
				else if (index + 1 == pathNodes.size()){
					ConnectedHost host = getHostInfo(input.getDstIpAddress().getValue());
					if (host != null){
						pathRule = true;
						this.installFlow(func.performFunction(host.getNodeConnectorConnectedTo(), 
								input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
					}
					if (index - 1 >= 0){
						//forwarding direction rule i.e., src -> dst
						Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index-1));
						if (neighbor != null){
							pathRule = true;
							this.installFlow(func.performFunction(neighbor.getSrcPort(), 
									input.getSrcIpAddress(), input.getDstIpAddress(), pathNodes.get(index)));
						}
					}
				}
				/*
				if (futureOutput != null && futureOutput1 != null){
					InstallFlowOutput installOutput = futureOutput.get().getResult();
					InstallFlowOutput installOutput1 = futureOutput1.get().getResult();
					//pathFlows.put(pathNodes.get(index).getValue() + ":" + input.getSrcIpAddress().getValue(), installOutput.getFlowId());
					//pathFlows.put(pathNodes.get(index).getValue() + ":" + input.getDstIpAddress().getValue(), installOutput1.getFlowId());
				} else {
					String exception = "No Flow ID is provided as output from installFlowRule RPC";
					throw new Exception(exception);
				}
				*/
			}
		} catch (Exception e) {
			LOG.error("Exception reached in InstallPathRPC {} --------", e);
			return null;
		}
		
		//LOG.debug("         -------------------------------------------             ");
		//LOG.debug("Path is successfully installed.");
		//LOG.debug("         -------------------------------------------             ");
		
		output.setStatus("Path is installed.");
		return RpcResultBuilder.success(output).buildFuture();
	}
	//////////////////////////////////////////////////////////////////////////////////
	@Override
	public Future<RpcResult<MovePathOutput>> movePath(final MovePathInput input) {
		// This function migrates the traffic from one path to another
		List<NodeId> oldpathNodes = input.getOldPathNodes();
		List<NodeId> newpathNodes = input.getNewPathNodes();
		//Validation Check-----First and last nodes of both paths should be same
		MovePathOutputBuilder output = new MovePathOutputBuilder();
		if ((oldpathNodes.get(0).equals(newpathNodes.get(0)) == false) || 
				(oldpathNodes.get(oldpathNodes.size()-1).equals(newpathNodes.get(newpathNodes.size()-1)) == false)){
			
			LOG.debug("         -------------------------------------------             ");
			LOG.debug("Invalid Migration: First and Last nodes are not identical.");
			LOG.debug("         -------------------------------------------             ");
			
			output.setStatus("Invalid Migration: First and Last nodes are not identical.");
			return RpcResultBuilder.success(output).buildFuture();
		}
		///////////////////////////////////
		try {
			RepeatFunction func = new RepeatFunction() {	
				@Override
				public InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix dstIp,
						Ipv4Prefix srcIp, NodeId nodeid) {
					AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
					ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
					forwardBuilder.setOutputNodeConnector(outputPort);
					
					actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
							setForwardToPort(forwardBuilder.build()).build());
					actionBuilder.setId((long)1);
					List<AssociatedActions> actionList = Lists.newArrayList();
					actionList.add(actionBuilder.build());
					
					NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
					newFlowBuilder.setDstIpAddress(dstIp);
					//newFlowBuilder.setTrafficMatch(input.get)
					newFlowBuilder.setFlowPriority(input.getFlowPriority());
					newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
					newFlowBuilder.setHardTimeout(input.getHardTimeout());
					
					InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
					installFlowBuilder.setNode(nodeid);
					installFlowBuilder.setNewFlow(newFlowBuilder.build());
					installFlowBuilder.setAssociatedActions(actionList);
					return installFlowBuilder.build();
					
				}

				@Override
				public InstallFlowInput performFunction(
						NodeConnectorId outputPort, Ipv4Prefix curDstIp,
						Ipv4Prefix newDstIp, Ipv4Prefix curSrcIp,
						Ipv4Prefix newSrcIp, boolean setMac, NodeId nodeid) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			int index = 0;
			
			for (; index < newpathNodes.size(); index++){
				if (index == 0 || index == newpathNodes.size() - 1) continue;
				//Future<RpcResult<InstallFlowOutput>> futureOutput = null;
				//forwarding direction rule i.e., src -> dst
				//LOG.debug("         ---------------------------------------------------------------------     ");
       		 	//LOG.debug(newpathNodes.get(index).getValue() + "  index & index+1     " + newpathNodes.get(index + 1));
       		 	//LOG.debug("         ---------------------------------------------------------------------     ");
				
				//"Lets say, s1 has a link with s2, output port of s1 is x and input port of s2 is y. 
				//Then neighbor-node-id means s1, src-port means x and neigh-port means y";
				//newpathNodes.get(index) == s1
				//newpathNodes.get(index+1) == s2
				Neighbors neighbor = getPortInformation(newpathNodes.get(index), newpathNodes.get(index+1));
				if (neighbor != null){
					pathRule = true;
					this.installFlow(func.performFunction(neighbor.getSrcPort(), 
							input.getDstIpAddress(), input.getSrcIpAddress(), newpathNodes.get(index)));
					//LOG.debug("         ---------------------------------------------------------------------     ");
	       		 	//LOG.debug(neighbor.getSrcPort().getValue() + "     " + input.getDstIpAddress().getValue());
	       		 	//LOG.debug("         ---------------------------------------------------------------------     ");
				} else {
					String exception = "Neighbor " + newpathNodes.get(index).getValue() + 
							" is not available for Node " + newpathNodes.get(index+1).getValue();
					throw new Exception(exception);
				}
				//Reverse direction rule  i.e., dst -> src
				//LOG.debug("         ---------------------------------------------------------------------     ");
       		 	//LOG.debug(newpathNodes.get(index).getValue() + "   index & index-1    " + newpathNodes.get(index - 1));
       		 	//LOG.debug("         ---------------------------------------------------------------------     ");
				Neighbors neighbor1 = getPortInformation(newpathNodes.get(index), newpathNodes.get(index-1));
				if (neighbor1 != null){
					pathRule = true;
					this.installFlow(func.performFunction(neighbor1.getSrcPort(), 
							input.getSrcIpAddress(), input.getDstIpAddress(), newpathNodes.get(index)));
					//LOG.debug("         ---------------------------------------------------------------------     ");
	       		 	//LOG.debug(neighbor1.getSrcPort().getValue() + "     " + input.getSrcIpAddress().getValue());
	       		 	//LOG.debug("         ---------------------------------------------------------------------     ");
				} else {
					String exception = "Neighbor " + newpathNodes.get(index).getValue() + 
							" is not available for Node " + newpathNodes.get(index-1).getValue();
					throw new Exception(exception);
				}
				/*
				try {		
					if (futureOutput != null){
						InstallFlowOutput installOutput = futureOutput.get().getResult();
						pathFlows.put(newpathNodes.get(index).getValue() + ":" + input.getDstIpAddress().getValue(), installOutput.getFlowId());
					}else {
						String exception = "No Flow ID is provided as output from installFlowRule RPC";
						throw new Exception(exception);
					}
				} catch (Exception e) {
					LOG.error("Exception reached in MovePathRPC {} --------", e);
					return null;
				}
				*/
			}
			//Switch for for both First and Last nodes
			Neighbors neighbor = getPortInformation(newpathNodes.get(0), newpathNodes.get(1));
			Neighbors neighbor1 = getPortInformation(newpathNodes.get(newpathNodes.size()-1), newpathNodes.get(newpathNodes.size()-2));
			//Future<RpcResult<InstallFlowOutput>> futureOutput = null;
			//Future<RpcResult<InstallFlowOutput>> futureOutput1 = null;
			if (neighbor != null){
				pathRule = true;
				this.installFlow(func.performFunction(neighbor.getSrcPort(), 
						input.getDstIpAddress(), input.getSrcIpAddress(), newpathNodes.get(0)));
			} else {
				String exception = "Neighbor " + newpathNodes.get(0).getValue() + 
						" is not available for Node " + newpathNodes.get(1).getValue();
				throw new Exception(exception);
			}
			if (neighbor1 != null){
				pathRule = true;
				this.installFlow(func.performFunction(neighbor1.getSrcPort(), 
						input.getSrcIpAddress(), input.getDstIpAddress(), newpathNodes.get(newpathNodes.size()-1)));
			} else {
				String exception = "Neighbor " + newpathNodes.get(newpathNodes.size()-1).getValue() + 
						" is not available for Node " + newpathNodes.get(newpathNodes.size()-2).getValue();
				throw new Exception(exception);
			}
			/*
			if (futureOutput != null && futureOutput1 != null){
				InstallFlowOutput installOutput = futureOutput.get().getResult();
				InstallFlowOutput installOutput1 = futureOutput1.get().getResult();
				pathFlows.put(newpathNodes.get(0).getValue() + ":" + input.getDstIpAddress().getValue(), installOutput.getFlowId());
				pathFlows.put(newpathNodes.get(newpathNodes.size()-1).getValue() + ":" + input.getDstIpAddress().getValue(), installOutput1.getFlowId());
			}
			else {
				String exception = "No Flow ID is provided as output from installFlowRule RPC";
				throw new Exception(exception);
			}
			*/
			index = 0;
			for (; index < oldpathNodes.size(); index++){
				if (newpathNodes.contains(oldpathNodes.get(index))) continue;
				//delete flow from the switch
				if (pathFlows.containsKey(oldpathNodes.get(index).getValue() + ":" + input.getDstIpAddress().getValue())){
					String flowIdStr = pathFlows.get(oldpathNodes.get(index).getValue() + ":" + input.getDstIpAddress().getValue());
                	
	            	FlowBuilder flowBuilder = new FlowBuilder();
	            	FlowKey key = new FlowKey(new FlowId(flowIdStr));
	            	flowBuilder.setFlowName(flowIdStr);
	            	flowBuilder.setKey(key);
	            	flowBuilder.setId(new FlowId(flowIdStr));
	            	flowBuilder.setTableId((short)0);
	                	
	            	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
	            			.child(Node.class, new NodeKey(oldpathNodes.get(index)))
	            			.augmentation(FlowCapableNode.class)
	            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
	            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
	            			.build();
	                	
	            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
	            	flowsInstalled.get(oldpathNodes.get(index)).remove(flowIdStr);
	            	pathFlows.remove(oldpathNodes.get(index).getValue() + ":" + input.getDstIpAddress().getValue());
				}
                
            	////=============================================
				if (pathFlows.containsKey(oldpathNodes.get(index).getValue() + ":" + input.getSrcIpAddress().getValue())){
					String flowIdStr1 = pathFlows.get(oldpathNodes.get(index).getValue() + ":" + input.getSrcIpAddress().getValue());
	            	
					FlowBuilder flowBuilder = new FlowBuilder();
					FlowKey key = new FlowKey(new FlowId(flowIdStr1));
	            	flowBuilder.setFlowName(flowIdStr1);
	            	flowBuilder.setKey(key);
	            	flowBuilder.setId(new FlowId(flowIdStr1));
	            	flowBuilder.setTableId((short)0);
	                	
	            	InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
	            			.child(Node.class, new NodeKey(oldpathNodes.get(index)))
	            			.augmentation(FlowCapableNode.class)
	            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
	            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
	            			.build();
	                	
	            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
	            	flowsInstalled.get(oldpathNodes.get(index)).remove(flowIdStr1);
	            	pathFlows.remove(oldpathNodes.get(index).getValue() + ":" + input.getSrcIpAddress().getValue());
				}
			}
			////////////////////////////////////////////////////////////////////////////
			
		} catch (Exception e) {
            LOG.error("Exception reached in MovePath RPC {} --------", e);
            output.setStatus("Path Couldn't be migrated.");
    		return RpcResultBuilder.success(output).buildFuture();
        }
		/*
		 * ------Do something for old path, one thing that we can readjust their idle timeout to small value
		 *  we can start this to begin-with. So, for each migration, the nodes in the oldPath are put to 
		 *  no flight zone for this src-destination pair. We can also extend the matching criteria from only
		 *  destination to src-destination both. So, whenever a new flow-removed msg is received then we can
		 *  do a simple look-up to confirm if flow nees to be restored or just leave it.
		 *  
		 *  Also Check what should be the flags of these newly installed flows
		 */
		
		output.setStatus("Path is successfully migrated.");
		return RpcResultBuilder.success(output).buildFuture();
		//return null;
	}
	
	
	@Override
	public Future<RpcResult<MigratePathOutput>> migratePath(
			final MigratePathInput input) {
		// This function migrates the traffic from one path to another in a new destination
		List<NodeId> oldpathNodes = input.getOldPathNodes();
		List<NodeId> newpathNodes = input.getNewPathNodes();
		
		Ipv4Prefix oldSrcIp = input.getOldSrcIpAddress();
		Ipv4Prefix newSrcIp = input.getNewSrcIpAddress();
		
		Ipv4Prefix oldDstIpAddress = input.getOldDstIpAddress();
		Ipv4Prefix newDstIpAddress = input.getNewDstIpAddress();
		
		Ipv4Prefix newSrcIpAddress;
		Ipv4Prefix oldSrcIpAddress;
		
		MigratePathOutputBuilder output = new MigratePathOutputBuilder();
		try {
			if (newSrcIp != null) {
				newSrcIpAddress = newSrcIp;
				oldSrcIpAddress = oldSrcIp;
			} else if(oldSrcIp != null && newSrcIp == null) {
				newSrcIpAddress = oldSrcIp;
				oldSrcIpAddress = oldSrcIp;
			} else {
				String exception = "Src not provided";
				throw new Exception(exception);
			}
			
			RepeatFunction func = new RepeatFunction() {	
				@Override
				public InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix dstIp,
						Ipv4Prefix srcIp, NodeId nodeid) {

					LOG.debug("		---------------------------------------------------------------------     ");
					LOG.debug("		Flow is Installed to the switch {}, using source {} and destination {}", nodeid.getValue(), srcIp.getValue(), dstIp.getValue());
					LOG.debug("     ---------------------------------------------------------------------     ");
					
					
					AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
					ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
					forwardBuilder.setOutputNodeConnector(outputPort);
					
					actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
							setForwardToPort(forwardBuilder.build()).build());
					actionBuilder.setId((long)1);
					List<AssociatedActions> actionList = Lists.newArrayList();
					actionList.add(actionBuilder.build());
					
					NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
					newFlowBuilder.setDstIpAddress(dstIp);
					//newFlowBuilder.setTrafficMatch(input.get)
					newFlowBuilder.setFlowPriority(input.getFlowPriority());
					newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
					newFlowBuilder.setHardTimeout(input.getHardTimeout());
					
					InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
					installFlowBuilder.setNode(nodeid);
					installFlowBuilder.setNewFlow(newFlowBuilder.build());
					installFlowBuilder.setAssociatedActions(actionList);
					return installFlowBuilder.build();
					
				}

				@Override
				public InstallFlowInput performFunction(
						NodeConnectorId outputPort, Ipv4Prefix curDstIp,
						Ipv4Prefix newDstIp, Ipv4Prefix curSrcIp,
						Ipv4Prefix newSrcIp, boolean setMac, NodeId nodeid) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
			
			//Delete flow rule from the old paths
			removeAllFlowRulesInPath(oldpathNodes, oldSrcIpAddress, oldDstIpAddress);
			
			//Install flow rule in the new paths
			installFlowRulesInPath(newpathNodes, newSrcIpAddress, newDstIpAddress, func);
			
		} catch (Exception e) {
            LOG.error("Exception reached in MovePath RPC {} --------", e);
            output.setStatus("Path Couldn't be migrated.");
    		return RpcResultBuilder.success(output).buildFuture();
        }
		/*
		 * ------Do something for old path, one thing that we can readjust their idle timeout to small value
		 *  we can start this to begin-with. So, for each migration, the nodes in the oldPath are put to 
		 *  no flight zone for this src-destination pair. We can also extend the matching criteria from only
		 *  destination to src-destination both. So, whenever a new flow-removed msg is received then we can
		 *  do a simple look-up to confirm if flow nees to be restored or just leave it.
		 *  
		 *  Also Check what should be the flags of these newly installed flows
		 */
		output.setStatus("Path is successfully migrated.");
		return RpcResultBuilder.success(output).buildFuture();
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	@Override
	public Future<RpcResult<InstallPathBwNodesOutput>> installPathBwNodes(
			final InstallPathBwNodesInput input) {
		// This will install the path between any two nodes and don't care about hosts connected to edge nodes
		
		List<NodeId> pathNodes = input.getPathNodes();
		InstallPathBwNodesOutputBuilder output = new InstallPathBwNodesOutputBuilder();
		if (pathNodes.size() <= 2 ){
			LOG.debug("         -------------------------------------------             ");
			LOG.debug("Short Path: No nodes in between edge nodes.");
			LOG.debug("         -------------------------------------------             ");
			
			output.setStatus("Short Path: No nodes in between edge nodes");
			return RpcResultBuilder.success(output).buildFuture();
		}
		///////////////////////////////////
		try {
			RepeatFunction func = new RepeatFunction() {	
				@Override
				public InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix dstIp,
						Ipv4Prefix srcIp, NodeId nodeid) {
					AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
					ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
					forwardBuilder.setOutputNodeConnector(outputPort);
					
					actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
							setForwardToPort(forwardBuilder.build()).build());
					actionBuilder.setId((long)1);
					List<AssociatedActions> actionList = Lists.newArrayList();
					actionList.add(actionBuilder.build());
					
					NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
					newFlowBuilder.setDstIpAddress(dstIp);
					newFlowBuilder.setFlowPriority(input.getFlowPriority());
					newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
					newFlowBuilder.setHardTimeout(input.getHardTimeout());
					
					InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
					installFlowBuilder.setNode(nodeid);
					installFlowBuilder.setNewFlow(newFlowBuilder.build());
					installFlowBuilder.setAssociatedActions(actionList);
					return installFlowBuilder.build();
					
				}

				@Override
				public InstallFlowInput performFunction(
						NodeConnectorId outputPort, Ipv4Prefix curDstIp,
						Ipv4Prefix newDstIp, Ipv4Prefix curSrcIp,
						Ipv4Prefix newSrcIp, boolean setMac, NodeId nodeid) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			int index = 0;
			for (; index < pathNodes.size(); index++){
				if (index == 0 || index == pathNodes.size() - 1) continue;
				
				//forwarding direction rule i.e., src -> dst
				Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index+1));
				if (neighbor != null){
					this.installFlow(func.performFunction(neighbor.getSrcPort(), 
							input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
				} else {
					String exception = "Neighbor " + pathNodes.get(index).getValue() + 
							" is not available for Node " + pathNodes.get(index+1).getValue();
					throw new Exception();
				}
				//Reverse direction rule  i.e., dst -> src
				Neighbors neighbor1 = getPortInformation(pathNodes.get(index), pathNodes.get(index-1));
				if (neighbor1 != null){
					this.installFlow(func.performFunction(neighbor1.getSrcPort(), 
							input.getSrcIpAddress(), input.getDstIpAddress(), pathNodes.get(index)));
				} else {
					String exception = "Neighbor " + pathNodes.get(index).getValue() + 
							" is not available for Node " + pathNodes.get(index-1).getValue();
					throw new Exception();
				}
			}
			////////////////////////////////////////////////////////////////////////////
			
		} catch (Exception e) {
            LOG.error("Exception reached in InstallPathBwNodes RPC {} --------", e);
            output.setStatus("Path Couldn't be Installed between Nodes.");
    		return RpcResultBuilder.success(output).buildFuture();
            
        }
		/*
		 * ------Do something for old path, one thing that we can readjust their idle timeout to small value
		 *  we can start this to begin-with. So, for each migration, the nodes in the oldPath are put to 
		 *  no flight zone for this src-destination pair. We can also extend the matching criteria from only
		 *  destination to src-destination both. So, whenever a new flow-removed msg is received then we can
		 *  do a simple look-up to confirm if flow nees to be restored or just leave it.
		 *  
		 *  Also Check what should be the flags of these newly installed flows
		 */
		
		output.setStatus("Path is successfully migrated.");
		return RpcResultBuilder.success(output).buildFuture();
	}

	
	@Override
	public Future<RpcResult<IpMutateEngineOutput>> ipMutateEngine(final IpMutateEngineInput input) {
		LOG.debug("     ==================================================================     ");
//		LOG.debug("          In mutateIp function: SourceIp {} and DestinationIp {}", input.getSrcIpAddress().getValue(), input.getDstIpAddress().getValue());
		LOG.debug("      ==================================================================     ");
		
		// This function will mutate the Ip addresses
		RepeatFunction func = new RepeatFunction() {	
			@Override
			public InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix curDstIp,
					Ipv4Prefix newDstIp, Ipv4Prefix curSrcIp, Ipv4Prefix newSrcIp, boolean setMac,
					NodeId nodeid) {
				
				LOG.debug("     ==================================================================     ");
				LOG.debug("     In mutateIp install Flow function: curDstIp {} and newDstIp {}"
						+ " curSrcIp {} newSrcIp {}", curDstIp.getValue(), newDstIp.getValue(), curSrcIp.getValue(), newSrcIp.getValue());
				LOG.debug("     ===================================================================     ");
				
				List<AssociatedActions> actionList = Lists.newArrayList();
				AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
				long actionKey = 1;
				if (curSrcIp.equals(newSrcIp) == false){
					SetSourceIpv4AddressBuilder srcIpBuilder = new SetSourceIpv4AddressBuilder();
					srcIpBuilder.setValue(newSrcIp);
					actionBuilder.setFlowActions(new SetSourceIpv4AddressCaseBuilder().
							setSetSourceIpv4Address(srcIpBuilder.build()).build());
					actionBuilder.setId(actionKey++);
					actionList.add(actionBuilder.build());
					/////////////////////////////////////
					ConnectedHost host = getHostInfo(newSrcIp.getValue());
					if (host != null && setMac){
						SetSrcMacAddressBuilder srcMacBuilder = new SetSrcMacAddressBuilder();
						srcMacBuilder.setValue(host.getHostMacAddress());
						actionBuilder.setFlowActions(new SetSrcMacAddressCaseBuilder().
								setSetSrcMacAddress(srcMacBuilder.build()).build());
						actionBuilder.setId(actionKey++);
						actionList.add(actionBuilder.build());
					}
				}
				if (curDstIp.equals(newDstIp) == false){
					SetDstIpv4AddressBuilder dstIpBuilder = new SetDstIpv4AddressBuilder();
					dstIpBuilder.setValue(newDstIp);
					actionBuilder.setFlowActions(new SetDstIpv4AddressCaseBuilder().
							setSetDstIpv4Address(dstIpBuilder.build()).build());
					actionBuilder.setId(actionKey++);
					actionList.add(actionBuilder.build());
					//////////////////////////
					ConnectedHost host = getHostInfo(newDstIp.getValue());
					if (host != null && setMac){
						SetDstMacAddressBuilder dstMacBuilder = new SetDstMacAddressBuilder();
						dstMacBuilder.setValue(host.getHostMacAddress());
						actionBuilder.setFlowActions(new SetDstMacAddressCaseBuilder().
								setSetDstMacAddress(dstMacBuilder.build()).build());
						actionBuilder.setId(actionKey++);
						actionList.add(actionBuilder.build());
					}
				}
				
				ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
				forwardBuilder.setOutputNodeConnector(outputPort);
				
				actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
						setForwardToPort(forwardBuilder.build()).build());
				actionBuilder.setId(actionKey++);
				actionList.add(actionBuilder.build());
				
				NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
				newFlowBuilder.setDstIpAddress(curDstIp);
				newFlowBuilder.setSrcIpAddress(curSrcIp);
				newFlowBuilder.setFlowPriority(input.getFlowPriority());
				newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
				newFlowBuilder.setHardTimeout(input.getHardTimeout());
				
				InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
				installFlowBuilder.setNode(nodeid);
				installFlowBuilder.setNewFlow(newFlowBuilder.build());
				
				installFlowBuilder.setAssociatedActions(actionList);
				return installFlowBuilder.build();
				
			}

			@Override
			public InstallFlowInput performFunction(NodeConnectorId outputPort,
					Ipv4Prefix dstIp, Ipv4Prefix srcIp, NodeId nodeid) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		IpMutateEngineOutputBuilder output = new IpMutateEngineOutputBuilder();
		try{
			Neighbors srcEdgeNeighbor = getPortInformation(input.getPathNodes().get(0), input.getPathNodes().get(1));
			Neighbors dstEdgeNeighbor = getPortInformation(input.getPathNodes().get(input.getPathNodes().size()-1), 
					input.getPathNodes().get(input.getPathNodes().size()-2));
				
			Ipv4Prefix rIpSrc = input.getNewSrcIpAddress();
			Ipv4Prefix rIpDst = input.getNewDstIpAddress();
			Ipv4Prefix vIpSrc = input.getOldSrcIpAddress();
			Ipv4Prefix vIpDst = input.getOldDstIpAddress();
					
			
//			LOG.debug("     ==================================================================     ");
//			LOG.debug("     For mutation we found, rIpSrc {}, rIpDst{}, vIpSrc {}, vIpDst{}", rIpSrc.getValue(), rIpDst.getValue(),
//					vIpSrc.getValue(), vIpDst.getValue());
//			LOG.debug("     ==================================================================     ");
			
			List<NodeId> pathNodes = Lists.newArrayList();
			pathNodes.add(input.getPathNodes().get(0));
			pathNodes.add(input.getPathNodes().get(input.getPathNodes().size() -1));
//			
//			removeAllFlowRulesInPath(pathNodes , vIpSrc, vIpDst);
//			List gateways = Lists.newArrayList();
//			gateways.add(pathNodes.get(0));
//			gateways.add(pathNodes.get(pathNodes.size()-1));
//			removeAllFlowRulesInPath(gateways , rIpSrc, rIpDst);
			removeAllFlowRulesInPath(pathNodes , rIpSrc, rIpDst);
			
			ConnectedHost srcHost = getHostInfo(rIpSrc.getValue());
			ConnectedHost dstHost = getHostInfo(rIpDst.getValue());
			

//			LOG.debug("     ==================================================================     ");
//			LOG.debug("     And srcHost {}, dstHost{}", srcHost.getNodeConnectedTo().getValue(), dstHost.getNodeConnectedTo().getValue());
//			LOG.debug("     ==================================================================     ");
			
//			Lets assume the condition, rIp's are h1,h2 and vIp's are h3,h4
//			First switch: going to destination
//			What we got		h1 --> h4
//			what we want	h1 --> h2	MAC change
//			rIpSrc = h1 //these four are fixed
//			rIpDst = h2
//			vIpSrc = h3
//			vIpDst = h4
// 			So change will be like: for destination: h4->h2, for source: h1->h1
			this.installFlow(func.performFunction(srcEdgeNeighbor.getSrcPort(), 
					vIpDst, rIpDst,	rIpSrc, rIpSrc, true,
					input.getPathNodes().get(0)));

			//			Lets assume the condition, rIp's are h1,h2 and vIp's are h3,h4
//			First switch: going to destination
//			What we got 	h2 --> h1 
//			What we want	h4 --> h1 NO MAC change
//			rIpSrc = h1 //these four are fixed
//			rIpDst = h2
//			vIpSrc = h3
//			vIpDst = h4
// 			So change will be like: for destination: h1->h1, for source: h2->h4
			this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(),
					rIpSrc, rIpSrc, rIpDst, vIpDst, false,
					input.getPathNodes().get(0)));
			
//			Lets assume the condition, rIp's are h1,h2 and vIp's are h3,h4
//			Last switch: going to destination
//			What we got 	h1 --> h2
//			What we want	h3 --> h2 NO MAC change
//			rIpSrc = h1 //these four are fixed
//			rIpDst = h2
//			vIpSrc = h3
//			vIpDst = h4
// 			So change will be like: for destination: h2->h2, for source: h1->h3
			this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
						rIpDst, rIpDst, rIpSrc, vIpSrc, false,
						input.getPathNodes().get(input.getPathNodes().size()-1)));
			
//			Lets assume the condition, rIp's are h1,h2 and vIp's are h3,h4
//			Last switch: going to source
//			What we got		h2 --> h3 
//			What we want	h2 --> h1 MAC change
//			rIpSrc = h1 //these four are fixed
//			rIpDst = h2
//			vIpSrc = h3
//			vIpDst = h4
// 			So change will be like: for destination: h3->h1, for source: h2->h2
			this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
					vIpSrc, rIpSrc, rIpDst, rIpDst, true,
					input.getPathNodes().get(input.getPathNodes().size()-1)));

		} catch (Exception e) {
            LOG.error("Exception reached in MutateIP RPC {} --------", e);
            output.setStatus("IP couldn't be mutated.");
    		return RpcResultBuilder.success(output).buildFuture();
        }
		
		output.setStatus("IP is successfully mutated.");
		return RpcResultBuilder.success(output).buildFuture();
	}
	
//	@Override
//	public Future<RpcResult<MutateIpOutput>> mutateIp(final MutateIpInput input) {
//		
//		LOG.debug("     ==================================================================     ");
//		LOG.debug("          In mutateIp function: SourceIp {} and DestinationIp {}", input.getSrcIpAddress().getValue(), input.getDstIpAddress().getValue());
//		LOG.debug("      ==================================================================     ");
//		// This function will mutate the Ip addresses
//		RepeatFunction func = new RepeatFunction() {	
//			@Override
//			public InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix curDstIp,
//					Ipv4Prefix newDstIp, Ipv4Prefix curSrcIp, Ipv4Prefix newSrcIp,  boolean setMac,
//					NodeId nodeid) {
//				
//				LOG.debug("     ==================================================================     ");
//				LOG.debug("     In mutateIp install Flow function: curDstIp {} and newDstIp {}"
//						+ " curSrcIp {} newSrcIp {}", curDstIp.getValue(), newDstIp.getValue(), curSrcIp.getValue(), newSrcIp.getValue());
//				LOG.debug("     ===================================================================     ");
//				
//				List<AssociatedActions> actionList = Lists.newArrayList();
//				AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
//				long actionKey = 1;
//				if (curSrcIp.equals(newSrcIp) == false){
//					SetSourceIpv4AddressBuilder srcIpBuilder = new SetSourceIpv4AddressBuilder();
//					srcIpBuilder.setValue(newSrcIp);
//					actionBuilder.setFlowActions(new SetSourceIpv4AddressCaseBuilder().
//							setSetSourceIpv4Address(srcIpBuilder.build()).build());
//					actionBuilder.setId(actionKey++);
//					actionList.add(actionBuilder.build());
//					/////////////////////////////////////
//					ConnectedHost host = getHostInfo(newSrcIp.getValue());
//					if (host != null){
//						SetSrcMacAddressBuilder srcMacBuilder = new SetSrcMacAddressBuilder();
//						srcMacBuilder.setValue(host.getHostMacAddress());
//						actionBuilder.setFlowActions(new SetSrcMacAddressCaseBuilder().
//								setSetSrcMacAddress(srcMacBuilder.build()).build());
//						actionBuilder.setId(actionKey++);
//						actionList.add(actionBuilder.build());
//					}
//				}
//				if (curDstIp.equals(newDstIp) == false){
//					SetDstIpv4AddressBuilder dstIpBuilder = new SetDstIpv4AddressBuilder();
//					dstIpBuilder.setValue(newDstIp);
//					actionBuilder.setFlowActions(new SetDstIpv4AddressCaseBuilder().
//							setSetDstIpv4Address(dstIpBuilder.build()).build());
//					actionBuilder.setId(actionKey++);
//					actionList.add(actionBuilder.build());
//					//////////////////////////
//					ConnectedHost host = getHostInfo(newDstIp.getValue());
//					if (host != null){
//						SetDstMacAddressBuilder dstMacBuilder = new SetDstMacAddressBuilder();
//						dstMacBuilder.setValue(host.getHostMacAddress());
//						actionBuilder.setFlowActions(new SetDstMacAddressCaseBuilder().
//								setSetDstMacAddress(dstMacBuilder.build()).build());
//						actionBuilder.setId(actionKey++);
//						actionList.add(actionBuilder.build());
//					}
//				}
//				
//				ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
//				forwardBuilder.setOutputNodeConnector(outputPort);
//				
//				actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
//						setForwardToPort(forwardBuilder.build()).build());
//				actionBuilder.setId(actionKey++);
//				actionList.add(actionBuilder.build());
//				
//				NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
//				newFlowBuilder.setDstIpAddress(curDstIp);
//				newFlowBuilder.setSrcIpAddress(curSrcIp);
//				newFlowBuilder.setFlowPriority(input.getFlowPriority());
//				newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
//				newFlowBuilder.setHardTimeout(input.getHardTimeout());
//				
//				InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
//				installFlowBuilder.setNode(nodeid);
//				installFlowBuilder.setNewFlow(newFlowBuilder.build());
//				
//				installFlowBuilder.setAssociatedActions(actionList);
//				return installFlowBuilder.build();
//				
//			}
//
//			@Override
//			public InstallFlowInput performFunction(NodeConnectorId outputPort,
//					Ipv4Prefix dstIp, Ipv4Prefix srcIp, NodeId nodeid) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		
//		MutateIpOutputBuilder output = new MutateIpOutputBuilder();
//		try{
//			//LOG.debug("  ===========================================   ");
//			//LOG.debug(input.getPathNodes().toString());
//			//LOG.debug("  ===========================================   ");
//			
////			ConnectedHost srcHost = getHostInfo(input.getSrcIpAddress().getValue());
////			if (srcHost == null){
////				String exception = "Source Host " + input.getSrcIpAddress().getValue() + 
////						" is not known to controller ";
////				throw new Exception(exception);
////			} else if (srcHost.getNodeConnectedTo().equals(input.getPathNodes().get(0)) == false ){
////				//LOG.debug("  ===========================================   ");
////				//LOG.debug(input.getPathNodes().get(0).getValue());
////				//LOG.debug("  ===========================================   ");
////				String exception = "Source Host " + input.getSrcIpAddress().getValue() + 
////						" is not known connected to node " + input.getPathNodes().get(0).getValue();
////				throw new Exception(exception);
////			}
//			/////////////////
//			ConnectedHost dstHost = getHostInfo(input.getDstIpAddress().getValue());
//			if (dstHost == null){
//				String exception = "Dst Host " + input.getDstIpAddress().getValue() + 
//						" is not known to controller ";
//				throw new Exception(exception);
//			} 
////			else if (dstHost.getNodeConnectedTo().equals(input.getPathNodes().get(input.getPathNodes().size()-1)) == false ){
////				String exception = "Dst Host " + input.getDstIpAddress().getValue() + 
////						" is not known connected to node " + input.getPathNodes().get(input.getPathNodes().size()-1).getValue();
////				throw new Exception(exception);
////			}
//			//////////////////////
//			Neighbors srcEdgeNeighbor = getPortInformation(input.getPathNodes().get(0), input.getPathNodes().get(1));
////			if (srcEdgeNeighbor == null){
////				String exception = "Soure Edge Node" + input.getPathNodes().get(0).getValue() + 
////						" is not neighbor with " + input.getPathNodes().get(1).getValue();
////				throw new Exception(exception);
////			}
//			Neighbors dstEdgeNeighbor = getPortInformation(input.getPathNodes().get(input.getPathNodes().size()-1), 
//					input.getPathNodes().get(input.getPathNodes().size()-2));
////			if (dstEdgeNeighbor == null){
////				String exception = "Dst Edge Node" + input.getPathNodes().get(input.getPathNodes().size()-1).getValue() + 
////						" is not neighbor with " + input.getPathNodes().get(input.getPathNodes().size()-2).getValue();
////				throw new Exception(exception);
////			}
//			////////////////////////////////////////////////
//			/*
//			if (input.getMutationEnd() instanceof SourceOnlyCase){
//				SourceOnlyCase srcOnlyCase = (SourceOnlyCase) input.getMutationEnd();
//				InstallPathBwNodesInputBuilder pathInputBuilder = new InstallPathBwNodesInputBuilder();
//				pathInputBuilder.setDstIpAddress(input.getDstIpAddress());
//				pathInputBuilder.setSrcIpAddress(srcOnlyCase.getSourceOnly().getNewSrcIpAddress());
//				pathInputBuilder.setPathNodes(input.getPathNodes());
//				pathInputBuilder.setFlowPriority(input.getFlowPriority());
//				pathInputBuilder.setIdleTimeout(input.getIdleTimeout());
//				pathInputBuilder.setHardTimeout(input.getHardTimeout());
//				this.installPathBwNodes(pathInputBuilder.build());
//				
//				//On source edge node, SrcHost will be the destination and its traffic will reach with changed DstIp 
//				//so we have to revert it back to original srcHost IP
//				this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(), 
//						srcOnlyCase.getSourceOnly().getNewSrcIpAddress(),
//						input.getSrcIpAddress(), input.getDstIpAddress(), input.getDstIpAddress(), 
//						input.getPathNodes().get(0)));
//				
//				//On source edge node, if SrcHost is the source then going to dstHost then we need to change its identity 
//				//for the network and change the srcIp of packet to newSrcIP and leave the dstHost intact
//				this.installFlow(func.performFunction(srcEdgeNeighbor.getSrcPort(), 
//						input.getDstIpAddress(), input.getDstIpAddress(), 
//						input.getSrcIpAddress(), srcOnlyCase.getSourceOnly().getNewSrcIpAddress(), 
//						input.getPathNodes().get(0)));
//				
//				//On Destination edge node, if newSrcHostIP is the source then going to dstHost then we need to change its identity 
//				//back to original srcHost IP so that the dstHost can recognize it
//				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
//						input.getDstIpAddress(), input.getDstIpAddress(),
//						srcOnlyCase.getSourceOnly().getNewSrcIpAddress(),
//						input.getSrcIpAddress(),
//						input.getPathNodes().get(input.getPathNodes().size()-1)));
//				
//				//On Destination edge node, SrcHostIP will be the destination and its traffic Identity should be hidden from the  
//				//network, so the DstIP of the packet will be changed from actualSrcHostIP to newIP
//				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
//						input.getSrcIpAddress(), 
//						srcOnlyCase.getSourceOnly().getNewSrcIpAddress(),
//						input.getDstIpAddress(), input.getDstIpAddress(), 
//						input.getPathNodes().get(input.getPathNodes().size()-1)));
//				
//			} ///////////////////////////////
//			else if (input.getMutationEnd() instanceof DstOnlyCase){
//				DstOnlyCase dstOnlyCase = (DstOnlyCase) input.getMutationEnd();
//<<<<<<< HEAD
//				
////				InstallPathBwNodesInputBuilder pathInputBuilder = new InstallPathBwNodesInputBuilder();
////				pathInputBuilder.setDstIpAddress(dstOnlyCase.getDstOnly().getNewDstIpAddress());
////				pathInputBuilder.setSrcIpAddress(input.getSrcIpAddress());
////				pathInputBuilder.setPathNodes(input.getPathNodes());
////				pathInputBuilder.setFlowPriority(input.getFlowPriority());
////				pathInputBuilder.setIdleTimeout(input.getIdleTimeout());
////				pathInputBuilder.setHardTimeout(input.getHardTimeout());
////				this.installPathBwNodes(pathInputBuilder.build());
//=======
//				InstallPathBwNodesInputBuilder pathInputBuilder = new InstallPathBwNodesInputBuilder();
//				pathInputBuilder.setDstIpAddress(dstOnlyCase.getDstOnly().getNewDstIpAddress());
//				pathInputBuilder.setSrcIpAddress(input.getSrcIpAddress());
//				pathInputBuilder.setPathNodes(input.getPathNodes());
//				pathInputBuilder.setFlowPriority(input.getFlowPriority());
//				pathInputBuilder.setIdleTimeout(input.getIdleTimeout());
//				pathInputBuilder.setHardTimeout(input.getHardTimeout());
//				//this.installPathBwNodes(pathInputBuilder.build());
//>>>>>>> 7edbdd9c6d5550e8d69859d7b10e48d5f9aa8092
//				
//				//On source edge node, dstHostIP is the actual destination, however its traffic should be hidden from the network 
//				//so we change the IP destination of packets from actual dstHostIP to new IP
//				this.installFlow(func.performFunction(srcEdgeNeighbor.getSrcPort(), 
//						input.getDstIpAddress(), dstOnlyCase.getDstOnly().getNewDstIpAddress(), 
//						input.getSrcIpAddress(), input.getSrcIpAddress(), 
//						input.getPathNodes().get(0)));
//				
//				//On source edge node, if SrcHost is the destination then all packets coming from actual dstHostIP are mutated 
//				//in their srcIP address field, so before we forward these packets to srcHost, we need to switch them back original dstIP
//				this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(), 
//<<<<<<< HEAD
//=======
//						input.getSrcIpAddress(),  input.getSrcIpAddress(),
//						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
//						input.getDstIpAddress(),					 
//						input.getPathNodes().get(0)));
//				
//				ConnectedHost newDstHost = getHostInfo(dstOnlyCase.getDstOnly().getNewDstIpAddress().getValue());
//				if (newDstHost == null){
//					String exception = "New Dst Host " + input.getDstIpAddress().getValue() + 
//							" is not known to controller ";
//					throw new Exception(exception);
//				}
//				//LOG.debug("((((((((((((((((((((((((New Dst Host is {} )))))))))))))))))))))", newDstHost.getHostIpAddress().getValue());
//				////-------------------------------------------------------------------------------------------------------------/////
//				///-----This code is only temporary fix for the video to install flow rules at the destination edge router ------/////
//				////------------------------------------------------------------------------------------------------------------/////
//				//on Dst Edge node, if traffic coming from SrcHost for dstHost will be mutated in dstIP as we hide the identity of dstHost  
//				//from network. So, we have to now change the mutated dstIP to original dstIp of the dstHost
//				this.installFlow(func.performFunction(newDstHost.getNodeConnectorConnectedTo(), 
//						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
//						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
//						input.getSrcIpAddress(), input.getSrcIpAddress(),
//						input.getPathNodes().get(input.getPathNodes().size()-1)));
//				
//				//On Destination edge node, any traffic originating from dstHost will have its IP address and we have to hide its identity from   
//				//the network. So we change the srcIP of packets from actual dstHost to mutated IP
//				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
//						input.getSrcIpAddress(), input.getSrcIpAddress(),
//						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
//						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
//						input.getPathNodes().get(input.getPathNodes().size()-1)));
//				
//				/*
//				//on Dst Edge node, if traffic coming from SrcHost for dstHost will be mutated in dstIP as we hide the identity of dstHost  
//				//from network. So, we have to now change the mutated dstIP to original dstIp of the dstHost
//				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
//						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
//						input.getDstIpAddress(),
//>>>>>>> 7edbdd9c6d5550e8d69859d7b10e48d5f9aa8092
//						input.getSrcIpAddress(), input.getSrcIpAddress(),
//						input.getDstIpAddress(), dstOnlyCase.getDstOnly().getNewDstIpAddress(),					 
//						input.getPathNodes().get(0)));
//				
//<<<<<<< HEAD
////				//on Dst Edge node, if traffic coming from SrcHost for dstHost will be mutated in dstIP as we hide the identity of dstHost  
////				//from network. So, we have to now change the mutated dstIP to original dstIp of the dstHost
////				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
////						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
////						input.getDstIpAddress(),
////						input.getSrcIpAddress(), input.getSrcIpAddress(),
////						input.getPathNodes().get(input.getPathNodes().size()-1)));
////				
////				//On Destination edge node, any traffic originating from dstHost will have its IP address and we have to hide its identity from   
////				//the network. So we change the srcIP of packets from actual dstHost to mutated IP
////				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
////						input.getSrcIpAddress(), input.getSrcIpAddress(),
////						input.getDstIpAddress(),
////						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
////						input.getPathNodes().get(input.getPathNodes().size()-1)));
//=======
//				//On Destination edge node, any traffic originating from dstHost will have its IP address and we have to hide its identity from   
//				//the network. So we change the srcIP of packets from actual dstHost to mutated IP
//				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
//						input.getSrcIpAddress(), input.getSrcIpAddress(),
//						input.getDstIpAddress(),
//						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
//						input.getPathNodes().get(input.getPathNodes().size()-1)));
//			else */
//				
//			if (input.getMutationEnd() instanceof BothCase){
//				BothCase bothCase = (BothCase) input.getMutationEnd();
//				Ipv4Prefix rIpSrc = bothCase.getBoth().getNewSrcIpAddress();
//				Ipv4Prefix rIpDst = bothCase.getBoth().getNewDstIpAddress();
//				Ipv4Prefix vIpSrc = input.getSrcIpAddress();
//				Ipv4Prefix vIpDst = input.getDstIpAddress();
//						
//				
//				LOG.debug("     ==================================================================     ");
//				LOG.debug("     For mutation we found, rIpSrc {}, rIpDst{}, vIpSrc {}, vIpDst{}", rIpSrc.getValue(), rIpDst.getValue(),
//						vIpSrc.getValue(), vIpDst.getValue());
//				LOG.debug("     ==================================================================     ");
//				
//				List<NodeId> pathNodes = Lists.newArrayList();
//				pathNodes.add(input.getPathNodes().get(0));
//				pathNodes.add(input.getPathNodes().get(input.getPathNodes().size() -1));
//				
////				removeAllFlowRulesInPath(pathNodes , bothCase.getBoth().getNewSrcIpAddress(), bothCase.getBoth().getNewDstIpAddress());
////				removeAllFlowRulesInPath(pathNodes , rIpSrc, rIpDst);
//				
////				ConnectedHost srcHost = getHostInfo(input.getSrcIpAddress().getValue());
//				ConnectedHost srcHost = getHostInfo(rIpSrc.getValue());
////				ConnectedHost dstHost = getHostInfo(input.getDstIpAddress().getValue());
//				ConnectedHost dstHost1 = getHostInfo(rIpDst.getValue());
//				
//
//				LOG.debug("     ==================================================================     ");
//				LOG.debug("     And srcHost {}, dstHost{}", srcHost.getNodeConnectedTo().getValue(), dstHost1.getNodeConnectedTo().getValue());
//				LOG.debug("     ==================================================================     ");
//				//On source edge node, traffic generated by actual srcHost for actual dstHost but we have to 
//				//mutate their identities
////				this.installFlow(func.performFunction(srcEdgeNeighbor.getSrcPort(), 
////						input.getDstIpAddress(), bothCase.getBoth().getNewDstIpAddress(),
////						input.getSrcIpAddress(), bothCase.getBoth().getNewSrcIpAddress(), 
////						input.getPathNodes().get(0)));
//				this.installFlow(func.performFunction(srcEdgeNeighbor.getSrcPort(), 
//						vIpDst, rIpDst,	vIpSrc, rIpSrc, false,
//						input.getPathNodes().get(0)));
//				
//				//On source edge node, traffic coming from mutated dstHost IP to mutated srcHost IP should be 
//				//reverted back to their identities
////				this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(), 
////						bothCase.getBoth().getNewSrcIpAddress(), input.getSrcIpAddress(),
////						bothCase.getBoth().getNewDstIpAddress(), input.getDstIpAddress(), 
////						input.getPathNodes().get(0)));
//				this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(),
//						rIpSrc, vIpSrc, rIpDst, vIpDst, false,
//						input.getPathNodes().get(0)));
//				
//				//On dst edge node, traffic coming for actual dstHost is mutated in both src and dst IPs
//				//so we have to revert it back before we hand this over to dstHost
////				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
////						bothCase.getBoth().getNewDstIpAddress(), input.getDstIpAddress(),
////						bothCase.getBoth().getNewSrcIpAddress(), input.getSrcIpAddress(),
////						input.getPathNodes().get(input.getPathNodes().size()-1)));
//				
////				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
////						rIpDst, rIpDst, rIpSrc, vIpSrc,
////						input.getPathNodes().get(input.getPathNodes().size()-1)));
//				
//				//On dst edge node, traffic originated from dstHost for srcHost, we have to mutate both IPs 
//				//to hide their identities from the network
////				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
////						input.getSrcIpAddress(), bothCase.getBoth().getNewSrcIpAddress(),
////						input.getDstIpAddress(), bothCase.getBoth().getNewDstIpAddress(),
////						input.getPathNodes().get(input.getPathNodes().size()-1)));
//
////				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
////						vIpSrc, rIpSrc, rIpDst, rIpDst,
////						input.getPathNodes().get(input.getPathNodes().size()-1)));
//				
////				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
////						vIpSrc, rIpSrc, vIpDst, rIpDst,
////						input.getPathNodes().get(input.getPathNodes().size()-1)));
//				
//			}
//			
//			
//		} catch (Exception e) {
//            LOG.error("Exception reached in MutateIP RPC {} --------", e);
//            output.setStatus("IP couldn't be mutated.");
//    		return RpcResultBuilder.success(output).buildFuture();
//        }
//		
//		output.setStatus("IP is successfully mutated.");
//		return RpcResultBuilder.success(output).buildFuture();
//	}
	
	public Future<RpcResult<MutateIpOutput>> mutateIp(final MutateIpInput input) {
		
		LOG.debug("     ==================================================================     ");
		LOG.debug("          In mutateIp function: SourceIp {} and DestinationIp {}", input.getSrcIpAddress().getValue(), input.getDstIpAddress().getValue());
		LOG.debug("      ==================================================================     ");
		// This function will mutate the Ip addresses
		RepeatFunction func = new RepeatFunction() {	
			@Override
			public InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix curDstIp,
					Ipv4Prefix newDstIp, Ipv4Prefix curSrcIp, Ipv4Prefix newSrcIp, boolean setMac,
					NodeId nodeid) {
				List<AssociatedActions> actionList = Lists.newArrayList();
				AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
				long actionKey = 1;
				if (curSrcIp.equals(newSrcIp) == false){
					SetSourceIpv4AddressBuilder srcIpBuilder = new SetSourceIpv4AddressBuilder();
					srcIpBuilder.setValue(newSrcIp);
					actionBuilder.setFlowActions(new SetSourceIpv4AddressCaseBuilder().
							setSetSourceIpv4Address(srcIpBuilder.build()).build());
					actionBuilder.setId(actionKey++);
					actionList.add(actionBuilder.build());
				}
				if (curDstIp.equals(newDstIp) == false){
					SetDstIpv4AddressBuilder dstIpBuilder = new SetDstIpv4AddressBuilder();
					dstIpBuilder.setValue(newDstIp);
					actionBuilder.setFlowActions(new SetDstIpv4AddressCaseBuilder().
							setSetDstIpv4Address(dstIpBuilder.build()).build());
					actionBuilder.setId(actionKey++);
					actionList.add(actionBuilder.build());
				}
				
				ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
				forwardBuilder.setOutputNodeConnector(outputPort);
				
				actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
						setForwardToPort(forwardBuilder.build()).build());
				actionBuilder.setId(actionKey++);
				actionList.add(actionBuilder.build());
				
				NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
				newFlowBuilder.setDstIpAddress(curDstIp);
				newFlowBuilder.setSrcIpAddress(curSrcIp);
				newFlowBuilder.setFlowPriority(input.getFlowPriority());
				newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
				newFlowBuilder.setHardTimeout(input.getHardTimeout());
				
				InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
				installFlowBuilder.setNode(nodeid);
				installFlowBuilder.setNewFlow(newFlowBuilder.build());
				
				installFlowBuilder.setAssociatedActions(actionList);
				return installFlowBuilder.build();
				
			}

			@Override
			public InstallFlowInput performFunction(NodeConnectorId outputPort,
					Ipv4Prefix dstIp, Ipv4Prefix srcIp, NodeId nodeid) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		MutateIpOutputBuilder output = new MutateIpOutputBuilder();
		try{
			//LOG.debug("  ===========================================   ");
			//LOG.debug(input.getPathNodes().toString());
			//LOG.debug("  ===========================================   ");
			
			ConnectedHost srcHost = getHostInfo(input.getSrcIpAddress().getValue());
			if (srcHost == null){
				String exception = "Source Host " + input.getSrcIpAddress().getValue() + 
						" is not known to controller ";
				throw new Exception(exception);
			} else if (srcHost.getNodeConnectedTo().equals(input.getPathNodes().get(0)) == false ){
				//LOG.debug("  ===========================================   ");
				//LOG.debug(input.getPathNodes().get(0).getValue());
				//LOG.debug("  ===========================================   ");
				String exception = "Source Host " + input.getSrcIpAddress().getValue() + 
						" is not known connected to node " + input.getPathNodes().get(0).getValue();
				throw new Exception(exception);
			}
			/////////////////
			ConnectedHost dstHost = getHostInfo(input.getDstIpAddress().getValue());
			if (dstHost == null){
				String exception = "Dst Host " + input.getDstIpAddress().getValue() + 
						" is not known to controller ";
				throw new Exception(exception);
			} else if (dstHost.getNodeConnectedTo().equals(input.getPathNodes().get(input.getPathNodes().size()-1)) == false ){
				String exception = "Dst Host " + input.getDstIpAddress().getValue() + 
						" is not known connected to node " + input.getPathNodes().get(input.getPathNodes().size()-1).getValue();
				throw new Exception(exception);
			}
			//////////////////////
			Neighbors srcEdgeNeighbor = getPortInformation(input.getPathNodes().get(0), input.getPathNodes().get(1));
			if (srcEdgeNeighbor == null){
				String exception = "Soure Edge Node" + input.getPathNodes().get(0).getValue() + 
						" is not neighbor with " + input.getPathNodes().get(1).getValue();
				throw new Exception(exception);
			}
			Neighbors dstEdgeNeighbor = getPortInformation(input.getPathNodes().get(input.getPathNodes().size()-1), 
					input.getPathNodes().get(input.getPathNodes().size()-2));
			if (dstEdgeNeighbor == null){
				String exception = "Dst Edge Node" + input.getPathNodes().get(input.getPathNodes().size()-1).getValue() + 
						" is not neighbor with " + input.getPathNodes().get(input.getPathNodes().size()-2).getValue();
				throw new Exception(exception);
			}
			////////////////////////////////////////////////
			if (input.getMutationEnd() instanceof SourceOnlyCase){
				SourceOnlyCase srcOnlyCase = (SourceOnlyCase) input.getMutationEnd();
				InstallPathBwNodesInputBuilder pathInputBuilder = new InstallPathBwNodesInputBuilder();
				pathInputBuilder.setDstIpAddress(input.getDstIpAddress());
				pathInputBuilder.setSrcIpAddress(srcOnlyCase.getSourceOnly().getNewSrcIpAddress());
				pathInputBuilder.setPathNodes(input.getPathNodes());
				pathInputBuilder.setFlowPriority(input.getFlowPriority());
				pathInputBuilder.setIdleTimeout(input.getIdleTimeout());
				pathInputBuilder.setHardTimeout(input.getHardTimeout());
				this.installPathBwNodes(pathInputBuilder.build());
				
				//On source edge node, SrcHost will be the destination and its traffic will reach with changed DstIp 
				//so we have to revert it back to original srcHost IP
				this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(), 
						srcOnlyCase.getSourceOnly().getNewSrcIpAddress(),
						input.getSrcIpAddress(), input.getDstIpAddress(), input.getDstIpAddress(), 
						false, input.getPathNodes().get(0)));
				
				//On source edge node, if SrcHost is the source then going to dstHost then we need to change its identity 
				//for the network and change the srcIp of packet to newSrcIP and leave the dstHost intact
				this.installFlow(func.performFunction(srcEdgeNeighbor.getSrcPort(), 
						input.getDstIpAddress(), input.getDstIpAddress(), 
						input.getSrcIpAddress(), srcOnlyCase.getSourceOnly().getNewSrcIpAddress(), 
						false, input.getPathNodes().get(0)));
				
				//On Destination edge node, if newSrcHostIP is the source then going to dstHost then we need to change its identity 
				//back to original srcHost IP so that the dstHost can recognize it
				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
						input.getDstIpAddress(), input.getDstIpAddress(),
						srcOnlyCase.getSourceOnly().getNewSrcIpAddress(),
						input.getSrcIpAddress(),
						false, input.getPathNodes().get(input.getPathNodes().size()-1)));
				
				//On Destination edge node, SrcHostIP will be the destination and its traffic Identity should be hidden from the  
				//network, so the DstIP of the packet will be changed from actualSrcHostIP to newIP
				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
						input.getSrcIpAddress(), 
						srcOnlyCase.getSourceOnly().getNewSrcIpAddress(),
						input.getDstIpAddress(), input.getDstIpAddress(), 
						false, input.getPathNodes().get(input.getPathNodes().size()-1)));
				
			} ///////////////////////////////
			else if (input.getMutationEnd() instanceof DstOnlyCase){
				DstOnlyCase dstOnlyCase = (DstOnlyCase) input.getMutationEnd();
				InstallPathBwNodesInputBuilder pathInputBuilder = new InstallPathBwNodesInputBuilder();
				pathInputBuilder.setDstIpAddress(dstOnlyCase.getDstOnly().getNewDstIpAddress());
				pathInputBuilder.setSrcIpAddress(input.getSrcIpAddress());
				pathInputBuilder.setPathNodes(input.getPathNodes());
				pathInputBuilder.setFlowPriority(input.getFlowPriority());
				pathInputBuilder.setIdleTimeout(input.getIdleTimeout());
				pathInputBuilder.setHardTimeout(input.getHardTimeout());
				this.installPathBwNodes(pathInputBuilder.build());
				
				//On source edge node, dstHostIP is the actual destination, however its traffic should be hidden from the network 
				//so we change the IP destination of packets from actual dstHostIP to new IP
				this.installFlow(func.performFunction(srcEdgeNeighbor.getSrcPort(), 
						input.getDstIpAddress(),
						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
						input.getSrcIpAddress(),  input.getSrcIpAddress(), 
						false, input.getPathNodes().get(0)));
				
				//On source edge node, if SrcHost is the destination then all packets coming from actual dstHostIP are mutated 
				//in their srcIP address field, so before we forward these packets to srcHost, we need to switch them back original dstIP
				this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(), 
						input.getSrcIpAddress(),  input.getSrcIpAddress(),
						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
						input.getDstIpAddress(),					 
						false, input.getPathNodes().get(0)));
				
				//on Dst Edge node, if traffic coming from SrcHost for dstHost will be mutated in dstIP as we hide the identity of dstHost  
				//from network. So, we have to now change the mutated dstIP to original dstIp of the dstHost
				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
						input.getDstIpAddress(),
						input.getSrcIpAddress(), input.getSrcIpAddress(),
						false, input.getPathNodes().get(input.getPathNodes().size()-1)));
				
				//On Destination edge node, any traffic originating from dstHost will have its IP address and we have to hide its identity from   
				//the network. So we change the srcIP of packets from actual dstHost to mutated IP
				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
						input.getSrcIpAddress(), input.getSrcIpAddress(),
						input.getDstIpAddress(),
						dstOnlyCase.getDstOnly().getNewDstIpAddress(),
						false, input.getPathNodes().get(input.getPathNodes().size()-1)));
			}/////////////////////////////////////////////////////////////////
			else if (input.getMutationEnd() instanceof BothCase){
				BothCase bothCase = (BothCase) input.getMutationEnd();
				InstallPathBwNodesInputBuilder pathInputBuilder = new InstallPathBwNodesInputBuilder();
				pathInputBuilder.setDstIpAddress(bothCase.getBoth().getNewDstIpAddress());
				pathInputBuilder.setSrcIpAddress(bothCase.getBoth().getNewSrcIpAddress());
				pathInputBuilder.setPathNodes(input.getPathNodes());
				pathInputBuilder.setFlowPriority(input.getFlowPriority());
				pathInputBuilder.setIdleTimeout(input.getIdleTimeout());
				pathInputBuilder.setHardTimeout(input.getHardTimeout());
				this.installPathBwNodes(pathInputBuilder.build());
				
				//On source edge node, traffic generated by actual srcHost for actual dstHost but we have to 
				//mutate their identities
				this.installFlow(func.performFunction(srcEdgeNeighbor.getSrcPort(), 
						input.getDstIpAddress(),
						bothCase.getBoth().getNewDstIpAddress(),
						input.getSrcIpAddress(), 
						bothCase.getBoth().getNewSrcIpAddress(), 
						false, input.getPathNodes().get(0)));
				
				//On source edge node, traffic coming from mutated dstHost IP to mutated srcHost IP should be 
				//reverted back to their identities
				this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(), 
						bothCase.getBoth().getNewSrcIpAddress(),
						input.getSrcIpAddress(),
						bothCase.getBoth().getNewDstIpAddress(),
						input.getDstIpAddress(), 
						false, input.getPathNodes().get(0)));
				
				//On dst edge node, traffic coming for actual dstHost is mutated in both src and dst IPs
				//so we have to revert it back before we hand this over to dstHost
				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
						bothCase.getBoth().getNewDstIpAddress(),
						input.getDstIpAddress(),
						bothCase.getBoth().getNewSrcIpAddress(),
						input.getSrcIpAddress(),
						false, input.getPathNodes().get(input.getPathNodes().size()-1)));
				
				//On dst edge node, traffic originated from dstHost for srcHost, we have to mutate both IPs 
				//to hide their identities from the network
				this.installFlow(func.performFunction(dstEdgeNeighbor.getSrcPort(), 
						input.getSrcIpAddress(),
						bothCase.getBoth().getNewSrcIpAddress(),
						input.getDstIpAddress(),
						bothCase.getBoth().getNewDstIpAddress(),
						false, input.getPathNodes().get(input.getPathNodes().size()-1)));
				
			}
			
			
		} catch (Exception e) {
            LOG.error("Exception reached in MutateIP RPC {} --------", e);
            output.setStatus("IP couldn't be mutated.");
    		return RpcResultBuilder.success(output).buildFuture();
        }
		
		output.setStatus("IP is successfully mutated.");
		return RpcResultBuilder.success(output).buildFuture();
	}

	@Override
	public Future<RpcResult<RemoveAllTapsFromSwitchOutput>> removeAllTapsFromSwitch(
			RemoveAllTapsFromSwitchInput input) {
		NodeId nodeId = input.getNode();
		if (tapsInstalled.containsKey(nodeId)){
			for (String tapId: tapsInstalled.get(nodeId)){
				String flowIdStr = "Tap_" + tapId + "_NodeID_" + nodeId.getValue();
                //remove tap from tap-spec datastore	
                InstanceIdentifier<Tap> tapIID = InstanceIdentifier.builder(TapSpec.class)
                		.child(Tap.class, new TapKey(tapId))
                		.build();
                TapBuilder tapB = new TapBuilder();
                tapB.setId(tapId);
                GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, tapIID, tapB.build(), false);
            }
			RemoveAllTapsFromSwitchOutputBuilder output = new RemoveAllTapsFromSwitchOutputBuilder();
			output.setStatus("Taps removed from " + nodeId.getValue());
			
			return RpcResultBuilder.success(output.build()).buildFuture();
		}
		else {
			RemoveAllTapsFromSwitchOutputBuilder output = new RemoveAllTapsFromSwitchOutputBuilder();
			output.setStatus("No Taps Installed on " + nodeId.getValue());
			
			return RpcResultBuilder.success(output.build()).buildFuture();
		}
	}

	@Override
	public Future<RpcResult<RemoveAFlowFromSwitchOutput>> removeAFlowFromSwitch(
			RemoveAFlowFromSwitchInput input) {
		
		FlowKey key = new FlowKey(new FlowId(input.getFlowKey()));
		InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
        		.child(Node.class, new NodeKey(input.getNodeId()))
        		.augmentation(FlowCapableNode.class)
        		.child(Table.class, new TableKey(input.getTableId()))
        		.child(Flow.class, new FlowKey(key))
        		.build();
		
		FlowBuilder flowBuilder = new FlowBuilder();
    	flowBuilder.setFlowName(key.getId().getValue());
    	flowBuilder.setKey(key);
    	flowBuilder.setId(new FlowId(input.getFlowKey()));
    	flowBuilder.setTableId((short)0);
    	
		boolean status = GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
		RemoveAFlowFromSwitchOutputBuilder outputBuilder = new RemoveAFlowFromSwitchOutputBuilder(); 
		if (status == true) {
			outputBuilder.setStatus("Flow with ID " + input.getFlowKey() + " is successfully removed from Switch " + input.getNodeId().getValue());
			return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
		}
		return null;
	}

	
	@Override
	public Future<RpcResult<RemoveATapFromSwitchOutput>> removeATapFromSwitch(
			RemoveATapFromSwitchInput input) {
		NodeId nodeId = input.getNode();
		if (tapsInstalled.containsKey(nodeId)){
			List<String> taps = tapsInstalled.get(nodeId);
			if (taps.contains(input.getTapId())) {
				String tapId = taps.get(taps.indexOf(input.getTapId()));
				//String flowIdStr = "Tap_" + tapId + "_NodeID_" + nodeId.getValue();
				//String flowIdStr = tapId;
                //remove tap from tap-spec datastore	
                InstanceIdentifier<Tap> tapIID = InstanceIdentifier.builder(TapSpec.class)
                		.child(Tap.class, new TapKey(tapId))
                		.build();
                TapBuilder tapB = new TapBuilder();
                tapB.setId(tapId);
                GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, tapIID, tapB.build(), false);
                RemoveATapFromSwitchOutputBuilder outputBuilder = new RemoveATapFromSwitchOutputBuilder();
                outputBuilder.setStatus("Tap is removed");
                taps.remove(taps.indexOf(input.getTapId()));
                return RpcResultBuilder.success(outputBuilder.build()).buildFuture();
			}
		}
		return null;
	}

	@Override
	public Future<RpcResult<InstallInspectionPathOutput>> installInspectionPath(
			final InstallInspectionPathInput input) {
		// This RPC installs a path between a source-destination pair
				List<NodeId> pathNodes = input.getPathNodes();
				InstallInspectionPathOutputBuilder output = new InstallInspectionPathOutputBuilder();
				
				int nodeIndex = 0;
				RepeatFunction func = new RepeatFunction() {	
					@Override
					public InstallFlowInput performFunction(NodeConnectorId outputPort, Ipv4Prefix dstIp,
							Ipv4Prefix srcIp, NodeId nodeid) {
						AssociatedActionsBuilder actionBuilder = new AssociatedActionsBuilder();
	
						if (outputPort.getValue() == "openflow:6:4294967293"){
							ForwardToControllerBuilder forwardControllerBuilder = new ForwardToControllerBuilder();
							actionBuilder.setFlowActions(new ForwardToControllerCaseBuilder().
									setForwardToController(forwardControllerBuilder.build()).build());
						}
						else {
							ForwardToPortBuilder forwardBuilder = new ForwardToPortBuilder();
							forwardBuilder.setOutputNodeConnector(outputPort);
							actionBuilder.setFlowActions(new ForwardToPortCaseBuilder().
									setForwardToPort(forwardBuilder.build()).build());
						}
											
						actionBuilder.setId((long)1);
						List<AssociatedActions> actionList = Lists.newArrayList();
						actionList.add(actionBuilder.build());
						
						NewFlowBuilder newFlowBuilder = new NewFlowBuilder();
						newFlowBuilder.setSrcIpAddress(srcIp);
						newFlowBuilder.setDstIpAddress(dstIp);
						newFlowBuilder.setTrafficMatch(input.getTrafficMatch());
						newFlowBuilder.setFlowPriority(input.getFlowPriority());
						newFlowBuilder.setIdleTimeout(input.getIdleTimeout());
						newFlowBuilder.setHardTimeout(input.getHardTimeout());
						
						InstallFlowInputBuilder installFlowBuilder = new InstallFlowInputBuilder();
						installFlowBuilder.setNode(nodeid);
						
						installFlowBuilder.setNewFlow(newFlowBuilder.build());
						installFlowBuilder.setAssociatedActions(actionList);
						//--------------------------------------------
						//pathFlows.put(dstIp.getValue()+ ":" + nodeid.getValue(), value)
						//--------------------------------------------
						return installFlowBuilder.build();
						
					}

					@Override
					public InstallFlowInput performFunction(NodeConnectorId outputPort,
							Ipv4Prefix curDstIp, Ipv4Prefix newDstIp,
							Ipv4Prefix curSrcIp, Ipv4Prefix newSrcIp, boolean setMac, NodeId nodeid) {
						// TODO Auto-generated method stub
						return null;
					}
				};
				
				if (pathNodes.size() < 2 || (pathNodes.get(pathNodes.size() - 1) == input.getInspectionSwitchId()) ){
					LOG.debug("Invalid Scenario: Either only one switch along the path or Last switch is the inspection switch");
					output.setStatus("inspection Path is not installed.");
					return RpcResultBuilder.success(output).buildFuture();
				}
				int index = 0;
				LOG.debug("NodeConnectorID {}", input.getInpsectionSwitchPort());
				try {
					for (; index < pathNodes.size(); index++){
						if (index == 0){ // got the first switch
							
							ConnectedHost host = getHostInfo(input.getSrcIpAddress().getValue());
							if (host != null){
								pathRule = true;
								this.installFlow(func.performFunction(host.getNodeConnectorConnectedTo(), 
										input.getSrcIpAddress(), input.getDstIpAddress(), pathNodes.get(index)));
							}
							if (index + 1 < pathNodes.size()){
								if (pathNodes.get(index).getValue().equals(input.getInspectionSwitchId().getValue())){ //This is the switching node so we have to forward the port
									//which is now the controller port
									this.installFlow(func.performFunction(input.getInpsectionSwitchPort(), 
											input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
								}
								else {
									//forwarding direction rule i.e., src -> dst
									Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index+1));
									if (neighbor != null){
										pathRule = true;
										this.installFlow(func.performFunction(neighbor.getSrcPort(), 
												input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
									}
								}
							}
							else {
								ConnectedHost host1 = getHostInfo(input.getDstIpAddress().getValue());
								if (host1 != null){
									pathRule = true;
									this.installFlow(func.performFunction(host1.getNodeConnectorConnectedTo(), 
											input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
								}
							}
						}/////////////////////////////////////////////////////////////////
						//we have more than one switch
						else if (index - 1 >= 0 && index + 1 < pathNodes.size()) {
							if (pathNodes.get(index).getValue().equals(input.getInspectionSwitchId().getValue())) {
								this.installFlow(func.performFunction(
										input.getInpsectionSwitchPort(),
										input.getDstIpAddress(),
										input.getSrcIpAddress(), pathNodes.get(index)));
								LOG.debug("Installed the switch along the path with switchID {}", input.getInspectionSwitchId());
							} else {
								// forwarding direction rule i.e., src -> dst
								Neighbors neighbor = getPortInformation(
										pathNodes.get(index), pathNodes.get(index + 1));
								if (neighbor != null) {
									pathRule = true;
									this.installFlow(func.performFunction(
											neighbor.getSrcPort(),
											input.getDstIpAddress(),
											input.getSrcIpAddress(),
											pathNodes.get(index)));
								}
							}
							// Reverse direction rule i.e., dst -> src
							Neighbors neighbor1 = getPortInformation(
									pathNodes.get(index), pathNodes.get(index - 1));
							if (neighbor1 != null) {
								pathRule = true;
								this.installFlow(func.performFunction(
										neighbor1.getSrcPort(),
										input.getSrcIpAddress(),
										input.getDstIpAddress(), pathNodes.get(index)));
							}
						}/////////////////////////////////////////////////////////////////
						else if (index + 1 == pathNodes.size()){
							ConnectedHost host = getHostInfo(input.getDstIpAddress().getValue());
							if (host != null){
								pathRule = true;
								this.installFlow(func.performFunction(host.getNodeConnectorConnectedTo(), 
										input.getDstIpAddress(), input.getSrcIpAddress(), pathNodes.get(index)));
							}
							if (index - 1 >= 0){
								//forwarding direction rule i.e., src -> dst
								Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index-1));
								if (neighbor != null){
									pathRule = true;
									this.installFlow(func.performFunction(neighbor.getSrcPort(), 
											input.getSrcIpAddress(), input.getDstIpAddress(), pathNodes.get(index)));
								}
							}
						}
						/*
						if (futureOutput != null && futureOutput1 != null){
							InstallFlowOutput installOutput = futureOutput.get().getResult();
							InstallFlowOutput installOutput1 = futureOutput1.get().getResult();
							//pathFlows.put(pathNodes.get(index).getValue() + ":" + input.getSrcIpAddress().getValue(), installOutput.getFlowId());
							//pathFlows.put(pathNodes.get(index).getValue() + ":" + input.getDstIpAddress().getValue(), installOutput1.getFlowId());
						} else {
							String exception = "No Flow ID is provided as output from installFlowRule RPC";
							throw new Exception(exception);
						}
						*/
					}
				} catch (Exception e) {
					LOG.error("Exception reached in InstallPathRPC {} --------", e);
					return null;
				}
				
				//LOG.debug("         -------------------------------------------             ");
				//LOG.debug("Path is successfully installed.");
				//LOG.debug("         -------------------------------------------             ");
				
				output.setStatus("Path is installed.");
				return RpcResultBuilder.success(output).buildFuture();
	}
	
	public void installFlowRulesInPath(List<NodeId> pathNodes, Ipv4Prefix srcIpAddress, 
			Ipv4Prefix dstIpAddress, RepeatFunction func) {
		int index;
		for (index = 0; index < pathNodes.size(); index++){
			if (index == 0){ // got the first switch
				ConnectedHost srcHost = getHostInfo(srcIpAddress.getValue());
				//Reverse direction rule i.e., switch -> src
				if (srcHost != null){
					pathRule = true;
					this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(), 
							srcIpAddress, dstIpAddress, pathNodes.get(index)));
				}
				
				//if there are more than one switch
				if (pathNodes.size() > 1){
					//Forwarding direction rule i.e., src -> dst (switch to switch)
					Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index+1));
					if (neighbor != null){
						pathRule = true;
						this.installFlow(func.performFunction(neighbor.getSrcPort(), 
								dstIpAddress, srcIpAddress, pathNodes.get(index)));
					}
				} else { // case is h1 -- s1 -- h2
					ConnectedHost dstHost = getHostInfo(dstIpAddress.getValue());
					//Forwarding direction rule i.e., switch -> dst
					if (dstHost != null){
						pathRule = true;
						this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
								dstIpAddress, srcIpAddress, pathNodes.get(index)));
					}
				}
			} else if (index + 1 < pathNodes.size()){ //we have more than one switch
				//Forwarding direction rule i.e., src -> dst
				Neighbors forwardingNeighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index+1));
				if (forwardingNeighbor != null){
					pathRule = true;
					this.installFlow(func.performFunction(forwardingNeighbor.getSrcPort(), 
							dstIpAddress, srcIpAddress, pathNodes.get(index)));
				}
				//Reverse direction rule  i.e., dst -> src
				Neighbors reversNeighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index-1));
				if (reversNeighbor != null){
					pathRule = true;
					this.installFlow(func.performFunction(reversNeighbor.getSrcPort(), 
							srcIpAddress, dstIpAddress, pathNodes.get(index)));
				}
			}
			else if (index + 1 == pathNodes.size()){ //Last switch
				ConnectedHost dstHost = getHostInfo(dstIpAddress.getValue());
				//Forwarding direction rule i.e., switch -> dst
				if (dstHost != null){
					pathRule = true;
					this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
							dstIpAddress, srcIpAddress, pathNodes.get(index)));
				}
				//Reverse direction rule i.e., dst -> src
				Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index-1));
				if (neighbor != null){
					pathRule = true;
					this.installFlow(func.performFunction(neighbor.getSrcPort(), 
							srcIpAddress, dstIpAddress, pathNodes.get(index)));
				}
			}
		}
	}
	
	public void removeFlowRulesInPath(List<NodeId> pathNodes, Ipv4Prefix srcIpAddress, 
			Ipv4Prefix dstIpAddress) {
		int index;
		
//		if (index == 0){ // got the first switch
//			ConnectedHost srcHost = getHostInfo(srcIpAddress.getValue());
//			//Reverse direction rule i.e., switch -> src
//			if (srcHost != null){
//				pathRule = true;
//				this.installFlow(func.performFunction(srcHost.getNodeConnectorConnectedTo(), 
//						srcIpAddress, dstIpAddress, pathNodes.get(index)));
//			}
//			
//			//if there are more than one switch
//			if (pathNodes.size() > 1){
//				//Forwarding direction rule i.e., src -> dst (switch to switch)
//				Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index+1));
//				if (neighbor != null){
//					pathRule = true;
//					this.installFlow(func.performFunction(neighbor.getSrcPort(), 
//							dstIpAddress, srcIpAddress, pathNodes.get(index)));
//				}
//			} else { // case is h1 -- s1 -- h2
//				ConnectedHost dstHost = getHostInfo(dstIpAddress.getValue());
//				//Forwarding direction rule i.e., switch -> dst
//				if (dstHost != null){
//					pathRule = true;
//					this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
//							dstIpAddress, srcIpAddress, pathNodes.get(index)));
//				}
//			}
//		} else if (index + 1 < pathNodes.size()){ //we have more than one switch
//			//Forwarding direction rule i.e., src -> dst
//			Neighbors forwardingNeighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index+1));
//			if (forwardingNeighbor != null){
//				pathRule = true;
//				this.installFlow(func.performFunction(forwardingNeighbor.getSrcPort(), 
//						dstIpAddress, srcIpAddress, pathNodes.get(index)));
//			}
//			//Reverse direction rule  i.e., dst -> src
//			Neighbors reversNeighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index-1));
//			if (reversNeighbor != null){
//				pathRule = true;
//				this.installFlow(func.performFunction(reversNeighbor.getSrcPort(), 
//						srcIpAddress, dstIpAddress, pathNodes.get(index)));
//			}
//		}
//		else if (index + 1 == pathNodes.size()){ //Last switch
//			ConnectedHost dstHost = getHostInfo(dstIpAddress.getValue());
//			//Forwarding direction rule i.e., switch -> dst
//			if (dstHost != null){
//				pathRule = true;
//				this.installFlow(func.performFunction(dstHost.getNodeConnectorConnectedTo(), 
//						dstIpAddress, srcIpAddress, pathNodes.get(index)));
//			}
//			//Reverse direction rule i.e., dst -> src
//			Neighbors neighbor = getPortInformation(pathNodes.get(index), pathNodes.get(index-1));
//			if (neighbor != null){
//				pathRule = true;
//				this.installFlow(func.performFunction(neighbor.getSrcPort(), 
//						srcIpAddress, dstIpAddress, pathNodes.get(index)));
//			}
//		}
		
		
		for (index = 0; index < pathNodes.size(); index++){
			//delete forwarding flow from the switch
			String switchToDstKey = pathNodes.get(index).getValue() + ":" + dstIpAddress.getValue();
			
			if (pathFlows.containsKey(switchToDstKey)){
				String flowIdStr = pathFlows.get(switchToDstKey);

				LOG.debug("     ---------------------------------------------------------------------     ");
				LOG.debug("		Delete forwading rule to : {}", flowIdStr);
				LOG.debug("     ---------------------------------------------------------------------     ");
				
            	FlowBuilder flowBuilder = new FlowBuilder();
            	FlowKey key = new FlowKey(new FlowId(flowIdStr));
            	flowBuilder.setFlowName(flowIdStr);
            	flowBuilder.setKey(key);
            	flowBuilder.setId(new FlowId(flowIdStr));
            	flowBuilder.setTableId((short)0);
                	
            	@SuppressWarnings("deprecation")
				InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
            			.child(Node.class, new NodeKey(pathNodes.get(index)))
            			.augmentation(FlowCapableNode.class)
            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
            			.build();
                	
            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
            	flowsInstalled.get(pathNodes.get(index)).remove(flowIdStr);
            	pathFlows.remove(switchToDstKey);
			}
            
			//delete reverse flow from the switch
			String switchToSrcKey = pathNodes.get(index).getValue() + ":" + srcIpAddress.getValue();
			
			if (pathFlows.containsKey(switchToSrcKey)){
				String flowIdStr = pathFlows.get(switchToSrcKey);

				LOG.debug("     ---------------------------------------------------------------------     ");
				LOG.debug("		Delete reversing rule to : {}", flowIdStr);
				LOG.debug("     ---------------------------------------------------------------------     ");
            	
				FlowBuilder flowBuilder = new FlowBuilder();
				FlowKey key = new FlowKey(new FlowId(flowIdStr));
            	flowBuilder.setFlowName(flowIdStr);
            	flowBuilder.setKey(key);
            	flowBuilder.setId(new FlowId(flowIdStr));
            	flowBuilder.setTableId((short)0);
                	
            	@SuppressWarnings("deprecation")
				InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
            			.child(Node.class, new NodeKey(pathNodes.get(index)))
            			.augmentation(FlowCapableNode.class)
            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
            			.build();
                	
            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
            	flowsInstalled.get(pathNodes.get(index)).remove(flowIdStr);
            	pathFlows.remove(switchToSrcKey);
			}
		}
	}
	
	public void removeAllFlowRulesInPath(List<NodeId> pathNodes, Ipv4Prefix srcIpAddress, 
			Ipv4Prefix dstIpAddress) {
		int index;
		
		for (index = 0; index < pathNodes.size(); index++){
			//delete forwarding flow from the switch
			String switchToDstKey = pathNodes.get(index).getValue() + ":" + dstIpAddress.getValue();
			
			if (allInstalledFlows.containsKey(switchToDstKey)){
				List<String> flowIds = allInstalledFlows.get(switchToDstKey);
				for (String flowIdStr : flowIds) {
//					LOG.debug("     ---------------------------------------------------------------------     ");
//					LOG.debug("		Delete forwading rule to : {}", flowIdStr);
//					LOG.debug("     ---------------------------------------------------------------------     ");
					
	            	FlowBuilder flowBuilder = new FlowBuilder();
	            	FlowKey key = new FlowKey(new FlowId(flowIdStr));
	            	flowBuilder.setFlowName(flowIdStr);
	            	flowBuilder.setKey(key);
	            	flowBuilder.setId(new FlowId(flowIdStr));
	            	flowBuilder.setTableId((short)0);
	                	
	            	@SuppressWarnings("deprecation")
					InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
	            			.child(Node.class, new NodeKey(pathNodes.get(index)))
	            			.augmentation(FlowCapableNode.class)
	            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
	            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
	            			.build();
	                	
	            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
	            	flowsInstalled.get(pathNodes.get(index)).remove(flowIdStr);
				}
				allInstalledFlows.remove(switchToDstKey);
			}
            
			//delete reverse flow from the switch
			String switchToSrcKey = pathNodes.get(index).getValue() + ":" + srcIpAddress.getValue();
			
			if (allInstalledFlows.containsKey(switchToSrcKey)){
				List<String> flowIds = allInstalledFlows.get(switchToSrcKey);
				for (String flowIdStr : flowIds) {
//					LOG.debug("     ---------------------------------------------------------------------     ");
//					LOG.debug("		Delete reversing rule to : {}", flowIdStr);
//					LOG.debug("     ---------------------------------------------------------------------     ");
	            	
					FlowBuilder flowBuilder = new FlowBuilder();
					FlowKey key = new FlowKey(new FlowId(flowIdStr));
	            	flowBuilder.setFlowName(flowIdStr);
	            	flowBuilder.setKey(key);
	            	flowBuilder.setId(new FlowId(flowIdStr));
	            	flowBuilder.setTableId((short)0);
	                	
	            	@SuppressWarnings("deprecation")
					InstanceIdentifier<Flow> flowIID = InstanceIdentifier.builder(Nodes.class)
	            			.child(Node.class, new NodeKey(pathNodes.get(index)))
	            			.augmentation(FlowCapableNode.class)
	            			.child(Table.class, new TableKey(flowBuilder.getTableId()))
	            			.child(Flow.class, new FlowKey(flowBuilder.getKey()))
	            			.build();
	                	
	            	GenericTransactionUtils.writeData(dataBroker, LogicalDatastoreType.CONFIGURATION, flowIID, flowBuilder.build(), false);
	            	flowsInstalled.get(pathNodes.get(index)).remove(flowIdStr);
				}
				
			}
			allInstalledFlows.remove(switchToSrcKey);
		}
	}
}
