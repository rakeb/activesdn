package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;


public enum MeterFlags {
    MeterKbps(0),
    
    MeterPktps(1),
    
    MeterBurst(2),
    
    MeterStats(3)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, MeterFlags> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, MeterFlags> b = com.google.common.collect.ImmutableMap.builder();
        for (MeterFlags enumItem : MeterFlags.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private MeterFlags(int value) {
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
     * @return corresponding MeterFlags item
     */
    public static MeterFlags forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
