package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public int f429620a;

    /* renamed from: b, reason: collision with root package name */
    public q[] f429621b;

    public m() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429620a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                q[] qVarArr = this.f429621b;
                int length = qVarArr == null ? 0 : qVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                q[] qVarArr2 = new q[i3];
                if (length != 0) {
                    System.arraycopy(qVarArr, 0, qVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    q qVar = new q();
                    qVarArr2[length] = qVar;
                    codedInputByteBufferNano.readMessage(qVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                q qVar2 = new q();
                qVarArr2[length] = qVar2;
                codedInputByteBufferNano.readMessage(qVar2);
                this.f429621b = qVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429620a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        q[] qVarArr = this.f429621b;
        if (qVarArr != null && qVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                q[] qVarArr2 = this.f429621b;
                if (i16 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i16];
                if (qVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, qVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429620a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        q[] qVarArr = this.f429621b;
        if (qVarArr != null && qVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                q[] qVarArr2 = this.f429621b;
                if (i16 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i16];
                if (qVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, qVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f429620a = 0;
        this.f429621b = q.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
