package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile f[] f449390c;

    /* renamed from: a, reason: collision with root package name */
    public int f449391a;

    /* renamed from: b, reason: collision with root package name */
    public String f449392b;

    public f() {
        a();
    }

    public static f[] b() {
        if (f449390c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f449390c == null) {
                    f449390c = new f[0];
                }
            }
        }
        return f449390c;
    }

    public f a() {
        this.f449391a = 0;
        this.f449392b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f449392b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f449391a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f449391a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f449392b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f449392b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f449391a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f449392b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f449392b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
