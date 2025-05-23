package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ah extends ExtendableMessageNano<ah> {

    /* renamed from: a, reason: collision with root package name */
    public long f432253a;

    /* renamed from: b, reason: collision with root package name */
    public int f432254b;

    /* renamed from: c, reason: collision with root package name */
    public String f432255c;

    /* renamed from: d, reason: collision with root package name */
    public long f432256d;

    /* renamed from: e, reason: collision with root package name */
    public String f432257e;

    /* renamed from: f, reason: collision with root package name */
    public long f432258f;

    /* renamed from: g, reason: collision with root package name */
    public int f432259g;

    /* renamed from: h, reason: collision with root package name */
    public String f432260h;

    /* renamed from: i, reason: collision with root package name */
    public String f432261i;

    public ah() {
        a();
    }

    public ah a() {
        this.f432253a = 0L;
        this.f432254b = 0;
        this.f432255c = "";
        this.f432256d = 0L;
        this.f432257e = "";
        this.f432258f = 0L;
        this.f432259g = 0;
        this.f432260h = "";
        this.f432261i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ah mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 40) {
                                if (readTag != 50) {
                                    if (readTag != 56) {
                                        if (readTag != 64) {
                                            if (readTag != 74) {
                                                if (readTag != 82) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f432261i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f432260h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f432259g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f432258f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f432257e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f432256d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f432255c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432254b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f432253a = codedInputByteBufferNano.readUInt64();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f432253a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f432254b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f432255c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432255c);
        }
        long j16 = this.f432256d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        if (!this.f432257e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f432257e);
        }
        long j17 = this.f432258f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        int i16 = this.f432259g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        if (!this.f432260h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f432260h);
        }
        if (!this.f432261i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f432261i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432253a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f432254b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f432255c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432255c);
        }
        long j16 = this.f432256d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        if (!this.f432257e.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f432257e);
        }
        long j17 = this.f432258f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        int i16 = this.f432259g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        if (!this.f432260h.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f432260h);
        }
        if (!this.f432261i.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f432261i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
