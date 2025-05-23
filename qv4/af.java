package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class af extends ExtendableMessageNano<af> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.r f429907a;

    public af() {
        a();
    }

    public static af c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (af) MessageNano.mergeFrom(new af(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public af mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f429907a == null) {
                    this.f429907a = new pv4.r();
                }
                codedInputByteBufferNano.readMessage(this.f429907a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.r rVar = this.f429907a;
        return rVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, rVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.r rVar = this.f429907a;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(1, rVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public af a() {
        this.f429907a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
