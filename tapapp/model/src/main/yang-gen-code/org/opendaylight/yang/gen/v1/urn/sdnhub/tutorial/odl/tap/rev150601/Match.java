package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev100924.MacAddress;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping match {
 *     leaf in-port {
 *         type leafref;
 *     }
 *     leaf src-mac-address {
 *         type mac-address;
 *     }
 *     leaf dst-mac-address {
 *         type mac-address;
 *     }
 *     leaf src-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf dst-ip-address {
 *         type ipv4-prefix;
 *     }
 *     leaf traffic-match {
 *         type traffic-type;
 *     }
 *     leaf flow-priority {
 *         type flow-priority;
 *     }
 *     leaf idle-timeout {
 *         type idle-timeout;
 *     }
 *     leaf hard-timeout {
 *         type hard-timeout;
 *     }
 *     container custom-info {
 *         leaf dl-type {
 *             type dl-type;
 *         }
 *         leaf nw-proto {
 *             type nw-proto;
 *         }
 *         leaf tp-dst {
 *             type tp-dst;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/match</i>
 *
 */
public interface Match
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "match").intern();

    NodeConnectorId getInPort();
    
    MacAddress getSrcMacAddress();
    
    MacAddress getDstMacAddress();
    
    Ipv4Prefix getSrcIpAddress();
    
    Ipv4Prefix getDstIpAddress();
    
    TrafficType getTrafficMatch();
    
    java.lang.Integer getFlowPriority();
    
    java.lang.Integer getIdleTimeout();
    
    java.lang.Integer getHardTimeout();
    
    CustomInfo getCustomInfo();

}

