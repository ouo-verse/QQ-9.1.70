package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: a, reason: collision with root package name */
    public String f440454a;

    /* renamed from: b, reason: collision with root package name */
    public int f440455b;

    /* renamed from: c, reason: collision with root package name */
    public int f440456c;

    /* renamed from: d, reason: collision with root package name */
    public int f440457d;

    /* renamed from: e, reason: collision with root package name */
    public int f440458e;

    /* renamed from: f, reason: collision with root package name */
    public String f440459f;

    public v() {
        a();
    }

    public v a() {
        this.f440454a = "";
        this.f440455b = 0;
        this.f440456c = 0;
        this.f440457d = 0;
        this.f440458e = 0;
        this.f440459f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440454a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f440455b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f440456c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f440457d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f440458e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440459f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440454a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440454a);
        }
        int i3 = this.f440455b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f440456c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f440457d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f440458e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        return !this.f440459f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f440459f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440454a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440454a);
        }
        int i3 = this.f440455b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f440456c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f440457d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f440458e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        if (!this.f440459f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440459f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
