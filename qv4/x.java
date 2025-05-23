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
public final class x extends ExtendableMessageNano<x> {

    /* renamed from: a, reason: collision with root package name */
    public ba[] f430208a;

    public x() {
        a();
    }

    public static x c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (x) MessageNano.mergeFrom(new x(), bArr);
    }

    public x a() {
        this.f430208a = ba.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public x mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                ba[] baVarArr = this.f430208a;
                int length = baVarArr == null ? 0 : baVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ba[] baVarArr2 = new ba[i3];
                if (length != 0) {
                    System.arraycopy(baVarArr, 0, baVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ba baVar = new ba();
                    baVarArr2[length] = baVar;
                    codedInputByteBufferNano.readMessage(baVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ba baVar2 = new ba();
                baVarArr2[length] = baVar2;
                codedInputByteBufferNano.readMessage(baVar2);
                this.f430208a = baVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ba[] baVarArr = this.f430208a;
        if (baVarArr != null && baVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ba[] baVarArr2 = this.f430208a;
                if (i3 >= baVarArr2.length) {
                    break;
                }
                ba baVar = baVarArr2[i3];
                if (baVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, baVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ba[] baVarArr = this.f430208a;
        if (baVarArr != null && baVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ba[] baVarArr2 = this.f430208a;
                if (i3 >= baVarArr2.length) {
                    break;
                }
                ba baVar = baVarArr2[i3];
                if (baVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, baVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
