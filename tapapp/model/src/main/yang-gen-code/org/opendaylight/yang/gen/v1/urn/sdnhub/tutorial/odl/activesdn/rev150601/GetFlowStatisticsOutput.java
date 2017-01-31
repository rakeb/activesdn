package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * container output {
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
 *     leaf status {
 *         type string;
 *     }
 *     uses grp-flow-statistic;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/get-flow-statistics/output</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetFlowStatisticsOutputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetFlowStatisticsOutputBuilder
 *
 */
public interface GetFlowStatisticsOutput
    extends
    GrpFlowStatistic,
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetFlowStatisticsOutput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "output").intern();

    java.lang.Integer getSwitchId();
    
    java.lang.String getStatus();

}

