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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader
 *
 */
public class TcpPacketHeaderBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader> {

    private java.lang.Short _destPort;
    private java.lang.Integer _sequenceNumber;
    private java.lang.Short _sourcePort;
    private java.lang.Boolean _ackFlag;
    private java.lang.Boolean _finFlag;
    private java.lang.Boolean _rstFlag;
    private java.lang.Boolean _synFlag;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>> augmentation = Collections.emptyMap();

    public TcpPacketHeaderBuilder() {
    }
    public TcpPacketHeaderBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields arg) {
        this._sourcePort = arg.getSourcePort();
        this._destPort = arg.getDestPort();
        this._sequenceNumber = arg.getSequenceNumber();
        this._synFlag = arg.isSynFlag();
        this._rstFlag = arg.isRstFlag();
        this._ackFlag = arg.isAckFlag();
        this._finFlag = arg.isFinFlag();
    }

    public TcpPacketHeaderBuilder(TcpPacketHeader base) {
        this._destPort = base.getDestPort();
        this._sequenceNumber = base.getSequenceNumber();
        this._sourcePort = base.getSourcePort();
        this._ackFlag = base.isAckFlag();
        this._finFlag = base.isFinFlag();
        this._rstFlag = base.isRstFlag();
        this._synFlag = base.isSynFlag();
        if (base instanceof TcpPacketHeaderImpl) {
            TcpPacketHeaderImpl impl = (TcpPacketHeaderImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields) {
            this._sourcePort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields)arg).getSourcePort();
            this._destPort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields)arg).getDestPort();
            this._sequenceNumber = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields)arg).getSequenceNumber();
            this._synFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields)arg).isSynFlag();
            this._rstFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields)arg).isRstFlag();
            this._ackFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields)arg).isAckFlag();
            this._finFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields)arg).isFinFlag();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketFields] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.Short getDestPort() {
        return _destPort;
    }
    
    public java.lang.Integer getSequenceNumber() {
        return _sequenceNumber;
    }
    
    public java.lang.Short getSourcePort() {
        return _sourcePort;
    }
    
    public java.lang.Boolean isAckFlag() {
        return _ackFlag;
    }
    
    public java.lang.Boolean isFinFlag() {
        return _finFlag;
    }
    
    public java.lang.Boolean isRstFlag() {
        return _rstFlag;
    }
    
    public java.lang.Boolean isSynFlag() {
        return _synFlag;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public TcpPacketHeaderBuilder setDestPort(final java.lang.Short value) {
        this._destPort = value;
        return this;
    }
    
     
    public TcpPacketHeaderBuilder setSequenceNumber(final java.lang.Integer value) {
        this._sequenceNumber = value;
        return this;
    }
    
     
    public TcpPacketHeaderBuilder setSourcePort(final java.lang.Short value) {
        this._sourcePort = value;
        return this;
    }
    
     
    public TcpPacketHeaderBuilder setAckFlag(final java.lang.Boolean value) {
        this._ackFlag = value;
        return this;
    }
    
     
    public TcpPacketHeaderBuilder setFinFlag(final java.lang.Boolean value) {
        this._finFlag = value;
        return this;
    }
    
     
    public TcpPacketHeaderBuilder setRstFlag(final java.lang.Boolean value) {
        this._rstFlag = value;
        return this;
    }
    
     
    public TcpPacketHeaderBuilder setSynFlag(final java.lang.Boolean value) {
        this._synFlag = value;
        return this;
    }
    
    public TcpPacketHeaderBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public TcpPacketHeaderBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public TcpPacketHeader build() {
        return new TcpPacketHeaderImpl(this);
    }

    private static final class TcpPacketHeaderImpl implements TcpPacketHeader {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader.class;
        }

        private final java.lang.Short _destPort;
        private final java.lang.Integer _sequenceNumber;
        private final java.lang.Short _sourcePort;
        private final java.lang.Boolean _ackFlag;
        private final java.lang.Boolean _finFlag;
        private final java.lang.Boolean _rstFlag;
        private final java.lang.Boolean _synFlag;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>> augmentation = Collections.emptyMap();

        private TcpPacketHeaderImpl(TcpPacketHeaderBuilder base) {
            this._destPort = base.getDestPort();
            this._sequenceNumber = base.getSequenceNumber();
            this._sourcePort = base.getSourcePort();
            this._ackFlag = base.isAckFlag();
            this._finFlag = base.isFinFlag();
            this._rstFlag = base.isRstFlag();
            this._synFlag = base.isSynFlag();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Short getDestPort() {
            return _destPort;
        }
        
        @Override
        public java.lang.Integer getSequenceNumber() {
            return _sequenceNumber;
        }
        
        @Override
        public java.lang.Short getSourcePort() {
            return _sourcePort;
        }
        
        @Override
        public java.lang.Boolean isAckFlag() {
            return _ackFlag;
        }
        
        @Override
        public java.lang.Boolean isFinFlag() {
            return _finFlag;
        }
        
        @Override
        public java.lang.Boolean isRstFlag() {
            return _rstFlag;
        }
        
        @Override
        public java.lang.Boolean isSynFlag() {
            return _synFlag;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_destPort);
            result = prime * result + Objects.hashCode(_sequenceNumber);
            result = prime * result + Objects.hashCode(_sourcePort);
            result = prime * result + Objects.hashCode(_ackFlag);
            result = prime * result + Objects.hashCode(_finFlag);
            result = prime * result + Objects.hashCode(_rstFlag);
            result = prime * result + Objects.hashCode(_synFlag);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader)obj;
            if (!Objects.equals(_destPort, other.getDestPort())) {
                return false;
            }
            if (!Objects.equals(_sequenceNumber, other.getSequenceNumber())) {
                return false;
            }
            if (!Objects.equals(_sourcePort, other.getSourcePort())) {
                return false;
            }
            if (!Objects.equals(_ackFlag, other.isAckFlag())) {
                return false;
            }
            if (!Objects.equals(_finFlag, other.isFinFlag())) {
                return false;
            }
            if (!Objects.equals(_rstFlag, other.isRstFlag())) {
                return false;
            }
            if (!Objects.equals(_synFlag, other.isSynFlag())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                TcpPacketHeaderImpl otherImpl = (TcpPacketHeaderImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.TcpPacketHeader>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("TcpPacketHeader [");
            boolean first = true;
        
            if (_destPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_destPort=");
                builder.append(_destPort);
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
            if (_sourcePort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sourcePort=");
                builder.append(_sourcePort);
             }
            if (_ackFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ackFlag=");
                builder.append(_ackFlag);
             }
            if (_finFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_finFlag=");
                builder.append(_finFlag);
             }
            if (_rstFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_rstFlag=");
                builder.append(_rstFlag);
             }
            if (_synFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_synFlag=");
                builder.append(_synFlag);
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
