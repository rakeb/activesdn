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
 *     leaf flow-key {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/remove-a-flow-rule-from-switch/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RemoveAFlowRuleFromSwitchInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RemoveAFlowRuleFromSwitchInputBuilder
 *
 */
public interface RemoveAFlowRuleFromSwitchInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.RemoveAFlowRuleFromSwitchInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "input").intern();

    java.lang.Integer getSwitchId();
    
    java.lang.String getFlowKey();

}

