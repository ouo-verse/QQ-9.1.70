package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public int f427448a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f427449b;

    /* renamed from: c, reason: collision with root package name */
    public float f427450c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f427451d;

    /* renamed from: e, reason: collision with root package name */
    public int f427452e;

    public h() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427448a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f427449b = codedInputByteBufferNano.readBool();
            } else if (readTag == 29) {
                this.f427450c = codedInputByteBufferNano.readFloat();
            } else if (readTag == 32) {
                this.f427451d = codedInputByteBufferNano.readBool();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427452e = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427448a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        boolean z16 = this.f427449b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        if (Float.floatToIntBits(this.f427450c) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.f427450c);
        }
        boolean z17 = this.f427451d;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z17);
        }
        int i16 = this.f427452e;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427448a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        boolean z16 = this.f427449b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        if (Float.floatToIntBits(this.f427450c) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.f427450c);
        }
        boolean z17 = this.f427451d;
        if (z17) {
            codedOutputByteBufferNano.writeBool(4, z17);
        }
        int i16 = this.f427452e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f427448a = 0;
        this.f427449b = false;
        this.f427450c = 0.0f;
        this.f427451d = false;
        this.f427452e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
