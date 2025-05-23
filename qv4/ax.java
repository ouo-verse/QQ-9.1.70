package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ax extends ExtendableMessageNano<ax> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.j f430023a;

    public ax() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ax mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f430023a == null) {
                    this.f430023a = new pv4.j();
                }
                codedInputByteBufferNano.readMessage(this.f430023a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.j jVar = this.f430023a;
        return jVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, jVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.j jVar = this.f430023a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ax a() {
        this.f430023a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
