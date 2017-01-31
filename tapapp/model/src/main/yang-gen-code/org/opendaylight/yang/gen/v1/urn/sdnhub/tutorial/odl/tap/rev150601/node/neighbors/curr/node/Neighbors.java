package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * list neighbors {
 *     key "neighbor-node-id"
 *     leaf neighbor-node-id {
 *         type leafref;
 *     }
 *     leaf src-port {
 *         type leafref;
 *     }
 *     leaf neigh-port {
 *         type leafref;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/node-neighbors/curr-node/neighbors</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.NeighborsBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.NeighborsBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.NeighborsKey
 *
 */
public interface Neighbors
    extends
    ChildOf<CurrNode>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.Neighbors>,
    Identifiable<NeighborsKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "neighbors").intern();

    NodeId getNeighborNodeId();
    
    NodeConnectorId getSrcPort();
    
    NodeConnectorId getNeighPort();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    NeighborsKey getKey();

}

