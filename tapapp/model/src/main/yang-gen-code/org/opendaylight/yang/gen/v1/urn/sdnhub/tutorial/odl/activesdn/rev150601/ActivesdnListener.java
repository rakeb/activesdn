package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.NotificationListener;


/**
 * Interface for receiving the following YANG notifications defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * notification event-triggered {
 *     leaf triggered-event-type {
 *         type enumeration;
 *     }
 *     leaf event-id {
 *         type string;
 *     }
 *     leaf switch-id {
 *         type int32;
 *     }
 *     leaf in-port-number {
 *         type int32;
 *     }
 *     choice packet-type {
 *         case arp-packet-type {
 *             leaf ethernet-src-mac-address {
 *                 type string;
 *             }
 *             leaf ethernet-type {
 *                 type string;
 *             }
 *             leaf hardware-type {
 *                 type string;
 *             }
 *             leaf protocol-type {
 *                 type string;
 *             }
 *             leaf hardware-address-length {
 *                 type int32;
 *             }
 *             leaf protocol-address-length {
 *                 type int32;
 *             }
 *             leaf opcode {
 *                 type string;
 *             }
 *             leaf sender-hardware-address {
 *                 type string;
 *             }
 *             leaf sender-protocol-address {
 *                 type string;
 *             }
 *             leaf target-hardware-address {
 *                 type string;
 *             }
 *             leaf target-protocol-address {
 *                 type string;
 *             }
 *         }
 *         case icmp-packet-type {
 *             leaf ethernet-src-mac-address {
 *                 type string;
 *             }
 *             leaf ethernet-type {
 *                 type string;
 *             }
 *             leaf type {
 *                 type uint8;
 *             }
 *             leaf code {
 *                 type uint8;
 *             }
 *             leaf crc {
 *                 type uint16;
 *             }
 *             leaf identifier {
 *                 type uint16;
 *             }
 *             leaf sequence-number {
 *                 type uint16;
 *             }
 *             leaf version {
 *                 type uint8;
 *             }
 *             leaf ihl {
 *                 type uint8;
 *             }
 *             leaf dscp-value {
 *                 type uint8;
 *             }
 *             leaf ecn {
 *                 type uint8;
 *             }
 *             leaf total-length {
 *                 type uint16;
 *             }
 *             leaf identification {
 *                 type uint16;
 *             }
 *             leaf reserved-flag {
 *                 type boolean;
 *             }
 *             leaf df-flag {
 *                 type boolean;
 *             }
 *             leaf mf-flag {
 *                 type boolean;
 *             }
 *             leaf fragment-offset {
 *                 type uint16;
 *             }
 *             leaf ttl {
 *                 type uint8;
 *             }
 *             leaf protocol {
 *                 type uint8;
 *             }
 *             leaf header-checksum {
 *                 type uint16;
 *             }
 *             leaf source-address {
 *                 type string;
 *             }
 *             leaf destination-address {
 *                 type string;
 *             }
 *             leaf ipv4-options {
 *                 type binary;
 *             }
 *             leaf icmp-payload-offset {
 *                 type int32;
 *             }
 *             leaf icmp-payload-length {
 *                 type int32;
 *             }
 *         }
 *         case ipv4-packet-type {
 *             leaf version {
 *                 type uint8;
 *             }
 *             leaf ihl {
 *                 type uint8;
 *             }
 *             leaf dscp-value {
 *                 type uint8;
 *             }
 *             leaf ecn {
 *                 type uint8;
 *             }
 *             leaf total-length {
 *                 type uint16;
 *             }
 *             leaf identification {
 *                 type uint16;
 *             }
 *             leaf reserved-flag {
 *                 type boolean;
 *             }
 *             leaf df-flag {
 *                 type boolean;
 *             }
 *             leaf mf-flag {
 *                 type boolean;
 *             }
 *             leaf fragment-offset {
 *                 type uint16;
 *             }
 *             leaf ttl {
 *                 type uint8;
 *             }
 *             leaf protocol {
 *                 type uint8;
 *             }
 *             leaf header-checksum {
 *                 type uint16;
 *             }
 *             leaf source-address {
 *                 type string;
 *             }
 *             leaf destination-address {
 *                 type string;
 *             }
 *             leaf ipv4-options {
 *                 type binary;
 *             }
 *         }
 *         case tcp-packet-type {
 *             leaf version {
 *                 type uint8;
 *             }
 *             leaf ihl {
 *                 type uint8;
 *             }
 *             leaf dscp-value {
 *                 type uint8;
 *             }
 *             leaf ecn {
 *                 type uint8;
 *             }
 *             leaf total-length {
 *                 type uint16;
 *             }
 *             leaf identification {
 *                 type uint16;
 *             }
 *             leaf reserved-flag {
 *                 type boolean;
 *             }
 *             leaf df-flag {
 *                 type boolean;
 *             }
 *             leaf mf-flag {
 *                 type boolean;
 *             }
 *             leaf fragment-offset {
 *                 type uint16;
 *             }
 *             leaf ttl {
 *                 type uint8;
 *             }
 *             leaf protocol {
 *                 type uint8;
 *             }
 *             leaf header-checksum {
 *                 type uint16;
 *             }
 *             leaf source-address {
 *                 type string;
 *             }
 *             leaf destination-address {
 *                 type string;
 *             }
 *             leaf ipv4-options {
 *                 type binary;
 *             }
 *             leaf source-port {
 *                 type int16;
 *             }
 *             leaf dest-port {
 *                 type int16;
 *             }
 *             leaf sequence-number {
 *                 type int32;
 *             }
 *             leaf syn-flag {
 *                 type boolean;
 *             }
 *             leaf rst-flag {
 *                 type boolean;
 *             }
 *             leaf ack-flag {
 *                 type boolean;
 *             }
 *             leaf fin-flag {
 *                 type boolean;
 *             }
 *         }
 *     }
 *     leaf payload {
 *         type binary;
 *     }
 *     leaf string-payload {
 *         type string;
 *     }
 * }
 * notification new-host-found {
 *     leaf host-mac-address {
 *         type string;
 *     }
 *     leaf host-ip-address {
 *         type string;
 *     }
 *     leaf switch-connected-to {
 *         type int32;
 *     }
 *     leaf port-connected-to {
 *         type int32;
 *     }
 * }
 * notification is-dropbox-detected {
 *     container dropbox-info {
 *         leaf srcIp {
 *             type string;
 *         }
 *         leaf dstPort {
 *             type int32;
 *         }
 *         leaf dstIp {
 *             type string;
 *         }
 *     }
 * }
 * notification flow-statistic-received {
 *     list switch-statistics {
 *         key "switch-id"
 *         leaf switch-id {
 *             type int32;
 *         }
 *         list flow-statistic {
 *             key "flow-id"
 *             leaf flow-id {
 *                 type string;
 *             }
 *             leaf packet-count {
 *                 type uint32;
 *             }
 *             leaf byte-count {
 *                 type uint32;
 *             }
 *             leaf duration {
 *                 type duration;
 *             }
 *             leaf src-ip-address {
 *                 type string;
 *             }
 *             leaf dst-ip-address {
 *                 type string;
 *             }
 *             leaf type-of-traffic {
 *                 type traffic-type;
 *             }
 *             leaf src-port {
 *                 type int32;
 *             }
 *             leaf dst-port {
 *                 type int32;
 *             }
 *         }
 *         uses grp-flow-statistic;
 *     }
 *     leaf stats-time {
 *         type uint32;
 *     }
 * }
 * notification construct-topology {
 * }
 * notification flow-is-removed {
 *     leaf switch-id {
 *         type int32;
 *     }
 *     leaf flow-id {
 *         type string;
 *     }
 * }
 * notification is-link-flooded {
 *     list flooded-links {
 *         key "link-id"
 *         leaf link-id {
 *             type string;
 *         }
 *         leaf packet-drop-observed {
 *             type uint32;
 *         }
 *     }
 * }
 * </pre>
 *
 */
public interface ActivesdnListener
    extends
    NotificationListener
{




    void onEventTriggered(EventTriggered notification);
    
    void onNewHostFound(NewHostFound notification);
    
    void onIsDropboxDetected(IsDropboxDetected notification);
    
    void onFlowStatisticReceived(FlowStatisticReceived notification);
    
    void onConstructTopology(ConstructTopology notification);
    
    void onFlowIsRemoved(FlowIsRemoved notification);
    
    void onIsLinkFlooded(IsLinkFlooded notification);

}

