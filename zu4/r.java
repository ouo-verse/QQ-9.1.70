package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile r[] f453472c;

    /* renamed from: a, reason: collision with root package name */
    public int f453473a;

    /* renamed from: b, reason: collision with root package name */
    public String f453474b;

    public r() {
        a();
    }

    public static r[] b() {
        if (f453472c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f453472c == null) {
                    f453472c = new r[0];
                }
            }
        }
        return f453472c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f453473a = codedInputByteBufferNano.readInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453474b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f453473a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        return !this.f453474b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f453474b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f453473a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f453474b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f453474b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f453473a = 0;
        this.f453474b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
