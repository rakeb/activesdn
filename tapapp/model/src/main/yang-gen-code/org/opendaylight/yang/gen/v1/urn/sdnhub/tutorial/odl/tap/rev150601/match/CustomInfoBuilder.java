package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo
 *
 */
public class CustomInfoBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo> {

    private java.lang.Integer _dlType;
    private java.lang.Short _nwProto;
    private java.lang.Integer _tpDst;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>> augmentation = Collections.emptyMap();

    public CustomInfoBuilder() {
    }

    public CustomInfoBuilder(CustomInfo base) {
        this._dlType = base.getDlType();
        this._nwProto = base.getNwProto();
        this._tpDst = base.getTpDst();
        if (base instanceof CustomInfoImpl) {
            CustomInfoImpl impl = (CustomInfoImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.Integer getDlType() {
        return _dlType;
    }
    
    public java.lang.Short getNwProto() {
        return _nwProto;
    }
    
    public java.lang.Integer getTpDst() {
        return _tpDst;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkDlTypeRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public CustomInfoBuilder setDlType(final java.lang.Integer value) {
    if (value != null) {
        checkDlTypeRange(value);
    }
        this._dlType = value;
        return this;
    }
    
     
     private static void checkNwProtoRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public CustomInfoBuilder setNwProto(final java.lang.Short value) {
    if (value != null) {
        checkNwProtoRange(value);
    }
        this._nwProto = value;
        return this;
    }
    
     
     private static void checkTpDstRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public CustomInfoBuilder setTpDst(final java.lang.Integer value) {
    if (value != null) {
        checkTpDstRange(value);
    }
        this._tpDst = value;
        return this;
    }
    
    public CustomInfoBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public CustomInfoBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public CustomInfo build() {
        return new CustomInfoImpl(this);
    }

    private static final class CustomInfoImpl implements CustomInfo {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo.class;
        }

        private final java.lang.Integer _dlType;
        private final java.lang.Short _nwProto;
        private final java.lang.Integer _tpDst;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>> augmentation = Collections.emptyMap();

        private CustomInfoImpl(CustomInfoBuilder base) {
            this._dlType = base.getDlType();
            this._nwProto = base.getNwProto();
            this._tpDst = base.getTpDst();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Integer getDlType() {
            return _dlType;
        }
        
        @Override
        public java.lang.Short getNwProto() {
            return _nwProto;
        }
        
        @Override
        public java.lang.Integer getTpDst() {
            return _tpDst;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_dlType);
            result = prime * result + Objects.hashCode(_nwProto);
            result = prime * result + Objects.hashCode(_tpDst);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo)obj;
            if (!Objects.equals(_dlType, other.getDlType())) {
                return false;
            }
            if (!Objects.equals(_nwProto, other.getNwProto())) {
                return false;
            }
            if (!Objects.equals(_tpDst, other.getTpDst())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                CustomInfoImpl otherImpl = (CustomInfoImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.match.CustomInfo>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("CustomInfo [");
            boolean first = true;
        
            if (_dlType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dlType=");
                builder.append(_dlType);
             }
            if (_nwProto != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_nwProto=");
                builder.append(_nwProto);
             }
            if (_tpDst != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_tpDst=");
                builder.append(_tpDst);
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
