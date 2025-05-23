package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f429597a;

    /* renamed from: b, reason: collision with root package name */
    public String f429598b;

    /* renamed from: c, reason: collision with root package name */
    public String f429599c;

    public h() {
        a();
    }

    public h a() {
        this.f429597a = "";
        this.f429598b = "";
        this.f429599c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f429597a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f429598b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429599c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f429597a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429597a);
        }
        if (!this.f429598b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f429598b);
        }
        return !this.f429599c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f429599c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429597a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429597a);
        }
        if (!this.f429598b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f429598b);
        }
        if (!this.f429599c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429599c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
