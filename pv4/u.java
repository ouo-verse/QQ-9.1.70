package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile u[] f427701e;

    /* renamed from: a, reason: collision with root package name */
    public String f427702a;

    /* renamed from: b, reason: collision with root package name */
    public String f427703b;

    /* renamed from: c, reason: collision with root package name */
    public String f427704c;

    /* renamed from: d, reason: collision with root package name */
    public pu4.g f427705d;

    public u() {
        a();
    }

    public static u[] b() {
        if (f427701e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427701e == null) {
                    f427701e = new u[0];
                }
            }
        }
        return f427701e;
    }

    public u a() {
        this.f427702a = "";
        this.f427703b = "";
        this.f427704c = "";
        this.f427705d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f427702a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f427703b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f427704c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f427705d == null) {
                    this.f427705d = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f427705d);
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f427702a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427702a);
        }
        if (!this.f427703b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427703b);
        }
        if (!this.f427704c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427704c);
        }
        pu4.g gVar = this.f427705d;
        return gVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, gVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427702a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427702a);
        }
        if (!this.f427703b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427703b);
        }
        if (!this.f427704c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427704c);
        }
        pu4.g gVar = this.f427705d;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(4, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
