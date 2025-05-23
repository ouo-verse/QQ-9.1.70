package sq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: l, reason: collision with root package name */
    private static volatile b[] f434232l;

    /* renamed from: a, reason: collision with root package name */
    public long f434233a;

    /* renamed from: b, reason: collision with root package name */
    public String f434234b;

    /* renamed from: c, reason: collision with root package name */
    public int f434235c;

    /* renamed from: d, reason: collision with root package name */
    public long f434236d;

    /* renamed from: e, reason: collision with root package name */
    public int f434237e;

    /* renamed from: f, reason: collision with root package name */
    public String f434238f;

    /* renamed from: g, reason: collision with root package name */
    public long f434239g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f434240h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f434241i;

    /* renamed from: j, reason: collision with root package name */
    public int f434242j;

    /* renamed from: k, reason: collision with root package name */
    public String f434243k;

    public b() {
        a();
    }

    public static b[] b() {
        if (f434232l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f434232l == null) {
                    f434232l = new b[0];
                }
            }
        }
        return f434232l;
    }

    public b a() {
        this.f434233a = 0L;
        this.f434234b = "";
        this.f434235c = 0;
        this.f434236d = 0L;
        this.f434237e = 0;
        this.f434238f = "";
        this.f434239g = 0L;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f434240h = bArr;
        this.f434241i = bArr;
        this.f434242j = 0;
        this.f434243k = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f434233a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f434234b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f434235c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f434236d = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.f434237e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.f434238f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f434239g = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    this.f434240h = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.f434241i = codedInputByteBufferNano.readBytes();
                    break;
                case 88:
                    this.f434242j = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    this.f434243k = codedInputByteBufferNano.readString();
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
        long j3 = this.f434233a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f434234b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434234b);
        }
        int i3 = this.f434235c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        long j16 = this.f434236d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        int i16 = this.f434237e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        if (!this.f434238f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f434238f);
        }
        long j17 = this.f434239g;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        byte[] bArr = this.f434240h;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.f434240h);
        }
        if (!Arrays.equals(this.f434241i, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.f434241i);
        }
        int i17 = this.f434242j;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i17);
        }
        if (!this.f434243k.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.f434243k);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f434233a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f434234b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434234b);
        }
        int i3 = this.f434235c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        long j16 = this.f434236d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        int i16 = this.f434237e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        if (!this.f434238f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f434238f);
        }
        long j17 = this.f434239g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        byte[] bArr = this.f434240h;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.f434240h);
        }
        if (!Arrays.equals(this.f434241i, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.f434241i);
        }
        int i17 = this.f434242j;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i17);
        }
        if (!this.f434243k.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f434243k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
