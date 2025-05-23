package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public String f449442a;

    /* renamed from: b, reason: collision with root package name */
    public String f449443b;

    /* renamed from: c, reason: collision with root package name */
    public i f449444c;

    /* renamed from: d, reason: collision with root package name */
    public String f449445d;

    /* renamed from: e, reason: collision with root package name */
    public String f449446e;

    /* renamed from: f, reason: collision with root package name */
    public String f449447f;

    public n() {
        a();
    }

    public n a() {
        this.f449442a = "";
        this.f449443b = "";
        this.f449444c = null;
        this.f449445d = "";
        this.f449446e = "";
        this.f449447f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f449447f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f449446e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f449445d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            if (this.f449444c == null) {
                                this.f449444c = new i();
                            }
                            codedInputByteBufferNano.readMessage(this.f449444c);
                        }
                    } else {
                        this.f449443b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f449442a = codedInputByteBufferNano.readString();
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
        if (!this.f449442a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f449442a);
        }
        if (!this.f449443b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f449443b);
        }
        i iVar = this.f449444c;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, iVar);
        }
        if (!this.f449445d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f449445d);
        }
        if (!this.f449446e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f449446e);
        }
        if (!this.f449447f.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f449447f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f449442a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f449442a);
        }
        if (!this.f449443b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f449443b);
        }
        i iVar = this.f449444c;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(3, iVar);
        }
        if (!this.f449445d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f449445d);
        }
        if (!this.f449446e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f449446e);
        }
        if (!this.f449447f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f449447f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
