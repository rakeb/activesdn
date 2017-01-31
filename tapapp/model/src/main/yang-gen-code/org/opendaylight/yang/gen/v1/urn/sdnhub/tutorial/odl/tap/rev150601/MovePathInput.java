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
 *     leaf src-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf dst-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf-list old-path-nodes {
 *         type leafref;
 *     }
 *     leaf-list new-path-nodes {
 *         type leafref;
 *     }
 *     leaf flow-priority {
 *         type int32;
 *     }
 *     leaf idle-timeout {
 *         type int32;
 *     }
 *     leaf hard-timeout {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/move-path/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MovePathInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MovePathInputBuilder
 *
 */
public interface MovePathInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MovePathInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "input").intern();

    Ipv4Prefix getSrcIpAddress();
    
    Ipv4Prefix getDstIpAddress();
    
    List<NodeId> getOldPathNodes();
    
    List<NodeId> getNewPathNodes();
    
    java.lang.Integer getFlowPriority();
    
    java.lang.Integer getIdleTimeout();
    
    java.lang.Integer getHardTimeout();

}

