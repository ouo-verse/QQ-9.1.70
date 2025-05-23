package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public m[] f451520a;

    public q() {
        a();
    }

    public q a() {
        this.f451520a = m.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    m[] mVarArr = this.f451520a;
                    if (mVarArr == null) {
                        length = 0;
                    } else {
                        length = mVarArr.length;
                    }
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
                    this.f451520a = mVarArr2;
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
        m[] mVarArr = this.f451520a;
        if (mVarArr != null && mVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                m[] mVarArr2 = this.f451520a;
                if (i3 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i3];
                if (mVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, mVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        m[] mVarArr = this.f451520a;
        if (mVarArr != null && mVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                m[] mVarArr2 = this.f451520a;
                if (i3 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i3];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, mVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
