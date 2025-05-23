package tv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b[] f437556e;

    /* renamed from: a, reason: collision with root package name */
    public long f437557a;

    /* renamed from: b, reason: collision with root package name */
    public String f437558b;

    /* renamed from: c, reason: collision with root package name */
    public String f437559c;

    /* renamed from: d, reason: collision with root package name */
    public String f437560d;

    public b() {
        a();
    }

    public static b[] b() {
        if (f437556e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f437556e == null) {
                    f437556e = new b[0];
                }
            }
        }
        return f437556e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f437557a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f437558b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f437559c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437560d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f437557a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f437558b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f437558b);
        }
        if (!this.f437559c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f437559c);
        }
        return !this.f437560d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f437560d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f437557a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f437558b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f437558b);
        }
        if (!this.f437559c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f437559c);
        }
        if (!this.f437560d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f437560d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f437557a = 0L;
        this.f437558b = "";
        this.f437559c = "";
        this.f437560d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
