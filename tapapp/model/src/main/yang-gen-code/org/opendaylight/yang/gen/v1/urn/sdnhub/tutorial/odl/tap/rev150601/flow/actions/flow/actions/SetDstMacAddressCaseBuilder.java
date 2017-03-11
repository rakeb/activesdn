package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase
 *
 */
public class SetDstMacAddressCaseBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase> {

    private SetDstMacAddress _setDstMacAddress;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>> augmentation = Collections.emptyMap();

    public SetDstMacAddressCaseBuilder() {
    }

    public SetDstMacAddressCaseBuilder(SetDstMacAddressCase base) {
        this._setDstMacAddress = base.getSetDstMacAddress();
        if (base instanceof SetDstMacAddressCaseImpl) {
            SetDstMacAddressCaseImpl impl = (SetDstMacAddressCaseImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public SetDstMacAddress getSetDstMacAddress() {
        return _setDstMacAddress;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public SetDstMacAddressCaseBuilder setSetDstMacAddress(final SetDstMacAddress value) {
        this._setDstMacAddress = value;
        return this;
    }
    
    public SetDstMacAddressCaseBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public SetDstMacAddressCaseBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public SetDstMacAddressCase build() {
        return new SetDstMacAddressCaseImpl(this);
    }

    private static final class SetDstMacAddressCaseImpl implements SetDstMacAddressCase {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase.class;
        }

        private final SetDstMacAddress _setDstMacAddress;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>> augmentation = Collections.emptyMap();

        private SetDstMacAddressCaseImpl(SetDstMacAddressCaseBuilder base) {
            this._setDstMacAddress = base.getSetDstMacAddress();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public SetDstMacAddress getSetDstMacAddress() {
            return _setDstMacAddress;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_setDstMacAddress);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase)obj;
            if (!Objects.equals(_setDstMacAddress, other.getSetDstMacAddress())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                SetDstMacAddressCaseImpl otherImpl = (SetDstMacAddressCaseImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.SetDstMacAddressCase>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("SetDstMacAddressCase [");
            boolean first = true;
        
            if (_setDstMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_setDstMacAddress=");
                builder.append(_setDstMacAddress);
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
