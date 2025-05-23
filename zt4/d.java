package zt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f453410a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f453411b;

    /* renamed from: c, reason: collision with root package name */
    public e f453412c;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f453410a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.f453411b = codedInputByteBufferNano.readBool();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f453412c == null) {
                    this.f453412c = new e();
                }
                codedInputByteBufferNano.readMessage(this.f453412c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f453410a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.f453411b;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z17);
        }
        e eVar = this.f453412c;
        return eVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, eVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f453410a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.f453411b;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        e eVar = this.f453412c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f453410a = false;
        this.f453411b = false;
        this.f453412c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
