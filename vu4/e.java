package vu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f443570a;

    /* renamed from: b, reason: collision with root package name */
    public String f443571b;

    /* renamed from: c, reason: collision with root package name */
    public String f443572c;

    /* renamed from: d, reason: collision with root package name */
    public String f443573d;

    /* renamed from: e, reason: collision with root package name */
    public String f443574e;

    /* renamed from: f, reason: collision with root package name */
    public String f443575f;

    /* renamed from: g, reason: collision with root package name */
    public String f443576g;

    /* renamed from: h, reason: collision with root package name */
    public String f443577h;

    /* renamed from: i, reason: collision with root package name */
    public String f443578i;

    /* renamed from: j, reason: collision with root package name */
    public String f443579j;

    /* renamed from: k, reason: collision with root package name */
    public String f443580k;

    /* renamed from: l, reason: collision with root package name */
    public String f443581l;

    /* renamed from: m, reason: collision with root package name */
    public String f443582m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f443583n;

    public e() {
        a();
    }

    public e a() {
        this.f443570a = "";
        this.f443571b = "";
        this.f443572c = "";
        this.f443573d = "";
        this.f443574e = "";
        this.f443575f = "";
        this.f443576g = "";
        this.f443577h = "";
        this.f443578i = "";
        this.f443579j = "";
        this.f443580k = "";
        this.f443581l = "";
        this.f443582m = "";
        this.f443583n = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f443570a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f443571b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f443572c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f443573d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f443574e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f443575f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f443576g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f443577h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f443578i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f443579j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f443580k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f443581l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f443582m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f443583n = codedInputByteBufferNano.readBool();
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
        if (!this.f443570a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f443570a);
        }
        if (!this.f443571b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f443571b);
        }
        if (!this.f443572c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f443572c);
        }
        if (!this.f443573d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f443573d);
        }
        if (!this.f443574e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f443574e);
        }
        if (!this.f443575f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f443575f);
        }
        if (!this.f443576g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f443576g);
        }
        if (!this.f443577h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f443577h);
        }
        if (!this.f443578i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f443578i);
        }
        if (!this.f443579j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f443579j);
        }
        if (!this.f443580k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f443580k);
        }
        if (!this.f443581l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f443581l);
        }
        if (!this.f443582m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f443582m);
        }
        boolean z16 = this.f443583n;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(14, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f443570a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f443570a);
        }
        if (!this.f443571b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f443571b);
        }
        if (!this.f443572c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f443572c);
        }
        if (!this.f443573d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f443573d);
        }
        if (!this.f443574e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f443574e);
        }
        if (!this.f443575f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f443575f);
        }
        if (!this.f443576g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f443576g);
        }
        if (!this.f443577h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f443577h);
        }
        if (!this.f443578i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f443578i);
        }
        if (!this.f443579j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f443579j);
        }
        if (!this.f443580k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f443580k);
        }
        if (!this.f443581l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f443581l);
        }
        if (!this.f443582m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f443582m);
        }
        boolean z16 = this.f443583n;
        if (z16) {
            codedOutputByteBufferNano.writeBool(14, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
