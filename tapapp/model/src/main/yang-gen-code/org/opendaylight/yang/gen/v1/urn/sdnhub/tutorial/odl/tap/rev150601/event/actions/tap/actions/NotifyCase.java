package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.TapActions;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.notify._case.NotifyAction;


/**
 * Notify the occurance of matching event.
 *
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * case notify-case {
 *     container notify-action {
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/event-actions/tap-actions/notify-case</i>
 *
 */
public interface NotifyCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.NotifyCase>,
    TapActions
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "notify-case").intern();

    NotifyAction getNotifyAction();

}

