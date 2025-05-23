package rs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public bs4.j f432181a;

    public p() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f432181a == null) {
                    this.f432181a = new bs4.j();
                }
                codedInputByteBufferNano.readMessage(this.f432181a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs4.j jVar = this.f432181a;
        return jVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, jVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs4.j jVar = this.f432181a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f432181a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
