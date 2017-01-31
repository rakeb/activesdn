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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader
 *
 */
public class IcmpPacketHeaderBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader> {

    private java.lang.Short _code;
    private java.lang.Integer _crc;
    private java.lang.Integer _identifier;
    private java.lang.Integer _payloadLength;
    private java.lang.Integer _payloadOffset;
    private java.lang.Integer _sequenceNumber;
    private java.lang.Short _type;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>> augmentation = Collections.emptyMap();

    public IcmpPacketHeaderBuilder() {
    }
    public IcmpPacketHeaderBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields arg) {
        this._type = arg.getType();
        this._code = arg.getCode();
        this._crc = arg.getCrc();
        this._identifier = arg.getIdentifier();
        this._sequenceNumber = arg.getSequenceNumber();
        this._payloadOffset = arg.getPayloadOffset();
        this._payloadLength = arg.getPayloadLength();
    }
    public IcmpPacketHeaderBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields arg) {
        this._payloadOffset = arg.getPayloadOffset();
        this._payloadLength = arg.getPayloadLength();
    }

    public IcmpPacketHeaderBuilder(IcmpPacketHeader base) {
        this._code = base.getCode();
        this._crc = base.getCrc();
        this._identifier = base.getIdentifier();
        this._payloadLength = base.getPayloadLength();
        this._payloadOffset = base.getPayloadOffset();
        this._sequenceNumber = base.getSequenceNumber();
        this._type = base.getType();
        if (base instanceof IcmpPacketHeaderImpl) {
            IcmpPacketHeaderImpl impl = (IcmpPacketHeaderImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields</li>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields) {
            this._type = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields)arg).getType();
            this._code = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields)arg).getCode();
            this._crc = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields)arg).getCrc();
            this._identifier = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields)arg).getIdentifier();
            this._sequenceNumber = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields)arg).getSequenceNumber();
            isValidArg = true;
        }
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields) {
            this._payloadOffset = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields)arg).getPayloadOffset();
            this._payloadLength = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields)arg).getPayloadLength();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketFields, org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.PacketFields] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.Short getCode() {
        return _code;
    }
    
    public java.lang.Integer getCrc() {
        return _crc;
    }
    
    public java.lang.Integer getIdentifier() {
        return _identifier;
    }
    
    public java.lang.Integer getPayloadLength() {
        return _payloadLength;
    }
    
    public java.lang.Integer getPayloadOffset() {
        return _payloadOffset;
    }
    
    public java.lang.Integer getSequenceNumber() {
        return _sequenceNumber;
    }
    
    public java.lang.Short getType() {
        return _type;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkCodeRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public IcmpPacketHeaderBuilder setCode(final java.lang.Short value) {
    if (value != null) {
        checkCodeRange(value);
    }
        this._code = value;
        return this;
    }
    
     
     private static void checkCrcRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketHeaderBuilder setCrc(final java.lang.Integer value) {
    if (value != null) {
        checkCrcRange(value);
    }
        this._crc = value;
        return this;
    }
    
     
     private static void checkIdentifierRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketHeaderBuilder setIdentifier(final java.lang.Integer value) {
    if (value != null) {
        checkIdentifierRange(value);
    }
        this._identifier = value;
        return this;
    }
    
     
    public IcmpPacketHeaderBuilder setPayloadLength(final java.lang.Integer value) {
        this._payloadLength = value;
        return this;
    }
    
     
    public IcmpPacketHeaderBuilder setPayloadOffset(final java.lang.Integer value) {
        this._payloadOffset = value;
        return this;
    }
    
     
     private static void checkSequenceNumberRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketHeaderBuilder setSequenceNumber(final java.lang.Integer value) {
    if (value != null) {
        checkSequenceNumberRange(value);
    }
        this._sequenceNumber = value;
        return this;
    }
    
     
     private static void checkTypeRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public IcmpPacketHeaderBuilder setType(final java.lang.Short value) {
    if (value != null) {
        checkTypeRange(value);
    }
        this._type = value;
        return this;
    }
    
    public IcmpPacketHeaderBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public IcmpPacketHeaderBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public IcmpPacketHeader build() {
        return new IcmpPacketHeaderImpl(this);
    }

    private static final class IcmpPacketHeaderImpl implements IcmpPacketHeader {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader.class;
        }

        private final java.lang.Short _code;
        private final java.lang.Integer _crc;
        private final java.lang.Integer _identifier;
        private final java.lang.Integer _payloadLength;
        private final java.lang.Integer _payloadOffset;
        private final java.lang.Integer _sequenceNumber;
        private final java.lang.Short _type;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>> augmentation = Collections.emptyMap();

        private IcmpPacketHeaderImpl(IcmpPacketHeaderBuilder base) {
            this._code = base.getCode();
            this._crc = base.getCrc();
            this._identifier = base.getIdentifier();
            this._payloadLength = base.getPayloadLength();
            this._payloadOffset = base.getPayloadOffset();
            this._sequenceNumber = base.getSequenceNumber();
            this._type = base.getType();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Short getCode() {
            return _code;
        }
        
        @Override
        public java.lang.Integer getCrc() {
            return _crc;
        }
        
        @Override
        public java.lang.Integer getIdentifier() {
            return _identifier;
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
        public java.lang.Integer getSequenceNumber() {
            return _sequenceNumber;
        }
        
        @Override
        public java.lang.Short getType() {
            return _type;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_code);
            result = prime * result + Objects.hashCode(_crc);
            result = prime * result + Objects.hashCode(_identifier);
            result = prime * result + Objects.hashCode(_payloadLength);
            result = prime * result + Objects.hashCode(_payloadOffset);
            result = prime * result + Objects.hashCode(_sequenceNumber);
            result = prime * result + Objects.hashCode(_type);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader)obj;
            if (!Objects.equals(_code, other.getCode())) {
                return false;
            }
            if (!Objects.equals(_crc, other.getCrc())) {
                return false;
            }
            if (!Objects.equals(_identifier, other.getIdentifier())) {
                return false;
            }
            if (!Objects.equals(_payloadLength, other.getPayloadLength())) {
                return false;
            }
            if (!Objects.equals(_payloadOffset, other.getPayloadOffset())) {
                return false;
            }
            if (!Objects.equals(_sequenceNumber, other.getSequenceNumber())) {
                return false;
            }
            if (!Objects.equals(_type, other.getType())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                IcmpPacketHeaderImpl otherImpl = (IcmpPacketHeaderImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.IcmpPacketHeader>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("IcmpPacketHeader [");
            boolean first = true;
        
            if (_code != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_code=");
                builder.append(_code);
             }
            if (_crc != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_crc=");
                builder.append(_crc);
             }
            if (_identifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_identifier=");
                builder.append(_identifier);
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
            if (_sequenceNumber != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sequenceNumber=");
                builder.append(_sequenceNumber);
             }
            if (_type != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_type=");
                builder.append(_type);
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
