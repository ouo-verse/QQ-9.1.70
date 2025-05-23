package sq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f434247a;

    /* renamed from: b, reason: collision with root package name */
    public String f434248b;

    /* renamed from: c, reason: collision with root package name */
    public String f434249c;

    /* renamed from: d, reason: collision with root package name */
    public String f434250d;

    /* renamed from: e, reason: collision with root package name */
    public String f434251e;

    /* renamed from: f, reason: collision with root package name */
    public String f434252f;

    /* renamed from: g, reason: collision with root package name */
    public String f434253g;

    public a() {
        a();
    }

    public a a() {
        this.f434247a = "";
        this.f434248b = "";
        this.f434249c = "";
        this.f434250d = "";
        this.f434251e = "";
        this.f434252f = "";
        this.f434253g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f434253g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f434252f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f434251e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f434250d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f434249c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f434248b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f434247a = codedInputByteBufferNano.readString();
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
        if (!this.f434247a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f434247a);
        }
        if (!this.f434248b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434248b);
        }
        if (!this.f434249c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434249c);
        }
        if (!this.f434250d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f434250d);
        }
        if (!this.f434251e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f434251e);
        }
        if (!this.f434252f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f434252f);
        }
        if (!this.f434253g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f434253g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f434247a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f434247a);
        }
        if (!this.f434248b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434248b);
        }
        if (!this.f434249c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434249c);
        }
        if (!this.f434250d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f434250d);
        }
        if (!this.f434251e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f434251e);
        }
        if (!this.f434252f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f434252f);
        }
        if (!this.f434253g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f434253g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
