package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev100924.MacAddress;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping tap-grouping {
 *     leaf node {
 *         type leafref;
 *     }
 *     leaf inPortConnector {
 *         type leafref;
 *     }
 *     leaf source-mac-address {
 *         type mac-address;
 *     }
 *     leaf dst-mac-address {
 *         type mac-address;
 *     }
 *     leaf source-ip-address {
 *         type local-ipv4-prefix;
 *     }
 *     leaf dst-ip-address {
 *         type local-ipv4-prefix;
 *     }
 *     leaf traffic-match {
 *         type traffic-type;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/tap-grouping</i>
 *
 */
public interface TapGrouping
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "tap-grouping").intern();

    NodeId getNode();
    
    NodeConnectorId getInPortConnector();
    
    MacAddress getSourceMacAddress();
    
    MacAddress getDstMacAddress();
    
    LocalIpv4Prefix getSourceIpAddress();
    
    LocalIpv4Prefix getDstIpAddress();
    
    TrafficType getTrafficMatch();

}

