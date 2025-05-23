package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f429577a;

    /* renamed from: b, reason: collision with root package name */
    public q[] f429578b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f429579c;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429577a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                q[] qVarArr = this.f429578b;
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
                this.f429578b = qVarArr2;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429579c = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429577a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        q[] qVarArr = this.f429578b;
        if (qVarArr != null && qVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                q[] qVarArr2 = this.f429578b;
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
        boolean z16 = this.f429579c;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429577a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        q[] qVarArr = this.f429578b;
        if (qVarArr != null && qVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                q[] qVarArr2 = this.f429578b;
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
        boolean z16 = this.f429579c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f429577a = 0;
        this.f429578b = q.b();
        this.f429579c = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
