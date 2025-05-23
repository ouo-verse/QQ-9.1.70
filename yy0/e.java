package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public r[] f451437a;

    /* renamed from: b, reason: collision with root package name */
    public int f451438b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f451439c;

    /* renamed from: d, reason: collision with root package name */
    public int f451440d;

    /* renamed from: e, reason: collision with root package name */
    public i[] f451441e;

    public e() {
        a();
    }

    public e a() {
        this.f451437a = r.b();
        this.f451438b = 0;
        this.f451439c = WireFormatNano.EMPTY_INT_ARRAY;
        this.f451440d = 0;
        this.f451441e = i.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        int length4;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 26) {
                                if (readTag != 32) {
                                    if (readTag != 42) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                        i[] iVarArr = this.f451441e;
                                        if (iVarArr == null) {
                                            length = 0;
                                        } else {
                                            length = iVarArr.length;
                                        }
                                        int i3 = repeatedFieldArrayLength + length;
                                        i[] iVarArr2 = new i[i3];
                                        if (length != 0) {
                                            System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                                        }
                                        while (length < i3 - 1) {
                                            i iVar = new i();
                                            iVarArr2[length] = iVar;
                                            codedInputByteBufferNano.readMessage(iVar);
                                            codedInputByteBufferNano.readTag();
                                            length++;
                                        }
                                        i iVar2 = new i();
                                        iVarArr2[length] = iVar2;
                                        codedInputByteBufferNano.readMessage(iVar2);
                                        this.f451441e = iVarArr2;
                                    }
                                } else {
                                    this.f451440d = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                int position = codedInputByteBufferNano.getPosition();
                                int i16 = 0;
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    codedInputByteBufferNano.readInt32();
                                    i16++;
                                }
                                codedInputByteBufferNano.rewindToPosition(position);
                                int[] iArr = this.f451439c;
                                if (iArr == null) {
                                    length2 = 0;
                                } else {
                                    length2 = iArr.length;
                                }
                                int i17 = i16 + length2;
                                int[] iArr2 = new int[i17];
                                if (length2 != 0) {
                                    System.arraycopy(iArr, 0, iArr2, 0, length2);
                                }
                                while (length2 < i17) {
                                    iArr2[length2] = codedInputByteBufferNano.readInt32();
                                    length2++;
                                }
                                this.f451439c = iArr2;
                                codedInputByteBufferNano.popLimit(pushLimit);
                            }
                        } else {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                            int[] iArr3 = this.f451439c;
                            if (iArr3 == null) {
                                length3 = 0;
                            } else {
                                length3 = iArr3.length;
                            }
                            int i18 = repeatedFieldArrayLength2 + length3;
                            int[] iArr4 = new int[i18];
                            if (length3 != 0) {
                                System.arraycopy(iArr3, 0, iArr4, 0, length3);
                            }
                            while (length3 < i18 - 1) {
                                iArr4[length3] = codedInputByteBufferNano.readInt32();
                                codedInputByteBufferNano.readTag();
                                length3++;
                            }
                            iArr4[length3] = codedInputByteBufferNano.readInt32();
                            this.f451439c = iArr4;
                        }
                    } else {
                        this.f451438b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    r[] rVarArr = this.f451437a;
                    if (rVarArr == null) {
                        length4 = 0;
                    } else {
                        length4 = rVarArr.length;
                    }
                    int i19 = repeatedFieldArrayLength3 + length4;
                    r[] rVarArr2 = new r[i19];
                    if (length4 != 0) {
                        System.arraycopy(rVarArr, 0, rVarArr2, 0, length4);
                    }
                    while (length4 < i19 - 1) {
                        r rVar = new r();
                        rVarArr2[length4] = rVar;
                        codedInputByteBufferNano.readMessage(rVar);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    r rVar2 = new r();
                    rVarArr2[length4] = rVar2;
                    codedInputByteBufferNano.readMessage(rVar2);
                    this.f451437a = rVarArr2;
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
        r[] rVarArr = this.f451437a;
        int i3 = 0;
        if (rVarArr != null && rVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                r[] rVarArr2 = this.f451437a;
                if (i16 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i16];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
                }
                i16++;
            }
        }
        int i17 = this.f451438b;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i17);
        }
        int[] iArr2 = this.f451439c;
        if (iArr2 != null && iArr2.length > 0) {
            int i18 = 0;
            int i19 = 0;
            while (true) {
                iArr = this.f451439c;
                if (i18 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i18]);
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        int i26 = this.f451440d;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i26);
        }
        i[] iVarArr = this.f451441e;
        if (iVarArr != null && iVarArr.length > 0) {
            while (true) {
                i[] iVarArr2 = this.f451441e;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, iVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        r[] rVarArr = this.f451437a;
        int i3 = 0;
        if (rVarArr != null && rVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                r[] rVarArr2 = this.f451437a;
                if (i16 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i16];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, rVar);
                }
                i16++;
            }
        }
        int i17 = this.f451438b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i17);
        }
        int[] iArr = this.f451439c;
        if (iArr != null && iArr.length > 0) {
            int i18 = 0;
            while (true) {
                int[] iArr2 = this.f451439c;
                if (i18 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(3, iArr2[i18]);
                i18++;
            }
        }
        int i19 = this.f451440d;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i19);
        }
        i[] iVarArr = this.f451441e;
        if (iVarArr != null && iVarArr.length > 0) {
            while (true) {
                i[] iVarArr2 = this.f451441e;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, iVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
