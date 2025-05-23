package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bl extends ExtendableMessageNano<bl> {

    /* renamed from: a, reason: collision with root package name */
    public qu4.n f440369a;

    /* renamed from: b, reason: collision with root package name */
    public String f440370b;

    /* renamed from: c, reason: collision with root package name */
    public int f440371c;

    public bl() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f440369a == null) {
                    this.f440369a = new qu4.n();
                }
                codedInputByteBufferNano.readMessage(this.f440369a);
            } else if (readTag == 18) {
                this.f440370b = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440371c = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        qu4.n nVar = this.f440369a;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, nVar);
        }
        if (!this.f440370b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440370b);
        }
        int i3 = this.f440371c;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        qu4.n nVar = this.f440369a;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(1, nVar);
        }
        if (!this.f440370b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440370b);
        }
        int i3 = this.f440371c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bl a() {
        this.f440369a = null;
        this.f440370b = "";
        this.f440371c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
