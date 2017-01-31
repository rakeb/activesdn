package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.add.tap.input.Tap1;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container input {
 *     list tap1 {
 *         key "id"
 *         leaf id {
 *             type string;
 *         }
 *         leaf count {
 *             type uint32;
 *         }
 *         leaf duration {
 *             type uint32;
 *         }
 *         leaf node {
 *             type leafref;
 *         }
 *         leaf inPortConnector {
 *             type leafref;
 *         }
 *         leaf source-mac-address {
 *             type mac-address;
 *         }
 *         leaf dst-mac-address {
 *             type mac-address;
 *         }
 *         leaf source-ip-address {
 *             type local-ipv4-prefix;
 *         }
 *         leaf dst-ip-address {
 *             type local-ipv4-prefix;
 *         }
 *         leaf traffic-match {
 *             type traffic-type;
 *         }
 *         choice tap-actions {
 *             case block-case {
 *                 container block-action {
 *                 }
 *             }
 *             case drop-and-notify-case {
 *                 container drop-and-notify {
 *                     leaf hold-notification {
 *                         type int32;
 *                     }
 *                 }
 *             }
 *             case notify-case {
 *                 container notify-action {
 *                 }
 *             }
 *             case set-rate-limit-event-case {
 *                 container set-rate-limit-action {
 *                     leaf meter-type {
 *                         type meter-flags;
 *                     }
 *                     leaf band-rate {
 *                         type uint32;
 *                     }
 *                     leaf band-burst-size {
 *                         type band-burst-size;
 *                     }
 *                     leaf drop-rate {
 *                         type drop-rate;
 *                     }
 *                     leaf drop-burst-size {
 *                         type drop-burst-size;
 *                     }
 *                     leaf egress-port {
 *                         type leafref;
 *                     }
 *                 }
 *             }
 *         }
 *         uses event-actions;
 *         uses tap-grouping;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/add-tap/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.AddTapInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.AddTapInputBuilder
 *
 */
public interface AddTapInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.AddTapInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "input").intern();

    List<Tap1> getTap1();

}

