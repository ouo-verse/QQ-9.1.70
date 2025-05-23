package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class au extends ExtendableMessageNano<au> {

    /* renamed from: a, reason: collision with root package name */
    public bs f430008a;

    /* renamed from: b, reason: collision with root package name */
    public String f430009b;

    /* renamed from: c, reason: collision with root package name */
    public String f430010c;

    /* renamed from: d, reason: collision with root package name */
    public String f430011d;

    /* renamed from: e, reason: collision with root package name */
    public String f430012e;

    /* renamed from: f, reason: collision with root package name */
    public long f430013f;

    /* renamed from: g, reason: collision with root package name */
    public String f430014g;

    public au() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public au mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430008a == null) {
                    this.f430008a = new bs();
                }
                codedInputByteBufferNano.readMessage(this.f430008a);
            } else if (readTag == 18) {
                this.f430009b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f430010c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f430011d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f430012e = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.f430013f = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430014g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs bsVar = this.f430008a;
        if (bsVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bsVar);
        }
        if (!this.f430009b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430009b);
        }
        if (!this.f430010c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430010c);
        }
        if (!this.f430011d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430011d);
        }
        if (!this.f430012e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f430012e);
        }
        long j3 = this.f430013f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        return !this.f430014g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f430014g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs bsVar = this.f430008a;
        if (bsVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bsVar);
        }
        if (!this.f430009b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430009b);
        }
        if (!this.f430010c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430010c);
        }
        if (!this.f430011d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430011d);
        }
        if (!this.f430012e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f430012e);
        }
        long j3 = this.f430013f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        if (!this.f430014g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f430014g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public au a() {
        this.f430008a = null;
        this.f430009b = "";
        this.f430010c = "";
        this.f430011d = "";
        this.f430012e = "";
        this.f430013f = 0L;
        this.f430014g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
