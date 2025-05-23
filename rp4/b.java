package rp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f431862a;

    /* renamed from: b, reason: collision with root package name */
    public h f431863b;

    /* renamed from: c, reason: collision with root package name */
    public String f431864c;

    public b() {
        a();
    }

    public b a() {
        this.f431862a = "";
        this.f431863b = null;
        this.f431864c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f431864c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        if (this.f431863b == null) {
                            this.f431863b = new h();
                        }
                        codedInputByteBufferNano.readMessage(this.f431863b);
                    }
                } else {
                    this.f431862a = codedInputByteBufferNano.readString();
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
        if (!this.f431862a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f431862a);
        }
        h hVar = this.f431863b;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        if (!this.f431864c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f431864c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f431862a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f431862a);
        }
        h hVar = this.f431863b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        if (!this.f431864c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f431864c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
