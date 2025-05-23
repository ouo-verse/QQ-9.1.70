package st3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f434720a;

    /* renamed from: b, reason: collision with root package name */
    public String f434721b;

    /* renamed from: c, reason: collision with root package name */
    public d f434722c;

    /* renamed from: d, reason: collision with root package name */
    public e f434723d;

    public c() {
        a();
    }

    public c a() {
        this.f434720a = 0L;
        this.f434721b = "";
        this.f434722c = null;
        this.f434723d = null;
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
                                if (this.f434723d == null) {
                                    this.f434723d = new e();
                                }
                                codedInputByteBufferNano.readMessage(this.f434723d);
                            }
                        } else {
                            if (this.f434722c == null) {
                                this.f434722c = new d();
                            }
                            codedInputByteBufferNano.readMessage(this.f434722c);
                        }
                    } else {
                        this.f434721b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f434720a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f434720a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f434721b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434721b);
        }
        d dVar = this.f434722c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        e eVar = this.f434723d;
        if (eVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, eVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f434720a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f434721b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434721b);
        }
        d dVar = this.f434722c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        e eVar = this.f434723d;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(4, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
