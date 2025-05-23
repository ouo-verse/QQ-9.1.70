package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f427395a;

    /* renamed from: b, reason: collision with root package name */
    public int f427396b;

    /* renamed from: c, reason: collision with root package name */
    public int f427397c;

    /* renamed from: d, reason: collision with root package name */
    public int f427398d;

    /* renamed from: e, reason: collision with root package name */
    public int f427399e;

    /* renamed from: f, reason: collision with root package name */
    public String f427400f;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427395a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f427396b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f427397c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 32) {
                this.f427398d = codedInputByteBufferNano.readInt32();
            } else if (readTag == 40) {
                this.f427399e = codedInputByteBufferNano.readInt32();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427400f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427395a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f427396b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f427397c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f427398d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        int i19 = this.f427399e;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i19);
        }
        return !this.f427400f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f427400f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427395a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f427396b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f427397c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f427398d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        int i19 = this.f427399e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i19);
        }
        if (!this.f427400f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427400f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f427395a = 0;
        this.f427396b = 0;
        this.f427397c = 0;
        this.f427398d = 0;
        this.f427399e = 0;
        this.f427400f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
