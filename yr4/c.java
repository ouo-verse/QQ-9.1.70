package yr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;
import zr4.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public g f451096a;

    /* renamed from: b, reason: collision with root package name */
    public g f451097b;

    /* renamed from: c, reason: collision with root package name */
    public String f451098c;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f451096a == null) {
                    this.f451096a = new g();
                }
                codedInputByteBufferNano.readMessage(this.f451096a);
            } else if (readTag == 18) {
                if (this.f451097b == null) {
                    this.f451097b = new g();
                }
                codedInputByteBufferNano.readMessage(this.f451097b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451098c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        g gVar = this.f451096a;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
        }
        g gVar2 = this.f451097b;
        if (gVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar2);
        }
        return !this.f451098c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f451098c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        g gVar = this.f451096a;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(1, gVar);
        }
        g gVar2 = this.f451097b;
        if (gVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar2);
        }
        if (!this.f451098c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451098c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f451096a = null;
        this.f451097b = null;
        this.f451098c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
