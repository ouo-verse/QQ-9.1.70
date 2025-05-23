package x45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile h[] f447211d;

    /* renamed from: a, reason: collision with root package name */
    public long f447212a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f447213b;

    /* renamed from: c, reason: collision with root package name */
    public String f447214c;

    public h() {
        a();
    }

    public static h[] b() {
        if (f447211d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f447211d == null) {
                    f447211d = new h[0];
                }
            }
        }
        return f447211d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f447212a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f447213b = codedInputByteBufferNano.readBytes();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f447214c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f447212a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f447213b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f447213b);
        }
        return !this.f447214c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f447214c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f447212a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f447213b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f447213b);
        }
        if (!this.f447214c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f447214c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f447212a = 0L;
        this.f447213b = WireFormatNano.EMPTY_BYTES;
        this.f447214c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
