package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ar extends ExtendableMessageNano<ar> {

    /* renamed from: a, reason: collision with root package name */
    public v f429998a;

    /* renamed from: b, reason: collision with root package name */
    public int f429999b;

    public ar() {
        a();
    }

    public static ar c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ar) MessageNano.mergeFrom(new ar(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ar mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f429998a == null) {
                    this.f429998a = new v();
                }
                codedInputByteBufferNano.readMessage(this.f429998a);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429999b = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        v vVar = this.f429998a;
        if (vVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vVar);
        }
        int i3 = this.f429999b;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        v vVar = this.f429998a;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(1, vVar);
        }
        int i3 = this.f429999b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ar a() {
        this.f429998a = null;
        this.f429999b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
