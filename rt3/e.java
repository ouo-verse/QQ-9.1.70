package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public ae[] f432278a;

    /* renamed from: b, reason: collision with root package name */
    public int f432279b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f432280c;

    /* renamed from: d, reason: collision with root package name */
    public int f432281d;

    /* renamed from: e, reason: collision with root package name */
    public l[] f432282e;

    public e() {
        a();
    }

    public e a() {
        this.f432278a = ae.b();
        this.f432279b = 0;
        this.f432280c = WireFormatNano.EMPTY_INT_ARRAY;
        this.f432281d = 0;
        this.f432282e = l.b();
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
                                        l[] lVarArr = this.f432282e;
                                        if (lVarArr == null) {
                                            length = 0;
                                        } else {
                                            length = lVarArr.length;
                                        }
                                        int i3 = repeatedFieldArrayLength + length;
                                        l[] lVarArr2 = new l[i3];
                                        if (length != 0) {
                                            System.arraycopy(lVarArr, 0, lVarArr2, 0, length);
                                        }
                                        while (length < i3 - 1) {
                                            l lVar = new l();
                                            lVarArr2[length] = lVar;
                                            codedInputByteBufferNano.readMessage(lVar);
                                            codedInputByteBufferNano.readTag();
                                            length++;
                                        }
                                        l lVar2 = new l();
                                        lVarArr2[length] = lVar2;
                                        codedInputByteBufferNano.readMessage(lVar2);
                                        this.f432282e = lVarArr2;
                                    }
                                } else {
                                    this.f432281d = codedInputByteBufferNano.readInt32();
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
                                int[] iArr = this.f432280c;
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
                                this.f432280c = iArr2;
                                codedInputByteBufferNano.popLimit(pushLimit);
                            }
                        } else {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                            int[] iArr3 = this.f432280c;
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
                            this.f432280c = iArr4;
                        }
                    } else {
                        this.f432279b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    ae[] aeVarArr = this.f432278a;
                    if (aeVarArr == null) {
                        length4 = 0;
                    } else {
                        length4 = aeVarArr.length;
                    }
                    int i19 = repeatedFieldArrayLength3 + length4;
                    ae[] aeVarArr2 = new ae[i19];
                    if (length4 != 0) {
                        System.arraycopy(aeVarArr, 0, aeVarArr2, 0, length4);
                    }
                    while (length4 < i19 - 1) {
                        ae aeVar = new ae();
                        aeVarArr2[length4] = aeVar;
                        codedInputByteBufferNano.readMessage(aeVar);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    ae aeVar2 = new ae();
                    aeVarArr2[length4] = aeVar2;
                    codedInputByteBufferNano.readMessage(aeVar2);
                    this.f432278a = aeVarArr2;
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
        ae[] aeVarArr = this.f432278a;
        int i3 = 0;
        if (aeVarArr != null && aeVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ae[] aeVarArr2 = this.f432278a;
                if (i16 >= aeVarArr2.length) {
                    break;
                }
                ae aeVar = aeVarArr2[i16];
                if (aeVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aeVar);
                }
                i16++;
            }
        }
        int i17 = this.f432279b;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i17);
        }
        int[] iArr2 = this.f432280c;
        if (iArr2 != null && iArr2.length > 0) {
            int i18 = 0;
            int i19 = 0;
            while (true) {
                iArr = this.f432280c;
                if (i18 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i18]);
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        int i26 = this.f432281d;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i26);
        }
        l[] lVarArr = this.f432282e;
        if (lVarArr != null && lVarArr.length > 0) {
            while (true) {
                l[] lVarArr2 = this.f432282e;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, lVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ae[] aeVarArr = this.f432278a;
        int i3 = 0;
        if (aeVarArr != null && aeVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ae[] aeVarArr2 = this.f432278a;
                if (i16 >= aeVarArr2.length) {
                    break;
                }
                ae aeVar = aeVarArr2[i16];
                if (aeVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aeVar);
                }
                i16++;
            }
        }
        int i17 = this.f432279b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i17);
        }
        int[] iArr = this.f432280c;
        if (iArr != null && iArr.length > 0) {
            int i18 = 0;
            while (true) {
                int[] iArr2 = this.f432280c;
                if (i18 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(3, iArr2[i18]);
                i18++;
            }
        }
        int i19 = this.f432281d;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i19);
        }
        l[] lVarArr = this.f432282e;
        if (lVarArr != null && lVarArr.length > 0) {
            while (true) {
                l[] lVarArr2 = this.f432282e;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, lVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
