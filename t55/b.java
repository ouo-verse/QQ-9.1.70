package t55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f435448a;

    /* renamed from: b, reason: collision with root package name */
    public long f435449b;

    /* renamed from: c, reason: collision with root package name */
    public long f435450c;

    /* renamed from: d, reason: collision with root package name */
    public String f435451d;

    /* renamed from: e, reason: collision with root package name */
    public int f435452e;

    /* renamed from: f, reason: collision with root package name */
    public a f435453f;

    /* renamed from: g, reason: collision with root package name */
    public String f435454g;

    public b() {
        a();
    }

    public b a() {
        this.f435448a = "";
        this.f435449b = 0L;
        this.f435450c = 0L;
        this.f435451d = "";
        this.f435452e = 0;
        this.f435453f = null;
        this.f435454g = "";
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
                this.f435448a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f435449b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f435450c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                this.f435451d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f435452e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 50) {
                if (this.f435453f == null) {
                    this.f435453f = new a();
                }
                codedInputByteBufferNano.readMessage(this.f435453f);
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f435454g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f435448a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f435448a);
        }
        long j3 = this.f435449b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f435450c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.f435451d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f435451d);
        }
        int i3 = this.f435452e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        a aVar = this.f435453f;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, aVar);
        }
        return !this.f435454g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f435454g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f435448a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f435448a);
        }
        long j3 = this.f435449b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f435450c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f435451d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f435451d);
        }
        int i3 = this.f435452e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        a aVar = this.f435453f;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(6, aVar);
        }
        if (!this.f435454g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f435454g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
