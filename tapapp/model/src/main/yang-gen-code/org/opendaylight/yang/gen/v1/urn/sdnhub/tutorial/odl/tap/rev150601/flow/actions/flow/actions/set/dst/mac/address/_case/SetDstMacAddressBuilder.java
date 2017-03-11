package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case;
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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress
 *
 */
public class SetDstMacAddressBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress> {

    private MacAddress _value;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>> augmentation = Collections.emptyMap();

    public SetDstMacAddressBuilder() {
    }

    public SetDstMacAddressBuilder(SetDstMacAddress base) {
        this._value = base.getValue();
        if (base instanceof SetDstMacAddressImpl) {
            SetDstMacAddressImpl impl = (SetDstMacAddressImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public MacAddress getValue() {
        return _value;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public SetDstMacAddressBuilder setValue(final MacAddress value) {
        this._value = value;
        return this;
    }
    
    public SetDstMacAddressBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public SetDstMacAddressBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public SetDstMacAddress build() {
        return new SetDstMacAddressImpl(this);
    }

    private static final class SetDstMacAddressImpl implements SetDstMacAddress {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress.class;
        }

        private final MacAddress _value;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>> augmentation = Collections.emptyMap();

        private SetDstMacAddressImpl(SetDstMacAddressBuilder base) {
            this._value = base.getValue();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>>singletonMap(e.getKey(), e.getValue());
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
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress)obj;
            if (!Objects.equals(_value, other.getValue())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                SetDstMacAddressImpl otherImpl = (SetDstMacAddressImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.set.dst.mac.address._case.SetDstMacAddress>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("SetDstMacAddress [");
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
