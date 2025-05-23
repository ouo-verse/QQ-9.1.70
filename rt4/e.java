package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f432402a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f432403b;

    /* renamed from: c, reason: collision with root package name */
    public w f432404c;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f432402a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.f432403b = codedInputByteBufferNano.readBool();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f432404c == null) {
                    this.f432404c = new w();
                }
                codedInputByteBufferNano.readMessage(this.f432404c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f432402a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.f432403b;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z17);
        }
        w wVar = this.f432404c;
        return wVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, wVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f432402a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.f432403b;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        w wVar = this.f432404c;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(3, wVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f432402a = false;
        this.f432403b = false;
        this.f432404c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
