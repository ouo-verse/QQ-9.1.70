package tv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f437561a;

    /* renamed from: b, reason: collision with root package name */
    public long f437562b;

    /* renamed from: c, reason: collision with root package name */
    public long f437563c;

    /* renamed from: d, reason: collision with root package name */
    public String f437564d;

    /* renamed from: e, reason: collision with root package name */
    public long f437565e;

    /* renamed from: f, reason: collision with root package name */
    public long f437566f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f437567g;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f437561a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f437562b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f437563c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                this.f437564d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f437565e = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.f437566f = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437567g = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f437561a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f437562b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f437563c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        if (!this.f437564d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f437564d);
        }
        long j18 = this.f437565e;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j18);
        }
        long j19 = this.f437566f;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j19);
        }
        boolean z16 = this.f437567g;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f437561a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f437562b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f437563c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        if (!this.f437564d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f437564d);
        }
        long j18 = this.f437565e;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j18);
        }
        long j19 = this.f437566f;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j19);
        }
        boolean z16 = this.f437567g;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f437561a = 0L;
        this.f437562b = 0L;
        this.f437563c = 0L;
        this.f437564d = "";
        this.f437565e = 0L;
        this.f437566f = 0L;
        this.f437567g = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
