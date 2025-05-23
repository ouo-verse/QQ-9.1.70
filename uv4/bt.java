package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bt extends ExtendableMessageNano<bt> {

    /* renamed from: a, reason: collision with root package name */
    public int f440391a;

    /* renamed from: b, reason: collision with root package name */
    public String f440392b;

    /* renamed from: c, reason: collision with root package name */
    public al f440393c;

    /* renamed from: d, reason: collision with root package name */
    public int f440394d;

    public bt() {
        a();
    }

    public static bt c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (bt) MessageNano.mergeFrom(new bt(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bt mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440391a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f440392b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                if (this.f440393c == null) {
                    this.f440393c = new al();
                }
                codedInputByteBufferNano.readMessage(this.f440393c);
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440394d = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440391a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f440392b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440392b);
        }
        al alVar = this.f440393c;
        if (alVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, alVar);
        }
        int i16 = this.f440394d;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440391a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440392b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440392b);
        }
        al alVar = this.f440393c;
        if (alVar != null) {
            codedOutputByteBufferNano.writeMessage(3, alVar);
        }
        int i16 = this.f440394d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bt a() {
        this.f440391a = 0;
        this.f440392b = "";
        this.f440393c = null;
        this.f440394d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
