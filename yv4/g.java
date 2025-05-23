package yv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public t55.c f451341a;

    /* renamed from: b, reason: collision with root package name */
    public b f451342b;

    /* renamed from: c, reason: collision with root package name */
    public String f451343c;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f451341a == null) {
                    this.f451341a = new t55.c();
                }
                codedInputByteBufferNano.readMessage(this.f451341a);
            } else if (readTag == 18) {
                if (this.f451342b == null) {
                    this.f451342b = new b();
                }
                codedInputByteBufferNano.readMessage(this.f451342b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451343c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        t55.c cVar = this.f451341a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        b bVar = this.f451342b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        return !this.f451343c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f451343c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        t55.c cVar = this.f451341a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        b bVar = this.f451342b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        if (!this.f451343c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451343c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f451341a = null;
        this.f451342b = null;
        this.f451343c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
