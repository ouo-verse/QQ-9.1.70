package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bs extends ExtendableMessageNano<bs> {

    /* renamed from: a, reason: collision with root package name */
    public int f440388a;

    /* renamed from: b, reason: collision with root package name */
    public String f440389b;

    /* renamed from: c, reason: collision with root package name */
    public qu4.a f440390c;

    public bs() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bs mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440388a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f440389b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f440390c == null) {
                    this.f440390c = new qu4.a();
                }
                codedInputByteBufferNano.readMessage(this.f440390c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440388a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f440389b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440389b);
        }
        qu4.a aVar = this.f440390c;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440388a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440389b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440389b);
        }
        qu4.a aVar = this.f440390c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bs a() {
        this.f440388a = 0;
        this.f440389b = "";
        this.f440390c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
