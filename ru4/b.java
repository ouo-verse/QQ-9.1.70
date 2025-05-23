package ru4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f432518a;

    /* renamed from: b, reason: collision with root package name */
    public int f432519b;

    /* renamed from: c, reason: collision with root package name */
    public int f432520c;

    /* renamed from: d, reason: collision with root package name */
    public int f432521d;

    /* renamed from: e, reason: collision with root package name */
    public int f432522e;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
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
                this.f432518a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f432519b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f432520c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 32) {
                this.f432521d = codedInputByteBufferNano.readInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f432522e = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f432518a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f432519b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f432520c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f432521d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        int i19 = this.f432522e;
        return i19 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i19) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432518a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f432519b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f432520c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f432521d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        int i19 = this.f432522e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f432518a = 0;
        this.f432519b = 0;
        this.f432520c = 0;
        this.f432521d = 0;
        this.f432522e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
