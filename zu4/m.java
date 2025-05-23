package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public long f453449a;

    /* renamed from: b, reason: collision with root package name */
    public long f453450b;

    /* renamed from: c, reason: collision with root package name */
    public String f453451c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f453452d;

    public m() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f453449a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f453450b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                this.f453451c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453452d = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f453449a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f453450b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f453451c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f453451c);
        }
        boolean z16 = this.f453452d;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f453449a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f453450b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f453451c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f453451c);
        }
        boolean z16 = this.f453452d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f453449a = 0L;
        this.f453450b = 0L;
        this.f453451c = "";
        this.f453452d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
