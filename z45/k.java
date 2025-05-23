package z45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public int f451919a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f451920b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f451921c;

    public k() {
        a();
    }

    public k a() {
        this.f451919a = 0;
        this.f451920b = WireFormatNano.EMPTY_BYTES;
        this.f451921c = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 80) {
                            if (readTag != 82) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                int position = codedInputByteBufferNano.getPosition();
                                int i3 = 0;
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 100 || readInt32 == 101) {
                                        i3++;
                                    }
                                }
                                if (i3 != 0) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    int[] iArr = this.f451921c;
                                    if (iArr == null) {
                                        length = 0;
                                    } else {
                                        length = iArr.length;
                                    }
                                    int[] iArr2 = new int[i3 + length];
                                    if (length != 0) {
                                        System.arraycopy(iArr, 0, iArr2, 0, length);
                                    }
                                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                        int readInt322 = codedInputByteBufferNano.readInt32();
                                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 100 || readInt322 == 101) {
                                            iArr2[length] = readInt322;
                                            length++;
                                        }
                                    }
                                    this.f451921c = iArr2;
                                }
                                codedInputByteBufferNano.popLimit(pushLimit);
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                            int[] iArr3 = new int[repeatedFieldArrayLength];
                            int i16 = 0;
                            for (int i17 = 0; i17 < repeatedFieldArrayLength; i17++) {
                                if (i17 != 0) {
                                    codedInputByteBufferNano.readTag();
                                }
                                int readInt323 = codedInputByteBufferNano.readInt32();
                                if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2 || readInt323 == 100 || readInt323 == 101) {
                                    iArr3[i16] = readInt323;
                                    i16++;
                                }
                            }
                            if (i16 != 0) {
                                int[] iArr4 = this.f451921c;
                                if (iArr4 == null) {
                                    length2 = 0;
                                } else {
                                    length2 = iArr4.length;
                                }
                                if (length2 == 0 && i16 == repeatedFieldArrayLength) {
                                    this.f451921c = iArr3;
                                } else {
                                    int[] iArr5 = new int[length2 + i16];
                                    if (length2 != 0) {
                                        System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                    }
                                    System.arraycopy(iArr3, 0, iArr5, length2, i16);
                                    this.f451921c = iArr5;
                                }
                            }
                        }
                    } else {
                        this.f451920b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f451919a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f451919a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!Arrays.equals(this.f451920b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f451920b);
        }
        int[] iArr = this.f451921c;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.f451921c;
                if (i16 < iArr2.length) {
                    i17 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i16]);
                    i16++;
                } else {
                    return computeSerializedSize + i17 + (iArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451919a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!Arrays.equals(this.f451920b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f451920b);
        }
        int[] iArr = this.f451921c;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f451921c;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(10, iArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
