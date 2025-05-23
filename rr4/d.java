package rr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public i f432104a;

    /* renamed from: b, reason: collision with root package name */
    public b f432105b;

    /* renamed from: c, reason: collision with root package name */
    public sr4.g[] f432106c;

    /* renamed from: d, reason: collision with root package name */
    public long f432107d;

    /* renamed from: e, reason: collision with root package name */
    public a f432108e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f432109f;

    /* renamed from: g, reason: collision with root package name */
    public String f432110g;

    /* renamed from: h, reason: collision with root package name */
    public e f432111h;

    /* renamed from: i, reason: collision with root package name */
    public String f432112i;

    /* renamed from: j, reason: collision with root package name */
    public String f432113j;

    /* renamed from: k, reason: collision with root package name */
    public f f432114k;

    /* renamed from: l, reason: collision with root package name */
    public f f432115l;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f432104a = null;
        this.f432105b = null;
        this.f432106c = sr4.g.b();
        this.f432107d = 0L;
        this.f432108e = null;
        this.f432109f = false;
        this.f432110g = "";
        this.f432111h = null;
        this.f432112i = "";
        this.f432113j = "";
        this.f432114k = null;
        this.f432115l = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f432104a == null) {
                        this.f432104a = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.f432104a);
                    break;
                case 18:
                    if (this.f432105b == null) {
                        this.f432105b = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f432105b);
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    sr4.g[] gVarArr = this.f432106c;
                    if (gVarArr == null) {
                        length = 0;
                    } else {
                        length = gVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    sr4.g[] gVarArr2 = new sr4.g[i3];
                    if (length != 0) {
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        sr4.g gVar = new sr4.g();
                        gVarArr2[length] = gVar;
                        codedInputByteBufferNano.readMessage(gVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    sr4.g gVar2 = new sr4.g();
                    gVarArr2[length] = gVar2;
                    codedInputByteBufferNano.readMessage(gVar2);
                    this.f432106c = gVarArr2;
                    break;
                case 32:
                    this.f432107d = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    if (this.f432108e == null) {
                        this.f432108e = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f432108e);
                    break;
                case 48:
                    this.f432109f = codedInputByteBufferNano.readBool();
                    break;
                case 58:
                    this.f432110g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    if (this.f432111h == null) {
                        this.f432111h = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f432111h);
                    break;
                case 74:
                    this.f432112i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f432113j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.f432114k == null) {
                        this.f432114k = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f432114k);
                    break;
                case 98:
                    if (this.f432115l == null) {
                        this.f432115l = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f432115l);
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
        i iVar = this.f432104a;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iVar);
        }
        b bVar = this.f432105b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        sr4.g[] gVarArr = this.f432106c;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                sr4.g[] gVarArr2 = this.f432106c;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                sr4.g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
                }
                i3++;
            }
        }
        long j3 = this.f432107d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        a aVar = this.f432108e;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, aVar);
        }
        boolean z16 = this.f432109f;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        if (!this.f432110g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f432110g);
        }
        e eVar = this.f432111h;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, eVar);
        }
        if (!this.f432112i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f432112i);
        }
        if (!this.f432113j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f432113j);
        }
        f fVar = this.f432114k;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, fVar);
        }
        f fVar2 = this.f432115l;
        if (fVar2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(12, fVar2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        i iVar = this.f432104a;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(1, iVar);
        }
        b bVar = this.f432105b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        sr4.g[] gVarArr = this.f432106c;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                sr4.g[] gVarArr2 = this.f432106c;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                sr4.g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, gVar);
                }
                i3++;
            }
        }
        long j3 = this.f432107d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        a aVar = this.f432108e;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(5, aVar);
        }
        boolean z16 = this.f432109f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        if (!this.f432110g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f432110g);
        }
        e eVar = this.f432111h;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(8, eVar);
        }
        if (!this.f432112i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f432112i);
        }
        if (!this.f432113j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f432113j);
        }
        f fVar = this.f432114k;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(11, fVar);
        }
        f fVar2 = this.f432115l;
        if (fVar2 != null) {
            codedOutputByteBufferNano.writeMessage(12, fVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
