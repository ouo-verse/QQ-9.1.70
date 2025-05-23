package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String[] f427559a;

    /* renamed from: b, reason: collision with root package name */
    public u f427560b;

    /* renamed from: c, reason: collision with root package name */
    public u f427561c;

    /* renamed from: d, reason: collision with root package name */
    public u f427562d;

    public a() {
        a();
    }

    public a a() {
        this.f427559a = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f427560b = null;
        this.f427561c = null;
        this.f427562d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                String[] strArr = this.f427559a;
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
                this.f427559a = strArr2;
            } else if (readTag == 18) {
                if (this.f427560b == null) {
                    this.f427560b = new u();
                }
                codedInputByteBufferNano.readMessage(this.f427560b);
            } else if (readTag == 26) {
                if (this.f427561c == null) {
                    this.f427561c = new u();
                }
                codedInputByteBufferNano.readMessage(this.f427561c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f427562d == null) {
                    this.f427562d = new u();
                }
                codedInputByteBufferNano.readMessage(this.f427562d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.f427559a;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f427559a;
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
        u uVar = this.f427560b;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, uVar);
        }
        u uVar2 = this.f427561c;
        if (uVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, uVar2);
        }
        u uVar3 = this.f427562d;
        return uVar3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, uVar3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f427559a;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f427559a;
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
        u uVar = this.f427560b;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(2, uVar);
        }
        u uVar2 = this.f427561c;
        if (uVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, uVar2);
        }
        u uVar3 = this.f427562d;
        if (uVar3 != null) {
            codedOutputByteBufferNano.writeMessage(4, uVar3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
