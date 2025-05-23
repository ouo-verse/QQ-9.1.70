package qr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile e[] f429394c;

    /* renamed from: a, reason: collision with root package name */
    public String f429395a;

    /* renamed from: b, reason: collision with root package name */
    public String f429396b;

    public e() {
        a();
    }

    public static e[] b() {
        if (f429394c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429394c == null) {
                    f429394c = new e[0];
                }
            }
        }
        return f429394c;
    }

    public e a() {
        this.f429395a = "";
        this.f429396b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f429396b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f429395a = codedInputByteBufferNano.readString();
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
        if (!this.f429395a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429395a);
        }
        if (!this.f429396b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f429396b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429395a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429395a);
        }
        if (!this.f429396b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f429396b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
