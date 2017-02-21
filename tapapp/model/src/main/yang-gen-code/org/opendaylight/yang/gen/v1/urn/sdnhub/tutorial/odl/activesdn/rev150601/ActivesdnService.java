package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.binding.RpcService;
import java.util.concurrent.Future;


/**
 * Interface for implementing the following YANG RPCs defined in module <b>activesdn</b>
 * <br>(Source path: <i>META-INF/yang/activesdn.yang</i>):
 * <pre>
 * rpc remove-all-flows-from-a-switch {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc send-packet-out {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *         leaf payload {
 *             type binary;
 *         }
 *         leaf in-port-number {
 *             type int32;
 *         }
 *         leaf output-port {
 *             type string;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc get-flow-statistics {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
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
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc subscribe-for-link-flooding-check {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *         leaf connector-id {
 *             type int32;
 *         }
 *         leaf drop-threshold {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc unsubscribe-for-stats-from-switch {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc create-src-dst-tunnel {
 *     input {
 *         leaf current-src-ip-address {
 *             type string;
 *         }
 *         leaf new-src-ip-address {
 *             type string;
 *         }
 *         leaf current-dst-ip-address {
 *             type string;
 *         }
 *         leaf new-dst-ip-address {
 *             type string;
 *         }
 *         leaf-list switches-in-path {
 *             type int32;
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
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc install-flow-rule {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *         leaf in-port-id {
 *             type uint32;
 *         }
 *         leaf src-mac-address {
 *             type string;
 *         }
 *         leaf dst-mac-address {
 *             type string;
 *         }
 *         leaf src-ip-address {
 *             type string;
 *         }
 *         leaf dst-ip-address {
 *             type string;
 *         }
 *         leaf type-of-traffic {
 *             type traffic-type;
 *         }
 *         leaf src-port {
 *             type int32;
 *         }
 *         leaf dst-port {
 *             type int32;
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
 *         leaf action-output-port {
 *             type string;
 *         }
 *         leaf action-set-source-ipv4-address {
 *             type string;
 *         }
 *         leaf action-set-dst-ipv4-address {
 *             type string;
 *         }
 *         leaf action-set-ipv4-tos {
 *             type int32;
 *         }
 *         leaf action-set-tcp-src-port {
 *             type int32;
 *         }
 *         leaf action-set-tcp-dst-port {
 *             type int32;
 *         }
 *         leaf action-set-ipv4-ttl {
 *             type uint8;
 *         }
 *         leaf action-set-port-queue {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
 *         leaf flow-id {
 *             type string;
 *         }
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc unsubscribe-for-link-flooding-check {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *         leaf connector-id {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc get-port-statistics {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *         leaf connector-id {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
 *         leaf total-transmitted {
 *             type uint32;
 *         }
 *         leaf total-received {
 *             type uint32;
 *         }
 *         leaf receive-drops {
 *             type uint32;
 *         }
 *         leaf transmit-drops {
 *             type uint32;
 *         }
 *     }
 * }
 * rpc subscribe-event {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *         leaf in-port-id {
 *             type uint32;
 *         }
 *         leaf src-mac-address {
 *             type string;
 *         }
 *         leaf dst-mac-address {
 *             type string;
 *         }
 *         leaf src-ip-address {
 *             type string;
 *         }
 *         leaf dst-ip-address {
 *             type string;
 *         }
 *         leaf traffic-protocol {
 *             type traffic-type;
 *         }
 *         leaf count {
 *             type uint32;
 *         }
 *         leaf duration {
 *             type uint32;
 *         }
 *         leaf hold-notification {
 *             type int32;
 *         }
 *         leaf event-action {
 *             type enumeration;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *         leaf event-id {
 *             type string;
 *         }
 *     }
 * }
 * rpc remove-event-from-switch {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *         leaf event-id {
 *             type string;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc install-network-path {
 *     input {
 *         leaf src-ip-address {
 *             type string;
 *         }
 *         leaf dst-ip-address {
 *             type string;
 *         }
 *         leaf-list switches-in-path {
 *             type int32;
 *         }
 *         leaf type-of-traffic {
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
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc get-all-flow-rules-from-a-switch {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
 *         list flow-rules {
 *             key "flow-id"
 *             leaf flow-id {
 *                 type string;
 *             }
 *             leaf switch-id {
 *                 type int32;
 *             }
 *             leaf in-port-id {
 *                 type uint32;
 *             }
 *             leaf src-mac-address {
 *                 type string;
 *             }
 *             leaf dst-mac-address {
 *                 type string;
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
 *             leaf flow-priority {
 *                 type flow-priority;
 *             }
 *             leaf idle-timeout {
 *                 type idle-timeout;
 *             }
 *             leaf hard-timeout {
 *                 type hard-timeout;
 *             }
 *             leaf action-output-port {
 *                 type string;
 *             }
 *             leaf action-set-source-ipv4-address {
 *                 type string;
 *             }
 *             leaf action-set-dst-ipv4-address {
 *                 type string;
 *             }
 *             leaf action-set-ipv4-tos {
 *                 type int32;
 *             }
 *             leaf action-set-tcp-src-port {
 *                 type int32;
 *             }
 *             leaf action-set-tcp-dst-port {
 *                 type int32;
 *             }
 *             leaf action-set-ipv4-ttl {
 *                 type uint8;
 *             }
 *             leaf action-set-port-queue {
 *                 type int32;
 *             }
 *             uses flow-rule-specs;
 *         }
 *     }
 * }
 * rpc create-dst-only-tunnel {
 *     input {
 *         leaf src-ip-address {
 *             type string;
 *         }
 *         leaf current-dst-ip-address {
 *             type string;
 *         }
 *         leaf new-dst-ip-address {
 *             type string;
 *         }
 *         leaf-list switches-in-path {
 *             type int32;
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
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc redirect {
 *     input {
 *         leaf src-ip-address {
 *             type string;
 *         }
 *         leaf dst-ip-address {
 *             type string;
 *         }
 *         leaf-list switches-in-path {
 *             type int32;
 *         }
 *         leaf inspection-switch-id {
 *             type int32;
 *         }
 *         leaf inspection-switch-port-id {
 *             type string;
 *         }
 *         leaf type-of-traffic {
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
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc re-route {
 *     input {
 *         leaf src-ip-address {
 *             type string;
 *         }
 *         leaf dst-ip-address {
 *             type string;
 *         }
 *         leaf-list switches-in-old-path {
 *             type int32;
 *         }
 *         leaf-list switches-in-new-path {
 *             type int32;
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
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc remove-a-flow-rule-from-switch {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *         leaf flow-key {
 *             type string;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc migrate-network-path {
 *     input {
 *         leaf old-src-ip-address {
 *             type string;
 *         }
 *         leaf new-src-ip-address {
 *             type string;
 *         }
 *         leaf old-dst-ip-address {
 *             type string;
 *         }
 *         leaf new-dst-ip-address {
 *             type string;
 *         }
 *         leaf-list switches-in-old-path {
 *             type int32;
 *         }
 *         leaf-list switches-in-new-path {
 *             type int32;
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
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc subscribe-for-stats-from-switch {
 *     input {
 *         leaf switch-id {
 *             type int32;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc create-src-only-tunnel {
 *     input {
 *         leaf current-src-ip-address {
 *             type string;
 *         }
 *         leaf new-src-ip-address {
 *             type string;
 *         }
 *         leaf dst-ip-address {
 *             type string;
 *         }
 *         leaf-list switches-in-path {
 *             type int32;
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
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc get-all-hosts {
 *     output {
 *         list hosts-info {
 *             key "id"
 *             leaf id {
 *                 type uint32;
 *             }
 *             leaf host-mac-address {
 *                 type mac-address;
 *             }
 *             leaf host-ip-address {
 *                 type local-ipv4-prefix;
 *             }
 *             leaf host-last-seen {
 *                 type string;
 *             }
 *             leaf host-first-seen {
 *                 type string;
 *             }
 *             leaf node-connected-to {
 *                 type leafref;
 *             }
 *             leaf node-connector-connected-to {
 *                 type leafref;
 *             }
 *             uses host-info;
 *         }
 *     }
 * }
 * </pre>
 *
 */
