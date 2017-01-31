package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.FlowActions;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * This limits the rate of the flow by assigning it to a meter.
 *
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * case set-rate-limit-case {
 *     container set-rate-limit {
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
 * <i>tap/flow-actions/flow-actions/set-rate-limit-case</i>
 *
 */
public interface SetRateLimitCase
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetRateLimitCase>,
    FlowActions
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "set-rate-limit-case").intern();

    SetRateLimit getSetRateLimit();

}

