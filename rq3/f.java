package rq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f431949a;

    /* renamed from: b, reason: collision with root package name */
    public long f431950b;

    /* renamed from: c, reason: collision with root package name */
    public d f431951c;

    /* renamed from: d, reason: collision with root package name */
    public String f431952d;

    /* renamed from: e, reason: collision with root package name */
    public long f431953e;

    public f() {
        a();
    }

    public f a() {
        this.f431949a = 0L;
        this.f431950b = 0L;
        this.f431951c = null;
        this.f431952d = "";
        this.f431953e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f431953e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f431952d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            if (this.f431951c == null) {
                                this.f431951c = new d();
                            }
                            codedInputByteBufferNano.readMessage(this.f431951c);
                        }
                    } else {
                        this.f431950b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f431949a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f431949a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f431950b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        d dVar = this.f431951c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        if (!this.f431952d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f431952d);
        }
        long j17 = this.f431953e;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f431949a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f431950b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        d dVar = this.f431951c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        if (!this.f431952d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f431952d);
        }
        long j17 = this.f431953e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
