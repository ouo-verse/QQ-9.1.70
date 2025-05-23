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
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public az[] f440398a;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f440398a = az.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                az[] azVarArr = this.f440398a;
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
                this.f440398a = azVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        az[] azVarArr = this.f440398a;
        if (azVarArr != null && azVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                az[] azVarArr2 = this.f440398a;
                if (i3 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i3];
                if (azVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, azVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        az[] azVarArr = this.f440398a;
        if (azVarArr != null && azVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                az[] azVarArr2 = this.f440398a;
                if (i3 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i3];
                if (azVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, azVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
