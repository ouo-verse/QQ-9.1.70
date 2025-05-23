package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public long f451510a;

    /* renamed from: b, reason: collision with root package name */
    public long f451511b;

    /* renamed from: c, reason: collision with root package name */
    public String f451512c;

    /* renamed from: d, reason: collision with root package name */
    public String f451513d;

    /* renamed from: e, reason: collision with root package name */
    public int f451514e;

    /* renamed from: f, reason: collision with root package name */
    public q f451515f;

    /* renamed from: g, reason: collision with root package name */
    public int f451516g;

    /* renamed from: h, reason: collision with root package name */
    public int f451517h;

    /* renamed from: i, reason: collision with root package name */
    public String f451518i;

    /* renamed from: j, reason: collision with root package name */
    public String f451519j;

    public p() {
        a();
    }

    public p a() {
        this.f451510a = 0L;
        this.f451511b = 0L;
        this.f451512c = "";
        this.f451513d = "";
        this.f451514e = 0;
        this.f451515f = null;
        this.f451516g = 0;
        this.f451517h = 0;
        this.f451518i = "";
        this.f451519j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f451510a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f451511b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f451512c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f451513d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f451514e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    if (this.f451515f == null) {
                        this.f451515f = new q();
                    }
                    codedInputByteBufferNano.readMessage(this.f451515f);
                    break;
                case 56:
                    this.f451516g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f451517h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f451518i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f451519j = codedInputByteBufferNano.readString();
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
        long j3 = this.f451510a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f451511b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f451512c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451512c);
        }
        if (!this.f451513d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f451513d);
        }
        int i3 = this.f451514e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        q qVar = this.f451515f;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, qVar);
        }
        int i16 = this.f451516g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.f451517h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        if (!this.f451518i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f451518i);
        }
        if (!this.f451519j.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f451519j);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f451510a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f451511b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f451512c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451512c);
        }
        if (!this.f451513d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451513d);
        }
        int i3 = this.f451514e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        q qVar = this.f451515f;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(6, qVar);
        }
        int i16 = this.f451516g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.f451517h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        if (!this.f451518i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f451518i);
        }
        if (!this.f451519j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f451519j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
