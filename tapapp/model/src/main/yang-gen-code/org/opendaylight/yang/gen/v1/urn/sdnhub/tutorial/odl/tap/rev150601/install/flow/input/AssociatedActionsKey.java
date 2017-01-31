package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;


public class AssociatedActionsKey
 implements Identifier<AssociatedActions> {
    private static final long serialVersionUID = 4909244965112279344L;
    private final java.lang.Long _id;


    public AssociatedActionsKey(java.lang.Long _id) {
    
    
        this._id = _id;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public AssociatedActionsKey(AssociatedActionsKey source) {
        this._id = source._id;
    }


    public java.lang.Long getId() {
        return _id;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_id);
        return result;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AssociatedActionsKey other = (AssociatedActionsKey) obj;
        if (!Objects.equals(_id, other._id)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.install.flow.input.AssociatedActionsKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_id != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_id=");
            builder.append(_id);
         }
        return builder.append(']').toString();
    }
}

