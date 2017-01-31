package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.set.rate.limit.event._case.SetRateLimitAction;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.TapActions;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * Limits the traffic matching event.
 *
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * case set-rate-limit-event-case {
 *     container set-rate-limit-action {
 *         leaf meter-type {
 *             type meter-flags;
 *         }
 *         leaf band-rate {
 *             type uint32;
 *         }
 *         leaf band-burst-size {
 *             type band-burst-size;
 *         }
 *         leaf drop-rate {
 *             type drop-rate;
 *         }
 *         leaf drop-burst-size {
 *             type drop-burst-size;
 *         }
 *         leaf egress-port {
 *             type leafref;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/event-actions/tap-actions/set-rate-limit-event-case</i>
 *
 */
public interface SetRateLimitEventCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.SetRateLimitEventCase>,
    TapActions
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "set-rate-limit-event-case").intern();

    SetRateLimitAction getSetRateLimitAction();

}

