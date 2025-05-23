package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public long f432337a;

    /* renamed from: b, reason: collision with root package name */
    public long f432338b;

    /* renamed from: c, reason: collision with root package name */
    public String f432339c;

    /* renamed from: d, reason: collision with root package name */
    public String f432340d;

    /* renamed from: e, reason: collision with root package name */
    public String f432341e;

    /* renamed from: f, reason: collision with root package name */
    public int f432342f;

    /* renamed from: g, reason: collision with root package name */
    public String f432343g;

    /* renamed from: h, reason: collision with root package name */
    public long f432344h;

    /* renamed from: i, reason: collision with root package name */
    public String f432345i;

    /* renamed from: j, reason: collision with root package name */
    public String f432346j;

    /* renamed from: k, reason: collision with root package name */
    public String f432347k;

    /* renamed from: l, reason: collision with root package name */
    public o[] f432348l;

    /* renamed from: m, reason: collision with root package name */
    public j[] f432349m;

    /* renamed from: n, reason: collision with root package name */
    public x f432350n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f432351o;

    public q() {
        a();
    }

    public q a() {
        this.f432337a = 0L;
        this.f432338b = 0L;
        this.f432339c = "";
        this.f432340d = "";
        this.f432341e = "";
        this.f432342f = 0;
        this.f432343g = "";
        this.f432344h = 0L;
        this.f432345i = "";
        this.f432346j = "";
        this.f432347k = "";
        this.f432348l = o.b();
        this.f432349m = j.b();
        this.f432350n = null;
        this.f432351o = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f432337a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f432338b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f432339c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f432340d = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f432341e = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f432342f = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f432343g = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.f432344h = codedInputByteBufferNano.readInt64();
                    break;
                case 146:
                    this.f432345i = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.f432346j = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.f432347k = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 178);
                    o[] oVarArr = this.f432348l;
                    if (oVarArr == null) {
                        length = 0;
                    } else {
                        length = oVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    o[] oVarArr2 = new o[i3];
                    if (length != 0) {
                        System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        o oVar = new o();
                        oVarArr2[length] = oVar;
                        codedInputByteBufferNano.readMessage(oVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    o oVar2 = new o();
                    oVarArr2[length] = oVar2;
                    codedInputByteBufferNano.readMessage(oVar2);
                    this.f432348l = oVarArr2;
                    break;
                case 186:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                    j[] jVarArr = this.f432349m;
                    if (jVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = jVarArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    j[] jVarArr2 = new j[i16];
                    if (length2 != 0) {
                        System.arraycopy(jVarArr, 0, jVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        j jVar = new j();
                        jVarArr2[length2] = jVar;
                        codedInputByteBufferNano.readMessage(jVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    j jVar2 = new j();
                    jVarArr2[length2] = jVar2;
                    codedInputByteBufferNano.readMessage(jVar2);
                    this.f432349m = jVarArr2;
                    break;
                case 194:
                    if (this.f432350n == null) {
                        this.f432350n = new x();
                    }
                    codedInputByteBufferNano.readMessage(this.f432350n);
                    break;
                case 200:
                    this.f432351o = codedInputByteBufferNano.readBool();
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
        long j3 = this.f432337a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f432338b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f432339c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432339c);
        }
        if (!this.f432340d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f432340d);
        }
        if (!this.f432341e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f432341e);
        }
        int i3 = this.f432342f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        if (!this.f432343g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f432343g);
        }
        long j17 = this.f432344h;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(16, j17);
        }
        if (!this.f432345i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f432345i);
        }
        if (!this.f432346j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.f432346j);
        }
        if (!this.f432347k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.f432347k);
        }
        o[] oVarArr = this.f432348l;
        int i16 = 0;
        if (oVarArr != null && oVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                o[] oVarArr2 = this.f432348l;
                if (i17 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i17];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, oVar);
                }
                i17++;
            }
        }
        j[] jVarArr = this.f432349m;
        if (jVarArr != null && jVarArr.length > 0) {
            while (true) {
                j[] jVarArr2 = this.f432349m;
                if (i16 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i16];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, jVar);
                }
                i16++;
            }
        }
        x xVar = this.f432350n;
        if (xVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, xVar);
        }
        boolean z16 = this.f432351o;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(25, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432337a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f432338b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f432339c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432339c);
        }
        if (!this.f432340d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432340d);
        }
        if (!this.f432341e.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f432341e);
        }
        int i3 = this.f432342f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        if (!this.f432343g.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f432343g);
        }
        long j17 = this.f432344h;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(16, j17);
        }
        if (!this.f432345i.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f432345i);
        }
        if (!this.f432346j.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.f432346j);
        }
        if (!this.f432347k.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.f432347k);
        }
        o[] oVarArr = this.f432348l;
        int i16 = 0;
        if (oVarArr != null && oVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                o[] oVarArr2 = this.f432348l;
                if (i17 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i17];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(22, oVar);
                }
                i17++;
            }
        }
        j[] jVarArr = this.f432349m;
        if (jVarArr != null && jVarArr.length > 0) {
            while (true) {
                j[] jVarArr2 = this.f432349m;
                if (i16 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i16];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(23, jVar);
                }
                i16++;
            }
        }
        x xVar = this.f432350n;
        if (xVar != null) {
            codedOutputByteBufferNano.writeMessage(24, xVar);
        }
        boolean z16 = this.f432351o;
        if (z16) {
            codedOutputByteBufferNano.writeBool(25, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
