package zs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f453166a;

    /* renamed from: b, reason: collision with root package name */
    public int f453167b;

    /* renamed from: c, reason: collision with root package name */
    public long f453168c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f453169d;

    /* renamed from: e, reason: collision with root package name */
    public long f453170e;

    /* renamed from: f, reason: collision with root package name */
    public int f453171f;

    /* renamed from: g, reason: collision with root package name */
    public int f453172g;

    public b() {
        a();
    }

    public b a() {
        this.f453166a = "";
        this.f453167b = 0;
        this.f453168c = 0L;
        this.f453169d = WireFormatNano.EMPTY_BYTES;
        this.f453170e = 0L;
        this.f453171f = 0;
        this.f453172g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f453166a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                    switch (readInt32) {
                    }
                }
                this.f453167b = readInt32;
            } else if (readTag == 24) {
                this.f453168c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                this.f453169d = codedInputByteBufferNano.readBytes();
            } else if (readTag == 40) {
                this.f453170e = codedInputByteBufferNano.readInt64();
            } else if (readTag == 48) {
                this.f453171f = codedInputByteBufferNano.readInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453172g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f453166a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f453166a);
        }
        int i3 = this.f453167b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        long j3 = this.f453168c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        if (!Arrays.equals(this.f453169d, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.f453169d);
        }
        long j16 = this.f453170e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j16);
        }
        int i16 = this.f453171f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        int i17 = this.f453172g;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f453166a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f453166a);
        }
        int i3 = this.f453167b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        long j3 = this.f453168c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!Arrays.equals(this.f453169d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.f453169d);
        }
        long j16 = this.f453170e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j16);
        }
        int i16 = this.f453171f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        int i17 = this.f453172g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
