package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f451425a;

    /* renamed from: b, reason: collision with root package name */
    public int f451426b;

    /* renamed from: c, reason: collision with root package name */
    public String f451427c;

    /* renamed from: d, reason: collision with root package name */
    public int f451428d;

    /* renamed from: e, reason: collision with root package name */
    public int f451429e;

    /* renamed from: f, reason: collision with root package name */
    public int f451430f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f451431g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f451432h;

    public c() {
        a();
    }

    public c a() {
        this.f451425a = "";
        this.f451426b = 0;
        this.f451427c = "";
        this.f451428d = 0;
        this.f451429e = 0;
        this.f451430f = 0;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f451431g = strArr;
        this.f451432h = strArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 40) {
                                if (readTag != 48) {
                                    if (readTag != 56) {
                                        if (readTag != 66) {
                                            if (readTag != 74) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                                                String[] strArr = this.f451432h;
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
                                                this.f451432h = strArr2;
                                            }
                                        } else {
                                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                                            String[] strArr3 = this.f451431g;
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
                                            this.f451431g = strArr4;
                                        }
                                    } else {
                                        this.f451430f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f451429e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f451428d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f451427c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451426b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f451425a = codedInputByteBufferNano.readString();
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
        if (!this.f451425a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451425a);
        }
        int i3 = this.f451426b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f451427c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451427c);
        }
        int i16 = this.f451428d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f451429e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.f451430f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        String[] strArr = this.f451431g;
        int i19 = 0;
        if (strArr != null && strArr.length > 0) {
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            while (true) {
                String[] strArr2 = this.f451431g;
                if (i26 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i26];
                if (str != null) {
                    i28++;
                    i27 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i26++;
            }
            computeSerializedSize = computeSerializedSize + i27 + (i28 * 1);
        }
        String[] strArr3 = this.f451432h;
        if (strArr3 != null && strArr3.length > 0) {
            int i29 = 0;
            int i36 = 0;
            while (true) {
                String[] strArr4 = this.f451432h;
                if (i19 < strArr4.length) {
                    String str2 = strArr4[i19];
                    if (str2 != null) {
                        i36++;
                        i29 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                    }
                    i19++;
                } else {
                    return computeSerializedSize + i29 + (i36 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451425a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451425a);
        }
        int i3 = this.f451426b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f451427c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451427c);
        }
        int i16 = this.f451428d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f451429e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.f451430f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        String[] strArr = this.f451431g;
        int i19 = 0;
        if (strArr != null && strArr.length > 0) {
            int i26 = 0;
            while (true) {
                String[] strArr2 = this.f451431g;
                if (i26 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i26];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(8, str);
                }
                i26++;
            }
        }
        String[] strArr3 = this.f451432h;
        if (strArr3 != null && strArr3.length > 0) {
            while (true) {
                String[] strArr4 = this.f451432h;
                if (i19 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i19];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(9, str2);
                }
                i19++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
