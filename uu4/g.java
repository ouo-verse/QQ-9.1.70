package uu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public String f440065a;

    /* renamed from: b, reason: collision with root package name */
    public String f440066b;

    /* renamed from: c, reason: collision with root package name */
    public String f440067c;

    /* renamed from: d, reason: collision with root package name */
    public int f440068d;

    /* renamed from: e, reason: collision with root package name */
    public int f440069e;

    /* renamed from: f, reason: collision with root package name */
    public f f440070f;

    /* renamed from: g, reason: collision with root package name */
    public a f440071g;

    /* renamed from: h, reason: collision with root package name */
    public String f440072h;

    /* renamed from: i, reason: collision with root package name */
    public String f440073i;

    /* renamed from: j, reason: collision with root package name */
    public String f440074j;

    /* renamed from: k, reason: collision with root package name */
    public String f440075k;

    /* renamed from: l, reason: collision with root package name */
    public int f440076l;

    /* renamed from: m, reason: collision with root package name */
    public int f440077m;

    /* renamed from: n, reason: collision with root package name */
    public int f440078n;

    /* renamed from: o, reason: collision with root package name */
    public String f440079o;

    /* renamed from: p, reason: collision with root package name */
    public int f440080p;

    public g() {
        a();
    }

    public g a() {
        this.f440065a = "";
        this.f440066b = "";
        this.f440067c = "";
        this.f440068d = 0;
        this.f440069e = 0;
        this.f440070f = null;
        this.f440071g = null;
        this.f440072h = "";
        this.f440073i = "";
        this.f440074j = "";
        this.f440075k = "";
        this.f440076l = 0;
        this.f440077m = 0;
        this.f440078n = 0;
        this.f440079o = "";
        this.f440080p = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f440065a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f440066b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f440067c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f440068d = readInt32;
                        break;
                    }
                case 40:
                    this.f440069e = codedInputByteBufferNano.readInt32();
                    break;
                case 50:
                    if (this.f440070f == null) {
                        this.f440070f = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f440070f);
                    break;
                case 58:
                    if (this.f440071g == null) {
                        this.f440071g = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f440071g);
                    break;
                case 66:
                    this.f440072h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f440073i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f440074j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f440075k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f440076l = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.f440077m = codedInputByteBufferNano.readInt32();
                    break;
                case 112:
                    this.f440078n = codedInputByteBufferNano.readInt32();
                    break;
                case 122:
                    this.f440079o = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.f440080p = codedInputByteBufferNano.readInt32();
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
        if (!this.f440065a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440065a);
        }
        if (!this.f440066b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440066b);
        }
        if (!this.f440067c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440067c);
        }
        int i3 = this.f440068d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i16 = this.f440069e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        f fVar = this.f440070f;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, fVar);
        }
        a aVar = this.f440071g;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, aVar);
        }
        if (!this.f440072h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f440072h);
        }
        if (!this.f440073i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f440073i);
        }
        if (!this.f440074j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f440074j);
        }
        if (!this.f440075k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f440075k);
        }
        int i17 = this.f440076l;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i17);
        }
        int i18 = this.f440077m;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i18);
        }
        int i19 = this.f440078n;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i19);
        }
        if (!this.f440079o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f440079o);
        }
        int i26 = this.f440080p;
        return i26 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(16, i26) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440065a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440065a);
        }
        if (!this.f440066b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440066b);
        }
        if (!this.f440067c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440067c);
        }
        int i3 = this.f440068d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i16 = this.f440069e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        f fVar = this.f440070f;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(6, fVar);
        }
        a aVar = this.f440071g;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(7, aVar);
        }
        if (!this.f440072h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f440072h);
        }
        if (!this.f440073i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f440073i);
        }
        if (!this.f440074j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f440074j);
        }
        if (!this.f440075k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f440075k);
        }
        int i17 = this.f440076l;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i17);
        }
        int i18 = this.f440077m;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i18);
        }
        int i19 = this.f440078n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i19);
        }
        if (!this.f440079o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f440079o);
        }
        int i26 = this.f440080p;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
