package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bf extends ExtendableMessageNano<bf> {

    /* renamed from: a, reason: collision with root package name */
    public long f440327a;

    /* renamed from: b, reason: collision with root package name */
    public long f440328b;

    /* renamed from: c, reason: collision with root package name */
    public String f440329c;

    public bf() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440327a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f440328b = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440329c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f440327a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f440328b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        return !this.f440329c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f440329c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f440327a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f440328b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f440329c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440329c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bf a() {
        this.f440327a = 0L;
        this.f440328b = 0L;
        this.f440329c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
