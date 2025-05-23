package tv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile a[] f437549g;

    /* renamed from: a, reason: collision with root package name */
    public long f437550a;

    /* renamed from: b, reason: collision with root package name */
    public String f437551b;

    /* renamed from: c, reason: collision with root package name */
    public String f437552c;

    /* renamed from: d, reason: collision with root package name */
    public long f437553d;

    /* renamed from: e, reason: collision with root package name */
    public long f437554e;

    /* renamed from: f, reason: collision with root package name */
    public long f437555f;

    public a() {
        a();
    }

    public static a[] b() {
        if (f437549g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f437549g == null) {
                    f437549g = new a[0];
                }
            }
        }
        return f437549g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f437550a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f437551b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f437552c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f437553d = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.f437554e = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437555f = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f437550a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f437551b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f437551b);
        }
        if (!this.f437552c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f437552c);
        }
        long j16 = this.f437553d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        long j17 = this.f437554e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        long j18 = this.f437555f;
        return j18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f437550a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f437551b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f437551b);
        }
        if (!this.f437552c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f437552c);
        }
        long j16 = this.f437553d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        long j17 = this.f437554e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        long j18 = this.f437555f;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f437550a = 0L;
        this.f437551b = "";
        this.f437552c = "";
        this.f437553d = 0L;
        this.f437554e = 0L;
        this.f437555f = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
