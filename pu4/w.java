package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: a, reason: collision with root package name */
    public String f427536a;

    /* renamed from: b, reason: collision with root package name */
    public String f427537b;

    /* renamed from: c, reason: collision with root package name */
    public int f427538c;

    /* renamed from: d, reason: collision with root package name */
    public String f427539d;

    /* renamed from: e, reason: collision with root package name */
    public String f427540e;

    /* renamed from: f, reason: collision with root package name */
    public int f427541f;

    /* renamed from: g, reason: collision with root package name */
    public v f427542g;

    /* renamed from: h, reason: collision with root package name */
    public int f427543h;

    /* renamed from: i, reason: collision with root package name */
    public int f427544i;

    /* renamed from: j, reason: collision with root package name */
    public String f427545j;

    /* renamed from: k, reason: collision with root package name */
    public String f427546k;

    /* renamed from: l, reason: collision with root package name */
    public String f427547l;

    /* renamed from: m, reason: collision with root package name */
    public String f427548m;

    /* renamed from: n, reason: collision with root package name */
    public int f427549n;

    /* renamed from: o, reason: collision with root package name */
    public int f427550o;

    /* renamed from: p, reason: collision with root package name */
    public String f427551p;

    /* renamed from: q, reason: collision with root package name */
    public String f427552q;

    /* renamed from: r, reason: collision with root package name */
    public String f427553r;

    /* renamed from: s, reason: collision with root package name */
    public String f427554s;

    /* renamed from: t, reason: collision with root package name */
    public String f427555t;

    public w() {
        a();
    }

    public w a() {
        this.f427536a = "";
        this.f427537b = "";
        this.f427538c = 0;
        this.f427539d = "";
        this.f427540e = "";
        this.f427541f = 0;
        this.f427542g = null;
        this.f427543h = 0;
        this.f427544i = 0;
        this.f427545j = "";
        this.f427546k = "";
        this.f427547l = "";
        this.f427548m = "";
        this.f427549n = 0;
        this.f427550o = 0;
        this.f427551p = "";
        this.f427552q = "";
        this.f427553r = "";
        this.f427554s = "";
        this.f427555t = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f427536a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f427537b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f427538c = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    this.f427539d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f427540e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f427541f = codedInputByteBufferNano.readInt32();
                    break;
                case 58:
                    if (this.f427542g == null) {
                        this.f427542g = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.f427542g);
                    break;
                case 64:
                    this.f427543h = codedInputByteBufferNano.readInt32();
                    break;
                case 72:
                    this.f427544i = codedInputByteBufferNano.readInt32();
                    break;
                case 82:
                    this.f427545j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f427546k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f427547l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f427548m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f427549n = codedInputByteBufferNano.readInt32();
                    break;
                case 120:
                    this.f427550o = codedInputByteBufferNano.readInt32();
                    break;
                case 130:
                    this.f427551p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.f427552q = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    this.f427553r = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.f427554s = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.f427555t = codedInputByteBufferNano.readString();
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
        if (!this.f427536a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427536a);
        }
        if (!this.f427537b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427537b);
        }
        int i3 = this.f427538c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.f427539d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427539d);
        }
        if (!this.f427540e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427540e);
        }
        int i16 = this.f427541f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        v vVar = this.f427542g;
        if (vVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, vVar);
        }
        int i17 = this.f427543h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        int i18 = this.f427544i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i18);
        }
        if (!this.f427545j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f427545j);
        }
        if (!this.f427546k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f427546k);
        }
        if (!this.f427547l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f427547l);
        }
        if (!this.f427548m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f427548m);
        }
        int i19 = this.f427549n;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i19);
        }
        int i26 = this.f427550o;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i26);
        }
        if (!this.f427551p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f427551p);
        }
        if (!this.f427552q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.f427552q);
        }
        if (!this.f427553r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f427553r);
        }
        if (!this.f427554s.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.f427554s);
        }
        return !this.f427555t.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.f427555t) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427536a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427536a);
        }
        if (!this.f427537b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427537b);
        }
        int i3 = this.f427538c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f427539d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427539d);
        }
        if (!this.f427540e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427540e);
        }
        int i16 = this.f427541f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        v vVar = this.f427542g;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(7, vVar);
        }
        int i17 = this.f427543h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        int i18 = this.f427544i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i18);
        }
        if (!this.f427545j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f427545j);
        }
        if (!this.f427546k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f427546k);
        }
        if (!this.f427547l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f427547l);
        }
        if (!this.f427548m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f427548m);
        }
        int i19 = this.f427549n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i19);
        }
        int i26 = this.f427550o;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i26);
        }
        if (!this.f427551p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f427551p);
        }
        if (!this.f427552q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f427552q);
        }
        if (!this.f427553r.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f427553r);
        }
        if (!this.f427554s.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.f427554s);
        }
        if (!this.f427555t.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.f427555t);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
