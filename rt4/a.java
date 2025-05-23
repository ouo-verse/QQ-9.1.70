package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a[] f432387e;

    /* renamed from: a, reason: collision with root package name */
    public int f432388a;

    /* renamed from: b, reason: collision with root package name */
    public int f432389b;

    /* renamed from: c, reason: collision with root package name */
    public hs4.r f432390c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.s f432391d;

    public a() {
        a();
    }

    public static a[] b() {
        if (f432387e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432387e == null) {
                    f432387e = new a[0];
                }
            }
        }
        return f432387e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f432388a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f432389b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                if (this.f432390c == null) {
                    this.f432390c = new hs4.r();
                }
                codedInputByteBufferNano.readMessage(this.f432390c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f432391d == null) {
                    this.f432391d = new hs4.s();
                }
                codedInputByteBufferNano.readMessage(this.f432391d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f432388a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f432389b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        hs4.r rVar = this.f432390c;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, rVar);
        }
        hs4.s sVar = this.f432391d;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432388a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f432389b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        hs4.r rVar = this.f432390c;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(3, rVar);
        }
        hs4.s sVar = this.f432391d;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(4, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f432388a = 0;
        this.f432389b = 0;
        this.f432390c = null;
        this.f432391d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
