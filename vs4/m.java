package vs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public long f443321a;

    /* renamed from: b, reason: collision with root package name */
    public int f443322b;

    /* renamed from: c, reason: collision with root package name */
    public int f443323c;

    /* renamed from: d, reason: collision with root package name */
    public int f443324d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f443325e;

    /* renamed from: f, reason: collision with root package name */
    public int f443326f;

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
                this.f443321a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f443322b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f443323c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f443324d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.f443325e = codedInputByteBufferNano.readBytes();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f443326f = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f443321a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f443322b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f443323c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f443324d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!Arrays.equals(this.f443325e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f443325e);
        }
        int i18 = this.f443326f;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f443321a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f443322b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f443323c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f443324d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!Arrays.equals(this.f443325e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f443325e);
        }
        int i18 = this.f443326f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f443321a = 0L;
        this.f443322b = 0;
        this.f443323c = 0;
        this.f443324d = 0;
        this.f443325e = WireFormatNano.EMPTY_BYTES;
        this.f443326f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
