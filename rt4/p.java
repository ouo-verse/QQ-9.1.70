package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f432442a;

    public p() {
        a();
    }

    public static p c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (p) MessageNano.mergeFrom(new p(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 8) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f432442a = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f432442a;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f432442a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f432442a = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
