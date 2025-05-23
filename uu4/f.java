package uu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f440062a;

    /* renamed from: b, reason: collision with root package name */
    public String f440063b;

    /* renamed from: c, reason: collision with root package name */
    public String f440064c;

    public f() {
        a();
    }

    public f a() {
        this.f440062a = "";
        this.f440063b = "";
        this.f440064c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
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
                this.f440062a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f440063b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440064c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440062a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440062a);
        }
        if (!this.f440063b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440063b);
        }
        return !this.f440064c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f440064c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440062a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440062a);
        }
        if (!this.f440063b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440063b);
        }
        if (!this.f440064c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440064c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
