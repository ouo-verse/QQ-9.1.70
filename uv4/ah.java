package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ah extends ExtendableMessageNano<ah> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile ah[] f440137c;

    /* renamed from: a, reason: collision with root package name */
    public int f440138a;

    /* renamed from: b, reason: collision with root package name */
    public String f440139b;

    public ah() {
        a();
    }

    public static ah[] b() {
        if (f440137c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440137c == null) {
                    f440137c = new ah[0];
                }
            }
        }
        return f440137c;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ah mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440138a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440139b = codedInputByteBufferNano.readString();
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440138a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        return !this.f440139b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f440139b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440138a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440139b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440139b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ah a() {
        this.f440138a = 0;
        this.f440139b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
