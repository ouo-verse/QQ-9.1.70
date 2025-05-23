package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f448564a;

    /* renamed from: b, reason: collision with root package name */
    public String f448565b;

    /* renamed from: c, reason: collision with root package name */
    public hs4.a f448566c;

    public c() {
        a();
    }

    public c a() {
        this.f448564a = "";
        this.f448565b = "";
        this.f448566c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
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
                this.f448564a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f448565b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448566c == null) {
                    this.f448566c = new hs4.a();
                }
                codedInputByteBufferNano.readMessage(this.f448566c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f448564a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f448564a);
        }
        if (!this.f448565b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448565b);
        }
        hs4.a aVar = this.f448566c;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f448564a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f448564a);
        }
        if (!this.f448565b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448565b);
        }
        hs4.a aVar = this.f448566c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
