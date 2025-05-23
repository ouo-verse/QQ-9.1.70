package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile s[] f429668f;

    /* renamed from: a, reason: collision with root package name */
    public String f429669a;

    /* renamed from: b, reason: collision with root package name */
    public int f429670b;

    /* renamed from: c, reason: collision with root package name */
    public a f429671c;

    /* renamed from: d, reason: collision with root package name */
    public h f429672d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f429673e;

    public s() {
        a();
    }

    public static s[] b() {
        if (f429668f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429668f == null) {
                    f429668f = new s[0];
                }
            }
        }
        return f429668f;
    }

    public s a() {
        this.f429669a = "";
        this.f429670b = 0;
        this.f429671c = null;
        this.f429672d = null;
        this.f429673e = false;
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
                this.f429669a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f429670b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.f429671c == null) {
                    this.f429671c = new a();
                }
                codedInputByteBufferNano.readMessage(this.f429671c);
            } else if (readTag == 34) {
                if (this.f429672d == null) {
                    this.f429672d = new h();
                }
                codedInputByteBufferNano.readMessage(this.f429672d);
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429673e = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f429669a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429669a);
        }
        int i3 = this.f429670b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        a aVar = this.f429671c;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
        }
        h hVar = this.f429672d;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, hVar);
        }
        boolean z16 = this.f429673e;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429669a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429669a);
        }
        int i3 = this.f429670b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        a aVar = this.f429671c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        h hVar = this.f429672d;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(4, hVar);
        }
        boolean z16 = this.f429673e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
