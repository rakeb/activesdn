package org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Arrays;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType
 *
 */
public class Ipv4PacketTypeBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType> {

    private java.lang.String _destinationAddress;
    private java.lang.Short _dscpValue;
    private java.lang.Short _ecn;
    private java.lang.Integer _fragmentOffset;
    private java.lang.Integer _headerChecksum;
    private java.lang.Integer _identification;
    private java.lang.Short _ihl;
    private byte[] _ipv4Options;
    private java.lang.Short _protocol;
    private java.lang.String _sourceAddress;
    private java.lang.Integer _totalLength;
    private java.lang.Short _ttl;
    private java.lang.Short _version;
    private java.lang.Boolean _dfFlag;
    private java.lang.Boolean _mfFlag;
    private java.lang.Boolean _reservedFlag;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>> augmentation = Collections.emptyMap();

    public Ipv4PacketTypeBuilder() {
    }
    public Ipv4PacketTypeBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields arg) {
        this._version = arg.getVersion();
        this._ihl = arg.getIhl();
        this._dscpValue = arg.getDscpValue();
        this._ecn = arg.getEcn();
        this._totalLength = arg.getTotalLength();
        this._identification = arg.getIdentification();
        this._reservedFlag = arg.isReservedFlag();
        this._dfFlag = arg.isDfFlag();
        this._mfFlag = arg.isMfFlag();
        this._fragmentOffset = arg.getFragmentOffset();
        this._ttl = arg.getTtl();
        this._protocol = arg.getProtocol();
        this._headerChecksum = arg.getHeaderChecksum();
        this._sourceAddress = arg.getSourceAddress();
        this._destinationAddress = arg.getDestinationAddress();
        this._ipv4Options = arg.getIpv4Options();
    }

    public Ipv4PacketTypeBuilder(Ipv4PacketType base) {
        this._destinationAddress = base.getDestinationAddress();
        this._dscpValue = base.getDscpValue();
        this._ecn = base.getEcn();
        this._fragmentOffset = base.getFragmentOffset();
        this._headerChecksum = base.getHeaderChecksum();
        this._identification = base.getIdentification();
        this._ihl = base.getIhl();
        this._ipv4Options = base.getIpv4Options();
        this._protocol = base.getProtocol();
        this._sourceAddress = base.getSourceAddress();
        this._totalLength = base.getTotalLength();
        this._ttl = base.getTtl();
        this._version = base.getVersion();
        this._dfFlag = base.isDfFlag();
        this._mfFlag = base.isMfFlag();
        this._reservedFlag = base.isReservedFlag();
        if (base instanceof Ipv4PacketTypeImpl) {
            Ipv4PacketTypeImpl impl = (Ipv4PacketTypeImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields) {
            this._version = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getVersion();
            this._ihl = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getIhl();
            this._dscpValue = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getDscpValue();
            this._ecn = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getEcn();
            this._totalLength = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getTotalLength();
            this._identification = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getIdentification();
            this._reservedFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).isReservedFlag();
            this._dfFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).isDfFlag();
            this._mfFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).isMfFlag();
            this._fragmentOffset = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getFragmentOffset();
            this._ttl = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getTtl();
            this._protocol = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getProtocol();
            this._headerChecksum = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getHeaderChecksum();
            this._sourceAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getSourceAddress();
            this._destinationAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getDestinationAddress();
            this._ipv4Options = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields)arg).getIpv4Options();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.String getDestinationAddress() {
        return _destinationAddress;
    }
    
    public java.lang.Short getDscpValue() {
        return _dscpValue;
    }
    
    public java.lang.Short getEcn() {
        return _ecn;
    }
    
    public java.lang.Integer getFragmentOffset() {
        return _fragmentOffset;
    }
    
    public java.lang.Integer getHeaderChecksum() {
        return _headerChecksum;
    }
    
    public java.lang.Integer getIdentification() {
        return _identification;
    }
    
    public java.lang.Short getIhl() {
        return _ihl;
    }
    
    public byte[] getIpv4Options() {
        return _ipv4Options == null ? null : _ipv4Options.clone();
    }
    
    public java.lang.Short getProtocol() {
        return _protocol;
    }
    
    public java.lang.String getSourceAddress() {
        return _sourceAddress;
    }
    
    public java.lang.Integer getTotalLength() {
        return _totalLength;
    }
    
    public java.lang.Short getTtl() {
        return _ttl;
    }
    
    public java.lang.Short getVersion() {
        return _version;
    }
    
    public java.lang.Boolean isDfFlag() {
        return _dfFlag;
    }
    
    public java.lang.Boolean isMfFlag() {
        return _mfFlag;
    }
    
    public java.lang.Boolean isReservedFlag() {
        return _reservedFlag;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public Ipv4PacketTypeBuilder setDestinationAddress(final java.lang.String value) {
        this._destinationAddress = value;
        return this;
    }
    
     
     private static void checkDscpValueRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public Ipv4PacketTypeBuilder setDscpValue(final java.lang.Short value) {
    if (value != null) {
        checkDscpValueRange(value);
    }
        this._dscpValue = value;
        return this;
    }
    
     
     private static void checkEcnRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public Ipv4PacketTypeBuilder setEcn(final java.lang.Short value) {
    if (value != null) {
        checkEcnRange(value);
    }
        this._ecn = value;
        return this;
    }
    
     
     private static void checkFragmentOffsetRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public Ipv4PacketTypeBuilder setFragmentOffset(final java.lang.Integer value) {
    if (value != null) {
        checkFragmentOffsetRange(value);
    }
        this._fragmentOffset = value;
        return this;
    }
    
     
     private static void checkHeaderChecksumRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public Ipv4PacketTypeBuilder setHeaderChecksum(final java.lang.Integer value) {
    if (value != null) {
        checkHeaderChecksumRange(value);
    }
        this._headerChecksum = value;
        return this;
    }
    
     
     private static void checkIdentificationRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public Ipv4PacketTypeBuilder setIdentification(final java.lang.Integer value) {
    if (value != null) {
        checkIdentificationRange(value);
    }
        this._identification = value;
        return this;
    }
    
     
     private static void checkIhlRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public Ipv4PacketTypeBuilder setIhl(final java.lang.Short value) {
    if (value != null) {
        checkIhlRange(value);
    }
        this._ihl = value;
        return this;
    }
    
     
    public Ipv4PacketTypeBuilder setIpv4Options(final byte[] value) {
        this._ipv4Options = value;
        return this;
    }
    
     
     private static void checkProtocolRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public Ipv4PacketTypeBuilder setProtocol(final java.lang.Short value) {
    if (value != null) {
        checkProtocolRange(value);
    }
        this._protocol = value;
        return this;
    }
    
     
    public Ipv4PacketTypeBuilder setSourceAddress(final java.lang.String value) {
        this._sourceAddress = value;
        return this;
    }
    
     
     private static void checkTotalLengthRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public Ipv4PacketTypeBuilder setTotalLength(final java.lang.Integer value) {
    if (value != null) {
        checkTotalLengthRange(value);
    }
        this._totalLength = value;
        return this;
    }
    
     
     private static void checkTtlRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public Ipv4PacketTypeBuilder setTtl(final java.lang.Short value) {
    if (value != null) {
        checkTtlRange(value);
    }
        this._ttl = value;
        return this;
    }
    
     
     private static void checkVersionRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public Ipv4PacketTypeBuilder setVersion(final java.lang.Short value) {
    if (value != null) {
        checkVersionRange(value);
    }
        this._version = value;
        return this;
    }
    
     
    public Ipv4PacketTypeBuilder setDfFlag(final java.lang.Boolean value) {
        this._dfFlag = value;
        return this;
    }
    
     
    public Ipv4PacketTypeBuilder setMfFlag(final java.lang.Boolean value) {
        this._mfFlag = value;
        return this;
    }
    
     
    public Ipv4PacketTypeBuilder setReservedFlag(final java.lang.Boolean value) {
        this._reservedFlag = value;
        return this;
    }
    
    public Ipv4PacketTypeBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public Ipv4PacketTypeBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Ipv4PacketType build() {
        return new Ipv4PacketTypeImpl(this);
    }

    private static final class Ipv4PacketTypeImpl implements Ipv4PacketType {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType.class;
        }

        private final java.lang.String _destinationAddress;
        private final java.lang.Short _dscpValue;
        private final java.lang.Short _ecn;
        private final java.lang.Integer _fragmentOffset;
        private final java.lang.Integer _headerChecksum;
        private final java.lang.Integer _identification;
        private final java.lang.Short _ihl;
        private final byte[] _ipv4Options;
        private final java.lang.Short _protocol;
        private final java.lang.String _sourceAddress;
        private final java.lang.Integer _totalLength;
        private final java.lang.Short _ttl;
        private final java.lang.Short _version;
        private final java.lang.Boolean _dfFlag;
        private final java.lang.Boolean _mfFlag;
        private final java.lang.Boolean _reservedFlag;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>> augmentation = Collections.emptyMap();

        private Ipv4PacketTypeImpl(Ipv4PacketTypeBuilder base) {
            this._destinationAddress = base.getDestinationAddress();
            this._dscpValue = base.getDscpValue();
            this._ecn = base.getEcn();
            this._fragmentOffset = base.getFragmentOffset();
            this._headerChecksum = base.getHeaderChecksum();
            this._identification = base.getIdentification();
            this._ihl = base.getIhl();
            this._ipv4Options = base.getIpv4Options();
            this._protocol = base.getProtocol();
            this._sourceAddress = base.getSourceAddress();
            this._totalLength = base.getTotalLength();
            this._ttl = base.getTtl();
            this._version = base.getVersion();
            this._dfFlag = base.isDfFlag();
            this._mfFlag = base.isMfFlag();
            this._reservedFlag = base.isReservedFlag();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getDestinationAddress() {
            return _destinationAddress;
        }
        
        @Override
        public java.lang.Short getDscpValue() {
            return _dscpValue;
        }
        
        @Override
        public java.lang.Short getEcn() {
            return _ecn;
        }
        
        @Override
        public java.lang.Integer getFragmentOffset() {
            return _fragmentOffset;
        }
        
        @Override
        public java.lang.Integer getHeaderChecksum() {
            return _headerChecksum;
        }
        
        @Override
        public java.lang.Integer getIdentification() {
            return _identification;
        }
        
        @Override
        public java.lang.Short getIhl() {
            return _ihl;
        }
        
        @Override
        public byte[] getIpv4Options() {
            return _ipv4Options == null ? null : _ipv4Options.clone();
        }
        
        @Override
        public java.lang.Short getProtocol() {
            return _protocol;
        }
        
        @Override
        public java.lang.String getSourceAddress() {
            return _sourceAddress;
        }
        
        @Override
        public java.lang.Integer getTotalLength() {
            return _totalLength;
        }
        
        @Override
        public java.lang.Short getTtl() {
            return _ttl;
        }
        
        @Override
        public java.lang.Short getVersion() {
            return _version;
        }
        
        @Override
        public java.lang.Boolean isDfFlag() {
            return _dfFlag;
        }
        
        @Override
        public java.lang.Boolean isMfFlag() {
            return _mfFlag;
        }
        
        @Override
        public java.lang.Boolean isReservedFlag() {
            return _reservedFlag;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_destinationAddress);
            result = prime * result + Objects.hashCode(_dscpValue);
            result = prime * result + Objects.hashCode(_ecn);
            result = prime * result + Objects.hashCode(_fragmentOffset);
            result = prime * result + Objects.hashCode(_headerChecksum);
            result = prime * result + Objects.hashCode(_identification);
            result = prime * result + Objects.hashCode(_ihl);
            result = prime * result + Arrays.hashCode(_ipv4Options);
            result = prime * result + Objects.hashCode(_protocol);
            result = prime * result + Objects.hashCode(_sourceAddress);
            result = prime * result + Objects.hashCode(_totalLength);
            result = prime * result + Objects.hashCode(_ttl);
            result = prime * result + Objects.hashCode(_version);
            result = prime * result + Objects.hashCode(_dfFlag);
            result = prime * result + Objects.hashCode(_mfFlag);
            result = prime * result + Objects.hashCode(_reservedFlag);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType)obj;
            if (!Objects.equals(_destinationAddress, other.getDestinationAddress())) {
                return false;
            }
            if (!Objects.equals(_dscpValue, other.getDscpValue())) {
                return false;
            }
            if (!Objects.equals(_ecn, other.getEcn())) {
                return false;
            }
            if (!Objects.equals(_fragmentOffset, other.getFragmentOffset())) {
                return false;
            }
            if (!Objects.equals(_headerChecksum, other.getHeaderChecksum())) {
                return false;
            }
            if (!Objects.equals(_identification, other.getIdentification())) {
                return false;
            }
            if (!Objects.equals(_ihl, other.getIhl())) {
                return false;
            }
            if (!Arrays.equals(_ipv4Options, other.getIpv4Options())) {
                return false;
            }
            if (!Objects.equals(_protocol, other.getProtocol())) {
                return false;
            }
            if (!Objects.equals(_sourceAddress, other.getSourceAddress())) {
                return false;
            }
            if (!Objects.equals(_totalLength, other.getTotalLength())) {
                return false;
            }
            if (!Objects.equals(_ttl, other.getTtl())) {
                return false;
            }
            if (!Objects.equals(_version, other.getVersion())) {
                return false;
            }
            if (!Objects.equals(_dfFlag, other.isDfFlag())) {
                return false;
            }
            if (!Objects.equals(_mfFlag, other.isMfFlag())) {
                return false;
            }
            if (!Objects.equals(_reservedFlag, other.isReservedFlag())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                Ipv4PacketTypeImpl otherImpl = (Ipv4PacketTypeImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.Ipv4PacketType>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Ipv4PacketType [");
            boolean first = true;
        
            if (_destinationAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_destinationAddress=");
                builder.append(_destinationAddress);
             }
            if (_dscpValue != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dscpValue=");
                builder.append(_dscpValue);
             }
            if (_ecn != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ecn=");
                builder.append(_ecn);
             }
            if (_fragmentOffset != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_fragmentOffset=");
                builder.append(_fragmentOffset);
             }
            if (_headerChecksum != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_headerChecksum=");
                builder.append(_headerChecksum);
             }
            if (_identification != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_identification=");
                builder.append(_identification);
             }
            if (_ihl != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ihl=");
                builder.append(_ihl);
             }
            if (_ipv4Options != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipv4Options=");
                builder.append(Arrays.toString(_ipv4Options));
             }
            if (_protocol != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_protocol=");
                builder.append(_protocol);
             }
            if (_sourceAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sourceAddress=");
                builder.append(_sourceAddress);
             }
            if (_totalLength != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_totalLength=");
                builder.append(_totalLength);
             }
            if (_ttl != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ttl=");
                builder.append(_ttl);
             }
            if (_version != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_version=");
                builder.append(_version);
             }
            if (_dfFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_dfFlag=");
                builder.append(_dfFlag);
             }
            if (_mfFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_mfFlag=");
                builder.append(_mfFlag);
             }
            if (_reservedFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_reservedFlag=");
                builder.append(_reservedFlag);
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
