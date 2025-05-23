package py0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f428054a;

    /* renamed from: b, reason: collision with root package name */
    public long f428055b;

    /* renamed from: c, reason: collision with root package name */
    public long f428056c;

    /* renamed from: d, reason: collision with root package name */
    public long f428057d;

    /* renamed from: e, reason: collision with root package name */
    public long f428058e;

    /* renamed from: f, reason: collision with root package name */
    public long f428059f;

    /* renamed from: g, reason: collision with root package name */
    public long f428060g;

    /* renamed from: h, reason: collision with root package name */
    public long f428061h;

    public f() {
        a();
    }

    public f a() {
        this.f428054a = 0L;
        this.f428055b = 0L;
        this.f428056c = 0L;
        this.f428057d = 0L;
        this.f428058e = 0L;
        this.f428059f = 0L;
        this.f428060g = 0L;
        this.f428061h = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 40) {
                                if (readTag != 48) {
                                    if (readTag != 56) {
                                        if (readTag != 64) {
                                            if (readTag != 72) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f428061h = codedInputByteBufferNano.readUInt64();
                                            }
                                        } else {
                                            this.f428060g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f428059f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f428058e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f428057d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f428056c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f428055b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f428054a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f428054a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f428055b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f428056c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.f428057d;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j18);
        }
        long j19 = this.f428058e;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j19);
        }
        long j26 = this.f428059f;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j26);
        }
        long j27 = this.f428060g;
        if (j27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j27);
        }
        long j28 = this.f428061h;
        if (j28 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j28);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f428054a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f428055b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f428056c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.f428057d;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j18);
        }
        long j19 = this.f428058e;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j19);
        }
        long j26 = this.f428059f;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j26);
        }
        long j27 = this.f428060g;
        if (j27 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j27);
        }
        long j28 = this.f428061h;
        if (j28 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j28);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
