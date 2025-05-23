package su4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile i[] f434791h;

    /* renamed from: a, reason: collision with root package name */
    public long f434792a;

    /* renamed from: b, reason: collision with root package name */
    public String f434793b;

    /* renamed from: c, reason: collision with root package name */
    public String f434794c;

    /* renamed from: d, reason: collision with root package name */
    public String f434795d;

    /* renamed from: e, reason: collision with root package name */
    public int f434796e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f434797f;

    /* renamed from: g, reason: collision with root package name */
    public int f434798g;

    public i() {
        a();
    }

    public static i[] b() {
        if (f434791h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f434791h == null) {
                    f434791h = new i[0];
                }
            }
        }
        return f434791h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f434792a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f434793b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f434794c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f434795d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f434796e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 48) {
                this.f434797f = codedInputByteBufferNano.readBool();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f434798g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f434792a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f434793b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434793b);
        }
        if (!this.f434794c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434794c);
        }
        if (!this.f434795d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f434795d);
        }
        int i3 = this.f434796e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        boolean z16 = this.f434797f;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        int i16 = this.f434798g;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f434792a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f434793b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434793b);
        }
        if (!this.f434794c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434794c);
        }
        if (!this.f434795d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f434795d);
        }
        int i3 = this.f434796e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        boolean z16 = this.f434797f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        int i16 = this.f434798g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f434792a = 0L;
        this.f434793b = "";
        this.f434794c = "";
        this.f434795d = "";
        this.f434796e = 0;
        this.f434797f = false;
        this.f434798g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
