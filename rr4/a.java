package rr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f432091a;

    /* renamed from: b, reason: collision with root package name */
    public int f432092b;

    /* renamed from: c, reason: collision with root package name */
    public String f432093c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f432094d;

    /* renamed from: e, reason: collision with root package name */
    public int f432095e;

    public a() {
        a();
    }

    public a a() {
        this.f432091a = false;
        this.f432092b = 0;
        this.f432093c = "";
        this.f432094d = false;
        this.f432095e = 0;
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
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f432095e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f432094d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f432093c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432092b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f432091a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f432091a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f432092b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f432093c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432093c);
        }
        boolean z17 = this.f432094d;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z17);
        }
        int i16 = this.f432095e;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f432091a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f432092b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f432093c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432093c);
        }
        boolean z17 = this.f432094d;
        if (z17) {
            codedOutputByteBufferNano.writeBool(4, z17);
        }
        int i16 = this.f432095e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
