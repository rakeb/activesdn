package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.MeterFlags;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.FlowActions;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container set-rate-limit {
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
 * <i>tap/flow-actions/flow-actions/set-rate-limit-case/set-rate-limit</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimitBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimitBuilder
 *
 */
public interface SetRateLimit
    extends
    ChildOf<FlowActions>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.rate.limit._case.SetRateLimit>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "set-rate-limit").intern();

    MeterFlags getMeterType();
    
    java.lang.Long getBandRate();
    
    java.lang.Long getBandBurstSize();
    
    java.lang.Long getDropRate();
    
    java.lang.Long getDropBurstSize();
    
    NodeConnectorId getEgressPort();

}

