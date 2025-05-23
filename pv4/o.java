package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile o[] f427642h;

    /* renamed from: a, reason: collision with root package name */
    public String f427643a;

    /* renamed from: b, reason: collision with root package name */
    public String f427644b;

    /* renamed from: c, reason: collision with root package name */
    public int f427645c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f427646d;

    /* renamed from: e, reason: collision with root package name */
    public pu4.g f427647e;

    /* renamed from: f, reason: collision with root package name */
    public String f427648f;

    /* renamed from: g, reason: collision with root package name */
    public String f427649g;

    public o() {
        a();
    }

    public static o[] b() {
        if (f427642h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427642h == null) {
                    f427642h = new o[0];
                }
            }
        }
        return f427642h;
    }

    public o a() {
        this.f427643a = "";
        this.f427644b = "";
        this.f427645c = 0;
        this.f427646d = WireFormatNano.EMPTY_BYTES;
        this.f427647e = null;
        this.f427648f = "";
        this.f427649g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f427643a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f427644b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f427645c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f427646d = codedInputByteBufferNano.readBytes();
            } else if (readTag == 42) {
                if (this.f427647e == null) {
                    this.f427647e = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f427647e);
            } else if (readTag == 50) {
                this.f427648f = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427649g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f427643a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427643a);
        }
        if (!this.f427644b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427644b);
        }
        int i3 = this.f427645c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!Arrays.equals(this.f427646d, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.f427646d);
        }
        pu4.g gVar = this.f427647e;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gVar);
        }
        if (!this.f427648f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427648f);
        }
        return !this.f427649g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f427649g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427643a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427643a);
        }
        if (!this.f427644b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427644b);
        }
        int i3 = this.f427645c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!Arrays.equals(this.f427646d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.f427646d);
        }
        pu4.g gVar = this.f427647e;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(5, gVar);
        }
        if (!this.f427648f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427648f);
        }
        if (!this.f427649g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427649g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