public interface ActivesdnService
    extends
    RpcService
{




    Future<RpcResult<RemoveAllFlowsFromASwitchOutput>> removeAllFlowsFromASwitch(RemoveAllFlowsFromASwitchInput input);
    
    Future<RpcResult<SendPacketOutOutput>> sendPacketOut(SendPacketOutInput input);
    
    Future<RpcResult<GetFlowStatisticsOutput>> getFlowStatistics(GetFlowStatisticsInput input);
    
    Future<RpcResult<SubscribeForLinkFloodingCheckOutput>> subscribeForLinkFloodingCheck(SubscribeForLinkFloodingCheckInput input);
    
    Future<RpcResult<UnsubscribeForStatsFromSwitchOutput>> unsubscribeForStatsFromSwitch(UnsubscribeForStatsFromSwitchInput input);
    
    Future<RpcResult<CreateSrcDstTunnelOutput>> createSrcDstTunnel(CreateSrcDstTunnelInput input);
    
    Future<RpcResult<InstallFlowRuleOutput>> installFlowRule(InstallFlowRuleInput input);
    
    Future<RpcResult<UnsubscribeForLinkFloodingCheckOutput>> unsubscribeForLinkFloodingCheck(UnsubscribeForLinkFloodingCheckInput input);
    
    Future<RpcResult<GetPortStatisticsOutput>> getPortStatistics(GetPortStatisticsInput input);
    
    Future<RpcResult<SubscribeEventOutput>> subscribeEvent(SubscribeEventInput input);
    
    Future<RpcResult<RemoveEventFromSwitchOutput>> removeEventFromSwitch(RemoveEventFromSwitchInput input);
    
    Future<RpcResult<InstallNetworkPathOutput>> installNetworkPath(InstallNetworkPathInput input);
    
    Future<RpcResult<GetAllFlowRulesFromASwitchOutput>> getAllFlowRulesFromASwitch(GetAllFlowRulesFromASwitchInput input);
    
    Future<RpcResult<CreateDstOnlyTunnelOutput>> createDstOnlyTunnel(CreateDstOnlyTunnelInput input);
    
    Future<RpcResult<RedirectOutput>> redirect(RedirectInput input);
    
    Future<RpcResult<ReRouteOutput>> reRoute(ReRouteInput input);
    
    Future<RpcResult<RemoveAFlowRuleFromSwitchOutput>> removeAFlowRuleFromSwitch(RemoveAFlowRuleFromSwitchInput input);
    
    Future<RpcResult<MigrateNetworkPathOutput>> migrateNetworkPath(MigrateNetworkPathInput input);
    
    Future<RpcResult<SubscribeForStatsFromSwitchOutput>> subscribeForStatsFromSwitch(SubscribeForStatsFromSwitchInput input);
    
    Future<RpcResult<CreateSrcOnlyTunnelOutput>> createSrcOnlyTunnel(CreateSrcOnlyTunnelInput input);
    
    Future<RpcResult<GetAllHostsOutput>> getAllHosts();

}

