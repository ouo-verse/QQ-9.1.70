package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ba extends ExtendableMessageNano<ba> {

    /* renamed from: a, reason: collision with root package name */
    public int f440300a;

    /* renamed from: b, reason: collision with root package name */
    public String f440301b;

    /* renamed from: c, reason: collision with root package name */
    public String f440302c;

    /* renamed from: d, reason: collision with root package name */
    public String f440303d;

    /* renamed from: e, reason: collision with root package name */
    public String f440304e;

    /* renamed from: f, reason: collision with root package name */
    public int f440305f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f440306g;

    /* renamed from: h, reason: collision with root package name */
    public int f440307h;

    /* renamed from: i, reason: collision with root package name */
    public int f440308i;

    /* renamed from: j, reason: collision with root package name */
    public int f440309j;

    public ba() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ba mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f440300a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f440301b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f440302c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f440303d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f440304e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.f440305f = readInt32;
                        break;
                    }
                case 56:
                    this.f440306g = codedInputByteBufferNano.readBool();
                    break;
                case 64:
                    this.f440307h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f440308i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f440309j = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f440300a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f440301b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440301b);
        }
        if (!this.f440302c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440302c);
        }
        if (!this.f440303d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440303d);
        }
        if (!this.f440304e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440304e);
        }
        int i16 = this.f440305f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        boolean z16 = this.f440306g;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z16);
        }
        int i17 = this.f440307h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        int i18 = this.f440308i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i18);
        }
        int i19 = this.f440309j;
        return i19 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i19) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440300a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440301b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440301b);
        }
        if (!this.f440302c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440302c);
        }
        if (!this.f440303d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440303d);
        }
        if (!this.f440304e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440304e);
        }
        int i16 = this.f440305f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        boolean z16 = this.f440306g;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        int i17 = this.f440307h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        int i18 = this.f440308i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i18);
        }
        int i19 = this.f440309j;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ba a() {
        this.f440300a = 0;
        this.f440301b = "";
        this.f440302c = "";
        this.f440303d = "";
        this.f440304e = "";
        this.f440305f = 0;
        this.f440306g = false;
        this.f440307h = 0;
        this.f440308i = 0;
        this.f440309j = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
