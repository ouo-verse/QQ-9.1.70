package tv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public b f437579a;

    /* renamed from: b, reason: collision with root package name */
    public a f437580b;

    /* renamed from: c, reason: collision with root package name */
    public long f437581c;

    /* renamed from: d, reason: collision with root package name */
    public String f437582d;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f437579a == null) {
                    this.f437579a = new b();
                }
                codedInputByteBufferNano.readMessage(this.f437579a);
            } else if (readTag == 18) {
                if (this.f437580b == null) {
                    this.f437580b = new a();
                }
                codedInputByteBufferNano.readMessage(this.f437580b);
            } else if (readTag == 24) {
                this.f437581c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437582d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b bVar = this.f437579a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        a aVar = this.f437580b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        long j3 = this.f437581c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return !this.f437582d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f437582d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f437579a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        a aVar = this.f437580b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        long j3 = this.f437581c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!this.f437582d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f437582d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f437579a = null;
        this.f437580b = null;
        this.f437581c = 0L;
        this.f437582d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
