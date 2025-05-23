package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bi extends ExtendableMessageNano<bi> {

    /* renamed from: a, reason: collision with root package name */
    public String f430066a;

    /* renamed from: b, reason: collision with root package name */
    public pu4.g f430067b;

    /* renamed from: c, reason: collision with root package name */
    public int f430068c;

    public bi() {
        a();
    }

    public bi a() {
        this.f430066a = "";
        this.f430067b = null;
        this.f430068c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bi mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f430066a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f430067b == null) {
                    this.f430067b = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f430067b);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430068c = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f430066a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f430066a);
        }
        pu4.g gVar = this.f430067b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        int i3 = this.f430068c;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f430066a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f430066a);
        }
        pu4.g gVar = this.f430067b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        int i3 = this.f430068c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
