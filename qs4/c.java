package qs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile c[] f429472g;

    /* renamed from: a, reason: collision with root package name */
    public String f429473a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f429474b;

    /* renamed from: c, reason: collision with root package name */
    public long f429475c;

    /* renamed from: d, reason: collision with root package name */
    public int f429476d;

    /* renamed from: e, reason: collision with root package name */
    public long f429477e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f429478f;

    public c() {
        a();
    }

    public static c[] b() {
        if (f429472g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429472g == null) {
                    f429472g = new c[0];
                }
            }
        }
        return f429472g;
    }

    public c a() {
        this.f429473a = "";
        this.f429474b = WireFormatNano.EMPTY_BYTES;
        this.f429475c = 0L;
        this.f429476d = 0;
        this.f429477e = 0L;
        this.f429478f = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f429473a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f429474b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 24) {
                this.f429475c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f429476d = readInt32;
                }
            } else if (readTag == 40) {
                this.f429477e = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429478f = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f429473a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429473a);
        }
        if (!Arrays.equals(this.f429474b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f429474b);
        }
        long j3 = this.f429475c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        int i3 = this.f429476d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        long j16 = this.f429477e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        boolean z16 = this.f429478f;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429473a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429473a);
        }
        if (!Arrays.equals(this.f429474b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f429474b);
        }
        long j3 = this.f429475c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        int i3 = this.f429476d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        long j16 = this.f429477e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        boolean z16 = this.f429478f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
