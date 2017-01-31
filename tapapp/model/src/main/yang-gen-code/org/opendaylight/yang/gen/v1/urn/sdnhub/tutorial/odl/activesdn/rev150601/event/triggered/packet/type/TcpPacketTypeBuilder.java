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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType
 *
 */
public class TcpPacketTypeBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType> {

    private java.lang.Short _destPort;
    private java.lang.String _destinationAddress;
    private java.lang.Short _dscpValue;
    private java.lang.Short _ecn;
    private java.lang.Integer _fragmentOffset;
    private java.lang.Integer _headerChecksum;
    private java.lang.Integer _identification;
    private java.lang.Short _ihl;
    private byte[] _ipv4Options;
    private java.lang.Short _protocol;
    private java.lang.Integer _sequenceNumber;
    private java.lang.String _sourceAddress;
    private java.lang.Short _sourcePort;
    private java.lang.Integer _totalLength;
    private java.lang.Short _ttl;
    private java.lang.Short _version;
    private java.lang.Boolean _ackFlag;
    private java.lang.Boolean _dfFlag;
    private java.lang.Boolean _finFlag;
    private java.lang.Boolean _mfFlag;
    private java.lang.Boolean _reservedFlag;
    private java.lang.Boolean _rstFlag;
    private java.lang.Boolean _synFlag;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>> augmentation = Collections.emptyMap();

