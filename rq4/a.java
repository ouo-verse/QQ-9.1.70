package rq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a[] f431963e;

    /* renamed from: a, reason: collision with root package name */
    public int f431964a;

    /* renamed from: b, reason: collision with root package name */
    public String f431965b;

    /* renamed from: c, reason: collision with root package name */
    public String f431966c;

    /* renamed from: d, reason: collision with root package name */
    public int f431967d;

    public a() {
        a();
    }

    public static a[] b() {
        if (f431963e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f431963e == null) {
                    f431963e = new a[0];
                }
            }
        }
        return f431963e;
    }

    public a a() {
        this.f431964a = 0;
        this.f431965b = "";
        this.f431966c = "";
        this.f431967d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f431967d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f431966c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f431965b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f431964a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f431964a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f431965b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f431965b);
        }
        if (!this.f431966c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f431966c);
        }
        int i16 = this.f431967d;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f431964a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f431965b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f431965b);
        }
        if (!this.f431966c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f431966c);
        }
        int i16 = this.f431967d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
