package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: a, reason: collision with root package name */
    public int f427525a;

    /* renamed from: b, reason: collision with root package name */
    public int f427526b;

    /* renamed from: c, reason: collision with root package name */
    public int f427527c;

    /* renamed from: d, reason: collision with root package name */
    public String f427528d;

    /* renamed from: e, reason: collision with root package name */
    public int f427529e;

    /* renamed from: f, reason: collision with root package name */
    public String f427530f;

    /* renamed from: g, reason: collision with root package name */
    public String f427531g;

    public u() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427525a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f427526b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f427527c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f427528d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f427529e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 50) {
                this.f427530f = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427531g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427525a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f427526b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f427527c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        if (!this.f427528d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427528d);
        }
        int i18 = this.f427529e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i18);
        }
        if (!this.f427530f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427530f);
        }
        return !this.f427531g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f427531g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427525a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f427526b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f427527c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        if (!this.f427528d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427528d);
        }
        int i18 = this.f427529e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i18);
        }
        if (!this.f427530f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427530f);
        }
        if (!this.f427531g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427531g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public u a() {
        this.f427525a = 0;
        this.f427526b = 0;
        this.f427527c = 0;
        this.f427528d = "";
        this.f427529e = 0;
        this.f427530f = "";
        this.f427531g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
