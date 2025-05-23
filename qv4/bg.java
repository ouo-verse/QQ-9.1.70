package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bg extends ExtendableMessageNano<bg> {

    /* renamed from: a, reason: collision with root package name */
    public String f430057a;

    /* renamed from: b, reason: collision with root package name */
    public int f430058b;

    /* renamed from: c, reason: collision with root package name */
    public nv4.m[] f430059c;

    public bg() {
        a();
    }

    public bg a() {
        this.f430057a = "";
        this.f430058b = 0;
        this.f430059c = nv4.m.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f430057a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f430058b = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                nv4.m[] mVarArr = this.f430059c;
                int length = mVarArr == null ? 0 : mVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                nv4.m[] mVarArr2 = new nv4.m[i3];
                if (length != 0) {
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    nv4.m mVar = new nv4.m();
                    mVarArr2[length] = mVar;
                    codedInputByteBufferNano.readMessage(mVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                nv4.m mVar2 = new nv4.m();
                mVarArr2[length] = mVar2;
                codedInputByteBufferNano.readMessage(mVar2);
                this.f430059c = mVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f430057a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f430057a);
        }
        int i3 = this.f430058b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        nv4.m[] mVarArr = this.f430059c;
        if (mVarArr != null && mVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                nv4.m[] mVarArr2 = this.f430059c;
                if (i16 >= mVarArr2.length) {
                    break;
                }
                nv4.m mVar = mVarArr2[i16];
                if (mVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, mVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f430057a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f430057a);
        }
        int i3 = this.f430058b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        nv4.m[] mVarArr = this.f430059c;
        if (mVarArr != null && mVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                nv4.m[] mVarArr2 = this.f430059c;
                if (i16 >= mVarArr2.length) {
                    break;
                }
                nv4.m mVar = mVarArr2[i16];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, mVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
