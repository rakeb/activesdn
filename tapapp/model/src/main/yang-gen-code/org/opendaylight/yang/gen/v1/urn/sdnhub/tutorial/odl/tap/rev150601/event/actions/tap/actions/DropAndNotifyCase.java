package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.TapActions;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * Start dropping the packets and also notify
 *
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * case drop-and-notify-case {
 *     container drop-and-notify {
 *         leaf hold-notification {
 *             type int32;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/event-actions/tap-actions/drop-and-notify-case</i>
 *
 */
public interface DropAndNotifyCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.DropAndNotifyCase>,
    TapActions
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "drop-and-notify-case").intern();

    DropAndNotify getDropAndNotify();

}

