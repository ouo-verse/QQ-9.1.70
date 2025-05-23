package zv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;
import uv4.az;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile c[] f453568d;

    /* renamed from: a, reason: collision with root package name */
    public int f453569a;

    /* renamed from: b, reason: collision with root package name */
    public az f453570b;

    /* renamed from: c, reason: collision with root package name */
    public int f453571c;

    public c() {
        a();
    }

    public static c[] b() {
        if (f453568d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f453568d == null) {
                    f453568d = new c[0];
                }
            }
        }
        return f453568d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f453569a = readInt32;
                }
            } else if (readTag == 18) {
                if (this.f453570b == null) {
                    this.f453570b = new az();
                }
                codedInputByteBufferNano.readMessage(this.f453570b);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453571c = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f453569a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        az azVar = this.f453570b;
        if (azVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, azVar);
        }
        int i16 = this.f453571c;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f453569a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        az azVar = this.f453570b;
        if (azVar != null) {
            codedOutputByteBufferNano.writeMessage(2, azVar);
        }
        int i16 = this.f453571c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f453569a = 0;
        this.f453570b = null;
        this.f453571c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
