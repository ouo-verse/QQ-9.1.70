package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: a, reason: collision with root package name */
    public String f432456a;

    /* renamed from: b, reason: collision with root package name */
    public String f432457b;

    /* renamed from: c, reason: collision with root package name */
    public String f432458c;

    /* renamed from: d, reason: collision with root package name */
    public int f432459d;

    /* renamed from: e, reason: collision with root package name */
    public String f432460e;

    /* renamed from: f, reason: collision with root package name */
    public String f432461f;

    /* renamed from: g, reason: collision with root package name */
    public String f432462g;

    /* renamed from: h, reason: collision with root package name */
    public String f432463h;

    /* renamed from: i, reason: collision with root package name */
    public String f432464i;

    /* renamed from: j, reason: collision with root package name */
    public String f432465j;

    public v() {
        a();
    }

    public v a() {
        this.f432456a = "";
        this.f432457b = "";
        this.f432458c = "";
        this.f432459d = 0;
        this.f432460e = "";
        this.f432461f = "";
        this.f432462g = "";
        this.f432463h = "";
        this.f432464i = "";
        this.f432465j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f432456a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f432457b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f432458c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f432459d = readInt32;
                        break;
                    }
                case 42:
                    this.f432460e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f432461f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f432462g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f432463h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f432464i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f432465j = codedInputByteBufferNano.readString();
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
        if (!this.f432456a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432456a);
        }
        if (!this.f432457b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432457b);
        }
        if (!this.f432458c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432458c);
        }
        int i3 = this.f432459d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!this.f432460e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f432460e);
        }
        if (!this.f432461f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f432461f);
        }
        if (!this.f432462g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f432462g);
        }
        if (!this.f432463h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f432463h);
        }
        if (!this.f432464i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f432464i);
        }
        return !this.f432465j.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f432465j) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432456a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432456a);
        }
        if (!this.f432457b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432457b);
        }
        if (!this.f432458c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432458c);
        }
        int i3 = this.f432459d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!this.f432460e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f432460e);
        }
        if (!this.f432461f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f432461f);
        }
        if (!this.f432462g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f432462g);
        }
        if (!this.f432463h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f432463h);
        }
        if (!this.f432464i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f432464i);
        }
        if (!this.f432465j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f432465j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
