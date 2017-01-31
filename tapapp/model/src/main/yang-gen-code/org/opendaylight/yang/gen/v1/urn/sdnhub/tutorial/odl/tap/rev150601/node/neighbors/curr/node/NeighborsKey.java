package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node;
import org.opendaylight.yangtools.yang.binding.Identifier;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import java.util.Objects;


public class NeighborsKey
 implements Identifier<Neighbors> {
    private static final long serialVersionUID = -4112743682083643088L;
    private final NodeId _neighborNodeId;


    public NeighborsKey(NodeId _neighborNodeId) {
    
    
        this._neighborNodeId = _neighborNodeId;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public NeighborsKey(NeighborsKey source) {
        this._neighborNodeId = source._neighborNodeId;
    }


    public NodeId getNeighborNodeId() {
        return _neighborNodeId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_neighborNodeId);
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
        NeighborsKey other = (NeighborsKey) obj;
        if (!Objects.equals(_neighborNodeId, other._neighborNodeId)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.node.neighbors.curr.node.NeighborsKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_neighborNodeId != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_neighborNodeId=");
            builder.append(_neighborNodeId);
         }
        return builder.append(']').toString();
    }
}

