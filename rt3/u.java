package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile u[] f432357d;

    /* renamed from: a, reason: collision with root package name */
    public String f432358a;

    /* renamed from: b, reason: collision with root package name */
    public int f432359b;

    /* renamed from: c, reason: collision with root package name */
    public String f432360c;

    public u() {
        a();
    }

    public static u[] b() {
        if (f432357d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432357d == null) {
                    f432357d = new u[0];
                }
            }
        }
        return f432357d;
    }

    public u a() {
        this.f432358a = "";
        this.f432359b = 0;
        this.f432360c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f432360c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432359b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f432358a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f432358a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432358a);
        }
        int i3 = this.f432359b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f432360c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f432360c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432358a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432358a);
        }
        int i3 = this.f432359b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f432360c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432360c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
