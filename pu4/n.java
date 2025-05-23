package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public j f427498a;

    /* renamed from: b, reason: collision with root package name */
    public l f427499b;

    /* renamed from: c, reason: collision with root package name */
    public s f427500c;

    /* renamed from: d, reason: collision with root package name */
    public q f427501d;

    /* renamed from: e, reason: collision with root package name */
    public i f427502e;

    public n() {
        a();
    }

    public static n c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (n) MessageNano.mergeFrom(new n(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f427498a == null) {
                    this.f427498a = new j();
                }
                codedInputByteBufferNano.readMessage(this.f427498a);
            } else if (readTag == 18) {
                if (this.f427499b == null) {
                    this.f427499b = new l();
                }
                codedInputByteBufferNano.readMessage(this.f427499b);
            } else if (readTag == 26) {
                if (this.f427500c == null) {
                    this.f427500c = new s();
                }
                codedInputByteBufferNano.readMessage(this.f427500c);
            } else if (readTag == 34) {
                if (this.f427501d == null) {
                    this.f427501d = new q();
                }
                codedInputByteBufferNano.readMessage(this.f427501d);
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f427502e == null) {
                    this.f427502e = new i();
                }
                codedInputByteBufferNano.readMessage(this.f427502e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        j jVar = this.f427498a;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
        }
        l lVar = this.f427499b;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, lVar);
        }
        s sVar = this.f427500c;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, sVar);
        }
        q qVar = this.f427501d;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, qVar);
        }
        i iVar = this.f427502e;
        return iVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, iVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        j jVar = this.f427498a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        l lVar = this.f427499b;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(2, lVar);
        }
        s sVar = this.f427500c;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(3, sVar);
        }
        q qVar = this.f427501d;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(4, qVar);
        }
        i iVar = this.f427502e;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(5, iVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f427498a = null;
        this.f427499b = null;
        this.f427500c = null;
        this.f427501d = null;
        this.f427502e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
