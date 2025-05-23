package ts4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f437429a;

    /* renamed from: b, reason: collision with root package name */
    public int f437430b;

    /* renamed from: c, reason: collision with root package name */
    public long f437431c;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f437429a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f437430b = readInt32;
                }
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437431c = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f437429a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        int i3 = this.f437430b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        long j16 = this.f437431c;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f437429a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        int i3 = this.f437430b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        long j16 = this.f437431c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f437429a = 0L;
        this.f437430b = 0;
        this.f437431c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
