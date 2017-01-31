package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.set.rate.limit.event._case;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MeterFlags;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.EventActions;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container set-rate-limit-action {
 *     leaf meter-type {
 *         type meter-flags;
 *     }
 *     leaf band-rate {
 *         type uint32;
 *     }
 *     leaf band-burst-size {
 *         type band-burst-size;
 *     }
 *     leaf drop-rate {
 *         type drop-rate;
 *     }
 *     leaf drop-burst-size {
 *         type drop-burst-size;
 *     }
 *     leaf egress-port {
 *         type leafref;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/event-actions/tap-actions/set-rate-limit-event-case/set-rate-limit-action</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.set.rate.limit.event._case.SetRateLimitActionBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.set.rate.limit.event._case.SetRateLimitActionBuilder
 *
 */
public interface SetRateLimitAction
    extends
    ChildOf<EventActions>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.set.rate.limit.event._case.SetRateLimitAction>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "set-rate-limit-action").intern();

    MeterFlags getMeterType();
    
    java.lang.Long getBandRate();
    
    java.lang.Long getBandBurstSize();
    
    java.lang.Long getDropRate();
    
    java.lang.Long getDropBurstSize();
    
    NodeConnectorId getEgressPort();

}

