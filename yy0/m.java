package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile m[] f451504d;

    /* renamed from: a, reason: collision with root package name */
    public int f451505a;

    /* renamed from: b, reason: collision with root package name */
    public String f451506b;

    /* renamed from: c, reason: collision with root package name */
    public String f451507c;

    public m() {
        a();
    }

    public static m[] b() {
        if (f451504d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451504d == null) {
                    f451504d = new m[0];
                }
            }
        }
        return f451504d;
    }

    public m a() {
        this.f451505a = 0;
        this.f451506b = "";
        this.f451507c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f451507c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451506b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f451505a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f451505a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f451506b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451506b);
        }
        if (!this.f451507c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f451507c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451505a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f451506b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451506b);
        }
        if (!this.f451507c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451507c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
