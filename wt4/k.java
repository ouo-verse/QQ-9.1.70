package wt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public String f446518a;

    /* renamed from: b, reason: collision with root package name */
    public String f446519b;

    public k() {
        a();
    }

    public k a() {
        this.f446518a = "";
        this.f446519b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f446518a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f446519b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f446518a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f446518a);
        }
        return !this.f446519b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f446519b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f446518a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f446518a);
        }
        if (!this.f446519b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f446519b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
