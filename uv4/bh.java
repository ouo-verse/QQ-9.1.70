package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bh extends ExtendableMessageNano<bh> {

    /* renamed from: a, reason: collision with root package name */
    public String f440341a;

    /* renamed from: b, reason: collision with root package name */
    public String f440342b;

    /* renamed from: c, reason: collision with root package name */
    public String f440343c;

    public bh() {
        a();
    }

    public bh a() {
        this.f440341a = "";
        this.f440342b = "";
        this.f440343c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440341a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f440342b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440343c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440341a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440341a);
        }
        if (!this.f440342b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440342b);
        }
        return !this.f440343c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f440343c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440341a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440341a);
        }
        if (!this.f440342b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440342b);
        }
        if (!this.f440343c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440343c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
