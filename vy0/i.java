package vy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public long f443700a;

    /* renamed from: b, reason: collision with root package name */
    public String f443701b;

    /* renamed from: c, reason: collision with root package name */
    public String f443702c;

    /* renamed from: d, reason: collision with root package name */
    public String f443703d;

    /* renamed from: e, reason: collision with root package name */
    public String f443704e;

    public i() {
        a();
    }

    public i a() {
        this.f443700a = 0L;
        this.f443701b = "";
        this.f443702c = "";
        this.f443703d = "";
        this.f443704e = "";
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
                                    this.f443704e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f443703d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f443702c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f443701b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f443700a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f443700a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f443701b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f443701b);
        }
        if (!this.f443702c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f443702c);
        }
        if (!this.f443703d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f443703d);
        }
        if (!this.f443704e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f443704e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f443700a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f443701b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f443701b);
        }
        if (!this.f443702c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f443702c);
        }
        if (!this.f443703d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f443703d);
        }
        if (!this.f443704e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f443704e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
