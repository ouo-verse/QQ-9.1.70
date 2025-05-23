package su4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f434772a;

    /* renamed from: b, reason: collision with root package name */
    public long f434773b;

    /* renamed from: c, reason: collision with root package name */
    public String f434774c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f434775d;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f434772a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f434773b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                this.f434774c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f434775d = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f434772a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f434773b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.f434774c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434774c);
        }
        return !Arrays.equals(this.f434775d, WireFormatNano.EMPTY_BYTES) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.f434775d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f434772a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f434773b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.f434774c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434774c);
        }
        if (!Arrays.equals(this.f434775d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.f434775d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f434772a = 0;
        this.f434773b = 0L;
        this.f434774c = "";
        this.f434775d = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
