package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile a[] f439884i;

    /* renamed from: a, reason: collision with root package name */
    public s f439885a;

    /* renamed from: b, reason: collision with root package name */
    public k f439886b;

    /* renamed from: c, reason: collision with root package name */
    public int f439887c;

    /* renamed from: d, reason: collision with root package name */
    public int f439888d;

    /* renamed from: e, reason: collision with root package name */
    public long f439889e;

    /* renamed from: f, reason: collision with root package name */
    public long f439890f;

    /* renamed from: g, reason: collision with root package name */
    public int f439891g;

    /* renamed from: h, reason: collision with root package name */
    public String f439892h;

    public a() {
        a();
    }

    public static a[] b() {
        if (f439884i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f439884i == null) {
                    f439884i = new a[0];
                }
            }
        }
        return f439884i;
    }

    public a a() {
        this.f439885a = null;
        this.f439886b = null;
        this.f439887c = 0;
        this.f439888d = 0;
        this.f439889e = 0L;
        this.f439890f = 0L;
        this.f439891g = 0;
        this.f439892h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (readTag != 66) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f439892h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f439891g = codedInputByteBufferNano.readInt32();
                                        }
                                    } else {
                                        this.f439890f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f439889e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f439888d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f439887c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        if (this.f439886b == null) {
                            this.f439886b = new k();
                        }
                        codedInputByteBufferNano.readMessage(this.f439886b);
                    }
                } else {
                    if (this.f439885a == null) {
                        this.f439885a = new s();
                    }
                    codedInputByteBufferNano.readMessage(this.f439885a);
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
        s sVar = this.f439885a;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sVar);
        }
        k kVar = this.f439886b;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        int i3 = this.f439887c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.f439888d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        long j3 = this.f439889e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        long j16 = this.f439890f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        int i17 = this.f439891g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        if (!this.f439892h.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f439892h);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        s sVar = this.f439885a;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(1, sVar);
        }
        k kVar = this.f439886b;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        int i3 = this.f439887c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.f439888d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        long j3 = this.f439889e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        long j16 = this.f439890f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        int i17 = this.f439891g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        if (!this.f439892h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f439892h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
