package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class al extends ExtendableMessageNano<al> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile al[] f429941e;

    /* renamed from: a, reason: collision with root package name */
    public String f429942a;

    /* renamed from: b, reason: collision with root package name */
    public String f429943b;

    /* renamed from: c, reason: collision with root package name */
    public am f429944c;

    /* renamed from: d, reason: collision with root package name */
    public String f429945d;

    public al() {
        a();
    }

    public static al[] b() {
        if (f429941e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429941e == null) {
                    f429941e = new al[0];
                }
            }
        }
        return f429941e;
    }

    public al a() {
        this.f429942a = "";
        this.f429943b = "";
        this.f429944c = null;
        this.f429945d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public al mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f429942a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f429943b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                if (this.f429944c == null) {
                    this.f429944c = new am();
                }
                codedInputByteBufferNano.readMessage(this.f429944c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429945d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f429942a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429942a);
        }
        if (!this.f429943b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f429943b);
        }
        am amVar = this.f429944c;
        if (amVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, amVar);
        }
        return !this.f429945d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f429945d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429942a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429942a);
        }
        if (!this.f429943b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f429943b);
        }
        am amVar = this.f429944c;
        if (amVar != null) {
            codedOutputByteBufferNano.writeMessage(3, amVar);
        }
        if (!this.f429945d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429945d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
