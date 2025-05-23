package xp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f448317a;

    /* renamed from: b, reason: collision with root package name */
    public h f448318b;

    public e() {
        a();
    }

    public e a() {
        this.f448317a = null;
        this.f448318b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f448318b == null) {
                            this.f448318b = new h();
                        }
                        codedInputByteBufferNano.readMessage(this.f448318b);
                    }
                } else {
                    if (this.f448317a == null) {
                        this.f448317a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f448317a);
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
        np4.c cVar = this.f448317a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        h hVar = this.f448318b;
        if (hVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f448317a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        h hVar = this.f448318b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
