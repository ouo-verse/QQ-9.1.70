package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile h[] f440423c;

    /* renamed from: a, reason: collision with root package name */
    public int f440424a;

    /* renamed from: b, reason: collision with root package name */
    public int f440425b;

    public h() {
        a();
    }

    public static h[] b() {
        if (f440423c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440423c == null) {
                    f440423c = new h[0];
                }
            }
        }
        return f440423c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440424a = codedInputByteBufferNano.readInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440425b = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440424a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f440425b;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440424a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f440425b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f440424a = 0;
        this.f440425b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
