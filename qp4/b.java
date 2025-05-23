package qp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b[] f429202d;

    /* renamed from: a, reason: collision with root package name */
    public String f429203a;

    /* renamed from: b, reason: collision with root package name */
    public f f429204b;

    /* renamed from: c, reason: collision with root package name */
    public String f429205c;

    public b() {
        a();
    }

    public static b[] b() {
        if (f429202d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429202d == null) {
                    f429202d = new b[0];
                }
            }
        }
        return f429202d;
    }

    public b a() {
        this.f429203a = "";
        this.f429204b = null;
        this.f429205c = "";
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
                            this.f429205c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        if (this.f429204b == null) {
                            this.f429204b = new f();
                        }
                        codedInputByteBufferNano.readMessage(this.f429204b);
                    }
                } else {
                    this.f429203a = codedInputByteBufferNano.readString();
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
        if (!this.f429203a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429203a);
        }
        f fVar = this.f429204b;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, fVar);
        }
        if (!this.f429205c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f429205c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429203a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429203a);
        }
        f fVar = this.f429204b;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(2, fVar);
        }
        if (!this.f429205c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429205c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
