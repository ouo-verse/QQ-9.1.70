package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public long f439954a;

    /* renamed from: b, reason: collision with root package name */
    public String f439955b;

    /* renamed from: c, reason: collision with root package name */
    public String f439956c;

    /* renamed from: d, reason: collision with root package name */
    public String f439957d;

    /* renamed from: e, reason: collision with root package name */
    public String f439958e;

    public s() {
        a();
    }

    public s a() {
        this.f439954a = 0L;
        this.f439955b = "";
        this.f439956c = "";
        this.f439957d = "";
        this.f439958e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                    this.f439958e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f439957d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f439956c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f439955b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f439954a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f439954a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f439955b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f439955b);
        }
        if (!this.f439956c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f439956c);
        }
        if (!this.f439957d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f439957d);
        }
        if (!this.f439958e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f439958e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f439954a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f439955b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f439955b);
        }
        if (!this.f439956c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f439956c);
        }
        if (!this.f439957d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f439957d);
        }
        if (!this.f439958e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f439958e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
