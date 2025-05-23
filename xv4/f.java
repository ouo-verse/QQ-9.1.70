package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile f[] f448794c;

    /* renamed from: a, reason: collision with root package name */
    public int f448795a;

    /* renamed from: b, reason: collision with root package name */
    public String f448796b;

    public f() {
        a();
    }

    public static f[] b() {
        if (f448794c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448794c == null) {
                    f448794c = new f[0];
                }
            }
        }
        return f448794c;
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
                this.f448795a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448796b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f448795a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return !this.f448796b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f448796b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448795a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f448796b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448796b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f448795a = 0;
        this.f448796b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
