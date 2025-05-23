package vp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d[] f443168c;

    /* renamed from: a, reason: collision with root package name */
    public double f443169a;

    /* renamed from: b, reason: collision with root package name */
    public double f443170b;

    public d() {
        a();
    }

    public static d[] b() {
        if (f443168c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f443168c == null) {
                    f443168c = new d[0];
                }
            }
        }
        return f443168c;
    }

    public d a() {
        this.f443169a = 0.0d;
        this.f443170b = 0.0d;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 9) {
                    if (readTag != 17) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f443170b = codedInputByteBufferNano.readDouble();
                    }
                } else {
                    this.f443169a = codedInputByteBufferNano.readDouble();
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
        if (Double.doubleToLongBits(this.f443169a) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, this.f443169a);
        }
        if (Double.doubleToLongBits(this.f443170b) != Double.doubleToLongBits(0.0d)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(2, this.f443170b);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (Double.doubleToLongBits(this.f443169a) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(1, this.f443169a);
        }
        if (Double.doubleToLongBits(this.f443170b) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.f443170b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
