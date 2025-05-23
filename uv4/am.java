package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class am extends ExtendableMessageNano<am> {

    /* renamed from: n, reason: collision with root package name */
    private static volatile am[] f440156n;

    /* renamed from: a, reason: collision with root package name */
    public int f440157a;

    /* renamed from: b, reason: collision with root package name */
    public int f440158b;

    /* renamed from: c, reason: collision with root package name */
    public String f440159c;

    /* renamed from: d, reason: collision with root package name */
    public int f440160d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f440161e;

    /* renamed from: f, reason: collision with root package name */
    public int f440162f;

    /* renamed from: g, reason: collision with root package name */
    public String f440163g;

    /* renamed from: h, reason: collision with root package name */
    public int f440164h;

    /* renamed from: i, reason: collision with root package name */
    public String f440165i;

    /* renamed from: j, reason: collision with root package name */
    public int f440166j;

    /* renamed from: k, reason: collision with root package name */
    public int f440167k;

    /* renamed from: l, reason: collision with root package name */
    public float f440168l;

    /* renamed from: m, reason: collision with root package name */
    public int f440169m;

    public am() {
        a();
    }

    public static am[] b() {
        if (f440156n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440156n == null) {
                    f440156n = new am[0];
                }
            }
        }
        return f440156n;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public am mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f440157a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f440158b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f440159c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f440160d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f440161e = codedInputByteBufferNano.readBool();
                    break;
                case 48:
                    this.f440162f = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.f440163g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f440164h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f440165i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f440166j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f440167k = codedInputByteBufferNano.readUInt32();
                    break;
                case 101:
                    this.f440168l = codedInputByteBufferNano.readFloat();
                    break;
                case 104:
                    this.f440169m = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f440157a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f440158b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f440159c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440159c);
        }
        int i17 = this.f440160d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        boolean z16 = this.f440161e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        int i18 = this.f440162f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        if (!this.f440163g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f440163g);
        }
        int i19 = this.f440164h;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i19);
        }
        if (!this.f440165i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f440165i);
        }
        int i26 = this.f440166j;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i26);
        }
        int i27 = this.f440167k;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i27);
        }
        if (Float.floatToIntBits(this.f440168l) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(12, this.f440168l);
        }
        int i28 = this.f440169m;
        return i28 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(13, i28) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440157a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f440158b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f440159c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440159c);
        }
        int i17 = this.f440160d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        boolean z16 = this.f440161e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        int i18 = this.f440162f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        if (!this.f440163g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f440163g);
        }
        int i19 = this.f440164h;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i19);
        }
        if (!this.f440165i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f440165i);
        }
        int i26 = this.f440166j;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i26);
        }
        int i27 = this.f440167k;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i27);
        }
        if (Float.floatToIntBits(this.f440168l) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(12, this.f440168l);
        }
        int i28 = this.f440169m;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i28);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public am a() {
        this.f440157a = 0;
        this.f440158b = 0;
        this.f440159c = "";
        this.f440160d = 0;
        this.f440161e = false;
        this.f440162f = 0;
        this.f440163g = "";
        this.f440164h = 0;
        this.f440165i = "";
        this.f440166j = 0;
        this.f440167k = 0;
        this.f440168l = 0.0f;
        this.f440169m = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
