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
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType
 *
 */
public class IcmpPacketTypeBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType> {

    private java.lang.Short _code;
    private java.lang.Integer _crc;
    private java.lang.String _destinationAddress;
    private java.lang.Short _dscpValue;
    private java.lang.Short _ecn;
    private java.lang.String _ethernetSrcMacAddress;
    private java.lang.String _ethernetType;
    private java.lang.Integer _fragmentOffset;
    private java.lang.Integer _headerChecksum;
    private java.lang.Integer _icmpPayloadLength;
    private java.lang.Integer _icmpPayloadOffset;
    private java.lang.Integer _identification;
    private java.lang.Integer _identifier;
    private java.lang.Short _ihl;
    private byte[] _ipv4Options;
    private java.lang.Short _protocol;
    private java.lang.Integer _sequenceNumber;
    private java.lang.String _sourceAddress;
    private java.lang.Integer _totalLength;
    private java.lang.Short _ttl;
    private java.lang.Short _type;
    private java.lang.Short _version;
    private java.lang.Boolean _dfFlag;
    private java.lang.Boolean _mfFlag;
    private java.lang.Boolean _reservedFlag;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>> augmentation = Collections.emptyMap();

    public IcmpPacketTypeBuilder() {
    }
    public IcmpPacketTypeBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields arg) {
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
    public IcmpPacketTypeBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields arg) {
        this._ethernetSrcMacAddress = arg.getEthernetSrcMacAddress();
        this._ethernetType = arg.getEthernetType();
        this._type = arg.getType();
        this._code = arg.getCode();
        this._crc = arg.getCrc();
        this._identifier = arg.getIdentifier();
        this._sequenceNumber = arg.getSequenceNumber();
    }

    public IcmpPacketTypeBuilder(IcmpPacketType base) {
        this._code = base.getCode();
        this._crc = base.getCrc();
        this._destinationAddress = base.getDestinationAddress();
        this._dscpValue = base.getDscpValue();
        this._ecn = base.getEcn();
        this._ethernetSrcMacAddress = base.getEthernetSrcMacAddress();
        this._ethernetType = base.getEthernetType();
        this._fragmentOffset = base.getFragmentOffset();
        this._headerChecksum = base.getHeaderChecksum();
        this._icmpPayloadLength = base.getIcmpPayloadLength();
        this._icmpPayloadOffset = base.getIcmpPayloadOffset();
        this._identification = base.getIdentification();
        this._identifier = base.getIdentifier();
        this._ihl = base.getIhl();
        this._ipv4Options = base.getIpv4Options();
        this._protocol = base.getProtocol();
        this._sequenceNumber = base.getSequenceNumber();
        this._sourceAddress = base.getSourceAddress();
        this._totalLength = base.getTotalLength();
        this._ttl = base.getTtl();
        this._type = base.getType();
        this._version = base.getVersion();
        this._dfFlag = base.isDfFlag();
        this._mfFlag = base.isMfFlag();
        this._reservedFlag = base.isReservedFlag();
        if (base instanceof IcmpPacketTypeImpl) {
            IcmpPacketTypeImpl impl = (IcmpPacketTypeImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields</li>
     * <li>org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields</li>
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
        if (arg instanceof org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields) {
            this._ethernetSrcMacAddress = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields)arg).getEthernetSrcMacAddress();
            this._ethernetType = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields)arg).getEthernetType();
            this._type = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields)arg).getType();
            this._code = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields)arg).getCode();
            this._crc = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields)arg).getCrc();
            this._identifier = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields)arg).getIdentifier();
            this._sequenceNumber = ((org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields)arg).getSequenceNumber();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.Ipv4PacketHeaderFields, org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.IcmpPacketHeaderFields] \n" +
              "but was: " + arg
            );
        }
    }

    public java.lang.Short getCode() {
        return _code;
    }
    
    public java.lang.Integer getCrc() {
        return _crc;
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
    
    public java.lang.String getEthernetSrcMacAddress() {
        return _ethernetSrcMacAddress;
    }
    
    public java.lang.String getEthernetType() {
        return _ethernetType;
    }
    
    public java.lang.Integer getFragmentOffset() {
        return _fragmentOffset;
    }
    
    public java.lang.Integer getHeaderChecksum() {
        return _headerChecksum;
    }
    
    public java.lang.Integer getIcmpPayloadLength() {
        return _icmpPayloadLength;
    }
    
    public java.lang.Integer getIcmpPayloadOffset() {
        return _icmpPayloadOffset;
    }
    
    public java.lang.Integer getIdentification() {
        return _identification;
    }
    
    public java.lang.Integer getIdentifier() {
        return _identifier;
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
    
    public java.lang.Integer getTotalLength() {
        return _totalLength;
    }
    
    public java.lang.Short getTtl() {
        return _ttl;
    }
    
    public java.lang.Short getType() {
        return _type;
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
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkCodeRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public IcmpPacketTypeBuilder setCode(final java.lang.Short value) {
    if (value != null) {
        checkCodeRange(value);
    }
        this._code = value;
        return this;
    }
    
     
     private static void checkCrcRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketTypeBuilder setCrc(final java.lang.Integer value) {
    if (value != null) {
        checkCrcRange(value);
    }
        this._crc = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setDestinationAddress(final java.lang.String value) {
        this._destinationAddress = value;
        return this;
    }
    
     
     private static void checkDscpValueRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public IcmpPacketTypeBuilder setDscpValue(final java.lang.Short value) {
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
    
    public IcmpPacketTypeBuilder setEcn(final java.lang.Short value) {
    if (value != null) {
        checkEcnRange(value);
    }
        this._ecn = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setEthernetSrcMacAddress(final java.lang.String value) {
        this._ethernetSrcMacAddress = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setEthernetType(final java.lang.String value) {
        this._ethernetType = value;
        return this;
    }
    
     
     private static void checkFragmentOffsetRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketTypeBuilder setFragmentOffset(final java.lang.Integer value) {
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
    
    public IcmpPacketTypeBuilder setHeaderChecksum(final java.lang.Integer value) {
    if (value != null) {
        checkHeaderChecksumRange(value);
    }
        this._headerChecksum = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setIcmpPayloadLength(final java.lang.Integer value) {
        this._icmpPayloadLength = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setIcmpPayloadOffset(final java.lang.Integer value) {
        this._icmpPayloadOffset = value;
        return this;
    }
    
     
     private static void checkIdentificationRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketTypeBuilder setIdentification(final java.lang.Integer value) {
    if (value != null) {
        checkIdentificationRange(value);
    }
        this._identification = value;
        return this;
    }
    
     
     private static void checkIdentifierRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketTypeBuilder setIdentifier(final java.lang.Integer value) {
    if (value != null) {
        checkIdentifierRange(value);
    }
        this._identifier = value;
        return this;
    }
    
     
     private static void checkIhlRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public IcmpPacketTypeBuilder setIhl(final java.lang.Short value) {
    if (value != null) {
        checkIhlRange(value);
    }
        this._ihl = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setIpv4Options(final byte[] value) {
        this._ipv4Options = value;
        return this;
    }
    
     
     private static void checkProtocolRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public IcmpPacketTypeBuilder setProtocol(final java.lang.Short value) {
    if (value != null) {
        checkProtocolRange(value);
    }
        this._protocol = value;
        return this;
    }
    
     
     private static void checkSequenceNumberRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketTypeBuilder setSequenceNumber(final java.lang.Integer value) {
    if (value != null) {
        checkSequenceNumberRange(value);
    }
        this._sequenceNumber = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setSourceAddress(final java.lang.String value) {
        this._sourceAddress = value;
        return this;
    }
    
     
     private static void checkTotalLengthRange(final int value) {
         if (value >= 0 && value <= 65535) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥65535]].", value));
     }
    
    public IcmpPacketTypeBuilder setTotalLength(final java.lang.Integer value) {
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
    
    public IcmpPacketTypeBuilder setTtl(final java.lang.Short value) {
    if (value != null) {
        checkTtlRange(value);
    }
        this._ttl = value;
        return this;
    }
    
     
     private static void checkTypeRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public IcmpPacketTypeBuilder setType(final java.lang.Short value) {
    if (value != null) {
        checkTypeRange(value);
    }
        this._type = value;
        return this;
    }
    
     
     private static void checkVersionRange(final short value) {
         if (value >= (short)0 && value <= (short)255) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥255]].", value));
     }
    
    public IcmpPacketTypeBuilder setVersion(final java.lang.Short value) {
    if (value != null) {
        checkVersionRange(value);
    }
        this._version = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setDfFlag(final java.lang.Boolean value) {
        this._dfFlag = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setMfFlag(final java.lang.Boolean value) {
        this._mfFlag = value;
        return this;
    }
    
     
    public IcmpPacketTypeBuilder setReservedFlag(final java.lang.Boolean value) {
        this._reservedFlag = value;
        return this;
    }
    
    public IcmpPacketTypeBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public IcmpPacketTypeBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public IcmpPacketType build() {
        return new IcmpPacketTypeImpl(this);
    }

    private static final class IcmpPacketTypeImpl implements IcmpPacketType {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType.class;
        }

        private final java.lang.Short _code;
        private final java.lang.Integer _crc;
        private final java.lang.String _destinationAddress;
        private final java.lang.Short _dscpValue;
        private final java.lang.Short _ecn;
        private final java.lang.String _ethernetSrcMacAddress;
        private final java.lang.String _ethernetType;
        private final java.lang.Integer _fragmentOffset;
        private final java.lang.Integer _headerChecksum;
        private final java.lang.Integer _icmpPayloadLength;
        private final java.lang.Integer _icmpPayloadOffset;
        private final java.lang.Integer _identification;
        private final java.lang.Integer _identifier;
        private final java.lang.Short _ihl;
        private final byte[] _ipv4Options;
        private final java.lang.Short _protocol;
        private final java.lang.Integer _sequenceNumber;
        private final java.lang.String _sourceAddress;
        private final java.lang.Integer _totalLength;
        private final java.lang.Short _ttl;
        private final java.lang.Short _type;
        private final java.lang.Short _version;
        private final java.lang.Boolean _dfFlag;
        private final java.lang.Boolean _mfFlag;
        private final java.lang.Boolean _reservedFlag;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>> augmentation = Collections.emptyMap();

        private IcmpPacketTypeImpl(IcmpPacketTypeBuilder base) {
            this._code = base.getCode();
            this._crc = base.getCrc();
            this._destinationAddress = base.getDestinationAddress();
            this._dscpValue = base.getDscpValue();
            this._ecn = base.getEcn();
            this._ethernetSrcMacAddress = base.getEthernetSrcMacAddress();
            this._ethernetType = base.getEthernetType();
            this._fragmentOffset = base.getFragmentOffset();
            this._headerChecksum = base.getHeaderChecksum();
            this._icmpPayloadLength = base.getIcmpPayloadLength();
            this._icmpPayloadOffset = base.getIcmpPayloadOffset();
            this._identification = base.getIdentification();
            this._identifier = base.getIdentifier();
            this._ihl = base.getIhl();
            this._ipv4Options = base.getIpv4Options();
            this._protocol = base.getProtocol();
            this._sequenceNumber = base.getSequenceNumber();
            this._sourceAddress = base.getSourceAddress();
            this._totalLength = base.getTotalLength();
            this._ttl = base.getTtl();
            this._type = base.getType();
            this._version = base.getVersion();
            this._dfFlag = base.isDfFlag();
            this._mfFlag = base.isMfFlag();
            this._reservedFlag = base.isReservedFlag();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Short getCode() {
            return _code;
        }
        
        @Override
        public java.lang.Integer getCrc() {
            return _crc;
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
        public java.lang.String getEthernetSrcMacAddress() {
            return _ethernetSrcMacAddress;
        }
        
        @Override
        public java.lang.String getEthernetType() {
            return _ethernetType;
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
        public java.lang.Integer getIcmpPayloadLength() {
            return _icmpPayloadLength;
        }
        
        @Override
        public java.lang.Integer getIcmpPayloadOffset() {
            return _icmpPayloadOffset;
        }
        
        @Override
        public java.lang.Integer getIdentification() {
            return _identification;
        }
        
        @Override
        public java.lang.Integer getIdentifier() {
            return _identifier;
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
        public java.lang.Integer getTotalLength() {
            return _totalLength;
        }
        
        @Override
        public java.lang.Short getTtl() {
            return _ttl;
        }
        
        @Override
        public java.lang.Short getType() {
            return _type;
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
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_code);
            result = prime * result + Objects.hashCode(_crc);
            result = prime * result + Objects.hashCode(_destinationAddress);
            result = prime * result + Objects.hashCode(_dscpValue);
            result = prime * result + Objects.hashCode(_ecn);
            result = prime * result + Objects.hashCode(_ethernetSrcMacAddress);
            result = prime * result + Objects.hashCode(_ethernetType);
            result = prime * result + Objects.hashCode(_fragmentOffset);
            result = prime * result + Objects.hashCode(_headerChecksum);
            result = prime * result + Objects.hashCode(_icmpPayloadLength);
            result = prime * result + Objects.hashCode(_icmpPayloadOffset);
            result = prime * result + Objects.hashCode(_identification);
            result = prime * result + Objects.hashCode(_identifier);
            result = prime * result + Objects.hashCode(_ihl);
            result = prime * result + Arrays.hashCode(_ipv4Options);
            result = prime * result + Objects.hashCode(_protocol);
            result = prime * result + Objects.hashCode(_sequenceNumber);
            result = prime * result + Objects.hashCode(_sourceAddress);
            result = prime * result + Objects.hashCode(_totalLength);
            result = prime * result + Objects.hashCode(_ttl);
            result = prime * result + Objects.hashCode(_type);
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
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType other = (org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType)obj;
            if (!Objects.equals(_code, other.getCode())) {
                return false;
            }
            if (!Objects.equals(_crc, other.getCrc())) {
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
            if (!Objects.equals(_ethernetSrcMacAddress, other.getEthernetSrcMacAddress())) {
                return false;
            }
            if (!Objects.equals(_ethernetType, other.getEthernetType())) {
                return false;
            }
            if (!Objects.equals(_fragmentOffset, other.getFragmentOffset())) {
                return false;
            }
            if (!Objects.equals(_headerChecksum, other.getHeaderChecksum())) {
                return false;
            }
            if (!Objects.equals(_icmpPayloadLength, other.getIcmpPayloadLength())) {
                return false;
            }
            if (!Objects.equals(_icmpPayloadOffset, other.getIcmpPayloadOffset())) {
                return false;
            }
            if (!Objects.equals(_identification, other.getIdentification())) {
                return false;
            }
            if (!Objects.equals(_identifier, other.getIdentifier())) {
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
            if (!Objects.equals(_totalLength, other.getTotalLength())) {
                return false;
            }
            if (!Objects.equals(_ttl, other.getTtl())) {
                return false;
            }
            if (!Objects.equals(_type, other.getType())) {
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
                IcmpPacketTypeImpl otherImpl = (IcmpPacketTypeImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.tutorial.odl.activesdn.rev150601.event.triggered.packet.type.IcmpPacketType>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("IcmpPacketType [");
            boolean first = true;
        
            if (_code != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_code=");
                builder.append(_code);
             }
            if (_crc != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_crc=");
                builder.append(_crc);
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
            if (_ethernetSrcMacAddress != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ethernetSrcMacAddress=");
                builder.append(_ethernetSrcMacAddress);
             }
            if (_ethernetType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ethernetType=");
                builder.append(_ethernetType);
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
            if (_icmpPayloadLength != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_icmpPayloadLength=");
                builder.append(_icmpPayloadLength);
             }
            if (_icmpPayloadOffset != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_icmpPayloadOffset=");
                builder.append(_icmpPayloadOffset);
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
            if (_identifier != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_identifier=");
                builder.append(_identifier);
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
            if (_type != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_type=");
                builder.append(_type);
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
