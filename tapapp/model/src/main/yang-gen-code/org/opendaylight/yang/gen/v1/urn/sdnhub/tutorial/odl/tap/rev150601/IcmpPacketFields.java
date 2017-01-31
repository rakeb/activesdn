package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping icmp-packet-fields {
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
 *     leaf payload-offset {
 *         type int32;
 *     }
 *     leaf payload-length {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/icmp-packet-fields</i>
 *
 */
public interface IcmpPacketFields
    extends
    DataObject,
    PacketFields
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "icmp-packet-fields").intern();

    java.lang.Short getType();
    
    java.lang.Short getCode();
    
    java.lang.Integer getCrc();
    
    java.lang.Integer getIdentifier();
    
    java.lang.Integer getSequenceNumber();

}

