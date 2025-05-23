package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ap extends ExtendableMessageNano<ap> {

    /* renamed from: z, reason: collision with root package name */
    private static volatile ap[] f429973z;

    /* renamed from: a, reason: collision with root package name */
    public int f429974a;

    /* renamed from: b, reason: collision with root package name */
    public int f429975b;

    /* renamed from: c, reason: collision with root package name */
    public String f429976c;

    /* renamed from: d, reason: collision with root package name */
    public String f429977d;

    /* renamed from: e, reason: collision with root package name */
    public String f429978e;

    /* renamed from: f, reason: collision with root package name */
    public String f429979f;

    /* renamed from: g, reason: collision with root package name */
    public int f429980g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f429981h;

    /* renamed from: i, reason: collision with root package name */
    public String f429982i;

    /* renamed from: j, reason: collision with root package name */
    public pv4.y f429983j;

    /* renamed from: k, reason: collision with root package name */
    public int f429984k;

    /* renamed from: l, reason: collision with root package name */
    public int f429985l;

    /* renamed from: m, reason: collision with root package name */
    public String f429986m;

    /* renamed from: n, reason: collision with root package name */
    public String f429987n;

    /* renamed from: o, reason: collision with root package name */
    public String f429988o;

    /* renamed from: p, reason: collision with root package name */
    public String f429989p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f429990q;

    /* renamed from: r, reason: collision with root package name */
    public long f429991r;

    /* renamed from: s, reason: collision with root package name */
    public String f429992s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f429993t;

    /* renamed from: u, reason: collision with root package name */
    public pv4.j f429994u;

    /* renamed from: v, reason: collision with root package name */
    public String f429995v;

    /* renamed from: w, reason: collision with root package name */
    public at f429996w;

    public ap() {
        a();
    }

    public static ap[] b() {
        if (f429973z == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429973z == null) {
                    f429973z = new ap[0];
                }
            }
        }
        return f429973z;
    }

    public static ap d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ap) MessageNano.mergeFrom(new ap(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ap mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f429974a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f429975b = readInt32;
                        break;
                    }
                case 26:
                    this.f429976c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f429977d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f429978e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f429979f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                        break;
                    } else {
                        this.f429980g = readInt322;
                        break;
                    }
                case 66:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    String[] strArr = this.f429981h;
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
                    this.f429981h = strArr2;
                    break;
                case 74:
                    this.f429982i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    if (this.f429983j == null) {
                        this.f429983j = new pv4.y();
                    }
                    codedInputByteBufferNano.readMessage(this.f429983j);
                    break;
                case 88:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2 && readInt323 != 3) {
                        break;
                    } else {
                        this.f429984k = readInt323;
                        break;
                    }
                case 96:
                    this.f429985l = codedInputByteBufferNano.readInt32();
                    break;
                case 106:
                    this.f429986m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f429987n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f429988o = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    this.f429989p = codedInputByteBufferNano.readString();
                    break;
                case 136:
                    this.f429990q = codedInputByteBufferNano.readBool();
                    break;
                case 144:
                    this.f429991r = codedInputByteBufferNano.readInt64();
                    break;
                case 154:
                    this.f429992s = codedInputByteBufferNano.readString();
                    break;
                case 160:
                    this.f429993t = codedInputByteBufferNano.readBool();
                    break;
                case 170:
                    if (this.f429994u == null) {
                        this.f429994u = new pv4.j();
                    }
                    codedInputByteBufferNano.readMessage(this.f429994u);
                    break;
                case 178:
                    this.f429995v = codedInputByteBufferNano.readString();
                    break;
                case 186:
                    if (this.f429996w == null) {
                        this.f429996w = new at();
                    }
                    codedInputByteBufferNano.readMessage(this.f429996w);
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
        int i3 = this.f429974a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f429975b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f429976c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f429976c);
        }
        if (!this.f429977d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f429977d);
        }
        if (!this.f429978e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f429978e);
        }
        if (!this.f429979f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f429979f);
        }
        int i17 = this.f429980g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        String[] strArr = this.f429981h;
        if (strArr != null && strArr.length > 0) {
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            while (true) {
                String[] strArr2 = this.f429981h;
                if (i18 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i18];
                if (str != null) {
                    i26++;
                    i19 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (i26 * 1);
        }
        if (!this.f429982i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f429982i);
        }
        pv4.y yVar = this.f429983j;
        if (yVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, yVar);
        }
        int i27 = this.f429984k;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i27);
        }
        int i28 = this.f429985l;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i28);
        }
        if (!this.f429986m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f429986m);
        }
        if (!this.f429987n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f429987n);
        }
        if (!this.f429988o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f429988o);
        }
        if (!this.f429989p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f429989p);
        }
        boolean z16 = this.f429990q;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z16);
        }
        long j3 = this.f429991r;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(18, j3);
        }
        if (!this.f429992s.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.f429992s);
        }
        boolean z17 = this.f429993t;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, z17);
        }
        pv4.j jVar = this.f429994u;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, jVar);
        }
        if (!this.f429995v.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.f429995v);
        }
        at atVar = this.f429996w;
        return atVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(23, atVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429974a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f429975b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f429976c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429976c);
        }
        if (!this.f429977d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429977d);
        }
        if (!this.f429978e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f429978e);
        }
        if (!this.f429979f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f429979f);
        }
        int i17 = this.f429980g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        String[] strArr = this.f429981h;
        if (strArr != null && strArr.length > 0) {
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f429981h;
                if (i18 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i18];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(8, str);
                }
                i18++;
            }
        }
        if (!this.f429982i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f429982i);
        }
        pv4.y yVar = this.f429983j;
        if (yVar != null) {
            codedOutputByteBufferNano.writeMessage(10, yVar);
        }
        int i19 = this.f429984k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i19);
        }
        int i26 = this.f429985l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i26);
        }
        if (!this.f429986m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f429986m);
        }
        if (!this.f429987n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f429987n);
        }
        if (!this.f429988o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f429988o);
        }
        if (!this.f429989p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f429989p);
        }
        boolean z16 = this.f429990q;
        if (z16) {
            codedOutputByteBufferNano.writeBool(17, z16);
        }
        long j3 = this.f429991r;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(18, j3);
        }
        if (!this.f429992s.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.f429992s);
        }
        boolean z17 = this.f429993t;
        if (z17) {
            codedOutputByteBufferNano.writeBool(20, z17);
        }
        pv4.j jVar = this.f429994u;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(21, jVar);
        }
        if (!this.f429995v.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.f429995v);
        }
        at atVar = this.f429996w;
        if (atVar != null) {
            codedOutputByteBufferNano.writeMessage(23, atVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ap a() {
        this.f429974a = 0;
        this.f429975b = 0;
        this.f429976c = "";
        this.f429977d = "";
        this.f429978e = "";
        this.f429979f = "";
        this.f429980g = 0;
        this.f429981h = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f429982i = "";
        this.f429983j = null;
        this.f429984k = 0;
        this.f429985l = 0;
        this.f429986m = "";
        this.f429987n = "";
        this.f429988o = "";
        this.f429989p = "";
        this.f429990q = false;
        this.f429991r = 0L;
        this.f429992s = "";
        this.f429993t = false;
        this.f429994u = null;
        this.f429995v = "";
        this.f429996w = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
