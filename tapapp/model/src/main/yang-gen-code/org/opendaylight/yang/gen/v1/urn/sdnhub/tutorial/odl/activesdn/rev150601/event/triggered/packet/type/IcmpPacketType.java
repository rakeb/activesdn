package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.PacketType;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * case icmp-packet-type {
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
 *     leaf version {
 *         type uint8;
 *     }
 *     leaf ihl {
 *         type uint8;
 *     }
 *     leaf dscp-value {
 *         type uint8;
 *     }
 *     leaf ecn {
 *         type uint8;
 *     }
 *     leaf total-length {
 *         type uint16;
 *     }
 *     leaf identification {
 *         type uint16;
 *     }
 *     leaf reserved-flag {
 *         type boolean;
 *     }
 *     leaf df-flag {
 *         type boolean;
 *     }
 *     leaf mf-flag {
 *         type boolean;
 *     }
 *     leaf fragment-offset {
 *         type uint16;
 *     }
 *     leaf ttl {
 *         type uint8;
 *     }
 *     leaf protocol {
 *         type uint8;
 *     }
 *     leaf header-checksum {
 *         type uint16;
 *     }
 *     leaf source-address {
 *         type string;
 *     }
 *     leaf destination-address {
 *         type string;
 *     }
 *     leaf ipv4-options {
 *         type binary;
 *     }
 *     leaf icmp-payload-offset {
 *         type int32;
 *     }
 *     leaf icmp-payload-length {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/event-triggered/packet-type/icmp-packet-type</i>
 *
 */
public interface IcmpPacketType
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>,
    Ipv4PacketHeaderFields,
    IcmpPacketHeaderFields,
    PacketType
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "icmp-packet-type").intern();

    java.lang.Integer getIcmpPayloadOffset();
    
    java.lang.Integer getIcmpPayloadLength();

}

