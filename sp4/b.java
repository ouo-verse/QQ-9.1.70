package sp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f434134a;

    /* renamed from: b, reason: collision with root package name */
    public String f434135b;

    /* renamed from: c, reason: collision with root package name */
    public String f434136c;

    /* renamed from: d, reason: collision with root package name */
    public String f434137d;

    /* renamed from: e, reason: collision with root package name */
    public int f434138e;

    public b() {
        a();
    }

    public b a() {
        this.f434134a = "";
        this.f434135b = "";
        this.f434136c = "";
        this.f434137d = "";
        this.f434138e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                        this.f434138e = readInt32;
                                    }
                                }
                            } else {
                                this.f434137d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f434136c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f434135b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f434134a = codedInputByteBufferNano.readString();
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
        if (!this.f434134a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f434134a);
        }
        if (!this.f434135b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434135b);
        }
        if (!this.f434136c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434136c);
        }
        if (!this.f434137d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f434137d);
        }
        int i3 = this.f434138e;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f434134a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f434134a);
        }
        if (!this.f434135b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434135b);
        }
        if (!this.f434136c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434136c);
        }
        if (!this.f434137d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f434137d);
        }
        int i3 = this.f434138e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
