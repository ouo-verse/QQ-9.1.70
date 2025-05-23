package vy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile e[] f443684f;

    /* renamed from: a, reason: collision with root package name */
    public int f443685a;

    /* renamed from: b, reason: collision with root package name */
    public h f443686b;

    /* renamed from: c, reason: collision with root package name */
    public c f443687c;

    /* renamed from: d, reason: collision with root package name */
    public long f443688d;

    /* renamed from: e, reason: collision with root package name */
    public h f443689e;

    public e() {
        a();
    }

    public static e[] b() {
        if (f443684f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f443684f == null) {
                    f443684f = new e[0];
                }
            }
        }
        return f443684f;
    }

    public e a() {
        this.f443685a = 0;
        this.f443686b = null;
        this.f443687c = null;
        this.f443688d = 0L;
        this.f443689e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    if (this.f443689e == null) {
                                        this.f443689e = new h();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f443689e);
                                }
                            } else {
                                this.f443688d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            if (this.f443687c == null) {
                                this.f443687c = new c();
                            }
                            codedInputByteBufferNano.readMessage(this.f443687c);
                        }
                    } else {
                        if (this.f443686b == null) {
                            this.f443686b = new h();
                        }
                        codedInputByteBufferNano.readMessage(this.f443686b);
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                        this.f443685a = readInt32;
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
        int i3 = this.f443685a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        h hVar = this.f443686b;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        c cVar = this.f443687c;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
        }
        long j3 = this.f443688d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        h hVar2 = this.f443689e;
        if (hVar2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, hVar2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f443685a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        h hVar = this.f443686b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        c cVar = this.f443687c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        long j3 = this.f443688d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        h hVar2 = this.f443689e;
        if (hVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, hVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
