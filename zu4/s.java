package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile s[] f453475e;

    /* renamed from: a, reason: collision with root package name */
    public String f453476a;

    /* renamed from: b, reason: collision with root package name */
    public long f453477b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f453478c;

    /* renamed from: d, reason: collision with root package name */
    public int f453479d;

    public s() {
        a();
    }

    public static s[] b() {
        if (f453475e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f453475e == null) {
                    f453475e = new s[0];
                }
            }
        }
        return f453475e;
    }

    public s a() {
        this.f453476a = "";
        this.f453477b = 0L;
        this.f453478c = false;
        this.f453479d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f453476a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f453477b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f453478c = codedInputByteBufferNano.readBool();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453479d = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f453476a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f453476a);
        }
        long j3 = this.f453477b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        boolean z16 = this.f453478c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        int i3 = this.f453479d;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f453476a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f453476a);
        }
        long j3 = this.f453477b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        boolean z16 = this.f453478c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        int i3 = this.f453479d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
