package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public long f432408a;

    /* renamed from: b, reason: collision with root package name */
    public String f432409b;

    /* renamed from: c, reason: collision with root package name */
    public String f432410c;

    /* renamed from: d, reason: collision with root package name */
    public int f432411d;

    /* renamed from: e, reason: collision with root package name */
    public int f432412e;

    /* renamed from: f, reason: collision with root package name */
    public int f432413f;

    public i() {
        a();
    }

    public static i c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (i) MessageNano.mergeFrom(new i(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f432408a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                this.f432409b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f432410c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f432411d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f432412e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f432413f = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f432408a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        if (!this.f432409b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432409b);
        }
        if (!this.f432410c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432410c);
        }
        int i3 = this.f432411d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.f432412e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f432413f;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432408a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        if (!this.f432409b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432409b);
        }
        if (!this.f432410c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432410c);
        }
        int i3 = this.f432411d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.f432412e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f432413f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f432408a = 0L;
        this.f432409b = "";
        this.f432410c = "";
        this.f432411d = 0;
        this.f432412e = 0;
        this.f432413f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
