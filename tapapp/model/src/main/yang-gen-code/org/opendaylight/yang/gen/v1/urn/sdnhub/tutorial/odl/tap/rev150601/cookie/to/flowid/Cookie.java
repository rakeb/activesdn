package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.CookieToFlowid;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * list cookie {
 *     key "id"
 *     leaf id {
 *         type string;
 *     }
 *     leaf tapid {
 *         type string;
 *     }
 *     leaf flowid {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/cookie-to-flowid/cookie</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.CookieBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.CookieBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.CookieKey
 *
 */
public interface Cookie
    extends
    ChildOf<CookieToFlowid>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.cookie.to.flowid.Cookie>,
    Identifiable<CookieKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "cookie").intern();

    java.lang.String getId();
    
    java.lang.String getTapid();
    
    java.lang.String getFlowid();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    CookieKey getKey();

}

