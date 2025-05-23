package rt3;

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
    public int f432207a;

    /* renamed from: b, reason: collision with root package name */
    public int f432208b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f432209c;

    /* renamed from: d, reason: collision with root package name */
    public int f432210d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f432211e;

    /* renamed from: f, reason: collision with root package name */
    public v f432212f;

    /* renamed from: g, reason: collision with root package name */
    public v f432213g;

    /* renamed from: h, reason: collision with root package name */
    public v f432214h;

    /* renamed from: i, reason: collision with root package name */
    public e f432215i;

    /* renamed from: j, reason: collision with root package name */
    public int f432216j;

    /* renamed from: k, reason: collision with root package name */
    public int f432217k;

    /* renamed from: l, reason: collision with root package name */
    public int f432218l;

    /* renamed from: m, reason: collision with root package name */
    public int f432219m;

    /* renamed from: n, reason: collision with root package name */
    public ag f432220n;

    /* renamed from: o, reason: collision with root package name */
    public af f432221o;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f432207a = 0;
        this.f432208b = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f432209c = bArr;
        this.f432210d = 0;
        this.f432211e = bArr;
        this.f432212f = null;
        this.f432213g = null;
        this.f432214h = null;
        this.f432215i = null;
        this.f432216j = 0;
        this.f432217k = 0;
        this.f432218l = 0;
        this.f432219m = 0;
        this.f432220n = null;
        this.f432221o = null;
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
                    this.f432207a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f432208b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f432209c = codedInputByteBufferNano.readBytes();
                    break;
                case 32:
                    this.f432210d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f432211e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    if (this.f432212f == null) {
                        this.f432212f = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.f432212f);
                    break;
                case 58:
                    if (this.f432213g == null) {
                        this.f432213g = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.f432213g);
                    break;
                case 66:
                    if (this.f432214h == null) {
                        this.f432214h = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.f432214h);
                    break;
                case 74:
                    if (this.f432215i == null) {
                        this.f432215i = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f432215i);
                    break;
                case 80:
                    this.f432216j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f432217k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f432218l = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.f432219m = codedInputByteBufferNano.readUInt32();
                    break;
                case 114:
                    if (this.f432220n == null) {
                        this.f432220n = new ag();
                    }
                    codedInputByteBufferNano.readMessage(this.f432220n);
                    break;
                case 122:
                    if (this.f432221o == null) {
                        this.f432221o = new af();
                    }
                    codedInputByteBufferNano.readMessage(this.f432221o);
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
        int i3 = this.f432207a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f432208b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        byte[] bArr = this.f432209c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f432209c);
        }
        int i17 = this.f432210d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!Arrays.equals(this.f432211e, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f432211e);
        }
        v vVar = this.f432212f;
        if (vVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, vVar);
        }
        v vVar2 = this.f432213g;
        if (vVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, vVar2);
        }
        v vVar3 = this.f432214h;
        if (vVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, vVar3);
        }
        e eVar = this.f432215i;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, eVar);
        }
        int i18 = this.f432216j;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i18);
        }
        int i19 = this.f432217k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i19);
        }
        int i26 = this.f432218l;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i26);
        }
        int i27 = this.f432219m;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i27);
        }
        ag agVar = this.f432220n;
        if (agVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, agVar);
        }
        af afVar = this.f432221o;
        if (afVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(15, afVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432207a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f432208b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        byte[] bArr = this.f432209c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.f432209c);
        }
        int i17 = this.f432210d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!Arrays.equals(this.f432211e, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.f432211e);
        }
        v vVar = this.f432212f;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(6, vVar);
        }
        v vVar2 = this.f432213g;
        if (vVar2 != null) {
            codedOutputByteBufferNano.writeMessage(7, vVar2);
        }
        v vVar3 = this.f432214h;
        if (vVar3 != null) {
            codedOutputByteBufferNano.writeMessage(8, vVar3);
        }
        e eVar = this.f432215i;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(9, eVar);
        }
        int i18 = this.f432216j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i18);
        }
        int i19 = this.f432217k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i19);
        }
        int i26 = this.f432218l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        int i27 = this.f432219m;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i27);
        }
        ag agVar = this.f432220n;
        if (agVar != null) {
            codedOutputByteBufferNano.writeMessage(14, agVar);
        }
        af afVar = this.f432221o;
        if (afVar != null) {
            codedOutputByteBufferNano.writeMessage(15, afVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
