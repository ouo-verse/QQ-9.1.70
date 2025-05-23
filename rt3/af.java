package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class af extends ExtendableMessageNano<af> {

    /* renamed from: a, reason: collision with root package name */
    public long f432244a;

    /* renamed from: b, reason: collision with root package name */
    public long f432245b;

    /* renamed from: c, reason: collision with root package name */
    public String f432246c;

    /* renamed from: d, reason: collision with root package name */
    public String f432247d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f432248e;

    /* renamed from: f, reason: collision with root package name */
    public long f432249f;

    /* renamed from: g, reason: collision with root package name */
    public long f432250g;

    public af() {
        a();
    }

    public af a() {
        this.f432244a = 0L;
        this.f432245b = 0L;
        this.f432246c = "";
        this.f432247d = "";
        this.f432248e = false;
        this.f432249f = 0L;
        this.f432250g = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public af mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f432250g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f432249f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f432248e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f432247d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f432246c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432245b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f432244a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f432244a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f432245b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f432246c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432246c);
        }
        if (!this.f432247d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f432247d);
        }
        boolean z16 = this.f432248e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        long j17 = this.f432249f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        long j18 = this.f432250g;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432244a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f432245b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f432246c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432246c);
        }
        if (!this.f432247d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432247d);
        }
        boolean z16 = this.f432248e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        long j17 = this.f432249f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        long j18 = this.f432250g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
