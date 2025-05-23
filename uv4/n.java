package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public qu4.a f440432a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f440433b;

    public n() {
        a();
    }

    public static n c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (n) MessageNano.mergeFrom(new n(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f440432a == null) {
                    this.f440432a = new qu4.a();
                }
                codedInputByteBufferNano.readMessage(this.f440432a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                String[] strArr = this.f440433b;
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
                this.f440433b = strArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        qu4.a aVar = this.f440432a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        String[] strArr = this.f440433b;
        if (strArr == null || strArr.length <= 0) {
            return computeSerializedSize;
        }
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            String[] strArr2 = this.f440433b;
            if (i3 >= strArr2.length) {
                return computeSerializedSize + i16 + (i17 * 1);
            }
            String str = strArr2[i3];
            if (str != null) {
                i17++;
                i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
            }
            i3++;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        qu4.a aVar = this.f440432a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        String[] strArr = this.f440433b;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f440433b;
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

    public n a() {
        this.f440432a = null;
        this.f440433b = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
