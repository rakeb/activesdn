package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping packet-fields {
 *     leaf payload-offset {
 *         type int32;
 *     }
 *     leaf payload-length {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/packet-fields</i>
 *
 */
public interface PacketFields
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "packet-fields").intern();

    java.lang.Integer getPayloadOffset();
    
    java.lang.Integer getPayloadLength();

}

