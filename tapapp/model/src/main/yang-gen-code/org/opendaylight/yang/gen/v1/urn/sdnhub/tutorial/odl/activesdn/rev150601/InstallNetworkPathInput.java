package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TrafficType;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * container input {
 *     leaf src-ip-address {
 *         type string;
 *     }
 *     leaf dst-ip-address {
 *         type string;
 *     }
 *     leaf-list switches-in-path {
 *         type int32;
 *     }
 *     leaf type-of-traffic {
 *         type traffic-type;
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
 * <i>activesdn/install-network-path/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.InstallNetworkPathInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.InstallNetworkPathInputBuilder
 *
 */
public interface InstallNetworkPathInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.InstallNetworkPathInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "input").intern();

    java.lang.String getSrcIpAddress();
    
    java.lang.String getDstIpAddress();
    
    List<java.lang.Integer> getSwitchesInPath();
    
    TrafficType getTypeOfTraffic();
    
    java.lang.Integer getFlowPriority();
    
    java.lang.Integer getIdleTimeout();
    
    java.lang.Integer getHardTimeout();

}

