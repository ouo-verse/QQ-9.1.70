package vs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import hs4.r;
import hs4.s;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public r f443303a;

    /* renamed from: b, reason: collision with root package name */
    public s f443304b;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f443303a == null) {
                    this.f443303a = new r();
                }
                codedInputByteBufferNano.readMessage(this.f443303a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f443304b == null) {
                    this.f443304b = new s();
                }
                codedInputByteBufferNano.readMessage(this.f443304b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        r rVar = this.f443303a;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
        }
        s sVar = this.f443304b;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        r rVar = this.f443303a;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(1, rVar);
        }
        s sVar = this.f443304b;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(2, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f443303a = null;
        this.f443304b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
