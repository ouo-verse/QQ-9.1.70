package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile g[] f448583d;

    /* renamed from: a, reason: collision with root package name */
    public long f448584a;

    /* renamed from: b, reason: collision with root package name */
    public int f448585b;

    /* renamed from: c, reason: collision with root package name */
    public hs4.c f448586c;

    public g() {
        a();
    }

    public static g[] b() {
        if (f448583d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448583d == null) {
                    f448583d = new g[0];
                }
            }
        }
        return f448583d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448584a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f448585b = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448586c == null) {
                    this.f448586c = new hs4.c();
                }
                codedInputByteBufferNano.readMessage(this.f448586c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f448584a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f448585b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        hs4.c cVar = this.f448586c;
        return cVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, cVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448584a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f448585b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        hs4.c cVar = this.f448586c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f448584a = 0L;
        this.f448585b = 0;
        this.f448586c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
