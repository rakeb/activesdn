package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * container input {
 *     leaf old-src-ip-address {
 *         type string;
 *     }
 *     leaf new-src-ip-address {
 *         type string;
 *     }
 *     leaf old-dst-ip-address {
 *         type string;
 *     }
 *     leaf new-dst-ip-address {
 *         type string;
 *     }
 *     leaf-list switches-in-old-path {
 *         type int32;
 *     }
 *     leaf-list switches-in-new-path {
 *         type int32;
 *     }
 *     leaf flow-priority {
 *         type flow-priority;
 *     }
 *     leaf idle-timeout {
 *         type idle-timeout;
 *     }
 *     leaf hard-timeout {
 *         type hard-timeout;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/migrate-network-path/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.MigrateNetworkPathInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.MigrateNetworkPathInputBuilder
 *
 */
public interface MigrateNetworkPathInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.MigrateNetworkPathInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "input").intern();

    /**
     * It is assumed that this filed must be provided
     *
     */
    java.lang.String getOldSrcIpAddress();
    
    /**
     * This field may left empty
     *
     */
    java.lang.String getNewSrcIpAddress();
    
    java.lang.String getOldDstIpAddress();
    
    java.lang.String getNewDstIpAddress();
    
    List<java.lang.Integer> getSwitchesInOldPath();
    
    List<java.lang.Integer> getSwitchesInNewPath();
    
    java.lang.Integer getFlowPriority();
    
    java.lang.Integer getIdleTimeout();
    
    java.lang.Integer getHardTimeout();

}

