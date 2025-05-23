package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f448513a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f448514b;

    /* renamed from: c, reason: collision with root package name */
    public b f448515c;

    /* renamed from: d, reason: collision with root package name */
    public b f448516d;

    public a() {
        a();
    }

    public a a() {
        this.f448513a = "";
        this.f448514b = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f448515c = null;
        this.f448516d = null;
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
                this.f448513a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                String[] strArr = this.f448514b;
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
                this.f448514b = strArr2;
            } else if (readTag == 26) {
                if (this.f448515c == null) {
                    this.f448515c = new b();
                }
                codedInputByteBufferNano.readMessage(this.f448515c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448516d == null) {
                    this.f448516d = new b();
                }
                codedInputByteBufferNano.readMessage(this.f448516d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f448513a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f448513a);
        }
        String[] strArr = this.f448514b;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f448514b;
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
        b bVar = this.f448515c;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bVar);
        }
        b bVar2 = this.f448516d;
        return bVar2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, bVar2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f448513a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f448513a);
        }
        String[] strArr = this.f448514b;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f448514b;
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
        b bVar = this.f448515c;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(3, bVar);
        }
        b bVar2 = this.f448516d;
        if (bVar2 != null) {
            codedOutputByteBufferNano.writeMessage(4, bVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
