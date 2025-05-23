package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class aa extends ExtendableMessageNano<aa> {

    /* renamed from: a, reason: collision with root package name */
    public long f432222a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f432223b;

    /* renamed from: c, reason: collision with root package name */
    public String f432224c;

    /* renamed from: d, reason: collision with root package name */
    public tq4.a f432225d;

    public aa() {
        a();
    }

    public static aa c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (aa) MessageNano.mergeFrom(new aa(), bArr);
    }

    public aa a() {
        this.f432222a = 0L;
        this.f432223b = false;
        this.f432224c = "";
        this.f432225d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f432225d == null) {
                                    this.f432225d = new tq4.a();
                                }
                                codedInputByteBufferNano.readMessage(this.f432225d);
                            }
                        } else {
                            this.f432224c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432223b = codedInputByteBufferNano.readBool();
                    }
                } else {
                    this.f432222a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f432222a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        boolean z16 = this.f432223b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        if (!this.f432224c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432224c);
        }
        tq4.a aVar = this.f432225d;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432222a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        boolean z16 = this.f432223b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        if (!this.f432224c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432224c);
        }
        tq4.a aVar = this.f432225d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
