package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile i[] f451475f;

    /* renamed from: a, reason: collision with root package name */
    public int f451476a;

    /* renamed from: b, reason: collision with root package name */
    public int f451477b;

    /* renamed from: c, reason: collision with root package name */
    public String f451478c;

    /* renamed from: d, reason: collision with root package name */
    public int f451479d;

    /* renamed from: e, reason: collision with root package name */
    public int f451480e;

    public i() {
        a();
    }

    public static i[] b() {
        if (f451475f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451475f == null) {
                    f451475f = new i[0];
                }
            }
        }
        return f451475f;
    }

    public i a() {
        this.f451476a = 0;
        this.f451477b = 0;
        this.f451478c = "";
        this.f451479d = 0;
        this.f451480e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                    this.f451480e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f451479d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f451478c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451477b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    this.f451476a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f451476a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f451477b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f451478c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451478c);
        }
        int i17 = this.f451479d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f451480e;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451476a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f451477b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f451478c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451478c);
        }
        int i17 = this.f451479d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f451480e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
