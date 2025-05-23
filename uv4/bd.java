package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bd extends ExtendableMessageNano<bd> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile bd[] f440319e;

    /* renamed from: a, reason: collision with root package name */
    public long f440320a;

    /* renamed from: b, reason: collision with root package name */
    public int f440321b;

    /* renamed from: c, reason: collision with root package name */
    public long f440322c;

    /* renamed from: d, reason: collision with root package name */
    public String f440323d;

    public bd() {
        a();
    }

    public static bd[] b() {
        if (f440319e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440319e == null) {
                    f440319e = new bd[0];
                }
            }
        }
        return f440319e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440320a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f440321b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f440322c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440323d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f440320a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f440321b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.f440322c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        return !this.f440323d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f440323d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f440320a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f440321b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.f440322c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f440323d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440323d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bd a() {
        this.f440320a = 0L;
        this.f440321b = 0;
        this.f440322c = 0L;
        this.f440323d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
