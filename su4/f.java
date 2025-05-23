package su4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile f[] f434785d;

    /* renamed from: a, reason: collision with root package name */
    public int f434786a;

    /* renamed from: b, reason: collision with root package name */
    public int f434787b;

    /* renamed from: c, reason: collision with root package name */
    public String f434788c;

    public f() {
        a();
    }

    public static f[] b() {
        if (f434785d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f434785d == null) {
                    f434785d = new f[0];
                }
            }
        }
        return f434785d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f434786a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f434787b = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f434788c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f434786a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f434787b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        return !this.f434788c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f434788c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f434786a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f434787b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f434788c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434788c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f434786a = 0;
        this.f434787b = 0;
        this.f434788c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
