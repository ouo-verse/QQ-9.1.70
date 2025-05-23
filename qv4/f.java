package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile f[] f430133h;

    /* renamed from: a, reason: collision with root package name */
    public String f430134a;

    /* renamed from: b, reason: collision with root package name */
    public long f430135b;

    /* renamed from: c, reason: collision with root package name */
    public String f430136c;

    /* renamed from: d, reason: collision with root package name */
    public String f430137d;

    /* renamed from: e, reason: collision with root package name */
    public String f430138e;

    /* renamed from: f, reason: collision with root package name */
    public long f430139f;

    /* renamed from: g, reason: collision with root package name */
    public String f430140g;

    public f() {
        a();
    }

    public static f[] b() {
        if (f430133h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430133h == null) {
                    f430133h = new f[0];
                }
            }
        }
        return f430133h;
    }

    public f a() {
        this.f430134a = "";
        this.f430135b = 0L;
        this.f430136c = "";
        this.f430137d = "";
        this.f430138e = "";
        this.f430139f = 0L;
        this.f430140g = "";
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
                this.f430134a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f430135b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                this.f430136c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f430137d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f430138e = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.f430139f = codedInputByteBufferNano.readInt64();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430140g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f430134a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f430134a);
        }
        long j3 = this.f430135b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        if (!this.f430136c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430136c);
        }
        if (!this.f430137d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430137d);
        }
        if (!this.f430138e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f430138e);
        }
        long j16 = this.f430139f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j16);
        }
        return !this.f430140g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f430140g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f430134a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f430134a);
        }
        long j3 = this.f430135b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        if (!this.f430136c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430136c);
        }
        if (!this.f430137d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430137d);
        }
        if (!this.f430138e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f430138e);
        }
        long j16 = this.f430139f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j16);
        }
        if (!this.f430140g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f430140g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
