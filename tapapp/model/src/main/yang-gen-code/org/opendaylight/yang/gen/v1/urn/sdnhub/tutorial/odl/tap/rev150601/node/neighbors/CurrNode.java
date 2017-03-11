package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NodeNeighbors;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * list curr-node {
 *     key "curr-node-id"
 *     leaf curr-node-id {
 *         type leafref;
 *     }
 *     list neighbors {
 *         key "neighbor-node-id"
 *         leaf neighbor-node-id {
 *             type leafref;
 *         }
 *         leaf src-port {
 *             type leafref;
 *         }
 *         leaf neigh-port {
 *             type leafref;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/node-neighbors/curr-node</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNodeBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNodeBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNodeKey
 *
 */
public interface CurrNode
    extends
    ChildOf<NodeNeighbors>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode>,
    Identifiable<CurrNodeKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "curr-node").intern();

    NodeId getCurrNodeId();
    
    /**
     * Lets say, s1 has a link with s2, output port of s1 is x and input port of s2 is 
     * y. Then neighbor-node-id means s1, src-port means x and neigh-port means y
     *
     */
    List<Neighbors> getNeighbors();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    CurrNodeKey getKey();

}

