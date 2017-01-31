package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * grouping tcp-packet-fields {
 *     leaf source-port {
 *         type int16;
 *     }
 *     leaf dest-port {
 *         type int16;
 *     }
 *     leaf sequence-number {
 *         type int32;
 *     }
 *     leaf syn-flag {
 *         type boolean;
 *     }
 *     leaf rst-flag {
 *         type boolean;
 *     }
 *     leaf ack-flag {
 *         type boolean;
 *     }
 *     leaf fin-flag {
 *         type boolean;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/tcp-packet-fields</i>
 *
 */
public interface TcpPacketFields
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "tcp-packet-fields").intern();

    java.lang.Short getSourcePort();
    
    java.lang.Short getDestPort();
    
    java.lang.Integer getSequenceNumber();
    
    java.lang.Boolean isSynFlag();
    
    java.lang.Boolean isRstFlag();
    
    java.lang.Boolean isAckFlag();
    
    java.lang.Boolean isFinFlag();

}

