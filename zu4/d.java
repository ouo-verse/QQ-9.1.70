package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile d[] f453430e;

    /* renamed from: a, reason: collision with root package name */
    public int f453431a;

    /* renamed from: b, reason: collision with root package name */
    public String f453432b;

    /* renamed from: c, reason: collision with root package name */
    public long f453433c;

    /* renamed from: d, reason: collision with root package name */
    public String f453434d;

    public d() {
        a();
    }

    public static d[] b() {
        if (f453430e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f453430e == null) {
                    f453430e = new d[0];
                }
            }
        }
        return f453430e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f453431a = readInt32;
                }
            } else if (readTag == 18) {
                this.f453432b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f453433c = codedInputByteBufferNano.readInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453434d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f453431a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f453432b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f453432b);
        }
        long j3 = this.f453433c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        return !this.f453434d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f453434d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f453431a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f453432b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f453432b);
        }
        long j3 = this.f453433c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        if (!this.f453434d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f453434d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f453431a = 0;
        this.f453432b = "";
        this.f453433c = 0L;
        this.f453434d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
