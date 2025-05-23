package wr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f446135a;

    /* renamed from: b, reason: collision with root package name */
    public String f446136b;

    /* renamed from: c, reason: collision with root package name */
    public String f446137c;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f446135a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                this.f446136b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f446137c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f446135a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f446136b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f446136b);
        }
        return !this.f446137c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f446137c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f446135a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f446136b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f446136b);
        }
        if (!this.f446137c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f446137c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f446135a = false;
        this.f446136b = "";
        this.f446137c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
