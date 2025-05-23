package t45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public bv4.c f435399a;

    /* renamed from: b, reason: collision with root package name */
    public bv4.b f435400b;

    /* renamed from: c, reason: collision with root package name */
    public bv4.e f435401c;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f435399a == null) {
                    this.f435399a = new bv4.c();
                }
                codedInputByteBufferNano.readMessage(this.f435399a);
            } else if (readTag == 18) {
                if (this.f435400b == null) {
                    this.f435400b = new bv4.b();
                }
                codedInputByteBufferNano.readMessage(this.f435400b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f435401c == null) {
                    this.f435401c = new bv4.e();
                }
                codedInputByteBufferNano.readMessage(this.f435401c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bv4.c cVar = this.f435399a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        bv4.b bVar = this.f435400b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        bv4.e eVar = this.f435401c;
        return eVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, eVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bv4.c cVar = this.f435399a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        bv4.b bVar = this.f435400b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        bv4.e eVar = this.f435401c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f435399a = null;
        this.f435400b = null;
        this.f435401c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
