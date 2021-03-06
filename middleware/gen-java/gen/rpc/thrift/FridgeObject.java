/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package gen.rpc.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-04-26")
public class FridgeObject implements org.apache.thrift.TBase<FridgeObject, FridgeObject._Fields>, java.io.Serializable, Cloneable, Comparable<FridgeObject> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FridgeObject");

  private static final org.apache.thrift.protocol.TField DEVICE_FIELD_DESC = new org.apache.thrift.protocol.TField("device", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField FRIDGE_STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("fridgeState", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FridgeObjectStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FridgeObjectTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable DeviceObject device; // required
  public @org.apache.thrift.annotation.Nullable FridgeState fridgeState; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DEVICE((short)1, "device"),
    FRIDGE_STATE((short)2, "fridgeState");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DEVICE
          return DEVICE;
        case 2: // FRIDGE_STATE
          return FRIDGE_STATE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DEVICE, new org.apache.thrift.meta_data.FieldMetaData("device", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, DeviceObject.class)));
    tmpMap.put(_Fields.FRIDGE_STATE, new org.apache.thrift.meta_data.FieldMetaData("fridgeState", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FridgeState.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FridgeObject.class, metaDataMap);
  }

  public FridgeObject() {
  }

  public FridgeObject(
    DeviceObject device,
    FridgeState fridgeState)
  {
    this();
    this.device = device;
    this.fridgeState = fridgeState;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FridgeObject(FridgeObject other) {
    if (other.isSetDevice()) {
      this.device = new DeviceObject(other.device);
    }
    if (other.isSetFridgeState()) {
      this.fridgeState = new FridgeState(other.fridgeState);
    }
  }

  public FridgeObject deepCopy() {
    return new FridgeObject(this);
  }

  @Override
  public void clear() {
    this.device = null;
    this.fridgeState = null;
  }

  @org.apache.thrift.annotation.Nullable
  public DeviceObject getDevice() {
    return this.device;
  }

  public FridgeObject setDevice(@org.apache.thrift.annotation.Nullable DeviceObject device) {
    this.device = device;
    return this;
  }

  public void unsetDevice() {
    this.device = null;
  }

  /** Returns true if field device is set (has been assigned a value) and false otherwise */
  public boolean isSetDevice() {
    return this.device != null;
  }

  public void setDeviceIsSet(boolean value) {
    if (!value) {
      this.device = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public FridgeState getFridgeState() {
    return this.fridgeState;
  }

  public FridgeObject setFridgeState(@org.apache.thrift.annotation.Nullable FridgeState fridgeState) {
    this.fridgeState = fridgeState;
    return this;
  }

  public void unsetFridgeState() {
    this.fridgeState = null;
  }

  /** Returns true if field fridgeState is set (has been assigned a value) and false otherwise */
  public boolean isSetFridgeState() {
    return this.fridgeState != null;
  }

  public void setFridgeStateIsSet(boolean value) {
    if (!value) {
      this.fridgeState = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DEVICE:
      if (value == null) {
        unsetDevice();
      } else {
        setDevice((DeviceObject)value);
      }
      break;

    case FRIDGE_STATE:
      if (value == null) {
        unsetFridgeState();
      } else {
        setFridgeState((FridgeState)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DEVICE:
      return getDevice();

    case FRIDGE_STATE:
      return getFridgeState();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case DEVICE:
      return isSetDevice();
    case FRIDGE_STATE:
      return isSetFridgeState();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof FridgeObject)
      return this.equals((FridgeObject)that);
    return false;
  }

  public boolean equals(FridgeObject that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_device = true && this.isSetDevice();
    boolean that_present_device = true && that.isSetDevice();
    if (this_present_device || that_present_device) {
      if (!(this_present_device && that_present_device))
        return false;
      if (!this.device.equals(that.device))
        return false;
    }

    boolean this_present_fridgeState = true && this.isSetFridgeState();
    boolean that_present_fridgeState = true && that.isSetFridgeState();
    if (this_present_fridgeState || that_present_fridgeState) {
      if (!(this_present_fridgeState && that_present_fridgeState))
        return false;
      if (!this.fridgeState.equals(that.fridgeState))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDevice()) ? 131071 : 524287);
    if (isSetDevice())
      hashCode = hashCode * 8191 + device.hashCode();

    hashCode = hashCode * 8191 + ((isSetFridgeState()) ? 131071 : 524287);
    if (isSetFridgeState())
      hashCode = hashCode * 8191 + fridgeState.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(FridgeObject other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetDevice()).compareTo(other.isSetDevice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDevice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.device, other.device);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFridgeState()).compareTo(other.isSetFridgeState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFridgeState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fridgeState, other.fridgeState);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("FridgeObject(");
    boolean first = true;

    sb.append("device:");
    if (this.device == null) {
      sb.append("null");
    } else {
      sb.append(this.device);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fridgeState:");
    if (this.fridgeState == null) {
      sb.append("null");
    } else {
      sb.append(this.fridgeState);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (device != null) {
      device.validate();
    }
    if (fridgeState != null) {
      fridgeState.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FridgeObjectStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FridgeObjectStandardScheme getScheme() {
      return new FridgeObjectStandardScheme();
    }
  }

  private static class FridgeObjectStandardScheme extends org.apache.thrift.scheme.StandardScheme<FridgeObject> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FridgeObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DEVICE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.device = new DeviceObject();
              struct.device.read(iprot);
              struct.setDeviceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FRIDGE_STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.fridgeState = new FridgeState();
              struct.fridgeState.read(iprot);
              struct.setFridgeStateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, FridgeObject struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.device != null) {
        oprot.writeFieldBegin(DEVICE_FIELD_DESC);
        struct.device.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.fridgeState != null) {
        oprot.writeFieldBegin(FRIDGE_STATE_FIELD_DESC);
        struct.fridgeState.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FridgeObjectTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FridgeObjectTupleScheme getScheme() {
      return new FridgeObjectTupleScheme();
    }
  }

  private static class FridgeObjectTupleScheme extends org.apache.thrift.scheme.TupleScheme<FridgeObject> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FridgeObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDevice()) {
        optionals.set(0);
      }
      if (struct.isSetFridgeState()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetDevice()) {
        struct.device.write(oprot);
      }
      if (struct.isSetFridgeState()) {
        struct.fridgeState.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FridgeObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.device = new DeviceObject();
        struct.device.read(iprot);
        struct.setDeviceIsSet(true);
      }
      if (incoming.get(1)) {
        struct.fridgeState = new FridgeState();
        struct.fridgeState.read(iprot);
        struct.setFridgeStateIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

