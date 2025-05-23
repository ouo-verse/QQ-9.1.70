package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bm extends ExtendableMessageNano<bm> {

    /* renamed from: a, reason: collision with root package name */
    public qu4.o f440372a;

    /* renamed from: b, reason: collision with root package name */
    public qu4.a f440373b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f440374c;

    public bm() {
        a();
    }

    public static bm c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (bm) MessageNano.mergeFrom(new bm(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f440372a == null) {
                    this.f440372a = new qu4.o();
                }
                codedInputByteBufferNano.readMessage(this.f440372a);
            } else if (readTag == 18) {
                if (this.f440373b == null) {
                    this.f440373b = new qu4.a();
                }
                codedInputByteBufferNano.readMessage(this.f440373b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440374c = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        qu4.o oVar = this.f440372a;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, oVar);
        }
        qu4.a aVar = this.f440373b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        return !Arrays.equals(this.f440374c, WireFormatNano.EMPTY_BYTES) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.f440374c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        qu4.o oVar = this.f440372a;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(1, oVar);
        }
        qu4.a aVar = this.f440373b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        if (!Arrays.equals(this.f440374c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f440374c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bm a() {
        this.f440372a = null;
        this.f440373b = null;
        this.f440374c = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
