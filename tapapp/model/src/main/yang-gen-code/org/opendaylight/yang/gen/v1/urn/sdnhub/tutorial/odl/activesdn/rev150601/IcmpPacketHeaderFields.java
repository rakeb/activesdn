package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * grouping icmp-packet-header-fields {
 *     leaf ethernet-src-mac-address {
 *         type string;
 *     }
 *     leaf ethernet-type {
 *         type string;
 *     }
 *     leaf type {
 *         type uint8;
 *     }
 *     leaf code {
 *         type uint8;
 *     }
 *     leaf crc {
 *         type uint16;
 *     }
 *     leaf identifier {
 *         type uint16;
 *     }
 *     leaf sequence-number {
 *         type uint16;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/icmp-packet-header-fields</i>
 *
 */
public interface IcmpPacketHeaderFields
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "icmp-packet-header-fields").intern();

    java.lang.String getEthernetSrcMacAddress();
    
    java.lang.String getEthernetType();
    
    java.lang.Short getType();
    
    java.lang.Short getCode();
    
    java.lang.Integer getCrc();
    
    java.lang.Integer getIdentifier();
    
    java.lang.Integer getSequenceNumber();

}

