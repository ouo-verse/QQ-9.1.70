package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bj extends ExtendableMessageNano<bj> {

    /* renamed from: p, reason: collision with root package name */
    private static volatile bj[] f440348p;

    /* renamed from: a, reason: collision with root package name */
    public String f440349a;

    /* renamed from: b, reason: collision with root package name */
    public int f440350b;

    /* renamed from: c, reason: collision with root package name */
    public String f440351c;

    /* renamed from: d, reason: collision with root package name */
    public String f440352d;

    /* renamed from: e, reason: collision with root package name */
    public String f440353e;

    /* renamed from: f, reason: collision with root package name */
    public String f440354f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f440355g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f440356h;

    /* renamed from: i, reason: collision with root package name */
    public as f440357i;

    /* renamed from: j, reason: collision with root package name */
    public int f440358j;

    /* renamed from: k, reason: collision with root package name */
    public int f440359k;

    /* renamed from: l, reason: collision with root package name */
    public int f440360l;

    /* renamed from: m, reason: collision with root package name */
    public bh f440361m;

    /* renamed from: n, reason: collision with root package name */
    public int f440362n;

    /* renamed from: o, reason: collision with root package name */
    public String f440363o;

    public bj() {
        a();
    }

    public static bj[] b() {
        if (f440348p == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440348p == null) {
                    f440348p = new bj[0];
                }
            }
        }
        return f440348p;
    }

    public bj a() {
        this.f440349a = "";
        this.f440350b = 0;
        this.f440351c = "";
        this.f440352d = "";
        this.f440353e = "";
        this.f440354f = "";
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.f440355g = iArr;
        this.f440356h = iArr;
        this.f440357i = null;
        this.f440358j = 0;
        this.f440359k = 0;
        this.f440360l = 0;
        this.f440361m = null;
        this.f440362n = 0;
        this.f440363o = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f440349a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f440350b = codedInputByteBufferNano.readInt32();
                    break;
                case 26:
                    this.f440351c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f440352d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f440353e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f440354f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 56);
                    int[] iArr = this.f440355g;
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
                    this.f440355g = iArr2;
                    break;
                case 58:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f440355g;
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
                    this.f440355g = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 64:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 64);
                    int[] iArr5 = this.f440356h;
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
                    this.f440356h = iArr6;
                    break;
                case 66:
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i19 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i19++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    int[] iArr7 = this.f440356h;
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
                    this.f440356h = iArr8;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                    break;
                case 74:
                    if (this.f440357i == null) {
                        this.f440357i = new as();
                    }
                    codedInputByteBufferNano.readMessage(this.f440357i);
                    break;
                case 80:
                    this.f440358j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f440359k = codedInputByteBufferNano.readInt32();
                    break;
                case 96:
                    this.f440360l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    if (this.f440361m == null) {
                        this.f440361m = new bh();
                    }
                    codedInputByteBufferNano.readMessage(this.f440361m);
                    break;
                case 112:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f440362n = readInt32;
                        break;
                    }
                case 122:
                    this.f440363o = codedInputByteBufferNano.readString();
                    break;
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
        if (!this.f440349a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440349a);
        }
        int i3 = this.f440350b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f440351c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440351c);
        }
        if (!this.f440352d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440352d);
        }
        if (!this.f440353e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440353e);
        }
        if (!this.f440354f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f440354f);
        }
        int[] iArr3 = this.f440355g;
        int i16 = 0;
        if (iArr3 != null && iArr3.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                iArr2 = this.f440355g;
                if (i17 >= iArr2.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (iArr2.length * 1);
        }
        int[] iArr4 = this.f440356h;
        if (iArr4 != null && iArr4.length > 0) {
            int i19 = 0;
            while (true) {
                iArr = this.f440356h;
                if (i16 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        as asVar = this.f440357i;
        if (asVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, asVar);
        }
        int i26 = this.f440358j;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i26);
        }
        int i27 = this.f440359k;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i27);
        }
        int i28 = this.f440360l;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i28);
        }
        bh bhVar = this.f440361m;
        if (bhVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, bhVar);
        }
        int i29 = this.f440362n;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i29);
        }
        return !this.f440363o.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(15, this.f440363o) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440349a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440349a);
        }
        int i3 = this.f440350b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f440351c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440351c);
        }
        if (!this.f440352d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440352d);
        }
        if (!this.f440353e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440353e);
        }
        if (!this.f440354f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440354f);
        }
        int[] iArr = this.f440355g;
        int i16 = 0;
        if (iArr != null && iArr.length > 0) {
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.f440355g;
                if (i17 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(7, iArr2[i17]);
                i17++;
            }
        }
        int[] iArr3 = this.f440356h;
        if (iArr3 != null && iArr3.length > 0) {
            while (true) {
                int[] iArr4 = this.f440356h;
                if (i16 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(8, iArr4[i16]);
                i16++;
            }
        }
        as asVar = this.f440357i;
        if (asVar != null) {
            codedOutputByteBufferNano.writeMessage(9, asVar);
        }
        int i18 = this.f440358j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i18);
        }
        int i19 = this.f440359k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i19);
        }
        int i26 = this.f440360l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        bh bhVar = this.f440361m;
        if (bhVar != null) {
            codedOutputByteBufferNano.writeMessage(13, bhVar);
        }
        int i27 = this.f440362n;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i27);
        }
        if (!this.f440363o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f440363o);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
