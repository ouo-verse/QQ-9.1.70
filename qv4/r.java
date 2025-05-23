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
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: a, reason: collision with root package name */
    public ao f430194a;

    /* renamed from: b, reason: collision with root package name */
    public as[] f430195b;

    public r() {
        a();
    }

    public static r c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (r) MessageNano.mergeFrom(new r(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430194a == null) {
                    this.f430194a = new ao();
                }
                codedInputByteBufferNano.readMessage(this.f430194a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                as[] asVarArr = this.f430195b;
                int length = asVarArr == null ? 0 : asVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                as[] asVarArr2 = new as[i3];
                if (length != 0) {
                    System.arraycopy(asVarArr, 0, asVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    as asVar = new as();
                    asVarArr2[length] = asVar;
                    codedInputByteBufferNano.readMessage(asVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                as asVar2 = new as();
                asVarArr2[length] = asVar2;
                codedInputByteBufferNano.readMessage(asVar2);
                this.f430195b = asVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ao aoVar = this.f430194a;
        if (aoVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aoVar);
        }
        as[] asVarArr = this.f430195b;
        if (asVarArr != null && asVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                as[] asVarArr2 = this.f430195b;
                if (i3 >= asVarArr2.length) {
                    break;
                }
                as asVar = asVarArr2[i3];
                if (asVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, asVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ao aoVar = this.f430194a;
        if (aoVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aoVar);
        }
        as[] asVarArr = this.f430195b;
        if (asVarArr != null && asVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                as[] asVarArr2 = this.f430195b;
                if (i3 >= asVarArr2.length) {
                    break;
                }
                as asVar = asVarArr2[i3];
                if (asVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, asVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f430194a = null;
        this.f430195b = as.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
