package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public int f429629a;

    /* renamed from: b, reason: collision with root package name */
    public String f429630b;

    /* renamed from: c, reason: collision with root package name */
    public int f429631c;

    /* renamed from: d, reason: collision with root package name */
    public long f429632d;

    /* renamed from: e, reason: collision with root package name */
    public long f429633e;

    /* renamed from: f, reason: collision with root package name */
    public int f429634f;

    public o() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429629a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.f429630b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f429631c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f429632d = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.f429633e = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429634f = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429629a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f429630b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f429630b);
        }
        int i16 = this.f429631c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        long j3 = this.f429632d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        long j16 = this.f429633e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        int i17 = this.f429634f;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429629a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f429630b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f429630b);
        }
        int i16 = this.f429631c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        long j3 = this.f429632d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        long j16 = this.f429633e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        int i17 = this.f429634f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f429629a = 0;
        this.f429630b = "";
        this.f429631c = 0;
        this.f429632d = 0L;
        this.f429633e = 0L;
        this.f429634f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
