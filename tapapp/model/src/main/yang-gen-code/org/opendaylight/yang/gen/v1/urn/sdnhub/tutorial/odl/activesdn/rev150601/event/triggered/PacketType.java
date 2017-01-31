package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered;
import org.opendaylight.yangtools.yang.binding.DataContainer;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * choice packet-type {
 *     case arp-packet-type {
 *         leaf ethernet-src-mac-address {
 *             type string;
 *         }
 *         leaf ethernet-type {
 *             type string;
 *         }
 *         leaf hardware-type {
 *             type string;
 *         }
 *         leaf protocol-type {
 *             type string;
 *         }
 *         leaf hardware-address-length {
 *             type int32;
 *         }
 *         leaf protocol-address-length {
 *             type int32;
 *         }
 *         leaf opcode {
 *             type string;
 *         }
 *         leaf sender-hardware-address {
 *             type string;
 *         }
 *         leaf sender-protocol-address {
 *             type string;
 *         }
 *         leaf target-hardware-address {
 *             type string;
 *         }
 *         leaf target-protocol-address {
 *             type string;
 *         }
 *     }
 *     case icmp-packet-type {
 *         leaf ethernet-src-mac-address {
 *             type string;
 *         }
 *         leaf ethernet-type {
 *             type string;
 *         }
 *         leaf type {
 *             type uint8;
 *         }
 *         leaf code {
 *             type uint8;
 *         }
 *         leaf crc {
 *             type uint16;
 *         }
 *         leaf identifier {
 *             type uint16;
 *         }
 *         leaf sequence-number {
 *             type uint16;
 *         }
 *         leaf version {
 *             type uint8;
 *         }
 *         leaf ihl {
 *             type uint8;
 *         }
 *         leaf dscp-value {
 *             type uint8;
 *         }
 *         leaf ecn {
 *             type uint8;
 *         }
 *         leaf total-length {
 *             type uint16;
 *         }
 *         leaf identification {
 *             type uint16;
 *         }
 *         leaf reserved-flag {
 *             type boolean;
 *         }
 *         leaf df-flag {
 *             type boolean;
 *         }
 *         leaf mf-flag {
 *             type boolean;
 *         }
 *         leaf fragment-offset {
 *             type uint16;
 *         }
 *         leaf ttl {
 *             type uint8;
 *         }
 *         leaf protocol {
 *             type uint8;
 *         }
 *         leaf header-checksum {
 *             type uint16;
 *         }
 *         leaf source-address {
 *             type string;
 *         }
 *         leaf destination-address {
 *             type string;
 *         }
 *         leaf ipv4-options {
 *             type binary;
 *         }
 *         leaf icmp-payload-offset {
 *             type int32;
 *         }
 *         leaf icmp-payload-length {
 *             type int32;
 *         }
 *     }
 *     case ipv4-packet-type {
 *         leaf version {
 *             type uint8;
 *         }
 *         leaf ihl {
 *             type uint8;
 *         }
 *         leaf dscp-value {
 *             type uint8;
 *         }
 *         leaf ecn {
 *             type uint8;
 *         }
 *         leaf total-length {
 *             type uint16;
 *         }
 *         leaf identification {
 *             type uint16;
 *         }
 *         leaf reserved-flag {
 *             type boolean;
 *         }
 *         leaf df-flag {
 *             type boolean;
 *         }
 *         leaf mf-flag {
 *             type boolean;
 *         }
 *         leaf fragment-offset {
 *             type uint16;
 *         }
 *         leaf ttl {
 *             type uint8;
 *         }
 *         leaf protocol {
 *             type uint8;
 *         }
 *         leaf header-checksum {
 *             type uint16;
 *         }
 *         leaf source-address {
 *             type string;
 *         }
 *         leaf destination-address {
 *             type string;
 *         }
 *         leaf ipv4-options {
 *             type binary;
 *         }
 *     }
 *     case tcp-packet-type {
 *         leaf version {
 *             type uint8;
 *         }
 *         leaf ihl {
 *             type uint8;
 *         }
 *         leaf dscp-value {
 *             type uint8;
 *         }
 *         leaf ecn {
 *             type uint8;
 *         }
 *         leaf total-length {
 *             type uint16;
 *         }
 *         leaf identification {
 *             type uint16;
 *         }
 *         leaf reserved-flag {
 *             type boolean;
 *         }
 *         leaf df-flag {
 *             type boolean;
 *         }
 *         leaf mf-flag {
 *             type boolean;
 *         }
 *         leaf fragment-offset {
 *             type uint16;
 *         }
 *         leaf ttl {
 *             type uint8;
 *         }
 *         leaf protocol {
 *             type uint8;
 *         }
 *         leaf header-checksum {
 *             type uint16;
 *         }
 *         leaf source-address {
 *             type string;
 *         }
 *         leaf destination-address {
 *             type string;
 *         }
 *         leaf ipv4-options {
 *             type binary;
 *         }
 *         leaf source-port {
 *             type int16;
 *         }
 *         leaf dest-port {
 *             type int16;
 *         }
 *         leaf sequence-number {
 *             type int32;
 *         }
 *         leaf syn-flag {
 *             type boolean;
 *         }
 *         leaf rst-flag {
 *             type boolean;
 *         }
 *         leaf ack-flag {
 *             type boolean;
 *         }
 *         leaf fin-flag {
 *             type boolean;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/event-triggered/packet-type</i>
 *
 */
public interface PacketType
    extends
    DataContainer
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "packet-type").intern();


}

