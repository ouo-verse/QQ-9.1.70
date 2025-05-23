package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: t, reason: collision with root package name */
    private static volatile b[] f449365t;

    /* renamed from: a, reason: collision with root package name */
    public String f449366a;

    /* renamed from: b, reason: collision with root package name */
    public long f449367b;

    /* renamed from: c, reason: collision with root package name */
    public long f449368c;

    /* renamed from: d, reason: collision with root package name */
    public o f449369d;

    /* renamed from: e, reason: collision with root package name */
    public int f449370e;

    /* renamed from: f, reason: collision with root package name */
    public String f449371f;

    /* renamed from: g, reason: collision with root package name */
    public String f449372g;

    /* renamed from: h, reason: collision with root package name */
    public long f449373h;

    /* renamed from: i, reason: collision with root package name */
    public a f449374i;

    /* renamed from: j, reason: collision with root package name */
    public i[] f449375j;

    /* renamed from: k, reason: collision with root package name */
    public l f449376k;

    /* renamed from: l, reason: collision with root package name */
    public e f449377l;

    /* renamed from: m, reason: collision with root package name */
    public d f449378m;

    /* renamed from: n, reason: collision with root package name */
    public k f449379n;

    /* renamed from: o, reason: collision with root package name */
    public m f449380o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f449381p;

    /* renamed from: q, reason: collision with root package name */
    public int f449382q;

    /* renamed from: r, reason: collision with root package name */
    public f[] f449383r;

    /* renamed from: s, reason: collision with root package name */
    public String f449384s;

    public b() {
        a();
    }

    public static b[] b() {
        if (f449365t == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f449365t == null) {
                    f449365t = new b[0];
                }
            }
        }
        return f449365t;
    }

    public static b d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f449366a = "";
        this.f449367b = 0L;
        this.f449368c = 0L;
        this.f449369d = null;
        this.f449370e = 0;
        this.f449371f = "";
        this.f449372g = "";
        this.f449373h = 0L;
        this.f449374i = null;
        this.f449375j = i.b();
        this.f449376k = null;
        this.f449377l = null;
        this.f449378m = null;
        this.f449379n = null;
        this.f449380o = null;
        this.f449381p = WireFormatNano.EMPTY_BYTES;
        this.f449382q = 0;
        this.f449383r = f.b();
        this.f449384s = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f449366a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f449367b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f449368c = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    if (this.f449369d == null) {
                        this.f449369d = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f449369d);
                    break;
                case 40:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f449370e = readInt32;
                        break;
                    }
                case 50:
                    this.f449371f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f449372g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f449373h = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    if (this.f449374i == null) {
                        this.f449374i = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f449374i);
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    i[] iVarArr = this.f449375j;
                    if (iVarArr == null) {
                        length = 0;
                    } else {
                        length = iVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    i[] iVarArr2 = new i[i3];
                    if (length != 0) {
                        System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        i iVar = new i();
                        iVarArr2[length] = iVar;
                        codedInputByteBufferNano.readMessage(iVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    i iVar2 = new i();
                    iVarArr2[length] = iVar2;
                    codedInputByteBufferNano.readMessage(iVar2);
                    this.f449375j = iVarArr2;
                    break;
                case 90:
                    if (this.f449376k == null) {
                        this.f449376k = new l();
                    }
                    codedInputByteBufferNano.readMessage(this.f449376k);
                    break;
                case 98:
                    if (this.f449377l == null) {
                        this.f449377l = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f449377l);
                    break;
                case 106:
                    if (this.f449378m == null) {
                        this.f449378m = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f449378m);
                    break;
                case 114:
                    if (this.f449379n == null) {
                        this.f449379n = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f449379n);
                    break;
                case 122:
                    if (this.f449380o == null) {
                        this.f449380o = new m();
                    }
                    codedInputByteBufferNano.readMessage(this.f449380o);
                    break;
                case 130:
                    this.f449381p = codedInputByteBufferNano.readBytes();
                    break;
                case 136:
                    this.f449382q = codedInputByteBufferNano.readUInt32();
                    break;
                case 146:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                    f[] fVarArr = this.f449383r;
                    if (fVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = fVarArr.length;
                    }
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
                    this.f449383r = fVarArr2;
                    break;
                case 154:
                    this.f449384s = codedInputByteBufferNano.readString();
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
        if (!this.f449366a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f449366a);
        }
        long j3 = this.f449367b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f449368c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        o oVar = this.f449369d;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, oVar);
        }
        int i3 = this.f449370e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        if (!this.f449371f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f449371f);
        }
        if (!this.f449372g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f449372g);
        }
        long j17 = this.f449373h;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j17);
        }
        a aVar = this.f449374i;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, aVar);
        }
        i[] iVarArr = this.f449375j;
        int i16 = 0;
        if (iVarArr != null && iVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                i[] iVarArr2 = this.f449375j;
                if (i17 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i17];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, iVar);
                }
                i17++;
            }
        }
        l lVar = this.f449376k;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, lVar);
        }
        e eVar = this.f449377l;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, eVar);
        }
        d dVar = this.f449378m;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, dVar);
        }
        k kVar = this.f449379n;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, kVar);
        }
        m mVar = this.f449380o;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, mVar);
        }
        if (!Arrays.equals(this.f449381p, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(16, this.f449381p);
        }
        int i18 = this.f449382q;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i18);
        }
        f[] fVarArr = this.f449383r;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                f[] fVarArr2 = this.f449383r;
                if (i16 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i16];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, fVar);
                }
                i16++;
            }
        }
        if (!this.f449384s.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(19, this.f449384s);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f449366a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f449366a);
        }
        long j3 = this.f449367b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f449368c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        o oVar = this.f449369d;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(4, oVar);
        }
        int i3 = this.f449370e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        if (!this.f449371f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f449371f);
        }
        if (!this.f449372g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f449372g);
        }
        long j17 = this.f449373h;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j17);
        }
        a aVar = this.f449374i;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(9, aVar);
        }
        i[] iVarArr = this.f449375j;
        int i16 = 0;
        if (iVarArr != null && iVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                i[] iVarArr2 = this.f449375j;
                if (i17 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i17];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, iVar);
                }
                i17++;
            }
        }
        l lVar = this.f449376k;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(11, lVar);
        }
        e eVar = this.f449377l;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(12, eVar);
        }
        d dVar = this.f449378m;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(13, dVar);
        }
        k kVar = this.f449379n;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(14, kVar);
        }
        m mVar = this.f449380o;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(15, mVar);
        }
        if (!Arrays.equals(this.f449381p, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(16, this.f449381p);
        }
        int i18 = this.f449382q;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i18);
        }
        f[] fVarArr = this.f449383r;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                f[] fVarArr2 = this.f449383r;
                if (i16 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i16];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(18, fVar);
                }
                i16++;
            }
        }
        if (!this.f449384s.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.f449384s);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
