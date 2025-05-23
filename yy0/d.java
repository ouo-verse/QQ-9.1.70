package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f451433a;

    /* renamed from: b, reason: collision with root package name */
    public String f451434b;

    /* renamed from: c, reason: collision with root package name */
    public String f451435c;

    /* renamed from: d, reason: collision with root package name */
    public String f451436d;

    public d() {
        a();
    }

    public d a() {
        this.f451433a = "";
        this.f451434b = "";
        this.f451435c = "";
        this.f451436d = "";
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
                                this.f451436d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f451435c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451434b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f451433a = codedInputByteBufferNano.readString();
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
        if (!this.f451433a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451433a);
        }
        if (!this.f451434b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451434b);
        }
        if (!this.f451435c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451435c);
        }
        if (!this.f451436d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f451436d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451433a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451433a);
        }
        if (!this.f451434b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451434b);
        }
        if (!this.f451435c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451435c);
        }
        if (!this.f451436d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451436d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
