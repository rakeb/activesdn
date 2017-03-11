package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Notification;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded.FloodedLinks;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * notification is-link-flooded {
 *     list flooded-links {
 *         key "link-id"
 *         leaf link-id {
 *             type string;
 *         }
 *         leaf packet-drop-observed {
 *             type uint32;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/is-link-flooded</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IsLinkFloodedBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IsLinkFloodedBuilder
 *
 */
public interface IsLinkFlooded
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IsLinkFlooded>,
    Notification
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "is-link-flooded").intern();

    List<FloodedLinks> getFloodedLinks();

}

