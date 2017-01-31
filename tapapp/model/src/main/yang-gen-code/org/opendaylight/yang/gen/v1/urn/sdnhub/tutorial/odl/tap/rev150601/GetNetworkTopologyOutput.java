package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container output {
 *     list network-links {
 *         key "id"
 *         leaf id {
 *             type string;
 *         }
 *         leaf src-node {
 *             type leafref;
 *         }
 *         leaf src-node-connector {
 *             type leafref;
 *         }
 *         leaf dst-node {
 *             type leafref;
 *         }
 *         leaf dst-node-connector {
 *             type leafref;
 *         }
 *         uses network-link;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/getNetworkTopology/output</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetNetworkTopologyOutputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetNetworkTopologyOutputBuilder
 *
 */
public interface GetNetworkTopologyOutput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetNetworkTopologyOutput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "output").intern();

    List<NetworkLinks> getNetworkLinks();

}

