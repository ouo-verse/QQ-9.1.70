package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f451406a;

    /* renamed from: b, reason: collision with root package name */
    public int f451407b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f451408c;

    /* renamed from: d, reason: collision with root package name */
    public int f451409d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f451410e;

    /* renamed from: f, reason: collision with root package name */
    public k f451411f;

    /* renamed from: g, reason: collision with root package name */
    public k f451412g;

    /* renamed from: h, reason: collision with root package name */
    public k f451413h;

    /* renamed from: i, reason: collision with root package name */
    public e f451414i;

    /* renamed from: j, reason: collision with root package name */
    public int f451415j;

    /* renamed from: k, reason: collision with root package name */
    public int f451416k;

    /* renamed from: l, reason: collision with root package name */
    public int f451417l;

    /* renamed from: m, reason: collision with root package name */
    public int f451418m;

    /* renamed from: n, reason: collision with root package name */
    public t f451419n;

    /* renamed from: o, reason: collision with root package name */
    public s f451420o;

    public a() {
        a();
    }

    public a a() {
        this.f451406a = 0;
        this.f451407b = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f451408c = bArr;
        this.f451409d = 0;
        this.f451410e = bArr;
        this.f451411f = null;
        this.f451412g = null;
        this.f451413h = null;
        this.f451414i = null;
        this.f451415j = 0;
        this.f451416k = 0;
        this.f451417l = 0;
        this.f451418m = 0;
        this.f451419n = null;
        this.f451420o = null;
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
                    this.f451406a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f451407b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f451408c = codedInputByteBufferNano.readBytes();
                    break;
                case 32:
                    this.f451409d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f451410e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    if (this.f451411f == null) {
                        this.f451411f = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f451411f);
                    break;
                case 58:
                    if (this.f451412g == null) {
                        this.f451412g = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f451412g);
                    break;
                case 66:
                    if (this.f451413h == null) {
                        this.f451413h = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f451413h);
                    break;
                case 74:
                    if (this.f451414i == null) {
                        this.f451414i = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f451414i);
                    break;
                case 80:
                    this.f451415j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f451416k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f451417l = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.f451418m = codedInputByteBufferNano.readUInt32();
                    break;
                case 114:
                    if (this.f451419n == null) {
                        this.f451419n = new t();
                    }
                    codedInputByteBufferNano.readMessage(this.f451419n);
                    break;
                case 122:
                    if (this.f451420o == null) {
                        this.f451420o = new s();
                    }
                    codedInputByteBufferNano.readMessage(this.f451420o);
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
        int i3 = this.f451406a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f451407b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        byte[] bArr = this.f451408c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f451408c);
        }
        int i17 = this.f451409d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!Arrays.equals(this.f451410e, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f451410e);
        }
        k kVar = this.f451411f;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, kVar);
        }
        k kVar2 = this.f451412g;
        if (kVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, kVar2);
        }
        k kVar3 = this.f451413h;
        if (kVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, kVar3);
        }
        e eVar = this.f451414i;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, eVar);
        }
        int i18 = this.f451415j;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i18);
        }
        int i19 = this.f451416k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i19);
        }
        int i26 = this.f451417l;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i26);
        }
        int i27 = this.f451418m;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i27);
        }
        t tVar = this.f451419n;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, tVar);
        }
        s sVar = this.f451420o;
        if (sVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(15, sVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451406a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f451407b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        byte[] bArr = this.f451408c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.f451408c);
        }
        int i17 = this.f451409d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!Arrays.equals(this.f451410e, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.f451410e);
        }
        k kVar = this.f451411f;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(6, kVar);
        }
        k kVar2 = this.f451412g;
        if (kVar2 != null) {
            codedOutputByteBufferNano.writeMessage(7, kVar2);
        }
        k kVar3 = this.f451413h;
        if (kVar3 != null) {
            codedOutputByteBufferNano.writeMessage(8, kVar3);
        }
        e eVar = this.f451414i;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(9, eVar);
        }
        int i18 = this.f451415j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i18);
        }
        int i19 = this.f451416k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i19);
        }
        int i26 = this.f451417l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        int i27 = this.f451418m;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i27);
        }
        t tVar = this.f451419n;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(14, tVar);
        }
        s sVar = this.f451420o;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(15, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
