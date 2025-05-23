package vv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public byte[][] f443590a;

    public a() {
        a();
    }

    public a a() {
        this.f443590a = WireFormatNano.EMPTY_BYTES_ARRAY;
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
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                byte[][] bArr = this.f443590a;
                int length = bArr == null ? 0 : bArr.length;
                int i3 = repeatedFieldArrayLength + length;
                byte[][] bArr2 = new byte[i3];
                if (length != 0) {
                    System.arraycopy(bArr, 0, bArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bArr2[length] = codedInputByteBufferNano.readBytes();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bArr2[length] = codedInputByteBufferNano.readBytes();
                this.f443590a = bArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[][] bArr = this.f443590a;
        if (bArr == null || bArr.length <= 0) {
            return computeSerializedSize;
        }
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            byte[][] bArr2 = this.f443590a;
            if (i3 >= bArr2.length) {
                return computeSerializedSize + i16 + (i17 * 1);
            }
            byte[] bArr3 = bArr2[i3];
            if (bArr3 != null) {
                i17++;
                i16 += CodedOutputByteBufferNano.computeBytesSizeNoTag(bArr3);
            }
            i3++;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[][] bArr = this.f443590a;
        if (bArr != null && bArr.length > 0) {
            int i3 = 0;
            while (true) {
                byte[][] bArr2 = this.f443590a;
                if (i3 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i3];
                if (bArr3 != null) {
                    codedOutputByteBufferNano.writeBytes(1, bArr3);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
