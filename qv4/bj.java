package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bj extends ExtendableMessageNano<bj> {

    /* renamed from: a, reason: collision with root package name */
    public String f430069a;

    /* renamed from: b, reason: collision with root package name */
    public String f430070b;

    /* renamed from: c, reason: collision with root package name */
    public String f430071c;

    /* renamed from: d, reason: collision with root package name */
    public String f430072d;

    /* renamed from: e, reason: collision with root package name */
    public pu4.g f430073e;

    /* renamed from: f, reason: collision with root package name */
    public int f430074f;

    public bj() {
        a();
    }

    public bj a() {
        this.f430069a = "";
        this.f430070b = "";
        this.f430071c = "";
        this.f430072d = "";
        this.f430073e = null;
        this.f430074f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f430069a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f430070b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f430071c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f430072d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                if (this.f430073e == null) {
                    this.f430073e = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f430073e);
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f430074f = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f430069a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f430069a);
        }
        if (!this.f430070b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430070b);
        }
        if (!this.f430071c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430071c);
        }
        if (!this.f430072d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430072d);
        }
        pu4.g gVar = this.f430073e;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gVar);
        }
        int i3 = this.f430074f;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f430069a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f430069a);
        }
        if (!this.f430070b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430070b);
        }
        if (!this.f430071c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430071c);
        }
        if (!this.f430072d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430072d);
        }
        pu4.g gVar = this.f430073e;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(5, gVar);
        }
        int i3 = this.f430074f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
