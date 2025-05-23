package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public long f432303a;

    /* renamed from: b, reason: collision with root package name */
    public String f432304b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f432305c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f432306d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f432307e;

    /* renamed from: f, reason: collision with root package name */
    public String f432308f;

    /* renamed from: g, reason: collision with root package name */
    public String f432309g;

    /* renamed from: h, reason: collision with root package name */
    public String f432310h;

    /* renamed from: i, reason: collision with root package name */
    public String f432311i;

    public i() {
        a();
    }

    public i a() {
        this.f432303a = 0L;
        this.f432304b = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f432305c = bArr;
        this.f432306d = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f432307e = bArr;
        this.f432308f = "";
        this.f432309g = "";
        this.f432310h = "";
        this.f432311i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (readTag != 66) {
                                                if (readTag != 74) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f432311i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f432310h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f432309g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f432308f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f432307e = codedInputByteBufferNano.readBytes();
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                String[] strArr = this.f432306d;
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
                                this.f432306d = strArr2;
                            }
                        } else {
                            this.f432305c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f432304b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432303a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f432303a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f432304b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432304b);
        }
        if (!Arrays.equals(this.f432305c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f432305c);
        }
        String[] strArr = this.f432306d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f432306d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i17++;
                    i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (i17 * 1);
        }
        if (!Arrays.equals(this.f432307e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f432307e);
        }
        if (!this.f432308f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f432308f);
        }
        if (!this.f432309g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f432309g);
        }
        if (!this.f432310h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f432310h);
        }
        if (!this.f432311i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f432311i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432303a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f432304b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432304b);
        }
        if (!Arrays.equals(this.f432305c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f432305c);
        }
        String[] strArr = this.f432306d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f432306d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i3++;
            }
        }
        if (!Arrays.equals(this.f432307e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f432307e);
        }
        if (!this.f432308f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f432308f);
        }
        if (!this.f432309g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f432309g);
        }
        if (!this.f432310h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f432310h);
        }
        if (!this.f432311i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f432311i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
