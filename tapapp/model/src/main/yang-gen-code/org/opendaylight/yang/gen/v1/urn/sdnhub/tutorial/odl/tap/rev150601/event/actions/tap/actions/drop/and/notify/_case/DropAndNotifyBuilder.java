package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify
 *
 */
public class DropAndNotifyBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify> {

    private java.lang.Integer _holdNotification;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>> augmentation = Collections.emptyMap();

    public DropAndNotifyBuilder() {
    }

    public DropAndNotifyBuilder(DropAndNotify base) {
        this._holdNotification = base.getHoldNotification();
        if (base instanceof DropAndNotifyImpl) {
            DropAndNotifyImpl impl = (DropAndNotifyImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.Integer getHoldNotification() {
        return _holdNotification;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public DropAndNotifyBuilder setHoldNotification(final java.lang.Integer value) {
        this._holdNotification = value;
        return this;
    }
    
    public DropAndNotifyBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public DropAndNotifyBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public DropAndNotify build() {
        return new DropAndNotifyImpl(this);
    }

    private static final class DropAndNotifyImpl implements DropAndNotify {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify.class;
        }

        private final java.lang.Integer _holdNotification;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>> augmentation = Collections.emptyMap();

        private DropAndNotifyImpl(DropAndNotifyBuilder base) {
            this._holdNotification = base.getHoldNotification();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Integer getHoldNotification() {
            return _holdNotification;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_holdNotification);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify)obj;
            if (!Objects.equals(_holdNotification, other.getHoldNotification())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                DropAndNotifyImpl otherImpl = (DropAndNotifyImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.event.actions.tap.actions.drop.and.notify._case.DropAndNotify>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("DropAndNotify [");
            boolean first = true;
        
            if (_holdNotification != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_holdNotification=");
                builder.append(_holdNotification);
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
