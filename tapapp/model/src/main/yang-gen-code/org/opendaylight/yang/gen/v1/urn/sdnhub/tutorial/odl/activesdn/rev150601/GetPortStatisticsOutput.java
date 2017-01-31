package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * container output {
 *     leaf total-transmitted {
 *         type uint32;
 *     }
 *     leaf total-received {
 *         type uint32;
 *     }
 *     leaf receive-drops {
 *         type uint32;
 *     }
 *     leaf transmit-drops {
 *         type uint32;
 *     }
 *     uses grp-port-statistics;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/get-port-statistics/output</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutputBuilder
 *
 */
public interface GetPortStatisticsOutput
    extends
    GrpPortStatistics,
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetPortStatisticsOutput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "output").intern();


}

