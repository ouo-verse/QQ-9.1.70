package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f448747a;

    /* renamed from: b, reason: collision with root package name */
    public int f448748b;

    /* renamed from: c, reason: collision with root package name */
    public String f448749c;

    /* renamed from: d, reason: collision with root package name */
    public String f448750d;

    /* renamed from: e, reason: collision with root package name */
    public String f448751e;

    /* renamed from: f, reason: collision with root package name */
    public z[] f448752f;

    /* renamed from: g, reason: collision with root package name */
    public int f448753g;

    /* renamed from: h, reason: collision with root package name */
    public long f448754h;

    /* renamed from: i, reason: collision with root package name */
    public long f448755i;

    /* renamed from: j, reason: collision with root package name */
    public f[] f448756j;

    /* renamed from: k, reason: collision with root package name */
    public long f448757k;

    /* renamed from: l, reason: collision with root package name */
    public int f448758l;

    /* renamed from: m, reason: collision with root package name */
    public String f448759m;

    /* renamed from: n, reason: collision with root package name */
    public String f448760n;

    /* renamed from: o, reason: collision with root package name */
    public ab[] f448761o;

    /* renamed from: p, reason: collision with root package name */
    public ab[] f448762p;

    /* renamed from: q, reason: collision with root package name */
    public String f448763q;

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
                    this.f448747a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f448748b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f448749c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f448750d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f448751e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    z[] zVarArr = this.f448752f;
                    int length = zVarArr == null ? 0 : zVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    z[] zVarArr2 = new z[i3];
                    if (length != 0) {
                        System.arraycopy(zVarArr, 0, zVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        z zVar = new z();
                        zVarArr2[length] = zVar;
                        codedInputByteBufferNano.readMessage(zVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    z zVar2 = new z();
                    zVarArr2[length] = zVar2;
                    codedInputByteBufferNano.readMessage(zVar2);
                    this.f448752f = zVarArr2;
                    break;
                case 56:
                    this.f448753g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f448754h = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.f448755i = codedInputByteBufferNano.readUInt64();
                    break;
                case 82:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    f[] fVarArr = this.f448756j;
                    int length2 = fVarArr == null ? 0 : fVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    f[] fVarArr2 = new f[i16];
                    if (length2 != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        f fVar = new f();
                        fVarArr2[length2] = fVar;
                        codedInputByteBufferNano.readMessage(fVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    f fVar2 = new f();
                    fVarArr2[length2] = fVar2;
                    codedInputByteBufferNano.readMessage(fVar2);
                    this.f448756j = fVarArr2;
                    break;
                case 88:
                    this.f448757k = codedInputByteBufferNano.readUInt64();
                    break;
                case 96:
                    this.f448758l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.f448759m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f448760n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    ab[] abVarArr = this.f448761o;
                    int length3 = abVarArr == null ? 0 : abVarArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    ab[] abVarArr2 = new ab[i17];
                    if (length3 != 0) {
                        System.arraycopy(abVarArr, 0, abVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        ab abVar = new ab();
                        abVarArr2[length3] = abVar;
                        codedInputByteBufferNano.readMessage(abVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    ab abVar2 = new ab();
                    abVarArr2[length3] = abVar2;
                    codedInputByteBufferNano.readMessage(abVar2);
                    this.f448761o = abVarArr2;
                    break;
                case 130:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                    ab[] abVarArr3 = this.f448762p;
                    int length4 = abVarArr3 == null ? 0 : abVarArr3.length;
                    int i18 = repeatedFieldArrayLength4 + length4;
                    ab[] abVarArr4 = new ab[i18];
                    if (length4 != 0) {
                        System.arraycopy(abVarArr3, 0, abVarArr4, 0, length4);
                    }
                    while (length4 < i18 - 1) {
                        ab abVar3 = new ab();
                        abVarArr4[length4] = abVar3;
                        codedInputByteBufferNano.readMessage(abVar3);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    ab abVar4 = new ab();
                    abVarArr4[length4] = abVar4;
                    codedInputByteBufferNano.readMessage(abVar4);
                    this.f448762p = abVarArr4;
                    break;
                case 138:
                    this.f448763q = codedInputByteBufferNano.readString();
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
        long j3 = this.f448747a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f448748b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f448749c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448749c);
        }
        if (!this.f448750d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448750d);
        }
        if (!this.f448751e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f448751e);
        }
        z[] zVarArr = this.f448752f;
        int i16 = 0;
        if (zVarArr != null && zVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                z[] zVarArr2 = this.f448752f;
                if (i17 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i17];
                if (zVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, zVar);
                }
                i17++;
            }
        }
        int i18 = this.f448753g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        long j16 = this.f448754h;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        long j17 = this.f448755i;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j17);
        }
        f[] fVarArr = this.f448756j;
        if (fVarArr != null && fVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                f[] fVarArr2 = this.f448756j;
                if (i19 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i19];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, fVar);
                }
                i19++;
            }
        }
        long j18 = this.f448757k;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j18);
        }
        int i26 = this.f448758l;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i26);
        }
        if (!this.f448759m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f448759m);
        }
        if (!this.f448760n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f448760n);
        }
        ab[] abVarArr = this.f448761o;
        if (abVarArr != null && abVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448761o;
                if (i27 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i27];
                if (abVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, abVar);
                }
                i27++;
            }
        }
        ab[] abVarArr3 = this.f448762p;
        if (abVarArr3 != null && abVarArr3.length > 0) {
            while (true) {
                ab[] abVarArr4 = this.f448762p;
                if (i16 >= abVarArr4.length) {
                    break;
                }
                ab abVar2 = abVarArr4[i16];
                if (abVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, abVar2);
                }
                i16++;
            }
        }
        return !this.f448763q.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.f448763q) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448747a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f448748b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f448749c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448749c);
        }
        if (!this.f448750d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448750d);
        }
        if (!this.f448751e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f448751e);
        }
        z[] zVarArr = this.f448752f;
        int i16 = 0;
        if (zVarArr != null && zVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                z[] zVarArr2 = this.f448752f;
                if (i17 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i17];
                if (zVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, zVar);
                }
                i17++;
            }
        }
        int i18 = this.f448753g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        long j16 = this.f448754h;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        long j17 = this.f448755i;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j17);
        }
        f[] fVarArr = this.f448756j;
        if (fVarArr != null && fVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                f[] fVarArr2 = this.f448756j;
                if (i19 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i19];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, fVar);
                }
                i19++;
            }
        }
        long j18 = this.f448757k;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j18);
        }
        int i26 = this.f448758l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i26);
        }
        if (!this.f448759m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f448759m);
        }
        if (!this.f448760n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f448760n);
        }
        ab[] abVarArr = this.f448761o;
        if (abVarArr != null && abVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448761o;
                if (i27 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i27];
                if (abVar != null) {
                    codedOutputByteBufferNano.writeMessage(15, abVar);
                }
                i27++;
            }
        }
        ab[] abVarArr3 = this.f448762p;
        if (abVarArr3 != null && abVarArr3.length > 0) {
            while (true) {
                ab[] abVarArr4 = this.f448762p;
                if (i16 >= abVarArr4.length) {
                    break;
                }
                ab abVar2 = abVarArr4[i16];
                if (abVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(16, abVar2);
                }
                i16++;
            }
        }
        if (!this.f448763q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f448763q);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f448747a = 0L;
        this.f448748b = 0;
        this.f448749c = "";
        this.f448750d = "";
        this.f448751e = "";
        this.f448752f = z.b();
        this.f448753g = 0;
        this.f448754h = 0L;
        this.f448755i = 0L;
        this.f448756j = f.b();
        this.f448757k = 0L;
        this.f448758l = 0;
        this.f448759m = "";
        this.f448760n = "";
        this.f448761o = ab.b();
        this.f448762p = ab.b();
        this.f448763q = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
