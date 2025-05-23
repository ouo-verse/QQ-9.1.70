package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public String f427476a;

    /* renamed from: b, reason: collision with root package name */
    public String f427477b;

    /* renamed from: c, reason: collision with root package name */
    public long f427478c;

    /* renamed from: d, reason: collision with root package name */
    public g[] f427479d;

    /* renamed from: e, reason: collision with root package name */
    public r f427480e;

    /* renamed from: f, reason: collision with root package name */
    public w f427481f;

    /* renamed from: g, reason: collision with root package name */
    public String f427482g;

    /* renamed from: h, reason: collision with root package name */
    public int f427483h;

    /* renamed from: i, reason: collision with root package name */
    public String f427484i;

    /* renamed from: j, reason: collision with root package name */
    public String f427485j;

    /* renamed from: k, reason: collision with root package name */
    public int f427486k;

    /* renamed from: l, reason: collision with root package name */
    public int f427487l;

    /* renamed from: m, reason: collision with root package name */
    public String f427488m;

    /* renamed from: n, reason: collision with root package name */
    public String f427489n;

    /* renamed from: o, reason: collision with root package name */
    public String f427490o;

    /* renamed from: p, reason: collision with root package name */
    public int f427491p;

    /* renamed from: q, reason: collision with root package name */
    public int f427492q;

    public l() {
        a();
    }

    public l a() {
        this.f427476a = "";
        this.f427477b = "";
        this.f427478c = 0L;
        this.f427479d = g.b();
        this.f427480e = null;
        this.f427481f = null;
        this.f427482g = "";
        this.f427483h = 0;
        this.f427484i = "";
        this.f427485j = "";
        this.f427486k = 0;
        this.f427487l = 0;
        this.f427488m = "";
        this.f427489n = "";
        this.f427490o = "";
        this.f427491p = 0;
        this.f427492q = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f427476a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f427477b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f427478c = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    g[] gVarArr = this.f427479d;
                    int length = gVarArr == null ? 0 : gVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    g[] gVarArr2 = new g[i3];
                    if (length != 0) {
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        g gVar = new g();
                        gVarArr2[length] = gVar;
                        codedInputByteBufferNano.readMessage(gVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    g gVar2 = new g();
                    gVarArr2[length] = gVar2;
                    codedInputByteBufferNano.readMessage(gVar2);
                    this.f427479d = gVarArr2;
                    break;
                case 42:
                    if (this.f427480e == null) {
                        this.f427480e = new r();
                    }
                    codedInputByteBufferNano.readMessage(this.f427480e);
                    break;
                case 50:
                    if (this.f427481f == null) {
                        this.f427481f = new w();
                    }
                    codedInputByteBufferNano.readMessage(this.f427481f);
                    break;
                case 58:
                    this.f427482g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f427483h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f427484i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f427485j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f427486k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f427487l = codedInputByteBufferNano.readInt32();
                    break;
                case 106:
                    this.f427488m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f427489n = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    this.f427490o = codedInputByteBufferNano.readString();
                    break;
                case 136:
                    this.f427491p = codedInputByteBufferNano.readInt32();
                    break;
                case 144:
                    this.f427492q = codedInputByteBufferNano.readInt32();
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
        if (!this.f427476a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427476a);
        }
        if (!this.f427477b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427477b);
        }
        long j3 = this.f427478c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        g[] gVarArr = this.f427479d;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f427479d;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, gVar);
                }
                i3++;
            }
        }
        r rVar = this.f427480e;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, rVar);
        }
        w wVar = this.f427481f;
        if (wVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, wVar);
        }
        if (!this.f427482g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f427482g);
        }
        int i16 = this.f427483h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        if (!this.f427484i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f427484i);
        }
        if (!this.f427485j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f427485j);
        }
        int i17 = this.f427486k;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i17);
        }
        int i18 = this.f427487l;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i18);
        }
        if (!this.f427488m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f427488m);
        }
        if (!this.f427489n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f427489n);
        }
        if (!this.f427490o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f427490o);
        }
        int i19 = this.f427491p;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, i19);
        }
        int i26 = this.f427492q;
        return i26 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(18, i26) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427476a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427476a);
        }
        if (!this.f427477b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427477b);
        }
        long j3 = this.f427478c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        g[] gVarArr = this.f427479d;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f427479d;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, gVar);
                }
                i3++;
            }
        }
        r rVar = this.f427480e;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(5, rVar);
        }
        w wVar = this.f427481f;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(6, wVar);
        }
        if (!this.f427482g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427482g);
        }
        int i16 = this.f427483h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        if (!this.f427484i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f427484i);
        }
        if (!this.f427485j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f427485j);
        }
        int i17 = this.f427486k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i17);
        }
        int i18 = this.f427487l;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i18);
        }
        if (!this.f427488m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f427488m);
        }
        if (!this.f427489n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f427489n);
        }
        if (!this.f427490o.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f427490o);
        }
        int i19 = this.f427491p;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(17, i19);
        }
        int i26 = this.f427492q;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(18, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
