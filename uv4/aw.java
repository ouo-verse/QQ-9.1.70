package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class aw extends ExtendableMessageNano<aw> {

    /* renamed from: r, reason: collision with root package name */
    private static volatile aw[] f440239r;

    /* renamed from: a, reason: collision with root package name */
    public int f440240a;

    /* renamed from: b, reason: collision with root package name */
    public int f440241b;

    /* renamed from: c, reason: collision with root package name */
    public int f440242c;

    /* renamed from: d, reason: collision with root package name */
    public String f440243d;

    /* renamed from: e, reason: collision with root package name */
    public String f440244e;

    /* renamed from: f, reason: collision with root package name */
    public int f440245f;

    /* renamed from: g, reason: collision with root package name */
    public int f440246g;

    /* renamed from: h, reason: collision with root package name */
    public int f440247h;

    /* renamed from: i, reason: collision with root package name */
    public int f440248i;

    /* renamed from: j, reason: collision with root package name */
    public String f440249j;

    /* renamed from: k, reason: collision with root package name */
    public String f440250k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f440251l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f440252m;

    /* renamed from: n, reason: collision with root package name */
    public int f440253n;

    /* renamed from: o, reason: collision with root package name */
    public int f440254o;

    /* renamed from: p, reason: collision with root package name */
    public int f440255p;

    /* renamed from: q, reason: collision with root package name */
    public int f440256q;

    public aw() {
        a();
    }

    public static aw[] b() {
        if (f440239r == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440239r == null) {
                    f440239r = new aw[0];
                }
            }
        }
        return f440239r;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public aw mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f440240a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f440241b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f440242c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f440243d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f440244e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f440245f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f440246g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f440247h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f440248i = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.f440249j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f440250k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f440251l = codedInputByteBufferNano.readBool();
                    break;
                case 104:
                    this.f440252m = codedInputByteBufferNano.readBool();
                    break;
                case 112:
                    this.f440253n = codedInputByteBufferNano.readInt32();
                    break;
                case 120:
                    this.f440254o = codedInputByteBufferNano.readInt32();
                    break;
                case 128:
                    this.f440255p = codedInputByteBufferNano.readInt32();
                    break;
                case 136:
                    this.f440256q = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f440240a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f440241b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f440242c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        if (!this.f440243d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440243d);
        }
        if (!this.f440244e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440244e);
        }
        int i18 = this.f440245f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        int i19 = this.f440246g;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        int i26 = this.f440247h;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        int i27 = this.f440248i;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i27);
        }
        if (!this.f440249j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f440249j);
        }
        if (!this.f440250k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f440250k);
        }
        boolean z16 = this.f440251l;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z16);
        }
        boolean z17 = this.f440252m;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, z17);
        }
        int i28 = this.f440253n;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i28);
        }
        int i29 = this.f440254o;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i29);
        }
        int i36 = this.f440255p;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(16, i36);
        }
        int i37 = this.f440256q;
        return i37 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(17, i37) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440240a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f440241b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f440242c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        if (!this.f440243d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440243d);
        }
        if (!this.f440244e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440244e);
        }
        int i18 = this.f440245f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        int i19 = this.f440246g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.f440247h;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        int i27 = this.f440248i;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i27);
        }
        if (!this.f440249j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f440249j);
        }
        if (!this.f440250k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f440250k);
        }
        boolean z16 = this.f440251l;
        if (z16) {
            codedOutputByteBufferNano.writeBool(12, z16);
        }
        boolean z17 = this.f440252m;
        if (z17) {
            codedOutputByteBufferNano.writeBool(13, z17);
        }
        int i28 = this.f440253n;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i28);
        }
        int i29 = this.f440254o;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i29);
        }
        int i36 = this.f440255p;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i36);
        }
        int i37 = this.f440256q;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeInt32(17, i37);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public aw a() {
        this.f440240a = 0;
        this.f440241b = 0;
        this.f440242c = 0;
        this.f440243d = "";
        this.f440244e = "";
        this.f440245f = 0;
        this.f440246g = 0;
        this.f440247h = 0;
        this.f440248i = 0;
        this.f440249j = "";
        this.f440250k = "";
        this.f440251l = false;
        this.f440252m = false;
        this.f440253n = 0;
        this.f440254o = 0;
        this.f440255p = 0;
        this.f440256q = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
