package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class aa extends ExtendableMessageNano<aa> {

    /* renamed from: l, reason: collision with root package name */
    private static volatile aa[] f427563l;

    /* renamed from: a, reason: collision with root package name */
    public u f427564a;

    /* renamed from: b, reason: collision with root package name */
    public pu4.g f427565b;

    /* renamed from: c, reason: collision with root package name */
    public String f427566c;

    /* renamed from: d, reason: collision with root package name */
    public int f427567d;

    /* renamed from: e, reason: collision with root package name */
    public int f427568e;

    /* renamed from: f, reason: collision with root package name */
    public String f427569f;

    /* renamed from: g, reason: collision with root package name */
    public String f427570g;

    /* renamed from: h, reason: collision with root package name */
    public String f427571h;

    /* renamed from: i, reason: collision with root package name */
    public String f427572i;

    /* renamed from: j, reason: collision with root package name */
    public int f427573j;

    /* renamed from: k, reason: collision with root package name */
    public int f427574k;

    public aa() {
        a();
    }

    public static aa[] b() {
        if (f427563l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427563l == null) {
                    f427563l = new aa[0];
                }
            }
        }
        return f427563l;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public aa mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f427564a == null) {
                        this.f427564a = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f427564a);
                    break;
                case 18:
                    if (this.f427565b == null) {
                        this.f427565b = new pu4.g();
                    }
                    codedInputByteBufferNano.readMessage(this.f427565b);
                    break;
                case 26:
                    this.f427566c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f427567d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f427568e = codedInputByteBufferNano.readInt32();
                    break;
                case 50:
                    this.f427569f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f427570g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f427571h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f427572i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f427573j = codedInputByteBufferNano.readInt32();
                    break;
                case 88:
                    this.f427574k = codedInputByteBufferNano.readUInt32();
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
        u uVar = this.f427564a;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, uVar);
        }
        pu4.g gVar = this.f427565b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        if (!this.f427566c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427566c);
        }
        int i3 = this.f427567d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.f427568e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        if (!this.f427569f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427569f);
        }
        if (!this.f427570g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f427570g);
        }
        if (!this.f427571h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f427571h);
        }
        if (!this.f427572i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f427572i);
        }
        int i17 = this.f427573j;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i17);
        }
        int i18 = this.f427574k;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(11, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        u uVar = this.f427564a;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(1, uVar);
        }
        pu4.g gVar = this.f427565b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        if (!this.f427566c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427566c);
        }
        int i3 = this.f427567d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.f427568e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        if (!this.f427569f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427569f);
        }
        if (!this.f427570g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427570g);
        }
        if (!this.f427571h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f427571h);
        }
        if (!this.f427572i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f427572i);
        }
        int i17 = this.f427573j;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i17);
        }
        int i18 = this.f427574k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public aa a() {
        this.f427564a = null;
        this.f427565b = null;
        this.f427566c = "";
        this.f427567d = 0;
        this.f427568e = 0;
        this.f427569f = "";
        this.f427570g = "";
        this.f427571h = "";
        this.f427572i = "";
        this.f427573j = 0;
        this.f427574k = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
