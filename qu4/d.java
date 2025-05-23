package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile d[] f429582e;

    /* renamed from: a, reason: collision with root package name */
    public int f429583a;

    /* renamed from: b, reason: collision with root package name */
    public int f429584b;

    /* renamed from: c, reason: collision with root package name */
    public p f429585c;

    /* renamed from: d, reason: collision with root package name */
    public l f429586d;

    public d() {
        a();
    }

    public static d[] b() {
        if (f429582e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429582e == null) {
                    f429582e = new d[0];
                }
            }
        }
        return f429582e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429583a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f429584b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.f429585c == null) {
                    this.f429585c = new p();
                }
                codedInputByteBufferNano.readMessage(this.f429585c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f429586d == null) {
                    this.f429586d = new l();
                }
                codedInputByteBufferNano.readMessage(this.f429586d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429583a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f429584b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        p pVar = this.f429585c;
        if (pVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, pVar);
        }
        l lVar = this.f429586d;
        return lVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, lVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429583a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f429584b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        p pVar = this.f429585c;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(3, pVar);
        }
        l lVar = this.f429586d;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(4, lVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f429583a = 0;
        this.f429584b = 0;
        this.f429585c = null;
        this.f429586d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
