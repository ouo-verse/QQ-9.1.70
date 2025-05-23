package yr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f451099a;

    /* renamed from: b, reason: collision with root package name */
    public long f451100b;

    /* renamed from: c, reason: collision with root package name */
    public long f451101c;

    /* renamed from: d, reason: collision with root package name */
    public long f451102d;

    /* renamed from: e, reason: collision with root package name */
    public long f451103e;

    /* renamed from: f, reason: collision with root package name */
    public String f451104f;

    /* renamed from: g, reason: collision with root package name */
    public String f451105g;

    /* renamed from: h, reason: collision with root package name */
    public String f451106h;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f451099a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f451100b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f451101c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.f451102d = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.f451103e = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 50) {
                this.f451104f = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                this.f451105g = codedInputByteBufferNano.readString();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451106h = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f451099a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f451100b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f451101c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.f451102d;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j18);
        }
        long j19 = this.f451103e;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j19);
        }
        if (!this.f451104f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f451104f);
        }
        if (!this.f451105g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f451105g);
        }
        return !this.f451106h.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f451106h) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f451099a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f451100b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f451101c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.f451102d;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j18);
        }
        long j19 = this.f451103e;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j19);
        }
        if (!this.f451104f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f451104f);
        }
        if (!this.f451105g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f451105g);
        }
        if (!this.f451106h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f451106h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f451099a = 0L;
        this.f451100b = 0L;
        this.f451101c = 0L;
        this.f451102d = 0L;
        this.f451103e = 0L;
        this.f451104f = "";
        this.f451105g = "";
        this.f451106h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
