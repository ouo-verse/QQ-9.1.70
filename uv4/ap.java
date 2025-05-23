package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ap extends ExtendableMessageNano<ap> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile ap[] f440198f;

    /* renamed from: a, reason: collision with root package name */
    public int f440199a;

    /* renamed from: b, reason: collision with root package name */
    public String f440200b;

    /* renamed from: c, reason: collision with root package name */
    public String f440201c;

    /* renamed from: d, reason: collision with root package name */
    public int f440202d;

    /* renamed from: e, reason: collision with root package name */
    public String f440203e;

    public ap() {
        a();
    }

    public static ap[] b() {
        if (f440198f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440198f == null) {
                    f440198f = new ap[0];
                }
            }
        }
        return f440198f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ap mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440199a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f440200b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f440201c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f440202d = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440203e = codedInputByteBufferNano.readString();
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440199a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f440200b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440200b);
        }
        if (!this.f440201c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440201c);
        }
        int i16 = this.f440202d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return !this.f440203e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f440203e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440199a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440200b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440200b);
        }
        if (!this.f440201c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440201c);
        }
        int i16 = this.f440202d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.f440203e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440203e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ap a() {
        this.f440199a = 0;
        this.f440200b = "";
        this.f440201c = "";
        this.f440202d = 0;
        this.f440203e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
