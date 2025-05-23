package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bu extends ExtendableMessageNano<bu> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile bu[] f430123c;

    /* renamed from: a, reason: collision with root package name */
    public long f430124a;

    /* renamed from: b, reason: collision with root package name */
    public String f430125b;

    public bu() {
        a();
    }

    public static bu[] b() {
        if (f430123c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430123c == null) {
                    f430123c = new bu[0];
                }
            }
        }
        return f430123c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bu mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f430124a = codedInputByteBufferNano.readInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430125b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f430124a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        return !this.f430125b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f430125b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f430124a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        if (!this.f430125b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430125b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bu a() {
        this.f430124a = 0L;
        this.f430125b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
