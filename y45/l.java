package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public String f449419a;

    /* renamed from: b, reason: collision with root package name */
    public String f449420b;

    /* renamed from: c, reason: collision with root package name */
    public int f449421c;

    /* renamed from: d, reason: collision with root package name */
    public String f449422d;

    /* renamed from: e, reason: collision with root package name */
    public String f449423e;

    /* renamed from: f, reason: collision with root package name */
    public int f449424f;

    /* renamed from: g, reason: collision with root package name */
    public g f449425g;

    /* renamed from: h, reason: collision with root package name */
    public int f449426h;

    /* renamed from: i, reason: collision with root package name */
    public int f449427i;

    /* renamed from: j, reason: collision with root package name */
    public String f449428j;

    /* renamed from: k, reason: collision with root package name */
    public String f449429k;

    /* renamed from: l, reason: collision with root package name */
    public String f449430l;

    /* renamed from: m, reason: collision with root package name */
    public String f449431m;

    /* renamed from: n, reason: collision with root package name */
    public int f449432n;

    /* renamed from: o, reason: collision with root package name */
    public int f449433o;

    /* renamed from: p, reason: collision with root package name */
    public String f449434p;

    /* renamed from: q, reason: collision with root package name */
    public String f449435q;

    /* renamed from: r, reason: collision with root package name */
    public String f449436r;

    /* renamed from: s, reason: collision with root package name */
    public String f449437s;

    /* renamed from: t, reason: collision with root package name */
    public String f449438t;

    public l() {
        a();
    }

    public l a() {
        this.f449419a = "";
        this.f449420b = "";
        this.f449421c = 0;
        this.f449422d = "";
        this.f449423e = "";
        this.f449424f = 0;
        this.f449425g = null;
        this.f449426h = 0;
        this.f449427i = 0;
        this.f449428j = "";
        this.f449429k = "";
        this.f449430l = "";
        this.f449431m = "";
        this.f449432n = 0;
        this.f449433o = 0;
        this.f449434p = "";
        this.f449435q = "";
        this.f449436r = "";
        this.f449437s = "";
        this.f449438t = "";
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
                    this.f449419a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f449420b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f449421c = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    this.f449422d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f449423e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f449424f = codedInputByteBufferNano.readInt32();
                    break;
                case 58:
                    if (this.f449425g == null) {
                        this.f449425g = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f449425g);
                    break;
                case 64:
                    this.f449426h = codedInputByteBufferNano.readInt32();
                    break;
                case 72:
                    this.f449427i = codedInputByteBufferNano.readInt32();
                    break;
                case 82:
                    this.f449428j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f449429k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f449430l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f449431m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f449432n = codedInputByteBufferNano.readInt32();
                    break;
                case 120:
                    this.f449433o = codedInputByteBufferNano.readInt32();
                    break;
                case 130:
                    this.f449434p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.f449435q = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    this.f449436r = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.f449437s = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.f449438t = codedInputByteBufferNano.readString();
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
        if (!this.f449419a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f449419a);
        }
        if (!this.f449420b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f449420b);
        }
        int i3 = this.f449421c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.f449422d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f449422d);
        }
        if (!this.f449423e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f449423e);
        }
        int i16 = this.f449424f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        g gVar = this.f449425g;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, gVar);
        }
        int i17 = this.f449426h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        int i18 = this.f449427i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i18);
        }
        if (!this.f449428j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f449428j);
        }
        if (!this.f449429k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f449429k);
        }
        if (!this.f449430l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f449430l);
        }
        if (!this.f449431m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f449431m);
        }
        int i19 = this.f449432n;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i19);
        }
        int i26 = this.f449433o;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i26);
        }
        if (!this.f449434p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f449434p);
        }
        if (!this.f449435q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.f449435q);
        }
        if (!this.f449436r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f449436r);
        }
        if (!this.f449437s.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.f449437s);
        }
        if (!this.f449438t.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.f449438t);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f449419a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f449419a);
        }
        if (!this.f449420b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f449420b);
        }
        int i3 = this.f449421c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f449422d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f449422d);
        }
        if (!this.f449423e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f449423e);
        }
        int i16 = this.f449424f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        g gVar = this.f449425g;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(7, gVar);
        }
        int i17 = this.f449426h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        int i18 = this.f449427i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i18);
        }
        if (!this.f449428j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f449428j);
        }
        if (!this.f449429k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f449429k);
        }
        if (!this.f449430l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f449430l);
        }
        if (!this.f449431m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f449431m);
        }
        int i19 = this.f449432n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i19);
        }
        int i26 = this.f449433o;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i26);
        }
        if (!this.f449434p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f449434p);
        }
        if (!this.f449435q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f449435q);
        }
        if (!this.f449436r.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f449436r);
        }
        if (!this.f449437s.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.f449437s);
        }
        if (!this.f449438t.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.f449438t);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
