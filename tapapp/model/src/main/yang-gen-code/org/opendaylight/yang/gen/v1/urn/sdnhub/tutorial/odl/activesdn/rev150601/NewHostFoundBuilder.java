package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound
 *
 */
public class NewHostFoundBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound> {

    private java.lang.String _hostIpAddress;
    private java.lang.String _hostMacAddress;
    private java.lang.Integer _portConnectedTo;
    private java.lang.Integer _switchConnectedTo;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>> augmentation = Collections.emptyMap();

    public NewHostFoundBuilder() {
    }

    public NewHostFoundBuilder(NewHostFound base) {
        this._hostIpAddress = base.getHostIpAddress();
        this._hostMacAddress = base.getHostMacAddress();
        this._portConnectedTo = base.getPortConnectedTo();
        this._switchConnectedTo = base.getSwitchConnectedTo();
        if (base instanceof NewHostFoundImpl) {
            NewHostFoundImpl impl = (NewHostFoundImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getHostIpAddress() {
        return _hostIpAddress;
    }
    
    public java.lang.String getHostMacAddress() {
        return _hostMacAddress;
    }
    
    public java.lang.Integer getPortConnectedTo() {
        return _portConnectedTo;
    }
    
    public java.lang.Integer getSwitchConnectedTo() {
        return _switchConnectedTo;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public NewHostFoundBuilder setHostIpAddress(final java.lang.String value) {
        this._hostIpAddress = value;
        return this;
    }
    
     
    public NewHostFoundBuilder setHostMacAddress(final java.lang.String value) {
        this._hostMacAddress = value;
        return this;
    }
    
     
    public NewHostFoundBuilder setPortConnectedTo(final java.lang.Integer value) {
        this._portConnectedTo = value;
        return this;
    }
    
     
    public NewHostFoundBuilder setSwitchConnectedTo(final java.lang.Integer value) {
        this._switchConnectedTo = value;
        return this;
    }
    
    public NewHostFoundBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public NewHostFoundBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public NewHostFound build() {
        return new NewHostFoundImpl(this);
    }

    private static final class NewHostFoundImpl implements NewHostFound {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound.class;
        }

        private final java.lang.String _hostIpAddress;
        private final java.lang.String _hostMacAddress;
        private final java.lang.Integer _portConnectedTo;
        private final java.lang.Integer _switchConnectedTo;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>> augmentation = Collections.emptyMap();

        private NewHostFoundImpl(NewHostFoundBuilder base) {
            this._hostIpAddress = base.getHostIpAddress();
            this._hostMacAddress = base.getHostMacAddress();
            this._portConnectedTo = base.getPortConnectedTo();
            this._switchConnectedTo = base.getSwitchConnectedTo();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getHostIpAddress() {
            return _hostIpAddress;
        }
        
        @Override
        public java.lang.String getHostMacAddress() {
            return _hostMacAddress;
        }
        
        @Override
        public java.lang.Integer getPortConnectedTo() {
            return _portConnectedTo;
        }
        
        @Override
        public java.lang.Integer getSwitchConnectedTo() {
            return _switchConnectedTo;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_hostIpAddress);
            result = prime * result + Objects.hashCode(_hostMacAddress);
            result = prime * result + Objects.hashCode(_portConnectedTo);
            result = prime * result + Objects.hashCode(_switchConnectedTo);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound)obj;
            if (!Objects.equals(_hostIpAddress, other.getHostIpAddress())) {
                return false;
            }
            if (!Objects.equals(_hostMacAddress, other.getHostMacAddress())) {
                return false;
            }
            if (!Objects.equals(_portConnectedTo, other.getPortConnectedTo())) {
                return false;
            }
            if (!Objects.equals(_switchConnectedTo, other.getSwitchConnectedTo())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                NewHostFoundImpl otherImpl = (NewHostFoundImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.NewHostFound>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("NewHostFound [");
            boolean first = true;
        
            if (_hostIpAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hostIpAddress=");
                builder.append(_hostIpAddress);
             }
            if (_hostMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_hostMacAddress=");
                builder.append(_hostMacAddress);
             }
            if (_portConnectedTo != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_portConnectedTo=");
                builder.append(_portConnectedTo);
             }
            if (_switchConnectedTo != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_switchConnectedTo=");
                builder.append(_switchConnectedTo);
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
