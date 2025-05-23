package qr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f429379a;

    /* renamed from: b, reason: collision with root package name */
    public int f429380b;

    /* renamed from: c, reason: collision with root package name */
    public e[] f429381c;

    /* renamed from: d, reason: collision with root package name */
    public String f429382d;

    /* renamed from: e, reason: collision with root package name */
    public int f429383e;

    /* renamed from: f, reason: collision with root package name */
    public long f429384f;

    /* renamed from: g, reason: collision with root package name */
    public String f429385g;

    /* renamed from: h, reason: collision with root package name */
    public String f429386h;

    /* renamed from: i, reason: collision with root package name */
    public a[] f429387i;

    /* renamed from: j, reason: collision with root package name */
    public String f429388j;

    public c() {
        a();
    }

    public c a() {
        this.f429379a = 0;
        this.f429380b = 0;
        this.f429381c = e.b();
        this.f429382d = "";
        this.f429383e = 0;
        this.f429384f = 0L;
        this.f429385g = "";
        this.f429386h = "";
        this.f429387i = a.b();
        this.f429388j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f429379a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f429380b = codedInputByteBufferNano.readInt32();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    e[] eVarArr = this.f429381c;
                    if (eVarArr == null) {
                        length = 0;
                    } else {
                        length = eVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    e[] eVarArr2 = new e[i3];
                    if (length != 0) {
                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        e eVar = new e();
                        eVarArr2[length] = eVar;
                        codedInputByteBufferNano.readMessage(eVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    e eVar2 = new e();
                    eVarArr2[length] = eVar2;
                    codedInputByteBufferNano.readMessage(eVar2);
                    this.f429381c = eVarArr2;
                    break;
                case 34:
                    this.f429382d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f429383e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f429384f = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    this.f429385g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f429386h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    a[] aVarArr = this.f429387i;
                    if (aVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = aVarArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    a[] aVarArr2 = new a[i16];
                    if (length2 != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        a aVar = new a();
                        aVarArr2[length2] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    a aVar2 = new a();
                    aVarArr2[length2] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f429387i = aVarArr2;
                    break;
                case 82:
                    this.f429388j = codedInputByteBufferNano.readString();
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
        int i3 = this.f429379a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f429380b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        e[] eVarArr = this.f429381c;
        int i17 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                e[] eVarArr2 = this.f429381c;
                if (i18 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i18];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
                }
                i18++;
            }
        }
        if (!this.f429382d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f429382d);
        }
        int i19 = this.f429383e;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        long j3 = this.f429384f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        if (!this.f429385g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f429385g);
        }
        if (!this.f429386h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f429386h);
        }
        a[] aVarArr = this.f429387i;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f429387i;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i17];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, aVar);
                }
                i17++;
            }
        }
        if (!this.f429388j.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f429388j);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429379a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f429380b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        e[] eVarArr = this.f429381c;
        int i17 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                e[] eVarArr2 = this.f429381c;
                if (i18 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i18];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, eVar);
                }
                i18++;
            }
        }
        if (!this.f429382d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429382d);
        }
        int i19 = this.f429383e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        long j3 = this.f429384f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        if (!this.f429385g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f429385g);
        }
        if (!this.f429386h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f429386h);
        }
        a[] aVarArr = this.f429387i;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f429387i;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i17];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, aVar);
                }
                i17++;
            }
        }
        if (!this.f429388j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f429388j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
