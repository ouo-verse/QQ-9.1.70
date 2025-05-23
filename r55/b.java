package r55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: t, reason: collision with root package name */
    private static volatile b[] f430777t;

    /* renamed from: a, reason: collision with root package name */
    public String f430778a;

    /* renamed from: b, reason: collision with root package name */
    public String f430779b;

    /* renamed from: c, reason: collision with root package name */
    public String f430780c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f430781d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f430782e;

    /* renamed from: f, reason: collision with root package name */
    public String f430783f;

    /* renamed from: g, reason: collision with root package name */
    public String f430784g;

    /* renamed from: h, reason: collision with root package name */
    public a f430785h;

    /* renamed from: i, reason: collision with root package name */
    public String f430786i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f430787j;

    /* renamed from: k, reason: collision with root package name */
    public int f430788k;

    /* renamed from: l, reason: collision with root package name */
    public int f430789l;

    /* renamed from: m, reason: collision with root package name */
    public int f430790m;

    /* renamed from: n, reason: collision with root package name */
    public int f430791n;

    /* renamed from: o, reason: collision with root package name */
    public int f430792o;

    /* renamed from: p, reason: collision with root package name */
    public String f430793p;

    /* renamed from: q, reason: collision with root package name */
    public n55.a[] f430794q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f430795r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f430796s;

    public b() {
        a();
    }

    public static b[] b() {
        if (f430777t == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430777t == null) {
                    f430777t = new b[0];
                }
            }
        }
        return f430777t;
    }

    public b a() {
        this.f430778a = "";
        this.f430779b = "";
        this.f430780c = "";
        this.f430781d = false;
        this.f430782e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f430783f = "";
        this.f430784g = "";
        this.f430785h = null;
        this.f430786i = "";
        this.f430787j = false;
        this.f430788k = 0;
        this.f430789l = 0;
        this.f430790m = 0;
        this.f430791n = 0;
        this.f430792o = 0;
        this.f430793p = "";
        this.f430794q = n55.a.b();
        this.f430795r = false;
        this.f430796s = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f430778a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f430779b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f430780c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f430781d = codedInputByteBufferNano.readBool();
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    String[] strArr = this.f430782e;
                    int length = strArr == null ? 0 : strArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i3];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.f430782e = strArr2;
                    break;
                case 50:
                    this.f430783f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f430784g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    if (this.f430785h == null) {
                        this.f430785h = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f430785h);
                    break;
                case 74:
                    this.f430786i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f430787j = codedInputByteBufferNano.readBool();
                    break;
                case 88:
                    this.f430788k = codedInputByteBufferNano.readInt32();
                    break;
                case 96:
                    this.f430789l = codedInputByteBufferNano.readInt32();
                    break;
                case 104:
                    this.f430790m = codedInputByteBufferNano.readInt32();
                    break;
                case 112:
                    this.f430791n = codedInputByteBufferNano.readInt32();
                    break;
                case 120:
                    this.f430792o = codedInputByteBufferNano.readInt32();
                    break;
                case 130:
                    this.f430793p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 138);
                    n55.a[] aVarArr = this.f430794q;
                    int length2 = aVarArr == null ? 0 : aVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    n55.a[] aVarArr2 = new n55.a[i16];
                    if (length2 != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        n55.a aVar = new n55.a();
                        aVarArr2[length2] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    n55.a aVar2 = new n55.a();
                    aVarArr2[length2] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f430794q = aVarArr2;
                    break;
                case 144:
                    this.f430795r = codedInputByteBufferNano.readBool();
                    break;
                case 152:
                    this.f430796s = codedInputByteBufferNano.readBool();
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
        if (!this.f430778a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f430778a);
        }
        if (!this.f430779b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430779b);
        }
        if (!this.f430780c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430780c);
        }
        boolean z16 = this.f430781d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        String[] strArr = this.f430782e;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f430782e;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        if (!this.f430783f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f430783f);
        }
        if (!this.f430784g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f430784g);
        }
        a aVar = this.f430785h;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, aVar);
        }
        if (!this.f430786i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f430786i);
        }
        boolean z17 = this.f430787j;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z17);
        }
        int i19 = this.f430788k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i19);
        }
        int i26 = this.f430789l;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i26);
        }
        int i27 = this.f430790m;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i27);
        }
        int i28 = this.f430791n;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i28);
        }
        int i29 = this.f430792o;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i29);
        }
        if (!this.f430793p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f430793p);
        }
        n55.a[] aVarArr = this.f430794q;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                n55.a[] aVarArr2 = this.f430794q;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                n55.a aVar2 = aVarArr2[i3];
                if (aVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, aVar2);
                }
                i3++;
            }
        }
        boolean z18 = this.f430795r;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(18, z18);
        }
        boolean z19 = this.f430796s;
        return z19 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(19, z19) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f430778a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f430778a);
        }
        if (!this.f430779b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430779b);
        }
        if (!this.f430780c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430780c);
        }
        boolean z16 = this.f430781d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        String[] strArr = this.f430782e;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f430782e;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(5, str);
                }
                i16++;
            }
        }
        if (!this.f430783f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f430783f);
        }
        if (!this.f430784g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f430784g);
        }
        a aVar = this.f430785h;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(8, aVar);
        }
        if (!this.f430786i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f430786i);
        }
        boolean z17 = this.f430787j;
        if (z17) {
            codedOutputByteBufferNano.writeBool(10, z17);
        }
        int i17 = this.f430788k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i17);
        }
        int i18 = this.f430789l;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i18);
        }
        int i19 = this.f430790m;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i19);
        }
        int i26 = this.f430791n;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i26);
        }
        int i27 = this.f430792o;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i27);
        }
        if (!this.f430793p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f430793p);
        }
        n55.a[] aVarArr = this.f430794q;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                n55.a[] aVarArr2 = this.f430794q;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                n55.a aVar2 = aVarArr2[i3];
                if (aVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(17, aVar2);
                }
                i3++;
            }
        }
        boolean z18 = this.f430795r;
        if (z18) {
            codedOutputByteBufferNano.writeBool(18, z18);
        }
        boolean z19 = this.f430796s;
        if (z19) {
            codedOutputByteBufferNano.writeBool(19, z19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
