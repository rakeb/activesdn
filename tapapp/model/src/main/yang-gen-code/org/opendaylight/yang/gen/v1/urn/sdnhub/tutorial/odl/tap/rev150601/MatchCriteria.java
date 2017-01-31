package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.criteria.IpAddress;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.criteria.MacAddress;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping match-criteria {
 *     container mac-address {
 *         leaf type {
 *             type field-type;
 *         }
 *         leaf value {
 *             type mac-address;
 *         }
 *     }
 *     container ip-address {
 *         leaf type {
 *             type field-type;
 *         }
 *         leaf value {
 *             type ipv4-prefix;
 *         }
 *     }
 *     leaf traffic-match {
 *         type traffic-type;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/match-criteria</i>
 *
 */
public interface MatchCriteria
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "match-criteria").intern();

    MacAddress getMacAddress();
    
    IpAddress getIpAddress();
    
    TrafficType getTrafficMatch();

}

