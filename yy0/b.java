package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b[] f451421d;

    /* renamed from: a, reason: collision with root package name */
    public String f451422a;

    /* renamed from: b, reason: collision with root package name */
    public int f451423b;

    /* renamed from: c, reason: collision with root package name */
    public String f451424c;

    public b() {
        a();
    }

    public static b[] b() {
        if (f451421d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451421d == null) {
                    f451421d = new b[0];
                }
            }
        }
        return f451421d;
    }

    public b a() {
        this.f451422a = "";
        this.f451423b = 0;
        this.f451424c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f451424c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451423b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f451422a = codedInputByteBufferNano.readString();
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
        if (!this.f451422a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451422a);
        }
        int i3 = this.f451423b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f451424c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f451424c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451422a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451422a);
        }
        int i3 = this.f451423b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f451424c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451424c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
