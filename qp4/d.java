package qp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f429210a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f429211b;

    /* renamed from: c, reason: collision with root package name */
    public int f429212c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f429213d;

    /* renamed from: e, reason: collision with root package name */
    public String f429214e;

    public d() {
        a();
    }

    public d a() {
        this.f429210a = "";
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f429211b = strArr;
        this.f429212c = 0;
        this.f429213d = strArr;
        this.f429214e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f429214e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                String[] strArr = this.f429213d;
                                if (strArr == null) {
                                    length = 0;
                                } else {
                                    length = strArr.length;
                                }
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
                                this.f429213d = strArr2;
                            }
                        } else {
                            this.f429212c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        String[] strArr3 = this.f429211b;
                        if (strArr3 == null) {
                            length2 = 0;
                        } else {
                            length2 = strArr3.length;
                        }
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
                        this.f429211b = strArr4;
                    }
                } else {
                    this.f429210a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f429210a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429210a);
        }
        String[] strArr = this.f429211b;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f429211b;
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
        int i19 = this.f429212c;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i19);
        }
        String[] strArr3 = this.f429213d;
        if (strArr3 != null && strArr3.length > 0) {
            int i26 = 0;
            int i27 = 0;
            while (true) {
                String[] strArr4 = this.f429213d;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    i27++;
                    i26 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (i27 * 1);
        }
        if (!this.f429214e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f429214e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429210a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429210a);
        }
        String[] strArr = this.f429211b;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f429211b;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i16++;
            }
        }
        int i17 = this.f429212c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        String[] strArr3 = this.f429213d;
        if (strArr3 != null && strArr3.length > 0) {
            while (true) {
                String[] strArr4 = this.f429213d;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(4, str2);
                }
                i3++;
            }
        }
        if (!this.f429214e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f429214e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
