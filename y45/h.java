package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f449397a;

    /* renamed from: b, reason: collision with root package name */
    public String f449398b;

    /* renamed from: c, reason: collision with root package name */
    public String f449399c;

    /* renamed from: d, reason: collision with root package name */
    public String f449400d;

    /* renamed from: e, reason: collision with root package name */
    public String f449401e;

    public h() {
        a();
    }

    public h a() {
        this.f449397a = "";
        this.f449398b = "";
        this.f449399c = "";
        this.f449400d = "";
        this.f449401e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f449401e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f449400d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f449399c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f449398b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f449397a = codedInputByteBufferNano.readString();
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
        if (!this.f449397a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f449397a);
        }
        if (!this.f449398b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f449398b);
        }
        if (!this.f449399c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f449399c);
        }
        if (!this.f449400d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f449400d);
        }
        if (!this.f449401e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f449401e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f449397a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f449397a);
        }
        if (!this.f449398b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f449398b);
        }
        if (!this.f449399c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f449399c);
        }
        if (!this.f449400d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f449400d);
        }
        if (!this.f449401e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f449401e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
