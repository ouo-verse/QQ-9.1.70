package yr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public long f451089a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f451090b;

    /* renamed from: c, reason: collision with root package name */
    public long f451091c;

    /* renamed from: d, reason: collision with root package name */
    public long f451092d;

    /* renamed from: e, reason: collision with root package name */
    public long f451093e;

    /* renamed from: f, reason: collision with root package name */
    public long f451094f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f451095g;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f451089a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f451090b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 24) {
                this.f451091c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.f451092d = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.f451093e = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.f451094f = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451095g = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f451089a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        byte[] bArr = this.f451090b;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f451090b);
        }
        long j16 = this.f451091c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.f451092d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        long j18 = this.f451093e;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j18);
        }
        long j19 = this.f451094f;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j19);
        }
        return !Arrays.equals(this.f451095g, bArr2) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(7, this.f451095g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f451089a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        byte[] bArr = this.f451090b;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.f451090b);
        }
        long j16 = this.f451091c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.f451092d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        long j18 = this.f451093e;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j18);
        }
        long j19 = this.f451094f;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j19);
        }
        if (!Arrays.equals(this.f451095g, bArr2)) {
            codedOutputByteBufferNano.writeBytes(7, this.f451095g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f451089a = 0L;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f451090b = bArr;
        this.f451091c = 0L;
        this.f451092d = 0L;
        this.f451093e = 0L;
        this.f451094f = 0L;
        this.f451095g = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
