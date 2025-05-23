package q55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f428429a;

    /* renamed from: b, reason: collision with root package name */
    public String f428430b;

    /* renamed from: c, reason: collision with root package name */
    public String f428431c;

    /* renamed from: d, reason: collision with root package name */
    public String f428432d;

    /* renamed from: e, reason: collision with root package name */
    public String f428433e;

    /* renamed from: f, reason: collision with root package name */
    public String f428434f;

    public b() {
        a();
    }

    public b a() {
        this.f428429a = "";
        this.f428430b = "";
        this.f428431c = "";
        this.f428432d = "";
        this.f428433e = "";
        this.f428434f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f428429a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f428430b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f428431c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f428432d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f428433e = codedInputByteBufferNano.readString();
            } else if (readTag != 802) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f428434f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f428429a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f428429a);
        }
        if (!this.f428430b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f428430b);
        }
        if (!this.f428431c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f428431c);
        }
        if (!this.f428432d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f428432d);
        }
        if (!this.f428433e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f428433e);
        }
        return !this.f428434f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(100, this.f428434f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f428429a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f428429a);
        }
        if (!this.f428430b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f428430b);
        }
        if (!this.f428431c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f428431c);
        }
        if (!this.f428432d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f428432d);
        }
        if (!this.f428433e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f428433e);
        }
        if (!this.f428434f.equals("")) {
            codedOutputByteBufferNano.writeString(100, this.f428434f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
