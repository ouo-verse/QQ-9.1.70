package xu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f448713a;

    /* renamed from: b, reason: collision with root package name */
    public String f448714b;

    /* renamed from: c, reason: collision with root package name */
    public String f448715c;

    /* renamed from: d, reason: collision with root package name */
    public String f448716d;

    /* renamed from: e, reason: collision with root package name */
    public int f448717e;

    /* renamed from: f, reason: collision with root package name */
    public int f448718f;

    public b() {
        a();
    }

    public b a() {
        this.f448713a = "";
        this.f448714b = "";
        this.f448715c = "";
        this.f448716d = "";
        this.f448717e = 0;
        this.f448718f = 0;
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
                this.f448713a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f448714b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f448715c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f448716d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f448717e = codedInputByteBufferNano.readInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448718f = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f448713a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f448713a);
        }
        if (!this.f448714b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448714b);
        }
        if (!this.f448715c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448715c);
        }
        if (!this.f448716d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448716d);
        }
        int i3 = this.f448717e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        int i16 = this.f448718f;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f448713a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f448713a);
        }
        if (!this.f448714b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448714b);
        }
        if (!this.f448715c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448715c);
        }
        if (!this.f448716d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448716d);
        }
        int i3 = this.f448717e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        int i16 = this.f448718f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
