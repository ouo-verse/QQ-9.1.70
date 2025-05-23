package z45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public y45.b[] f451922a;

    /* renamed from: b, reason: collision with root package name */
    public int f451923b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f451924c;

    /* renamed from: d, reason: collision with root package name */
    public b55.g[] f451925d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f451926e;

    public l() {
        a();
    }

    public static l c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (l) MessageNano.mergeFrom(new l(), bArr);
    }

    public l a() {
        this.f451922a = y45.b.b();
        this.f451923b = 0;
        this.f451924c = WireFormatNano.EMPTY_BYTES;
        this.f451925d = b55.g.b();
        this.f451926e = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        int length4;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
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
                                            int[] iArr = this.f451926e;
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
                                            this.f451926e = iArr2;
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
                                        int[] iArr4 = this.f451926e;
                                        if (iArr4 == null) {
                                            length2 = 0;
                                        } else {
                                            length2 = iArr4.length;
                                        }
                                        if (length2 == 0 && i16 == repeatedFieldArrayLength) {
                                            this.f451926e = iArr3;
                                        } else {
                                            int[] iArr5 = new int[length2 + i16];
                                            if (length2 != 0) {
                                                System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                            }
                                            System.arraycopy(iArr3, 0, iArr5, length2, i16);
                                            this.f451926e = iArr5;
                                        }
                                    }
                                }
                            } else {
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                b55.g[] gVarArr = this.f451925d;
                                if (gVarArr == null) {
                                    length3 = 0;
                                } else {
                                    length3 = gVarArr.length;
                                }
                                int i18 = repeatedFieldArrayLength2 + length3;
                                b55.g[] gVarArr2 = new b55.g[i18];
                                if (length3 != 0) {
                                    System.arraycopy(gVarArr, 0, gVarArr2, 0, length3);
                                }
                                while (length3 < i18 - 1) {
                                    b55.g gVar = new b55.g();
                                    gVarArr2[length3] = gVar;
                                    codedInputByteBufferNano.readMessage(gVar);
                                    codedInputByteBufferNano.readTag();
                                    length3++;
                                }
                                b55.g gVar2 = new b55.g();
                                gVarArr2[length3] = gVar2;
                                codedInputByteBufferNano.readMessage(gVar2);
                                this.f451925d = gVarArr2;
                            }
                        } else {
                            this.f451924c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f451923b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    y45.b[] bVarArr = this.f451922a;
                    if (bVarArr == null) {
                        length4 = 0;
                    } else {
                        length4 = bVarArr.length;
                    }
                    int i19 = repeatedFieldArrayLength3 + length4;
                    y45.b[] bVarArr2 = new y45.b[i19];
                    if (length4 != 0) {
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length4);
                    }
                    while (length4 < i19 - 1) {
                        y45.b bVar = new y45.b();
                        bVarArr2[length4] = bVar;
                        codedInputByteBufferNano.readMessage(bVar);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    y45.b bVar2 = new y45.b();
                    bVarArr2[length4] = bVar2;
                    codedInputByteBufferNano.readMessage(bVar2);
                    this.f451922a = bVarArr2;
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
        y45.b[] bVarArr = this.f451922a;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                y45.b[] bVarArr2 = this.f451922a;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                y45.b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
                }
                i16++;
            }
        }
        int i17 = this.f451923b;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i17);
        }
        if (!Arrays.equals(this.f451924c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f451924c);
        }
        b55.g[] gVarArr = this.f451925d;
        if (gVarArr != null && gVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                b55.g[] gVarArr2 = this.f451925d;
                if (i18 >= gVarArr2.length) {
                    break;
                }
                b55.g gVar = gVarArr2[i18];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, gVar);
                }
                i18++;
            }
        }
        int[] iArr = this.f451926e;
        if (iArr != null && iArr.length > 0) {
            int i19 = 0;
            while (true) {
                int[] iArr2 = this.f451926e;
                if (i3 < iArr2.length) {
                    i19 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i3]);
                    i3++;
                } else {
                    return computeSerializedSize + i19 + (iArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        y45.b[] bVarArr = this.f451922a;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                y45.b[] bVarArr2 = this.f451922a;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                y45.b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bVar);
                }
                i16++;
            }
        }
        int i17 = this.f451923b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i17);
        }
        if (!Arrays.equals(this.f451924c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f451924c);
        }
        b55.g[] gVarArr = this.f451925d;
        if (gVarArr != null && gVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                b55.g[] gVarArr2 = this.f451925d;
                if (i18 >= gVarArr2.length) {
                    break;
                }
                b55.g gVar = gVarArr2[i18];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, gVar);
                }
                i18++;
            }
        }
        int[] iArr = this.f451926e;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.f451926e;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(10, iArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
