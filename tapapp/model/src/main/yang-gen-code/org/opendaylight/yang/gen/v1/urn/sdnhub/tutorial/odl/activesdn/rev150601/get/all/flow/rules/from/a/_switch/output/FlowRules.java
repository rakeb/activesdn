package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.FlowRuleSpecs;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.GetAllFlowRulesFromASwitchOutput;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * list flow-rules {
 *     key "flow-id"
 *     leaf flow-id {
 *         type string;
 *     }
 *     leaf switch-id {
 *         type int32;
 *     }
 *     leaf in-port-id {
 *         type uint32;
 *     }
 *     leaf src-mac-address {
 *         type string;
 *     }
 *     leaf dst-mac-address {
 *         type string;
 *     }
 *     leaf src-ip-address {
 *         type string;
 *     }
 *     leaf dst-ip-address {
 *         type string;
 *     }
 *     leaf type-of-traffic {
 *         type traffic-type;
 *     }
 *     leaf src-port {
 *         type int32;
 *     }
 *     leaf dst-port {
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
 *     leaf action-output-port {
 *         type string;
 *     }
 *     leaf action-set-source-ipv4-address {
 *         type string;
 *     }
 *     leaf action-set-dst-ipv4-address {
 *         type string;
 *     }
 *     leaf action-set-ipv4-tos {
 *         type int32;
 *     }
 *     leaf action-set-tcp-src-port {
 *         type int32;
 *     }
 *     leaf action-set-tcp-dst-port {
 *         type int32;
 *     }
 *     leaf action-set-ipv4-ttl {
 *         type uint8;
 *     }
 *     leaf action-set-port-queue {
 *         type int32;
 *     }
 *     uses flow-rule-specs;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>activesdn/get-all-flow-rules-from-a-switch/output/flow-rules</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRulesBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRulesBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRulesKey
 *
 */
public interface FlowRules
    extends
    ChildOf<GetAllFlowRulesFromASwitchOutput>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.get.all.flow.rules.from.a._switch.output.FlowRules>,
    FlowRuleSpecs,
    Identifiable<FlowRulesKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:activesdn",
        "2015-06-01", "flow-rules").intern();

    java.lang.String getFlowId();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    FlowRulesKey getKey();

}

