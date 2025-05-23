package ws4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f446413a;

    /* renamed from: b, reason: collision with root package name */
    public String f446414b;

    /* renamed from: c, reason: collision with root package name */
    public String f446415c;

    /* renamed from: d, reason: collision with root package name */
    public String f446416d;

    /* renamed from: e, reason: collision with root package name */
    public String f446417e;

    public d() {
        a();
    }

    public d a() {
        this.f446413a = "";
        this.f446414b = "";
        this.f446415c = "";
        this.f446416d = "";
        this.f446417e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f446413a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f446414b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f446415c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f446416d = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f446417e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f446413a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f446413a);
        }
        if (!this.f446414b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f446414b);
        }
        if (!this.f446415c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f446415c);
        }
        if (!this.f446416d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f446416d);
        }
        return !this.f446417e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f446417e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f446413a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f446413a);
        }
        if (!this.f446414b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f446414b);
        }
        if (!this.f446415c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f446415c);
        }
        if (!this.f446416d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f446416d);
        }
        if (!this.f446417e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f446417e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
