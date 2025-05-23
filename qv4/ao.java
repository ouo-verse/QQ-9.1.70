package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ao extends ExtendableMessageNano<ao> {
    public String A;
    public String B;
    public String C;
    public String D;
    public boolean E;
    public pv4.j F;
    public String G;
    public at H;

    /* renamed from: a, reason: collision with root package name */
    public int f429949a;

    /* renamed from: b, reason: collision with root package name */
    public int f429950b;

    /* renamed from: c, reason: collision with root package name */
    public String f429951c;

    /* renamed from: d, reason: collision with root package name */
    public String f429952d;

    /* renamed from: e, reason: collision with root package name */
    public String f429953e;

    /* renamed from: f, reason: collision with root package name */
    public String f429954f;

    /* renamed from: g, reason: collision with root package name */
    public String f429955g;

    /* renamed from: h, reason: collision with root package name */
    public int f429956h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f429957i;

    /* renamed from: j, reason: collision with root package name */
    public String f429958j;

    /* renamed from: k, reason: collision with root package name */
    public int f429959k;

    /* renamed from: l, reason: collision with root package name */
    public String[] f429960l;

    /* renamed from: m, reason: collision with root package name */
    public int f429961m;

    /* renamed from: n, reason: collision with root package name */
    public int f429962n;

    /* renamed from: o, reason: collision with root package name */
    public bt f429963o;

    /* renamed from: p, reason: collision with root package name */
    public long f429964p;

    /* renamed from: q, reason: collision with root package name */
    public long f429965q;

    /* renamed from: r, reason: collision with root package name */
    public float f429966r;

    /* renamed from: s, reason: collision with root package name */
    public pv4.y f429967s;

    /* renamed from: t, reason: collision with root package name */
    public long f429968t;

    /* renamed from: u, reason: collision with root package name */
    public long f429969u;

    /* renamed from: v, reason: collision with root package name */
    public f[] f429970v;

    /* renamed from: w, reason: collision with root package name */
    public String f429971w;

    /* renamed from: z, reason: collision with root package name */
    public int f429972z;

    public ao() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ao mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f429949a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f429950b = readInt32;
                        break;
                    }
                case 26:
                    this.f429951c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f429952d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f429953e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f429954f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f429955g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                        break;
                    } else {
                        this.f429956h = readInt322;
                        break;
                    }
                case 74:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    String[] strArr = this.f429957i;
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
                    this.f429957i = strArr2;
                    break;
                case 82:
                    this.f429958j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f429959k = codedInputByteBufferNano.readInt32();
                    break;
                case 98:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    String[] strArr3 = this.f429960l;
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
                    this.f429960l = strArr4;
                    break;
                case 104:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2) {
                        break;
                    } else {
                        this.f429961m = readInt323;
                        break;
                    }
                case 112:
                    this.f429962n = codedInputByteBufferNano.readInt32();
                    break;
                case 122:
                    if (this.f429963o == null) {
                        this.f429963o = new bt();
                    }
                    codedInputByteBufferNano.readMessage(this.f429963o);
                    break;
                case 128:
                    this.f429964p = codedInputByteBufferNano.readInt64();
                    break;
                case 136:
                    this.f429965q = codedInputByteBufferNano.readInt64();
                    break;
                case 149:
                    this.f429966r = codedInputByteBufferNano.readFloat();
                    break;
                case 154:
                    if (this.f429967s == null) {
                        this.f429967s = new pv4.y();
                    }
                    codedInputByteBufferNano.readMessage(this.f429967s);
                    break;
                case 160:
                    this.f429968t = codedInputByteBufferNano.readInt64();
                    break;
                case 168:
                    this.f429969u = codedInputByteBufferNano.readInt64();
                    break;
                case 178:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 178);
                    f[] fVarArr = this.f429970v;
                    int length3 = fVarArr == null ? 0 : fVarArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    f[] fVarArr2 = new f[i17];
                    if (length3 != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        f fVar = new f();
                        fVarArr2[length3] = fVar;
                        codedInputByteBufferNano.readMessage(fVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    f fVar2 = new f();
                    fVarArr2[length3] = fVar2;
                    codedInputByteBufferNano.readMessage(fVar2);
                    this.f429970v = fVarArr2;
                    break;
                case 186:
                    this.f429971w = codedInputByteBufferNano.readString();
                    break;
                case 192:
                    int readInt324 = codedInputByteBufferNano.readInt32();
                    if (readInt324 != 0 && readInt324 != 1 && readInt324 != 2 && readInt324 != 3) {
                        break;
                    } else {
                        this.f429972z = readInt324;
                        break;
                    }
                case 202:
                    this.A = codedInputByteBufferNano.readString();
                    break;
                case 210:
                    this.B = codedInputByteBufferNano.readString();
                    break;
                case 218:
                    this.C = codedInputByteBufferNano.readString();
                    break;
                case 226:
                    this.D = codedInputByteBufferNano.readString();
                    break;
                case 232:
                    this.E = codedInputByteBufferNano.readBool();
                    break;
                case 242:
                    if (this.F == null) {
                        this.F = new pv4.j();
                    }
                    codedInputByteBufferNano.readMessage(this.F);
                    break;
                case 250:
                    this.G = codedInputByteBufferNano.readString();
                    break;
                case 258:
                    if (this.H == null) {
                        this.H = new at();
                    }
                    codedInputByteBufferNano.readMessage(this.H);
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
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429949a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f429950b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f429951c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f429951c);
        }
        if (!this.f429952d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f429952d);
        }
        if (!this.f429953e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f429953e);
        }
        if (!this.f429954f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f429954f);
        }
        if (!this.f429955g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f429955g);
        }
        int i17 = this.f429956h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        String[] strArr = this.f429957i;
        int i18 = 0;
        if (strArr != null && strArr.length > 0) {
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            while (true) {
                String[] strArr2 = this.f429957i;
                if (i19 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i19];
                if (str != null) {
                    i27++;
                    i26 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (i27 * 1);
        }
        if (!this.f429958j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f429958j);
        }
        int i28 = this.f429959k;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i28);
        }
        String[] strArr3 = this.f429960l;
        if (strArr3 != null && strArr3.length > 0) {
            int i29 = 0;
            int i36 = 0;
            int i37 = 0;
            while (true) {
                String[] strArr4 = this.f429960l;
                if (i29 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i29];
                if (str2 != null) {
                    i37++;
                    i36 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i29++;
            }
            computeSerializedSize = computeSerializedSize + i36 + (i37 * 1);
        }
        int i38 = this.f429961m;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i38);
        }
        int i39 = this.f429962n;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i39);
        }
        bt btVar = this.f429963o;
        if (btVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, btVar);
        }
        long j3 = this.f429964p;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(16, j3);
        }
        long j16 = this.f429965q;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(17, j16);
        }
        if (Float.floatToIntBits(this.f429966r) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(18, this.f429966r);
        }
        pv4.y yVar = this.f429967s;
        if (yVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, yVar);
        }
        long j17 = this.f429968t;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(20, j17);
        }
        long j18 = this.f429969u;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(21, j18);
        }
        f[] fVarArr = this.f429970v;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                f[] fVarArr2 = this.f429970v;
                if (i18 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i18];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, fVar);
                }
                i18++;
            }
        }
        if (!this.f429971w.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.f429971w);
        }
        int i46 = this.f429972z;
        if (i46 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(24, i46);
        }
        if (!this.A.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(25, this.A);
        }
        if (!this.B.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(26, this.B);
        }
        if (!this.C.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(27, this.C);
        }
        if (!this.D.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(28, this.D);
        }
        boolean z16 = this.E;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(29, z16);
        }
        pv4.j jVar = this.F;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(30, jVar);
        }
        if (!this.G.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(31, this.G);
        }
        at atVar = this.H;
        return atVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(32, atVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429949a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f429950b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f429951c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429951c);
        }
        if (!this.f429952d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429952d);
        }
        if (!this.f429953e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f429953e);
        }
        if (!this.f429954f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f429954f);
        }
        if (!this.f429955g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f429955g);
        }
        int i17 = this.f429956h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        String[] strArr = this.f429957i;
        int i18 = 0;
        if (strArr != null && strArr.length > 0) {
            int i19 = 0;
            while (true) {
                String[] strArr2 = this.f429957i;
                if (i19 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i19];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(9, str);
                }
                i19++;
            }
        }
        if (!this.f429958j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f429958j);
        }
        int i26 = this.f429959k;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i26);
        }
        String[] strArr3 = this.f429960l;
        if (strArr3 != null && strArr3.length > 0) {
            int i27 = 0;
            while (true) {
                String[] strArr4 = this.f429960l;
                if (i27 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i27];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(12, str2);
                }
                i27++;
            }
        }
        int i28 = this.f429961m;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i28);
        }
        int i29 = this.f429962n;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i29);
        }
        bt btVar = this.f429963o;
        if (btVar != null) {
            codedOutputByteBufferNano.writeMessage(15, btVar);
        }
        long j3 = this.f429964p;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(16, j3);
        }
        long j16 = this.f429965q;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(17, j16);
        }
        if (Float.floatToIntBits(this.f429966r) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(18, this.f429966r);
        }
        pv4.y yVar = this.f429967s;
        if (yVar != null) {
            codedOutputByteBufferNano.writeMessage(19, yVar);
        }
        long j17 = this.f429968t;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(20, j17);
        }
        long j18 = this.f429969u;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(21, j18);
        }
        f[] fVarArr = this.f429970v;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                f[] fVarArr2 = this.f429970v;
                if (i18 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i18];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(22, fVar);
                }
                i18++;
            }
        }
        if (!this.f429971w.equals("")) {
            codedOutputByteBufferNano.writeString(23, this.f429971w);
        }
        int i36 = this.f429972z;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeInt32(24, i36);
        }
        if (!this.A.equals("")) {
            codedOutputByteBufferNano.writeString(25, this.A);
        }
        if (!this.B.equals("")) {
            codedOutputByteBufferNano.writeString(26, this.B);
        }
        if (!this.C.equals("")) {
            codedOutputByteBufferNano.writeString(27, this.C);
        }
        if (!this.D.equals("")) {
            codedOutputByteBufferNano.writeString(28, this.D);
        }
        boolean z16 = this.E;
        if (z16) {
            codedOutputByteBufferNano.writeBool(29, z16);
        }
        pv4.j jVar = this.F;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(30, jVar);
        }
        if (!this.G.equals("")) {
            codedOutputByteBufferNano.writeString(31, this.G);
        }
        at atVar = this.H;
        if (atVar != null) {
            codedOutputByteBufferNano.writeMessage(32, atVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ao a() {
        this.f429949a = 0;
        this.f429950b = 0;
        this.f429951c = "";
        this.f429952d = "";
        this.f429953e = "";
        this.f429954f = "";
        this.f429955g = "";
        this.f429956h = 0;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f429957i = strArr;
        this.f429958j = "";
        this.f429959k = 0;
        this.f429960l = strArr;
        this.f429961m = 0;
        this.f429962n = 0;
        this.f429963o = null;
        this.f429964p = 0L;
        this.f429965q = 0L;
        this.f429966r = 0.0f;
        this.f429967s = null;
        this.f429968t = 0L;
        this.f429969u = 0L;
        this.f429970v = f.b();
        this.f429971w = "";
        this.f429972z = 0;
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = false;
        this.F = null;
        this.G = "";
        this.H = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
