package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public int f453480a;

    /* renamed from: b, reason: collision with root package name */
    public String f453481b;

    /* renamed from: c, reason: collision with root package name */
    public u f453482c;

    /* renamed from: d, reason: collision with root package name */
    public int f453483d;

    /* renamed from: e, reason: collision with root package name */
    public int f453484e;

    public t() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f453480a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f453481b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                if (this.f453482c == null) {
                    this.f453482c = new u();
                }
                codedInputByteBufferNano.readMessage(this.f453482c);
            } else if (readTag == 32) {
                this.f453483d = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453484e = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f453480a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f453481b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f453481b);
        }
        u uVar = this.f453482c;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, uVar);
        }
        int i16 = this.f453483d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f453484e;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f453480a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f453481b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f453481b);
        }
        u uVar = this.f453482c;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(3, uVar);
        }
        int i16 = this.f453483d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f453484e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public t a() {
        this.f453480a = 0;
        this.f453481b = "";
        this.f453482c = null;
        this.f453483d = 0;
        this.f453484e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
