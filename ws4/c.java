package ws4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f446409a;

    /* renamed from: b, reason: collision with root package name */
    public String f446410b;

    /* renamed from: c, reason: collision with root package name */
    public int f446411c;

    /* renamed from: d, reason: collision with root package name */
    public String f446412d;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f446409a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                this.f446410b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f446411c = codedInputByteBufferNano.readInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f446412d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f446409a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f446410b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f446410b);
        }
        int i3 = this.f446411c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        return !this.f446412d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f446412d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f446409a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f446410b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f446410b);
        }
        int i3 = this.f446411c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f446412d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f446412d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f446409a = false;
        this.f446410b = "";
        this.f446411c = 0;
        this.f446412d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
