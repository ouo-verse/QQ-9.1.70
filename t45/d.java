package t45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f435402a;

    /* renamed from: b, reason: collision with root package name */
    public String f435403b;

    /* renamed from: c, reason: collision with root package name */
    public String f435404c;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f435402a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f435403b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f435404c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f435402a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f435403b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f435403b);
        }
        return !this.f435404c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f435404c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f435402a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f435403b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f435403b);
        }
        if (!this.f435404c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f435404c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f435402a = 0L;
        this.f435403b = "";
        this.f435404c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
