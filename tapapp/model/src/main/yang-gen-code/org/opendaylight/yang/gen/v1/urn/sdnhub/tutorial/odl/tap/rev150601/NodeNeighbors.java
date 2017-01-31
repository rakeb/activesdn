package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.CurrNode;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container node-neighbors {
 *     list curr-node {
 *         key "curr-node-id"
 *         leaf curr-node-id {
 *             type leafref;
 *         }
 *         list neighbors {
 *             key "neighbor-node-id"
 *             leaf neighbor-node-id {
 *                 type leafref;
 *             }
 *             leaf src-port {
 *                 type leafref;
 *             }
 *             leaf neigh-port {
 *                 type leafref;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/node-neighbors</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NodeNeighborsBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NodeNeighborsBuilder
 *
 */
public interface NodeNeighbors
    extends
    ChildOf<TapData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NodeNeighbors>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "node-neighbors").intern();

    List<CurrNode> getCurrNode();

}

