package rp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public a f431870a;

    /* renamed from: b, reason: collision with root package name */
    public a f431871b;

    public e() {
        a();
    }

    public e a() {
        this.f431870a = null;
        this.f431871b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f431871b == null) {
                            this.f431871b = new a();
                        }
                        codedInputByteBufferNano.readMessage(this.f431871b);
                    }
                } else {
                    if (this.f431870a == null) {
                        this.f431870a = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f431870a);
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
        a aVar = this.f431870a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        a aVar2 = this.f431871b;
        if (aVar2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, aVar2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a aVar = this.f431870a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        a aVar2 = this.f431871b;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
