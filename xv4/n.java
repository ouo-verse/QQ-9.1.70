package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public a f448812a;

    /* renamed from: b, reason: collision with root package name */
    public ab[] f448813b;

    public n() {
        a();
    }

    public static n c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (n) MessageNano.mergeFrom(new n(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f448812a == null) {
                    this.f448812a = new a();
                }
                codedInputByteBufferNano.readMessage(this.f448812a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                ab[] abVarArr = this.f448813b;
                int length = abVarArr == null ? 0 : abVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ab[] abVarArr2 = new ab[i3];
                if (length != 0) {
                    System.arraycopy(abVarArr, 0, abVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ab abVar = new ab();
                    abVarArr2[length] = abVar;
                    codedInputByteBufferNano.readMessage(abVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ab abVar2 = new ab();
                abVarArr2[length] = abVar2;
                codedInputByteBufferNano.readMessage(abVar2);
                this.f448813b = abVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        a aVar = this.f448812a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        ab[] abVarArr = this.f448813b;
        if (abVarArr != null && abVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448813b;
                if (i3 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i3];
                if (abVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, abVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a aVar = this.f448812a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        ab[] abVarArr = this.f448813b;
        if (abVarArr != null && abVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448813b;
                if (i3 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i3];
                if (abVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, abVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f448812a = null;
        this.f448813b = ab.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
