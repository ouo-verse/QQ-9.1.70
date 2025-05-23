package rr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile h[] f432123c;

    /* renamed from: a, reason: collision with root package name */
    public String f432124a;

    /* renamed from: b, reason: collision with root package name */
    public String f432125b;

    public h() {
        a();
    }

    public static h[] b() {
        if (f432123c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432123c == null) {
                    f432123c = new h[0];
                }
            }
        }
        return f432123c;
    }

    public h a() {
        this.f432124a = "";
        this.f432125b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f432125b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432124a = codedInputByteBufferNano.readString();
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
        if (!this.f432124a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432124a);
        }
        if (!this.f432125b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f432125b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432124a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432124a);
        }
        if (!this.f432125b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432125b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
