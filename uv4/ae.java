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
public final class ae extends ExtendableMessageNano<ae> {

    /* renamed from: a, reason: collision with root package name */
    public long f440117a;

    /* renamed from: b, reason: collision with root package name */
    public String f440118b;

    /* renamed from: c, reason: collision with root package name */
    public az[] f440119c;

    /* renamed from: d, reason: collision with root package name */
    public String f440120d;

    public ae() {
        a();
    }

    public static ae c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ae) MessageNano.mergeFrom(new ae(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ae mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440117a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f440118b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                az[] azVarArr = this.f440119c;
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
                this.f440119c = azVarArr2;
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440120d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f440117a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f440118b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440118b);
        }
        az[] azVarArr = this.f440119c;
        if (azVarArr != null && azVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                az[] azVarArr2 = this.f440119c;
                if (i3 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i3];
                if (azVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, azVar);
                }
                i3++;
            }
        }
        return !this.f440120d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f440120d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f440117a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f440118b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440118b);
        }
        az[] azVarArr = this.f440119c;
        if (azVarArr != null && azVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                az[] azVarArr2 = this.f440119c;
                if (i3 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i3];
                if (azVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, azVar);
                }
                i3++;
            }
        }
        if (!this.f440120d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440120d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ae a() {
        this.f440117a = 0L;
        this.f440118b = "";
        this.f440119c = az.b();
        this.f440120d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
