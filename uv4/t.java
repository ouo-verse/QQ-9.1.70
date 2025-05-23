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
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public gv4.e[] f440442a;

    public t() {
        a();
    }

    public static t c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (t) MessageNano.mergeFrom(new t(), bArr);
    }

    public t a() {
        this.f440442a = gv4.e.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                gv4.e[] eVarArr = this.f440442a;
                int length = eVarArr == null ? 0 : eVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                gv4.e[] eVarArr2 = new gv4.e[i3];
                if (length != 0) {
                    System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    gv4.e eVar = new gv4.e();
                    eVarArr2[length] = eVar;
                    codedInputByteBufferNano.readMessage(eVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                gv4.e eVar2 = new gv4.e();
                eVarArr2[length] = eVar2;
                codedInputByteBufferNano.readMessage(eVar2);
                this.f440442a = eVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        gv4.e[] eVarArr = this.f440442a;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                gv4.e[] eVarArr2 = this.f440442a;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                gv4.e eVar = eVarArr2[i3];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        gv4.e[] eVarArr = this.f440442a;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                gv4.e[] eVarArr2 = this.f440442a;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                gv4.e eVar = eVarArr2[i3];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, eVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
