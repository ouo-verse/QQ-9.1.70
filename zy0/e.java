package zy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public long f453706a;

    /* renamed from: b, reason: collision with root package name */
    public long f453707b;

    /* renamed from: c, reason: collision with root package name */
    public long f453708c;

    public e() {
        a();
    }

    public e a() {
        this.f453706a = 0L;
        this.f453707b = 0L;
        this.f453708c = 0L;
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
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f453708c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f453707b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f453706a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f453706a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f453707b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f453708c;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f453706a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f453707b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f453708c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
