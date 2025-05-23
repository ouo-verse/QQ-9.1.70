package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ab extends ExtendableMessageNano<ab> {

    /* renamed from: a, reason: collision with root package name */
    public int f440109a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f440110b;

    /* renamed from: c, reason: collision with root package name */
    public String f440111c;

    public ab() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ab mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440109a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f440110b = codedInputByteBufferNano.readBool();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440111c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440109a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        boolean z16 = this.f440110b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        return !this.f440111c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f440111c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440109a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        boolean z16 = this.f440110b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        if (!this.f440111c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440111c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ab a() {
        this.f440109a = 0;
        this.f440110b = false;
        this.f440111c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
