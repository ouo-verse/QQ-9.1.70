package yq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f451019a;

    /* renamed from: b, reason: collision with root package name */
    public long f451020b;

    /* renamed from: c, reason: collision with root package name */
    public String f451021c;

    /* renamed from: d, reason: collision with root package name */
    public String f451022d;

    /* renamed from: e, reason: collision with root package name */
    public String f451023e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f451024f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f451025g;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f451019a = 0L;
        this.f451020b = 0L;
        this.f451021c = "";
        this.f451022d = "";
        this.f451023e = "";
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f451024f = strArr;
        this.f451025g = strArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                                            String[] strArr = this.f451025g;
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
                                            this.f451025g = strArr2;
                                        }
                                    } else {
                                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                                        String[] strArr3 = this.f451024f;
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
                                        this.f451024f = strArr4;
                                    }
                                } else {
                                    this.f451023e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f451022d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f451021c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451020b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f451019a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f451019a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f451020b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f451021c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451021c);
        }
        if (!this.f451022d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f451022d);
        }
        if (!this.f451023e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f451023e);
        }
        String[] strArr = this.f451024f;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f451024f;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        String[] strArr3 = this.f451025g;
        if (strArr3 != null && strArr3.length > 0) {
            int i19 = 0;
            int i26 = 0;
            while (true) {
                String[] strArr4 = this.f451025g;
                if (i3 < strArr4.length) {
                    String str2 = strArr4[i3];
                    if (str2 != null) {
                        i26++;
                        i19 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                    }
                    i3++;
                } else {
                    return computeSerializedSize + i19 + (i26 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f451019a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f451020b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f451021c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451021c);
        }
        if (!this.f451022d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451022d);
        }
        if (!this.f451023e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451023e);
        }
        String[] strArr = this.f451024f;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f451024f;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(6, str);
                }
                i16++;
            }
        }
        String[] strArr3 = this.f451025g;
        if (strArr3 != null && strArr3.length > 0) {
            while (true) {
                String[] strArr4 = this.f451025g;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(7, str2);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
