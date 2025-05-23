package tu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f437498a;

    /* renamed from: b, reason: collision with root package name */
    public String f437499b;

    /* renamed from: c, reason: collision with root package name */
    public String f437500c;

    /* renamed from: d, reason: collision with root package name */
    public String f437501d;

    /* renamed from: e, reason: collision with root package name */
    public String f437502e;

    /* renamed from: f, reason: collision with root package name */
    public String f437503f;

    /* renamed from: g, reason: collision with root package name */
    public String f437504g;

    /* renamed from: h, reason: collision with root package name */
    public String f437505h;

    /* renamed from: i, reason: collision with root package name */
    public String f437506i;

    /* renamed from: j, reason: collision with root package name */
    public String f437507j;

    public d() {
        a();
    }

    public d a() {
        this.f437498a = "";
        this.f437499b = "";
        this.f437500c = "";
        this.f437501d = "";
        this.f437502e = "";
        this.f437503f = "";
        this.f437504g = "";
        this.f437505h = "";
        this.f437506i = "";
        this.f437507j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f437498a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f437499b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f437500c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f437501d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f437502e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f437503f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f437504g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f437505h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f437506i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f437507j = codedInputByteBufferNano.readString();
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
        if (!this.f437498a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f437498a);
        }
        if (!this.f437499b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f437499b);
        }
        if (!this.f437500c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f437500c);
        }
        if (!this.f437501d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f437501d);
        }
        if (!this.f437502e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f437502e);
        }
        if (!this.f437503f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f437503f);
        }
        if (!this.f437504g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f437504g);
        }
        if (!this.f437505h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f437505h);
        }
        if (!this.f437506i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f437506i);
        }
        return !this.f437507j.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f437507j) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f437498a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f437498a);
        }
        if (!this.f437499b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f437499b);
        }
        if (!this.f437500c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f437500c);
        }
        if (!this.f437501d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f437501d);
        }
        if (!this.f437502e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f437502e);
        }
        if (!this.f437503f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f437503f);
        }
        if (!this.f437504g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f437504g);
        }
        if (!this.f437505h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f437505h);
        }
        if (!this.f437506i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f437506i);
        }
        if (!this.f437507j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f437507j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
