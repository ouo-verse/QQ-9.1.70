package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public d f439938a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f439939b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f439940c;

    /* renamed from: d, reason: collision with root package name */
    public long f439941d;

    /* renamed from: e, reason: collision with root package name */
    public k f439942e;

    /* renamed from: f, reason: collision with root package name */
    public String f439943f;

    public n() {
        a();
    }

    public static n c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (n) MessageNano.mergeFrom(new n(), bArr);
    }

    public n a() {
        this.f439938a = null;
        this.f439939b = false;
        this.f439940c = false;
        this.f439941d = 0L;
        this.f439942e = null;
        this.f439943f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f439943f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    if (this.f439942e == null) {
                                        this.f439942e = new k();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f439942e);
                                }
                            } else {
                                this.f439941d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f439940c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        this.f439939b = codedInputByteBufferNano.readBool();
                    }
                } else {
                    if (this.f439938a == null) {
                        this.f439938a = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f439938a);
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
        d dVar = this.f439938a;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
        }
        boolean z16 = this.f439939b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        boolean z17 = this.f439940c;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z17);
        }
        long j3 = this.f439941d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        k kVar = this.f439942e;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, kVar);
        }
        if (!this.f439943f.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f439943f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d dVar = this.f439938a;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(1, dVar);
        }
        boolean z16 = this.f439939b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        boolean z17 = this.f439940c;
        if (z17) {
            codedOutputByteBufferNano.writeBool(3, z17);
        }
        long j3 = this.f439941d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        k kVar = this.f439942e;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(5, kVar);
        }
        if (!this.f439943f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f439943f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
