package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ag extends ExtendableMessageNano<ag> {

    /* renamed from: a, reason: collision with root package name */
    public int f440130a;

    /* renamed from: b, reason: collision with root package name */
    public String f440131b;

    /* renamed from: c, reason: collision with root package name */
    public String f440132c;

    /* renamed from: d, reason: collision with root package name */
    public al f440133d;

    /* renamed from: e, reason: collision with root package name */
    public int f440134e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f440135f;

    /* renamed from: g, reason: collision with root package name */
    public pu4.u f440136g;

    public ag() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ag mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440130a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f440131b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f440132c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                if (this.f440133d == null) {
                    this.f440133d = new al();
                }
                codedInputByteBufferNano.readMessage(this.f440133d);
            } else if (readTag == 40) {
                this.f440134e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                String[] strArr = this.f440135f;
                int length = strArr == null ? 0 : strArr.length;
                int i3 = repeatedFieldArrayLength + length;
                String[] strArr2 = new String[i3];
                if (length != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length);
                }
                while (length < i3 - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.f440135f = strArr2;
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f440136g == null) {
                    this.f440136g = new pu4.u();
                }
                codedInputByteBufferNano.readMessage(this.f440136g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440130a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f440131b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440131b);
        }
        if (!this.f440132c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440132c);
        }
        al alVar = this.f440133d;
        if (alVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, alVar);
        }
        int i16 = this.f440134e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        String[] strArr = this.f440135f;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                String[] strArr2 = this.f440135f;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    i19++;
                    i18 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (i19 * 1);
        }
        pu4.u uVar = this.f440136g;
        return uVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, uVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440130a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440131b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440131b);
        }
        if (!this.f440132c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440132c);
        }
        al alVar = this.f440133d;
        if (alVar != null) {
            codedOutputByteBufferNano.writeMessage(4, alVar);
        }
        int i16 = this.f440134e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        String[] strArr = this.f440135f;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f440135f;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(6, str);
                }
                i17++;
            }
        }
        pu4.u uVar = this.f440136g;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(7, uVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ag a() {
        this.f440130a = 0;
        this.f440131b = "";
        this.f440132c = "";
        this.f440133d = null;
        this.f440134e = 0;
        this.f440135f = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f440136g = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
