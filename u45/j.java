package u45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f438240a;

    /* renamed from: b, reason: collision with root package name */
    public String f438241b;

    /* renamed from: c, reason: collision with root package name */
    public String f438242c;

    /* renamed from: d, reason: collision with root package name */
    public String f438243d;

    /* renamed from: e, reason: collision with root package name */
    public String f438244e;

    /* renamed from: f, reason: collision with root package name */
    public String f438245f;

    /* renamed from: g, reason: collision with root package name */
    public String f438246g;

    /* renamed from: h, reason: collision with root package name */
    public String f438247h;

    /* renamed from: i, reason: collision with root package name */
    public long f438248i;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f438240a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                this.f438241b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f438242c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f438243d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f438244e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f438245f = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                this.f438246g = codedInputByteBufferNano.readString();
            } else if (readTag == 66) {
                this.f438247h = codedInputByteBufferNano.readString();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f438248i = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f438240a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f438241b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f438241b);
        }
        if (!this.f438242c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f438242c);
        }
        if (!this.f438243d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f438243d);
        }
        if (!this.f438244e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f438244e);
        }
        if (!this.f438245f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f438245f);
        }
        if (!this.f438246g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f438246g);
        }
        if (!this.f438247h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f438247h);
        }
        long j3 = this.f438248i;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f438240a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f438241b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f438241b);
        }
        if (!this.f438242c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f438242c);
        }
        if (!this.f438243d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f438243d);
        }
        if (!this.f438244e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f438244e);
        }
        if (!this.f438245f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f438245f);
        }
        if (!this.f438246g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f438246g);
        }
        if (!this.f438247h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f438247h);
        }
        long j3 = this.f438248i;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f438240a = false;
        this.f438241b = "";
        this.f438242c = "";
        this.f438243d = "";
        this.f438244e = "";
        this.f438245f = "";
        this.f438246g = "";
        this.f438247h = "";
        this.f438248i = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
