package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class af extends ExtendableMessageNano<af> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile af[] f448533c;

    /* renamed from: a, reason: collision with root package name */
    public long f448534a;

    /* renamed from: b, reason: collision with root package name */
    public String f448535b;

    public af() {
        a();
    }

    public static af[] b() {
        if (f448533c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448533c == null) {
                    f448533c = new af[0];
                }
            }
        }
        return f448533c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public af mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448534a = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448535b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f448534a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        return !this.f448535b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f448535b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448534a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f448535b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448535b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public af a() {
        this.f448534a = 0L;
        this.f448535b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
