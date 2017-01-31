package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowStatisticReceived;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpFlowStatistic;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * list switch-statistics {
 *     key "switch-id"
 *     leaf switch-id {
 *         type int32;
 *     }
 *     list flow-statistic {
 *         key "flow-id"
 *         leaf flow-id {
 *             type string;
 *         }
 *         leaf packet-count {
 *             type uint32;
 *         }
 *         leaf byte-count {
 *             type uint32;
 *         }
 *         leaf duration {
 *             type duration;
 *         }
 *         leaf src-ip-address {
 *             type string;
 *         }
 *         leaf dst-ip-address {
 *             type string;
 *         }
 *         leaf type-of-traffic {
 *             type traffic-type;
 *         }
 *         leaf src-port {
 *             type int32;
 *         }
 *         leaf dst-port {
 *             type int32;
 *         }
 *     }
 *     uses grp-flow-statistic;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/flow-statistic-received/switch-statistics</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received.SwitchStatisticsBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received.SwitchStatisticsBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received.SwitchStatisticsKey
 *
 */
public interface SwitchStatistics
    extends
    ChildOf<FlowStatisticReceived>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received.SwitchStatistics>,
    GrpFlowStatistic,
    Identifiable<SwitchStatisticsKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "switch-statistics").intern();

    java.lang.Integer getSwitchId();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    SwitchStatisticsKey getKey();

}

