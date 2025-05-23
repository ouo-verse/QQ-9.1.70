package u45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public int f438252a;

    /* renamed from: b, reason: collision with root package name */
    public m[] f438253b;

    /* renamed from: c, reason: collision with root package name */
    public String f438254c;

    public l() {
        a();
    }

    public static l c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (l) MessageNano.mergeFrom(new l(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f438252a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                m[] mVarArr = this.f438253b;
                int length = mVarArr == null ? 0 : mVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                m[] mVarArr2 = new m[i3];
                if (length != 0) {
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    m mVar = new m();
                    mVarArr2[length] = mVar;
                    codedInputByteBufferNano.readMessage(mVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                m mVar2 = new m();
                mVarArr2[length] = mVar2;
                codedInputByteBufferNano.readMessage(mVar2);
                this.f438253b = mVarArr2;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f438254c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f438252a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        m[] mVarArr = this.f438253b;
        if (mVarArr != null && mVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                m[] mVarArr2 = this.f438253b;
                if (i16 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i16];
                if (mVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, mVar);
                }
                i16++;
            }
        }
        return !this.f438254c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f438254c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f438252a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        m[] mVarArr = this.f438253b;
        if (mVarArr != null && mVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                m[] mVarArr2 = this.f438253b;
                if (i16 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i16];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, mVar);
                }
                i16++;
            }
        }
        if (!this.f438254c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f438254c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f438252a = 0;
        this.f438253b = m.b();
        this.f438254c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
