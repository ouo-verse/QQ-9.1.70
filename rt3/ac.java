package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ac extends ExtendableMessageNano<ac> {

    /* renamed from: a, reason: collision with root package name */
    public long f432229a;

    /* renamed from: b, reason: collision with root package name */
    public long f432230b;

    /* renamed from: c, reason: collision with root package name */
    public String f432231c;

    /* renamed from: d, reason: collision with root package name */
    public String f432232d;

    /* renamed from: e, reason: collision with root package name */
    public int f432233e;

    /* renamed from: f, reason: collision with root package name */
    public ad f432234f;

    /* renamed from: g, reason: collision with root package name */
    public int f432235g;

    /* renamed from: h, reason: collision with root package name */
    public int f432236h;

    /* renamed from: i, reason: collision with root package name */
    public String f432237i;

    /* renamed from: j, reason: collision with root package name */
    public String f432238j;

    public ac() {
        a();
    }

    public ac a() {
        this.f432229a = 0L;
        this.f432230b = 0L;
        this.f432231c = "";
        this.f432232d = "";
        this.f432233e = 0;
        this.f432234f = null;
        this.f432235g = 0;
        this.f432236h = 0;
        this.f432237i = "";
        this.f432238j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ac mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f432229a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f432230b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f432231c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f432232d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f432233e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    if (this.f432234f == null) {
                        this.f432234f = new ad();
                    }
                    codedInputByteBufferNano.readMessage(this.f432234f);
                    break;
                case 56:
                    this.f432235g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f432236h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f432237i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f432238j = codedInputByteBufferNano.readString();
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
        long j3 = this.f432229a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f432230b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f432231c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432231c);
        }
        if (!this.f432232d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f432232d);
        }
        int i3 = this.f432233e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        ad adVar = this.f432234f;
        if (adVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, adVar);
        }
        int i16 = this.f432235g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.f432236h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        if (!this.f432237i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f432237i);
        }
        if (!this.f432238j.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f432238j);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432229a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f432230b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f432231c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432231c);
        }
        if (!this.f432232d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432232d);
        }
        int i3 = this.f432233e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        ad adVar = this.f432234f;
        if (adVar != null) {
            codedOutputByteBufferNano.writeMessage(6, adVar);
        }
        int i16 = this.f432235g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.f432236h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        if (!this.f432237i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f432237i);
        }
        if (!this.f432238j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f432238j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
