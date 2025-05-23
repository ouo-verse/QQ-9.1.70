package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile r[] f448641c;

    /* renamed from: a, reason: collision with root package name */
    public h f448642a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f448643b;

    public r() {
        a();
    }

    public static r[] b() {
        if (f448641c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448641c == null) {
                    f448641c = new r[0];
                }
            }
        }
        return f448641c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f448642a == null) {
                    this.f448642a = new h();
                }
                codedInputByteBufferNano.readMessage(this.f448642a);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448643b = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        h hVar = this.f448642a;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, hVar);
        }
        boolean z16 = this.f448643b;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        h hVar = this.f448642a;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(1, hVar);
        }
        boolean z16 = this.f448643b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public r a() {
        this.f448642a = null;
        this.f448643b = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
