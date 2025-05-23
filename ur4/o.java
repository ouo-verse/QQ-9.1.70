package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public m f439944a;

    /* renamed from: b, reason: collision with root package name */
    public int f439945b;

    /* renamed from: c, reason: collision with root package name */
    public long f439946c;

    /* renamed from: d, reason: collision with root package name */
    public String f439947d;

    public o() {
        a();
    }

    public o a() {
        this.f439944a = null;
        this.f439945b = 0;
        this.f439946c = 0L;
        this.f439947d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f439947d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f439946c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f439945b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    if (this.f439944a == null) {
                        this.f439944a = new m();
                    }
                    codedInputByteBufferNano.readMessage(this.f439944a);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        m mVar = this.f439944a;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, mVar);
        }
        int i3 = this.f439945b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j3 = this.f439946c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        if (!this.f439947d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f439947d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        m mVar = this.f439944a;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(1, mVar);
        }
        int i3 = this.f439945b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j3 = this.f439946c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!this.f439947d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f439947d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
