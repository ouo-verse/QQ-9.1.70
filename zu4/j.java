package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.h[] f453444a;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    public j a() {
        this.f453444a = pv4.h.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                pv4.h[] hVarArr = this.f453444a;
                int length = hVarArr == null ? 0 : hVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                pv4.h[] hVarArr2 = new pv4.h[i3];
                if (length != 0) {
                    System.arraycopy(hVarArr, 0, hVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    pv4.h hVar = new pv4.h();
                    hVarArr2[length] = hVar;
                    codedInputByteBufferNano.readMessage(hVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pv4.h hVar2 = new pv4.h();
                hVarArr2[length] = hVar2;
                codedInputByteBufferNano.readMessage(hVar2);
                this.f453444a = hVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.h[] hVarArr = this.f453444a;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pv4.h[] hVarArr2 = this.f453444a;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                pv4.h hVar = hVarArr2[i3];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, hVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.h[] hVarArr = this.f453444a;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pv4.h[] hVarArr2 = this.f453444a;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                pv4.h hVar = hVarArr2[i3];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, hVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
