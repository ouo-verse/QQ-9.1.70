package zy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f453701a;

    /* renamed from: b, reason: collision with root package name */
    public String f453702b;

    /* renamed from: c, reason: collision with root package name */
    public d f453703c;

    /* renamed from: d, reason: collision with root package name */
    public e f453704d;

    public c() {
        a();
    }

    public c a() {
        this.f453701a = 0L;
        this.f453702b = "";
        this.f453703c = null;
        this.f453704d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f453704d == null) {
                                    this.f453704d = new e();
                                }
                                codedInputByteBufferNano.readMessage(this.f453704d);
                            }
                        } else {
                            if (this.f453703c == null) {
                                this.f453703c = new d();
                            }
                            codedInputByteBufferNano.readMessage(this.f453703c);
                        }
                    } else {
                        this.f453702b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f453701a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f453701a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f453702b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f453702b);
        }
        d dVar = this.f453703c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        e eVar = this.f453704d;
        if (eVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, eVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f453701a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f453702b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f453702b);
        }
        d dVar = this.f453703c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        e eVar = this.f453704d;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(4, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
