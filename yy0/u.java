package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: a, reason: collision with root package name */
    public long f451534a;

    /* renamed from: b, reason: collision with root package name */
    public int f451535b;

    /* renamed from: c, reason: collision with root package name */
    public String f451536c;

    /* renamed from: d, reason: collision with root package name */
    public long f451537d;

    /* renamed from: e, reason: collision with root package name */
    public String f451538e;

    /* renamed from: f, reason: collision with root package name */
    public long f451539f;

    /* renamed from: g, reason: collision with root package name */
    public int f451540g;

    /* renamed from: h, reason: collision with root package name */
    public String f451541h;

    /* renamed from: i, reason: collision with root package name */
    public String f451542i;

    public u() {
        a();
    }

    public u a() {
        this.f451534a = 0L;
        this.f451535b = 0;
        this.f451536c = "";
        this.f451537d = 0L;
        this.f451538e = "";
        this.f451539f = 0L;
        this.f451540g = 0;
        this.f451541h = "";
        this.f451542i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                                                    this.f451542i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f451541h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f451540g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f451539f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f451538e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f451537d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f451536c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451535b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f451534a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f451534a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f451535b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f451536c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451536c);
        }
        long j16 = this.f451537d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        if (!this.f451538e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f451538e);
        }
        long j17 = this.f451539f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        int i16 = this.f451540g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        if (!this.f451541h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f451541h);
        }
        if (!this.f451542i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f451542i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f451534a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f451535b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f451536c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451536c);
        }
        long j16 = this.f451537d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        if (!this.f451538e.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f451538e);
        }
        long j17 = this.f451539f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        int i16 = this.f451540g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        if (!this.f451541h.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f451541h);
        }
        if (!this.f451542i.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f451542i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
