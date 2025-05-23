package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public hs4.s f448603a;

    /* renamed from: b, reason: collision with root package name */
    public hs4.s f448604b;

    public l() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f448603a == null) {
                    this.f448603a = new hs4.s();
                }
                codedInputByteBufferNano.readMessage(this.f448603a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448604b == null) {
                    this.f448604b = new hs4.s();
                }
                codedInputByteBufferNano.readMessage(this.f448604b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        hs4.s sVar = this.f448603a;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sVar);
        }
        hs4.s sVar2 = this.f448604b;
        return sVar2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, sVar2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        hs4.s sVar = this.f448603a;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(1, sVar);
        }
        hs4.s sVar2 = this.f448604b;
        if (sVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, sVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f448603a = null;
        this.f448604b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
