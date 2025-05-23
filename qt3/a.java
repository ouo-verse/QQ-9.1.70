package qt3;

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
    public long f429493a;

    /* renamed from: b, reason: collision with root package name */
    public long f429494b;

    /* renamed from: c, reason: collision with root package name */
    public int f429495c;

    /* renamed from: d, reason: collision with root package name */
    public int f429496d;

    /* renamed from: e, reason: collision with root package name */
    public int f429497e;

    /* renamed from: f, reason: collision with root package name */
    public b f429498f;

    /* renamed from: g, reason: collision with root package name */
    public int f429499g;

    /* renamed from: h, reason: collision with root package name */
    public int f429500h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f429501i;

    /* renamed from: j, reason: collision with root package name */
    public int f429502j;

    /* renamed from: k, reason: collision with root package name */
    public String f429503k;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f429493a = 0L;
        this.f429494b = 0L;
        this.f429495c = 0;
        this.f429496d = 0;
        this.f429497e = 0;
        this.f429498f = null;
        this.f429499g = 0;
        this.f429500h = 0;
        this.f429501i = WireFormatNano.EMPTY_BYTES;
        this.f429502j = 0;
        this.f429503k = "";
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
                    this.f429493a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f429494b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f429495c = codedInputByteBufferNano.readInt32();
                    break;
                case 32:
                    this.f429496d = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    this.f429497e = codedInputByteBufferNano.readInt32();
                    break;
                case 50:
                    if (this.f429498f == null) {
                        this.f429498f = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f429498f);
                    break;
                case 56:
                    this.f429499g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 10) {
                        break;
                    } else {
                        this.f429500h = readInt32;
                        break;
                    }
                case 74:
                    this.f429501i = codedInputByteBufferNano.readBytes();
                    break;
                case 80:
                    this.f429502j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.f429503k = codedInputByteBufferNano.readString();
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
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.f429493a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.f429494b) + CodedOutputByteBufferNano.computeInt32Size(3, this.f429495c) + CodedOutputByteBufferNano.computeInt32Size(4, this.f429496d) + CodedOutputByteBufferNano.computeInt32Size(5, this.f429497e);
        b bVar = this.f429498f;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, bVar);
        }
        int i3 = this.f429499g;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        int i16 = this.f429500h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i16);
        }
        if (!Arrays.equals(this.f429501i, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.f429501i);
        }
        int i17 = this.f429502j;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        if (!this.f429503k.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.f429503k);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f429493a);
        codedOutputByteBufferNano.writeUInt64(2, this.f429494b);
        codedOutputByteBufferNano.writeInt32(3, this.f429495c);
        codedOutputByteBufferNano.writeInt32(4, this.f429496d);
        codedOutputByteBufferNano.writeInt32(5, this.f429497e);
        b bVar = this.f429498f;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(6, bVar);
        }
        int i3 = this.f429499g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        int i16 = this.f429500h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i16);
        }
        if (!Arrays.equals(this.f429501i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.f429501i);
        }
        int i17 = this.f429502j;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        if (!this.f429503k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f429503k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
