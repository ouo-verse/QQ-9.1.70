package rp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c[] f431865c;

    /* renamed from: a, reason: collision with root package name */
    public String f431866a;

    /* renamed from: b, reason: collision with root package name */
    public String f431867b;

    public c() {
        a();
    }

    public static c[] b() {
        if (f431865c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f431865c == null) {
                    f431865c = new c[0];
                }
            }
        }
        return f431865c;
    }

    public c a() {
        this.f431866a = "";
        this.f431867b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f431867b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f431866a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f431866a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f431866a);
        }
        if (!this.f431867b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f431867b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f431866a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f431866a);
        }
        if (!this.f431867b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f431867b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
