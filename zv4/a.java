package zv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f453553a;

    /* renamed from: b, reason: collision with root package name */
    public int f453554b;

    /* renamed from: c, reason: collision with root package name */
    public long f453555c;

    /* renamed from: d, reason: collision with root package name */
    public long f453556d;

    /* renamed from: e, reason: collision with root package name */
    public String f453557e;

    /* renamed from: f, reason: collision with root package name */
    public String f453558f;

    /* renamed from: g, reason: collision with root package name */
    public String f453559g;

    /* renamed from: h, reason: collision with root package name */
    public int f453560h;

    /* renamed from: i, reason: collision with root package name */
    public int f453561i;

    /* renamed from: j, reason: collision with root package name */
    public b f453562j;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                        break;
                    } else {
                        this.f453553a = readInt32;
                        break;
                    }
                case 16:
                    this.f453554b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f453555c = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.f453556d = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.f453557e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f453558f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f453559g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f453560h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    switch (readInt322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            this.f453561i = readInt322;
                            break;
                    }
                case 82:
                    if (this.f453562j == null) {
                        this.f453562j = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f453562j);
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f453553a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f453554b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        long j3 = this.f453555c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j16 = this.f453556d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        if (!this.f453557e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f453557e);
        }
        if (!this.f453558f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f453558f);
        }
        if (!this.f453559g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f453559g);
        }
        int i17 = this.f453560h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        int i18 = this.f453561i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i18);
        }
        b bVar = this.f453562j;
        return bVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, bVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f453553a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f453554b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        long j3 = this.f453555c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j16 = this.f453556d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        if (!this.f453557e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f453557e);
        }
        if (!this.f453558f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f453558f);
        }
        if (!this.f453559g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f453559g);
        }
        int i17 = this.f453560h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        int i18 = this.f453561i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i18);
        }
        b bVar = this.f453562j;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(10, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f453553a = 0;
        this.f453554b = 0;
        this.f453555c = 0L;
        this.f453556d = 0L;
        this.f453557e = "";
        this.f453558f = "";
        this.f453559g = "";
        this.f453560h = 0;
        this.f453561i = 0;
        this.f453562j = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
