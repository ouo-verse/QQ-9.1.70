package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public long f427518a;

    /* renamed from: b, reason: collision with root package name */
    public String f427519b;

    /* renamed from: c, reason: collision with root package name */
    public String f427520c;

    /* renamed from: d, reason: collision with root package name */
    public String f427521d;

    /* renamed from: e, reason: collision with root package name */
    public int f427522e;

    public s() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427518a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f427519b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f427520c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f427521d = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427522e = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f427518a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f427519b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427519b);
        }
        if (!this.f427520c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427520c);
        }
        if (!this.f427521d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427521d);
        }
        int i3 = this.f427522e;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427518a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f427519b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427519b);
        }
        if (!this.f427520c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427520c);
        }
        if (!this.f427521d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427521d);
        }
        int i3 = this.f427522e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public s a() {
        this.f427518a = 0L;
        this.f427519b = "";
        this.f427520c = "";
        this.f427521d = "";
        this.f427522e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
