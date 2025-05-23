package xp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile a[] f448295j;

    /* renamed from: a, reason: collision with root package name */
    public String f448296a;

    /* renamed from: b, reason: collision with root package name */
    public long f448297b;

    /* renamed from: c, reason: collision with root package name */
    public qp4.e f448298c;

    /* renamed from: d, reason: collision with root package name */
    public String f448299d;

    /* renamed from: e, reason: collision with root package name */
    public rp4.g f448300e;

    /* renamed from: f, reason: collision with root package name */
    public op4.g f448301f;

    /* renamed from: g, reason: collision with root package name */
    public int f448302g;

    /* renamed from: h, reason: collision with root package name */
    public int f448303h;

    /* renamed from: i, reason: collision with root package name */
    public int f448304i;

    public a() {
        a();
    }

    public static a[] b() {
        if (f448295j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448295j == null) {
                    f448295j = new a[0];
                }
            }
        }
        return f448295j;
    }

    public a a() {
        this.f448296a = "";
        this.f448297b = 0L;
        this.f448298c = null;
        this.f448299d = "";
        this.f448300e = null;
        this.f448301f = null;
        this.f448302g = 0;
        this.f448303h = 0;
        this.f448304i = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 56) {
                                            if (readTag != 72) {
                                                if (readTag != 80) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f448304i = codedInputByteBufferNano.readUInt32();
                                                }
                                            } else {
                                                this.f448303h = codedInputByteBufferNano.readUInt32();
                                            }
                                        } else {
                                            this.f448302g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        if (this.f448301f == null) {
                                            this.f448301f = new op4.g();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f448301f);
                                    }
                                } else {
                                    if (this.f448300e == null) {
                                        this.f448300e = new rp4.g();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f448300e);
                                }
                            } else {
                                this.f448299d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            if (this.f448298c == null) {
                                this.f448298c = new qp4.e();
                            }
                            codedInputByteBufferNano.readMessage(this.f448298c);
                        }
                    } else {
                        this.f448297b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f448296a = codedInputByteBufferNano.readString();
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
        if (!this.f448296a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f448296a);
        }
        long j3 = this.f448297b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        qp4.e eVar = this.f448298c;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
        }
        if (!this.f448299d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448299d);
        }
        rp4.g gVar = this.f448300e;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gVar);
        }
        op4.g gVar2 = this.f448301f;
        if (gVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, gVar2);
        }
        int i3 = this.f448302g;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        int i16 = this.f448303h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i16);
        }
        int i17 = this.f448304i;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f448296a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f448296a);
        }
        long j3 = this.f448297b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        qp4.e eVar = this.f448298c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        if (!this.f448299d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448299d);
        }
        rp4.g gVar = this.f448300e;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(5, gVar);
        }
        op4.g gVar2 = this.f448301f;
        if (gVar2 != null) {
            codedOutputByteBufferNano.writeMessage(6, gVar2);
        }
        int i3 = this.f448302g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        int i16 = this.f448303h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i16);
        }
        int i17 = this.f448304i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
