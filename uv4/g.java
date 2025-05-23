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
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f440419a;

    /* renamed from: b, reason: collision with root package name */
    public String f440420b;

    /* renamed from: c, reason: collision with root package name */
    public e[] f440421c;

    /* renamed from: d, reason: collision with root package name */
    public az[] f440422d;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440419a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f440420b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                e[] eVarArr = this.f440421c;
                int length = eVarArr == null ? 0 : eVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                e[] eVarArr2 = new e[i3];
                if (length != 0) {
                    System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    e eVar = new e();
                    eVarArr2[length] = eVar;
                    codedInputByteBufferNano.readMessage(eVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                e eVar2 = new e();
                eVarArr2[length] = eVar2;
                codedInputByteBufferNano.readMessage(eVar2);
                this.f440421c = eVarArr2;
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                az[] azVarArr = this.f440422d;
                int length2 = azVarArr == null ? 0 : azVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                az[] azVarArr2 = new az[i16];
                if (length2 != 0) {
                    System.arraycopy(azVarArr, 0, azVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    az azVar = new az();
                    azVarArr2[length2] = azVar;
                    codedInputByteBufferNano.readMessage(azVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                az azVar2 = new az();
                azVarArr2[length2] = azVar2;
                codedInputByteBufferNano.readMessage(azVar2);
                this.f440422d = azVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440419a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f440420b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440420b);
        }
        e[] eVarArr = this.f440421c;
        int i16 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                e[] eVarArr2 = this.f440421c;
                if (i17 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i17];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
                }
                i17++;
            }
        }
        az[] azVarArr = this.f440422d;
        if (azVarArr != null && azVarArr.length > 0) {
            while (true) {
                az[] azVarArr2 = this.f440422d;
                if (i16 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i16];
                if (azVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, azVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440419a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440420b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440420b);
        }
        e[] eVarArr = this.f440421c;
        int i16 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                e[] eVarArr2 = this.f440421c;
                if (i17 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i17];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, eVar);
                }
                i17++;
            }
        }
        az[] azVarArr = this.f440422d;
        if (azVarArr != null && azVarArr.length > 0) {
            while (true) {
                az[] azVarArr2 = this.f440422d;
                if (i16 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i16];
                if (azVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, azVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f440419a = 0;
        this.f440420b = "";
        this.f440421c = e.b();
        this.f440422d = az.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
