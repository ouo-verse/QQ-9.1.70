package ws4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public e f446407a;

    /* renamed from: b, reason: collision with root package name */
    public f f446408b;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f446407a == null) {
                    this.f446407a = new e();
                }
                codedInputByteBufferNano.readMessage(this.f446407a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f446408b == null) {
                    this.f446408b = new f();
                }
                codedInputByteBufferNano.readMessage(this.f446408b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        e eVar = this.f446407a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        f fVar = this.f446408b;
        return fVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, fVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e eVar = this.f446407a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        f fVar = this.f446408b;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(2, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f446407a = null;
        this.f446408b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
