package sr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public c f434359a;

    /* renamed from: b, reason: collision with root package name */
    public h f434360b;

    /* renamed from: c, reason: collision with root package name */
    public pq4.c f434361c;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f434359a = null;
        this.f434360b = null;
        this.f434361c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            if (this.f434361c == null) {
                                this.f434361c = new pq4.c();
                            }
                            codedInputByteBufferNano.readMessage(this.f434361c);
                        }
                    } else {
                        if (this.f434360b == null) {
                            this.f434360b = new h();
                        }
                        codedInputByteBufferNano.readMessage(this.f434360b);
                    }
                } else {
                    if (this.f434359a == null) {
                        this.f434359a = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f434359a);
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
        c cVar = this.f434359a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        h hVar = this.f434360b;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        pq4.c cVar2 = this.f434361c;
        if (cVar2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, cVar2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c cVar = this.f434359a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        h hVar = this.f434360b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        pq4.c cVar2 = this.f434361c;
        if (cVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
