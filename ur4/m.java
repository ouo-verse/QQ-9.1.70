package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public long f439933a;

    /* renamed from: b, reason: collision with root package name */
    public long f439934b;

    /* renamed from: c, reason: collision with root package name */
    public k f439935c;

    /* renamed from: d, reason: collision with root package name */
    public String f439936d;

    /* renamed from: e, reason: collision with root package name */
    public long f439937e;

    public m() {
        a();
    }

    public m a() {
        this.f439933a = 0L;
        this.f439934b = 0L;
        this.f439935c = null;
        this.f439936d = "";
        this.f439937e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f439937e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f439936d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            if (this.f439935c == null) {
                                this.f439935c = new k();
                            }
                            codedInputByteBufferNano.readMessage(this.f439935c);
                        }
                    } else {
                        this.f439934b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f439933a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f439933a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f439934b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        k kVar = this.f439935c;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, kVar);
        }
        if (!this.f439936d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f439936d);
        }
        long j17 = this.f439937e;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f439933a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f439934b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        k kVar = this.f439935c;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar);
        }
        if (!this.f439936d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f439936d);
        }
        long j17 = this.f439937e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
