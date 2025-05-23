package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile e[] f430130c;

    /* renamed from: a, reason: collision with root package name */
    public int f430131a;

    /* renamed from: b, reason: collision with root package name */
    public String f430132b;

    public e() {
        a();
    }

    public static e[] b() {
        if (f430130c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430130c == null) {
                    f430130c = new e[0];
                }
            }
        }
        return f430130c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f430131a = codedInputByteBufferNano.readInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430132b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f430131a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        return !this.f430132b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f430132b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f430131a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f430132b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430132b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f430131a = 0;
        this.f430132b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
