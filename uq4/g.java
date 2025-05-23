package uq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public a[] f439849a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f439850b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends ExtendableMessageNano<a> {

        /* renamed from: c, reason: collision with root package name */
        private static volatile a[] f439851c;

        /* renamed from: a, reason: collision with root package name */
        public String f439852a;

        /* renamed from: b, reason: collision with root package name */
        public String f439853b;

        public a() {
            a();
        }

        public static a[] b() {
            if (f439851c == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (f439851c == null) {
                        f439851c = new a[0];
                    }
                }
            }
            return f439851c;
        }

        public a a() {
            this.f439852a = "";
            this.f439853b = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag != 0) {
                    if (readTag != 10) {
                        if (readTag != 18) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f439853b = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f439852a = codedInputByteBufferNano.readString();
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
            if (!this.f439852a.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f439852a);
            }
            if (!this.f439853b.equals("")) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f439853b);
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.f439852a.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.f439852a);
            }
            if (!this.f439853b.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.f439853b);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public g() {
        a();
    }

    public g a() {
        this.f439849a = a.b();
        this.f439850b = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        String[] strArr = this.f439850b;
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
                        this.f439850b = strArr2;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    a[] aVarArr = this.f439849a;
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
                    this.f439849a = aVarArr2;
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
        a[] aVarArr = this.f439849a;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f439849a;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
                }
                i16++;
            }
        }
        String[] strArr = this.f439850b;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f439850b;
                if (i3 < strArr2.length) {
                    String str = strArr2[i3];
                    if (str != null) {
                        i18++;
                        i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i3++;
                } else {
                    return computeSerializedSize + i17 + (i18 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a[] aVarArr = this.f439849a;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f439849a;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aVar);
                }
                i16++;
            }
        }
        String[] strArr = this.f439850b;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.f439850b;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
