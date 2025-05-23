package rr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f432099a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f432100b;

    /* renamed from: c, reason: collision with root package name */
    public long f432101c;

    /* renamed from: d, reason: collision with root package name */
    public long f432102d;

    /* renamed from: e, reason: collision with root package name */
    public g f432103e;

    public c() {
        a();
    }

    public c a() {
        this.f432099a = 0L;
        this.f432100b = WireFormatNano.EMPTY_INT_ARRAY;
        this.f432101c = 0L;
        this.f432102d = 0L;
        this.f432103e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 18) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 82) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        if (this.f432103e == null) {
                                            this.f432103e = new g();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f432103e);
                                    }
                                } else {
                                    this.f432102d = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f432101c = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position = codedInputByteBufferNano.getPosition();
                            int i3 = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                switch (codedInputByteBufferNano.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                        i3++;
                                        break;
                                }
                            }
                            if (i3 != 0) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                int[] iArr = this.f432100b;
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
                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                    switch (readInt32) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                            iArr2[length] = readInt32;
                                            length++;
                                            break;
                                    }
                                }
                                this.f432100b = iArr2;
                            }
                            codedInputByteBufferNano.popLimit(pushLimit);
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                        int[] iArr3 = new int[repeatedFieldArrayLength];
                        int i16 = 0;
                        for (int i17 = 0; i17 < repeatedFieldArrayLength; i17++) {
                            if (i17 != 0) {
                                codedInputByteBufferNano.readTag();
                            }
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            switch (readInt322) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                    iArr3[i16] = readInt322;
                                    i16++;
                                    break;
                            }
                        }
                        if (i16 != 0) {
                            int[] iArr4 = this.f432100b;
                            if (iArr4 == null) {
                                length2 = 0;
                            } else {
                                length2 = iArr4.length;
                            }
                            if (length2 == 0 && i16 == repeatedFieldArrayLength) {
                                this.f432100b = iArr3;
                            } else {
                                int[] iArr5 = new int[length2 + i16];
                                if (length2 != 0) {
                                    System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                }
                                System.arraycopy(iArr3, 0, iArr5, length2, i16);
                                this.f432100b = iArr5;
                            }
                        }
                    }
                } else {
                    this.f432099a = codedInputByteBufferNano.readUInt64();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f432099a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int[] iArr2 = this.f432100b;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                iArr = this.f432100b;
                if (i3 >= iArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (iArr.length * 1);
        }
        long j16 = this.f432101c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        long j17 = this.f432102d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        g gVar = this.f432103e;
        if (gVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, gVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432099a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int[] iArr = this.f432100b;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f432100b;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(2, iArr2[i3]);
                i3++;
            }
        }
        long j16 = this.f432101c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        long j17 = this.f432102d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        g gVar = this.f432103e;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(10, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
