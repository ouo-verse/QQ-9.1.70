package sr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {
    private static volatile g[] C;
    public String A;
    public a B;

    /* renamed from: a, reason: collision with root package name */
    public int f434385a;

    /* renamed from: b, reason: collision with root package name */
    public String f434386b;

    /* renamed from: c, reason: collision with root package name */
    public String f434387c;

    /* renamed from: d, reason: collision with root package name */
    public int f434388d;

    /* renamed from: e, reason: collision with root package name */
    public long f434389e;

    /* renamed from: f, reason: collision with root package name */
    public long f434390f;

    /* renamed from: g, reason: collision with root package name */
    public int f434391g;

    /* renamed from: h, reason: collision with root package name */
    public String f434392h;

    /* renamed from: i, reason: collision with root package name */
    public String f434393i;

    /* renamed from: j, reason: collision with root package name */
    public String f434394j;

    /* renamed from: k, reason: collision with root package name */
    public int f434395k;

    /* renamed from: l, reason: collision with root package name */
    public int f434396l;

    /* renamed from: m, reason: collision with root package name */
    public int f434397m;

    /* renamed from: n, reason: collision with root package name */
    public int f434398n;

    /* renamed from: o, reason: collision with root package name */
    public long f434399o;

    /* renamed from: p, reason: collision with root package name */
    public long f434400p;

    /* renamed from: q, reason: collision with root package name */
    public int f434401q;

    /* renamed from: r, reason: collision with root package name */
    public int f434402r;

    /* renamed from: s, reason: collision with root package name */
    public String f434403s;

    /* renamed from: t, reason: collision with root package name */
    public long f434404t;

    /* renamed from: u, reason: collision with root package name */
    public String f434405u;

    /* renamed from: v, reason: collision with root package name */
    public String f434406v;

    /* renamed from: w, reason: collision with root package name */
    public String f434407w;

    /* renamed from: z, reason: collision with root package name */
    public String f434408z;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends ExtendableMessageNano<a> {

        /* renamed from: a, reason: collision with root package name */
        public String f434409a;

        /* renamed from: b, reason: collision with root package name */
        public String f434410b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f434411c;

        public a() {
            a();
        }

        public a a() {
            this.f434409a = "";
            this.f434410b = "";
            this.f434411c = WireFormatNano.EMPTY_STRING_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int length;
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag != 0) {
                    if (readTag != 10) {
                        if (readTag != 18) {
                            if (readTag != 26) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                                String[] strArr = this.f434411c;
                                if (strArr == null) {
                                    length = 0;
                                } else {
                                    length = strArr.length;
                                }
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
                                this.f434411c = strArr2;
                            }
                        } else {
                            this.f434410b = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f434409a = codedInputByteBufferNano.readString();
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
            if (!this.f434409a.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f434409a);
            }
            if (!this.f434410b.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434410b);
            }
            String[] strArr = this.f434411c;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    String[] strArr2 = this.f434411c;
                    if (i3 < strArr2.length) {
                        String str = strArr2[i3];
                        if (str != null) {
                            i17++;
                            i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                        }
                        i3++;
                    } else {
                        return computeSerializedSize + i16 + (i17 * 1);
                    }
                }
            } else {
                return computeSerializedSize;
            }
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.f434409a.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.f434409a);
            }
            if (!this.f434410b.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.f434410b);
            }
            String[] strArr = this.f434411c;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.f434411c;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(3, str);
                    }
                    i3++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public g() {
        a();
    }

    public static g[] b() {
        if (C == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (C == null) {
                    C = new g[0];
                }
            }
        }
        return C;
    }

    public g a() {
        this.f434385a = 0;
        this.f434386b = "";
        this.f434387c = "";
        this.f434388d = 0;
        this.f434389e = 0L;
        this.f434390f = 0L;
        this.f434391g = 0;
        this.f434392h = "";
        this.f434393i = "";
        this.f434394j = "";
        this.f434395k = 0;
        this.f434396l = 0;
        this.f434397m = 0;
        this.f434398n = 0;
        this.f434399o = 0L;
        this.f434400p = 0L;
        this.f434401q = 0;
        this.f434402r = 0;
        this.f434403s = "";
        this.f434404t = 0L;
        this.f434405u = "";
        this.f434406v = "";
        this.f434407w = "";
        this.f434408z = "";
        this.A = "";
        this.B = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f434385a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f434386b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f434387c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f434388d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f434389e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f434390f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.f434391g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.f434392h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f434393i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f434394j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f434395k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f434396l = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.f434397m = codedInputByteBufferNano.readUInt32();
                    break;
                case 112:
                    this.f434398n = codedInputByteBufferNano.readUInt32();
                    break;
                case 120:
                    this.f434399o = codedInputByteBufferNano.readUInt64();
                    break;
                case 128:
                    this.f434400p = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.f434401q = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    this.f434402r = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    this.f434403s = codedInputByteBufferNano.readString();
                    break;
                case 160:
                    this.f434404t = codedInputByteBufferNano.readUInt64();
                    break;
                case 170:
                    this.f434405u = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    this.f434406v = codedInputByteBufferNano.readString();
                    break;
                case 210:
                    this.f434407w = codedInputByteBufferNano.readString();
                    break;
                case 218:
                    this.f434408z = codedInputByteBufferNano.readString();
                    break;
                case 226:
                    this.A = codedInputByteBufferNano.readString();
                    break;
                case 234:
                    if (this.B == null) {
                        this.B = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.B);
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
        int i3 = this.f434385a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f434386b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434386b);
        }
        if (!this.f434387c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434387c);
        }
        int i16 = this.f434388d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        long j3 = this.f434389e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        long j16 = this.f434390f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        int i17 = this.f434391g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        if (!this.f434392h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f434392h);
        }
        if (!this.f434393i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f434393i);
        }
        if (!this.f434394j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f434394j);
        }
        int i18 = this.f434395k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        int i19 = this.f434396l;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i19);
        }
        int i26 = this.f434397m;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i26);
        }
        int i27 = this.f434398n;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i27);
        }
        long j17 = this.f434399o;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j17);
        }
        long j18 = this.f434400p;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j18);
        }
        int i28 = this.f434401q;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i28);
        }
        int i29 = this.f434402r;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i29);
        }
        if (!this.f434403s.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.f434403s);
        }
        long j19 = this.f434404t;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(20, j19);
        }
        if (!this.f434405u.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.f434405u);
        }
        if (!this.f434406v.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.f434406v);
        }
        if (!this.f434407w.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(26, this.f434407w);
        }
        if (!this.f434408z.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(27, this.f434408z);
        }
        if (!this.A.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(28, this.A);
        }
        a aVar = this.B;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(29, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f434385a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f434386b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434386b);
        }
        if (!this.f434387c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434387c);
        }
        int i16 = this.f434388d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        long j3 = this.f434389e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        long j16 = this.f434390f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        int i17 = this.f434391g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        if (!this.f434392h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f434392h);
        }
        if (!this.f434393i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f434393i);
        }
        if (!this.f434394j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f434394j);
        }
        int i18 = this.f434395k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        int i19 = this.f434396l;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i19);
        }
        int i26 = this.f434397m;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i26);
        }
        int i27 = this.f434398n;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i27);
        }
        long j17 = this.f434399o;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(15, j17);
        }
        long j18 = this.f434400p;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j18);
        }
        int i28 = this.f434401q;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i28);
        }
        int i29 = this.f434402r;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i29);
        }
        if (!this.f434403s.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.f434403s);
        }
        long j19 = this.f434404t;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(20, j19);
        }
        if (!this.f434405u.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.f434405u);
        }
        if (!this.f434406v.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.f434406v);
        }
        if (!this.f434407w.equals("")) {
            codedOutputByteBufferNano.writeString(26, this.f434407w);
        }
        if (!this.f434408z.equals("")) {
            codedOutputByteBufferNano.writeString(27, this.f434408z);
        }
        if (!this.A.equals("")) {
            codedOutputByteBufferNano.writeString(28, this.A);
        }
        a aVar = this.B;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(29, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
