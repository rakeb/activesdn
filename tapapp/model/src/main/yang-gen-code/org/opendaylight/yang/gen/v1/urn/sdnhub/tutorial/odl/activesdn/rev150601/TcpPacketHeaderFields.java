package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * grouping tcp-packet-header-fields {
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
 * <i>activesdn/tcp-packet-header-fields</i>
 *
 */
public interface TcpPacketHeaderFields
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "tcp-packet-header-fields").intern();

    java.lang.Short getSourcePort();
    
    java.lang.Short getDestPort();
    
    java.lang.Integer getSequenceNumber();
    
    java.lang.Boolean isSynFlag();
    
    java.lang.Boolean isRstFlag();
    
    java.lang.Boolean isAckFlag();
    
    java.lang.Boolean isFinFlag();

}

