package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile m[] f427631d;

    /* renamed from: a, reason: collision with root package name */
    public String f427632a;

    /* renamed from: b, reason: collision with root package name */
    public String f427633b;

    /* renamed from: c, reason: collision with root package name */
    public String f427634c;

    public m() {
        a();
    }

    public static m[] b() {
        if (f427631d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427631d == null) {
                    f427631d = new m[0];
                }
            }
        }
        return f427631d;
    }

    public m a() {
        this.f427632a = "";
        this.f427633b = "";
        this.f427634c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f427632a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f427633b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427634c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f427632a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427632a);
        }
        if (!this.f427633b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427633b);
        }
        return !this.f427634c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f427634c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427632a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427632a);
        }
        if (!this.f427633b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427633b);
        }
        if (!this.f427634c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427634c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
