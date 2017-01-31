package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container ipv4-packet-header {
 *     leaf version {
 *         type uint8;
 *     }
 *     leaf ihl {
 *         type uint8;
 *     }
 *     leaf dscp {
 *         type uint8;
 *     }
 *     leaf ecn {
 *         type uint8;
 *     }
 *     leaf ipv4-length {
 *         type uint16;
 *     }
 *     leaf id {
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
 *         type known-ip-protocols;
 *     }
 *     leaf checksum {
 *         type uint16;
 *     }
 *     leaf source-ipv4 {
 *         type string;
 *     }
 *     leaf destination-ipv4 {
 *         type string;
 *     }
 *     leaf ipv4-options {
 *         type binary;
 *     }
 *     leaf payload-offset {
 *         type int32;
 *     }
 *     leaf payload-length {
 *         type int32;
 *     }
 *     leaf payload {
 *         type binary;
 *     }
 *     uses ipv4-packet-fields;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/ipv4-packet-header</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Ipv4PacketHeaderBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Ipv4PacketHeaderBuilder
 *
 */
public interface Ipv4PacketHeader
    extends
    ChildOf<TapData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.Ipv4PacketHeader>,
    Ipv4PacketFields
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "ipv4-packet-header").intern();

    byte[] getPayload();

}

