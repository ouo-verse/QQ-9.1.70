package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f432274a;

    /* renamed from: b, reason: collision with root package name */
    public String f432275b;

    /* renamed from: c, reason: collision with root package name */
    public String f432276c;

    /* renamed from: d, reason: collision with root package name */
    public String f432277d;

    public d() {
        a();
    }

    public d a() {
        this.f432274a = "";
        this.f432275b = "";
        this.f432276c = "";
        this.f432277d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f432277d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f432276c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432275b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432274a = codedInputByteBufferNano.readString();
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
        if (!this.f432274a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432274a);
        }
        if (!this.f432275b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432275b);
        }
        if (!this.f432276c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432276c);
        }
        if (!this.f432277d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f432277d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432274a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432274a);
        }
        if (!this.f432275b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432275b);
        }
        if (!this.f432276c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432276c);
        }
        if (!this.f432277d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432277d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
