package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInput;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.FlowActions;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * list associated-actions {
 *     key "id"
 *     leaf id {
 *         type uint32;
 *     }
 *     choice flow-actions {
 *         case drop-packet-case {
 *             container drop-packet {
 *             }
 *         }
 *         case forward-to-controller-case {
 *             container forward-to-controller {
 *             }
 *         }
 *         case forward-to-flood-case {
 *             container forward-to-flood {
 *             }
 *         }
 *         case forward-to-port-case {
 *             container forward-to-port {
 *                 leaf output-node-connector {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *         case set-dst-ipv4-address-case {
 *             container set-dst-ipv4-address {
 *                 leaf value {
 *                     type ipv4-prefix;
 *                 }
 *             }
 *         }
 *         case set-ipv4-tos-case {
 *             container set-ipv4-tos {
 *                 leaf value {
 *                     type int32;
 *                 }
 *             }
 *         }
 *         case set-ipv4-ttl-case {
 *             container set-ipv4-ttl {
 *                 leaf ttl-value {
 *                     type uint8;
 *                 }
 *             }
 *         }
 *         case set-port-queue-case {
 *             container set-queue {
 *                 leaf queue {
 *                     type string;
 *                 }
 *                 leaf queue-id {
 *                     type uint32;
 *                 }
 *                 leaf egress-port {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *         case set-rate-limit-case {
 *             container set-rate-limit {
 *                 leaf meter-type {
 *                     type meter-flags;
 *                 }
 *                 leaf band-rate {
 *                     type uint32;
 *                 }
 *                 leaf band-burst-size {
 *                     type band-burst-size;
 *                 }
 *                 leaf drop-rate {
 *                     type drop-rate;
 *                 }
 *                 leaf drop-burst-size {
 *                     type drop-burst-size;
 *                 }
 *                 leaf egress-port {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *         case set-source-ipv4-address-case {
 *             container set-source-ipv4-address {
 *                 leaf value {
 *                     type ipv4-prefix;
 *                 }
 *             }
 *         }
 *         case set-tcp-dst-port-case {
 *             container set-tcp-dst-port {
 *                 leaf port-number {
 *                     type int32;
 *                 }
 *             }
 *         }
 *         case set-tcp-src-port-case {
 *             container set-tcp-src-port {
 *                 leaf port-number {
 *                     type int32;
 *                 }
 *             }
 *         }
 *     }
 *     uses flow-actions;
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/install-flow/input/associated-actions</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActionsBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActionsBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActionsKey
 *
 */
public interface AssociatedActions
    extends
    ChildOf<InstallFlowInput>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActions>,
    FlowActions,
    Identifiable<AssociatedActionsKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "associated-actions").intern();

    java.lang.Long getId();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    AssociatedActionsKey getKey();

}

