package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String[] f439893a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f439894b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f439895c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f439896d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f439897e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f439898f;

    /* renamed from: g, reason: collision with root package name */
    public String f439899g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f439900h;

    /* renamed from: i, reason: collision with root package name */
    public String f439901i;

    public b() {
        a();
    }

    public b a() {
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f439893a = strArr;
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.f439894b = iArr;
        this.f439895c = strArr;
        this.f439896d = iArr;
        this.f439897e = strArr;
        this.f439898f = iArr;
        this.f439899g = "";
        this.f439900h = false;
        this.f439901i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        int length4;
        int length5;
        int length6;
        int length7;
        int length8;
        int length9;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    String[] strArr = this.f439893a;
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
                    this.f439893a = strArr2;
                    break;
                case 16:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                    int[] iArr = this.f439894b;
                    if (iArr == null) {
                        length2 = 0;
                    } else {
                        length2 = iArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    int[] iArr2 = new int[i16];
                    if (length2 != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        iArr2[length2] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    iArr2[length2] = codedInputByteBufferNano.readUInt32();
                    this.f439894b = iArr2;
                    break;
                case 18:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i17 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i17++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f439894b;
                    if (iArr3 == null) {
                        length3 = 0;
                    } else {
                        length3 = iArr3.length;
                    }
                    int i18 = i17 + length3;
                    int[] iArr4 = new int[i18];
                    if (length3 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length3);
                    }
                    while (length3 < i18) {
                        iArr4[length3] = codedInputByteBufferNano.readUInt32();
                        length3++;
                    }
                    this.f439894b = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 26:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr3 = this.f439895c;
                    if (strArr3 == null) {
                        length4 = 0;
                    } else {
                        length4 = strArr3.length;
                    }
                    int i19 = repeatedFieldArrayLength3 + length4;
                    String[] strArr4 = new String[i19];
                    if (length4 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length4);
                    }
                    while (length4 < i19 - 1) {
                        strArr4[length4] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    strArr4[length4] = codedInputByteBufferNano.readString();
                    this.f439895c = strArr4;
                    break;
                case 32:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                    int[] iArr5 = this.f439896d;
                    if (iArr5 == null) {
                        length5 = 0;
                    } else {
                        length5 = iArr5.length;
                    }
                    int i26 = repeatedFieldArrayLength4 + length5;
                    int[] iArr6 = new int[i26];
                    if (length5 != 0) {
                        System.arraycopy(iArr5, 0, iArr6, 0, length5);
                    }
                    while (length5 < i26 - 1) {
                        iArr6[length5] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    iArr6[length5] = codedInputByteBufferNano.readUInt32();
                    this.f439896d = iArr6;
                    break;
                case 34:
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i27 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i27++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    int[] iArr7 = this.f439896d;
                    if (iArr7 == null) {
                        length6 = 0;
                    } else {
                        length6 = iArr7.length;
                    }
                    int i28 = i27 + length6;
                    int[] iArr8 = new int[i28];
                    if (length6 != 0) {
                        System.arraycopy(iArr7, 0, iArr8, 0, length6);
                    }
                    while (length6 < i28) {
                        iArr8[length6] = codedInputByteBufferNano.readUInt32();
                        length6++;
                    }
                    this.f439896d = iArr8;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                    break;
                case 42:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    String[] strArr5 = this.f439897e;
                    if (strArr5 == null) {
                        length7 = 0;
                    } else {
                        length7 = strArr5.length;
                    }
                    int i29 = repeatedFieldArrayLength5 + length7;
                    String[] strArr6 = new String[i29];
                    if (length7 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length7);
                    }
                    while (length7 < i29 - 1) {
                        strArr6[length7] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    strArr6[length7] = codedInputByteBufferNano.readString();
                    this.f439897e = strArr6;
                    break;
                case 48:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 48);
                    int[] iArr9 = this.f439898f;
                    if (iArr9 == null) {
                        length8 = 0;
                    } else {
                        length8 = iArr9.length;
                    }
                    int i36 = repeatedFieldArrayLength6 + length8;
                    int[] iArr10 = new int[i36];
                    if (length8 != 0) {
                        System.arraycopy(iArr9, 0, iArr10, 0, length8);
                    }
                    while (length8 < i36 - 1) {
                        iArr10[length8] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length8++;
                    }
                    iArr10[length8] = codedInputByteBufferNano.readUInt32();
                    this.f439898f = iArr10;
                    break;
                case 50:
                    int pushLimit3 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position3 = codedInputByteBufferNano.getPosition();
                    int i37 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i37++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position3);
                    int[] iArr11 = this.f439898f;
                    if (iArr11 == null) {
                        length9 = 0;
                    } else {
                        length9 = iArr11.length;
                    }
                    int i38 = i37 + length9;
                    int[] iArr12 = new int[i38];
                    if (length9 != 0) {
                        System.arraycopy(iArr11, 0, iArr12, 0, length9);
                    }
                    while (length9 < i38) {
                        iArr12[length9] = codedInputByteBufferNano.readUInt32();
                        length9++;
                    }
                    this.f439898f = iArr12;
                    codedInputByteBufferNano.popLimit(pushLimit3);
                    break;
                case 58:
                    this.f439899g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f439900h = codedInputByteBufferNano.readBool();
                    break;
                case 74:
                    this.f439901i = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int computeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.f439893a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f439893a;
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
        int[] iArr4 = this.f439894b;
        if (iArr4 != null && iArr4.length > 0) {
            int i19 = 0;
            int i26 = 0;
            while (true) {
                iArr3 = this.f439894b;
                if (i19 >= iArr3.length) {
                    break;
                }
                i26 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr3[i19]);
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (iArr3.length * 1);
        }
        String[] strArr3 = this.f439895c;
        if (strArr3 != null && strArr3.length > 0) {
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            while (true) {
                String[] strArr4 = this.f439895c;
                if (i27 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i27];
                if (str2 != null) {
                    i29++;
                    i28 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i27++;
            }
            computeSerializedSize = computeSerializedSize + i28 + (i29 * 1);
        }
        int[] iArr5 = this.f439896d;
        if (iArr5 != null && iArr5.length > 0) {
            int i36 = 0;
            int i37 = 0;
            while (true) {
                iArr2 = this.f439896d;
                if (i36 >= iArr2.length) {
                    break;
                }
                i37 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i36]);
                i36++;
            }
            computeSerializedSize = computeSerializedSize + i37 + (iArr2.length * 1);
        }
        String[] strArr5 = this.f439897e;
        if (strArr5 != null && strArr5.length > 0) {
            int i38 = 0;
            int i39 = 0;
            int i46 = 0;
            while (true) {
                String[] strArr6 = this.f439897e;
                if (i38 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i38];
                if (str3 != null) {
                    i46++;
                    i39 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i38++;
            }
            computeSerializedSize = computeSerializedSize + i39 + (i46 * 1);
        }
        int[] iArr6 = this.f439898f;
        if (iArr6 != null && iArr6.length > 0) {
            int i47 = 0;
            while (true) {
                iArr = this.f439898f;
                if (i3 >= iArr.length) {
                    break;
                }
                i47 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i47 + (iArr.length * 1);
        }
        if (!this.f439899g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f439899g);
        }
        boolean z16 = this.f439900h;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z16);
        }
        if (!this.f439901i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f439901i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f439893a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f439893a;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                i16++;
            }
        }
        int[] iArr = this.f439894b;
        if (iArr != null && iArr.length > 0) {
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.f439894b;
                if (i17 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(2, iArr2[i17]);
                i17++;
            }
        }
        String[] strArr3 = this.f439895c;
        if (strArr3 != null && strArr3.length > 0) {
            int i18 = 0;
            while (true) {
                String[] strArr4 = this.f439895c;
                if (i18 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i18];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(3, str2);
                }
                i18++;
            }
        }
        int[] iArr3 = this.f439896d;
        if (iArr3 != null && iArr3.length > 0) {
            int i19 = 0;
            while (true) {
                int[] iArr4 = this.f439896d;
                if (i19 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(4, iArr4[i19]);
                i19++;
            }
        }
        String[] strArr5 = this.f439897e;
        if (strArr5 != null && strArr5.length > 0) {
            int i26 = 0;
            while (true) {
                String[] strArr6 = this.f439897e;
                if (i26 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i26];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(5, str3);
                }
                i26++;
            }
        }
        int[] iArr5 = this.f439898f;
        if (iArr5 != null && iArr5.length > 0) {
            while (true) {
                int[] iArr6 = this.f439898f;
                if (i3 >= iArr6.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(6, iArr6[i3]);
                i3++;
            }
        }
        if (!this.f439899g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f439899g);
        }
        boolean z16 = this.f439900h;
        if (z16) {
            codedOutputByteBufferNano.writeBool(8, z16);
        }
        if (!this.f439901i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f439901i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
