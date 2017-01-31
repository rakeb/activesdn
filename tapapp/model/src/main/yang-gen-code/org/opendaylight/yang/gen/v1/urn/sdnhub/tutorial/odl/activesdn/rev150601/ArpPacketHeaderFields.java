package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * grouping arp-packet-header-fields {
 *     leaf ethernet-src-mac-address {
 *         type string;
 *     }
 *     leaf ethernet-type {
 *         type string;
 *     }
 *     leaf hardware-type {
 *         type string;
 *     }
 *     leaf protocol-type {
 *         type string;
 *     }
 *     leaf hardware-address-length {
 *         type int32;
 *     }
 *     leaf protocol-address-length {
 *         type int32;
 *     }
 *     leaf opcode {
 *         type string;
 *     }
 *     leaf sender-hardware-address {
 *         type string;
 *     }
 *     leaf sender-protocol-address {
 *         type string;
 *     }
 *     leaf target-hardware-address {
 *         type string;
 *     }
 *     leaf target-protocol-address {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/arp-packet-header-fields</i>
 *
 */
public interface ArpPacketHeaderFields
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "arp-packet-header-fields").intern();

    java.lang.String getEthernetSrcMacAddress();
    
    java.lang.String getEthernetType();
    
    java.lang.String getHardwareType();
    
    java.lang.String getProtocolType();
    
    java.lang.Integer getHardwareAddressLength();
    
    java.lang.Integer getProtocolAddressLength();
    
    java.lang.String getOpcode();
    
    java.lang.String getSenderHardwareAddress();
    
    java.lang.String getSenderProtocolAddress();
    
    java.lang.String getTargetHardwareAddress();
    
    java.lang.String getTargetProtocolAddress();

}

