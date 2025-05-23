package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public int f430188a;

    /* renamed from: b, reason: collision with root package name */
    public int f430189b;

    /* renamed from: c, reason: collision with root package name */
    public int f430190c;

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
                this.f430188a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f430189b = codedInputByteBufferNano.readInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430190c = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f430188a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f430189b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f430190c;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f430188a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f430189b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f430190c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f430188a = 0;
        this.f430189b = 0;
        this.f430190c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
