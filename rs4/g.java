package rs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public long f432168a;

    /* renamed from: b, reason: collision with root package name */
    public long f432169b;

    /* renamed from: c, reason: collision with root package name */
    public String f432170c;

    /* renamed from: d, reason: collision with root package name */
    public String f432171d;

    /* renamed from: e, reason: collision with root package name */
    public int f432172e;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f432168a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f432169b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                this.f432170c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f432171d = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f432172e = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f432168a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f432169b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        if (!this.f432170c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432170c);
        }
        if (!this.f432171d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f432171d);
        }
        int i3 = this.f432172e;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432168a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f432169b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        if (!this.f432170c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432170c);
        }
        if (!this.f432171d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432171d);
        }
        int i3 = this.f432172e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f432168a = 0L;
        this.f432169b = 0L;
        this.f432170c = "";
        this.f432171d = "";
        this.f432172e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
