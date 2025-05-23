package xy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile c[] f449050g;

    /* renamed from: a, reason: collision with root package name */
    public int f449051a;

    /* renamed from: b, reason: collision with root package name */
    public int f449052b;

    /* renamed from: c, reason: collision with root package name */
    public int f449053c;

    /* renamed from: d, reason: collision with root package name */
    public int f449054d;

    /* renamed from: e, reason: collision with root package name */
    public int f449055e;

    /* renamed from: f, reason: collision with root package name */
    public int f449056f;

    public c() {
        a();
    }

    public static c[] b() {
        if (f449050g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f449050g == null) {
                    f449050g = new c[0];
                }
            }
        }
        return f449050g;
    }

    public c a() {
        this.f449051a = 0;
        this.f449052b = 0;
        this.f449053c = 0;
        this.f449054d = 0;
        this.f449055e = 0;
        this.f449056f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f449056f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f449055e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f449054d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f449053c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f449052b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f449051a = codedInputByteBufferNano.readUInt32();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.f449051a) + CodedOutputByteBufferNano.computeUInt32Size(2, this.f449052b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.f449053c) + CodedOutputByteBufferNano.computeUInt32Size(4, this.f449054d);
        int i3 = this.f449055e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.f449056f;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.f449051a);
        codedOutputByteBufferNano.writeUInt32(2, this.f449052b);
        codedOutputByteBufferNano.writeUInt32(3, this.f449053c);
        codedOutputByteBufferNano.writeUInt32(4, this.f449054d);
        int i3 = this.f449055e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.f449056f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
