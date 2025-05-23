package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ah extends ExtendableMessageNano<ah> {

    /* renamed from: b, reason: collision with root package name */
    private static volatile ah[] f448559b;

    /* renamed from: a, reason: collision with root package name */
    public h f448560a;

    public ah() {
        a();
    }

    public static ah[] b() {
        if (f448559b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448559b == null) {
                    f448559b = new ah[0];
                }
            }
        }
        return f448559b;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ah mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f448560a == null) {
                    this.f448560a = new h();
                }
                codedInputByteBufferNano.readMessage(this.f448560a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        h hVar = this.f448560a;
        return hVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, hVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        h hVar = this.f448560a;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(1, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ah a() {
        this.f448560a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
