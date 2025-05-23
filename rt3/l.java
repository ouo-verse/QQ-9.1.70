package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile l[] f432320f;

    /* renamed from: a, reason: collision with root package name */
    public int f432321a;

    /* renamed from: b, reason: collision with root package name */
    public int f432322b;

    /* renamed from: c, reason: collision with root package name */
    public String f432323c;

    /* renamed from: d, reason: collision with root package name */
    public int f432324d;

    /* renamed from: e, reason: collision with root package name */
    public int f432325e;

    public l() {
        a();
    }

    public static l[] b() {
        if (f432320f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432320f == null) {
                    f432320f = new l[0];
                }
            }
        }
        return f432320f;
    }

    public l a() {
        this.f432321a = 0;
        this.f432322b = 0;
        this.f432323c = "";
        this.f432324d = 0;
        this.f432325e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f432325e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f432324d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f432323c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432322b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f432321a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f432321a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f432322b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f432323c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432323c);
        }
        int i17 = this.f432324d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f432325e;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432321a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f432322b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f432323c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432323c);
        }
        int i17 = this.f432324d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f432325e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
