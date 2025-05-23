package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: q, reason: collision with root package name */
    private static volatile b[] f427401q;

    /* renamed from: a, reason: collision with root package name */
    public long f427402a;

    /* renamed from: b, reason: collision with root package name */
    public int f427403b;

    /* renamed from: c, reason: collision with root package name */
    public String f427404c;

    /* renamed from: d, reason: collision with root package name */
    public g f427405d;

    /* renamed from: e, reason: collision with root package name */
    public g f427406e;

    /* renamed from: f, reason: collision with root package name */
    public String f427407f;

    /* renamed from: g, reason: collision with root package name */
    public int f427408g;

    /* renamed from: h, reason: collision with root package name */
    public String f427409h;

    /* renamed from: i, reason: collision with root package name */
    public c f427410i;

    /* renamed from: j, reason: collision with root package name */
    public g f427411j;

    /* renamed from: k, reason: collision with root package name */
    public int f427412k;

    /* renamed from: l, reason: collision with root package name */
    public String f427413l;

    /* renamed from: m, reason: collision with root package name */
    public int f427414m;

    /* renamed from: n, reason: collision with root package name */
    public String f427415n;

    /* renamed from: o, reason: collision with root package name */
    public String f427416o;

    /* renamed from: p, reason: collision with root package name */
    public long f427417p;

    public b() {
        a();
    }

    public static b[] b() {
        if (f427401q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427401q == null) {
                    f427401q = new b[0];
                }
            }
        }
        return f427401q;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f427402a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f427403b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f427404c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.f427405d == null) {
                        this.f427405d = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f427405d);
                    break;
                case 42:
                    if (this.f427406e == null) {
                        this.f427406e = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f427406e);
                    break;
                case 50:
                    this.f427407f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f427408g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.f427409h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    if (this.f427410i == null) {
                        this.f427410i = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f427410i);
                    break;
                case 82:
                    if (this.f427411j == null) {
                        this.f427411j = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f427411j);
                    break;
                case 88:
                    this.f427412k = codedInputByteBufferNano.readInt32();
                    break;
                case 98:
                    this.f427413l = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.f427414m = codedInputByteBufferNano.readInt32();
                    break;
                case 114:
                    this.f427415n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f427416o = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.f427417p = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f427402a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f427403b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f427404c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427404c);
        }
        g gVar = this.f427405d;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, gVar);
        }
        g gVar2 = this.f427406e;
        if (gVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gVar2);
        }
        if (!this.f427407f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427407f);
        }
        int i16 = this.f427408g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        if (!this.f427409h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f427409h);
        }
        c cVar = this.f427410i;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, cVar);
        }
        g gVar3 = this.f427411j;
        if (gVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, gVar3);
        }
        int i17 = this.f427412k;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i17);
        }
        if (!this.f427413l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f427413l);
        }
        int i18 = this.f427414m;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i18);
        }
        if (!this.f427415n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f427415n);
        }
        if (!this.f427416o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f427416o);
        }
        long j16 = this.f427417p;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(16, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427402a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f427403b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f427404c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427404c);
        }
        g gVar = this.f427405d;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(4, gVar);
        }
        g gVar2 = this.f427406e;
        if (gVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, gVar2);
        }
        if (!this.f427407f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427407f);
        }
        int i16 = this.f427408g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        if (!this.f427409h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f427409h);
        }
        c cVar = this.f427410i;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(9, cVar);
        }
        g gVar3 = this.f427411j;
        if (gVar3 != null) {
            codedOutputByteBufferNano.writeMessage(10, gVar3);
        }
        int i17 = this.f427412k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i17);
        }
        if (!this.f427413l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f427413l);
        }
        int i18 = this.f427414m;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i18);
        }
        if (!this.f427415n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f427415n);
        }
        if (!this.f427416o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f427416o);
        }
        long j16 = this.f427417p;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f427402a = 0L;
        this.f427403b = 0;
        this.f427404c = "";
        this.f427405d = null;
        this.f427406e = null;
        this.f427407f = "";
        this.f427408g = 0;
        this.f427409h = "";
        this.f427410i = null;
        this.f427411j = null;
        this.f427412k = 0;
        this.f427413l = "";
        this.f427414m = 0;
        this.f427415n = "";
        this.f427416o = "";
        this.f427417p = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
