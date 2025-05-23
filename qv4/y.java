package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class y extends ExtendableMessageNano<y> {

    /* renamed from: a, reason: collision with root package name */
    public az f430209a;

    /* renamed from: b, reason: collision with root package name */
    public int f430210b;

    public y() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430209a == null) {
                    this.f430209a = new az();
                }
                codedInputByteBufferNano.readMessage(this.f430209a);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430210b = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        az azVar = this.f430209a;
        if (azVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, azVar);
        }
        int i3 = this.f430210b;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        az azVar = this.f430209a;
        if (azVar != null) {
            codedOutputByteBufferNano.writeMessage(1, azVar);
        }
        int i3 = this.f430210b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public y a() {
        this.f430209a = null;
        this.f430210b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
