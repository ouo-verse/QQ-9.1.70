package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: a, reason: collision with root package name */
    public String f432361a;

    /* renamed from: b, reason: collision with root package name */
    public String f432362b;

    /* renamed from: c, reason: collision with root package name */
    public String f432363c;

    /* renamed from: d, reason: collision with root package name */
    public String f432364d;

    /* renamed from: e, reason: collision with root package name */
    public String f432365e;

    /* renamed from: f, reason: collision with root package name */
    public String f432366f;

    /* renamed from: g, reason: collision with root package name */
    public String f432367g;

    public v() {
        a();
    }

    public v a() {
        this.f432361a = "";
        this.f432362b = "";
        this.f432363c = "";
        this.f432364d = "";
        this.f432365e = "";
        this.f432366f = "";
        this.f432367g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                            this.f432367g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f432366f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f432365e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f432364d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f432363c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432362b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432361a = codedInputByteBufferNano.readString();
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
        if (!this.f432361a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432361a);
        }
        if (!this.f432362b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432362b);
        }
        if (!this.f432363c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432363c);
        }
        if (!this.f432364d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f432364d);
        }
        if (!this.f432365e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f432365e);
        }
        if (!this.f432366f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f432366f);
        }
        if (!this.f432367g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f432367g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432361a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432361a);
        }
        if (!this.f432362b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432362b);
        }
        if (!this.f432363c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432363c);
        }
        if (!this.f432364d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432364d);
        }
        if (!this.f432365e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f432365e);
        }
        if (!this.f432366f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f432366f);
        }
        if (!this.f432367g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f432367g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
