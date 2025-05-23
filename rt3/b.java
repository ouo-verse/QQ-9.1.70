package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b[] f432262d;

    /* renamed from: a, reason: collision with root package name */
    public String f432263a;

    /* renamed from: b, reason: collision with root package name */
    public int f432264b;

    /* renamed from: c, reason: collision with root package name */
    public String f432265c;

    public b() {
        a();
    }

    public static b[] b() {
        if (f432262d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432262d == null) {
                    f432262d = new b[0];
                }
            }
        }
        return f432262d;
    }

    public b a() {
        this.f432263a = "";
        this.f432264b = 0;
        this.f432265c = "";
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
                            this.f432265c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432264b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f432263a = codedInputByteBufferNano.readString();
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
        if (!this.f432263a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432263a);
        }
        int i3 = this.f432264b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f432265c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f432265c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432263a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432263a);
        }
        int i3 = this.f432264b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f432265c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432265c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
