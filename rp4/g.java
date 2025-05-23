package rp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f431878a;

    /* renamed from: b, reason: collision with root package name */
    public int f431879b;

    /* renamed from: c, reason: collision with root package name */
    public String f431880c;

    /* renamed from: d, reason: collision with root package name */
    public String f431881d;

    /* renamed from: e, reason: collision with root package name */
    public String f431882e;

    /* renamed from: f, reason: collision with root package name */
    public String f431883f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f431884g;

    /* renamed from: h, reason: collision with root package name */
    public String f431885h;

    /* renamed from: i, reason: collision with root package name */
    public String f431886i;

    /* renamed from: j, reason: collision with root package name */
    public String f431887j;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    public g a() {
        this.f431878a = 0;
        this.f431879b = 0;
        this.f431880c = "";
        this.f431881d = "";
        this.f431882e = "";
        this.f431883f = "";
        this.f431884g = WireFormatNano.EMPTY_BYTES;
        this.f431885h = "";
        this.f431886i = "";
        this.f431887j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f431878a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f431879b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f431880c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f431881d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f431882e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f431883f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f431884g = codedInputByteBufferNano.readBytes();
                    break;
                case 66:
                    this.f431885h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f431886i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f431887j = codedInputByteBufferNano.readString();
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
        int i3 = this.f431878a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f431879b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f431880c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f431880c);
        }
        if (!this.f431881d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f431881d);
        }
        if (!this.f431882e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f431882e);
        }
        if (!this.f431883f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f431883f);
        }
        if (!Arrays.equals(this.f431884g, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.f431884g);
        }
        if (!this.f431885h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f431885h);
        }
        if (!this.f431886i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f431886i);
        }
        if (!this.f431887j.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f431887j);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f431878a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f431879b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f431880c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f431880c);
        }
        if (!this.f431881d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f431881d);
        }
        if (!this.f431882e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f431882e);
        }
        if (!this.f431883f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f431883f);
        }
        if (!Arrays.equals(this.f431884g, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(7, this.f431884g);
        }
        if (!this.f431885h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f431885h);
        }
        if (!this.f431886i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f431886i);
        }
        if (!this.f431887j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f431887j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
