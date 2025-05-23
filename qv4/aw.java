package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class aw extends ExtendableMessageNano<aw> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.y f430021a;

    /* renamed from: b, reason: collision with root package name */
    public g f430022b;

    public aw() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aw mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430021a == null) {
                    this.f430021a = new pv4.y();
                }
                codedInputByteBufferNano.readMessage(this.f430021a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f430022b == null) {
                    this.f430022b = new g();
                }
                codedInputByteBufferNano.readMessage(this.f430022b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.y yVar = this.f430021a;
        if (yVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, yVar);
        }
        g gVar = this.f430022b;
        return gVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, gVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.y yVar = this.f430021a;
        if (yVar != null) {
            codedOutputByteBufferNano.writeMessage(1, yVar);
        }
        g gVar = this.f430022b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public aw a() {
        this.f430021a = null;
        this.f430022b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
