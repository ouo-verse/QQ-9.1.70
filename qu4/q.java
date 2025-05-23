package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile q[] f429638f;

    /* renamed from: a, reason: collision with root package name */
    public int f429639a;

    /* renamed from: b, reason: collision with root package name */
    public int f429640b;

    /* renamed from: c, reason: collision with root package name */
    public long f429641c;

    /* renamed from: d, reason: collision with root package name */
    public g f429642d;

    /* renamed from: e, reason: collision with root package name */
    public r f429643e;

    public q() {
        a();
    }

    public static q[] b() {
        if (f429638f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429638f == null) {
                    f429638f = new q[0];
                }
            }
        }
        return f429638f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429639a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f429640b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f429641c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                if (this.f429642d == null) {
                    this.f429642d = new g();
                }
                codedInputByteBufferNano.readMessage(this.f429642d);
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f429643e == null) {
                    this.f429643e = new r();
                }
                codedInputByteBufferNano.readMessage(this.f429643e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429639a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f429640b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        long j3 = this.f429641c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        g gVar = this.f429642d;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, gVar);
        }
        r rVar = this.f429643e;
        return rVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, rVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429639a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f429640b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        long j3 = this.f429641c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        g gVar = this.f429642d;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(4, gVar);
        }
        r rVar = this.f429643e;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(5, rVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public q a() {
        this.f429639a = 0;
        this.f429640b = 0;
        this.f429641c = 0L;
        this.f429642d = null;
        this.f429643e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
