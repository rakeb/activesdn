package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket
 *
 */
public class ArpPacketBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket> {

    private java.lang.String _destinationHardwareAddress;
    private java.lang.String _destinationProtocolAddress;
    private java.lang.Short _hardwareLength;
    private KnownHardwareType _hardwareType;
    private KnownOperation _operation;
    private java.lang.Integer _payloadLength;
    private java.lang.Integer _payloadOffset;
    private java.lang.Short _protocolLength;
    private KnownEtherType _protocolType;
    private java.lang.String _sourceHardwareAddress;
    private java.lang.String _sourceProtocolAddress;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>> augmentation = Collections.emptyMap();

    public ArpPacketBuilder() {
    }
    public ArpPacketBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields arg) {
        this._hardwareType = arg.getHardwareType();
        this._protocolType = arg.getProtocolType();
        this._hardwareLength = arg.getHardwareLength();
        this._protocolLength = arg.getProtocolLength();
        this._operation = arg.getOperation();
        this._sourceHardwareAddress = arg.getSourceHardwareAddress();
        this._sourceProtocolAddress = arg.getSourceProtocolAddress();
        this._destinationHardwareAddress = arg.getDestinationHardwareAddress();
        this._destinationProtocolAddress = arg.getDestinationProtocolAddress();
        this._payloadOffset = arg.getPayloadOffset();
        this._payloadLength = arg.getPayloadLength();
    }
    public ArpPacketBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields arg) {
        this._payloadOffset = arg.getPayloadOffset();
        this._payloadLength = arg.getPayloadLength();
    }

    public ArpPacketBuilder(ArpPacket base) {
        this._destinationHardwareAddress = base.getDestinationHardwareAddress();
        this._destinationProtocolAddress = base.getDestinationProtocolAddress();
        this._hardwareLength = base.getHardwareLength();
        this._hardwareType = base.getHardwareType();
        this._operation = base.getOperation();
        this._payloadLength = base.getPayloadLength();
        this._payloadOffset = base.getPayloadOffset();
        this._protocolLength = base.getProtocolLength();
        this._protocolType = base.getProtocolType();
        this._sourceHardwareAddress = base.getSourceHardwareAddress();
        this._sourceProtocolAddress = base.getSourceProtocolAddress();
        if (base instanceof ArpPacketImpl) {
            ArpPacketImpl impl = (ArpPacketImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields</li>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields) {
            this._hardwareType = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getHardwareType();
            this._protocolType = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getProtocolType();
            this._hardwareLength = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getHardwareLength();
            this._protocolLength = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getProtocolLength();
            this._operation = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getOperation();
            this._sourceHardwareAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getSourceHardwareAddress();
            this._sourceProtocolAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getSourceProtocolAddress();
            this._destinationHardwareAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getDestinationHardwareAddress();
            this._destinationProtocolAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields)arg).getDestinationProtocolAddress();
            isValidArg = true;
        }
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields) {
            this._payloadOffset = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields)arg).getPayloadOffset();
            this._payloadLength = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields)arg).getPayloadLength();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacketFields, org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.String getDestinationHardwareAddress() {
        return _destinationHardwareAddress;
    }
    
    public java.lang.String getDestinationProtocolAddress() {
        return _destinationProtocolAddress;
    }
    
    public java.lang.Short getHardwareLength() {
        return _hardwareLength;
    }
    
    public KnownHardwareType getHardwareType() {
        return _hardwareType;
    }
    
    public KnownOperation getOperation() {
        return _operation;
    }
    
    public java.lang.Integer getPayloadLength() {
        return _payloadLength;
    }
    
    public java.lang.Integer getPayloadOffset() {
        return _payloadOffset;
    }
    
    public java.lang.Short getProtocolLength() {
        return _protocolLength;
    }
    
    public KnownEtherType getProtocolType() {
        return _protocolType;
    }
    
    public java.lang.String getSourceHardwareAddress() {
        return _sourceHardwareAddress;
    }
    
    public java.lang.String getSourceProtocolAddress() {
        return _sourceProtocolAddress;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public ArpPacketBuilder setDestinationHardwareAddress(final java.lang.String value) {
        this._destinationHardwareAddress = value;
        return this;
    }
    
     
    public ArpPacketBuilder setDestinationProtocolAddress(final java.lang.String value) {
        this._destinationProtocolAddress = value;
        return this;
    }
    
     
     private static void checkHardwareLengthRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public ArpPacketBuilder setHardwareLength(final java.lang.Short value) {
    if (value != null) {
        checkHardwareLengthRange(value);
    }
        this._hardwareLength = value;
        return this;
    }
    
     
    public ArpPacketBuilder setHardwareType(final KnownHardwareType value) {
        this._hardwareType = value;
        return this;
    }
    
     
    public ArpPacketBuilder setOperation(final KnownOperation value) {
        this._operation = value;
        return this;
    }
    
     
    public ArpPacketBuilder setPayloadLength(final java.lang.Integer value) {
        this._payloadLength = value;
        return this;
    }
    
     
    public ArpPacketBuilder setPayloadOffset(final java.lang.Integer value) {
        this._payloadOffset = value;
        return this;
    }
    
     
     private static void checkProtocolLengthRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public ArpPacketBuilder setProtocolLength(final java.lang.Short value) {
    if (value != null) {
        checkProtocolLengthRange(value);
    }
        this._protocolLength = value;
        return this;
    }
    
     
    public ArpPacketBuilder setProtocolType(final KnownEtherType value) {
        this._protocolType = value;
        return this;
    }
    
     
    public ArpPacketBuilder setSourceHardwareAddress(final java.lang.String value) {
        this._sourceHardwareAddress = value;
        return this;
    }
    
     
    public ArpPacketBuilder setSourceProtocolAddress(final java.lang.String value) {
        this._sourceProtocolAddress = value;
        return this;
    }
    
    public ArpPacketBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public ArpPacketBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public ArpPacket build() {
        return new ArpPacketImpl(this);
    }

    private static final class ArpPacketImpl implements ArpPacket {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket.class;
        }

        private final java.lang.String _destinationHardwareAddress;
        private final java.lang.String _destinationProtocolAddress;
        private final java.lang.Short _hardwareLength;
        private final KnownHardwareType _hardwareType;
        private final KnownOperation _operation;
        private final java.lang.Integer _payloadLength;
        private final java.lang.Integer _payloadOffset;
        private final java.lang.Short _protocolLength;
        private final KnownEtherType _protocolType;
        private final java.lang.String _sourceHardwareAddress;
        private final java.lang.String _sourceProtocolAddress;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>> augmentation = Collections.emptyMap();

        private ArpPacketImpl(ArpPacketBuilder base) {
            this._destinationHardwareAddress = base.getDestinationHardwareAddress();
            this._destinationProtocolAddress = base.getDestinationProtocolAddress();
            this._hardwareLength = base.getHardwareLength();
            this._hardwareType = base.getHardwareType();
            this._operation = base.getOperation();
            this._payloadLength = base.getPayloadLength();
            this._payloadOffset = base.getPayloadOffset();
            this._protocolLength = base.getProtocolLength();
            this._protocolType = base.getProtocolType();
            this._sourceHardwareAddress = base.getSourceHardwareAddress();
            this._sourceProtocolAddress = base.getSourceProtocolAddress();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getDestinationHardwareAddress() {
            return _destinationHardwareAddress;
        }
        
        @Override
        public java.lang.String getDestinationProtocolAddress() {
            return _destinationProtocolAddress;
        }
        
        @Override
        public java.lang.Short getHardwareLength() {
            return _hardwareLength;
        }
        
        @Override
        public KnownHardwareType getHardwareType() {
            return _hardwareType;
        }
        
        @Override
        public KnownOperation getOperation() {
            return _operation;
        }
        
        @Override
        public java.lang.Integer getPayloadLength() {
            return _payloadLength;
        }
        
        @Override
        public java.lang.Integer getPayloadOffset() {
            return _payloadOffset;
        }
        
        @Override
        public java.lang.Short getProtocolLength() {
            return _protocolLength;
        }
        
        @Override
        public KnownEtherType getProtocolType() {
            return _protocolType;
        }
        
        @Override
        public java.lang.String getSourceHardwareAddress() {
            return _sourceHardwareAddress;
        }
        
        @Override
        public java.lang.String getSourceProtocolAddress() {
            return _sourceProtocolAddress;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        private int hash = 0;
        private volatile boolean hashValid = false;
        
        @Override
        public int hashCode() {
            if (hashValid) {
                return hash;
            }
        
            final int prime = 31;
            int result = 1;
            result = prime * result + Objects.hashCode(_destinationHardwareAddress);
            result = prime * result + Objects.hashCode(_destinationProtocolAddress);
            result = prime * result + Objects.hashCode(_hardwareLength);
            result = prime * result + Objects.hashCode(_hardwareType);
            result = prime * result + Objects.hashCode(_operation);
            result = prime * result + Objects.hashCode(_payloadLength);
            result = prime * result + Objects.hashCode(_payloadOffset);
            result = prime * result + Objects.hashCode(_protocolLength);
            result = prime * result + Objects.hashCode(_protocolType);
            result = prime * result + Objects.hashCode(_sourceHardwareAddress);
            result = prime * result + Objects.hashCode(_sourceProtocolAddress);
            result = prime * result + Objects.hashCode(augmentation);
        
            hash = result;
            hashValid = true;
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket)obj;
            if (!Objects.equals(_destinationHardwareAddress, other.getDestinationHardwareAddress())) {
                return false;
            }
            if (!Objects.equals(_destinationProtocolAddress, other.getDestinationProtocolAddress())) {
                return false;
            }
            if (!Objects.equals(_hardwareLength, other.getHardwareLength())) {
                return false;
            }
            if (!Objects.equals(_hardwareType, other.getHardwareType())) {
                return false;
            }
            if (!Objects.equals(_operation, other.getOperation())) {
                return false;
            }
            if (!Objects.equals(_payloadLength, other.getPayloadLength())) {
                return false;
            }
            if (!Objects.equals(_payloadOffset, other.getPayloadOffset())) {
                return false;
            }
            if (!Objects.equals(_protocolLength, other.getProtocolLength())) {
                return false;
            }
            if (!Objects.equals(_protocolType, other.getProtocolType())) {
                return false;
            }
            if (!Objects.equals(_sourceHardwareAddress, other.getSourceHardwareAddress())) {
                return false;
            }
            if (!Objects.equals(_sourceProtocolAddress, other.getSourceProtocolAddress())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                ArpPacketImpl otherImpl = (ArpPacketImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.ArpPacket>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("ArpPacket [");
            boolean first = true;
        
            if (_destinationHardwareAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_destinationHardwareAddress=");
                builder.append(_destinationHardwareAddress);
             }
            if (_destinationProtocolAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_destinationProtocolAddress=");
                builder.append(_destinationProtocolAddress);
             }
            if (_hardwareLength != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hardwareLength=");
                builder.append(_hardwareLength);
             }
            if (_hardwareType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hardwareType=");
                builder.append(_hardwareType);
             }
            if (_operation != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_operation=");
                builder.append(_operation);
             }
            if (_payloadLength != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_payloadLength=");
                builder.append(_payloadLength);
             }
            if (_payloadOffset != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_payloadOffset=");
                builder.append(_payloadOffset);
             }
            if (_protocolLength != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_protocolLength=");
                builder.append(_protocolLength);
             }
            if (_protocolType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_protocolType=");
                builder.append(_protocolType);
             }
            if (_sourceHardwareAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sourceHardwareAddress=");
                builder.append(_sourceHardwareAddress);
             }
            if (_sourceProtocolAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sourceProtocolAddress=");
                builder.append(_sourceProtocolAddress);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
