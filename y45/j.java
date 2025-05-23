package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile j[] f449410e;

    /* renamed from: a, reason: collision with root package name */
    public int f449411a;

    /* renamed from: b, reason: collision with root package name */
    public String f449412b;

    /* renamed from: c, reason: collision with root package name */
    public int f449413c;

    /* renamed from: d, reason: collision with root package name */
    public int f449414d;

    public j() {
        a();
    }

    public static j[] b() {
        if (f449410e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f449410e == null) {
                    f449410e = new j[0];
                }
            }
        }
        return f449410e;
    }

    public j a() {
        this.f449411a = 0;
        this.f449412b = "";
        this.f449413c = 0;
        this.f449414d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f449414d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f449413c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f449412b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f449411a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f449411a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f449412b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f449412b);
        }
        int i16 = this.f449413c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f449414d;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f449411a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f449412b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f449412b);
        }
        int i16 = this.f449413c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f449414d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
