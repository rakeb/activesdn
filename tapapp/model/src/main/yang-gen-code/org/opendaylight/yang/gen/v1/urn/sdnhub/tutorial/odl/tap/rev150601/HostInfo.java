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
 * grouping host-info {
 *     leaf host-mac-address {
 *         type mac-address;
 *     }
 *     leaf host-ip-address {
 *         type local-ipv4-prefix;
 *     }
 *     leaf host-last-seen {
 *         type string;
 *     }
 *     leaf host-first-seen {
 *         type string;
 *     }
 *     leaf node-connected-to {
 *         type leafref;
 *     }
 *     leaf node-connector-connected-to {
 *         type leafref;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/host-info</i>
 *
 */
public interface HostInfo
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "host-info").intern();

    MacAddress getHostMacAddress();
    
    LocalIpv4Prefix getHostIpAddress();
    
    java.lang.String getHostLastSeen();
    
    java.lang.String getHostFirstSeen();
    
    NodeId getNodeConnectedTo();
    
    NodeConnectorId getNodeConnectorConnectedTo();

}

