package u45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String[] f438235a;

    /* renamed from: b, reason: collision with root package name */
    public int f438236b;

    /* renamed from: c, reason: collision with root package name */
    public int f438237c;

    /* renamed from: d, reason: collision with root package name */
    public String f438238d;

    /* renamed from: e, reason: collision with root package name */
    public String f438239e;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    public h a() {
        this.f438235a = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f438236b = 0;
        this.f438237c = 0;
        this.f438238d = "";
        this.f438239e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                String[] strArr = this.f438235a;
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
                this.f438235a = strArr2;
            } else if (readTag == 16) {
                this.f438236b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f438237c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.f438238d = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f438239e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.f438235a;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f438235a;
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
        int i18 = this.f438236b;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i18);
        }
        int i19 = this.f438237c;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i19);
        }
        if (!this.f438238d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f438238d);
        }
        return !this.f438239e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f438239e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f438235a;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f438235a;
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
        int i16 = this.f438236b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f438237c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        if (!this.f438238d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f438238d);
        }
        if (!this.f438239e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f438239e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
