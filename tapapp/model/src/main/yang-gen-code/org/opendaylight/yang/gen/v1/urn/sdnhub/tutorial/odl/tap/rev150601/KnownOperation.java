package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;


public enum KnownOperation {
    Reserved(0),
    
    Request(1),
    
    Reply(2),
    
    RequestReverse(3),
    
    ReplyReverse(4)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, KnownOperation> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, KnownOperation> b = com.google.common.collect.ImmutableMap.builder();
        for (KnownOperation enumItem : KnownOperation.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private KnownOperation(int value) {
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
     * @return corresponding KnownOperation item
     */
    public static KnownOperation forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
