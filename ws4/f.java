package ws4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f446423a;

    /* renamed from: b, reason: collision with root package name */
    public long f446424b;

    /* renamed from: c, reason: collision with root package name */
    public String f446425c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f446426d;

    public f() {
        a();
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
                this.f446423a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.f446424b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                this.f446425c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f446426d = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f446423a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        long j3 = this.f446424b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        if (!this.f446425c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f446425c);
        }
        boolean z17 = this.f446426d;
        return z17 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f446423a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        long j3 = this.f446424b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        if (!this.f446425c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f446425c);
        }
        boolean z17 = this.f446426d;
        if (z17) {
            codedOutputByteBufferNano.writeBool(4, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f446423a = false;
        this.f446424b = 0L;
        this.f446425c = "";
        this.f446426d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
