package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.d[] f453439a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f453440b;

    /* renamed from: c, reason: collision with root package name */
    public long f453441c;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    public h a() {
        this.f453439a = pv4.d.b();
        this.f453440b = false;
        this.f453441c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                pv4.d[] dVarArr = this.f453439a;
                int length = dVarArr == null ? 0 : dVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                pv4.d[] dVarArr2 = new pv4.d[i3];
                if (length != 0) {
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    pv4.d dVar = new pv4.d();
                    dVarArr2[length] = dVar;
                    codedInputByteBufferNano.readMessage(dVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pv4.d dVar2 = new pv4.d();
                dVarArr2[length] = dVar2;
                codedInputByteBufferNano.readMessage(dVar2);
                this.f453439a = dVarArr2;
            } else if (readTag == 16) {
                this.f453440b = codedInputByteBufferNano.readBool();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453441c = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.d[] dVarArr = this.f453439a;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pv4.d[] dVarArr2 = this.f453439a;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                pv4.d dVar = dVarArr2[i3];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f453440b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        long j3 = this.f453441c;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.d[] dVarArr = this.f453439a;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pv4.d[] dVarArr2 = this.f453439a;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                pv4.d dVar = dVarArr2[i3];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, dVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f453440b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        long j3 = this.f453441c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
