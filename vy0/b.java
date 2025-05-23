package vy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b[] f443677d;

    /* renamed from: a, reason: collision with root package name */
    public int f443678a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f443679b;

    /* renamed from: c, reason: collision with root package name */
    public int f443680c;

    public b() {
        a();
    }

    public static b[] b() {
        if (f443677d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f443677d == null) {
                    f443677d = new b[0];
                }
            }
        }
        return f443677d;
    }

    public b a() {
        this.f443678a = 0;
        this.f443679b = WireFormatNano.EMPTY_BYTES;
        this.f443680c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f443680c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f443679b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f443678a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f443678a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!Arrays.equals(this.f443679b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f443679b);
        }
        int i16 = this.f443680c;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f443678a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!Arrays.equals(this.f443679b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f443679b);
        }
        int i16 = this.f443680c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
