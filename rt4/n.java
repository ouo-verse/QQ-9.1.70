package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public int f432432a;

    /* renamed from: b, reason: collision with root package name */
    public String f432433b;

    /* renamed from: c, reason: collision with root package name */
    public String f432434c;

    /* renamed from: d, reason: collision with root package name */
    public String f432435d;

    public n() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f432432a = readInt32;
                }
            } else if (readTag == 18) {
                this.f432433b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f432434c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f432435d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f432432a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f432433b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432433b);
        }
        if (!this.f432434c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432434c);
        }
        return !this.f432435d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f432435d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432432a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f432433b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432433b);
        }
        if (!this.f432434c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432434c);
        }
        if (!this.f432435d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432435d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f432432a = 0;
        this.f432433b = "";
        this.f432434c = "";
        this.f432435d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
