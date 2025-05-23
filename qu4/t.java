package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public b f429674a;

    /* renamed from: b, reason: collision with root package name */
    public j f429675b;

    /* renamed from: c, reason: collision with root package name */
    public j f429676c;

    /* renamed from: d, reason: collision with root package name */
    public m f429677d;

    /* renamed from: e, reason: collision with root package name */
    public c f429678e;

    /* renamed from: f, reason: collision with root package name */
    public int f429679f;

    public t() {
        a();
    }

    public static t c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (t) MessageNano.mergeFrom(new t(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f429674a == null) {
                    this.f429674a = new b();
                }
                codedInputByteBufferNano.readMessage(this.f429674a);
            } else if (readTag == 18) {
                if (this.f429675b == null) {
                    this.f429675b = new j();
                }
                codedInputByteBufferNano.readMessage(this.f429675b);
            } else if (readTag == 26) {
                if (this.f429676c == null) {
                    this.f429676c = new j();
                }
                codedInputByteBufferNano.readMessage(this.f429676c);
            } else if (readTag == 34) {
                if (this.f429677d == null) {
                    this.f429677d = new m();
                }
                codedInputByteBufferNano.readMessage(this.f429677d);
            } else if (readTag == 42) {
                if (this.f429678e == null) {
                    this.f429678e = new c();
                }
                codedInputByteBufferNano.readMessage(this.f429678e);
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f429679f = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b bVar = this.f429674a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        j jVar = this.f429675b;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, jVar);
        }
        j jVar2 = this.f429676c;
        if (jVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, jVar2);
        }
        m mVar = this.f429677d;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, mVar);
        }
        c cVar = this.f429678e;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cVar);
        }
        int i3 = this.f429679f;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f429674a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        j jVar = this.f429675b;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(2, jVar);
        }
        j jVar2 = this.f429676c;
        if (jVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, jVar2);
        }
        m mVar = this.f429677d;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(4, mVar);
        }
        c cVar = this.f429678e;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(5, cVar);
        }
        int i3 = this.f429679f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public t a() {
        this.f429674a = null;
        this.f429675b = null;
        this.f429676c = null;
        this.f429677d = null;
        this.f429678e = null;
        this.f429679f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
