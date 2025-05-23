package yv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f451320d;

    /* renamed from: a, reason: collision with root package name */
    public int f451321a;

    /* renamed from: b, reason: collision with root package name */
    public int f451322b;

    /* renamed from: c, reason: collision with root package name */
    public String f451323c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f451320d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451320d == null) {
                    f451320d = new a[0];
                }
            }
        }
        return f451320d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        this.f451321a = readInt32;
                        break;
                }
            } else if (readTag == 16) {
                this.f451322b = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451323c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f451321a;
        if (i3 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f451322b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        return !this.f451323c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f451323c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451321a;
        if (i3 != 1) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f451322b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f451323c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451323c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f451321a = 1;
        this.f451322b = 0;
        this.f451323c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
