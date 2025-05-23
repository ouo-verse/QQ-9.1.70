package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f427589a;

    /* renamed from: b, reason: collision with root package name */
    public long f427590b;

    /* renamed from: c, reason: collision with root package name */
    public String f427591c;

    /* renamed from: d, reason: collision with root package name */
    public int f427592d;

    /* renamed from: e, reason: collision with root package name */
    public String f427593e;

    /* renamed from: f, reason: collision with root package name */
    public String f427594f;

    /* renamed from: g, reason: collision with root package name */
    public String f427595g;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f427589a = "";
        this.f427590b = 0L;
        this.f427591c = "";
        this.f427592d = 0;
        this.f427593e = "";
        this.f427594f = "";
        this.f427595g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f427589a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f427590b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                this.f427591c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0) {
                    this.f427592d = readInt32;
                }
            } else if (readTag == 42) {
                this.f427593e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f427594f = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427595g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f427589a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427589a);
        }
        long j3 = this.f427590b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        if (!this.f427591c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427591c);
        }
        int i3 = this.f427592d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!this.f427593e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427593e);
        }
        if (!this.f427594f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427594f);
        }
        return !this.f427595g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f427595g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427589a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427589a);
        }
        long j3 = this.f427590b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        if (!this.f427591c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427591c);
        }
        int i3 = this.f427592d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!this.f427593e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427593e);
        }
        if (!this.f427594f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427594f);
        }
        if (!this.f427595g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427595g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
