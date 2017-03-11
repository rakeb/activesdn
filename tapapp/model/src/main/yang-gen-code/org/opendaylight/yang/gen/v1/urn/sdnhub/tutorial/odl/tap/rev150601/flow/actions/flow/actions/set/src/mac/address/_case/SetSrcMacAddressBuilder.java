package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev100924.MacAddress;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress
 *
 */
public class SetSrcMacAddressBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress> {

    private MacAddress _value;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>> augmentation = Collections.emptyMap();

    public SetSrcMacAddressBuilder() {
    }

    public SetSrcMacAddressBuilder(SetSrcMacAddress base) {
        this._value = base.getValue();
        if (base instanceof SetSrcMacAddressImpl) {
            SetSrcMacAddressImpl impl = (SetSrcMacAddressImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public MacAddress getValue() {
        return _value;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public SetSrcMacAddressBuilder setValue(final MacAddress value) {
        this._value = value;
        return this;
    }
    
    public SetSrcMacAddressBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public SetSrcMacAddressBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public SetSrcMacAddress build() {
        return new SetSrcMacAddressImpl(this);
    }

    private static final class SetSrcMacAddressImpl implements SetSrcMacAddress {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress.class;
        }

        private final MacAddress _value;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>> augmentation = Collections.emptyMap();

        private SetSrcMacAddressImpl(SetSrcMacAddressBuilder base) {
            this._value = base.getValue();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public MacAddress getValue() {
            return _value;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_value);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress)obj;
            if (!Objects.equals(_value, other.getValue())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                SetSrcMacAddressImpl otherImpl = (SetSrcMacAddressImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.src.mac.address._case.SetSrcMacAddress>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("SetSrcMacAddress [");
            boolean first = true;
        
            if (_value != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_value=");
                builder.append(_value);
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
