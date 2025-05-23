package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class y extends ExtendableMessageNano<y> {

    /* renamed from: q, reason: collision with root package name */
    private static volatile y[] f427727q;

    /* renamed from: a, reason: collision with root package name */
    public int f427728a;

    /* renamed from: b, reason: collision with root package name */
    public int f427729b;

    /* renamed from: c, reason: collision with root package name */
    public int f427730c;

    /* renamed from: d, reason: collision with root package name */
    public String f427731d;

    /* renamed from: e, reason: collision with root package name */
    public String f427732e;

    /* renamed from: f, reason: collision with root package name */
    public String f427733f;

    /* renamed from: g, reason: collision with root package name */
    public long f427734g;

    /* renamed from: h, reason: collision with root package name */
    public int f427735h;

    /* renamed from: i, reason: collision with root package name */
    public int f427736i;

    /* renamed from: j, reason: collision with root package name */
    public String f427737j;

    /* renamed from: k, reason: collision with root package name */
    public String f427738k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f427739l;

    /* renamed from: m, reason: collision with root package name */
    public String f427740m;

    /* renamed from: n, reason: collision with root package name */
    public b f427741n;

    /* renamed from: o, reason: collision with root package name */
    public e f427742o;

    /* renamed from: p, reason: collision with root package name */
    public int f427743p;

    public y() {
        a();
    }

    public static y[] b() {
        if (f427727q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427727q == null) {
                    f427727q = new y[0];
                }
            }
        }
        return f427727q;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f427728a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f427729b = readInt32;
                        break;
                    }
                case 24:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.f427730c = readInt322;
                        break;
                    }
                case 34:
                    this.f427731d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f427732e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f427733f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f427734g = codedInputByteBufferNano.readInt64();
                    break;
                case 64:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2) {
                        break;
                    } else {
                        this.f427735h = readInt323;
                        break;
                    }
                case 72:
                    int readInt324 = codedInputByteBufferNano.readInt32();
                    if (readInt324 != 0 && readInt324 != 1 && readInt324 != 2 && readInt324 != 3 && readInt324 != 4) {
                        switch (readInt324) {
                        }
                    }
                    this.f427736i = readInt324;
                    break;
                case 82:
                    this.f427737j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f427738k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f427739l = codedInputByteBufferNano.readBool();
                    break;
                case 106:
                    this.f427740m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    if (this.f427741n == null) {
                        this.f427741n = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f427741n);
                    break;
                case 122:
                    if (this.f427742o == null) {
                        this.f427742o = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f427742o);
                    break;
                case 128:
                    int readInt325 = codedInputByteBufferNano.readInt32();
                    if (readInt325 != 0 && readInt325 != 1) {
                        break;
                    } else {
                        this.f427743p = readInt325;
                        break;
                    }
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
        int i3 = this.f427728a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f427729b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f427730c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        if (!this.f427731d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427731d);
        }
        if (!this.f427732e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427732e);
        }
        if (!this.f427733f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427733f);
        }
        long j3 = this.f427734g;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j3);
        }
        int i18 = this.f427735h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i18);
        }
        int i19 = this.f427736i;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i19);
        }
        if (!this.f427737j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f427737j);
        }
        if (!this.f427738k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f427738k);
        }
        boolean z16 = this.f427739l;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z16);
        }
        if (!this.f427740m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f427740m);
        }
        b bVar = this.f427741n;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, bVar);
        }
        e eVar = this.f427742o;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, eVar);
        }
        int i26 = this.f427743p;
        return i26 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(16, i26) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427728a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f427729b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f427730c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        if (!this.f427731d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427731d);
        }
        if (!this.f427732e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427732e);
        }
        if (!this.f427733f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427733f);
        }
        long j3 = this.f427734g;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j3);
        }
        int i18 = this.f427735h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        int i19 = this.f427736i;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i19);
        }
        if (!this.f427737j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f427737j);
        }
        if (!this.f427738k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f427738k);
        }
        boolean z16 = this.f427739l;
        if (z16) {
            codedOutputByteBufferNano.writeBool(12, z16);
        }
        if (!this.f427740m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f427740m);
        }
        b bVar = this.f427741n;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(14, bVar);
        }
        e eVar = this.f427742o;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(15, eVar);
        }
        int i26 = this.f427743p;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public y a() {
        this.f427728a = 0;
        this.f427729b = 0;
        this.f427730c = 0;
        this.f427731d = "";
        this.f427732e = "";
        this.f427733f = "";
        this.f427734g = 0L;
        this.f427735h = 0;
        this.f427736i = 0;
        this.f427737j = "";
        this.f427738k = "";
        this.f427739l = false;
        this.f427740m = "";
        this.f427741n = null;
        this.f427742o = null;
        this.f427743p = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
