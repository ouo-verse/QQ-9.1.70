package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ae extends ExtendableMessageNano<ae> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile ae[] f432240d;

    /* renamed from: a, reason: collision with root package name */
    public k[] f432241a;

    /* renamed from: b, reason: collision with root package name */
    public String f432242b;

    /* renamed from: c, reason: collision with root package name */
    public int f432243c;

    public ae() {
        a();
    }

    public static ae[] b() {
        if (f432240d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432240d == null) {
                    f432240d = new ae[0];
                }
            }
        }
        return f432240d;
    }

    public ae a() {
        this.f432241a = k.b();
        this.f432242b = "";
        this.f432243c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ae mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f432243c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f432242b = codedInputByteBufferNano.readString();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    k[] kVarArr = this.f432241a;
                    if (kVarArr == null) {
                        length = 0;
                    } else {
                        length = kVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    k[] kVarArr2 = new k[i3];
                    if (length != 0) {
                        System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        k kVar = new k();
                        kVarArr2[length] = kVar;
                        codedInputByteBufferNano.readMessage(kVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    k kVar2 = new k();
                    kVarArr2[length] = kVar2;
                    codedInputByteBufferNano.readMessage(kVar2);
                    this.f432241a = kVarArr2;
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
        k[] kVarArr = this.f432241a;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f432241a;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, kVar);
                }
                i3++;
            }
        }
        if (!this.f432242b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432242b);
        }
        int i16 = this.f432243c;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        k[] kVarArr = this.f432241a;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f432241a;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, kVar);
                }
                i3++;
            }
        }
        if (!this.f432242b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432242b);
        }
        int i16 = this.f432243c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
