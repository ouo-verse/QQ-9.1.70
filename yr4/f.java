package yr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f451111a;

    /* renamed from: b, reason: collision with root package name */
    public String f451112b;

    /* renamed from: c, reason: collision with root package name */
    public long f451113c;

    /* renamed from: d, reason: collision with root package name */
    public String f451114d;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f451111a = "";
        this.f451112b = "";
        this.f451113c = 0L;
        this.f451114d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f451111a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f451112b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f451113c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451114d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f451111a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451111a);
        }
        if (!this.f451112b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451112b);
        }
        long j3 = this.f451113c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return !this.f451114d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f451114d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451111a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451111a);
        }
        if (!this.f451112b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451112b);
        }
        long j3 = this.f451113c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!this.f451114d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451114d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
