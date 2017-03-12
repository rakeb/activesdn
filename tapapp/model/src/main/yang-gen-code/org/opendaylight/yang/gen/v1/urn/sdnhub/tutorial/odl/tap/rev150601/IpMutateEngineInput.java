package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container input {
 *     leaf old-src-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf new-src-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf old-dst-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf new-dst-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf-list path-nodes {
 *         type leafref;
 *     }
 *     leaf flow-priority {
 *         type flow-priority;
 *     }
 *     leaf idle-timeout {
 *         type idle-timeout;
 *     }
 *     leaf hard-timeout {
 *         type hard-timeout;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/ip-mutate-engine/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInputBuilder
 *
 */
public interface IpMutateEngineInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IpMutateEngineInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "input").intern();

    Ipv4Prefix getOldSrcIpAddress();
    
    Ipv4Prefix getNewSrcIpAddress();
    
    Ipv4Prefix getOldDstIpAddress();
    
    Ipv4Prefix getNewDstIpAddress();
    
    List<NodeId> getPathNodes();
    
    java.lang.Integer getFlowPriority();
    
    java.lang.Integer getIdleTimeout();
    
    java.lang.Integer getHardTimeout();

}

