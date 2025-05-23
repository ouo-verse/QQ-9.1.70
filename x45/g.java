package x45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile g[] f447205f;

    /* renamed from: a, reason: collision with root package name */
    public long f447206a;

    /* renamed from: b, reason: collision with root package name */
    public String f447207b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f447208c;

    /* renamed from: d, reason: collision with root package name */
    public int f447209d;

    /* renamed from: e, reason: collision with root package name */
    public long f447210e;

    public g() {
        a();
    }

    public static g[] b() {
        if (f447205f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f447205f == null) {
                    f447205f = new g[0];
                }
            }
        }
        return f447205f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f447206a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f447207b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f447208c = codedInputByteBufferNano.readBool();
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                    this.f447209d = readInt32;
                }
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f447210e = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f447206a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f447207b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f447207b);
        }
        boolean z16 = this.f447208c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        int i3 = this.f447209d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        long j16 = this.f447210e;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f447206a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f447207b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f447207b);
        }
        boolean z16 = this.f447208c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        int i3 = this.f447209d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        long j16 = this.f447210e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f447206a = 0L;
        this.f447207b = "";
        this.f447208c = false;
        this.f447209d = 0;
        this.f447210e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
