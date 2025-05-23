package zt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f453413a;

    /* renamed from: b, reason: collision with root package name */
    public String f453414b;

    /* renamed from: c, reason: collision with root package name */
    public String f453415c;

    public e() {
        a();
    }

    public e a() {
        this.f453413a = "";
        this.f453414b = "";
        this.f453415c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f453413a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f453414b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453415c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f453413a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f453413a);
        }
        if (!this.f453414b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f453414b);
        }
        return !this.f453415c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f453415c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f453413a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f453413a);
        }
        if (!this.f453414b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f453414b);
        }
        if (!this.f453415c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f453415c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
