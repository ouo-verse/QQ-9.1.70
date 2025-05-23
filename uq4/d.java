package uq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f439831a;

    /* renamed from: b, reason: collision with root package name */
    public int f439832b;

    /* renamed from: c, reason: collision with root package name */
    public float f439833c;

    /* renamed from: d, reason: collision with root package name */
    public float f439834d;

    public d() {
        a();
    }

    public d a() {
        this.f439831a = false;
        this.f439832b = 0;
        this.f439833c = 0.0f;
        this.f439834d = 0.0f;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 29) {
                            if (readTag != 37) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f439834d = codedInputByteBufferNano.readFloat();
                            }
                        } else {
                            this.f439833c = codedInputByteBufferNano.readFloat();
                        }
                    } else {
                        this.f439832b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f439831a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f439831a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f439832b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (Float.floatToIntBits(this.f439833c) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.f439833c);
        }
        if (Float.floatToIntBits(this.f439834d) != Float.floatToIntBits(0.0f)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(4, this.f439834d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f439831a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f439832b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (Float.floatToIntBits(this.f439833c) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.f439833c);
        }
        if (Float.floatToIntBits(this.f439834d) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.f439834d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
