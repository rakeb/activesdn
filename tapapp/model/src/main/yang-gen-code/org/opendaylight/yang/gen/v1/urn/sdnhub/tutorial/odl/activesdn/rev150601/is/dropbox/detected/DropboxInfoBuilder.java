package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo
 *
 */
public class DropboxInfoBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo> {

    private java.lang.String _dstIp;
    private java.lang.Integer _dstPort;
    private java.lang.String _srcIp;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>> augmentation = Collections.emptyMap();

    public DropboxInfoBuilder() {
    }

    public DropboxInfoBuilder(DropboxInfo base) {
        this._dstIp = base.getDstIp();
        this._dstPort = base.getDstPort();
        this._srcIp = base.getSrcIp();
        if (base instanceof DropboxInfoImpl) {
            DropboxInfoImpl impl = (DropboxInfoImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getDstIp() {
        return _dstIp;
    }
    
    public java.lang.Integer getDstPort() {
        return _dstPort;
    }
    
    public java.lang.String getSrcIp() {
        return _srcIp;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public DropboxInfoBuilder setDstIp(final java.lang.String value) {
        this._dstIp = value;
        return this;
    }
    
     
    public DropboxInfoBuilder setDstPort(final java.lang.Integer value) {
        this._dstPort = value;
        return this;
    }
    
     
    public DropboxInfoBuilder setSrcIp(final java.lang.String value) {
        this._srcIp = value;
        return this;
    }
    
    public DropboxInfoBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public DropboxInfoBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public DropboxInfo build() {
        return new DropboxInfoImpl(this);
    }

    private static final class DropboxInfoImpl implements DropboxInfo {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo.class;
        }

        private final java.lang.String _dstIp;
        private final java.lang.Integer _dstPort;
        private final java.lang.String _srcIp;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>> augmentation = Collections.emptyMap();

        private DropboxInfoImpl(DropboxInfoBuilder base) {
            this._dstIp = base.getDstIp();
            this._dstPort = base.getDstPort();
            this._srcIp = base.getSrcIp();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getDstIp() {
            return _dstIp;
        }
        
        @Override
        public java.lang.Integer getDstPort() {
            return _dstPort;
        }
        
        @Override
        public java.lang.String getSrcIp() {
            return _srcIp;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_dstIp);
            result = prime * result + Objects.hashCode(_dstPort);
            result = prime * result + Objects.hashCode(_srcIp);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo)obj;
            if (!Objects.equals(_dstIp, other.getDstIp())) {
                return false;
            }
            if (!Objects.equals(_dstPort, other.getDstPort())) {
                return false;
            }
            if (!Objects.equals(_srcIp, other.getSrcIp())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                DropboxInfoImpl otherImpl = (DropboxInfoImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.dropbox.detected.DropboxInfo>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("DropboxInfo [");
            boolean first = true;
        
            if (_dstIp != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstIp=");
                builder.append(_dstIp);
             }
            if (_dstPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dstPort=");
                builder.append(_dstPort);
             }
            if (_srcIp != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_srcIp=");
                builder.append(_srcIp);
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
