package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;


public enum KnownIpProtocols {
    /**
     * IPv6 Hop-by-Hop Option
     *
     */
    Hopopt(0),
    
    /**
     * Internet Control Message Protocol
     *
     */
    Icmp(1),
    
    /**
     * Internet Group Management Protocol
     *
     */
    Igmp(2),
    
    /**
     * Gateway-to-Gateway Protocol
     *
     */
    Ggp(3),
    
    /**
     * IP-in-IP Encapsulation
     *
     */
    IpInIp(4),
    
    /**
     * Internet Stream Protocol
     *
     */
    St(5),
    
    /**
     * Transmisson Control Protocol
     *
     */
    Tcp(6),
    
    /**
     * Core-based trees
     *
     */
    Cbt(7),
    
    /**
     * Exterior Gateway Protocol
     *
     */
    Egp(8),
    
    /**
     * Interior Gateway Protocol
     *
     */
    Igp(9),
    
    /**
     * Network Voice Protocol
     *
     */
    Nvp(11),
    
    /**
     * User Datagram Protocol
     *
     */
    Udp(17),
    
    /**
     * Host Monitoring Protocol
     *
     */
    Hmp(20),
    
    /**
     * Reliable Datagram Protocol
     *
     */
    Rdp(27),
    
    /**
     * Datagram Congestion Control Protocol
     *
     */
    Dccp(33),
    
    /**
     * IPv6 Encapsulation
     *
     */
    Encap(41),
    
    /**
     * IPv6 Routing Header
     *
     */
    Ipv6Route(43),
    
    /**
     * IPv6 Fragment Header
     *
     */
    Ipv6Frag(44),
    
    /**
     * Resource Reservation Protocol
     *
     */
    Rsvp(46),
    
    /**
     * Generic Routing Encapsulation
     *
     */
    Gre(47),
    
    /**
     * Encapsulating Security Payload
     *
     */
    Esp(50),
    
    /**
     * Authentication Header
     *
     */
    Ah(51),
    
    /**
     * IPv6 ICMP
     *
     */
    Ipv6Icmp(58),
    
    /**
     * IPv6 No Next Header
     *
     */
    Ipv6NoNext(59),
    
    /**
     * IPv6 Destination Options
     *
     */
    Ipv6Opts(60),
    
    /**
     * Open Shortest Path First
     *
     */
    Ospf(89),
    
    /**
     * Stream Control Transmission Protocol
     *
     */
    Sctp(132),
    
    /**
     * Fibre Channel
     *
     */
    FibreChannel(133),
    
    /**
     * IPv6 Mobility Header
     *
     */
    Ipv6Mobility(135),
    
    /**
     * Use for experimentation and testing, RFC3692
     *
     */
    Experimentation1(253),
    
    /**
     * Use for experimentation and testing, RFC3692
     *
     */
    Experimentation2(254)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, KnownIpProtocols> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, KnownIpProtocols> b = com.google.common.collect.ImmutableMap.builder();
        for (KnownIpProtocols enumItem : KnownIpProtocols.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private KnownIpProtocols(int value) {
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
     * @return corresponding KnownIpProtocols item
     */
    public static KnownIpProtocols forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
