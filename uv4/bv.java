package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bv extends ExtendableMessageNano<bv> {

    /* renamed from: a, reason: collision with root package name */
    public au f440397a;

    public bv() {
        a();
    }

    public static bv c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (bv) MessageNano.mergeFrom(new bv(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bv mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f440397a == null) {
                    this.f440397a = new au();
                }
                codedInputByteBufferNano.readMessage(this.f440397a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        au auVar = this.f440397a;
        return auVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, auVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        au auVar = this.f440397a;
        if (auVar != null) {
            codedOutputByteBufferNano.writeMessage(1, auVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bv a() {
        this.f440397a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
