package zo4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f452916a;

    /* renamed from: b, reason: collision with root package name */
    public String f452917b;

    /* renamed from: c, reason: collision with root package name */
    public String f452918c;

    /* renamed from: d, reason: collision with root package name */
    public String f452919d;

    /* renamed from: e, reason: collision with root package name */
    public String f452920e;

    /* renamed from: f, reason: collision with root package name */
    public String f452921f;

    /* renamed from: g, reason: collision with root package name */
    public String f452922g;

    /* renamed from: h, reason: collision with root package name */
    public String f452923h;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f452916a = "";
        this.f452917b = "";
        this.f452918c = "";
        this.f452919d = "";
        this.f452920e = "";
        this.f452921f = "";
        this.f452922g = "";
        this.f452923h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (readTag != 66) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f452923h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f452922g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f452921f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f452920e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f452919d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f452918c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f452917b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f452916a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    protected int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f452916a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f452916a);
        }
        if (!this.f452917b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f452917b);
        }
        if (!this.f452918c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f452918c);
        }
        if (!this.f452919d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f452919d);
        }
        if (!this.f452920e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f452920e);
        }
        if (!this.f452921f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f452921f);
        }
        if (!this.f452922g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f452922g);
        }
        if (!this.f452923h.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f452923h);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f452916a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f452916a);
        }
        if (!this.f452917b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f452917b);
        }
        if (!this.f452918c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f452918c);
        }
        if (!this.f452919d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f452919d);
        }
        if (!this.f452920e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f452920e);
        }
        if (!this.f452921f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f452921f);
        }
        if (!this.f452922g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f452922g);
        }
        if (!this.f452923h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f452923h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
