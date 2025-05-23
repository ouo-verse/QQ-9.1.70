package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ai extends ExtendableMessageNano<ai> {

    /* renamed from: a, reason: collision with root package name */
    public long f440140a;

    /* renamed from: b, reason: collision with root package name */
    public int f440141b;

    /* renamed from: c, reason: collision with root package name */
    public long f440142c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f440143d;

    /* renamed from: e, reason: collision with root package name */
    public String f440144e;

    public ai() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ai mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440140a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f440141b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f440142c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.f440143d = codedInputByteBufferNano.readBool();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440144e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f440140a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f440141b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.f440142c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        boolean z16 = this.f440143d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        return !this.f440144e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f440144e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f440140a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f440141b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.f440142c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        boolean z16 = this.f440143d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        if (!this.f440144e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440144e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ai a() {
        this.f440140a = 0L;
        this.f440141b = 0;
        this.f440142c = 0L;
        this.f440143d = false;
        this.f440144e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
