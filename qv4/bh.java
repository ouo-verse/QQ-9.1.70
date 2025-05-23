package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bh extends ExtendableMessageNano<bh> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile bh[] f430060f;

    /* renamed from: a, reason: collision with root package name */
    public long f430061a;

    /* renamed from: b, reason: collision with root package name */
    public String f430062b;

    /* renamed from: c, reason: collision with root package name */
    public String f430063c;

    /* renamed from: d, reason: collision with root package name */
    public String f430064d;

    /* renamed from: e, reason: collision with root package name */
    public long f430065e;

    public bh() {
        a();
    }

    public static bh[] b() {
        if (f430060f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430060f == null) {
                    f430060f = new bh[0];
                }
            }
        }
        return f430060f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f430061a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f430062b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f430063c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f430064d = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430065e = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f430061a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f430062b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430062b);
        }
        if (!this.f430063c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430063c);
        }
        if (!this.f430064d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430064d);
        }
        long j16 = this.f430065e;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f430061a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f430062b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430062b);
        }
        if (!this.f430063c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430063c);
        }
        if (!this.f430064d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430064d);
        }
        long j16 = this.f430065e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bh a() {
        this.f430061a = 0L;
        this.f430062b = "";
        this.f430063c = "";
        this.f430064d = "";
        this.f430065e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
