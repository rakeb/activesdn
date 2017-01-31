package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IsDropboxDetected;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * container dropbox-info {
 *     leaf srcIp {
 *         type string;
 *     }
 *     leaf dstPort {
 *         type int32;
 *     }
 *     leaf dstIp {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/is-dropbox-detected/dropbox-info</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfoBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfoBuilder
 *
 */
public interface DropboxInfo
    extends
    ChildOf<IsDropboxDetected>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "dropbox-info").intern();

    java.lang.String getSrcIp();
    
    java.lang.Integer getDstPort();
    
    java.lang.String getDstIp();

}

