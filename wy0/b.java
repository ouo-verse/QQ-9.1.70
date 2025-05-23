package wy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: l, reason: collision with root package name */
    private static volatile b[] f446725l;

    /* renamed from: a, reason: collision with root package name */
    public long f446726a;

    /* renamed from: b, reason: collision with root package name */
    public String f446727b;

    /* renamed from: c, reason: collision with root package name */
    public int f446728c;

    /* renamed from: d, reason: collision with root package name */
    public long f446729d;

    /* renamed from: e, reason: collision with root package name */
    public int f446730e;

    /* renamed from: f, reason: collision with root package name */
    public String f446731f;

    /* renamed from: g, reason: collision with root package name */
    public long f446732g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f446733h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f446734i;

    /* renamed from: j, reason: collision with root package name */
    public int f446735j;

    /* renamed from: k, reason: collision with root package name */
    public String f446736k;

    public b() {
        a();
    }

    public static b[] b() {
        if (f446725l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f446725l == null) {
                    f446725l = new b[0];
                }
            }
        }
        return f446725l;
    }

    public b a() {
        this.f446726a = 0L;
        this.f446727b = "";
        this.f446728c = 0;
        this.f446729d = 0L;
        this.f446730e = 0;
        this.f446731f = "";
        this.f446732g = 0L;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f446733h = bArr;
        this.f446734i = bArr;
        this.f446735j = 0;
        this.f446736k = "";
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
                    this.f446726a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f446727b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f446728c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f446729d = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.f446730e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.f446731f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f446732g = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    this.f446733h = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.f446734i = codedInputByteBufferNano.readBytes();
                    break;
                case 88:
                    this.f446735j = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    this.f446736k = codedInputByteBufferNano.readString();
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
        long j3 = this.f446726a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f446727b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f446727b);
        }
        int i3 = this.f446728c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        long j16 = this.f446729d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        int i16 = this.f446730e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        if (!this.f446731f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f446731f);
        }
        long j17 = this.f446732g;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        byte[] bArr = this.f446733h;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.f446733h);
        }
        if (!Arrays.equals(this.f446734i, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.f446734i);
        }
        int i17 = this.f446735j;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i17);
        }
        if (!this.f446736k.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.f446736k);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f446726a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f446727b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f446727b);
        }
        int i3 = this.f446728c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        long j16 = this.f446729d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        int i16 = this.f446730e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        if (!this.f446731f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f446731f);
        }
        long j17 = this.f446732g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        byte[] bArr = this.f446733h;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.f446733h);
        }
        if (!Arrays.equals(this.f446734i, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.f446734i);
        }
        int i17 = this.f446735j;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i17);
        }
        if (!this.f446736k.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f446736k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
