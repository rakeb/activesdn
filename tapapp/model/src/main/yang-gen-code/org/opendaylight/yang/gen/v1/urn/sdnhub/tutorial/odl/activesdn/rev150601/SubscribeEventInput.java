package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * container input {
 *     leaf switch-id {
 *         type int32;
 *     }
 *     leaf in-port-id {
 *         type uint32;
 *     }
 *     leaf src-mac-address {
 *         type string;
 *     }
 *     leaf dst-mac-address {
 *         type string;
 *     }
 *     leaf src-ip-address {
 *         type string;
 *     }
 *     leaf dst-ip-address {
 *         type string;
 *     }
 *     leaf traffic-protocol {
 *         type traffic-type;
 *     }
 *     leaf count {
 *         type uint32;
 *     }
 *     leaf duration {
 *         type uint32;
 *     }
 *     leaf hold-notification {
 *         type int32;
 *     }
 *     leaf event-action {
 *         type enumeration;
 *     }
 *     uses event-specs;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/subscribe-event/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInputBuilder
 *
 */
public interface SubscribeEventInput
    extends
    EventSpecs,
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeEventInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "input").intern();


}

