package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received.SwitchStatistics;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Notification;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * notification flow-statistic-received {
 *     list switch-statistics {
 *         key "switch-id"
 *         leaf switch-id {
 *             type int32;
 *         }
 *         list flow-statistic {
 *             key "flow-id"
 *             leaf flow-id {
 *                 type string;
 *             }
 *             leaf packet-count {
 *                 type uint32;
 *             }
 *             leaf byte-count {
 *                 type uint32;
 *             }
 *             leaf duration {
 *                 type duration;
 *             }
 *             leaf src-ip-address {
 *                 type string;
 *             }
 *             leaf dst-ip-address {
 *                 type string;
 *             }
 *             leaf type-of-traffic {
 *                 type traffic-type;
 *             }
 *             leaf src-port {
 *                 type int32;
 *             }
 *             leaf dst-port {
 *                 type int32;
 *             }
 *         }
 *         uses grp-flow-statistic;
 *     }
 *     leaf stats-time {
 *         type uint32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/flow-statistic-received</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowStatisticReceivedBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowStatisticReceivedBuilder
 *
 */
public interface FlowStatisticReceived
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowStatisticReceived>,
    Notification
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "flow-statistic-received").intern();

    List<SwitchStatistics> getSwitchStatistics();
    
    java.lang.Long getStatsTime();

}

