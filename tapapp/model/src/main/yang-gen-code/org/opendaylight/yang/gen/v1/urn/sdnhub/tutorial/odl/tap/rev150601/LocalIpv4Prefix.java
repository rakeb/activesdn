package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601;
import java.util.regex.Pattern;
import java.io.Serializable;
import java.beans.ConstructorProperties;
import com.google.common.collect.ImmutableList;
import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.List;


/**
 * The ipv4-prefix type represents an IPv4 address prefix.
 *         The prefix length is given by the number following the
 *         slash character and must be less than or equal to 32.
 *
 *         A prefix length value of n corresponds to an IP address
 *         mask that has n contiguous 1-bits from the most
 *         significant bit (MSB) and all other bits set to 0.
 *
 *         The canonical format of an IPv4 prefix has all bits of
 *         the IPv4 address set to zero that are not part of the
 *         IPv4 prefix.
 *
 */
public class LocalIpv4Prefix
 implements Serializable {
    private static final long serialVersionUID = -6212845872750445434L;
    private static final Pattern[] patterns;
    public static final List<String> PATTERN_CONSTANTS = ImmutableList.of("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])/(([0-9])|([1-2][0-9])|(3[0-2]))$");
    
    static {
        final Pattern a[] = new Pattern[PATTERN_CONSTANTS.size()];
        int i = 0;
        for (String regEx : PATTERN_CONSTANTS) {
            a[i++] = Pattern.compile(regEx);
        }
    
        patterns = a;
    }
    private final java.lang.String _value;


    @ConstructorProperties("value")
    public LocalIpv4Prefix(java.lang.String _value) {
    
    
        Preconditions.checkNotNull(_value, "Supplied value may not be null");
    
            for (Pattern p : patterns) {
                Preconditions.checkArgument(p.matcher(_value).matches(), "Supplied value \"%s\" does not match required pattern \"%s\"", _value, p);
            }
    
        this._value = _value;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public LocalIpv4Prefix(LocalIpv4Prefix source) {
        this._value = source._value;
    }

    public static LocalIpv4Prefix getDefaultInstance(String defaultValue) {
        return new LocalIpv4Prefix(defaultValue);
    }

    public java.lang.String getValue() {
        return _value;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_value);
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
        LocalIpv4Prefix other = (LocalIpv4Prefix) obj;
        if (!Objects.equals(_value, other._value)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.tap.rev150601.LocalIpv4Prefix.class.getSimpleName()).append(" [");
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
        return builder.append(']').toString();
    }
}

