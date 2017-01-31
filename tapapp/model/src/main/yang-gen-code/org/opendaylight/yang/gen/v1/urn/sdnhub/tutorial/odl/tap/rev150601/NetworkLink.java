package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping network-link {
 *     leaf src-node {
 *         type leafref;
 *     }
 *     leaf src-node-connector {
 *         type leafref;
 *     }
 *     leaf dst-node {
 *         type leafref;
 *     }
 *     leaf dst-node-connector {
 *         type leafref;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/network-link</i>
 *
 */
public interface NetworkLink
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "network-link").intern();

    NodeId getSrcNode();
    
    NodeConnectorId getSrcNodeConnector();
    
    NodeId getDstNode();
    
    NodeConnectorId getDstNodeConnector();

}

