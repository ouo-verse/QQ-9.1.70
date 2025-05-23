package zu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f453453a;

    /* renamed from: b, reason: collision with root package name */
    public int f453454b;

    /* renamed from: c, reason: collision with root package name */
    public int f453455c;

    /* renamed from: d, reason: collision with root package name */
    public int f453456d;

    /* renamed from: e, reason: collision with root package name */
    public int f453457e;

    /* renamed from: f, reason: collision with root package name */
    public int f453458f;

    /* renamed from: g, reason: collision with root package name */
    public int f453459g;

    /* renamed from: h, reason: collision with root package name */
    public int f453460h;

    /* renamed from: i, reason: collision with root package name */
    public int f453461i;

    public n() {
        a();
    }

    public static n c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (n) MessageNano.mergeFrom(new n(), bArr);
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
                this.f453453a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.f453454b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f453455c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f453456d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f453457e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f453458f = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.f453459g = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 64) {
                this.f453460h = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453461i = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f453453a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f453454b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f453455c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f453456d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f453457e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.f453458f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        int i26 = this.f453459g;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i26);
        }
        int i27 = this.f453460h;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i27);
        }
        int i28 = this.f453461i;
        return i28 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i28) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f453453a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f453454b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f453455c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f453456d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f453457e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.f453458f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        int i26 = this.f453459g;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i26);
        }
        int i27 = this.f453460h;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i27);
        }
        int i28 = this.f453461i;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i28);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f453453a = false;
        this.f453454b = 0;
        this.f453455c = 0;
        this.f453456d = 0;
        this.f453457e = 0;
        this.f453458f = 0;
        this.f453459g = 0;
        this.f453460h = 0;
        this.f453461i = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
