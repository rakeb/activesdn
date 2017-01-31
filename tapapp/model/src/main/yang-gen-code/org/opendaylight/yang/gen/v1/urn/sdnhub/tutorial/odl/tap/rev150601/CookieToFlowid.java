package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.Cookie;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container cookie-to-flowid {
 *     list cookie {
 *         key "id"
 *         leaf id {
 *             type string;
 *         }
 *         leaf tapid {
 *             type string;
 *         }
 *         leaf flowid {
 *             type string;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/cookie-to-flowid</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CookieToFlowidBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CookieToFlowidBuilder
 *
 */
public interface CookieToFlowid
    extends
    ChildOf<TapData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CookieToFlowid>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "cookie-to-flowid").intern();

    List<Cookie> getCookie();

}

