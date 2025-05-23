package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public q f432326a;

    /* renamed from: b, reason: collision with root package name */
    public p f432327b;

    public m() {
        a();
    }

    public static m c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (m) MessageNano.mergeFrom(new m(), bArr);
    }

    public m a() {
        this.f432326a = null;
        this.f432327b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f432327b == null) {
                            this.f432327b = new p();
                        }
                        codedInputByteBufferNano.readMessage(this.f432327b);
                    }
                } else {
                    if (this.f432326a == null) {
                        this.f432326a = new q();
                    }
                    codedInputByteBufferNano.readMessage(this.f432326a);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        q qVar = this.f432326a;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, qVar);
        }
        p pVar = this.f432327b;
        if (pVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, pVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        q qVar = this.f432326a;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(1, qVar);
        }
        p pVar = this.f432327b;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(2, pVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
