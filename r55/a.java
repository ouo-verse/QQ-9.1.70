package r55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f430773a;

    /* renamed from: b, reason: collision with root package name */
    public String f430774b;

    /* renamed from: c, reason: collision with root package name */
    public String f430775c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f430776d;

    public a() {
        a();
    }

    public a a() {
        this.f430773a = "";
        this.f430774b = "";
        this.f430775c = "";
        this.f430776d = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f430773a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f430774b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f430775c = codedInputByteBufferNano.readString();
            } else if (readTag != 802) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430776d = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f430773a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f430773a);
        }
        if (!this.f430774b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430774b);
        }
        if (!this.f430775c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430775c);
        }
        return !Arrays.equals(this.f430776d, WireFormatNano.EMPTY_BYTES) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(100, this.f430776d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f430773a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f430773a);
        }
        if (!this.f430774b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430774b);
        }
        if (!this.f430775c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430775c);
        }
        if (!Arrays.equals(this.f430776d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(100, this.f430776d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
