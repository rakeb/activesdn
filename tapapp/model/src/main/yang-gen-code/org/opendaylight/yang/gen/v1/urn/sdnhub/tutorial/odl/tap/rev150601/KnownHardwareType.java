package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;


public enum KnownHardwareType {
    Reserved(0),
    
    Ethernet(1)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, KnownHardwareType> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, KnownHardwareType> b = com.google.common.collect.ImmutableMap.builder();
        for (KnownHardwareType enumItem : KnownHardwareType.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private KnownHardwareType(int value) {
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
     * @return corresponding KnownHardwareType item
     */
    public static KnownHardwareType forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
