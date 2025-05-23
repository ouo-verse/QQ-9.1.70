package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bf extends ExtendableMessageNano<bf> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.j[] f430056a;

    public bf() {
        a();
    }

    public static bf c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (bf) MessageNano.mergeFrom(new bf(), bArr);
    }

    public bf a() {
        this.f430056a = pv4.j.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                pv4.j[] jVarArr = this.f430056a;
                int length = jVarArr == null ? 0 : jVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                pv4.j[] jVarArr2 = new pv4.j[i3];
                if (length != 0) {
                    System.arraycopy(jVarArr, 0, jVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    pv4.j jVar = new pv4.j();
                    jVarArr2[length] = jVar;
                    codedInputByteBufferNano.readMessage(jVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pv4.j jVar2 = new pv4.j();
                jVarArr2[length] = jVar2;
                codedInputByteBufferNano.readMessage(jVar2);
                this.f430056a = jVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.j[] jVarArr = this.f430056a;
        if (jVarArr != null && jVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pv4.j[] jVarArr2 = this.f430056a;
                if (i3 >= jVarArr2.length) {
                    break;
                }
                pv4.j jVar = jVarArr2[i3];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.j[] jVarArr = this.f430056a;
        if (jVarArr != null && jVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pv4.j[] jVarArr2 = this.f430056a;
                if (i3 >= jVarArr2.length) {
                    break;
                }
                pv4.j jVar = jVarArr2[i3];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, jVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
