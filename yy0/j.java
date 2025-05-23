package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile j[] f451481d;

    /* renamed from: a, reason: collision with root package name */
    public String f451482a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f451483b;

    /* renamed from: c, reason: collision with root package name */
    public long f451484c;

    public j() {
        a();
    }

    public static j[] b() {
        if (f451481d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451481d == null) {
                    f451481d = new j[0];
                }
            }
        }
        return f451481d;
    }

    public j a() {
        this.f451482a = "";
        this.f451483b = WireFormatNano.EMPTY_BYTES;
        this.f451484c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f451484c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f451483b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f451482a = codedInputByteBufferNano.readString();
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
        if (!this.f451482a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451482a);
        }
        if (!Arrays.equals(this.f451483b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f451483b);
        }
        long j3 = this.f451484c;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451482a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451482a);
        }
        if (!Arrays.equals(this.f451483b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f451483b);
        }
        long j3 = this.f451484c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
