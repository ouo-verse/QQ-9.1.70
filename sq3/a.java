package sq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public b f434219a;

    /* renamed from: b, reason: collision with root package name */
    public long f434220b;

    /* renamed from: c, reason: collision with root package name */
    public int f434221c;

    /* renamed from: d, reason: collision with root package name */
    public int f434222d;

    /* renamed from: e, reason: collision with root package name */
    public int f434223e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f434224f;

    /* renamed from: g, reason: collision with root package name */
    public c f434225g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f434226h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f434227i;

    /* renamed from: j, reason: collision with root package name */
    public int f434228j;

    /* renamed from: k, reason: collision with root package name */
    public int f434229k;

    /* renamed from: l, reason: collision with root package name */
    public int f434230l;

    /* renamed from: m, reason: collision with root package name */
    public String f434231m;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f434219a = null;
        this.f434220b = 0L;
        this.f434221c = 0;
        this.f434222d = 0;
        this.f434223e = 0;
        this.f434224f = false;
        this.f434225g = null;
        this.f434226h = false;
        this.f434227i = WireFormatNano.EMPTY_BYTES;
        this.f434228j = 0;
        this.f434229k = 0;
        this.f434230l = 0;
        this.f434231m = "";
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
                    if (this.f434219a == null) {
                        this.f434219a = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f434219a);
                    break;
                case 16:
                    this.f434220b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f434221c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f434222d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f434223e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f434224f = codedInputByteBufferNano.readBool();
                    break;
                case 58:
                    if (this.f434225g == null) {
                        this.f434225g = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f434225g);
                    break;
                case 64:
                    this.f434226h = codedInputByteBufferNano.readBool();
                    break;
                case 74:
                    this.f434227i = codedInputByteBufferNano.readBytes();
                    break;
                case 80:
                    this.f434228j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f434229k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f434230l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.f434231m = codedInputByteBufferNano.readString();
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
        b bVar = this.f434219a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        long j3 = this.f434220b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.f434221c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.f434222d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f434223e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        boolean z16 = this.f434224f;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        c cVar = this.f434225g;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, cVar);
        }
        boolean z17 = this.f434226h;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z17);
        }
        if (!Arrays.equals(this.f434227i, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.f434227i);
        }
        int i18 = this.f434228j;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i18);
        }
        int i19 = this.f434229k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i19);
        }
        int i26 = this.f434230l;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i26);
        }
        if (!this.f434231m.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(13, this.f434231m);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f434219a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        long j3 = this.f434220b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.f434221c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.f434222d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f434223e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        boolean z16 = this.f434224f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        c cVar = this.f434225g;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(7, cVar);
        }
        boolean z17 = this.f434226h;
        if (z17) {
            codedOutputByteBufferNano.writeBool(8, z17);
        }
        if (!Arrays.equals(this.f434227i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.f434227i);
        }
        int i18 = this.f434228j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i18);
        }
        int i19 = this.f434229k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i19);
        }
        int i26 = this.f434230l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        if (!this.f434231m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f434231m);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
