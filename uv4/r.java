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
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: a, reason: collision with root package name */
    public bk[] f440439a;

    public r() {
        a();
    }

    public static r c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (r) MessageNano.mergeFrom(new r(), bArr);
    }

    public r a() {
        this.f440439a = bk.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                bk[] bkVarArr = this.f440439a;
                int length = bkVarArr == null ? 0 : bkVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bk[] bkVarArr2 = new bk[i3];
                if (length != 0) {
                    System.arraycopy(bkVarArr, 0, bkVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bk bkVar = new bk();
                    bkVarArr2[length] = bkVar;
                    codedInputByteBufferNano.readMessage(bkVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bk bkVar2 = new bk();
                bkVarArr2[length] = bkVar2;
                codedInputByteBufferNano.readMessage(bkVar2);
                this.f440439a = bkVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bk[] bkVarArr = this.f440439a;
        if (bkVarArr != null && bkVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bk[] bkVarArr2 = this.f440439a;
                if (i3 >= bkVarArr2.length) {
                    break;
                }
                bk bkVar = bkVarArr2[i3];
                if (bkVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bkVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bk[] bkVarArr = this.f440439a;
        if (bkVarArr != null && bkVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bk[] bkVarArr2 = this.f440439a;
                if (i3 >= bkVarArr2.length) {
                    break;
                }
                bk bkVar = bkVarArr2[i3];
                if (bkVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bkVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
