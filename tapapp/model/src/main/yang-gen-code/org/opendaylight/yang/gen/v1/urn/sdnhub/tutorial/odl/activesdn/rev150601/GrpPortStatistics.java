package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * grouping grp-port-statistics {
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
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/grp-port-statistics</i>
 *
 */
public interface GrpPortStatistics
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "grp-port-statistics").intern();

    java.lang.Long getTotalTransmitted();
    
    java.lang.Long getTotalReceived();
    
    java.lang.Long getReceiveDrops();
    
    java.lang.Long getTransmitDrops();

}

