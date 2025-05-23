package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class an extends ExtendableMessageNano<an> {

    /* renamed from: b, reason: collision with root package name */
    private static volatile an[] f429947b;

    /* renamed from: a, reason: collision with root package name */
    public String f429948a;

    public an() {
        a();
    }

    public static an[] b() {
        if (f429947b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429947b == null) {
                    f429947b = new an[0];
                }
            }
        }
        return f429947b;
    }

    public an a() {
        this.f429948a = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public an mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429948a = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f429948a.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.f429948a) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429948a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429948a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
