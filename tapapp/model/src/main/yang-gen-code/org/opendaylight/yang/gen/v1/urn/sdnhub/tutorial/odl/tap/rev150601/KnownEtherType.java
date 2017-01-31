package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;


public enum KnownEtherType {
    /**
     * Internet Protocol version 4 (IPv4)
     *
     */
    Ipv4(2048),
    
    /**
     * Address Resolution Protocol (ARP)
     *
     */
    Arp(2054),
    
    /**
     * Wake-on-LAN[3]
     *
     */
    WakeOnLan(2114),
    
    /**
     * IETF TRILL Protocol
     *
     */
    IetfTrill(8947),
    
    /**
     * DECnet Phase IV
     *
     */
    DecnetPhaseIv(24579),
    
    /**
     * Reverse Address Resolution Protocol
     *
     */
    ReverseArp(32821),
    
    /**
     * AppleTalk (Ethertalk)
     *
     */
    AppleTalk(32923),
    
    /**
     * AppleTalk Address Resolution Protocol (AARP)
     *
     */
    AppleTalkArp(33011),
    
    /**
     * VLAN-tagged frame (IEEE 802.1Q) &amp; Shortest Path Bridging IEEE 802.1aq[4]
     *
     */
    VlanTagged(33024),
    
    /**
     * IPX
     *
     */
    Ipx(33079),
    
    /**
     * IPX
     *
     */
    Ipx2(33080),
    
    /**
     * QNX Qnet
     *
     */
    QnxQnet(33284),
    
    /**
     * Internet Protocol Version 6 (IPv6)
     *
     */
    Ipv6(34525),
    
    /**
     * Ethernet flow control
     *
     */
    EthernetFlowControl(34824),
    
    /**
     * Slow Protocols (IEEE 802.3)
     *
     */
    SlowProtocols(34825),
    
    /**
     * CobraNet
     *
     */
    CobraNet(34841),
    
    /**
     * MPLS unicast
     *
     */
    MplsUnicast(34887),
    
    /**
     * MPLS multicast
     *
     */
    MplsMulticast(34888),
    
    /**
     * PPPoE Discovery Stage
     *
     */
    PPPOverEthernetDiscovery(34915),
    
    /**
     * PPPoE Session Stage
     *
     */
    PPPOverEthernetSession(34916),
    
    /**
     * Jumbo Frames[2]
     *
     */
    Jumbo(34928),
    
    /**
     * HomePlug 1.0 MME
     *
     */
    Homeplug(34939),
    
    /**
     * EAP over LAN (IEEE 802.1X)
     *
     */
    EapOverLan(34958),
    
    /**
     * PROFINET Protocol
     *
     */
    Profinet(34962),
    
    /**
     * HyperSCSI (SCSI over Ethernet)
     *
     */
    HyperScsi(34970),
    
    /**
     * ATA over Ethernet
     *
     */
    AtaOverEthernet(34978),
    
    /**
     * EtherCAT Protocol
     *
     */
    Ethercat(34980),
    
    /**
     * Provider Bridging (IEEE 802.1ad) &amp; Shortest Path Bridging IEEE 802.1aq[5]
     *
     */
    ProviderBridging(34984),
    
    /**
     * Ethernet Powerlink[citation needed]
     *
     */
    EthernetPowerlink(34987),
    
    /**
     * Link Layer Discovery Protocol (LLDP)
     *
     */
    Lldp(35020),
    
    /**
     * SERCOS III
     *
     */
    Sercos3(35021),
    
    /**
     * HomePlug AV MME[citation needed]
     *
     */
    HomeplugAvMme(35041),
    
    /**
     * Media Redundancy Protocol (IEC62439-2)
     *
     */
    MediaRedudancyProtocol(35043),
    
    /**
     * MAC security (IEEE 802.1AE)
     *
     */
    MacSecurity(35045),
    
    /**
     * Precision Time Protocol (IEEE 1588)
     *
     */
    PrecisionTimeProtocol(35063),
    
    /**
     * IEEE 802.1ag Connectivity Fault Management (CFM) Protocol / ITU-T Recommendation
     * Y.1731 (OAM)
     *
     */
    ConnectivityFaultManagement(35074),
    
    /**
     * Fibre Channel over Ethernet (FCoE)
     *
     */
    FibreChannelOverEthernet(35078),
    
    /**
     * FCoE Initialization Protocol
     *
     */
    FibreChannelOverEthernetInitialization(35092),
    
    /**
     * RDMA over Converged Ethernet (RoCE)
     *
     */
    RmdaOverConvergedEthernet(35093),
    
    /**
     * High-availability Seamless Redundancy (HSR)
     *
     */
    HighAvailabilitySeamlessRedudancy(35119),
    
    /**
     * Ethernet Configuration Testing Protocol[6]
     *
     */
    EthernetConfigurationTestingProtocol(36864),
    
    /**
     * Q-in-Q
     *
     */
    QInQ(37120),
    
    /**
     * Veritas Low Latency Transport (LLT)[7] for Veritas Cluster Server
     *
     */
    VeritasLowLatency(51966)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, KnownEtherType> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, KnownEtherType> b = com.google.common.collect.ImmutableMap.builder();
        for (KnownEtherType enumItem : KnownEtherType.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private KnownEtherType(int value) {
        this.value = value;
    }

    /**
     * @return integer value
     */
    public int getIntValue() {
        return value;
    }

    /**
     * @param valueArg
     * @return corresponding KnownEtherType item
     */
    public static KnownEtherType forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
