package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f429580a;

    /* renamed from: b, reason: collision with root package name */
    public d[] f429581b;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429580a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                d[] dVarArr = this.f429581b;
                int length = dVarArr == null ? 0 : dVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                d[] dVarArr2 = new d[i3];
                if (length != 0) {
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    d dVar = new d();
                    dVarArr2[length] = dVar;
                    codedInputByteBufferNano.readMessage(dVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                d dVar2 = new d();
                dVarArr2[length] = dVar2;
                codedInputByteBufferNano.readMessage(dVar2);
                this.f429581b = dVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429580a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        d[] dVarArr = this.f429581b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                d[] dVarArr2 = this.f429581b;
                if (i16 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i16];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429580a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        d[] dVarArr = this.f429581b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                d[] dVarArr2 = this.f429581b;
                if (i16 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i16];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, dVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f429580a = 0;
        this.f429581b = d.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
