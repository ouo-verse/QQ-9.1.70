package tv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public long f437575a;

    /* renamed from: b, reason: collision with root package name */
    public long f437576b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f437577c;

    /* renamed from: d, reason: collision with root package name */
    public String f437578d;

    public e() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f437575a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f437576b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f437577c = codedInputByteBufferNano.readBool();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437578d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f437575a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f437576b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        boolean z16 = this.f437577c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        return !this.f437578d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f437578d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f437575a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f437576b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        boolean z16 = this.f437577c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!this.f437578d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f437578d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f437575a = 0L;
        this.f437576b = 0L;
        this.f437577c = false;
        this.f437578d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
