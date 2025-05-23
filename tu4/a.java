package tu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile a[] f437489f;

    /* renamed from: a, reason: collision with root package name */
    public int f437490a;

    /* renamed from: b, reason: collision with root package name */
    public String f437491b;

    /* renamed from: c, reason: collision with root package name */
    public int f437492c;

    /* renamed from: d, reason: collision with root package name */
    public String f437493d;

    /* renamed from: e, reason: collision with root package name */
    public long f437494e;

    public a() {
        a();
    }

    public static a[] b() {
        if (f437489f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f437489f == null) {
                    f437489f = new a[0];
                }
            }
        }
        return f437489f;
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
                this.f437490a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.f437491b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f437492c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f437493d = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437494e = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f437490a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f437491b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f437491b);
        }
        int i16 = this.f437492c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        if (!this.f437493d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f437493d);
        }
        long j3 = this.f437494e;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(5, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f437490a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f437491b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f437491b);
        }
        int i16 = this.f437492c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        if (!this.f437493d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f437493d);
        }
        long j3 = this.f437494e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f437490a = 0;
        this.f437491b = "";
        this.f437492c = 0;
        this.f437493d = "";
        this.f437494e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
