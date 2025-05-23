package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public q f432283a;

    /* renamed from: b, reason: collision with root package name */
    public p f432284b;

    /* renamed from: c, reason: collision with root package name */
    public ab f432285c;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f432283a = null;
        this.f432284b = null;
        this.f432285c = null;
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
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            if (this.f432285c == null) {
                                this.f432285c = new ab();
                            }
                            codedInputByteBufferNano.readMessage(this.f432285c);
                        }
                    } else {
                        if (this.f432284b == null) {
                            this.f432284b = new p();
                        }
                        codedInputByteBufferNano.readMessage(this.f432284b);
                    }
                } else {
                    if (this.f432283a == null) {
                        this.f432283a = new q();
                    }
                    codedInputByteBufferNano.readMessage(this.f432283a);
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
        q qVar = this.f432283a;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, qVar);
        }
        p pVar = this.f432284b;
        if (pVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, pVar);
        }
        ab abVar = this.f432285c;
        if (abVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, abVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        q qVar = this.f432283a;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(1, qVar);
        }
        p pVar = this.f432284b;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(2, pVar);
        }
        ab abVar = this.f432285c;
        if (abVar != null) {
            codedOutputByteBufferNano.writeMessage(3, abVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
