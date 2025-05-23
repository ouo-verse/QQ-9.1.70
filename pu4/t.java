package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public String[] f427523a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f427524b;

    public t() {
        a();
    }

    public t a() {
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f427523a = strArr;
        this.f427524b = strArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                String[] strArr = this.f427523a;
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
                this.f427523a = strArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                String[] strArr3 = this.f427524b;
                int length2 = strArr3 == null ? 0 : strArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                String[] strArr4 = new String[i16];
                if (length2 != 0) {
                    System.arraycopy(strArr3, 0, strArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                strArr4[length2] = codedInputByteBufferNano.readString();
                this.f427524b = strArr4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.f427523a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f427523a;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        String[] strArr3 = this.f427524b;
        if (strArr3 == null || strArr3.length <= 0) {
            return computeSerializedSize;
        }
        int i19 = 0;
        int i26 = 0;
        while (true) {
            String[] strArr4 = this.f427524b;
            if (i3 >= strArr4.length) {
                return computeSerializedSize + i19 + (i26 * 1);
            }
            String str2 = strArr4[i3];
            if (str2 != null) {
                i26++;
                i19 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
            }
            i3++;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f427523a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f427523a;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                i16++;
            }
        }
        String[] strArr3 = this.f427524b;
        if (strArr3 != null && strArr3.length > 0) {
            while (true) {
                String[] strArr4 = this.f427524b;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
