package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bn extends ExtendableMessageNano<bn> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f430089a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f430090b;

    public bn() {
        a();
    }

    public bn a() {
        this.f430089a = WireFormatNano.EMPTY_INT_ARRAY;
        this.f430090b = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bn mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                int[] iArr = this.f430089a;
                int length = iArr == null ? 0 : iArr.length;
                int i3 = repeatedFieldArrayLength + length;
                int[] iArr2 = new int[i3];
                if (length != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                }
                while (length < i3 - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.f430089a = iArr2;
            } else if (readTag == 10) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.f430089a;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int i17 = i16 + length2;
                int[] iArr4 = new int[i17];
                if (length2 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length2);
                }
                while (length2 < i17) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.f430089a = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430090b = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int[] iArr2 = this.f430089a;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                iArr = this.f430089a;
                if (i3 >= iArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (iArr.length * 1);
        }
        boolean z16 = this.f430090b;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int[] iArr = this.f430089a;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f430089a;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(1, iArr2[i3]);
                i3++;
            }
        }
        boolean z16 = this.f430090b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
