package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public String f427462a;

    /* renamed from: b, reason: collision with root package name */
    public String f427463b;

    /* renamed from: c, reason: collision with root package name */
    public int f427464c;

    /* renamed from: d, reason: collision with root package name */
    public int f427465d;

    /* renamed from: e, reason: collision with root package name */
    public int f427466e;

    /* renamed from: f, reason: collision with root package name */
    public int f427467f;

    /* renamed from: g, reason: collision with root package name */
    public int f427468g;

    /* renamed from: h, reason: collision with root package name */
    public long f427469h;

    /* renamed from: i, reason: collision with root package name */
    public int f427470i;

    /* renamed from: j, reason: collision with root package name */
    public int f427471j;

    /* renamed from: k, reason: collision with root package name */
    public long f427472k;

    public j() {
        a();
    }

    public j a() {
        this.f427462a = "";
        this.f427463b = "";
        this.f427464c = 0;
        this.f427465d = 0;
        this.f427466e = 0;
        this.f427467f = 0;
        this.f427468g = 0;
        this.f427469h = 0L;
        this.f427470i = 0;
        this.f427471j = 0;
        this.f427472k = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f427462a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f427463b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f427464c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f427465d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f427466e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f427467f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f427468g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f427469h = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.f427470i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f427471j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f427472k = codedInputByteBufferNano.readUInt64();
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
        if (!this.f427462a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427462a);
        }
        if (!this.f427463b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427463b);
        }
        int i3 = this.f427464c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.f427465d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f427466e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.f427467f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        int i19 = this.f427468g;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        long j3 = this.f427469h;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j3);
        }
        int i26 = this.f427470i;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i26);
        }
        int i27 = this.f427471j;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i27);
        }
        long j16 = this.f427472k;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427462a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427462a);
        }
        if (!this.f427463b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427463b);
        }
        int i3 = this.f427464c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.f427465d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f427466e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.f427467f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        int i19 = this.f427468g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        long j3 = this.f427469h;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j3);
        }
        int i26 = this.f427470i;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i26);
        }
        int i27 = this.f427471j;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i27);
        }
        long j16 = this.f427472k;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
