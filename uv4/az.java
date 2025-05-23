package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.view.FilterEnum;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class az extends ExtendableMessageNano<az> {
    private static volatile az[] O;
    public int A;
    public String B;
    public as C;
    public int D;
    public boolean E;
    public int F;
    public int G;
    public Map<String, String> H;
    public int I;
    public boolean J;
    public String K;
    public boolean L;
    public int M;
    public boolean N;

    /* renamed from: a, reason: collision with root package name */
    public long f440274a;

    /* renamed from: b, reason: collision with root package name */
    public int f440275b;

    /* renamed from: c, reason: collision with root package name */
    public long f440276c;

    /* renamed from: d, reason: collision with root package name */
    public String f440277d;

    /* renamed from: e, reason: collision with root package name */
    public String f440278e;

    /* renamed from: f, reason: collision with root package name */
    public String f440279f;

    /* renamed from: g, reason: collision with root package name */
    public long f440280g;

    /* renamed from: h, reason: collision with root package name */
    public int f440281h;

    /* renamed from: i, reason: collision with root package name */
    public String f440282i;

    /* renamed from: j, reason: collision with root package name */
    public String f440283j;

    /* renamed from: k, reason: collision with root package name */
    public String[] f440284k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f440285l;

    /* renamed from: m, reason: collision with root package name */
    public String f440286m;

    /* renamed from: n, reason: collision with root package name */
    public bc f440287n;

    /* renamed from: o, reason: collision with root package name */
    public ba f440288o;

    /* renamed from: p, reason: collision with root package name */
    public az[] f440289p;

    /* renamed from: q, reason: collision with root package name */
    public be f440290q;

    /* renamed from: r, reason: collision with root package name */
    public bb f440291r;

    /* renamed from: s, reason: collision with root package name */
    public int f440292s;

    /* renamed from: t, reason: collision with root package name */
    public bf f440293t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f440294u;

    /* renamed from: v, reason: collision with root package name */
    public long f440295v;

    /* renamed from: w, reason: collision with root package name */
    public int f440296w;

    /* renamed from: z, reason: collision with root package name */
    public qu4.a f440297z;

    public az() {
        a();
    }

    public static az[] b() {
        if (O == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (O == null) {
                    O = new az[0];
                }
            }
        }
        return O;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public az mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f440274a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f440275b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f440276c = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.f440277d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f440278e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f440279f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f440280g = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.f440281h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f440282i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f440283j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    String[] strArr = this.f440284k;
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
                    this.f440284k = strArr2;
                    break;
                case 96:
                    this.f440285l = codedInputByteBufferNano.readBool();
                    break;
                case 106:
                    this.f440286m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    if (this.f440287n == null) {
                        this.f440287n = new bc();
                    }
                    codedInputByteBufferNano.readMessage(this.f440287n);
                    break;
                case 122:
                    if (this.f440288o == null) {
                        this.f440288o = new ba();
                    }
                    codedInputByteBufferNano.readMessage(this.f440288o);
                    break;
                case 130:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                    az[] azVarArr = this.f440289p;
                    int length2 = azVarArr == null ? 0 : azVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    az[] azVarArr2 = new az[i16];
                    if (length2 != 0) {
                        System.arraycopy(azVarArr, 0, azVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        az azVar = new az();
                        azVarArr2[length2] = azVar;
                        codedInputByteBufferNano.readMessage(azVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    az azVar2 = new az();
                    azVarArr2[length2] = azVar2;
                    codedInputByteBufferNano.readMessage(azVar2);
                    this.f440289p = azVarArr2;
                    break;
                case 138:
                    if (this.f440290q == null) {
                        this.f440290q = new be();
                    }
                    codedInputByteBufferNano.readMessage(this.f440290q);
                    break;
                case 146:
                    if (this.f440291r == null) {
                        this.f440291r = new bb();
                    }
                    codedInputByteBufferNano.readMessage(this.f440291r);
                    break;
                case 152:
                    this.f440292s = codedInputByteBufferNano.readUInt32();
                    break;
                case 162:
                    if (this.f440293t == null) {
                        this.f440293t = new bf();
                    }
                    codedInputByteBufferNano.readMessage(this.f440293t);
                    break;
                case 168:
                    this.f440294u = codedInputByteBufferNano.readBool();
                    break;
                case 176:
                    this.f440295v = codedInputByteBufferNano.readUInt64();
                    break;
                case 184:
                    this.f440296w = codedInputByteBufferNano.readUInt32();
                    break;
                case 194:
                    if (this.f440297z == null) {
                        this.f440297z = new qu4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f440297z);
                    break;
                case 200:
                    this.A = codedInputByteBufferNano.readUInt32();
                    break;
                case 210:
                    this.B = codedInputByteBufferNano.readString();
                    break;
                case 218:
                    if (this.C == null) {
                        this.C = new as();
                    }
                    codedInputByteBufferNano.readMessage(this.C);
                    break;
                case 224:
                    this.D = codedInputByteBufferNano.readInt32();
                    break;
                case 232:
                    this.E = codedInputByteBufferNano.readBool();
                    break;
                case 240:
                    this.F = codedInputByteBufferNano.readUInt32();
                    break;
                case 248:
                    this.G = codedInputByteBufferNano.readUInt32();
                    break;
                case 258:
                    this.H = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.H, mapFactory, 9, 9, null, 10, 18);
                    break;
                case 264:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            this.I = readInt32;
                            break;
                    }
                case 272:
                    this.J = codedInputByteBufferNano.readBool();
                    break;
                case FilterEnum.MIC_PTU_BAIXI /* 282 */:
                    this.K = codedInputByteBufferNano.readString();
                    break;
                case 288:
                    this.L = codedInputByteBufferNano.readBool();
                    break;
                case 296:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3 && readInt322 != 4) {
                        break;
                    } else {
                        this.M = readInt322;
                        break;
                    }
                case 304:
                    this.N = codedInputByteBufferNano.readBool();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f440274a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f440275b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.f440276c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.f440277d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440277d);
        }
        if (!this.f440278e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440278e);
        }
        if (!this.f440279f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f440279f);
        }
        long j17 = this.f440280g;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        int i16 = this.f440281h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        if (!this.f440282i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f440282i);
        }
        if (!this.f440283j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f440283j);
        }
        String[] strArr = this.f440284k;
        int i17 = 0;
        if (strArr != null && strArr.length > 0) {
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            while (true) {
                String[] strArr2 = this.f440284k;
                if (i18 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i18];
                if (str != null) {
                    i26++;
                    i19 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (i26 * 1);
        }
        boolean z16 = this.f440285l;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z16);
        }
        if (!this.f440286m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f440286m);
        }
        bc bcVar = this.f440287n;
        if (bcVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, bcVar);
        }
        ba baVar = this.f440288o;
        if (baVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, baVar);
        }
        az[] azVarArr = this.f440289p;
        if (azVarArr != null && azVarArr.length > 0) {
            while (true) {
                az[] azVarArr2 = this.f440289p;
                if (i17 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i17];
                if (azVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, azVar);
                }
                i17++;
            }
        }
        be beVar = this.f440290q;
        if (beVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, beVar);
        }
        bb bbVar = this.f440291r;
        if (bbVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, bbVar);
        }
        int i27 = this.f440292s;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(19, i27);
        }
        bf bfVar = this.f440293t;
        if (bfVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, bfVar);
        }
        boolean z17 = this.f440294u;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(21, z17);
        }
        long j18 = this.f440295v;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(22, j18);
        }
        int i28 = this.f440296w;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(23, i28);
        }
        qu4.a aVar = this.f440297z;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, aVar);
        }
        int i29 = this.A;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(25, i29);
        }
        if (!this.B.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(26, this.B);
        }
        as asVar = this.C;
        if (asVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(27, asVar);
        }
        int i36 = this.D;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(28, i36);
        }
        boolean z18 = this.E;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(29, z18);
        }
        int i37 = this.F;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(30, i37);
        }
        int i38 = this.G;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(31, i38);
        }
        Map<String, String> map = this.H;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 32, 9, 9);
        }
        int i39 = this.I;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(33, i39);
        }
        boolean z19 = this.J;
        if (z19) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(34, z19);
        }
        if (!this.K.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(35, this.K);
        }
        boolean z26 = this.L;
        if (z26) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(36, z26);
        }
        int i46 = this.M;
        if (i46 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(37, i46);
        }
        boolean z27 = this.N;
        return z27 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(38, z27) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f440274a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f440275b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.f440276c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f440277d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440277d);
        }
        if (!this.f440278e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440278e);
        }
        if (!this.f440279f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440279f);
        }
        long j17 = this.f440280g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        int i16 = this.f440281h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        if (!this.f440282i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f440282i);
        }
        if (!this.f440283j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f440283j);
        }
        String[] strArr = this.f440284k;
        int i17 = 0;
        if (strArr != null && strArr.length > 0) {
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f440284k;
                if (i18 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i18];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i18++;
            }
        }
        boolean z16 = this.f440285l;
        if (z16) {
            codedOutputByteBufferNano.writeBool(12, z16);
        }
        if (!this.f440286m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f440286m);
        }
        bc bcVar = this.f440287n;
        if (bcVar != null) {
            codedOutputByteBufferNano.writeMessage(14, bcVar);
        }
        ba baVar = this.f440288o;
        if (baVar != null) {
            codedOutputByteBufferNano.writeMessage(15, baVar);
        }
        az[] azVarArr = this.f440289p;
        if (azVarArr != null && azVarArr.length > 0) {
            while (true) {
                az[] azVarArr2 = this.f440289p;
                if (i17 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i17];
                if (azVar != null) {
                    codedOutputByteBufferNano.writeMessage(16, azVar);
                }
                i17++;
            }
        }
        be beVar = this.f440290q;
        if (beVar != null) {
            codedOutputByteBufferNano.writeMessage(17, beVar);
        }
        bb bbVar = this.f440291r;
        if (bbVar != null) {
            codedOutputByteBufferNano.writeMessage(18, bbVar);
        }
        int i19 = this.f440292s;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(19, i19);
        }
        bf bfVar = this.f440293t;
        if (bfVar != null) {
            codedOutputByteBufferNano.writeMessage(20, bfVar);
        }
        boolean z17 = this.f440294u;
        if (z17) {
            codedOutputByteBufferNano.writeBool(21, z17);
        }
        long j18 = this.f440295v;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(22, j18);
        }
        int i26 = this.f440296w;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(23, i26);
        }
        qu4.a aVar = this.f440297z;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(24, aVar);
        }
        int i27 = this.A;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(25, i27);
        }
        if (!this.B.equals("")) {
            codedOutputByteBufferNano.writeString(26, this.B);
        }
        as asVar = this.C;
        if (asVar != null) {
            codedOutputByteBufferNano.writeMessage(27, asVar);
        }
        int i28 = this.D;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeInt32(28, i28);
        }
        boolean z18 = this.E;
        if (z18) {
            codedOutputByteBufferNano.writeBool(29, z18);
        }
        int i29 = this.F;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(30, i29);
        }
        int i36 = this.G;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(31, i36);
        }
        Map<String, String> map = this.H;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 32, 9, 9);
        }
        int i37 = this.I;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeInt32(33, i37);
        }
        boolean z19 = this.J;
        if (z19) {
            codedOutputByteBufferNano.writeBool(34, z19);
        }
        if (!this.K.equals("")) {
            codedOutputByteBufferNano.writeString(35, this.K);
        }
        boolean z26 = this.L;
        if (z26) {
            codedOutputByteBufferNano.writeBool(36, z26);
        }
        int i38 = this.M;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeInt32(37, i38);
        }
        boolean z27 = this.N;
        if (z27) {
            codedOutputByteBufferNano.writeBool(38, z27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public az a() {
        this.f440274a = 0L;
        this.f440275b = 0;
        this.f440276c = 0L;
        this.f440277d = "";
        this.f440278e = "";
        this.f440279f = "";
        this.f440280g = 0L;
        this.f440281h = 0;
        this.f440282i = "";
        this.f440283j = "";
        this.f440284k = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f440285l = false;
        this.f440286m = "";
        this.f440287n = null;
        this.f440288o = null;
        this.f440289p = b();
        this.f440290q = null;
        this.f440291r = null;
        this.f440292s = 0;
        this.f440293t = null;
        this.f440294u = false;
        this.f440295v = 0L;
        this.f440296w = 0;
        this.f440297z = null;
        this.A = 0;
        this.B = "";
        this.C = null;
        this.D = 0;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = 0;
        this.J = false;
        this.K = "";
        this.L = false;
        this.M = 0;
        this.N = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
