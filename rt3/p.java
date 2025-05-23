package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public long f432333a;

    /* renamed from: b, reason: collision with root package name */
    public String f432334b;

    /* renamed from: c, reason: collision with root package name */
    public String f432335c;

    /* renamed from: d, reason: collision with root package name */
    public long f432336d;

    public p() {
        a();
    }

    public p a() {
        this.f432333a = 0L;
        this.f432334b = "";
        this.f432335c = "";
        this.f432336d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 26) {
                        if (readTag != 50) {
                            if (readTag != 56) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f432336d = codedInputByteBufferNano.readInt64();
                            }
                        } else {
                            this.f432335c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432334b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432333a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f432333a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f432334b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432334b);
        }
        if (!this.f432335c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f432335c);
        }
        long j16 = this.f432336d;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(7, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432333a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f432334b.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432334b);
        }
        if (!this.f432335c.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f432335c);
        }
        long j16 = this.f432336d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
