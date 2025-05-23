package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: p, reason: collision with root package name */
    private static volatile s[] f427679p;

    /* renamed from: a, reason: collision with root package name */
    public u f427680a;

    /* renamed from: b, reason: collision with root package name */
    public pu4.g f427681b;

    /* renamed from: c, reason: collision with root package name */
    public String f427682c;

    /* renamed from: d, reason: collision with root package name */
    public u f427683d;

    /* renamed from: e, reason: collision with root package name */
    public o f427684e;

    /* renamed from: f, reason: collision with root package name */
    public p[] f427685f;

    /* renamed from: g, reason: collision with root package name */
    public q f427686g;

    /* renamed from: h, reason: collision with root package name */
    public q f427687h;

    /* renamed from: i, reason: collision with root package name */
    public int f427688i;

    /* renamed from: j, reason: collision with root package name */
    public u[] f427689j;

    /* renamed from: k, reason: collision with root package name */
    public int f427690k;

    /* renamed from: l, reason: collision with root package name */
    public n[] f427691l;

    /* renamed from: m, reason: collision with root package name */
    public v f427692m;

    /* renamed from: n, reason: collision with root package name */
    public int f427693n;

    /* renamed from: o, reason: collision with root package name */
    public String f427694o;

    public s() {
        a();
    }

    public static s[] b() {
        if (f427679p == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427679p == null) {
                    f427679p = new s[0];
                }
            }
        }
        return f427679p;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f427680a == null) {
                        this.f427680a = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f427680a);
                    break;
                case 18:
                    if (this.f427681b == null) {
                        this.f427681b = new pu4.g();
                    }
                    codedInputByteBufferNano.readMessage(this.f427681b);
                    break;
                case 26:
                    this.f427682c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.f427683d == null) {
                        this.f427683d = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f427683d);
                    break;
                case 42:
                    if (this.f427684e == null) {
                        this.f427684e = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f427684e);
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    p[] pVarArr = this.f427685f;
                    int length = pVarArr == null ? 0 : pVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    p[] pVarArr2 = new p[i3];
                    if (length != 0) {
                        System.arraycopy(pVarArr, 0, pVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        p pVar = new p();
                        pVarArr2[length] = pVar;
                        codedInputByteBufferNano.readMessage(pVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    p pVar2 = new p();
                    pVarArr2[length] = pVar2;
                    codedInputByteBufferNano.readMessage(pVar2);
                    this.f427685f = pVarArr2;
                    break;
                case 58:
                    if (this.f427686g == null) {
                        this.f427686g = new q();
                    }
                    codedInputByteBufferNano.readMessage(this.f427686g);
                    break;
                case 66:
                    if (this.f427687h == null) {
                        this.f427687h = new q();
                    }
                    codedInputByteBufferNano.readMessage(this.f427687h);
                    break;
                case 72:
                    this.f427688i = codedInputByteBufferNano.readInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    u[] uVarArr = this.f427689j;
                    int length2 = uVarArr == null ? 0 : uVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    u[] uVarArr2 = new u[i16];
                    if (length2 != 0) {
                        System.arraycopy(uVarArr, 0, uVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        u uVar = new u();
                        uVarArr2[length2] = uVar;
                        codedInputByteBufferNano.readMessage(uVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    u uVar2 = new u();
                    uVarArr2[length2] = uVar2;
                    codedInputByteBufferNano.readMessage(uVar2);
                    this.f427689j = uVarArr2;
                    break;
                case 96:
                    this.f427690k = codedInputByteBufferNano.readInt32();
                    break;
                case 106:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    n[] nVarArr = this.f427691l;
                    int length3 = nVarArr == null ? 0 : nVarArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    n[] nVarArr2 = new n[i17];
                    if (length3 != 0) {
                        System.arraycopy(nVarArr, 0, nVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        n nVar = new n();
                        nVarArr2[length3] = nVar;
                        codedInputByteBufferNano.readMessage(nVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    n nVar2 = new n();
                    nVarArr2[length3] = nVar2;
                    codedInputByteBufferNano.readMessage(nVar2);
                    this.f427691l = nVarArr2;
                    break;
                case 114:
                    if (this.f427692m == null) {
                        this.f427692m = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.f427692m);
                    break;
                case 120:
                    this.f427693n = codedInputByteBufferNano.readInt32();
                    break;
                case 130:
                    this.f427694o = codedInputByteBufferNano.readString();
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
        u uVar = this.f427680a;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, uVar);
        }
        pu4.g gVar = this.f427681b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        if (!this.f427682c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427682c);
        }
        u uVar2 = this.f427683d;
        if (uVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, uVar2);
        }
        o oVar = this.f427684e;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, oVar);
        }
        p[] pVarArr = this.f427685f;
        int i3 = 0;
        if (pVarArr != null && pVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                p[] pVarArr2 = this.f427685f;
                if (i16 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i16];
                if (pVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, pVar);
                }
                i16++;
            }
        }
        q qVar = this.f427686g;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, qVar);
        }
        q qVar2 = this.f427687h;
        if (qVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, qVar2);
        }
        int i17 = this.f427688i;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i17);
        }
        u[] uVarArr = this.f427689j;
        if (uVarArr != null && uVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                u[] uVarArr2 = this.f427689j;
                if (i18 >= uVarArr2.length) {
                    break;
                }
                u uVar3 = uVarArr2[i18];
                if (uVar3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, uVar3);
                }
                i18++;
            }
        }
        int i19 = this.f427690k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i19);
        }
        n[] nVarArr = this.f427691l;
        if (nVarArr != null && nVarArr.length > 0) {
            while (true) {
                n[] nVarArr2 = this.f427691l;
                if (i3 >= nVarArr2.length) {
                    break;
                }
                n nVar = nVarArr2[i3];
                if (nVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, nVar);
                }
                i3++;
            }
        }
        v vVar = this.f427692m;
        if (vVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, vVar);
        }
        int i26 = this.f427693n;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i26);
        }
        return !this.f427694o.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(16, this.f427694o) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        u uVar = this.f427680a;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(1, uVar);
        }
        pu4.g gVar = this.f427681b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        if (!this.f427682c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427682c);
        }
        u uVar2 = this.f427683d;
        if (uVar2 != null) {
            codedOutputByteBufferNano.writeMessage(4, uVar2);
        }
        o oVar = this.f427684e;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(5, oVar);
        }
        p[] pVarArr = this.f427685f;
        int i3 = 0;
        if (pVarArr != null && pVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                p[] pVarArr2 = this.f427685f;
                if (i16 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i16];
                if (pVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, pVar);
                }
                i16++;
            }
        }
        q qVar = this.f427686g;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(7, qVar);
        }
        q qVar2 = this.f427687h;
        if (qVar2 != null) {
            codedOutputByteBufferNano.writeMessage(8, qVar2);
        }
        int i17 = this.f427688i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i17);
        }
        u[] uVarArr = this.f427689j;
        if (uVarArr != null && uVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                u[] uVarArr2 = this.f427689j;
                if (i18 >= uVarArr2.length) {
                    break;
                }
                u uVar3 = uVarArr2[i18];
                if (uVar3 != null) {
                    codedOutputByteBufferNano.writeMessage(11, uVar3);
                }
                i18++;
            }
        }
        int i19 = this.f427690k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i19);
        }
        n[] nVarArr = this.f427691l;
        if (nVarArr != null && nVarArr.length > 0) {
            while (true) {
                n[] nVarArr2 = this.f427691l;
                if (i3 >= nVarArr2.length) {
                    break;
                }
                n nVar = nVarArr2[i3];
                if (nVar != null) {
                    codedOutputByteBufferNano.writeMessage(13, nVar);
                }
                i3++;
            }
        }
        v vVar = this.f427692m;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(14, vVar);
        }
        int i26 = this.f427693n;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i26);
        }
        if (!this.f427694o.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f427694o);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public s a() {
        this.f427680a = null;
        this.f427681b = null;
        this.f427682c = "";
        this.f427683d = null;
        this.f427684e = null;
        this.f427685f = p.b();
        this.f427686g = null;
        this.f427687h = null;
        this.f427688i = 0;
        this.f427689j = u.b();
        this.f427690k = 0;
        this.f427691l = n.b();
        this.f427692m = null;
        this.f427693n = 0;
        this.f427694o = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
