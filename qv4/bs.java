package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bs extends ExtendableMessageNano<bs> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile bs[] f430114c;

    /* renamed from: a, reason: collision with root package name */
    public int f430115a;

    /* renamed from: b, reason: collision with root package name */
    public String f430116b;

    public bs() {
        a();
    }

    public static bs[] b() {
        if (f430114c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430114c == null) {
                    f430114c = new bs[0];
                }
            }
        }
        return f430114c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bs mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f430115a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430116b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f430115a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return !this.f430116b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f430116b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f430115a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f430116b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430116b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bs a() {
        this.f430115a = 0;
        this.f430116b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
