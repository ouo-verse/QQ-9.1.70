package yt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f451206a;

    /* renamed from: b, reason: collision with root package name */
    public String f451207b;

    /* renamed from: c, reason: collision with root package name */
    public int f451208c;

    public h() {
        a();
    }

    public h a() {
        this.f451206a = "";
        this.f451207b = "";
        this.f451208c = 0;
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
                this.f451206a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f451207b = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451208c = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f451206a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451206a);
        }
        if (!this.f451207b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451207b);
        }
        int i3 = this.f451208c;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451206a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451206a);
        }
        if (!this.f451207b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451207b);
        }
        int i3 = this.f451208c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
