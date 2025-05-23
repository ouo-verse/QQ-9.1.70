package wt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public fs4.n f446508a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f446509b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f446510c;

    public f() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f446508a == null) {
                    this.f446508a = new fs4.n();
                }
                codedInputByteBufferNano.readMessage(this.f446508a);
            } else if (readTag == 18) {
                this.f446509b = codedInputByteBufferNano.readBytes();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f446510c = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        fs4.n nVar = this.f446508a;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, nVar);
        }
        if (!Arrays.equals(this.f446509b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f446509b);
        }
        boolean z16 = this.f446510c;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        fs4.n nVar = this.f446508a;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(1, nVar);
        }
        if (!Arrays.equals(this.f446509b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f446509b);
        }
        boolean z16 = this.f446510c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f446508a = null;
        this.f446509b = WireFormatNano.EMPTY_BYTES;
        this.f446510c = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
