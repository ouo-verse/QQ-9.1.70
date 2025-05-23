package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public long f451525a;

    /* renamed from: b, reason: collision with root package name */
    public long f451526b;

    /* renamed from: c, reason: collision with root package name */
    public String f451527c;

    /* renamed from: d, reason: collision with root package name */
    public String f451528d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f451529e;

    /* renamed from: f, reason: collision with root package name */
    public long f451530f;

    /* renamed from: g, reason: collision with root package name */
    public long f451531g;

    public s() {
        a();
    }

    public s a() {
        this.f451525a = 0L;
        this.f451526b = 0L;
        this.f451527c = "";
        this.f451528d = "";
        this.f451529e = false;
        this.f451530f = 0L;
        this.f451531g = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                            this.f451531g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f451530f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f451529e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f451528d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f451527c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451526b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f451525a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f451525a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f451526b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f451527c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451527c);
        }
        if (!this.f451528d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f451528d);
        }
        boolean z16 = this.f451529e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        long j17 = this.f451530f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        long j18 = this.f451531g;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f451525a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f451526b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f451527c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451527c);
        }
        if (!this.f451528d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451528d);
        }
        boolean z16 = this.f451529e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        long j17 = this.f451530f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        long j18 = this.f451531g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
