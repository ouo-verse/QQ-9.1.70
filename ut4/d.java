package ut4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import hs4.q;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f440024a;

    /* renamed from: b, reason: collision with root package name */
    public q f440025b;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440024a = codedInputByteBufferNano.readBool();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f440025b == null) {
                    this.f440025b = new q();
                }
                codedInputByteBufferNano.readMessage(this.f440025b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f440024a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        q qVar = this.f440025b;
        return qVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, qVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f440024a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        q qVar = this.f440025b;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(2, qVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f440024a = false;
        this.f440025b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
