package wy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public b f446712a;

    /* renamed from: b, reason: collision with root package name */
    public long f446713b;

    /* renamed from: c, reason: collision with root package name */
    public int f446714c;

    /* renamed from: d, reason: collision with root package name */
    public int f446715d;

    /* renamed from: e, reason: collision with root package name */
    public int f446716e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f446717f;

    /* renamed from: g, reason: collision with root package name */
    public c f446718g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f446719h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f446720i;

    /* renamed from: j, reason: collision with root package name */
    public int f446721j;

    /* renamed from: k, reason: collision with root package name */
    public int f446722k;

    /* renamed from: l, reason: collision with root package name */
    public int f446723l;

    /* renamed from: m, reason: collision with root package name */
    public String f446724m;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f446712a = null;
        this.f446713b = 0L;
        this.f446714c = 0;
        this.f446715d = 0;
        this.f446716e = 0;
        this.f446717f = false;
        this.f446718g = null;
        this.f446719h = false;
        this.f446720i = WireFormatNano.EMPTY_BYTES;
        this.f446721j = 0;
        this.f446722k = 0;
        this.f446723l = 0;
        this.f446724m = "";
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
                case 10:
                    if (this.f446712a == null) {
                        this.f446712a = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f446712a);
                    break;
                case 16:
                    this.f446713b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f446714c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f446715d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f446716e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f446717f = codedInputByteBufferNano.readBool();
                    break;
                case 58:
                    if (this.f446718g == null) {
                        this.f446718g = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f446718g);
                    break;
                case 64:
                    this.f446719h = codedInputByteBufferNano.readBool();
                    break;
                case 74:
                    this.f446720i = codedInputByteBufferNano.readBytes();
                    break;
                case 80:
                    this.f446721j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f446722k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f446723l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.f446724m = codedInputByteBufferNano.readString();
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
        b bVar = this.f446712a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        long j3 = this.f446713b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.f446714c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.f446715d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f446716e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        boolean z16 = this.f446717f;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        c cVar = this.f446718g;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, cVar);
        }
        boolean z17 = this.f446719h;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z17);
        }
        if (!Arrays.equals(this.f446720i, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.f446720i);
        }
        int i18 = this.f446721j;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i18);
        }
        int i19 = this.f446722k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i19);
        }
        int i26 = this.f446723l;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i26);
        }
        if (!this.f446724m.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(13, this.f446724m);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f446712a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        long j3 = this.f446713b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.f446714c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.f446715d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f446716e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        boolean z16 = this.f446717f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        c cVar = this.f446718g;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(7, cVar);
        }
        boolean z17 = this.f446719h;
        if (z17) {
            codedOutputByteBufferNano.writeBool(8, z17);
        }
        if (!Arrays.equals(this.f446720i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.f446720i);
        }
        int i18 = this.f446721j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i18);
        }
        int i19 = this.f446722k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i19);
        }
        int i26 = this.f446723l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        if (!this.f446724m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f446724m);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
