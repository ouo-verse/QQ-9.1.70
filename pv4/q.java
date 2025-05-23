package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public pu4.g f427653a;

    /* renamed from: b, reason: collision with root package name */
    public String f427654b;

    /* renamed from: c, reason: collision with root package name */
    public u f427655c;

    public q() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f427653a == null) {
                    this.f427653a = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f427653a);
            } else if (readTag == 18) {
                this.f427654b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f427655c == null) {
                    this.f427655c = new u();
                }
                codedInputByteBufferNano.readMessage(this.f427655c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pu4.g gVar = this.f427653a;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
        }
        if (!this.f427654b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427654b);
        }
        u uVar = this.f427655c;
        return uVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, uVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pu4.g gVar = this.f427653a;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(1, gVar);
        }
        if (!this.f427654b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427654b);
        }
        u uVar = this.f427655c;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(3, uVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public q a() {
        this.f427653a = null;
        this.f427654b = "";
        this.f427655c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
