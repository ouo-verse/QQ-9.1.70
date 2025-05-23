package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class z extends ExtendableMessageNano<z> {

    /* renamed from: a, reason: collision with root package name */
    public String f440473a;

    /* renamed from: b, reason: collision with root package name */
    public String f440474b;

    /* renamed from: c, reason: collision with root package name */
    public int f440475c;

    /* renamed from: d, reason: collision with root package name */
    public int f440476d;

    /* renamed from: e, reason: collision with root package name */
    public ah[] f440477e;

    /* renamed from: f, reason: collision with root package name */
    public int f440478f;

    /* renamed from: g, reason: collision with root package name */
    public int f440479g;

    /* renamed from: h, reason: collision with root package name */
    public String f440480h;

    /* renamed from: i, reason: collision with root package name */
    public int f440481i;

    /* renamed from: j, reason: collision with root package name */
    public String f440482j;

    /* renamed from: k, reason: collision with root package name */
    public String f440483k;

    public z() {
        a();
    }

    public z a() {
        this.f440473a = "";
        this.f440474b = "";
        this.f440475c = 0;
        this.f440476d = 0;
        this.f440477e = ah.b();
        this.f440478f = 0;
        this.f440479g = 0;
        this.f440480h = "";
        this.f440481i = 0;
        this.f440482j = "";
        this.f440483k = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f440473a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f440474b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f440475c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f440476d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    ah[] ahVarArr = this.f440477e;
                    int length = ahVarArr == null ? 0 : ahVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    ah[] ahVarArr2 = new ah[i3];
                    if (length != 0) {
                        System.arraycopy(ahVarArr, 0, ahVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        ah ahVar = new ah();
                        ahVarArr2[length] = ahVar;
                        codedInputByteBufferNano.readMessage(ahVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ah ahVar2 = new ah();
                    ahVarArr2[length] = ahVar2;
                    codedInputByteBufferNano.readMessage(ahVar2);
                    this.f440477e = ahVarArr2;
                    break;
                case 48:
                    this.f440478f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f440479g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.f440480h = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.f440481i = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.f440482j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f440483k = codedInputByteBufferNano.readString();
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
        if (!this.f440473a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440473a);
        }
        if (!this.f440474b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440474b);
        }
        int i3 = this.f440475c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.f440476d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        ah[] ahVarArr = this.f440477e;
        if (ahVarArr != null && ahVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                ah[] ahVarArr2 = this.f440477e;
                if (i17 >= ahVarArr2.length) {
                    break;
                }
                ah ahVar = ahVarArr2[i17];
                if (ahVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, ahVar);
                }
                i17++;
            }
        }
        int i18 = this.f440478f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        int i19 = this.f440479g;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        if (!this.f440480h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f440480h);
        }
        int i26 = this.f440481i;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i26);
        }
        if (!this.f440482j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f440482j);
        }
        return !this.f440483k.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.f440483k) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440473a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440473a);
        }
        if (!this.f440474b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440474b);
        }
        int i3 = this.f440475c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.f440476d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        ah[] ahVarArr = this.f440477e;
        if (ahVarArr != null && ahVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                ah[] ahVarArr2 = this.f440477e;
                if (i17 >= ahVarArr2.length) {
                    break;
                }
                ah ahVar = ahVarArr2[i17];
                if (ahVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, ahVar);
                }
                i17++;
            }
        }
        int i18 = this.f440478f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        int i19 = this.f440479g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        if (!this.f440480h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f440480h);
        }
        int i26 = this.f440481i;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i26);
        }
        if (!this.f440482j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f440482j);
        }
        if (!this.f440483k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f440483k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
