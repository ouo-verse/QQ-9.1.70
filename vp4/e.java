package vp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile e[] f443171c;

    /* renamed from: a, reason: collision with root package name */
    public d f443172a;

    /* renamed from: b, reason: collision with root package name */
    public double f443173b;

    public e() {
        a();
    }

    public static e[] b() {
        if (f443171c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f443171c == null) {
                    f443171c = new e[0];
                }
            }
        }
        return f443171c;
    }

    public e a() {
        this.f443172a = null;
        this.f443173b = 0.0d;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 17) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f443173b = codedInputByteBufferNano.readDouble();
                    }
                } else {
                    if (this.f443172a == null) {
                        this.f443172a = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f443172a);
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
        d dVar = this.f443172a;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
        }
        if (Double.doubleToLongBits(this.f443173b) != Double.doubleToLongBits(0.0d)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(2, this.f443173b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d dVar = this.f443172a;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(1, dVar);
        }
        if (Double.doubleToLongBits(this.f443173b) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.f443173b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
