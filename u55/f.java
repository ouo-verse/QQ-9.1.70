package u55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public int f438456a;

    /* renamed from: b, reason: collision with root package name */
    public long f438457b;

    /* renamed from: c, reason: collision with root package name */
    public long f438458c;

    /* renamed from: d, reason: collision with root package name */
    public long f438459d;

    /* renamed from: e, reason: collision with root package name */
    public String f438460e;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.f438456a = readInt32;
                }
            } else if (readTag == 16) {
                this.f438457b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f438458c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.f438459d = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f438460e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f438456a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f438457b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f438458c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        long j17 = this.f438459d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        return !this.f438460e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f438460e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f438456a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f438457b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f438458c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        long j17 = this.f438459d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        if (!this.f438460e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f438460e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f438456a = 0;
        this.f438457b = 0L;
        this.f438458c = 0L;
        this.f438459d = 0L;
        this.f438460e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
