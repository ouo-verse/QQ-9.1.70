package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile l[] f439928e;

    /* renamed from: a, reason: collision with root package name */
    public int f439929a;

    /* renamed from: b, reason: collision with root package name */
    public q f439930b;

    /* renamed from: c, reason: collision with root package name */
    public i f439931c;

    /* renamed from: d, reason: collision with root package name */
    public long f439932d;

    public l() {
        a();
    }

    public static l[] b() {
        if (f439928e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f439928e == null) {
                    f439928e = new l[0];
                }
            }
        }
        return f439928e;
    }

    public l a() {
        this.f439929a = 0;
        this.f439930b = null;
        this.f439931c = null;
        this.f439932d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f439932d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            if (this.f439931c == null) {
                                this.f439931c = new i();
                            }
                            codedInputByteBufferNano.readMessage(this.f439931c);
                        }
                    } else {
                        if (this.f439930b == null) {
                            this.f439930b = new q();
                        }
                        codedInputByteBufferNano.readMessage(this.f439930b);
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                        this.f439929a = readInt32;
                    }
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f439929a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        q qVar = this.f439930b;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, qVar);
        }
        i iVar = this.f439931c;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, iVar);
        }
        long j3 = this.f439932d;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f439929a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        q qVar = this.f439930b;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(2, qVar);
        }
        i iVar = this.f439931c;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(3, iVar);
        }
        long j3 = this.f439932d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
