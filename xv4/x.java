package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class x extends ExtendableMessageNano<x> {

    /* renamed from: a, reason: collision with root package name */
    public long f448852a;

    /* renamed from: b, reason: collision with root package name */
    public int f448853b;

    /* renamed from: c, reason: collision with root package name */
    public long f448854c;

    /* renamed from: d, reason: collision with root package name */
    public String f448855d;

    public x() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public x mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448852a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f448853b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f448854c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448855d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f448852a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f448853b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.f448854c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        return !this.f448855d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f448855d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448852a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f448853b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.f448854c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f448855d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448855d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public x a() {
        this.f448852a = 0L;
        this.f448853b = 0;
        this.f448854c = 0L;
        this.f448855d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
