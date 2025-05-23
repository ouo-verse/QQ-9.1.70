package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class be extends ExtendableMessageNano<be> {

    /* renamed from: a, reason: collision with root package name */
    public int f440324a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f440325b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f440326c;

    public be() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public be mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440324a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                int[] iArr = this.f440325b;
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
                this.f440325b = iArr2;
            } else if (readTag == 18) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.f440325b;
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
                this.f440325b = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 24) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                int[] iArr5 = this.f440326c;
                int length3 = iArr5 == null ? 0 : iArr5.length;
                int i18 = repeatedFieldArrayLength2 + length3;
                int[] iArr6 = new int[i18];
                if (length3 != 0) {
                    System.arraycopy(iArr5, 0, iArr6, 0, length3);
                }
                while (length3 < i18 - 1) {
                    iArr6[length3] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                iArr6[length3] = codedInputByteBufferNano.readUInt32();
                this.f440326c = iArr6;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position2 = codedInputByteBufferNano.getPosition();
                int i19 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i19++;
                }
                codedInputByteBufferNano.rewindToPosition(position2);
                int[] iArr7 = this.f440326c;
                int length4 = iArr7 == null ? 0 : iArr7.length;
                int i26 = i19 + length4;
                int[] iArr8 = new int[i26];
                if (length4 != 0) {
                    System.arraycopy(iArr7, 0, iArr8, 0, length4);
                }
                while (length4 < i26) {
                    iArr8[length4] = codedInputByteBufferNano.readUInt32();
                    length4++;
                }
                this.f440326c = iArr8;
                codedInputByteBufferNano.popLimit(pushLimit2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440324a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int[] iArr2 = this.f440325b;
        int i16 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                iArr = this.f440325b;
                if (i17 >= iArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (iArr.length * 1);
        }
        int[] iArr3 = this.f440326c;
        if (iArr3 == null || iArr3.length <= 0) {
            return computeSerializedSize;
        }
        int i19 = 0;
        while (true) {
            int[] iArr4 = this.f440326c;
            if (i16 < iArr4.length) {
                i19 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr4[i16]);
                i16++;
            } else {
                return computeSerializedSize + i19 + (iArr4.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440324a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int[] iArr = this.f440325b;
        int i16 = 0;
        if (iArr != null && iArr.length > 0) {
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.f440325b;
                if (i17 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(2, iArr2[i17]);
                i17++;
            }
        }
        int[] iArr3 = this.f440326c;
        if (iArr3 != null && iArr3.length > 0) {
            while (true) {
                int[] iArr4 = this.f440326c;
                if (i16 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(3, iArr4[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public be a() {
        this.f440324a = 0;
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.f440325b = iArr;
        this.f440326c = iArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
