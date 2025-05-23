package xy0;

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
    public long f449027a;

    /* renamed from: b, reason: collision with root package name */
    public long f449028b;

    /* renamed from: c, reason: collision with root package name */
    public int f449029c;

    /* renamed from: d, reason: collision with root package name */
    public int f449030d;

    /* renamed from: e, reason: collision with root package name */
    public int f449031e;

    /* renamed from: f, reason: collision with root package name */
    public b f449032f;

    /* renamed from: g, reason: collision with root package name */
    public int f449033g;

    /* renamed from: h, reason: collision with root package name */
    public int f449034h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f449035i;

    /* renamed from: j, reason: collision with root package name */
    public int f449036j;

    /* renamed from: k, reason: collision with root package name */
    public String f449037k;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f449027a = 0L;
        this.f449028b = 0L;
        this.f449029c = 0;
        this.f449030d = 0;
        this.f449031e = 0;
        this.f449032f = null;
        this.f449033g = 0;
        this.f449034h = 0;
        this.f449035i = WireFormatNano.EMPTY_BYTES;
        this.f449036j = 0;
        this.f449037k = "";
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
                    this.f449027a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f449028b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f449029c = codedInputByteBufferNano.readInt32();
                    break;
                case 32:
                    this.f449030d = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    this.f449031e = codedInputByteBufferNano.readInt32();
                    break;
                case 50:
                    if (this.f449032f == null) {
                        this.f449032f = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f449032f);
                    break;
                case 56:
                    this.f449033g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 10) {
                        break;
                    } else {
                        this.f449034h = readInt32;
                        break;
                    }
                case 74:
                    this.f449035i = codedInputByteBufferNano.readBytes();
                    break;
                case 80:
                    this.f449036j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.f449037k = codedInputByteBufferNano.readString();
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
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.f449027a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.f449028b) + CodedOutputByteBufferNano.computeInt32Size(3, this.f449029c) + CodedOutputByteBufferNano.computeInt32Size(4, this.f449030d) + CodedOutputByteBufferNano.computeInt32Size(5, this.f449031e);
        b bVar = this.f449032f;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, bVar);
        }
        int i3 = this.f449033g;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        int i16 = this.f449034h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i16);
        }
        if (!Arrays.equals(this.f449035i, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.f449035i);
        }
        int i17 = this.f449036j;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        if (!this.f449037k.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.f449037k);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f449027a);
        codedOutputByteBufferNano.writeUInt64(2, this.f449028b);
        codedOutputByteBufferNano.writeInt32(3, this.f449029c);
        codedOutputByteBufferNano.writeInt32(4, this.f449030d);
        codedOutputByteBufferNano.writeInt32(5, this.f449031e);
        b bVar = this.f449032f;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(6, bVar);
        }
        int i3 = this.f449033g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        int i16 = this.f449034h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i16);
        }
        if (!Arrays.equals(this.f449035i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.f449035i);
        }
        int i17 = this.f449036j;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        if (!this.f449037k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f449037k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
