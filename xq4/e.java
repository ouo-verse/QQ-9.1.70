package xq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f448410a;

    /* renamed from: b, reason: collision with root package name */
    public String f448411b;

    /* renamed from: c, reason: collision with root package name */
    public String f448412c;

    /* renamed from: d, reason: collision with root package name */
    public String f448413d;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f448410a = "";
        this.f448411b = "";
        this.f448412c = "";
        this.f448413d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f448413d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f448412c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f448411b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f448410a = codedInputByteBufferNano.readString();
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
        if (!this.f448410a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f448410a);
        }
        if (!this.f448411b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448411b);
        }
        if (!this.f448412c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448412c);
        }
        if (!this.f448413d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f448413d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f448410a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f448410a);
        }
        if (!this.f448411b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448411b);
        }
        if (!this.f448412c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448412c);
        }
        if (!this.f448413d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448413d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
