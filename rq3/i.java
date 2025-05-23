package rq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public long f431958a;

    /* renamed from: b, reason: collision with root package name */
    public String f431959b;

    /* renamed from: c, reason: collision with root package name */
    public String f431960c;

    /* renamed from: d, reason: collision with root package name */
    public String f431961d;

    /* renamed from: e, reason: collision with root package name */
    public String f431962e;

    public i() {
        a();
    }

    public i a() {
        this.f431958a = 0L;
        this.f431959b = "";
        this.f431960c = "";
        this.f431961d = "";
        this.f431962e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f431962e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f431961d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f431960c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f431959b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f431958a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f431958a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f431959b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f431959b);
        }
        if (!this.f431960c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f431960c);
        }
        if (!this.f431961d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f431961d);
        }
        if (!this.f431962e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f431962e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f431958a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f431959b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f431959b);
        }
        if (!this.f431960c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f431960c);
        }
        if (!this.f431961d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f431961d);
        }
        if (!this.f431962e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f431962e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
