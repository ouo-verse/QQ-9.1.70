package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ao extends ExtendableMessageNano<ao> {

    /* renamed from: p, reason: collision with root package name */
    private static volatile ao[] f440182p;

    /* renamed from: a, reason: collision with root package name */
    public String f440183a;

    /* renamed from: b, reason: collision with root package name */
    public int f440184b;

    /* renamed from: c, reason: collision with root package name */
    public String f440185c;

    /* renamed from: d, reason: collision with root package name */
    public String f440186d;

    /* renamed from: e, reason: collision with root package name */
    public String f440187e;

    /* renamed from: f, reason: collision with root package name */
    public String f440188f;

    /* renamed from: g, reason: collision with root package name */
    public bj[] f440189g;

    /* renamed from: h, reason: collision with root package name */
    public String f440190h;

    /* renamed from: i, reason: collision with root package name */
    public int f440191i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f440192j;

    /* renamed from: k, reason: collision with root package name */
    public int f440193k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f440194l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f440195m;

    /* renamed from: n, reason: collision with root package name */
    public pu4.g f440196n;

    /* renamed from: o, reason: collision with root package name */
    public int f440197o;

    public ao() {
        a();
    }

    public static ao[] b() {
        if (f440182p == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440182p == null) {
                    f440182p = new ao[0];
                }
            }
        }
        return f440182p;
    }

    public ao a() {
        this.f440183a = "";
        this.f440184b = 0;
        this.f440185c = "";
        this.f440186d = "";
        this.f440187e = "";
        this.f440188f = "";
        this.f440189g = bj.b();
        this.f440190h = "";
        this.f440191i = 0;
        this.f440192j = false;
        this.f440193k = 0;
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.f440194l = iArr;
        this.f440195m = iArr;
        this.f440196n = null;
        this.f440197o = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ao mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f440183a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f440184b = codedInputByteBufferNano.readInt32();
                    break;
                case 26:
                    this.f440185c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f440186d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f440187e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f440188f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    bj[] bjVarArr = this.f440189g;
                    int length = bjVarArr == null ? 0 : bjVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    bj[] bjVarArr2 = new bj[i3];
                    if (length != 0) {
                        System.arraycopy(bjVarArr, 0, bjVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        bj bjVar = new bj();
                        bjVarArr2[length] = bjVar;
                        codedInputByteBufferNano.readMessage(bjVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    bj bjVar2 = new bj();
                    bjVarArr2[length] = bjVar2;
                    codedInputByteBufferNano.readMessage(bjVar2);
                    this.f440189g = bjVarArr2;
                    break;
                case 66:
                    this.f440190h = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.f440191i = codedInputByteBufferNano.readInt32();
                    break;
                case 80:
                    this.f440192j = codedInputByteBufferNano.readBool();
                    break;
                case 88:
                    this.f440193k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 96);
                    int[] iArr = this.f440194l;
                    int length2 = iArr == null ? 0 : iArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    int[] iArr2 = new int[i16];
                    if (length2 != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        iArr2[length2] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    iArr2[length2] = codedInputByteBufferNano.readUInt32();
                    this.f440194l = iArr2;
                    break;
                case 98:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i17 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i17++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f440194l;
                    int length3 = iArr3 == null ? 0 : iArr3.length;
                    int i18 = i17 + length3;
                    int[] iArr4 = new int[i18];
                    if (length3 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length3);
                    }
                    while (length3 < i18) {
                        iArr4[length3] = codedInputByteBufferNano.readUInt32();
                        length3++;
                    }
                    this.f440194l = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 104:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 104);
                    int[] iArr5 = this.f440195m;
                    int length4 = iArr5 == null ? 0 : iArr5.length;
                    int i19 = repeatedFieldArrayLength3 + length4;
                    int[] iArr6 = new int[i19];
                    if (length4 != 0) {
                        System.arraycopy(iArr5, 0, iArr6, 0, length4);
                    }
                    while (length4 < i19 - 1) {
                        iArr6[length4] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    iArr6[length4] = codedInputByteBufferNano.readUInt32();
                    this.f440195m = iArr6;
                    break;
                case 106:
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i26 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i26++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    int[] iArr7 = this.f440195m;
                    int length5 = iArr7 == null ? 0 : iArr7.length;
                    int i27 = i26 + length5;
                    int[] iArr8 = new int[i27];
                    if (length5 != 0) {
                        System.arraycopy(iArr7, 0, iArr8, 0, length5);
                    }
                    while (length5 < i27) {
                        iArr8[length5] = codedInputByteBufferNano.readUInt32();
                        length5++;
                    }
                    this.f440195m = iArr8;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                    break;
                case 114:
                    if (this.f440196n == null) {
                        this.f440196n = new pu4.g();
                    }
                    codedInputByteBufferNano.readMessage(this.f440196n);
                    break;
                case 120:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f440197o = readInt32;
                        break;
                    }
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int[] iArr2;
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440183a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440183a);
        }
        int i3 = this.f440184b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f440185c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440185c);
        }
        if (!this.f440186d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440186d);
        }
        if (!this.f440187e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440187e);
        }
        if (!this.f440188f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f440188f);
        }
        bj[] bjVarArr = this.f440189g;
        int i16 = 0;
        if (bjVarArr != null && bjVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                bj[] bjVarArr2 = this.f440189g;
                if (i17 >= bjVarArr2.length) {
                    break;
                }
                bj bjVar = bjVarArr2[i17];
                if (bjVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, bjVar);
                }
                i17++;
            }
        }
        if (!this.f440190h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f440190h);
        }
        int i18 = this.f440191i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i18);
        }
        boolean z16 = this.f440192j;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z16);
        }
        int i19 = this.f440193k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i19);
        }
        int[] iArr3 = this.f440194l;
        if (iArr3 != null && iArr3.length > 0) {
            int i26 = 0;
            int i27 = 0;
            while (true) {
                iArr2 = this.f440194l;
                if (i26 >= iArr2.length) {
                    break;
                }
                i27 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i26]);
                i26++;
            }
            computeSerializedSize = computeSerializedSize + i27 + (iArr2.length * 1);
        }
        int[] iArr4 = this.f440195m;
        if (iArr4 != null && iArr4.length > 0) {
            int i28 = 0;
            while (true) {
                iArr = this.f440195m;
                if (i16 >= iArr.length) {
                    break;
                }
                i28 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i28 + (iArr.length * 1);
        }
        pu4.g gVar = this.f440196n;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, gVar);
        }
        int i29 = this.f440197o;
        return i29 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(15, i29) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440183a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440183a);
        }
        int i3 = this.f440184b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f440185c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440185c);
        }
        if (!this.f440186d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440186d);
        }
        if (!this.f440187e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440187e);
        }
        if (!this.f440188f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440188f);
        }
        bj[] bjVarArr = this.f440189g;
        int i16 = 0;
        if (bjVarArr != null && bjVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                bj[] bjVarArr2 = this.f440189g;
                if (i17 >= bjVarArr2.length) {
                    break;
                }
                bj bjVar = bjVarArr2[i17];
                if (bjVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, bjVar);
                }
                i17++;
            }
        }
        if (!this.f440190h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f440190h);
        }
        int i18 = this.f440191i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i18);
        }
        boolean z16 = this.f440192j;
        if (z16) {
            codedOutputByteBufferNano.writeBool(10, z16);
        }
        int i19 = this.f440193k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i19);
        }
        int[] iArr = this.f440194l;
        if (iArr != null && iArr.length > 0) {
            int i26 = 0;
            while (true) {
                int[] iArr2 = this.f440194l;
                if (i26 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(12, iArr2[i26]);
                i26++;
            }
        }
        int[] iArr3 = this.f440195m;
        if (iArr3 != null && iArr3.length > 0) {
            while (true) {
                int[] iArr4 = this.f440195m;
                if (i16 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(13, iArr4[i16]);
                i16++;
            }
        }
        pu4.g gVar = this.f440196n;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(14, gVar);
        }
        int i27 = this.f440197o;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
