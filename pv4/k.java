package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile k[] f427624f;

    /* renamed from: a, reason: collision with root package name */
    public int f427625a;

    /* renamed from: b, reason: collision with root package name */
    public String f427626b;

    /* renamed from: c, reason: collision with root package name */
    public int f427627c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f427628d;

    /* renamed from: e, reason: collision with root package name */
    public String f427629e;

    public k() {
        a();
    }

    public static k[] b() {
        if (f427624f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427624f == null) {
                    f427624f = new k[0];
                }
            }
        }
        return f427624f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427625a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f427626b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f427627c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f427628d = codedInputByteBufferNano.readBool();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427629e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427625a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f427626b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427626b);
        }
        int i16 = this.f427627c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        boolean z16 = this.f427628d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        return !this.f427629e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f427629e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427625a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f427626b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427626b);
        }
        int i16 = this.f427627c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        boolean z16 = this.f427628d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        if (!this.f427629e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427629e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f427625a = 0;
        this.f427626b = "";
        this.f427627c = 0;
        this.f427628d = false;
        this.f427629e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
