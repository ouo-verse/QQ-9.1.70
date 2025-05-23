package vs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import hs4.r;
import hs4.s;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f443309a;

    /* renamed from: b, reason: collision with root package name */
    public o f443310b;

    /* renamed from: c, reason: collision with root package name */
    public o f443311c;

    /* renamed from: d, reason: collision with root package name */
    public r f443312d;

    /* renamed from: e, reason: collision with root package name */
    public String f443313e;

    /* renamed from: f, reason: collision with root package name */
    public String f443314f;

    /* renamed from: g, reason: collision with root package name */
    public String f443315g;

    /* renamed from: h, reason: collision with root package name */
    public int f443316h;

    /* renamed from: i, reason: collision with root package name */
    public s f443317i;

    public h() {
        a();
    }

    public h a() {
        this.f443309a = "";
        this.f443310b = null;
        this.f443311c = null;
        this.f443312d = null;
        this.f443313e = "";
        this.f443314f = "";
        this.f443315g = "";
        this.f443316h = 0;
        this.f443317i = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f443309a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f443310b == null) {
                    this.f443310b = new o();
                }
                codedInputByteBufferNano.readMessage(this.f443310b);
            } else if (readTag == 26) {
                if (this.f443311c == null) {
                    this.f443311c = new o();
                }
                codedInputByteBufferNano.readMessage(this.f443311c);
            } else if (readTag == 34) {
                if (this.f443312d == null) {
                    this.f443312d = new r();
                }
                codedInputByteBufferNano.readMessage(this.f443312d);
            } else if (readTag == 42) {
                this.f443313e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f443314f = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                this.f443315g = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.f443316h = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f443317i == null) {
                    this.f443317i = new s();
                }
                codedInputByteBufferNano.readMessage(this.f443317i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f443309a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f443309a);
        }
        o oVar = this.f443310b;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, oVar);
        }
        o oVar2 = this.f443311c;
        if (oVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, oVar2);
        }
        r rVar = this.f443312d;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, rVar);
        }
        if (!this.f443313e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f443313e);
        }
        if (!this.f443314f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f443314f);
        }
        if (!this.f443315g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f443315g);
        }
        int i3 = this.f443316h;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        s sVar = this.f443317i;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f443309a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f443309a);
        }
        o oVar = this.f443310b;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(2, oVar);
        }
        o oVar2 = this.f443311c;
        if (oVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, oVar2);
        }
        r rVar = this.f443312d;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(4, rVar);
        }
        if (!this.f443313e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f443313e);
        }
        if (!this.f443314f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f443314f);
        }
        if (!this.f443315g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f443315g);
        }
        int i3 = this.f443316h;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        s sVar = this.f443317i;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(9, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
