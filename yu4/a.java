package yu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
import qu4.n;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f451255a;

    /* renamed from: b, reason: collision with root package name */
    public String f451256b;

    /* renamed from: c, reason: collision with root package name */
    public int f451257c;

    /* renamed from: d, reason: collision with root package name */
    public String f451258d;

    /* renamed from: e, reason: collision with root package name */
    public String f451259e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f451260f;

    /* renamed from: g, reason: collision with root package name */
    public c[] f451261g;

    /* renamed from: h, reason: collision with root package name */
    public int f451262h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f451263i;

    /* renamed from: j, reason: collision with root package name */
    public String f451264j;

    /* renamed from: k, reason: collision with root package name */
    public int f451265k;

    /* renamed from: l, reason: collision with root package name */
    public String f451266l;

    /* renamed from: m, reason: collision with root package name */
    public n f451267m;

    /* renamed from: n, reason: collision with root package name */
    public int f451268n;

    public a() {
        a();
    }

    public a a() {
        this.f451255a = "";
        this.f451256b = "";
        this.f451257c = 0;
        this.f451258d = "";
        this.f451259e = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f451260f = bArr;
        this.f451261g = c.b();
        this.f451262h = 0;
        this.f451263i = bArr;
        this.f451264j = "";
        this.f451265k = 0;
        this.f451266l = "";
        this.f451267m = null;
        this.f451268n = 0;
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
                    this.f451255a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f451256b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f451257c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f451258d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f451259e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f451260f = codedInputByteBufferNano.readBytes();
                    break;
                case 58:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    c[] cVarArr = this.f451261g;
                    int length = cVarArr == null ? 0 : cVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    c[] cVarArr2 = new c[i3];
                    if (length != 0) {
                        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        c cVar = new c();
                        cVarArr2[length] = cVar;
                        codedInputByteBufferNano.readMessage(cVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    c cVar2 = new c();
                    cVarArr2[length] = cVar2;
                    codedInputByteBufferNano.readMessage(cVar2);
                    this.f451261g = cVarArr2;
                    break;
                case 64:
                    this.f451262h = codedInputByteBufferNano.readInt32();
                    break;
                case 74:
                    this.f451263i = codedInputByteBufferNano.readBytes();
                    break;
                case 82:
                    this.f451264j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f451265k = codedInputByteBufferNano.readInt32();
                    break;
                case 98:
                    this.f451266l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    if (this.f451267m == null) {
                        this.f451267m = new n();
                    }
                    codedInputByteBufferNano.readMessage(this.f451267m);
                    break;
                case 112:
                    this.f451268n = codedInputByteBufferNano.readInt32();
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
        if (!this.f451255a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451255a);
        }
        if (!this.f451256b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451256b);
        }
        int i3 = this.f451257c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f451258d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f451258d);
        }
        if (!this.f451259e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f451259e);
        }
        if (!Arrays.equals(this.f451260f, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f451260f);
        }
        c[] cVarArr = this.f451261g;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                c[] cVarArr2 = this.f451261g;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, cVar);
                }
                i16++;
            }
        }
        int i17 = this.f451262h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        if (!Arrays.equals(this.f451263i, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.f451263i);
        }
        if (!this.f451264j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f451264j);
        }
        int i18 = this.f451265k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i18);
        }
        if (!this.f451266l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f451266l);
        }
        n nVar = this.f451267m;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, nVar);
        }
        int i19 = this.f451268n;
        return i19 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(14, i19) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451255a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451255a);
        }
        if (!this.f451256b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451256b);
        }
        int i3 = this.f451257c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f451258d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451258d);
        }
        if (!this.f451259e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451259e);
        }
        if (!Arrays.equals(this.f451260f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f451260f);
        }
        c[] cVarArr = this.f451261g;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                c[] cVarArr2 = this.f451261g;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, cVar);
                }
                i16++;
            }
        }
        int i17 = this.f451262h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        if (!Arrays.equals(this.f451263i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.f451263i);
        }
        if (!this.f451264j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f451264j);
        }
        int i18 = this.f451265k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i18);
        }
        if (!this.f451266l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f451266l);
        }
        n nVar = this.f451267m;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(13, nVar);
        }
        int i19 = this.f451268n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
