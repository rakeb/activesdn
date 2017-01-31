package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.forward.to.port._case.ForwardToPort;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase
 *
 */
public class ForwardToPortCaseBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase> {

    private ForwardToPort _forwardToPort;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>> augmentation = Collections.emptyMap();

    public ForwardToPortCaseBuilder() {
    }

    public ForwardToPortCaseBuilder(ForwardToPortCase base) {
        this._forwardToPort = base.getForwardToPort();
        if (base instanceof ForwardToPortCaseImpl) {
            ForwardToPortCaseImpl impl = (ForwardToPortCaseImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public ForwardToPort getForwardToPort() {
        return _forwardToPort;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public ForwardToPortCaseBuilder setForwardToPort(final ForwardToPort value) {
        this._forwardToPort = value;
        return this;
    }
    
    public ForwardToPortCaseBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public ForwardToPortCaseBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public ForwardToPortCase build() {
        return new ForwardToPortCaseImpl(this);
    }

    private static final class ForwardToPortCaseImpl implements ForwardToPortCase {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase.class;
        }

        private final ForwardToPort _forwardToPort;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>> augmentation = Collections.emptyMap();

        private ForwardToPortCaseImpl(ForwardToPortCaseBuilder base) {
            this._forwardToPort = base.getForwardToPort();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public ForwardToPort getForwardToPort() {
            return _forwardToPort;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_forwardToPort);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase)obj;
            if (!Objects.equals(_forwardToPort, other.getForwardToPort())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                ForwardToPortCaseImpl otherImpl = (ForwardToPortCaseImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.flow.actions.flow.actions.ForwardToPortCase>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("ForwardToPortCase [");
            boolean first = true;
        
            if (_forwardToPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_forwardToPort=");
                builder.append(_forwardToPort);
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
