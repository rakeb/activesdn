package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IsLinkFlooded;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * list flooded-links {
 *     key "link-id"
 *     leaf link-id {
 *         type string;
 *     }
 *     leaf packet-drop-observed {
 *         type uint32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/is-link-flooded/flooded-links</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded.FloodedLinksBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded.FloodedLinksBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded.FloodedLinksKey
 *
 */
public interface FloodedLinks
    extends
    ChildOf<IsLinkFlooded>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded.FloodedLinks>,
    Identifiable<FloodedLinksKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "flooded-links").intern();

    java.lang.String getLinkId();
    
    java.lang.Long getPacketDropObserved();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    FloodedLinksKey getKey();

}

