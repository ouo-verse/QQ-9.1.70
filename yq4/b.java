package yq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f451026a;

    /* renamed from: b, reason: collision with root package name */
    public long f451027b;

    /* renamed from: c, reason: collision with root package name */
    public int f451028c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f451029d;

    /* renamed from: e, reason: collision with root package name */
    public String f451030e;

    /* renamed from: f, reason: collision with root package name */
    public long f451031f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f451032g;

    public b() {
        a();
    }

    public b a() {
        this.f451026a = false;
        this.f451027b = 0L;
        this.f451028c = 0;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f451029d = strArr;
        this.f451030e = "";
        this.f451031f = 0L;
        this.f451032g = strArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                                            String[] strArr = this.f451032g;
                                            if (strArr == null) {
                                                length = 0;
                                            } else {
                                                length = strArr.length;
                                            }
                                            int i3 = repeatedFieldArrayLength + length;
                                            String[] strArr2 = new String[i3];
                                            if (length != 0) {
                                                System.arraycopy(strArr, 0, strArr2, 0, length);
                                            }
                                            while (length < i3 - 1) {
                                                strArr2[length] = codedInputByteBufferNano.readString();
                                                codedInputByteBufferNano.readTag();
                                                length++;
                                            }
                                            strArr2[length] = codedInputByteBufferNano.readString();
                                            this.f451032g = strArr2;
                                        }
                                    } else {
                                        this.f451031f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f451030e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                String[] strArr3 = this.f451029d;
                                if (strArr3 == null) {
                                    length2 = 0;
                                } else {
                                    length2 = strArr3.length;
                                }
                                int i16 = repeatedFieldArrayLength2 + length2;
                                String[] strArr4 = new String[i16];
                                if (length2 != 0) {
                                    System.arraycopy(strArr3, 0, strArr4, 0, length2);
                                }
                                while (length2 < i16 - 1) {
                                    strArr4[length2] = codedInputByteBufferNano.readString();
                                    codedInputByteBufferNano.readTag();
                                    length2++;
                                }
                                strArr4[length2] = codedInputByteBufferNano.readString();
                                this.f451029d = strArr4;
                            }
                        } else {
                            this.f451028c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f451027b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f451026a = codedInputByteBufferNano.readBool();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f451026a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        long j3 = this.f451027b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.f451028c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        String[] strArr = this.f451029d;
        int i16 = 0;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                String[] strArr2 = this.f451029d;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    i19++;
                    i18 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (i19 * 1);
        }
        if (!this.f451030e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f451030e);
        }
        long j16 = this.f451031f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        String[] strArr3 = this.f451032g;
        if (strArr3 != null && strArr3.length > 0) {
            int i26 = 0;
            int i27 = 0;
            while (true) {
                String[] strArr4 = this.f451032g;
                if (i16 < strArr4.length) {
                    String str2 = strArr4[i16];
                    if (str2 != null) {
                        i27++;
                        i26 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                    }
                    i16++;
                } else {
                    return computeSerializedSize + i26 + (i27 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f451026a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        long j3 = this.f451027b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.f451028c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        String[] strArr = this.f451029d;
        int i16 = 0;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f451029d;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i17++;
            }
        }
        if (!this.f451030e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451030e);
        }
        long j16 = this.f451031f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        String[] strArr3 = this.f451032g;
        if (strArr3 != null && strArr3.length > 0) {
            while (true) {
                String[] strArr4 = this.f451032g;
                if (i16 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i16];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(7, str2);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
