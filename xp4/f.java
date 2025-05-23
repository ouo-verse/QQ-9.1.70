package xp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f448319a;

    /* renamed from: b, reason: collision with root package name */
    public op4.h f448320b;

    public f() {
        a();
    }

    public f a() {
        this.f448319a = null;
        this.f448320b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f448320b == null) {
                            this.f448320b = new op4.h();
                        }
                        codedInputByteBufferNano.readMessage(this.f448320b);
                    }
                } else {
                    if (this.f448319a == null) {
                        this.f448319a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f448319a);
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
        np4.c cVar = this.f448319a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        op4.h hVar = this.f448320b;
        if (hVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f448319a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        op4.h hVar = this.f448320b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
