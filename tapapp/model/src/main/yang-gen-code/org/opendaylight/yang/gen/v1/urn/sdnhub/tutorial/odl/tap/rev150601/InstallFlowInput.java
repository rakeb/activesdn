package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.NewFlow;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActions;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * container input {
 *     leaf node {
 *         type leafref;
 *     }
 *     leaf flow-id {
 *         type string;
 *     }
 *     container new-flow {
 *         leaf in-port {
 *             type leafref;
 *         }
 *         leaf src-mac-address {
 *             type mac-address;
 *         }
 *         leaf dst-mac-address {
 *             type mac-address;
 *         }
 *         leaf src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf traffic-match {
 *             type traffic-type;
 *         }
 *         leaf flow-priority {
 *             type flow-priority;
 *         }
 *         leaf idle-timeout {
 *             type idle-timeout;
 *         }
 *         leaf hard-timeout {
 *             type hard-timeout;
 *         }
 *         container custom-info {
 *             leaf dl-type {
 *                 type dl-type;
 *             }
 *             leaf nw-proto {
 *                 type nw-proto;
 *             }
 *             leaf tp-dst {
 *                 type tp-dst;
 *             }
 *         }
 *         uses match;
 *     }
 *     list associated-actions {
 *         key "id"
 *         leaf id {
 *             type uint32;
 *         }
 *         choice flow-actions {
 *             case drop-packet-case {
 *                 container drop-packet {
 *                 }
 *             }
 *             case forward-to-controller-case {
 *                 container forward-to-controller {
 *                 }
 *             }
 *             case forward-to-flood-case {
 *                 container forward-to-flood {
 *                 }
 *             }
 *             case forward-to-port-case {
 *                 container forward-to-port {
 *                     leaf output-node-connector {
 *                         type leafref;
 *                     }
 *                 }
 *             }
 *             case set-dst-ipv4-address-case {
 *                 container set-dst-ipv4-address {
 *                     leaf value {
 *                         type ipv4-prefix;
 *                     }
 *                 }
 *             }
 *             case set-ipv4-tos-case {
 *                 container set-ipv4-tos {
 *                     leaf value {
 *                         type int32;
 *                     }
 *                 }
 *             }
 *             case set-ipv4-ttl-case {
 *                 container set-ipv4-ttl {
 *                     leaf ttl-value {
 *                         type uint8;
 *                     }
 *                 }
 *             }
 *             case set-port-queue-case {
 *                 container set-queue {
 *                     leaf queue {
 *                         type string;
 *                     }
 *                     leaf queue-id {
 *                         type uint32;
 *                     }
 *                     leaf egress-port {
 *                         type leafref;
 *                     }
 *                 }
 *             }
 *             case set-rate-limit-case {
 *                 container set-rate-limit {
 *                     leaf meter-type {
 *                         type meter-flags;
 *                     }
 *                     leaf band-rate {
 *                         type uint32;
 *                     }
 *                     leaf band-burst-size {
 *                         type band-burst-size;
 *                     }
 *                     leaf drop-rate {
 *                         type drop-rate;
 *                     }
 *                     leaf drop-burst-size {
 *                         type drop-burst-size;
 *                     }
 *                     leaf egress-port {
 *                         type leafref;
 *                     }
 *                 }
 *             }
 *             case set-source-ipv4-address-case {
 *                 container set-source-ipv4-address {
 *                     leaf value {
 *                         type ipv4-prefix;
 *                     }
 *                 }
 *             }
 *             case set-tcp-dst-port-case {
 *                 container set-tcp-dst-port {
 *                     leaf port-number {
 *                         type int32;
 *                     }
 *                 }
 *             }
 *             case set-tcp-src-port-case {
 *                 container set-tcp-src-port {
 *                     leaf port-number {
 *                         type int32;
 *                     }
 *                 }
 *             }
 *         }
 *         uses flow-actions;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>tap/install-flow/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInputBuilder
 *
 */
public interface InstallFlowInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.InstallFlowInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:tutorial:odl:tap",
        "2015-06-01", "input").intern();

    NodeId getNode();
    
    java.lang.String getFlowId();
    
    NewFlow getNewFlow();
    
    List<AssociatedActions> getAssociatedActions();

}

