package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Notification;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * notification new-host-found {
 *     leaf host-mac-address {
 *         type string;
 *     }
 *     leaf host-ip-address {
 *         type string;
 *     }
 *     leaf switch-connected-to {
 *         type int32;
 *     }
 *     leaf port-connected-to {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/new-host-found</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFoundBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFoundBuilder
 *
 */
public interface NewHostFound
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>,
    Notification
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "new-host-found").intern();

    java.lang.String getHostMacAddress();
    
    java.lang.String getHostIpAddress();
    
    java.lang.Integer getSwitchConnectedTo();
    
    java.lang.Integer getPortConnectedTo();

}

