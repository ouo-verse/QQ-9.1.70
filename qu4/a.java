package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public b f429572a;

    /* renamed from: b, reason: collision with root package name */
    public j f429573b;

    /* renamed from: c, reason: collision with root package name */
    public m f429574c;

    /* renamed from: d, reason: collision with root package name */
    public c f429575d;

    /* renamed from: e, reason: collision with root package name */
    public int f429576e;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f429572a == null) {
                    this.f429572a = new b();
                }
                codedInputByteBufferNano.readMessage(this.f429572a);
            } else if (readTag == 18) {
                if (this.f429573b == null) {
                    this.f429573b = new j();
                }
                codedInputByteBufferNano.readMessage(this.f429573b);
            } else if (readTag == 26) {
                if (this.f429574c == null) {
                    this.f429574c = new m();
                }
                codedInputByteBufferNano.readMessage(this.f429574c);
            } else if (readTag == 34) {
                if (this.f429575d == null) {
                    this.f429575d = new c();
                }
                codedInputByteBufferNano.readMessage(this.f429575d);
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f429576e = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b bVar = this.f429572a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        j jVar = this.f429573b;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, jVar);
        }
        m mVar = this.f429574c;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, mVar);
        }
        c cVar = this.f429575d;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
        }
        int i3 = this.f429576e;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f429572a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        j jVar = this.f429573b;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(2, jVar);
        }
        m mVar = this.f429574c;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(3, mVar);
        }
        c cVar = this.f429575d;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(4, cVar);
        }
        int i3 = this.f429576e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f429572a = null;
        this.f429573b = null;
        this.f429574c = null;
        this.f429575d = null;
        this.f429576e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
