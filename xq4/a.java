package xq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f448401a;

    /* renamed from: b, reason: collision with root package name */
    public long f448402b;

    /* renamed from: c, reason: collision with root package name */
    public String f448403c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f448404d;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f448401a = 0L;
        this.f448402b = 0L;
        this.f448403c = "";
        this.f448404d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f448404d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f448403c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f448402b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f448401a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f448401a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f448402b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f448403c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448403c);
        }
        boolean z16 = this.f448404d;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448401a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f448402b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f448403c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448403c);
        }
        boolean z16 = this.f448404d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
