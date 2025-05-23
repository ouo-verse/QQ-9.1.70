package qr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b[] f429375d;

    /* renamed from: a, reason: collision with root package name */
    public f f429376a;

    /* renamed from: b, reason: collision with root package name */
    public g f429377b;

    /* renamed from: c, reason: collision with root package name */
    public String f429378c;

    public b() {
        a();
    }

    public static b[] b() {
        if (f429375d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429375d == null) {
                    f429375d = new b[0];
                }
            }
        }
        return f429375d;
    }

    public static b d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f429376a = null;
        this.f429377b = null;
        this.f429378c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
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
                            this.f429378c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        if (this.f429377b == null) {
                            this.f429377b = new g();
                        }
                        codedInputByteBufferNano.readMessage(this.f429377b);
                    }
                } else {
                    if (this.f429376a == null) {
                        this.f429376a = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f429376a);
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
        f fVar = this.f429376a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        g gVar = this.f429377b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        if (!this.f429378c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f429378c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f429376a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        g gVar = this.f429377b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        if (!this.f429378c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429378c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
