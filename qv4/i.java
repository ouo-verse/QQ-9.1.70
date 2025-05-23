package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public bs f430159a;

    /* renamed from: b, reason: collision with root package name */
    public String f430160b;

    /* renamed from: c, reason: collision with root package name */
    public String f430161c;

    /* renamed from: d, reason: collision with root package name */
    public String f430162d;

    /* renamed from: e, reason: collision with root package name */
    public String f430163e;

    /* renamed from: f, reason: collision with root package name */
    public long f430164f;

    /* renamed from: g, reason: collision with root package name */
    public int f430165g;

    /* renamed from: h, reason: collision with root package name */
    public String f430166h;

    public i() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430159a == null) {
                    this.f430159a = new bs();
                }
                codedInputByteBufferNano.readMessage(this.f430159a);
            } else if (readTag == 18) {
                this.f430160b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f430161c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f430162d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f430163e = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.f430164f = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 56) {
                this.f430165g = codedInputByteBufferNano.readInt32();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430166h = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs bsVar = this.f430159a;
        if (bsVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bsVar);
        }
        if (!this.f430160b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430160b);
        }
        if (!this.f430161c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430161c);
        }
        if (!this.f430162d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430162d);
        }
        if (!this.f430163e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f430163e);
        }
        long j3 = this.f430164f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        int i3 = this.f430165g;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i3);
        }
        return !this.f430166h.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f430166h) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs bsVar = this.f430159a;
        if (bsVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bsVar);
        }
        if (!this.f430160b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430160b);
        }
        if (!this.f430161c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430161c);
        }
        if (!this.f430162d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430162d);
        }
        if (!this.f430163e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f430163e);
        }
        long j3 = this.f430164f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        int i3 = this.f430165g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i3);
        }
        if (!this.f430166h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f430166h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f430159a = null;
        this.f430160b = "";
        this.f430161c = "";
        this.f430162d = "";
        this.f430163e = "";
        this.f430164f = 0L;
        this.f430165g = 0;
        this.f430166h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
