package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile v[] f448654d;

    /* renamed from: a, reason: collision with root package name */
    public int f448655a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f448656b;

    /* renamed from: c, reason: collision with root package name */
    public String f448657c;

    public v() {
        a();
    }

    public static v[] b() {
        if (f448654d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448654d == null) {
                    f448654d = new v[0];
                }
            }
        }
        return f448654d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        this.f448655a = readInt32;
                        break;
                }
            } else if (readTag == 16) {
                this.f448656b = codedInputByteBufferNano.readBool();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448657c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f448655a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        boolean z16 = this.f448656b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        return !this.f448657c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f448657c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448655a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        boolean z16 = this.f448656b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        if (!this.f448657c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448657c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public v a() {
        this.f448655a = 0;
        this.f448656b = false;
        this.f448657c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