    public TcpPacketTypeBuilder() {
    }
    public TcpPacketTypeBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields arg) {
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
    public TcpPacketTypeBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields arg) {
        this._sourcePort = arg.getSourcePort();
        this._destPort = arg.getDestPort();
        this._sequenceNumber = arg.getSequenceNumber();
        this._synFlag = arg.isSynFlag();
        this._rstFlag = arg.isRstFlag();
        this._ackFlag = arg.isAckFlag();
        this._finFlag = arg.isFinFlag();
    }

    public TcpPacketTypeBuilder(TcpPacketType base) {
        this._destPort = base.getDestPort();
        this._destinationAddress = base.getDestinationAddress();
        this._dscpValue = base.getDscpValue();
        this._ecn = base.getEcn();
        this._fragmentOffset = base.getFragmentOffset();
        this._headerChecksum = base.getHeaderChecksum();
        this._identification = base.getIdentification();
        this._ihl = base.getIhl();
        this._ipv4Options = base.getIpv4Options();
        this._protocol = base.getProtocol();
        this._sequenceNumber = base.getSequenceNumber();
        this._sourceAddress = base.getSourceAddress();
        this._sourcePort = base.getSourcePort();
        this._totalLength = base.getTotalLength();
        this._ttl = base.getTtl();
        this._version = base.getVersion();
        this._ackFlag = base.isAckFlag();
        this._dfFlag = base.isDfFlag();
        this._finFlag = base.isFinFlag();
        this._mfFlag = base.isMfFlag();
        this._reservedFlag = base.isReservedFlag();
        this._rstFlag = base.isRstFlag();
        this._synFlag = base.isSynFlag();
        if (base instanceof TcpPacketTypeImpl) {
            TcpPacketTypeImpl impl = (TcpPacketTypeImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields</li>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields</li>
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
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields) {
            this._sourcePort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields)arg).getSourcePort();
            this._destPort = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields)arg).getDestPort();
            this._sequenceNumber = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields)arg).getSequenceNumber();
            this._synFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields)arg).isSynFlag();
            this._rstFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields)arg).isRstFlag();
            this._ackFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields)arg).isAckFlag();
            this._finFlag = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields)arg).isFinFlag();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields, org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.TcpPacketHeaderFields] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.Short getDestPort() {
        return _destPort;
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
    
    public java.lang.Integer getSequenceNumber() {
        return _sequenceNumber;
    }
    
    public java.lang.String getSourceAddress() {
        return _sourceAddress;
    }
    
    public java.lang.Short getSourcePort() {
        return _sourcePort;
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
    
    public java.lang.Boolean isAckFlag() {
        return _ackFlag;
    }
    
    public java.lang.Boolean isDfFlag() {
        return _dfFlag;
    }
    
    public java.lang.Boolean isFinFlag() {
        return _finFlag;
    }
    
    public java.lang.Boolean isMfFlag() {
        return _mfFlag;
    }
    
    public java.lang.Boolean isReservedFlag() {
        return _reservedFlag;
    }
    
    public java.lang.Boolean isRstFlag() {
        return _rstFlag;
    }
    
    public java.lang.Boolean isSynFlag() {
        return _synFlag;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public TcpPacketTypeBuilder setDestPort(final java.lang.Short value) {
        this._destPort = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setDestinationAddress(final java.lang.String value) {
        this._destinationAddress = value;
        return this;
    }
    
     
     private static void checkDscpValueRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public TcpPacketTypeBuilder setDscpValue(final java.lang.Short value) {
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
    
    public TcpPacketTypeBuilder setEcn(final java.lang.Short value) {
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
    
    public TcpPacketTypeBuilder setFragmentOffset(final java.lang.Integer value) {
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
    
    public TcpPacketTypeBuilder setHeaderChecksum(final java.lang.Integer value) {
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
    
    public TcpPacketTypeBuilder setIdentification(final java.lang.Integer value) {
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
    
    public TcpPacketTypeBuilder setIhl(final java.lang.Short value) {
    if (value != null) {
        checkIhlRange(value);
    }
        this._ihl = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setIpv4Options(final byte[] value) {
        this._ipv4Options = value;
        return this;
    }
    
     
     private static void checkProtocolRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public TcpPacketTypeBuilder setProtocol(final java.lang.Short value) {
    if (value != null) {
        checkProtocolRange(value);
    }
        this._protocol = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setSequenceNumber(final java.lang.Integer value) {
        this._sequenceNumber = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setSourceAddress(final java.lang.String value) {
        this._sourceAddress = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setSourcePort(final java.lang.Short value) {
        this._sourcePort = value;
        return this;
    }
    
     
     private static void checkTotalLengthRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public TcpPacketTypeBuilder setTotalLength(final java.lang.Integer value) {
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
    
    public TcpPacketTypeBuilder setTtl(final java.lang.Short value) {
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
    
    public TcpPacketTypeBuilder setVersion(final java.lang.Short value) {
    if (value != null) {
        checkVersionRange(value);
    }
        this._version = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setAckFlag(final java.lang.Boolean value) {
        this._ackFlag = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setDfFlag(final java.lang.Boolean value) {
        this._dfFlag = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setFinFlag(final java.lang.Boolean value) {
        this._finFlag = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setMfFlag(final java.lang.Boolean value) {
        this._mfFlag = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setReservedFlag(final java.lang.Boolean value) {
        this._reservedFlag = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setRstFlag(final java.lang.Boolean value) {
        this._rstFlag = value;
        return this;
    }
    
     
    public TcpPacketTypeBuilder setSynFlag(final java.lang.Boolean value) {
        this._synFlag = value;
        return this;
    }
    
    public TcpPacketTypeBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public TcpPacketTypeBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public TcpPacketType build() {
        return new TcpPacketTypeImpl(this);
    }

    private static final class TcpPacketTypeImpl implements TcpPacketType {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType.class;
        }

        private final java.lang.Short _destPort;
        private final java.lang.String _destinationAddress;
        private final java.lang.Short _dscpValue;
        private final java.lang.Short _ecn;
        private final java.lang.Integer _fragmentOffset;
        private final java.lang.Integer _headerChecksum;
        private final java.lang.Integer _identification;
        private final java.lang.Short _ihl;
        private final byte[] _ipv4Options;
        private final java.lang.Short _protocol;
        private final java.lang.Integer _sequenceNumber;
        private final java.lang.String _sourceAddress;
        private final java.lang.Short _sourcePort;
        private final java.lang.Integer _totalLength;
        private final java.lang.Short _ttl;
        private final java.lang.Short _version;
        private final java.lang.Boolean _ackFlag;
        private final java.lang.Boolean _dfFlag;
        private final java.lang.Boolean _finFlag;
        private final java.lang.Boolean _mfFlag;
        private final java.lang.Boolean _reservedFlag;
        private final java.lang.Boolean _rstFlag;
        private final java.lang.Boolean _synFlag;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>> augmentation = Collections.emptyMap();

        private TcpPacketTypeImpl(TcpPacketTypeBuilder base) {
            this._destPort = base.getDestPort();
            this._destinationAddress = base.getDestinationAddress();
            this._dscpValue = base.getDscpValue();
            this._ecn = base.getEcn();
            this._fragmentOffset = base.getFragmentOffset();
            this._headerChecksum = base.getHeaderChecksum();
            this._identification = base.getIdentification();
            this._ihl = base.getIhl();
            this._ipv4Options = base.getIpv4Options();
            this._protocol = base.getProtocol();
            this._sequenceNumber = base.getSequenceNumber();
            this._sourceAddress = base.getSourceAddress();
            this._sourcePort = base.getSourcePort();
            this._totalLength = base.getTotalLength();
            this._ttl = base.getTtl();
            this._version = base.getVersion();
            this._ackFlag = base.isAckFlag();
            this._dfFlag = base.isDfFlag();
            this._finFlag = base.isFinFlag();
            this._mfFlag = base.isMfFlag();
            this._reservedFlag = base.isReservedFlag();
            this._rstFlag = base.isRstFlag();
            this._synFlag = base.isSynFlag();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Short getDestPort() {
            return _destPort;
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
        public java.lang.Integer getSequenceNumber() {
            return _sequenceNumber;
        }
        
        @Override
        public java.lang.String getSourceAddress() {
            return _sourceAddress;
        }
        
        @Override
        public java.lang.Short getSourcePort() {
            return _sourcePort;
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
        public java.lang.Boolean isAckFlag() {
            return _ackFlag;
        }
        
        @Override
        public java.lang.Boolean isDfFlag() {
            return _dfFlag;
        }
        
        @Override
        public java.lang.Boolean isFinFlag() {
            return _finFlag;
        }
        
        @Override
        public java.lang.Boolean isMfFlag() {
            return _mfFlag;
        }
        
        @Override
        public java.lang.Boolean isReservedFlag() {
            return _reservedFlag;
        }
        
        @Override
        public java.lang.Boolean isRstFlag() {
            return _rstFlag;
        }
        
        @Override
        public java.lang.Boolean isSynFlag() {
            return _synFlag;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_destPort);
            result = prime * result + Objects.hashCode(_destinationAddress);
            result = prime * result + Objects.hashCode(_dscpValue);
            result = prime * result + Objects.hashCode(_ecn);
            result = prime * result + Objects.hashCode(_fragmentOffset);
            result = prime * result + Objects.hashCode(_headerChecksum);
            result = prime * result + Objects.hashCode(_identification);
            result = prime * result + Objects.hashCode(_ihl);
            result = prime * result + Arrays.hashCode(_ipv4Options);
            result = prime * result + Objects.hashCode(_protocol);
            result = prime * result + Objects.hashCode(_sequenceNumber);
            result = prime * result + Objects.hashCode(_sourceAddress);
            result = prime * result + Objects.hashCode(_sourcePort);
            result = prime * result + Objects.hashCode(_totalLength);
            result = prime * result + Objects.hashCode(_ttl);
            result = prime * result + Objects.hashCode(_version);
            result = prime * result + Objects.hashCode(_ackFlag);
            result = prime * result + Objects.hashCode(_dfFlag);
            result = prime * result + Objects.hashCode(_finFlag);
            result = prime * result + Objects.hashCode(_mfFlag);
            result = prime * result + Objects.hashCode(_reservedFlag);
            result = prime * result + Objects.hashCode(_rstFlag);
            result = prime * result + Objects.hashCode(_synFlag);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType)obj;
            if (!Objects.equals(_destPort, other.getDestPort())) {
                return false;
            }
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
            if (!Objects.equals(_sequenceNumber, other.getSequenceNumber())) {
                return false;
            }
            if (!Objects.equals(_sourceAddress, other.getSourceAddress())) {
                return false;
            }
            if (!Objects.equals(_sourcePort, other.getSourcePort())) {
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
            if (!Objects.equals(_ackFlag, other.isAckFlag())) {
                return false;
            }
            if (!Objects.equals(_dfFlag, other.isDfFlag())) {
                return false;
            }
            if (!Objects.equals(_finFlag, other.isFinFlag())) {
                return false;
            }
            if (!Objects.equals(_mfFlag, other.isMfFlag())) {
                return false;
            }
            if (!Objects.equals(_reservedFlag, other.isReservedFlag())) {
                return false;
            }
            if (!Objects.equals(_rstFlag, other.isRstFlag())) {
                return false;
            }
            if (!Objects.equals(_synFlag, other.isSynFlag())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                TcpPacketTypeImpl otherImpl = (TcpPacketTypeImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.TcpPacketType>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("TcpPacketType [");
            boolean first = true;
        
            if (_destPort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_destPort=");
                builder.append(_destPort);
             }
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
            if (_sequenceNumber != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sequenceNumber=");
                builder.append(_sequenceNumber);
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
            if (_sourcePort != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_sourcePort=");
                builder.append(_sourcePort);
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
            if (_ackFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ackFlag=");
                builder.append(_ackFlag);
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
            if (_finFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_finFlag=");
                builder.append(_finFlag);
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
            if (_rstFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_rstFlag=");
                builder.append(_rstFlag);
             }
            if (_synFlag != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_synFlag=");
                builder.append(_synFlag);
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
