package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ag extends ExtendableMessageNano<ag> {

    /* renamed from: w, reason: collision with root package name */
    private static volatile ag[] f448536w;

    /* renamed from: a, reason: collision with root package name */
    public long f448537a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f448538b;

    /* renamed from: c, reason: collision with root package name */
    public int f448539c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.t f448540d;

    /* renamed from: e, reason: collision with root package name */
    public hs4.i f448541e;

    /* renamed from: f, reason: collision with root package name */
    public hs4.r f448542f;

    /* renamed from: g, reason: collision with root package name */
    public hs4.r f448543g;

    /* renamed from: h, reason: collision with root package name */
    public String f448544h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f448545i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f448546j;

    /* renamed from: k, reason: collision with root package name */
    public v[] f448547k;

    /* renamed from: l, reason: collision with root package name */
    public hs4.q f448548l;

    /* renamed from: m, reason: collision with root package name */
    public hs4.j f448549m;

    /* renamed from: n, reason: collision with root package name */
    public int f448550n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f448551o;

    /* renamed from: p, reason: collision with root package name */
    public ab f448552p;

    /* renamed from: q, reason: collision with root package name */
    public ae f448553q;

    /* renamed from: r, reason: collision with root package name */
    public ac f448554r;

    /* renamed from: s, reason: collision with root package name */
    public fs4.o f448555s;

    /* renamed from: t, reason: collision with root package name */
    public hs4.s f448556t;

    /* renamed from: u, reason: collision with root package name */
    public hs4.h f448557u;

    /* renamed from: v, reason: collision with root package name */
    public hs4.s f448558v;

    public ag() {
        a();
    }

    public static ag[] b() {
        if (f448536w == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448536w == null) {
                    f448536w = new ag[0];
                }
            }
        }
        return f448536w;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ag mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f448537a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f448538b = codedInputByteBufferNano.readBytes();
                    break;
                case 24:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f448539c = readInt32;
                        break;
                    }
                    break;
                case 34:
                    if (this.f448540d == null) {
                        this.f448540d = new hs4.t();
                    }
                    codedInputByteBufferNano.readMessage(this.f448540d);
                    break;
                case 42:
                    if (this.f448541e == null) {
                        this.f448541e = new hs4.i();
                    }
                    codedInputByteBufferNano.readMessage(this.f448541e);
                    break;
                case 50:
                    if (this.f448542f == null) {
                        this.f448542f = new hs4.r();
                    }
                    codedInputByteBufferNano.readMessage(this.f448542f);
                    break;
                case 58:
                    if (this.f448543g == null) {
                        this.f448543g = new hs4.r();
                    }
                    codedInputByteBufferNano.readMessage(this.f448543g);
                    break;
                case 66:
                    this.f448544h = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.f448545i = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    this.f448546j = codedInputByteBufferNano.readBool();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    v[] vVarArr = this.f448547k;
                    int length = vVarArr == null ? 0 : vVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    v[] vVarArr2 = new v[i3];
                    if (length != 0) {
                        System.arraycopy(vVarArr, 0, vVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        v vVar = new v();
                        vVarArr2[length] = vVar;
                        codedInputByteBufferNano.readMessage(vVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    v vVar2 = new v();
                    vVarArr2[length] = vVar2;
                    codedInputByteBufferNano.readMessage(vVar2);
                    this.f448547k = vVarArr2;
                    break;
                case 98:
                    if (this.f448548l == null) {
                        this.f448548l = new hs4.q();
                    }
                    codedInputByteBufferNano.readMessage(this.f448548l);
                    break;
                case 106:
                    if (this.f448549m == null) {
                        this.f448549m = new hs4.j();
                    }
                    codedInputByteBufferNano.readMessage(this.f448549m);
                    break;
                case 112:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.f448550n = readInt322;
                        break;
                    }
                case 120:
                    this.f448551o = codedInputByteBufferNano.readBool();
                    break;
                case 130:
                    if (this.f448552p == null) {
                        this.f448552p = new ab();
                    }
                    codedInputByteBufferNano.readMessage(this.f448552p);
                    break;
                case 138:
                    if (this.f448553q == null) {
                        this.f448553q = new ae();
                    }
                    codedInputByteBufferNano.readMessage(this.f448553q);
                    break;
                case 146:
                    if (this.f448554r == null) {
                        this.f448554r = new ac();
                    }
                    codedInputByteBufferNano.readMessage(this.f448554r);
                    break;
                case 154:
                    if (this.f448555s == null) {
                        this.f448555s = new fs4.o();
                    }
                    codedInputByteBufferNano.readMessage(this.f448555s);
                    break;
                case 162:
                    if (this.f448556t == null) {
                        this.f448556t = new hs4.s();
                    }
                    codedInputByteBufferNano.readMessage(this.f448556t);
                    break;
                case 170:
                    if (this.f448557u == null) {
                        this.f448557u = new hs4.h();
                    }
                    codedInputByteBufferNano.readMessage(this.f448557u);
                    break;
                case 178:
                    if (this.f448558v == null) {
                        this.f448558v = new hs4.s();
                    }
                    codedInputByteBufferNano.readMessage(this.f448558v);
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
        long j3 = this.f448537a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f448538b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f448538b);
        }
        int i3 = this.f448539c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        hs4.t tVar = this.f448540d;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, tVar);
        }
        hs4.i iVar = this.f448541e;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, iVar);
        }
        hs4.r rVar = this.f448542f;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, rVar);
        }
        hs4.r rVar2 = this.f448543g;
        if (rVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, rVar2);
        }
        if (!this.f448544h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f448544h);
        }
        boolean z16 = this.f448545i;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z16);
        }
        boolean z17 = this.f448546j;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z17);
        }
        v[] vVarArr = this.f448547k;
        if (vVarArr != null && vVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                v[] vVarArr2 = this.f448547k;
                if (i16 >= vVarArr2.length) {
                    break;
                }
                v vVar = vVarArr2[i16];
                if (vVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, vVar);
                }
                i16++;
            }
        }
        hs4.q qVar = this.f448548l;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, qVar);
        }
        hs4.j jVar = this.f448549m;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, jVar);
        }
        int i17 = this.f448550n;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i17);
        }
        boolean z18 = this.f448551o;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(15, z18);
        }
        ab abVar = this.f448552p;
        if (abVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, abVar);
        }
        ae aeVar = this.f448553q;
        if (aeVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, aeVar);
        }
        ac acVar = this.f448554r;
        if (acVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, acVar);
        }
        fs4.o oVar = this.f448555s;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, oVar);
        }
        hs4.s sVar = this.f448556t;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, sVar);
        }
        hs4.h hVar = this.f448557u;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, hVar);
        }
        hs4.s sVar2 = this.f448558v;
        return sVar2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(22, sVar2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448537a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f448538b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f448538b);
        }
        int i3 = this.f448539c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        hs4.t tVar = this.f448540d;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(4, tVar);
        }
        hs4.i iVar = this.f448541e;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(5, iVar);
        }
        hs4.r rVar = this.f448542f;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(6, rVar);
        }
        hs4.r rVar2 = this.f448543g;
        if (rVar2 != null) {
            codedOutputByteBufferNano.writeMessage(7, rVar2);
        }
        if (!this.f448544h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f448544h);
        }
        boolean z16 = this.f448545i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(9, z16);
        }
        boolean z17 = this.f448546j;
        if (z17) {
            codedOutputByteBufferNano.writeBool(10, z17);
        }
        v[] vVarArr = this.f448547k;
        if (vVarArr != null && vVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                v[] vVarArr2 = this.f448547k;
                if (i16 >= vVarArr2.length) {
                    break;
                }
                v vVar = vVarArr2[i16];
                if (vVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, vVar);
                }
                i16++;
            }
        }
        hs4.q qVar = this.f448548l;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(12, qVar);
        }
        hs4.j jVar = this.f448549m;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(13, jVar);
        }
        int i17 = this.f448550n;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i17);
        }
        boolean z18 = this.f448551o;
        if (z18) {
            codedOutputByteBufferNano.writeBool(15, z18);
        }
        ab abVar = this.f448552p;
        if (abVar != null) {
            codedOutputByteBufferNano.writeMessage(16, abVar);
        }
        ae aeVar = this.f448553q;
        if (aeVar != null) {
            codedOutputByteBufferNano.writeMessage(17, aeVar);
        }
        ac acVar = this.f448554r;
        if (acVar != null) {
            codedOutputByteBufferNano.writeMessage(18, acVar);
        }
        fs4.o oVar = this.f448555s;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(19, oVar);
        }
        hs4.s sVar = this.f448556t;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(20, sVar);
        }
        hs4.h hVar = this.f448557u;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(21, hVar);
        }
        hs4.s sVar2 = this.f448558v;
        if (sVar2 != null) {
            codedOutputByteBufferNano.writeMessage(22, sVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ag a() {
        this.f448537a = 0L;
        this.f448538b = WireFormatNano.EMPTY_BYTES;
        this.f448539c = 0;
        this.f448540d = null;
        this.f448541e = null;
        this.f448542f = null;
        this.f448543g = null;
        this.f448544h = "";
        this.f448545i = false;
        this.f448546j = false;
        this.f448547k = v.b();
        this.f448548l = null;
        this.f448549m = null;
        this.f448550n = 0;
        this.f448551o = false;
        this.f448552p = null;
        this.f448553q = null;
        this.f448554r = null;
        this.f448555s = null;
        this.f448556t = null;
        this.f448557u = null;
        this.f448558v = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
