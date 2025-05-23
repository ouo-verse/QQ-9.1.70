package sv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f434853a;

    /* renamed from: b, reason: collision with root package name */
    public ou4.a f434854b;

    /* renamed from: c, reason: collision with root package name */
    public long f434855c;

    /* renamed from: d, reason: collision with root package name */
    public int f434856d;

    /* renamed from: e, reason: collision with root package name */
    public String f434857e;

    /* renamed from: f, reason: collision with root package name */
    public String f434858f;

    /* renamed from: g, reason: collision with root package name */
    public String f434859g;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f434853a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.f434854b == null) {
                    this.f434854b = new ou4.a();
                }
                codedInputByteBufferNano.readMessage(this.f434854b);
            } else if (readTag == 24) {
                this.f434855c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f434856d = readInt32;
                }
            } else if (readTag == 42) {
                this.f434857e = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                this.f434858f = codedInputByteBufferNano.readString();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f434859g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f434853a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        ou4.a aVar = this.f434854b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        long j3 = this.f434855c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        int i16 = this.f434856d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        if (!this.f434857e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f434857e);
        }
        if (!this.f434858f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f434858f);
        }
        return !this.f434859g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f434859g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f434853a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        ou4.a aVar = this.f434854b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        long j3 = this.f434855c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        int i16 = this.f434856d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        if (!this.f434857e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f434857e);
        }
        if (!this.f434858f.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f434858f);
        }
        if (!this.f434859g.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f434859g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f434853a = 0;
        this.f434854b = null;
        this.f434855c = 0L;
        this.f434856d = 0;
        this.f434857e = "";
        this.f434858f = "";
        this.f434859g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
