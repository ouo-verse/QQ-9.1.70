package uu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f440081a;

    /* renamed from: b, reason: collision with root package name */
    public String f440082b;

    /* renamed from: c, reason: collision with root package name */
    public String f440083c;

    /* renamed from: d, reason: collision with root package name */
    public String f440084d;

    /* renamed from: e, reason: collision with root package name */
    public int f440085e;

    /* renamed from: f, reason: collision with root package name */
    public int f440086f;

    /* renamed from: g, reason: collision with root package name */
    public int f440087g;

    public h() {
        a();
    }

    public h a() {
        this.f440081a = "";
        this.f440082b = "";
        this.f440083c = "";
        this.f440084d = "";
        this.f440085e = 0;
        this.f440086f = 0;
        this.f440087g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440081a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f440082b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f440083c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f440084d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f440085e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f440086f = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440087g = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440081a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440081a);
        }
        if (!this.f440082b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440082b);
        }
        if (!this.f440083c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440083c);
        }
        if (!this.f440084d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440084d);
        }
        int i3 = this.f440085e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.f440086f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        int i17 = this.f440087g;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440081a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440081a);
        }
        if (!this.f440082b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440082b);
        }
        if (!this.f440083c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440083c);
        }
        if (!this.f440084d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440084d);
        }
        int i3 = this.f440085e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.f440086f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        int i17 = this.f440087g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
