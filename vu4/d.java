package vu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d[] f443567c;

    /* renamed from: a, reason: collision with root package name */
    public String f443568a;

    /* renamed from: b, reason: collision with root package name */
    public String f443569b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f443567c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f443567c == null) {
                    f443567c = new d[0];
                }
            }
        }
        return f443567c;
    }

    public d a() {
        this.f443568a = "";
        this.f443569b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f443568a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f443569b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f443568a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f443568a);
        }
        return !this.f443569b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f443569b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f443568a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f443568a);
        }
        if (!this.f443569b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f443569b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
