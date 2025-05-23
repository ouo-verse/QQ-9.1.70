package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile o[] f449448h;

    /* renamed from: a, reason: collision with root package name */
    public String f449449a;

    /* renamed from: b, reason: collision with root package name */
    public String f449450b;

    /* renamed from: c, reason: collision with root package name */
    public h f449451c;

    /* renamed from: d, reason: collision with root package name */
    public int f449452d;

    /* renamed from: e, reason: collision with root package name */
    public long f449453e;

    /* renamed from: f, reason: collision with root package name */
    public String f449454f;

    /* renamed from: g, reason: collision with root package name */
    public int f449455g;

    public o() {
        a();
    }

    public static o[] b() {
        if (f449448h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f449448h == null) {
                    f449448h = new o[0];
                }
            }
        }
        return f449448h;
    }

    public o a() {
        this.f449449a = "";
        this.f449450b = "";
        this.f449451c = null;
        this.f449452d = 0;
        this.f449453e = 0L;
        this.f449454f = "";
        this.f449455g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f449455g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f449454f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f449453e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f449452d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            if (this.f449451c == null) {
                                this.f449451c = new h();
                            }
                            codedInputByteBufferNano.readMessage(this.f449451c);
                        }
                    } else {
                        this.f449450b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f449449a = codedInputByteBufferNano.readString();
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
        if (!this.f449449a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f449449a);
        }
        if (!this.f449450b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f449450b);
        }
        h hVar = this.f449451c;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar);
        }
        int i3 = this.f449452d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        long j3 = this.f449453e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!this.f449454f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f449454f);
        }
        int i16 = this.f449455g;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f449449a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f449449a);
        }
        if (!this.f449450b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f449450b);
        }
        h hVar = this.f449451c;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(3, hVar);
        }
        int i3 = this.f449452d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        long j3 = this.f449453e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!this.f449454f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f449454f);
        }
        int i16 = this.f449455g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
