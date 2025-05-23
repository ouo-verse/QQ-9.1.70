package wt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import fs4.t;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public t f446515a;

    /* renamed from: b, reason: collision with root package name */
    public k f446516b;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f446515a == null) {
                    this.f446515a = new t();
                }
                codedInputByteBufferNano.readMessage(this.f446515a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f446516b == null) {
                    this.f446516b = new k();
                }
                codedInputByteBufferNano.readMessage(this.f446516b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        t tVar = this.f446515a;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, tVar);
        }
        k kVar = this.f446516b;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        t tVar = this.f446515a;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(1, tVar);
        }
        k kVar = this.f446516b;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f446515a = null;
        this.f446516b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
