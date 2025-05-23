package st4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public b f434753a;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f434753a == null) {
                    this.f434753a = new b();
                }
                codedInputByteBufferNano.readMessage(this.f434753a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b bVar = this.f434753a;
        return bVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, bVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f434753a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f434753a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
