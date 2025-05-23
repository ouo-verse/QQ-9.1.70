package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile n[] f427635g;

    /* renamed from: a, reason: collision with root package name */
    public long f427636a;

    /* renamed from: b, reason: collision with root package name */
    public long f427637b;

    /* renamed from: c, reason: collision with root package name */
    public pu4.g f427638c;

    /* renamed from: d, reason: collision with root package name */
    public long f427639d;

    /* renamed from: e, reason: collision with root package name */
    public long f427640e;

    /* renamed from: f, reason: collision with root package name */
    public u f427641f;

    public n() {
        a();
    }

    public static n[] b() {
        if (f427635g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427635g == null) {
                    f427635g = new n[0];
                }
            }
        }
        return f427635g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427636a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f427637b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                if (this.f427638c == null) {
                    this.f427638c = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f427638c);
            } else if (readTag == 32) {
                this.f427639d = codedInputByteBufferNano.readInt64();
            } else if (readTag == 40) {
                this.f427640e = codedInputByteBufferNano.readInt64();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f427641f == null) {
                    this.f427641f = new u();
                }
                codedInputByteBufferNano.readMessage(this.f427641f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f427636a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f427637b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        pu4.g gVar = this.f427638c;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
        }
        long j17 = this.f427639d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j17);
        }
        long j18 = this.f427640e;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j18);
        }
        u uVar = this.f427641f;
        return uVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, uVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427636a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f427637b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        pu4.g gVar = this.f427638c;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(3, gVar);
        }
        long j17 = this.f427639d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j17);
        }
        long j18 = this.f427640e;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j18);
        }
        u uVar = this.f427641f;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(6, uVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f427636a = 0L;
        this.f427637b = 0L;
        this.f427638c = null;
        this.f427639d = 0L;
        this.f427640e = 0L;
        this.f427641f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
