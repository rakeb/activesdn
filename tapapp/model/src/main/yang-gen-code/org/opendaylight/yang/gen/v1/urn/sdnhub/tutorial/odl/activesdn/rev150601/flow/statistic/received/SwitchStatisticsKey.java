package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;


public class SwitchStatisticsKey
 implements Identifier<SwitchStatistics> {
    private static final long serialVersionUID = 4329063893840343183L;
    private final java.lang.Integer _switchId;


    public SwitchStatisticsKey(java.lang.Integer _switchId) {
    
    
        this._switchId = _switchId;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public SwitchStatisticsKey(SwitchStatisticsKey source) {
        this._switchId = source._switchId;
    }


    public java.lang.Integer getSwitchId() {
        return _switchId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_switchId);
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
        SwitchStatisticsKey other = (SwitchStatisticsKey) obj;
        if (!Objects.equals(_switchId, other._switchId)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.flow.statistic.received.SwitchStatisticsKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_switchId != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_switchId=");
            builder.append(_switchId);
         }
        return builder.append(']').toString();
    }
}

