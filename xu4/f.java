package xu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile f[] f448727e;

    /* renamed from: a, reason: collision with root package name */
    public String f448728a;

    /* renamed from: b, reason: collision with root package name */
    public String f448729b;

    /* renamed from: c, reason: collision with root package name */
    public String f448730c;

    /* renamed from: d, reason: collision with root package name */
    public int f448731d;

    public f() {
        a();
    }

    public static f[] b() {
        if (f448727e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448727e == null) {
                    f448727e = new f[0];
                }
            }
        }
        return f448727e;
    }

    public f a() {
        this.f448728a = "";
        this.f448729b = "";
        this.f448730c = "";
        this.f448731d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f448728a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f448729b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f448730c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448731d = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f448728a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f448728a);
        }
        if (!this.f448729b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448729b);
        }
        if (!this.f448730c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448730c);
        }
        int i3 = this.f448731d;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f448728a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f448728a);
        }
        if (!this.f448729b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448729b);
        }
        if (!this.f448730c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448730c);
        }
        int i3 = this.f448731d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
