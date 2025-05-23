package yu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c[] f451275c;

    /* renamed from: a, reason: collision with root package name */
    public String f451276a;

    /* renamed from: b, reason: collision with root package name */
    public String f451277b;

    public c() {
        a();
    }

    public static c[] b() {
        if (f451275c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451275c == null) {
                    f451275c = new c[0];
                }
            }
        }
        return f451275c;
    }

    public c a() {
        this.f451276a = "";
        this.f451277b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f451276a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451277b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f451276a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451276a);
        }
        return !this.f451277b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f451277b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451276a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451276a);
        }
        if (!this.f451277b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451277b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
