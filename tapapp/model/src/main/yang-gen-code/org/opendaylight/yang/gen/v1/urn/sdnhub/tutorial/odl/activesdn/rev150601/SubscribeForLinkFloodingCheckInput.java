package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * container input {
 *     leaf switch-id {
 *         type int32;
 *     }
 *     leaf connector-id {
 *         type int32;
 *     }
 *     leaf drop-threshold {
 *         type int32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/subscribe-for-link-flooding-check/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeForLinkFloodingCheckInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeForLinkFloodingCheckInputBuilder
 *
 */
public interface SubscribeForLinkFloodingCheckInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.SubscribeForLinkFloodingCheckInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "input").intern();

    java.lang.Integer getSwitchId();
    
    java.lang.Integer getConnectorId();
    
    java.lang.Integer getDropThreshold();

}

