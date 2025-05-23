package z45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public y45.f[] f451918a;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    public j a() {
        this.f451918a = y45.f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    y45.f[] fVarArr = this.f451918a;
                    if (fVarArr == null) {
                        length = 0;
                    } else {
                        length = fVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    y45.f[] fVarArr2 = new y45.f[i3];
                    if (length != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        y45.f fVar = new y45.f();
                        fVarArr2[length] = fVar;
                        codedInputByteBufferNano.readMessage(fVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    y45.f fVar2 = new y45.f();
                    fVarArr2[length] = fVar2;
                    codedInputByteBufferNano.readMessage(fVar2);
                    this.f451918a = fVarArr2;
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        y45.f[] fVarArr = this.f451918a;
        if (fVarArr != null && fVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y45.f[] fVarArr2 = this.f451918a;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                y45.f fVar = fVarArr2[i3];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        y45.f[] fVarArr = this.f451918a;
        if (fVarArr != null && fVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y45.f[] fVarArr2 = this.f451918a;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                y45.f fVar = fVarArr2[i3];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, fVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
