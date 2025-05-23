package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public String f429622a;

    /* renamed from: b, reason: collision with root package name */
    public long f429623b;

    /* renamed from: c, reason: collision with root package name */
    public long f429624c;

    /* renamed from: d, reason: collision with root package name */
    public String f429625d;

    /* renamed from: e, reason: collision with root package name */
    public int f429626e;

    /* renamed from: f, reason: collision with root package name */
    public e f429627f;

    /* renamed from: g, reason: collision with root package name */
    public String f429628g;

    public n() {
        a();
    }

    public n a() {
        this.f429622a = "";
        this.f429623b = 0L;
        this.f429624c = 0L;
        this.f429625d = "";
        this.f429626e = 0;
        this.f429627f = null;
        this.f429628g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f429622a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f429623b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f429624c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                this.f429625d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f429626e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 50) {
                if (this.f429627f == null) {
                    this.f429627f = new e();
                }
                codedInputByteBufferNano.readMessage(this.f429627f);
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429628g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f429622a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429622a);
        }
        long j3 = this.f429623b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f429624c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.f429625d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f429625d);
        }
        int i3 = this.f429626e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        e eVar = this.f429627f;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, eVar);
        }
        return !this.f429628g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f429628g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429622a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429622a);
        }
        long j3 = this.f429623b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f429624c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f429625d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429625d);
        }
        int i3 = this.f429626e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        e eVar = this.f429627f;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(6, eVar);
        }
        if (!this.f429628g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f429628g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
