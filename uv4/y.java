package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class y extends ExtendableMessageNano<y> {

    /* renamed from: a, reason: collision with root package name */
    public au f440472a;

    public y() {
        a();
    }

    public static y c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (y) MessageNano.mergeFrom(new y(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f440472a == null) {
                    this.f440472a = new au();
                }
                codedInputByteBufferNano.readMessage(this.f440472a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        au auVar = this.f440472a;
        return auVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, auVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        au auVar = this.f440472a;
        if (auVar != null) {
            codedOutputByteBufferNano.writeMessage(1, auVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public y a() {
        this.f440472a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
