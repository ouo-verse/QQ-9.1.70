package sr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f434347a;

    /* renamed from: b, reason: collision with root package name */
    public String f434348b;

    /* renamed from: c, reason: collision with root package name */
    public String f434349c;

    /* renamed from: d, reason: collision with root package name */
    public String f434350d;

    /* renamed from: e, reason: collision with root package name */
    public String f434351e;

    /* renamed from: f, reason: collision with root package name */
    public String f434352f;

    /* renamed from: g, reason: collision with root package name */
    public String f434353g;

    /* renamed from: h, reason: collision with root package name */
    public String f434354h;

    /* renamed from: i, reason: collision with root package name */
    public String f434355i;

    /* renamed from: j, reason: collision with root package name */
    public String f434356j;

    /* renamed from: k, reason: collision with root package name */
    public int f434357k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f434358l;

    public a() {
        a();
    }

    public a a() {
        this.f434347a = "";
        this.f434348b = "";
        this.f434349c = "";
        this.f434350d = "";
        this.f434351e = "";
        this.f434352f = "";
        this.f434353g = "";
        this.f434354h = "";
        this.f434355i = "";
        this.f434356j = "";
        this.f434357k = 0;
        this.f434358l = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f434347a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f434348b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f434349c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f434350d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f434351e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f434352f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f434353g = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f434354h = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f434355i = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f434356j = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f434357k = codedInputByteBufferNano.readInt32();
                    break;
                case 104:
                    this.f434358l = codedInputByteBufferNano.readBool();
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
        if (!this.f434347a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f434347a);
        }
        if (!this.f434348b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434348b);
        }
        if (!this.f434349c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434349c);
        }
        if (!this.f434350d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f434350d);
        }
        if (!this.f434351e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f434351e);
        }
        if (!this.f434352f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f434352f);
        }
        if (!this.f434353g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f434353g);
        }
        if (!this.f434354h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f434354h);
        }
        if (!this.f434355i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f434355i);
        }
        if (!this.f434356j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f434356j);
        }
        int i3 = this.f434357k;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i3);
        }
        boolean z16 = this.f434358l;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(13, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f434347a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f434347a);
        }
        if (!this.f434348b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434348b);
        }
        if (!this.f434349c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434349c);
        }
        if (!this.f434350d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f434350d);
        }
        if (!this.f434351e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f434351e);
        }
        if (!this.f434352f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f434352f);
        }
        if (!this.f434353g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f434353g);
        }
        if (!this.f434354h.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f434354h);
        }
        if (!this.f434355i.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f434355i);
        }
        if (!this.f434356j.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f434356j);
        }
        int i3 = this.f434357k;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i3);
        }
        boolean z16 = this.f434358l;
        if (z16) {
            codedOutputByteBufferNano.writeBool(13, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
