package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ai extends ExtendableMessageNano<ai> {

    /* renamed from: a, reason: collision with root package name */
    public bs f429925a;

    /* renamed from: b, reason: collision with root package name */
    public int f429926b;

    /* renamed from: c, reason: collision with root package name */
    public String f429927c;

    public ai() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ai mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f429925a == null) {
                    this.f429925a = new bs();
                }
                codedInputByteBufferNano.readMessage(this.f429925a);
            } else if (readTag == 16) {
                this.f429926b = codedInputByteBufferNano.readInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429927c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs bsVar = this.f429925a;
        if (bsVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bsVar);
        }
        int i3 = this.f429926b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        return !this.f429927c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f429927c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs bsVar = this.f429925a;
        if (bsVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bsVar);
        }
        int i3 = this.f429926b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f429927c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429927c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ai a() {
        this.f429925a = null;
        this.f429926b = 0;
        this.f429927c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
