package rs4;

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
    public bs4.f f432165a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f432166b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f432167c;

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
                if (this.f432165a == null) {
                    this.f432165a = new bs4.f();
                }
                codedInputByteBufferNano.readMessage(this.f432165a);
            } else if (readTag == 18) {
                this.f432166b = codedInputByteBufferNano.readBytes();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f432167c = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs4.f fVar = this.f432165a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        if (!Arrays.equals(this.f432166b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f432166b);
        }
        boolean z16 = this.f432167c;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs4.f fVar = this.f432165a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        if (!Arrays.equals(this.f432166b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f432166b);
        }
        boolean z16 = this.f432167c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f432165a = null;
        this.f432166b = WireFormatNano.EMPTY_BYTES;
        this.f432167c = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
