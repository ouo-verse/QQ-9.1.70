package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: w, reason: collision with root package name */
    private static volatile r[] f427656w;

    /* renamed from: a, reason: collision with root package name */
    public int f427657a;

    /* renamed from: b, reason: collision with root package name */
    public int f427658b;

    /* renamed from: c, reason: collision with root package name */
    public u f427659c;

    /* renamed from: d, reason: collision with root package name */
    public u f427660d;

    /* renamed from: e, reason: collision with root package name */
    public int f427661e;

    /* renamed from: f, reason: collision with root package name */
    public String f427662f;

    /* renamed from: g, reason: collision with root package name */
    public f[] f427663g;

    /* renamed from: h, reason: collision with root package name */
    public int f427664h;

    /* renamed from: i, reason: collision with root package name */
    public o[] f427665i;

    /* renamed from: j, reason: collision with root package name */
    public int f427666j;

    /* renamed from: k, reason: collision with root package name */
    public int f427667k;

    /* renamed from: l, reason: collision with root package name */
    public int f427668l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f427669m;

    /* renamed from: n, reason: collision with root package name */
    public int f427670n;

    /* renamed from: o, reason: collision with root package name */
    public s[] f427671o;

    /* renamed from: p, reason: collision with root package name */
    public pu4.n f427672p;

    /* renamed from: q, reason: collision with root package name */
    public pu4.e f427673q;

    /* renamed from: r, reason: collision with root package name */
    public x f427674r;

    /* renamed from: s, reason: collision with root package name */
    public h[] f427675s;

    /* renamed from: t, reason: collision with root package name */
    public w[] f427676t;

    /* renamed from: u, reason: collision with root package name */
    public a f427677u;

    /* renamed from: v, reason: collision with root package name */
    public z f427678v;

    public r() {
        a();
    }

    public static r[] b() {
        if (f427656w == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427656w == null) {
                    f427656w = new r[0];
                }
            }
        }
        return f427656w;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f427657a = codedInputByteBufferNano.readInt32();
                    break;
                case 16:
                    this.f427658b = codedInputByteBufferNano.readInt32();
                    break;
                case 26:
                    if (this.f427659c == null) {
                        this.f427659c = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f427659c);
                    break;
                case 34:
                    if (this.f427660d == null) {
                        this.f427660d = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f427660d);
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    s[] sVarArr = this.f427671o;
                    int length = sVarArr == null ? 0 : sVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    s[] sVarArr2 = new s[i3];
                    if (length != 0) {
                        System.arraycopy(sVarArr, 0, sVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        s sVar = new s();
                        sVarArr2[length] = sVar;
                        codedInputByteBufferNano.readMessage(sVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    s sVar2 = new s();
                    sVarArr2[length] = sVar2;
                    codedInputByteBufferNano.readMessage(sVar2);
                    this.f427671o = sVarArr2;
                    break;
                case 56:
                    this.f427661e = codedInputByteBufferNano.readInt32();
                    break;
                case 66:
                    this.f427662f = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    f[] fVarArr = this.f427663g;
                    int length2 = fVarArr == null ? 0 : fVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    f[] fVarArr2 = new f[i16];
                    if (length2 != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        f fVar = new f();
                        fVarArr2[length2] = fVar;
                        codedInputByteBufferNano.readMessage(fVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    f fVar2 = new f();
                    fVarArr2[length2] = fVar2;
                    codedInputByteBufferNano.readMessage(fVar2);
                    this.f427663g = fVarArr2;
                    break;
                case 80:
                    this.f427664h = codedInputByteBufferNano.readInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    o[] oVarArr = this.f427665i;
                    int length3 = oVarArr == null ? 0 : oVarArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    o[] oVarArr2 = new o[i17];
                    if (length3 != 0) {
                        System.arraycopy(oVarArr, 0, oVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        o oVar = new o();
                        oVarArr2[length3] = oVar;
                        codedInputByteBufferNano.readMessage(oVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    o oVar2 = new o();
                    oVarArr2[length3] = oVar2;
                    codedInputByteBufferNano.readMessage(oVar2);
                    this.f427665i = oVarArr2;
                    break;
                case 96:
                    this.f427666j = codedInputByteBufferNano.readInt32();
                    break;
                case 106:
                    if (this.f427672p == null) {
                        this.f427672p = new pu4.n();
                    }
                    codedInputByteBufferNano.readMessage(this.f427672p);
                    break;
                case 114:
                    if (this.f427673q == null) {
                        this.f427673q = new pu4.e();
                    }
                    codedInputByteBufferNano.readMessage(this.f427673q);
                    break;
                case 122:
                    if (this.f427674r == null) {
                        this.f427674r = new x();
                    }
                    codedInputByteBufferNano.readMessage(this.f427674r);
                    break;
                case 128:
                    this.f427667k = codedInputByteBufferNano.readUInt32();
                    break;
                case 136:
                    this.f427668l = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    this.f427670n = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                    h[] hVarArr = this.f427675s;
                    int length4 = hVarArr == null ? 0 : hVarArr.length;
                    int i18 = repeatedFieldArrayLength4 + length4;
                    h[] hVarArr2 = new h[i18];
                    if (length4 != 0) {
                        System.arraycopy(hVarArr, 0, hVarArr2, 0, length4);
                    }
                    while (length4 < i18 - 1) {
                        h hVar = new h();
                        hVarArr2[length4] = hVar;
                        codedInputByteBufferNano.readMessage(hVar);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    h hVar2 = new h();
                    hVarArr2[length4] = hVar2;
                    codedInputByteBufferNano.readMessage(hVar2);
                    this.f427675s = hVarArr2;
                    break;
                case 162:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    w[] wVarArr = this.f427676t;
                    int length5 = wVarArr == null ? 0 : wVarArr.length;
                    int i19 = repeatedFieldArrayLength5 + length5;
                    w[] wVarArr2 = new w[i19];
                    if (length5 != 0) {
                        System.arraycopy(wVarArr, 0, wVarArr2, 0, length5);
                    }
                    while (length5 < i19 - 1) {
                        w wVar = new w();
                        wVarArr2[length5] = wVar;
                        codedInputByteBufferNano.readMessage(wVar);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    w wVar2 = new w();
                    wVarArr2[length5] = wVar2;
                    codedInputByteBufferNano.readMessage(wVar2);
                    this.f427676t = wVarArr2;
                    break;
                case 170:
                    if (this.f427677u == null) {
                        this.f427677u = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f427677u);
                    break;
                case 176:
                    this.f427669m = codedInputByteBufferNano.readBool();
                    break;
                case 186:
                    if (this.f427678v == null) {
                        this.f427678v = new z();
                    }
                    codedInputByteBufferNano.readMessage(this.f427678v);
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
        int i3 = this.f427657a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f427658b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        u uVar = this.f427659c;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, uVar);
        }
        u uVar2 = this.f427660d;
        if (uVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, uVar2);
        }
        s[] sVarArr = this.f427671o;
        int i17 = 0;
        if (sVarArr != null && sVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                s[] sVarArr2 = this.f427671o;
                if (i18 >= sVarArr2.length) {
                    break;
                }
                s sVar = sVarArr2[i18];
                if (sVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, sVar);
                }
                i18++;
            }
        }
        int i19 = this.f427661e;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i19);
        }
        if (!this.f427662f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f427662f);
        }
        f[] fVarArr = this.f427663g;
        if (fVarArr != null && fVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                f[] fVarArr2 = this.f427663g;
                if (i26 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i26];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, fVar);
                }
                i26++;
            }
        }
        int i27 = this.f427664h;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i27);
        }
        o[] oVarArr = this.f427665i;
        if (oVarArr != null && oVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                o[] oVarArr2 = this.f427665i;
                if (i28 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i28];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, oVar);
                }
                i28++;
            }
        }
        int i29 = this.f427666j;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i29);
        }
        pu4.n nVar = this.f427672p;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, nVar);
        }
        pu4.e eVar = this.f427673q;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, eVar);
        }
        x xVar = this.f427674r;
        if (xVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, xVar);
        }
        int i36 = this.f427667k;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i36);
        }
        int i37 = this.f427668l;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i37);
        }
        int i38 = this.f427670n;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i38);
        }
        h[] hVarArr = this.f427675s;
        if (hVarArr != null && hVarArr.length > 0) {
            int i39 = 0;
            while (true) {
                h[] hVarArr2 = this.f427675s;
                if (i39 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i39];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, hVar);
                }
                i39++;
            }
        }
        w[] wVarArr = this.f427676t;
        if (wVarArr != null && wVarArr.length > 0) {
            while (true) {
                w[] wVarArr2 = this.f427676t;
                if (i17 >= wVarArr2.length) {
                    break;
                }
                w wVar = wVarArr2[i17];
                if (wVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, wVar);
                }
                i17++;
            }
        }
        a aVar = this.f427677u;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, aVar);
        }
        boolean z16 = this.f427669m;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, z16);
        }
        z zVar = this.f427678v;
        return zVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(23, zVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427657a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f427658b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        u uVar = this.f427659c;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(3, uVar);
        }
        u uVar2 = this.f427660d;
        if (uVar2 != null) {
            codedOutputByteBufferNano.writeMessage(4, uVar2);
        }
        s[] sVarArr = this.f427671o;
        int i17 = 0;
        if (sVarArr != null && sVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                s[] sVarArr2 = this.f427671o;
                if (i18 >= sVarArr2.length) {
                    break;
                }
                s sVar = sVarArr2[i18];
                if (sVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, sVar);
                }
                i18++;
            }
        }
        int i19 = this.f427661e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i19);
        }
        if (!this.f427662f.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f427662f);
        }
        f[] fVarArr = this.f427663g;
        if (fVarArr != null && fVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                f[] fVarArr2 = this.f427663g;
                if (i26 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i26];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, fVar);
                }
                i26++;
            }
        }
        int i27 = this.f427664h;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i27);
        }
        o[] oVarArr = this.f427665i;
        if (oVarArr != null && oVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                o[] oVarArr2 = this.f427665i;
                if (i28 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i28];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, oVar);
                }
                i28++;
            }
        }
        int i29 = this.f427666j;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i29);
        }
        pu4.n nVar = this.f427672p;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(13, nVar);
        }
        pu4.e eVar = this.f427673q;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(14, eVar);
        }
        x xVar = this.f427674r;
        if (xVar != null) {
            codedOutputByteBufferNano.writeMessage(15, xVar);
        }
        int i36 = this.f427667k;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i36);
        }
        int i37 = this.f427668l;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i37);
        }
        int i38 = this.f427670n;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i38);
        }
        h[] hVarArr = this.f427675s;
        if (hVarArr != null && hVarArr.length > 0) {
            int i39 = 0;
            while (true) {
                h[] hVarArr2 = this.f427675s;
                if (i39 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i39];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(19, hVar);
                }
                i39++;
            }
        }
        w[] wVarArr = this.f427676t;
        if (wVarArr != null && wVarArr.length > 0) {
            while (true) {
                w[] wVarArr2 = this.f427676t;
                if (i17 >= wVarArr2.length) {
                    break;
                }
                w wVar = wVarArr2[i17];
                if (wVar != null) {
                    codedOutputByteBufferNano.writeMessage(20, wVar);
                }
                i17++;
            }
        }
        a aVar = this.f427677u;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(21, aVar);
        }
        boolean z16 = this.f427669m;
        if (z16) {
            codedOutputByteBufferNano.writeBool(22, z16);
        }
        z zVar = this.f427678v;
        if (zVar != null) {
            codedOutputByteBufferNano.writeMessage(23, zVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f427657a = 0;
        this.f427658b = 0;
        this.f427659c = null;
        this.f427660d = null;
        this.f427661e = 0;
        this.f427662f = "";
        this.f427663g = f.b();
        this.f427664h = 0;
        this.f427665i = o.b();
        this.f427666j = 0;
        this.f427667k = 0;
        this.f427668l = 0;
        this.f427669m = false;
        this.f427670n = 0;
        this.f427671o = s.b();
        this.f427672p = null;
        this.f427673q = null;
        this.f427674r = null;
        this.f427675s = h.b();
        this.f427676t = w.b();
        this.f427677u = null;
        this.f427678v = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
