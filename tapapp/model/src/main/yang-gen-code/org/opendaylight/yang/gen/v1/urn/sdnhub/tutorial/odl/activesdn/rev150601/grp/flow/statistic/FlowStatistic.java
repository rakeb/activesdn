package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GrpFlowStatistic;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * list flow-statistic {
 *     key "flow-id"
 *     leaf flow-id {
 *         type string;
 *     }
 *     leaf packet-count {
 *         type uint32;
 *     }
 *     leaf byte-count {
 *         type uint32;
 *     }
 *     leaf duration {
 *         type duration;
 *     }
 *     leaf src-ip-address {
 *         type string;
 *     }
 *     leaf dst-ip-address {
 *         type string;
 *     }
 *     leaf type-of-traffic {
 *         type traffic-type;
 *     }
 *     leaf src-port {
 *         type int32;
 *     }
 *     leaf dst-port {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/grp-flow-statistic/flow-statistic</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatisticBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatisticBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatisticKey
 *
 */
public interface FlowStatistic
    extends
    ChildOf<GrpFlowStatistic>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic>,
    Identifiable<FlowStatisticKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "flow-statistic").intern();

    java.lang.String getFlowId();
    
    java.lang.Long getPacketCount();
    
    java.lang.Long getByteCount();
    
    /**
     * time window in seconds
     *
     */
    java.lang.Long getDuration();
    
    /**
     * IP address of the Host generated data packet, e.g., 10.0.0.1/32
     *
     */
    java.lang.String getSrcIpAddress();
    
    /**
     * IP address of the destination Host, e.g., 10.0.0.2/32
     *
     */
    java.lang.String getDstIpAddress();
    
    TrafficType getTypeOfTraffic();
    
    java.lang.Integer getSrcPort();
    
    java.lang.Integer getDstPort();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    FlowStatisticKey getKey();

}

