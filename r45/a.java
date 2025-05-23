package r45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a[] f430738c;

    /* renamed from: a, reason: collision with root package name */
    public String f430739a;

    /* renamed from: b, reason: collision with root package name */
    public String f430740b;

    public a() {
        a();
    }

    public static a[] b() {
        if (f430738c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430738c == null) {
                    f430738c = new a[0];
                }
            }
        }
        return f430738c;
    }

    public a a() {
        this.f430739a = "";
        this.f430740b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f430740b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f430739a = codedInputByteBufferNano.readString();
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
        if (!this.f430739a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f430739a);
        }
        if (!this.f430740b.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f430740b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f430739a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f430739a);
        }
        if (!this.f430740b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430740b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
