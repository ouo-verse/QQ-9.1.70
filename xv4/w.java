package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: u, reason: collision with root package name */
    private static volatile w[] f448831u;

    /* renamed from: a, reason: collision with root package name */
    public long f448832a;

    /* renamed from: b, reason: collision with root package name */
    public int f448833b;

    /* renamed from: c, reason: collision with root package name */
    public int f448834c;

    /* renamed from: d, reason: collision with root package name */
    public String f448835d;

    /* renamed from: e, reason: collision with root package name */
    public long f448836e;

    /* renamed from: f, reason: collision with root package name */
    public long f448837f;

    /* renamed from: g, reason: collision with root package name */
    public int f448838g;

    /* renamed from: h, reason: collision with root package name */
    public int f448839h;

    /* renamed from: i, reason: collision with root package name */
    public String f448840i;

    /* renamed from: j, reason: collision with root package name */
    public String f448841j;

    /* renamed from: k, reason: collision with root package name */
    public int f448842k;

    /* renamed from: l, reason: collision with root package name */
    public int f448843l;

    /* renamed from: m, reason: collision with root package name */
    public z[] f448844m;

    /* renamed from: n, reason: collision with root package name */
    public long f448845n;

    /* renamed from: o, reason: collision with root package name */
    public long f448846o;

    /* renamed from: p, reason: collision with root package name */
    public int f448847p;

    /* renamed from: q, reason: collision with root package name */
    public String f448848q;

    /* renamed from: r, reason: collision with root package name */
    public long f448849r;

    /* renamed from: s, reason: collision with root package name */
    public String[] f448850s;

    /* renamed from: t, reason: collision with root package name */
    public String f448851t;

    public w() {
        a();
    }

    public static w[] b() {
        if (f448831u == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448831u == null) {
                    f448831u = new w[0];
                }
            }
        }
        return f448831u;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f448832a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f448833b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f448834c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f448835d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f448836e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f448837f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.f448838g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f448839h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f448840i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f448841j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f448842k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f448843l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    z[] zVarArr = this.f448844m;
                    int length = zVarArr == null ? 0 : zVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    z[] zVarArr2 = new z[i3];
                    if (length != 0) {
                        System.arraycopy(zVarArr, 0, zVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        z zVar = new z();
                        zVarArr2[length] = zVar;
                        codedInputByteBufferNano.readMessage(zVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    z zVar2 = new z();
                    zVarArr2[length] = zVar2;
                    codedInputByteBufferNano.readMessage(zVar2);
                    this.f448844m = zVarArr2;
                    break;
                case 112:
                    this.f448845n = codedInputByteBufferNano.readUInt64();
                    break;
                case 128:
                    this.f448846o = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.f448847p = codedInputByteBufferNano.readUInt32();
                    break;
                case 146:
                    this.f448848q = codedInputByteBufferNano.readString();
                    break;
                case 152:
                    this.f448849r = codedInputByteBufferNano.readUInt64();
                    break;
                case 162:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    String[] strArr = this.f448850s;
                    int length2 = strArr == null ? 0 : strArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    String[] strArr2 = new String[i16];
                    if (length2 != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        strArr2[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    this.f448850s = strArr2;
                    break;
                case 170:
                    this.f448851t = codedInputByteBufferNano.readString();
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
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f448832a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f448833b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f448834c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        if (!this.f448835d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448835d);
        }
        long j16 = this.f448836e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        long j17 = this.f448837f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        int i17 = this.f448838g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        int i18 = this.f448839h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        if (!this.f448840i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f448840i);
        }
        if (!this.f448841j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f448841j);
        }
        int i19 = this.f448842k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i19);
        }
        int i26 = this.f448843l;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i26);
        }
        z[] zVarArr = this.f448844m;
        int i27 = 0;
        if (zVarArr != null && zVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                z[] zVarArr2 = this.f448844m;
                if (i28 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i28];
                if (zVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, zVar);
                }
                i28++;
            }
        }
        long j18 = this.f448845n;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j18);
        }
        long j19 = this.f448846o;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j19);
        }
        int i29 = this.f448847p;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i29);
        }
        if (!this.f448848q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f448848q);
        }
        long j26 = this.f448849r;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(19, j26);
        }
        String[] strArr = this.f448850s;
        if (strArr != null && strArr.length > 0) {
            int i36 = 0;
            int i37 = 0;
            while (true) {
                String[] strArr2 = this.f448850s;
                if (i27 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i27];
                if (str != null) {
                    i37++;
                    i36 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i27++;
            }
            computeSerializedSize = computeSerializedSize + i36 + (i37 * 2);
        }
        return !this.f448851t.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(21, this.f448851t) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448832a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f448833b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f448834c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!this.f448835d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448835d);
        }
        long j16 = this.f448836e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        long j17 = this.f448837f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        int i17 = this.f448838g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        int i18 = this.f448839h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        if (!this.f448840i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f448840i);
        }
        if (!this.f448841j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f448841j);
        }
        int i19 = this.f448842k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i19);
        }
        int i26 = this.f448843l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        z[] zVarArr = this.f448844m;
        int i27 = 0;
        if (zVarArr != null && zVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                z[] zVarArr2 = this.f448844m;
                if (i28 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i28];
                if (zVar != null) {
                    codedOutputByteBufferNano.writeMessage(13, zVar);
                }
                i28++;
            }
        }
        long j18 = this.f448845n;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(14, j18);
        }
        long j19 = this.f448846o;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j19);
        }
        int i29 = this.f448847p;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i29);
        }
        if (!this.f448848q.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f448848q);
        }
        long j26 = this.f448849r;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(19, j26);
        }
        String[] strArr = this.f448850s;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.f448850s;
                if (i27 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i27];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(20, str);
                }
                i27++;
            }
        }
        if (!this.f448851t.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.f448851t);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public w a() {
        this.f448832a = 0L;
        this.f448833b = 0;
        this.f448834c = 0;
        this.f448835d = "";
        this.f448836e = 0L;
        this.f448837f = 0L;
        this.f448838g = 0;
        this.f448839h = 0;
        this.f448840i = "";
        this.f448841j = "";
        this.f448842k = 0;
        this.f448843l = 0;
        this.f448844m = z.b();
        this.f448845n = 0L;
        this.f448846o = 0L;
        this.f448847p = 0;
        this.f448848q = "";
        this.f448849r = 0L;
        this.f448850s = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f448851t = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
