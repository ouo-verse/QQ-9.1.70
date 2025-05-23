package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.view.FilterEnum;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class r extends ExtendableMessageNano<r> {
    public int A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;

    /* renamed from: a, reason: collision with root package name */
    public String f429644a;

    /* renamed from: b, reason: collision with root package name */
    public String f429645b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f429646c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f429647d;

    /* renamed from: e, reason: collision with root package name */
    public String f429648e;

    /* renamed from: f, reason: collision with root package name */
    public int f429649f;

    /* renamed from: g, reason: collision with root package name */
    public String f429650g;

    /* renamed from: h, reason: collision with root package name */
    public float f429651h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f429652i;

    /* renamed from: j, reason: collision with root package name */
    public String f429653j;

    /* renamed from: k, reason: collision with root package name */
    public String f429654k;

    /* renamed from: l, reason: collision with root package name */
    public String f429655l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f429656m;

    /* renamed from: n, reason: collision with root package name */
    public String f429657n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f429658o;

    /* renamed from: p, reason: collision with root package name */
    public int f429659p;

    /* renamed from: q, reason: collision with root package name */
    public String[] f429660q;

    /* renamed from: r, reason: collision with root package name */
    public String[] f429661r;

    /* renamed from: s, reason: collision with root package name */
    public String[] f429662s;

    /* renamed from: t, reason: collision with root package name */
    public String[] f429663t;

    /* renamed from: u, reason: collision with root package name */
    public String f429664u;

    /* renamed from: v, reason: collision with root package name */
    public String f429665v;

    /* renamed from: w, reason: collision with root package name */
    public String f429666w;

    /* renamed from: z, reason: collision with root package name */
    public String f429667z;

    public r() {
        a();
    }

    public r a() {
        this.f429644a = "";
        this.f429645b = "";
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f429646c = strArr;
        this.f429647d = strArr;
        this.f429648e = "";
        this.f429649f = 0;
        this.f429650g = "";
        this.f429651h = 0.0f;
        this.f429652i = false;
        this.f429653j = "";
        this.f429654k = "";
        this.f429655l = "";
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.f429656m = iArr;
        this.f429657n = "";
        this.f429658o = iArr;
        this.f429659p = 0;
        this.f429660q = strArr;
        this.f429661r = strArr;
        this.f429662s = strArr;
        this.f429663t = strArr;
        this.f429664u = "";
        this.f429665v = "";
        this.f429666w = "";
        this.f429667z = "";
        this.A = 0;
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f429644a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f429645b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr = this.f429646c;
                    int length = strArr == null ? 0 : strArr.length;
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
                    this.f429646c = strArr2;
                    break;
                case 34:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr3 = this.f429647d;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
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
                    this.f429647d = strArr4;
                    break;
                case 42:
                    this.f429648e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f429649f = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f429650g = codedInputByteBufferNano.readString();
                    break;
                case 85:
                    this.f429651h = codedInputByteBufferNano.readFloat();
                    break;
                case 88:
                    this.f429652i = codedInputByteBufferNano.readBool();
                    break;
                case 98:
                    this.f429653j = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f429654k = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f429655l = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 120);
                    int[] iArr = this.f429656m;
                    int length3 = iArr == null ? 0 : iArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    int[] iArr2 = new int[i17];
                    if (length3 != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        iArr2[length3] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    iArr2[length3] = codedInputByteBufferNano.readUInt32();
                    this.f429656m = iArr2;
                    break;
                case 122:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i18 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i18++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f429656m;
                    int length4 = iArr3 == null ? 0 : iArr3.length;
                    int i19 = i18 + length4;
                    int[] iArr4 = new int[i19];
                    if (length4 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length4);
                    }
                    while (length4 < i19) {
                        iArr4[length4] = codedInputByteBufferNano.readUInt32();
                        length4++;
                    }
                    this.f429656m = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 130:
                    this.f429657n = codedInputByteBufferNano.readString();
                    break;
                case 184:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 184);
                    int[] iArr5 = this.f429658o;
                    int length5 = iArr5 == null ? 0 : iArr5.length;
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
                    this.f429658o = iArr6;
                    break;
                case 186:
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i27 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i27++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    int[] iArr7 = this.f429658o;
                    int length6 = iArr7 == null ? 0 : iArr7.length;
                    int i28 = i27 + length6;
                    int[] iArr8 = new int[i28];
                    if (length6 != 0) {
                        System.arraycopy(iArr7, 0, iArr8, 0, length6);
                    }
                    while (length6 < i28) {
                        iArr8[length6] = codedInputByteBufferNano.readUInt32();
                        length6++;
                    }
                    this.f429658o = iArr8;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                    break;
                case 192:
                    this.f429659p = codedInputByteBufferNano.readUInt32();
                    break;
                case 202:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 202);
                    String[] strArr5 = this.f429660q;
                    int length7 = strArr5 == null ? 0 : strArr5.length;
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
                    this.f429660q = strArr6;
                    break;
                case 210:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 210);
                    String[] strArr7 = this.f429661r;
                    int length8 = strArr7 == null ? 0 : strArr7.length;
                    int i36 = repeatedFieldArrayLength6 + length8;
                    String[] strArr8 = new String[i36];
                    if (length8 != 0) {
                        System.arraycopy(strArr7, 0, strArr8, 0, length8);
                    }
                    while (length8 < i36 - 1) {
                        strArr8[length8] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length8++;
                    }
                    strArr8[length8] = codedInputByteBufferNano.readString();
                    this.f429661r = strArr8;
                    break;
                case 218:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 218);
                    String[] strArr9 = this.f429662s;
                    int length9 = strArr9 == null ? 0 : strArr9.length;
                    int i37 = repeatedFieldArrayLength7 + length9;
                    String[] strArr10 = new String[i37];
                    if (length9 != 0) {
                        System.arraycopy(strArr9, 0, strArr10, 0, length9);
                    }
                    while (length9 < i37 - 1) {
                        strArr10[length9] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length9++;
                    }
                    strArr10[length9] = codedInputByteBufferNano.readString();
                    this.f429662s = strArr10;
                    break;
                case 226:
                    int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 226);
                    String[] strArr11 = this.f429663t;
                    int length10 = strArr11 == null ? 0 : strArr11.length;
                    int i38 = repeatedFieldArrayLength8 + length10;
                    String[] strArr12 = new String[i38];
                    if (length10 != 0) {
                        System.arraycopy(strArr11, 0, strArr12, 0, length10);
                    }
                    while (length10 < i38 - 1) {
                        strArr12[length10] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length10++;
                    }
                    strArr12[length10] = codedInputByteBufferNano.readString();
                    this.f429663t = strArr12;
                    break;
                case 234:
                    this.f429664u = codedInputByteBufferNano.readString();
                    break;
                case 242:
                    this.f429665v = codedInputByteBufferNano.readString();
                    break;
                case 250:
                    this.f429666w = codedInputByteBufferNano.readString();
                    break;
                case 258:
                    this.f429667z = codedInputByteBufferNano.readString();
                    break;
                case 264:
                    this.A = codedInputByteBufferNano.readUInt32();
                    break;
                case 274:
                    this.B = codedInputByteBufferNano.readString();
                    break;
                case FilterEnum.MIC_PTU_BAIXI /* 282 */:
                    this.C = codedInputByteBufferNano.readString();
                    break;
                case 290:
                    this.D = codedInputByteBufferNano.readString();
                    break;
                case 298:
                    this.E = codedInputByteBufferNano.readString();
                    break;
                case 306:
                    this.F = codedInputByteBufferNano.readString();
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
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f429644a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429644a);
        }
        if (!this.f429645b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f429645b);
        }
        String[] strArr = this.f429646c;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f429646c;
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
        String[] strArr3 = this.f429647d;
        if (strArr3 != null && strArr3.length > 0) {
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            while (true) {
                String[] strArr4 = this.f429647d;
                if (i19 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i19];
                if (str2 != null) {
                    i27++;
                    i26 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (i27 * 1);
        }
        if (!this.f429648e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f429648e);
        }
        int i28 = this.f429649f;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i28);
        }
        if (!this.f429650g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f429650g);
        }
        if (Float.floatToIntBits(this.f429651h) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(10, this.f429651h);
        }
        boolean z16 = this.f429652i;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z16);
        }
        if (!this.f429653j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f429653j);
        }
        if (!this.f429654k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f429654k);
        }
        if (!this.f429655l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f429655l);
        }
        int[] iArr3 = this.f429656m;
        if (iArr3 != null && iArr3.length > 0) {
            int i29 = 0;
            int i36 = 0;
            while (true) {
                iArr2 = this.f429656m;
                if (i29 >= iArr2.length) {
                    break;
                }
                i36 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i29]);
                i29++;
            }
            computeSerializedSize = computeSerializedSize + i36 + (iArr2.length * 1);
        }
        if (!this.f429657n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f429657n);
        }
        int[] iArr4 = this.f429658o;
        if (iArr4 != null && iArr4.length > 0) {
            int i37 = 0;
            int i38 = 0;
            while (true) {
                iArr = this.f429658o;
                if (i37 >= iArr.length) {
                    break;
                }
                i38 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i37]);
                i37++;
            }
            computeSerializedSize = computeSerializedSize + i38 + (iArr.length * 2);
        }
        int i39 = this.f429659p;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(24, i39);
        }
        String[] strArr5 = this.f429660q;
        if (strArr5 != null && strArr5.length > 0) {
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            while (true) {
                String[] strArr6 = this.f429660q;
                if (i46 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i46];
                if (str3 != null) {
                    i48++;
                    i47 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i46++;
            }
            computeSerializedSize = computeSerializedSize + i47 + (i48 * 2);
        }
        String[] strArr7 = this.f429661r;
        if (strArr7 != null && strArr7.length > 0) {
            int i49 = 0;
            int i56 = 0;
            int i57 = 0;
            while (true) {
                String[] strArr8 = this.f429661r;
                if (i49 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i49];
                if (str4 != null) {
                    i57++;
                    i56 += CodedOutputByteBufferNano.computeStringSizeNoTag(str4);
                }
                i49++;
            }
            computeSerializedSize = computeSerializedSize + i56 + (i57 * 2);
        }
        String[] strArr9 = this.f429662s;
        if (strArr9 != null && strArr9.length > 0) {
            int i58 = 0;
            int i59 = 0;
            int i65 = 0;
            while (true) {
                String[] strArr10 = this.f429662s;
                if (i58 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i58];
                if (str5 != null) {
                    i65++;
                    i59 += CodedOutputByteBufferNano.computeStringSizeNoTag(str5);
                }
                i58++;
            }
            computeSerializedSize = computeSerializedSize + i59 + (i65 * 2);
        }
        String[] strArr11 = this.f429663t;
        if (strArr11 != null && strArr11.length > 0) {
            int i66 = 0;
            int i67 = 0;
            while (true) {
                String[] strArr12 = this.f429663t;
                if (i3 >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i3];
                if (str6 != null) {
                    i67++;
                    i66 += CodedOutputByteBufferNano.computeStringSizeNoTag(str6);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i66 + (i67 * 2);
        }
        if (!this.f429664u.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(29, this.f429664u);
        }
        if (!this.f429665v.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(30, this.f429665v);
        }
        if (!this.f429666w.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(31, this.f429666w);
        }
        if (!this.f429667z.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(32, this.f429667z);
        }
        int i68 = this.A;
        if (i68 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(33, i68);
        }
        if (!this.B.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(34, this.B);
        }
        if (!this.C.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(35, this.C);
        }
        if (!this.D.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(36, this.D);
        }
        if (!this.E.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(37, this.E);
        }
        return !this.F.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(38, this.F) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429644a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429644a);
        }
        if (!this.f429645b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f429645b);
        }
        String[] strArr = this.f429646c;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f429646c;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i16++;
            }
        }
        String[] strArr3 = this.f429647d;
        if (strArr3 != null && strArr3.length > 0) {
            int i17 = 0;
            while (true) {
                String[] strArr4 = this.f429647d;
                if (i17 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i17];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(4, str2);
                }
                i17++;
            }
        }
        if (!this.f429648e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f429648e);
        }
        int i18 = this.f429649f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        if (!this.f429650g.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f429650g);
        }
        if (Float.floatToIntBits(this.f429651h) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(10, this.f429651h);
        }
        boolean z16 = this.f429652i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(11, z16);
        }
        if (!this.f429653j.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f429653j);
        }
        if (!this.f429654k.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f429654k);
        }
        if (!this.f429655l.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f429655l);
        }
        int[] iArr = this.f429656m;
        if (iArr != null && iArr.length > 0) {
            int i19 = 0;
            while (true) {
                int[] iArr2 = this.f429656m;
                if (i19 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(15, iArr2[i19]);
                i19++;
            }
        }
        if (!this.f429657n.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f429657n);
        }
        int[] iArr3 = this.f429658o;
        if (iArr3 != null && iArr3.length > 0) {
            int i26 = 0;
            while (true) {
                int[] iArr4 = this.f429658o;
                if (i26 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(23, iArr4[i26]);
                i26++;
            }
        }
        int i27 = this.f429659p;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i27);
        }
        String[] strArr5 = this.f429660q;
        if (strArr5 != null && strArr5.length > 0) {
            int i28 = 0;
            while (true) {
                String[] strArr6 = this.f429660q;
                if (i28 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i28];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(25, str3);
                }
                i28++;
            }
        }
        String[] strArr7 = this.f429661r;
        if (strArr7 != null && strArr7.length > 0) {
            int i29 = 0;
            while (true) {
                String[] strArr8 = this.f429661r;
                if (i29 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i29];
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(26, str4);
                }
                i29++;
            }
        }
        String[] strArr9 = this.f429662s;
        if (strArr9 != null && strArr9.length > 0) {
            int i36 = 0;
            while (true) {
                String[] strArr10 = this.f429662s;
                if (i36 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i36];
                if (str5 != null) {
                    codedOutputByteBufferNano.writeString(27, str5);
                }
                i36++;
            }
        }
        String[] strArr11 = this.f429663t;
        if (strArr11 != null && strArr11.length > 0) {
            while (true) {
                String[] strArr12 = this.f429663t;
                if (i3 >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i3];
                if (str6 != null) {
                    codedOutputByteBufferNano.writeString(28, str6);
                }
                i3++;
            }
        }
        if (!this.f429664u.equals("")) {
            codedOutputByteBufferNano.writeString(29, this.f429664u);
        }
        if (!this.f429665v.equals("")) {
            codedOutputByteBufferNano.writeString(30, this.f429665v);
        }
        if (!this.f429666w.equals("")) {
            codedOutputByteBufferNano.writeString(31, this.f429666w);
        }
        if (!this.f429667z.equals("")) {
            codedOutputByteBufferNano.writeString(32, this.f429667z);
        }
        int i37 = this.A;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(33, i37);
        }
        if (!this.B.equals("")) {
            codedOutputByteBufferNano.writeString(34, this.B);
        }
        if (!this.C.equals("")) {
            codedOutputByteBufferNano.writeString(35, this.C);
        }
        if (!this.D.equals("")) {
            codedOutputByteBufferNano.writeString(36, this.D);
        }
        if (!this.E.equals("")) {
            codedOutputByteBufferNano.writeString(37, this.E);
        }
        if (!this.F.equals("")) {
            codedOutputByteBufferNano.writeString(38, this.F);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
