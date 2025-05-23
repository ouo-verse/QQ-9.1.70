package qr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public String f429411a;

    /* renamed from: b, reason: collision with root package name */
    public String f429412b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f429413c;

    /* renamed from: d, reason: collision with root package name */
    public String f429414d;

    /* renamed from: e, reason: collision with root package name */
    public String f429415e;

    /* renamed from: f, reason: collision with root package name */
    public String f429416f;

    /* renamed from: g, reason: collision with root package name */
    public String f429417g;

    /* renamed from: h, reason: collision with root package name */
    public String f429418h;

    /* renamed from: i, reason: collision with root package name */
    public String f429419i;

    /* renamed from: j, reason: collision with root package name */
    public String f429420j;

    /* renamed from: k, reason: collision with root package name */
    public String f429421k;

    public g() {
        a();
    }

    public g a() {
        this.f429411a = "";
        this.f429412b = "";
        this.f429413c = false;
        this.f429414d = "";
        this.f429415e = "";
        this.f429416f = "";
        this.f429417g = "";
        this.f429418h = "";
        this.f429419i = "";
        this.f429420j = "";
        this.f429421k = "";
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
                    this.f429411a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f429412b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f429413c = codedInputByteBufferNano.readBool();
                    break;
                case 34:
                    this.f429414d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f429415e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f429416f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f429417g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f429418h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f429419i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f429420j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f429421k = codedInputByteBufferNano.readString();
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
        if (!this.f429411a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429411a);
        }
        if (!this.f429412b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f429412b);
        }
        boolean z16 = this.f429413c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        if (!this.f429414d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f429414d);
        }
        if (!this.f429415e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f429415e);
        }
        if (!this.f429416f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f429416f);
        }
        if (!this.f429417g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f429417g);
        }
        if (!this.f429418h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f429418h);
        }
        if (!this.f429419i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f429419i);
        }
        if (!this.f429420j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f429420j);
        }
        if (!this.f429421k.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.f429421k);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429411a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429411a);
        }
        if (!this.f429412b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f429412b);
        }
        boolean z16 = this.f429413c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!this.f429414d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429414d);
        }
        if (!this.f429415e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f429415e);
        }
        if (!this.f429416f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f429416f);
        }
        if (!this.f429417g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f429417g);
        }
        if (!this.f429418h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f429418h);
        }
        if (!this.f429419i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f429419i);
        }
        if (!this.f429420j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f429420j);
        }
        if (!this.f429421k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f429421k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
