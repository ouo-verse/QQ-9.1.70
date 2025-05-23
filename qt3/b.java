package qt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f429504a;

    /* renamed from: b, reason: collision with root package name */
    public int f429505b;

    /* renamed from: c, reason: collision with root package name */
    public int f429506c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f429507d;

    /* renamed from: e, reason: collision with root package name */
    public int f429508e;

    /* renamed from: f, reason: collision with root package name */
    public int f429509f;

    /* renamed from: g, reason: collision with root package name */
    public c[] f429510g;

    /* renamed from: h, reason: collision with root package name */
    public long f429511h;

    /* renamed from: i, reason: collision with root package name */
    public int f429512i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f429513j;

    /* renamed from: k, reason: collision with root package name */
    public int f429514k;

    /* renamed from: l, reason: collision with root package name */
    public int f429515l;

    public b() {
        a();
    }

    public b a() {
        this.f429504a = 0;
        this.f429505b = 0;
        this.f429506c = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f429507d = bArr;
        this.f429508e = 0;
        this.f429509f = 0;
        this.f429510g = c.b();
        this.f429511h = 0L;
        this.f429512i = 0;
        this.f429513j = bArr;
        this.f429514k = 0;
        this.f429515l = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f429504a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f429505b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f429506c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f429507d = codedInputByteBufferNano.readBytes();
                    break;
                case 40:
                    this.f429508e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f429509f = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    c[] cVarArr = this.f429510g;
                    if (cVarArr == null) {
                        length = 0;
                    } else {
                        length = cVarArr.length;
                    }
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
                    this.f429510g = cVarArr2;
                    break;
                case 64:
                    this.f429511h = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.f429512i = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.f429513j = codedInputByteBufferNano.readBytes();
                    break;
                case 88:
                    this.f429514k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f429515l = codedInputByteBufferNano.readUInt32();
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
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.f429504a) + CodedOutputByteBufferNano.computeUInt32Size(2, this.f429505b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.f429506c) + CodedOutputByteBufferNano.computeBytesSize(4, this.f429507d) + CodedOutputByteBufferNano.computeUInt32Size(5, this.f429508e) + CodedOutputByteBufferNano.computeUInt32Size(6, this.f429509f);
        c[] cVarArr = this.f429510g;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f429510g;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, cVar);
                }
                i3++;
            }
        }
        int computeUInt64Size = computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, this.f429511h);
        int i16 = this.f429512i;
        if (i16 != 0) {
            computeUInt64Size += CodedOutputByteBufferNano.computeUInt32Size(9, i16);
        }
        if (!Arrays.equals(this.f429513j, WireFormatNano.EMPTY_BYTES)) {
            computeUInt64Size += CodedOutputByteBufferNano.computeBytesSize(10, this.f429513j);
        }
        int i17 = this.f429514k;
        if (i17 != 0) {
            computeUInt64Size += CodedOutputByteBufferNano.computeUInt32Size(11, i17);
        }
        int i18 = this.f429515l;
        if (i18 != 0) {
            return computeUInt64Size + CodedOutputByteBufferNano.computeUInt32Size(12, i18);
        }
        return computeUInt64Size;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.f429504a);
        codedOutputByteBufferNano.writeUInt32(2, this.f429505b);
        codedOutputByteBufferNano.writeUInt32(3, this.f429506c);
        codedOutputByteBufferNano.writeBytes(4, this.f429507d);
        codedOutputByteBufferNano.writeUInt32(5, this.f429508e);
        codedOutputByteBufferNano.writeUInt32(6, this.f429509f);
        c[] cVarArr = this.f429510g;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f429510g;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, cVar);
                }
                i3++;
            }
        }
        codedOutputByteBufferNano.writeUInt64(8, this.f429511h);
        int i16 = this.f429512i;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i16);
        }
        if (!Arrays.equals(this.f429513j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.f429513j);
        }
        int i17 = this.f429514k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i17);
        }
        int i18 = this.f429515l;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
