package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f429587a;

    /* renamed from: b, reason: collision with root package name */
    public int f429588b;

    /* renamed from: c, reason: collision with root package name */
    public long f429589c;

    public e() {
        a();
    }

    public e a() {
        this.f429587a = "";
        this.f429588b = 0;
        this.f429589c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f429587a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f429588b = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429589c = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f429587a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429587a);
        }
        int i3 = this.f429588b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j3 = this.f429589c;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429587a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429587a);
        }
        int i3 = this.f429588b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j3 = this.f429589c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
