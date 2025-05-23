package z45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f451890a;

    /* renamed from: b, reason: collision with root package name */
    public String f451891b;

    /* renamed from: c, reason: collision with root package name */
    public String f451892c;

    /* renamed from: d, reason: collision with root package name */
    public long f451893d;

    /* renamed from: e, reason: collision with root package name */
    public String f451894e;

    public a() {
        a();
    }

    public a a() {
        this.f451890a = 0;
        this.f451891b = "";
        this.f451892c = "";
        this.f451893d = 0L;
        this.f451894e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f451894e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f451893d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f451892c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451891b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f451890a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f451890a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f451891b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451891b);
        }
        if (!this.f451892c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451892c);
        }
        long j3 = this.f451893d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        if (!this.f451894e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f451894e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451890a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f451891b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451891b);
        }
        if (!this.f451892c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451892c);
        }
        long j3 = this.f451893d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        if (!this.f451894e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451894e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
