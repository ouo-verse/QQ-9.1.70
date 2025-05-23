package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ab extends ExtendableMessageNano<ab> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f448519a;

    /* renamed from: b, reason: collision with root package name */
    public int f448520b;

    /* renamed from: c, reason: collision with root package name */
    public hs4.k f448521c;

    public ab() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ab mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448519a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.f448520b = codedInputByteBufferNano.readInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448521c == null) {
                    this.f448521c = new hs4.k();
                }
                codedInputByteBufferNano.readMessage(this.f448521c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f448519a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f448520b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        hs4.k kVar = this.f448521c;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f448519a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f448520b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        hs4.k kVar = this.f448521c;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ab a() {
        this.f448519a = false;
        this.f448520b = 0;
        this.f448521c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
