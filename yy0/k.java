package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public String f451485a;

    /* renamed from: b, reason: collision with root package name */
    public String f451486b;

    /* renamed from: c, reason: collision with root package name */
    public String f451487c;

    /* renamed from: d, reason: collision with root package name */
    public String f451488d;

    /* renamed from: e, reason: collision with root package name */
    public String f451489e;

    /* renamed from: f, reason: collision with root package name */
    public String f451490f;

    /* renamed from: g, reason: collision with root package name */
    public String f451491g;

    public k() {
        a();
    }

    public k a() {
        this.f451485a = "";
        this.f451486b = "";
        this.f451487c = "";
        this.f451488d = "";
        this.f451489e = "";
        this.f451490f = "";
        this.f451491g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                            this.f451491g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f451490f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f451489e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f451488d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f451487c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451486b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f451485a = codedInputByteBufferNano.readString();
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
        if (!this.f451485a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451485a);
        }
        if (!this.f451486b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451486b);
        }
        if (!this.f451487c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451487c);
        }
        if (!this.f451488d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f451488d);
        }
        if (!this.f451489e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f451489e);
        }
        if (!this.f451490f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f451490f);
        }
        if (!this.f451491g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f451491g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451485a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451485a);
        }
        if (!this.f451486b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451486b);
        }
        if (!this.f451487c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451487c);
        }
        if (!this.f451488d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451488d);
        }
        if (!this.f451489e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451489e);
        }
        if (!this.f451490f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f451490f);
        }
        if (!this.f451491g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f451491g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
