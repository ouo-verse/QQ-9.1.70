package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f453426a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f453427b;

    public a() {
        a();
    }

    public a a() {
        this.f453426a = "";
        this.f453427b = WireFormatNano.EMPTY_INT_ARRAY;
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
                this.f453426a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                int[] iArr = new int[repeatedFieldArrayLength];
                int i3 = 0;
                for (int i16 = 0; i16 < repeatedFieldArrayLength; i16++) {
                    if (i16 != 0) {
                        codedInputByteBufferNano.readTag();
                    }
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1) {
                        iArr[i3] = readInt32;
                        i3++;
                    }
                }
                if (i3 != 0) {
                    int[] iArr2 = this.f453427b;
                    int length = iArr2 == null ? 0 : iArr2.length;
                    if (length == 0 && i3 == repeatedFieldArrayLength) {
                        this.f453427b = iArr;
                    } else {
                        int[] iArr3 = new int[length + i3];
                        if (length != 0) {
                            System.arraycopy(iArr2, 0, iArr3, 0, length);
                        }
                        System.arraycopy(iArr, 0, iArr3, length, i3);
                        this.f453427b = iArr3;
                    }
                }
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i17 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 == 0 || readInt322 == 1) {
                        i17++;
                    }
                }
                if (i17 != 0) {
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr4 = this.f453427b;
                    int length2 = iArr4 == null ? 0 : iArr4.length;
                    int[] iArr5 = new int[i17 + length2];
                    if (length2 != 0) {
                        System.arraycopy(iArr4, 0, iArr5, 0, length2);
                    }
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        if (readInt323 == 0 || readInt323 == 1) {
                            iArr5[length2] = readInt323;
                            length2++;
                        }
                    }
                    this.f453427b = iArr5;
                }
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f453426a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f453426a);
        }
        int[] iArr = this.f453427b;
        if (iArr == null || iArr.length <= 0) {
            return computeSerializedSize;
        }
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int[] iArr2 = this.f453427b;
            if (i3 < iArr2.length) {
                i16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i3]);
                i3++;
            } else {
                return computeSerializedSize + i16 + (iArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f453426a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f453426a);
        }
        int[] iArr = this.f453427b;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f453427b;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(2, iArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
