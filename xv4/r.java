package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: a, reason: collision with root package name */
    public v f448817a;

    public r() {
        a();
    }

    public static r c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (r) MessageNano.mergeFrom(new r(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f448817a == null) {
                    this.f448817a = new v();
                }
                codedInputByteBufferNano.readMessage(this.f448817a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        v vVar = this.f448817a;
        return vVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, vVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        v vVar = this.f448817a;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(1, vVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f448817a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
