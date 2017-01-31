package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType
 *
 */
public class ArpPacketTypeBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType> {

    private java.lang.String _ethernetSrcMacAddress;
    private java.lang.String _ethernetType;
    private java.lang.Integer _hardwareAddressLength;
    private java.lang.String _hardwareType;
    private java.lang.String _opcode;
    private java.lang.Integer _protocolAddressLength;
    private java.lang.String _protocolType;
    private java.lang.String _senderHardwareAddress;
    private java.lang.String _senderProtocolAddress;
    private java.lang.String _targetHardwareAddress;
    private java.lang.String _targetProtocolAddress;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>> augmentation = Collections.emptyMap();

    public ArpPacketTypeBuilder() {
    }
    public ArpPacketTypeBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields arg) {
        this._ethernetSrcMacAddress = arg.getEthernetSrcMacAddress();
        this._ethernetType = arg.getEthernetType();
        this._hardwareType = arg.getHardwareType();
        this._protocolType = arg.getProtocolType();
        this._hardwareAddressLength = arg.getHardwareAddressLength();
        this._protocolAddressLength = arg.getProtocolAddressLength();
        this._opcode = arg.getOpcode();
        this._senderHardwareAddress = arg.getSenderHardwareAddress();
        this._senderProtocolAddress = arg.getSenderProtocolAddress();
        this._targetHardwareAddress = arg.getTargetHardwareAddress();
        this._targetProtocolAddress = arg.getTargetProtocolAddress();
    }

    public ArpPacketTypeBuilder(ArpPacketType base) {
        this._ethernetSrcMacAddress = base.getEthernetSrcMacAddress();
        this._ethernetType = base.getEthernetType();
        this._hardwareAddressLength = base.getHardwareAddressLength();
        this._hardwareType = base.getHardwareType();
        this._opcode = base.getOpcode();
        this._protocolAddressLength = base.getProtocolAddressLength();
        this._protocolType = base.getProtocolType();
        this._senderHardwareAddress = base.getSenderHardwareAddress();
        this._senderProtocolAddress = base.getSenderProtocolAddress();
        this._targetHardwareAddress = base.getTargetHardwareAddress();
        this._targetProtocolAddress = base.getTargetProtocolAddress();
        if (base instanceof ArpPacketTypeImpl) {
            ArpPacketTypeImpl impl = (ArpPacketTypeImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields) {
            this._ethernetSrcMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getEthernetSrcMacAddress();
            this._ethernetType = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getEthernetType();
            this._hardwareType = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getHardwareType();
            this._protocolType = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getProtocolType();
            this._hardwareAddressLength = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getHardwareAddressLength();
            this._protocolAddressLength = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getProtocolAddressLength();
            this._opcode = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getOpcode();
            this._senderHardwareAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getSenderHardwareAddress();
            this._senderProtocolAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getSenderProtocolAddress();
            this._targetHardwareAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getTargetHardwareAddress();
            this._targetProtocolAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields)arg).getTargetProtocolAddress();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.ArpPacketHeaderFields] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.String getEthernetSrcMacAddress() {
        return _ethernetSrcMacAddress;
    }
    
    public java.lang.String getEthernetType() {
        return _ethernetType;
    }
    
    public java.lang.Integer getHardwareAddressLength() {
        return _hardwareAddressLength;
    }
    
    public java.lang.String getHardwareType() {
        return _hardwareType;
    }
    
    public java.lang.String getOpcode() {
        return _opcode;
    }
    
    public java.lang.Integer getProtocolAddressLength() {
        return _protocolAddressLength;
    }
    
    public java.lang.String getProtocolType() {
        return _protocolType;
    }
    
    public java.lang.String getSenderHardwareAddress() {
        return _senderHardwareAddress;
    }
    
    public java.lang.String getSenderProtocolAddress() {
        return _senderProtocolAddress;
    }
    
    public java.lang.String getTargetHardwareAddress() {
        return _targetHardwareAddress;
    }
    
    public java.lang.String getTargetProtocolAddress() {
        return _targetProtocolAddress;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public ArpPacketTypeBuilder setEthernetSrcMacAddress(final java.lang.String value) {
        this._ethernetSrcMacAddress = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setEthernetType(final java.lang.String value) {
        this._ethernetType = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setHardwareAddressLength(final java.lang.Integer value) {
        this._hardwareAddressLength = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setHardwareType(final java.lang.String value) {
        this._hardwareType = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setOpcode(final java.lang.String value) {
        this._opcode = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setProtocolAddressLength(final java.lang.Integer value) {
        this._protocolAddressLength = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setProtocolType(final java.lang.String value) {
        this._protocolType = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setSenderHardwareAddress(final java.lang.String value) {
        this._senderHardwareAddress = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setSenderProtocolAddress(final java.lang.String value) {
        this._senderProtocolAddress = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setTargetHardwareAddress(final java.lang.String value) {
        this._targetHardwareAddress = value;
        return this;
    }
    
     
    public ArpPacketTypeBuilder setTargetProtocolAddress(final java.lang.String value) {
        this._targetProtocolAddress = value;
        return this;
    }
    
    public ArpPacketTypeBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public ArpPacketTypeBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public ArpPacketType build() {
        return new ArpPacketTypeImpl(this);
    }

    private static final class ArpPacketTypeImpl implements ArpPacketType {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType.class;
        }

        private final java.lang.String _ethernetSrcMacAddress;
        private final java.lang.String _ethernetType;
        private final java.lang.Integer _hardwareAddressLength;
        private final java.lang.String _hardwareType;
        private final java.lang.String _opcode;
        private final java.lang.Integer _protocolAddressLength;
        private final java.lang.String _protocolType;
        private final java.lang.String _senderHardwareAddress;
        private final java.lang.String _senderProtocolAddress;
        private final java.lang.String _targetHardwareAddress;
        private final java.lang.String _targetProtocolAddress;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>> augmentation = Collections.emptyMap();

        private ArpPacketTypeImpl(ArpPacketTypeBuilder base) {
            this._ethernetSrcMacAddress = base.getEthernetSrcMacAddress();
            this._ethernetType = base.getEthernetType();
            this._hardwareAddressLength = base.getHardwareAddressLength();
            this._hardwareType = base.getHardwareType();
            this._opcode = base.getOpcode();
            this._protocolAddressLength = base.getProtocolAddressLength();
            this._protocolType = base.getProtocolType();
            this._senderHardwareAddress = base.getSenderHardwareAddress();
            this._senderProtocolAddress = base.getSenderProtocolAddress();
            this._targetHardwareAddress = base.getTargetHardwareAddress();
            this._targetProtocolAddress = base.getTargetProtocolAddress();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getEthernetSrcMacAddress() {
            return _ethernetSrcMacAddress;
        }
        
        @Override
        public java.lang.String getEthernetType() {
            return _ethernetType;
        }
        
        @Override
        public java.lang.Integer getHardwareAddressLength() {
            return _hardwareAddressLength;
        }
        
        @Override
        public java.lang.String getHardwareType() {
            return _hardwareType;
        }
        
        @Override
        public java.lang.String getOpcode() {
            return _opcode;
        }
        
        @Override
        public java.lang.Integer getProtocolAddressLength() {
            return _protocolAddressLength;
        }
        
        @Override
        public java.lang.String getProtocolType() {
            return _protocolType;
        }
        
        @Override
        public java.lang.String getSenderHardwareAddress() {
            return _senderHardwareAddress;
        }
        
        @Override
        public java.lang.String getSenderProtocolAddress() {
            return _senderProtocolAddress;
        }
        
        @Override
        public java.lang.String getTargetHardwareAddress() {
            return _targetHardwareAddress;
        }
        
        @Override
        public java.lang.String getTargetProtocolAddress() {
            return _targetProtocolAddress;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_ethernetSrcMacAddress);
            result = prime * result + Objects.hashCode(_ethernetType);
            result = prime * result + Objects.hashCode(_hardwareAddressLength);
            result = prime * result + Objects.hashCode(_hardwareType);
            result = prime * result + Objects.hashCode(_opcode);
            result = prime * result + Objects.hashCode(_protocolAddressLength);
            result = prime * result + Objects.hashCode(_protocolType);
            result = prime * result + Objects.hashCode(_senderHardwareAddress);
            result = prime * result + Objects.hashCode(_senderProtocolAddress);
            result = prime * result + Objects.hashCode(_targetHardwareAddress);
            result = prime * result + Objects.hashCode(_targetProtocolAddress);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType)obj;
            if (!Objects.equals(_ethernetSrcMacAddress, other.getEthernetSrcMacAddress())) {
                return false;
            }
            if (!Objects.equals(_ethernetType, other.getEthernetType())) {
                return false;
            }
            if (!Objects.equals(_hardwareAddressLength, other.getHardwareAddressLength())) {
                return false;
            }
            if (!Objects.equals(_hardwareType, other.getHardwareType())) {
                return false;
            }
            if (!Objects.equals(_opcode, other.getOpcode())) {
                return false;
            }
            if (!Objects.equals(_protocolAddressLength, other.getProtocolAddressLength())) {
                return false;
            }
            if (!Objects.equals(_protocolType, other.getProtocolType())) {
                return false;
            }
            if (!Objects.equals(_senderHardwareAddress, other.getSenderHardwareAddress())) {
                return false;
            }
            if (!Objects.equals(_senderProtocolAddress, other.getSenderProtocolAddress())) {
                return false;
            }
            if (!Objects.equals(_targetHardwareAddress, other.getTargetHardwareAddress())) {
                return false;
            }
            if (!Objects.equals(_targetProtocolAddress, other.getTargetProtocolAddress())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                ArpPacketTypeImpl otherImpl = (ArpPacketTypeImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.ArpPacketType>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("ArpPacketType [");
            boolean first = true;
        
            if (_ethernetSrcMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ethernetSrcMacAddress=");
                builder.append(_ethernetSrcMacAddress);
             }
            if (_ethernetType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ethernetType=");
                builder.append(_ethernetType);
             }
            if (_hardwareAddressLength != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hardwareAddressLength=");
                builder.append(_hardwareAddressLength);
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
            if (_opcode != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_opcode=");
                builder.append(_opcode);
             }
            if (_protocolAddressLength != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_protocolAddressLength=");
                builder.append(_protocolAddressLength);
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
            if (_senderHardwareAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_senderHardwareAddress=");
                builder.append(_senderHardwareAddress);
             }
            if (_senderProtocolAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_senderProtocolAddress=");
                builder.append(_senderProtocolAddress);
             }
            if (_targetHardwareAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_targetHardwareAddress=");
                builder.append(_targetHardwareAddress);
             }
            if (_targetProtocolAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_targetProtocolAddress=");
                builder.append(_targetProtocolAddress);
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
