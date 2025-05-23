package tu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f437511a;

    /* renamed from: b, reason: collision with root package name */
    public int f437512b;

    /* renamed from: c, reason: collision with root package name */
    public long f437513c;

    public f() {
        a();
    }

    public f a() {
        this.f437511a = "";
        this.f437512b = 0;
        this.f437513c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f437511a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f437512b = codedInputByteBufferNano.readInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437513c = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f437511a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f437511a);
        }
        int i3 = this.f437512b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        long j3 = this.f437513c;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f437511a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f437511a);
        }
        int i3 = this.f437512b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        long j3 = this.f437513c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
