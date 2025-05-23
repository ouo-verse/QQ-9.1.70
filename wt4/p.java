package wt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public int f446525a;

    /* renamed from: b, reason: collision with root package name */
    public long f446526b;

    /* renamed from: c, reason: collision with root package name */
    public long f446527c;

    /* renamed from: d, reason: collision with root package name */
    public fs4.k f446528d;

    public p() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f446525a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f446526b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f446527c = codedInputByteBufferNano.readInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f446528d == null) {
                    this.f446528d = new fs4.k();
                }
                codedInputByteBufferNano.readMessage(this.f446528d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f446525a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f446526b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        long j16 = this.f446527c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        fs4.k kVar = this.f446528d;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f446525a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f446526b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        long j16 = this.f446527c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        fs4.k kVar = this.f446528d;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(4, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f446525a = 0;
        this.f446526b = 0L;
        this.f446527c = 0L;
        this.f446528d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
