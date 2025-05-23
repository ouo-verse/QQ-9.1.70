package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: a, reason: collision with root package name */
    public ac f448819a;

    /* renamed from: b, reason: collision with root package name */
    public d f448820b;

    /* renamed from: c, reason: collision with root package name */
    public a f448821c;

    public u() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f448819a == null) {
                    this.f448819a = new ac();
                }
                codedInputByteBufferNano.readMessage(this.f448819a);
            } else if (readTag == 18) {
                if (this.f448820b == null) {
                    this.f448820b = new d();
                }
                codedInputByteBufferNano.readMessage(this.f448820b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448821c == null) {
                    this.f448821c = new a();
                }
                codedInputByteBufferNano.readMessage(this.f448821c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ac acVar = this.f448819a;
        if (acVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, acVar);
        }
        d dVar = this.f448820b;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
        }
        a aVar = this.f448821c;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ac acVar = this.f448819a;
        if (acVar != null) {
            codedOutputByteBufferNano.writeMessage(1, acVar);
        }
        d dVar = this.f448820b;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2, dVar);
        }
        a aVar = this.f448821c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public u a() {
        this.f448819a = null;
        this.f448820b = null;
        this.f448821c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
