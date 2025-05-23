package u45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public int f438249a;

    /* renamed from: b, reason: collision with root package name */
    public int f438250b;

    /* renamed from: c, reason: collision with root package name */
    public String f438251c;

    public k() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f438249a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f438250b = codedInputByteBufferNano.readInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f438251c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f438249a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f438250b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        return !this.f438251c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f438251c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f438249a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f438250b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f438251c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f438251c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f438249a = 0;
        this.f438250b = 0;
        this.f438251c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
