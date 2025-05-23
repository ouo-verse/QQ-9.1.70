package uu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f440056a;

    /* renamed from: b, reason: collision with root package name */
    public String f440057b;

    /* renamed from: c, reason: collision with root package name */
    public String f440058c;

    public a() {
        a();
    }

    public a a() {
        this.f440056a = "";
        this.f440057b = "";
        this.f440058c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440056a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f440057b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440058c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440056a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440056a);
        }
        if (!this.f440057b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440057b);
        }
        return !this.f440058c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f440058c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440056a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440056a);
        }
        if (!this.f440057b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440057b);
        }
        if (!this.f440058c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440058c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
