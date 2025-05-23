package ts4;

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
    public String f437432a;

    /* renamed from: b, reason: collision with root package name */
    public long f437433b;

    /* renamed from: c, reason: collision with root package name */
    public long f437434c;

    /* renamed from: d, reason: collision with root package name */
    public long f437435d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f437436e;

    /* renamed from: f, reason: collision with root package name */
    public String f437437f;

    public b() {
        a();
    }

    public b a() {
        this.f437432a = "";
        this.f437433b = 0L;
        this.f437434c = 0L;
        this.f437435d = 0L;
        this.f437436e = WireFormatNano.EMPTY_BYTES;
        this.f437437f = "";
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
                this.f437432a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f437433b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f437434c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 32) {
                this.f437435d = codedInputByteBufferNano.readInt64();
            } else if (readTag == 42) {
                this.f437436e = codedInputByteBufferNano.readBytes();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437437f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f437432a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f437432a);
        }
        long j3 = this.f437433b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        long j16 = this.f437434c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        long j17 = this.f437435d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j17);
        }
        if (!Arrays.equals(this.f437436e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f437436e);
        }
        return !this.f437437f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f437437f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f437432a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f437432a);
        }
        long j3 = this.f437433b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        long j16 = this.f437434c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        long j17 = this.f437435d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j17);
        }
        if (!Arrays.equals(this.f437436e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f437436e);
        }
        if (!this.f437437f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f437437f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
