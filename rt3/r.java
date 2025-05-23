package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile r[] f432352d;

    /* renamed from: a, reason: collision with root package name */
    public String f432353a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f432354b;

    /* renamed from: c, reason: collision with root package name */
    public long f432355c;

    public r() {
        a();
    }

    public static r[] b() {
        if (f432352d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432352d == null) {
                    f432352d = new r[0];
                }
            }
        }
        return f432352d;
    }

    public r a() {
        this.f432353a = "";
        this.f432354b = WireFormatNano.EMPTY_BYTES;
        this.f432355c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f432355c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f432354b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f432353a = codedInputByteBufferNano.readString();
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
        if (!this.f432353a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432353a);
        }
        if (!Arrays.equals(this.f432354b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f432354b);
        }
        long j3 = this.f432355c;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432353a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432353a);
        }
        if (!Arrays.equals(this.f432354b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f432354b);
        }
        long j3 = this.f432355c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
