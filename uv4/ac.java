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
public final class ac extends ExtendableMessageNano<ac> {

    /* renamed from: a, reason: collision with root package name */
    public bn[] f440112a;

    /* renamed from: b, reason: collision with root package name */
    public long f440113b;

    /* renamed from: c, reason: collision with root package name */
    public String f440114c;

    public ac() {
        a();
    }

    public static ac c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ac) MessageNano.mergeFrom(new ac(), bArr);
    }

    public ac a() {
        this.f440112a = bn.b();
        this.f440113b = 0L;
        this.f440114c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ac mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                bn[] bnVarArr = this.f440112a;
                int length = bnVarArr == null ? 0 : bnVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bn[] bnVarArr2 = new bn[i3];
                if (length != 0) {
                    System.arraycopy(bnVarArr, 0, bnVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bn bnVar = new bn();
                    bnVarArr2[length] = bnVar;
                    codedInputByteBufferNano.readMessage(bnVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bn bnVar2 = new bn();
                bnVarArr2[length] = bnVar2;
                codedInputByteBufferNano.readMessage(bnVar2);
                this.f440112a = bnVarArr2;
            } else if (readTag == 16) {
                this.f440113b = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440114c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bn[] bnVarArr = this.f440112a;
        if (bnVarArr != null && bnVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bn[] bnVarArr2 = this.f440112a;
                if (i3 >= bnVarArr2.length) {
                    break;
                }
                bn bnVar = bnVarArr2[i3];
                if (bnVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bnVar);
                }
                i3++;
            }
        }
        long j3 = this.f440113b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return !this.f440114c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f440114c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bn[] bnVarArr = this.f440112a;
        if (bnVarArr != null && bnVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bn[] bnVarArr2 = this.f440112a;
                if (i3 >= bnVarArr2.length) {
                    break;
                }
                bn bnVar = bnVarArr2[i3];
                if (bnVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bnVar);
                }
                i3++;
            }
        }
        long j3 = this.f440113b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.f440114c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440114c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
