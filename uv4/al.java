package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class al extends ExtendableMessageNano<al> {

    /* renamed from: a, reason: collision with root package name */
    public qu4.a f440152a;

    /* renamed from: b, reason: collision with root package name */
    public az[] f440153b;

    /* renamed from: c, reason: collision with root package name */
    public String f440154c;

    /* renamed from: d, reason: collision with root package name */
    public String f440155d;

    public al() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public al mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f440152a == null) {
                    this.f440152a = new qu4.a();
                }
                codedInputByteBufferNano.readMessage(this.f440152a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                az[] azVarArr = this.f440153b;
                int length = azVarArr == null ? 0 : azVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                az[] azVarArr2 = new az[i3];
                if (length != 0) {
                    System.arraycopy(azVarArr, 0, azVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    az azVar = new az();
                    azVarArr2[length] = azVar;
                    codedInputByteBufferNano.readMessage(azVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                az azVar2 = new az();
                azVarArr2[length] = azVar2;
                codedInputByteBufferNano.readMessage(azVar2);
                this.f440153b = azVarArr2;
            } else if (readTag == 26) {
                this.f440154c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440155d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        qu4.a aVar = this.f440152a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        az[] azVarArr = this.f440153b;
        if (azVarArr != null && azVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                az[] azVarArr2 = this.f440153b;
                if (i3 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i3];
                if (azVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, azVar);
                }
                i3++;
            }
        }
        if (!this.f440154c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440154c);
        }
        return !this.f440155d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f440155d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        qu4.a aVar = this.f440152a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        az[] azVarArr = this.f440153b;
        if (azVarArr != null && azVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                az[] azVarArr2 = this.f440153b;
                if (i3 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i3];
                if (azVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, azVar);
                }
                i3++;
            }
        }
        if (!this.f440154c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440154c);
        }
        if (!this.f440155d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440155d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public al a() {
        this.f440152a = null;
        this.f440153b = az.b();
        this.f440154c = "";
        this.f440155d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
