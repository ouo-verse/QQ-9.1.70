package zr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile e[] f453102e;

    /* renamed from: a, reason: collision with root package name */
    public d f453103a;

    /* renamed from: b, reason: collision with root package name */
    public g f453104b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f453105c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f453106d;

    public e() {
        a();
    }

    public static e[] b() {
        if (f453102e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f453102e == null) {
                    f453102e = new e[0];
                }
            }
        }
        return f453102e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f453103a == null) {
                    this.f453103a = new d();
                }
                codedInputByteBufferNano.readMessage(this.f453103a);
            } else if (readTag == 18) {
                if (this.f453104b == null) {
                    this.f453104b = new g();
                }
                codedInputByteBufferNano.readMessage(this.f453104b);
            } else if (readTag == 26) {
                this.f453105c = codedInputByteBufferNano.readBytes();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453106d = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        d dVar = this.f453103a;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
        }
        g gVar = this.f453104b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        if (!Arrays.equals(this.f453105c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f453105c);
        }
        boolean z16 = this.f453106d;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d dVar = this.f453103a;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(1, dVar);
        }
        g gVar = this.f453104b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        if (!Arrays.equals(this.f453105c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f453105c);
        }
        boolean z16 = this.f453106d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f453103a = null;
        this.f453104b = null;
        this.f453105c = WireFormatNano.EMPTY_BYTES;
        this.f453106d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
