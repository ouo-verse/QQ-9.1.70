package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ad extends ExtendableMessageNano<ad> {

    /* renamed from: a, reason: collision with root package name */
    public y[] f432239a;

    public ad() {
        a();
    }

    public ad a() {
        this.f432239a = y.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ad mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    y[] yVarArr = this.f432239a;
                    if (yVarArr == null) {
                        length = 0;
                    } else {
                        length = yVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    y[] yVarArr2 = new y[i3];
                    if (length != 0) {
                        System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        y yVar = new y();
                        yVarArr2[length] = yVar;
                        codedInputByteBufferNano.readMessage(yVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    y yVar2 = new y();
                    yVarArr2[length] = yVar2;
                    codedInputByteBufferNano.readMessage(yVar2);
                    this.f432239a = yVarArr2;
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
        y[] yVarArr = this.f432239a;
        if (yVarArr != null && yVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y[] yVarArr2 = this.f432239a;
                if (i3 >= yVarArr2.length) {
                    break;
                }
                y yVar = yVarArr2[i3];
                if (yVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, yVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        y[] yVarArr = this.f432239a;
        if (yVarArr != null && yVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y[] yVarArr2 = this.f432239a;
                if (i3 >= yVarArr2.length) {
                    break;
                }
                y yVar = yVarArr2[i3];
                if (yVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, yVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
