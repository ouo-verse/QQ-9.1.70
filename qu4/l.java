package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile l[] f429613g;

    /* renamed from: a, reason: collision with root package name */
    public int f429614a;

    /* renamed from: b, reason: collision with root package name */
    public p f429615b;

    /* renamed from: c, reason: collision with root package name */
    public p f429616c;

    /* renamed from: d, reason: collision with root package name */
    public float f429617d;

    /* renamed from: e, reason: collision with root package name */
    public float f429618e;

    /* renamed from: f, reason: collision with root package name */
    public float f429619f;

    public l() {
        a();
    }

    public static l[] b() {
        if (f429613g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429613g == null) {
                    f429613g = new l[0];
                }
            }
        }
        return f429613g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429614a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.f429615b == null) {
                    this.f429615b = new p();
                }
                codedInputByteBufferNano.readMessage(this.f429615b);
            } else if (readTag == 26) {
                if (this.f429616c == null) {
                    this.f429616c = new p();
                }
                codedInputByteBufferNano.readMessage(this.f429616c);
            } else if (readTag == 37) {
                this.f429617d = codedInputByteBufferNano.readFloat();
            } else if (readTag == 45) {
                this.f429618e = codedInputByteBufferNano.readFloat();
            } else if (readTag != 53) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429619f = codedInputByteBufferNano.readFloat();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429614a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        p pVar = this.f429615b;
        if (pVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, pVar);
        }
        p pVar2 = this.f429616c;
        if (pVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, pVar2);
        }
        if (Float.floatToIntBits(this.f429617d) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.f429617d);
        }
        if (Float.floatToIntBits(this.f429618e) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.f429618e);
        }
        return Float.floatToIntBits(this.f429619f) != Float.floatToIntBits(0.0f) ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(6, this.f429619f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429614a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        p pVar = this.f429615b;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(2, pVar);
        }
        p pVar2 = this.f429616c;
        if (pVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, pVar2);
        }
        if (Float.floatToIntBits(this.f429617d) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.f429617d);
        }
        if (Float.floatToIntBits(this.f429618e) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(5, this.f429618e);
        }
        if (Float.floatToIntBits(this.f429619f) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(6, this.f429619f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f429614a = 0;
        this.f429615b = null;
        this.f429616c = null;
        this.f429617d = 0.0f;
        this.f429618e = 0.0f;
        this.f429619f = 0.0f;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
