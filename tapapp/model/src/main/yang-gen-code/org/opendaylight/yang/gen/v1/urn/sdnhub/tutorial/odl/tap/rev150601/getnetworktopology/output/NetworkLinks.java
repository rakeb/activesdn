package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.NetworkLink;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.GetNetworkTopologyOutput;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * list network-links {
 *     key "id"
 *     leaf id {
 *         type string;
 *     }
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
 *     uses network-link;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/getNetworkTopology/output/network-links</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinksBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinksBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinksKey
 *
 */
public interface NetworkLinks
    extends
    ChildOf<GetNetworkTopologyOutput>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.getnetworktopology.output.NetworkLinks>,
    NetworkLink,
    Identifiable<NetworkLinksKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "network-links").intern();

    java.lang.String getId();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    NetworkLinksKey getKey();

}

