package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public long f453445a;

    /* renamed from: b, reason: collision with root package name */
    public int f453446b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f453447c;

    public k() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f453445a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f453446b = readInt32;
                }
            } else if (readTag == 24) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                int[] iArr = new int[repeatedFieldArrayLength];
                int i3 = 0;
                for (int i16 = 0; i16 < repeatedFieldArrayLength; i16++) {
                    if (i16 != 0) {
                        codedInputByteBufferNano.readTag();
                    }
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                        iArr[i3] = readInt322;
                        i3++;
                    }
                }
                if (i3 != 0) {
                    int[] iArr2 = this.f453447c;
                    int length = iArr2 == null ? 0 : iArr2.length;
                    if (length == 0 && i3 == repeatedFieldArrayLength) {
                        this.f453447c = iArr;
                    } else {
                        int[] iArr3 = new int[length + i3];
                        if (length != 0) {
                            System.arraycopy(iArr2, 0, iArr3, 0, length);
                        }
                        System.arraycopy(iArr, 0, iArr3, length, i3);
                        this.f453447c = iArr3;
                    }
                }
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i17 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2) {
                        i17++;
                    }
                }
                if (i17 != 0) {
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr4 = this.f453447c;
                    int length2 = iArr4 == null ? 0 : iArr4.length;
                    int[] iArr5 = new int[i17 + length2];
                    if (length2 != 0) {
                        System.arraycopy(iArr4, 0, iArr5, 0, length2);
                    }
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        int readInt324 = codedInputByteBufferNano.readInt32();
                        if (readInt324 == 0 || readInt324 == 1 || readInt324 == 2) {
                            iArr5[length2] = readInt324;
                            length2++;
                        }
                    }
                    this.f453447c = iArr5;
                }
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f453445a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f453446b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int[] iArr = this.f453447c;
        if (iArr == null || iArr.length <= 0) {
            return computeSerializedSize;
        }
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int[] iArr2 = this.f453447c;
            if (i16 < iArr2.length) {
                i17 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i16]);
                i16++;
            } else {
                return computeSerializedSize + i17 + (iArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f453445a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f453446b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int[] iArr = this.f453447c;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f453447c;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(3, iArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f453445a = 0L;
        this.f453446b = 0;
        this.f453447c = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
