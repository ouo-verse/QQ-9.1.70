package xp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f448339a;

    /* renamed from: b, reason: collision with root package name */
    public qp4.e f448340b;

    /* renamed from: c, reason: collision with root package name */
    public op4.h f448341c;

    public j() {
        a();
    }

    public j a() {
        this.f448339a = null;
        this.f448340b = null;
        this.f448341c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            if (this.f448341c == null) {
                                this.f448341c = new op4.h();
                            }
                            codedInputByteBufferNano.readMessage(this.f448341c);
                        }
                    } else {
                        if (this.f448340b == null) {
                            this.f448340b = new qp4.e();
                        }
                        codedInputByteBufferNano.readMessage(this.f448340b);
                    }
                } else {
                    if (this.f448339a == null) {
                        this.f448339a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f448339a);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        np4.c cVar = this.f448339a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        qp4.e eVar = this.f448340b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        op4.h hVar = this.f448341c;
        if (hVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, hVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f448339a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        qp4.e eVar = this.f448340b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        op4.h hVar = this.f448341c;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(3, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
