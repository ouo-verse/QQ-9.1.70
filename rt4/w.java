package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: a, reason: collision with root package name */
    public int f432466a;

    /* renamed from: b, reason: collision with root package name */
    public int f432467b;

    /* renamed from: c, reason: collision with root package name */
    public v f432468c;

    /* renamed from: d, reason: collision with root package name */
    public int f432469d;

    /* renamed from: e, reason: collision with root package name */
    public int f432470e;

    /* renamed from: f, reason: collision with root package name */
    public String f432471f;

    /* renamed from: g, reason: collision with root package name */
    public int f432472g;

    public w() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f432466a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f432467b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                if (this.f432468c == null) {
                    this.f432468c = new v();
                }
                codedInputByteBufferNano.readMessage(this.f432468c);
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f432469d = readInt32;
                }
            } else if (readTag == 40) {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3) {
                    this.f432470e = readInt322;
                }
            } else if (readTag == 50) {
                this.f432471f = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt323 = codedInputByteBufferNano.readInt32();
                if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2) {
                    this.f432472g = readInt323;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f432466a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f432467b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        v vVar = this.f432468c;
        if (vVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, vVar);
        }
        int i17 = this.f432469d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        int i18 = this.f432470e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i18);
        }
        if (!this.f432471f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f432471f);
        }
        int i19 = this.f432472g;
        return i19 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i19) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432466a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f432467b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        v vVar = this.f432468c;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(3, vVar);
        }
        int i17 = this.f432469d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        int i18 = this.f432470e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i18);
        }
        if (!this.f432471f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f432471f);
        }
        int i19 = this.f432472g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public w a() {
        this.f432466a = 0;
        this.f432467b = 0;
        this.f432468c = null;
        this.f432469d = 0;
        this.f432470e = 0;
        this.f432471f = "";
        this.f432472g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
