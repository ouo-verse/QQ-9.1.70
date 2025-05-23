package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ar extends ExtendableMessageNano<ar> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile ar[] f440214d;

    /* renamed from: a, reason: collision with root package name */
    public int f440215a;

    /* renamed from: b, reason: collision with root package name */
    public String f440216b;

    /* renamed from: c, reason: collision with root package name */
    public String f440217c;

    public ar() {
        a();
    }

    public static ar[] b() {
        if (f440214d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440214d == null) {
                    f440214d = new ar[0];
                }
            }
        }
        return f440214d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ar mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440215a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f440216b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440217c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440215a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f440216b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440216b);
        }
        return !this.f440217c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f440217c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440215a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440216b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440216b);
        }
        if (!this.f440217c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440217c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ar a() {
        this.f440215a = 0;
        this.f440216b = "";
        this.f440217c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
