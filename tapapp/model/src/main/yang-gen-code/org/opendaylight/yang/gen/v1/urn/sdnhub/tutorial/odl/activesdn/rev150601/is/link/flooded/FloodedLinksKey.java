package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;


public class FloodedLinksKey
 implements Identifier<FloodedLinks> {
    private static final long serialVersionUID = 4112919631152164140L;
    private final java.lang.String _linkId;


    public FloodedLinksKey(java.lang.String _linkId) {
    
    
        this._linkId = _linkId;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public FloodedLinksKey(FloodedLinksKey source) {
        this._linkId = source._linkId;
    }


    public java.lang.String getLinkId() {
        return _linkId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_linkId);
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
        FloodedLinksKey other = (FloodedLinksKey) obj;
        if (!Objects.equals(_linkId, other._linkId)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.is.link.flooded.FloodedLinksKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_linkId != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_linkId=");
            builder.append(_linkId);
         }
        return builder.append(']').toString();
    }
}

