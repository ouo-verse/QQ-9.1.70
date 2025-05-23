package z45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: b, reason: collision with root package name */
    private static volatile o[] f451929b;

    /* renamed from: a, reason: collision with root package name */
    public y45.o f451930a;

    public o() {
        a();
    }

    public static o[] b() {
        if (f451929b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451929b == null) {
                    f451929b = new o[0];
                }
            }
        }
        return f451929b;
    }

    public o a() {
        this.f451930a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.f451930a == null) {
                        this.f451930a = new y45.o();
                    }
                    codedInputByteBufferNano.readMessage(this.f451930a);
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
        y45.o oVar = this.f451930a;
        if (oVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, oVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        y45.o oVar = this.f451930a;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(1, oVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
