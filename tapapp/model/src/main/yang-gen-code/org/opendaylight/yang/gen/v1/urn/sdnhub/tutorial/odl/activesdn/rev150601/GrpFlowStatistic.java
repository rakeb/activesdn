package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.grp.flow.statistic.FlowStatistic;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * grouping grp-flow-statistic {
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
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/grp-flow-statistic</i>
 *
 */
public interface GrpFlowStatistic
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "grp-flow-statistic").intern();

    List<FlowStatistic> getFlowStatistic();

}

