package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public String[] f453465a;

    /* renamed from: b, reason: collision with root package name */
    public int f453466b;

    /* renamed from: c, reason: collision with root package name */
    public String f453467c;

    /* renamed from: d, reason: collision with root package name */
    public int f453468d;

    /* renamed from: e, reason: collision with root package name */
    public String f453469e;

    /* renamed from: f, reason: collision with root package name */
    public int f453470f;

    /* renamed from: g, reason: collision with root package name */
    public int f453471g;

    public q() {
        a();
    }

    public static q c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (q) MessageNano.mergeFrom(new q(), bArr);
    }

    public q a() {
        this.f453465a = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f453466b = 0;
        this.f453467c = "";
        this.f453468d = 0;
        this.f453469e = "";
        this.f453470f = 0;
        this.f453471g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                String[] strArr = this.f453465a;
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
                this.f453465a = strArr2;
            } else if (readTag == 16) {
                this.f453466b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f453467c = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.f453468d = codedInputByteBufferNano.readInt32();
            } else if (readTag == 58) {
                this.f453469e = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.f453470f = codedInputByteBufferNano.readInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453471g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.f453465a;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f453465a;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i17++;
                    i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (i17 * 1);
        }
        int i18 = this.f453466b;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i18);
        }
        if (!this.f453467c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f453467c);
        }
        int i19 = this.f453468d;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i19);
        }
        if (!this.f453469e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f453469e);
        }
        int i26 = this.f453470f;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i26);
        }
        int i27 = this.f453471g;
        return i27 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(9, i27) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f453465a;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f453465a;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                i3++;
            }
        }
        int i16 = this.f453466b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f453467c.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f453467c);
        }
        int i17 = this.f453468d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        if (!this.f453469e.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f453469e);
        }
        int i18 = this.f453470f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        int i19 = this.f453471g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
