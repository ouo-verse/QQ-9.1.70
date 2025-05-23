package zv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f453563a;

    /* renamed from: b, reason: collision with root package name */
    public int f453564b;

    /* renamed from: c, reason: collision with root package name */
    public int f453565c;

    /* renamed from: d, reason: collision with root package name */
    public int f453566d;

    /* renamed from: e, reason: collision with root package name */
    public int f453567e;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f453563a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f453564b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f453565c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 32) {
                this.f453566d = codedInputByteBufferNano.readInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453567e = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f453563a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f453564b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f453565c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f453566d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        int i19 = this.f453567e;
        return i19 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i19) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f453563a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f453564b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f453565c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f453566d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        int i19 = this.f453567e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f453563a = 0;
        this.f453564b = 0;
        this.f453565c = 0;
        this.f453566d = 0;
        this.f453567e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
