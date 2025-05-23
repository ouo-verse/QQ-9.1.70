package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class au extends ExtendableMessageNano<au> {

    /* renamed from: a, reason: collision with root package name */
    public qu4.f f440232a;

    /* renamed from: b, reason: collision with root package name */
    public az[] f440233b;

    /* renamed from: c, reason: collision with root package name */
    public String f440234c;

    /* renamed from: d, reason: collision with root package name */
    public String f440235d;

    /* renamed from: e, reason: collision with root package name */
    public az[] f440236e;

    public au() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public au mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f440232a == null) {
                    this.f440232a = new qu4.f();
                }
                codedInputByteBufferNano.readMessage(this.f440232a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                az[] azVarArr = this.f440233b;
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
                this.f440233b = azVarArr2;
            } else if (readTag == 26) {
                this.f440234c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f440235d = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                az[] azVarArr3 = this.f440236e;
                int length2 = azVarArr3 == null ? 0 : azVarArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                az[] azVarArr4 = new az[i16];
                if (length2 != 0) {
                    System.arraycopy(azVarArr3, 0, azVarArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    az azVar3 = new az();
                    azVarArr4[length2] = azVar3;
                    codedInputByteBufferNano.readMessage(azVar3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                az azVar4 = new az();
                azVarArr4[length2] = azVar4;
                codedInputByteBufferNano.readMessage(azVar4);
                this.f440236e = azVarArr4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        qu4.f fVar = this.f440232a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        az[] azVarArr = this.f440233b;
        int i3 = 0;
        if (azVarArr != null && azVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                az[] azVarArr2 = this.f440233b;
                if (i16 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i16];
                if (azVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, azVar);
                }
                i16++;
            }
        }
        if (!this.f440234c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440234c);
        }
        if (!this.f440235d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440235d);
        }
        az[] azVarArr3 = this.f440236e;
        if (azVarArr3 != null && azVarArr3.length > 0) {
            while (true) {
                az[] azVarArr4 = this.f440236e;
                if (i3 >= azVarArr4.length) {
                    break;
                }
                az azVar2 = azVarArr4[i3];
                if (azVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, azVar2);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        qu4.f fVar = this.f440232a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        az[] azVarArr = this.f440233b;
        int i3 = 0;
        if (azVarArr != null && azVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                az[] azVarArr2 = this.f440233b;
                if (i16 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i16];
                if (azVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, azVar);
                }
                i16++;
            }
        }
        if (!this.f440234c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440234c);
        }
        if (!this.f440235d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440235d);
        }
        az[] azVarArr3 = this.f440236e;
        if (azVarArr3 != null && azVarArr3.length > 0) {
            while (true) {
                az[] azVarArr4 = this.f440236e;
                if (i3 >= azVarArr4.length) {
                    break;
                }
                az azVar2 = azVarArr4[i3];
                if (azVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(5, azVar2);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public au a() {
        this.f440232a = null;
        this.f440233b = az.b();
        this.f440234c = "";
        this.f440235d = "";
        this.f440236e = az.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
