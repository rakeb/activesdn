package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.binding.RpcService;
import java.util.concurrent.Future;


/**
 * Interface for implementing the following YANG RPCs defined in module <b>tap</b>
 * <br>(Source path: <i>META-INF/yang/tap.yang</i>):
 * <pre>
 * rpc add-tap {
 *     input {
 *         list tap1 {
 *             key "id"
 *             leaf id {
 *                 type string;
 *             }
 *             leaf count {
 *                 type uint32;
 *             }
 *             leaf duration {
 *                 type uint32;
 *             }
 *             leaf node {
 *                 type leafref;
 *             }
 *             leaf inPortConnector {
 *                 type leafref;
 *             }
 *             leaf source-mac-address {
 *                 type mac-address;
 *             }
 *             leaf dst-mac-address {
 *                 type mac-address;
 *             }
 *             leaf source-ip-address {
 *                 type local-ipv4-prefix;
 *             }
 *             leaf dst-ip-address {
 *                 type local-ipv4-prefix;
 *             }
 *             leaf traffic-match {
 *                 type traffic-type;
 *             }
 *             choice tap-actions {
 *                 case block-case {
 *                     container block-action {
 *                     }
 *                 }
 *                 case drop-and-notify-case {
 *                     container drop-and-notify {
 *                         leaf hold-notification {
 *                             type int32;
 *                         }
 *                     }
 *                 }
 *                 case notify-case {
 *                     container notify-action {
 *                     }
 *                 }
 *                 case set-rate-limit-event-case {
 *                     container set-rate-limit-action {
 *                         leaf meter-type {
 *                             type meter-flags;
 *                         }
 *                         leaf band-rate {
 *                             type uint32;
 *                         }
 *                         leaf band-burst-size {
 *                             type band-burst-size;
 *                         }
 *                         leaf drop-rate {
 *                             type drop-rate;
 *                         }
 *                         leaf drop-burst-size {
 *                             type drop-burst-size;
 *                         }
 *                         leaf egress-port {
 *                             type leafref;
 *                         }
 *                     }
 *                 }
 *             }
 *             uses event-actions;
 *             uses tap-grouping;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *         leaf tap-id {
 *             type string;
 *         }
 *     }
 * }
 * rpc getAllLinksOfSwitch {
 *     input {
 *         leaf node {
 *             type leafref;
 *         }
 *     }
 *     
 *     output {
 *         leaf-list links {
 *             type leafref;
 *         }
 *     }
 * }
 * rpc mutate-ip {
 *     input {
 *         leaf src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf-list path-nodes {
 *             type leafref;
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
 *         choice mutation-end {
 *             case both-case {
 *                 container both {
 *                     leaf new-src-ip-address {
 *                         type ipv4-prefix;
 *                     }
 *                     leaf new-dst-ip-address {
 *                         type ipv4-prefix;
 *                     }
 *                 }
 *             }
 *             case dst-only-case {
 *                 container dst-only {
 *                     leaf new-dst-ip-address {
 *                         type ipv4-prefix;
 *                     }
 *                 }
 *             }
 *             case source-only-case {
 *                 container source-only {
 *                     leaf new-src-ip-address {
 *                         type ipv4-prefix;
 *                     }
 *                 }
 *             }
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc getNetworkTopology {
 *     output {
 *         list network-links {
 *             key "id"
 *             leaf id {
 *                 type string;
 *             }
 *             leaf src-node {
 *                 type leafref;
 *             }
 *             leaf src-node-connector {
 *                 type leafref;
 *             }
 *             leaf dst-node {
 *                 type leafref;
 *             }
 *             leaf dst-node-connector {
 *                 type leafref;
 *             }
 *             uses network-link;
 *         }
 *     }
 * }
 * rpc install-path-bw-nodes {
 *     input {
 *         leaf src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf-list path-nodes {
 *             type leafref;
 *         }
 *         leaf flow-priority {
 *             type int32;
 *         }
 *         leaf idle-timeout {
 *             type int32;
 *         }
 *         leaf hard-timeout {
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
 * rpc install-flow {
 *     input {
 *         leaf node {
 *             type leafref;
 *         }
 *         leaf flow-id {
 *             type string;
 *         }
 *         container new-flow {
 *             leaf in-port {
 *                 type leafref;
 *             }
 *             leaf src-mac-address {
 *                 type mac-address;
 *             }
 *             leaf dst-mac-address {
 *                 type mac-address;
 *             }
 *             leaf src-ip-address {
 *                 type ipv4-prefix;
 *             }
 *             leaf dst-ip-address {
 *                 type ipv4-prefix;
 *             }
 *             leaf traffic-match {
 *                 type traffic-type;
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
 *             container custom-info {
 *                 leaf dl-type {
 *                     type dl-type;
 *                 }
 *                 leaf nw-proto {
 *                     type nw-proto;
 *                 }
 *                 leaf tp-dst {
 *                     type tp-dst;
 *                 }
 *             }
 *             uses match;
 *         }
 *         list associated-actions {
 *             key "id"
 *             leaf id {
 *                 type uint32;
 *             }
 *             choice flow-actions {
 *                 case drop-packet-case {
 *                     container drop-packet {
 *                     }
 *                 }
 *                 case forward-to-controller-case {
 *                     container forward-to-controller {
 *                     }
 *                 }
 *                 case forward-to-flood-case {
 *                     container forward-to-flood {
 *                     }
 *                 }
 *                 case forward-to-port-case {
 *                     container forward-to-port {
 *                         leaf output-node-connector {
 *                             type leafref;
 *                         }
 *                     }
 *                 }
 *                 case set-dst-ipv4-address-case {
 *                     container set-dst-ipv4-address {
 *                         leaf value {
 *                             type ipv4-prefix;
 *                         }
 *                     }
 *                 }
 *                 case set-dst-mac-address-case {
 *                     container set-dst-mac-address {
 *                         leaf value {
 *                             type mac-address;
 *                         }
 *                     }
 *                 }
 *                 case set-ipv4-tos-case {
 *                     container set-ipv4-tos {
 *                         leaf value {
 *                             type int32;
 *                         }
 *                     }
 *                 }
 *                 case set-ipv4-ttl-case {
 *                     container set-ipv4-ttl {
 *                         leaf ttl-value {
 *                             type uint8;
 *                         }
 *                     }
 *                 }
 *                 case set-port-queue-case {
 *                     container set-queue {
 *                         leaf queue {
 *                             type string;
 *                         }
 *                         leaf queue-id {
 *                             type uint32;
 *                         }
 *                         leaf egress-port {
 *                             type leafref;
 *                         }
 *                     }
 *                 }
 *                 case set-rate-limit-case {
 *                     container set-rate-limit {
 *                         leaf meter-type {
 *                             type meter-flags;
 *                         }
 *                         leaf band-rate {
 *                             type uint32;
 *                         }
 *                         leaf band-burst-size {
 *                             type band-burst-size;
 *                         }
 *                         leaf drop-rate {
 *                             type drop-rate;
 *                         }
 *                         leaf drop-burst-size {
 *                             type drop-burst-size;
 *                         }
 *                         leaf egress-port {
 *                             type leafref;
 *                         }
 *                     }
 *                 }
 *                 case set-source-ipv4-address-case {
 *                     container set-source-ipv4-address {
 *                         leaf value {
 *                             type ipv4-prefix;
 *                         }
 *                     }
 *                 }
 *                 case set-src-mac-address-case {
 *                     container set-src-mac-address {
 *                         leaf value {
 *                             type mac-address;
 *                         }
 *                     }
 *                 }
 *                 case set-tcp-dst-port-case {
 *                     container set-tcp-dst-port {
 *                         leaf port-number {
 *                             type int32;
 *                         }
 *                     }
 *                 }
 *                 case set-tcp-src-port-case {
 *                     container set-tcp-src-port {
 *                         leaf port-number {
 *                             type int32;
 *                         }
 *                     }
 *                 }
 *             }
 *             uses flow-actions;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *         leaf flow-id {
 *             type string;
 *         }
 *     }
 * }
 * rpc remove-a-tap-from-switch {
 *     input {
 *         leaf node {
 *             type leafref;
 *         }
 *         leaf tap-id {
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
 * rpc install-path {
 *     input {
 *         leaf src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf-list path-nodes {
 *             type leafref;
 *         }
 *         leaf traffic-match {
 *             type traffic-type;
 *         }
 *         leaf flow-priority {
 *             type int32;
 *         }
 *         leaf idle-timeout {
 *             type int32;
 *         }
 *         leaf hard-timeout {
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
 * rpc move-path {
 *     input {
 *         leaf src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf-list old-path-nodes {
 *             type leafref;
 *         }
 *         leaf-list new-path-nodes {
 *             type leafref;
 *         }
 *         leaf flow-priority {
 *             type int32;
 *         }
 *         leaf idle-timeout {
 *             type int32;
 *         }
 *         leaf hard-timeout {
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
 * rpc checking {
 *     input {
 *         leaf note {
 *             type string;
 *         }
 *     }
 *     
 *     output {
 *         leaf msg {
 *             type string;
 *         }
 *     }
 * }
 * rpc ip-mutate-engine {
 *     input {
 *         leaf old-src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf new-src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf old-dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf new-dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf-list path-nodes {
 *             type leafref;
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
 * rpc getAllSwitches {
 *     output {
 *         leaf-list nodes {
 *             type leafref;
 *         }
 *     }
 * }
 * rpc removeAllTapsFromSwitch {
 *     input {
 *         leaf node {
 *             type leafref;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc install-inspection-path {
 *     input {
 *         leaf src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf-list path-nodes {
 *             type leafref;
 *         }
 *         leaf inspection-switch-id {
 *             type leafref;
 *         }
 *         leaf inpsection-switch-port {
 *             type leafref;
 *         }
 *         leaf traffic-match {
 *             type traffic-type;
 *         }
 *         leaf flow-priority {
 *             type int32;
 *         }
 *         leaf idle-timeout {
 *             type int32;
 *         }
 *         leaf hard-timeout {
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
 * rpc migrate-path {
 *     "Migrate old path to a new path using same source but different destination";
 *     input {
 *         leaf old-src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf new-src-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf old-dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf new-dst-ip-address {
 *             type ipv4-prefix;
 *         }
 *         leaf-list old-path-nodes {
 *             type leafref;
 *         }
 *         leaf-list new-path-nodes {
 *             type leafref;
 *         }
 *         leaf flow-priority {
 *             type int32;
 *         }
 *         leaf idle-timeout {
 *             type int32;
 *         }
 *         leaf hard-timeout {
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
 * rpc removeFlowsFromSwitch {
 *     input {
 *         leaf node {
 *             type leafref;
 *         }
 *     }
 *     
 *     output {
 *         leaf status {
 *             type string;
 *         }
 *     }
 * }
 * rpc remove-a-flow-from-switch {
 *     input {
 *         leaf node-id {
 *             type leafref;
 *         }
 *         leaf table-id {
 *             type uint8;
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
 * rpc getAllHostsOnSwitch {
 *     input {
 *         leaf node {
 *             type leafref;
 *         }
 *     }
 *     
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
public interface TapService
    extends
    RpcService
{




    Future<RpcResult<AddTapOutput>> addTap(AddTapInput input);
    
    Future<RpcResult<GetAllLinksOfSwitchOutput>> getAllLinksOfSwitch(GetAllLinksOfSwitchInput input);
    
    Future<RpcResult<MutateIpOutput>> mutateIp(MutateIpInput input);
    
    Future<RpcResult<GetNetworkTopologyOutput>> getNetworkTopology();
    
    Future<RpcResult<InstallPathBwNodesOutput>> installPathBwNodes(InstallPathBwNodesInput input);
    
    Future<RpcResult<InstallFlowOutput>> installFlow(InstallFlowInput input);
    
    Future<RpcResult<RemoveATapFromSwitchOutput>> removeATapFromSwitch(RemoveATapFromSwitchInput input);
    
    Future<RpcResult<InstallPathOutput>> installPath(InstallPathInput input);
    
    Future<RpcResult<MovePathOutput>> movePath(MovePathInput input);
    
    Future<RpcResult<CheckingOutput>> checking(CheckingInput input);
    
    Future<RpcResult<IpMutateEngineOutput>> ipMutateEngine(IpMutateEngineInput input);
    
    Future<RpcResult<GetAllSwitchesOutput>> getAllSwitches();
    
    Future<RpcResult<RemoveAllTapsFromSwitchOutput>> removeAllTapsFromSwitch(RemoveAllTapsFromSwitchInput input);
    
    Future<RpcResult<InstallInspectionPathOutput>> installInspectionPath(InstallInspectionPathInput input);
    
    /**
     * Migrate old path to a new path using same source but different destination
     *
     */
    Future<RpcResult<MigratePathOutput>> migratePath(MigratePathInput input);
    
    Future<RpcResult<RemoveFlowsFromSwitchOutput>> removeFlowsFromSwitch(RemoveFlowsFromSwitchInput input);
    
    Future<RpcResult<RemoveAFlowFromSwitchOutput>> removeAFlowFromSwitch(RemoveAFlowFromSwitchInput input);
    
    Future<RpcResult<GetAllHostsOnSwitchOutput>> getAllHostsOnSwitch(GetAllHostsOnSwitchInput input);

}

