package sy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f434944a;

    /* renamed from: b, reason: collision with root package name */
    public int f434945b;

    /* renamed from: c, reason: collision with root package name */
    public String f434946c;

    /* renamed from: d, reason: collision with root package name */
    public int f434947d;

    /* renamed from: e, reason: collision with root package name */
    public long f434948e;

    /* renamed from: f, reason: collision with root package name */
    public String f434949f;

    /* renamed from: g, reason: collision with root package name */
    public int f434950g;

    /* renamed from: h, reason: collision with root package name */
    public int f434951h;

    /* renamed from: i, reason: collision with root package name */
    public String f434952i;

    /* renamed from: j, reason: collision with root package name */
    public String f434953j;

    /* renamed from: k, reason: collision with root package name */
    public String f434954k;

    /* renamed from: l, reason: collision with root package name */
    public long f434955l;

    /* renamed from: m, reason: collision with root package name */
    public int f434956m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f434957n;

    /* renamed from: o, reason: collision with root package name */
    public String f434958o;

    /* renamed from: p, reason: collision with root package name */
    public long f434959p;

    /* renamed from: q, reason: collision with root package name */
    public long f434960q;

    /* renamed from: r, reason: collision with root package name */
    public long f434961r;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f434944a = 0;
        this.f434945b = 0;
        this.f434946c = "";
        this.f434947d = 0;
        this.f434948e = 0L;
        this.f434949f = "";
        this.f434950g = 0;
        this.f434951h = 0;
        this.f434952i = "";
        this.f434953j = "";
        this.f434954k = "";
        this.f434955l = 0L;
        this.f434956m = 0;
        this.f434957n = false;
        this.f434958o = "";
        this.f434959p = 0L;
        this.f434960q = 0L;
        this.f434961r = 0L;
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
                case 8:
                    this.f434944a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f434945b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f434946c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f434947d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f434948e = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.f434949f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f434950g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f434951h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f434952i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f434953j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f434954k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f434955l = codedInputByteBufferNano.readUInt64();
                    break;
                case 104:
                    this.f434956m = codedInputByteBufferNano.readUInt32();
                    break;
                case 112:
                    this.f434957n = codedInputByteBufferNano.readBool();
                    break;
                case 122:
                    this.f434958o = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.f434959p = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.f434960q = codedInputByteBufferNano.readUInt64();
                    break;
                case 144:
                    this.f434961r = codedInputByteBufferNano.readUInt64();
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
        int i3 = this.f434944a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f434945b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f434946c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434946c);
        }
        int i17 = this.f434947d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        long j3 = this.f434948e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!this.f434949f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f434949f);
        }
        int i18 = this.f434950g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        int i19 = this.f434951h;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i19);
        }
        if (!this.f434952i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f434952i);
        }
        if (!this.f434953j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f434953j);
        }
        if (!this.f434954k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f434954k);
        }
        long j16 = this.f434955l;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j16);
        }
        int i26 = this.f434956m;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i26);
        }
        boolean z16 = this.f434957n;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, z16);
        }
        if (!this.f434958o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f434958o);
        }
        long j17 = this.f434959p;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j17);
        }
        long j18 = this.f434960q;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(17, j18);
        }
        long j19 = this.f434961r;
        if (j19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(18, j19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f434944a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f434945b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f434946c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434946c);
        }
        int i17 = this.f434947d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        long j3 = this.f434948e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!this.f434949f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f434949f);
        }
        int i18 = this.f434950g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        int i19 = this.f434951h;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i19);
        }
        if (!this.f434952i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f434952i);
        }
        if (!this.f434953j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f434953j);
        }
        if (!this.f434954k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f434954k);
        }
        long j16 = this.f434955l;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j16);
        }
        int i26 = this.f434956m;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i26);
        }
        boolean z16 = this.f434957n;
        if (z16) {
            codedOutputByteBufferNano.writeBool(14, z16);
        }
        if (!this.f434958o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f434958o);
        }
        long j17 = this.f434959p;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j17);
        }
        long j18 = this.f434960q;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(17, j18);
        }
        long j19 = this.f434961r;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(18, j19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
