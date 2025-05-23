package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile i[] f429600f;

    /* renamed from: a, reason: collision with root package name */
    public int f429601a;

    /* renamed from: b, reason: collision with root package name */
    public int f429602b;

    /* renamed from: c, reason: collision with root package name */
    public int f429603c;

    /* renamed from: d, reason: collision with root package name */
    public int f429604d;

    /* renamed from: e, reason: collision with root package name */
    public int f429605e;

    public i() {
        a();
    }

    public static i[] b() {
        if (f429600f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429600f == null) {
                    f429600f = new i[0];
                }
            }
        }
        return f429600f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429601a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f429602b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f429603c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 32) {
                this.f429604d = codedInputByteBufferNano.readInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429605e = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429601a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f429602b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f429603c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f429604d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        int i19 = this.f429605e;
        return i19 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i19) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429601a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f429602b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f429603c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f429604d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        int i19 = this.f429605e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f429601a = 0;
        this.f429602b = 0;
        this.f429603c = 0;
        this.f429604d = 0;
        this.f429605e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
