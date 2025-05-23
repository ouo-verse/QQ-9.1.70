package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: a, reason: collision with root package name */
    public ay[] f440460a;

    /* renamed from: b, reason: collision with root package name */
    public ar[] f440461b;

    /* renamed from: c, reason: collision with root package name */
    public ak f440462c;

    /* renamed from: d, reason: collision with root package name */
    public ap[] f440463d;

    /* renamed from: e, reason: collision with root package name */
    public at f440464e;

    /* renamed from: f, reason: collision with root package name */
    public au f440465f;

    /* renamed from: g, reason: collision with root package name */
    public int f440466g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f440467h;

    /* renamed from: i, reason: collision with root package name */
    public av f440468i;

    /* renamed from: j, reason: collision with root package name */
    public am[] f440469j;

    /* renamed from: k, reason: collision with root package name */
    public bi[] f440470k;

    /* renamed from: l, reason: collision with root package name */
    public af[] f440471l;

    public w() {
        a();
    }

    public static w c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (w) MessageNano.mergeFrom(new w(), bArr);
    }

    public w a() {
        this.f440460a = ay.b();
        this.f440461b = ar.b();
        this.f440462c = null;
        this.f440463d = ap.b();
        this.f440464e = null;
        this.f440465f = null;
        this.f440466g = 0;
        this.f440467h = WireFormatNano.EMPTY_INT_ARRAY;
        this.f440468i = null;
        this.f440469j = am.b();
        this.f440470k = bi.b();
        this.f440471l = af.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    ay[] ayVarArr = this.f440460a;
                    int length = ayVarArr == null ? 0 : ayVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    ay[] ayVarArr2 = new ay[i3];
                    if (length != 0) {
                        System.arraycopy(ayVarArr, 0, ayVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        ay ayVar = new ay();
                        ayVarArr2[length] = ayVar;
                        codedInputByteBufferNano.readMessage(ayVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ay ayVar2 = new ay();
                    ayVarArr2[length] = ayVar2;
                    codedInputByteBufferNano.readMessage(ayVar2);
                    this.f440460a = ayVarArr2;
                    break;
                case 18:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    ar[] arVarArr = this.f440461b;
                    int length2 = arVarArr == null ? 0 : arVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    ar[] arVarArr2 = new ar[i16];
                    if (length2 != 0) {
                        System.arraycopy(arVarArr, 0, arVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        ar arVar = new ar();
                        arVarArr2[length2] = arVar;
                        codedInputByteBufferNano.readMessage(arVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    ar arVar2 = new ar();
                    arVarArr2[length2] = arVar2;
                    codedInputByteBufferNano.readMessage(arVar2);
                    this.f440461b = arVarArr2;
                    break;
                case 26:
                    if (this.f440462c == null) {
                        this.f440462c = new ak();
                    }
                    codedInputByteBufferNano.readMessage(this.f440462c);
                    break;
                case 34:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    ap[] apVarArr = this.f440463d;
                    int length3 = apVarArr == null ? 0 : apVarArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    ap[] apVarArr2 = new ap[i17];
                    if (length3 != 0) {
                        System.arraycopy(apVarArr, 0, apVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        ap apVar = new ap();
                        apVarArr2[length3] = apVar;
                        codedInputByteBufferNano.readMessage(apVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    ap apVar2 = new ap();
                    apVarArr2[length3] = apVar2;
                    codedInputByteBufferNano.readMessage(apVar2);
                    this.f440463d = apVarArr2;
                    break;
                case 42:
                    if (this.f440464e == null) {
                        this.f440464e = new at();
                    }
                    codedInputByteBufferNano.readMessage(this.f440464e);
                    break;
                case 50:
                    if (this.f440465f == null) {
                        this.f440465f = new au();
                    }
                    codedInputByteBufferNano.readMessage(this.f440465f);
                    break;
                case 56:
                    this.f440466g = codedInputByteBufferNano.readInt32();
                    break;
                case 64:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 64);
                    int[] iArr = this.f440467h;
                    int length4 = iArr == null ? 0 : iArr.length;
                    int i18 = repeatedFieldArrayLength4 + length4;
                    int[] iArr2 = new int[i18];
                    if (length4 != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length4);
                    }
                    while (length4 < i18 - 1) {
                        iArr2[length4] = codedInputByteBufferNano.readInt32();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    iArr2[length4] = codedInputByteBufferNano.readInt32();
                    this.f440467h = iArr2;
                    break;
                case 66:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i19 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readInt32();
                        i19++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f440467h;
                    int length5 = iArr3 == null ? 0 : iArr3.length;
                    int i26 = i19 + length5;
                    int[] iArr4 = new int[i26];
                    if (length5 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length5);
                    }
                    while (length5 < i26) {
                        iArr4[length5] = codedInputByteBufferNano.readInt32();
                        length5++;
                    }
                    this.f440467h = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 74:
                    if (this.f440468i == null) {
                        this.f440468i = new av();
                    }
                    codedInputByteBufferNano.readMessage(this.f440468i);
                    break;
                case 82:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    am[] amVarArr = this.f440469j;
                    int length6 = amVarArr == null ? 0 : amVarArr.length;
                    int i27 = repeatedFieldArrayLength5 + length6;
                    am[] amVarArr2 = new am[i27];
                    if (length6 != 0) {
                        System.arraycopy(amVarArr, 0, amVarArr2, 0, length6);
                    }
                    while (length6 < i27 - 1) {
                        am amVar = new am();
                        amVarArr2[length6] = amVar;
                        codedInputByteBufferNano.readMessage(amVar);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    am amVar2 = new am();
                    amVarArr2[length6] = amVar2;
                    codedInputByteBufferNano.readMessage(amVar2);
                    this.f440469j = amVarArr2;
                    break;
                case 90:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    bi[] biVarArr = this.f440470k;
                    int length7 = biVarArr == null ? 0 : biVarArr.length;
                    int i28 = repeatedFieldArrayLength6 + length7;
                    bi[] biVarArr2 = new bi[i28];
                    if (length7 != 0) {
                        System.arraycopy(biVarArr, 0, biVarArr2, 0, length7);
                    }
                    while (length7 < i28 - 1) {
                        bi biVar = new bi();
                        biVarArr2[length7] = biVar;
                        codedInputByteBufferNano.readMessage(biVar);
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    bi biVar2 = new bi();
                    biVarArr2[length7] = biVar2;
                    codedInputByteBufferNano.readMessage(biVar2);
                    this.f440470k = biVarArr2;
                    break;
                case 98:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    af[] afVarArr = this.f440471l;
                    int length8 = afVarArr == null ? 0 : afVarArr.length;
                    int i29 = repeatedFieldArrayLength7 + length8;
                    af[] afVarArr2 = new af[i29];
                    if (length8 != 0) {
                        System.arraycopy(afVarArr, 0, afVarArr2, 0, length8);
                    }
                    while (length8 < i29 - 1) {
                        af afVar = new af();
                        afVarArr2[length8] = afVar;
                        codedInputByteBufferNano.readMessage(afVar);
                        codedInputByteBufferNano.readTag();
                        length8++;
                    }
                    af afVar2 = new af();
                    afVarArr2[length8] = afVar2;
                    codedInputByteBufferNano.readMessage(afVar2);
                    this.f440471l = afVarArr2;
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
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        ay[] ayVarArr = this.f440460a;
        int i3 = 0;
        if (ayVarArr != null && ayVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ay[] ayVarArr2 = this.f440460a;
                if (i16 >= ayVarArr2.length) {
                    break;
                }
                ay ayVar = ayVarArr2[i16];
                if (ayVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, ayVar);
                }
                i16++;
            }
        }
        ar[] arVarArr = this.f440461b;
        if (arVarArr != null && arVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                ar[] arVarArr2 = this.f440461b;
                if (i17 >= arVarArr2.length) {
                    break;
                }
                ar arVar = arVarArr2[i17];
                if (arVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, arVar);
                }
                i17++;
            }
        }
        ak akVar = this.f440462c;
        if (akVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, akVar);
        }
        ap[] apVarArr = this.f440463d;
        if (apVarArr != null && apVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                ap[] apVarArr2 = this.f440463d;
                if (i18 >= apVarArr2.length) {
                    break;
                }
                ap apVar = apVarArr2[i18];
                if (apVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, apVar);
                }
                i18++;
            }
        }
        at atVar = this.f440464e;
        if (atVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, atVar);
        }
        au auVar = this.f440465f;
        if (auVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, auVar);
        }
        int i19 = this.f440466g;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i19);
        }
        int[] iArr2 = this.f440467h;
        if (iArr2 != null && iArr2.length > 0) {
            int i26 = 0;
            int i27 = 0;
            while (true) {
                iArr = this.f440467h;
                if (i26 >= iArr.length) {
                    break;
                }
                i27 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i26]);
                i26++;
            }
            computeSerializedSize = computeSerializedSize + i27 + (iArr.length * 1);
        }
        av avVar = this.f440468i;
        if (avVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, avVar);
        }
        am[] amVarArr = this.f440469j;
        if (amVarArr != null && amVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                am[] amVarArr2 = this.f440469j;
                if (i28 >= amVarArr2.length) {
                    break;
                }
                am amVar = amVarArr2[i28];
                if (amVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, amVar);
                }
                i28++;
            }
        }
        bi[] biVarArr = this.f440470k;
        if (biVarArr != null && biVarArr.length > 0) {
            int i29 = 0;
            while (true) {
                bi[] biVarArr2 = this.f440470k;
                if (i29 >= biVarArr2.length) {
                    break;
                }
                bi biVar = biVarArr2[i29];
                if (biVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, biVar);
                }
                i29++;
            }
        }
        af[] afVarArr = this.f440471l;
        if (afVarArr != null && afVarArr.length > 0) {
            while (true) {
                af[] afVarArr2 = this.f440471l;
                if (i3 >= afVarArr2.length) {
                    break;
                }
                af afVar = afVarArr2[i3];
                if (afVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, afVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ay[] ayVarArr = this.f440460a;
        int i3 = 0;
        if (ayVarArr != null && ayVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ay[] ayVarArr2 = this.f440460a;
                if (i16 >= ayVarArr2.length) {
                    break;
                }
                ay ayVar = ayVarArr2[i16];
                if (ayVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, ayVar);
                }
                i16++;
            }
        }
        ar[] arVarArr = this.f440461b;
        if (arVarArr != null && arVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                ar[] arVarArr2 = this.f440461b;
                if (i17 >= arVarArr2.length) {
                    break;
                }
                ar arVar = arVarArr2[i17];
                if (arVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, arVar);
                }
                i17++;
            }
        }
        ak akVar = this.f440462c;
        if (akVar != null) {
            codedOutputByteBufferNano.writeMessage(3, akVar);
        }
        ap[] apVarArr = this.f440463d;
        if (apVarArr != null && apVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                ap[] apVarArr2 = this.f440463d;
                if (i18 >= apVarArr2.length) {
                    break;
                }
                ap apVar = apVarArr2[i18];
                if (apVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, apVar);
                }
                i18++;
            }
        }
        at atVar = this.f440464e;
        if (atVar != null) {
            codedOutputByteBufferNano.writeMessage(5, atVar);
        }
        au auVar = this.f440465f;
        if (auVar != null) {
            codedOutputByteBufferNano.writeMessage(6, auVar);
        }
        int i19 = this.f440466g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i19);
        }
        int[] iArr = this.f440467h;
        if (iArr != null && iArr.length > 0) {
            int i26 = 0;
            while (true) {
                int[] iArr2 = this.f440467h;
                if (i26 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(8, iArr2[i26]);
                i26++;
            }
        }
        av avVar = this.f440468i;
        if (avVar != null) {
            codedOutputByteBufferNano.writeMessage(9, avVar);
        }
        am[] amVarArr = this.f440469j;
        if (amVarArr != null && amVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                am[] amVarArr2 = this.f440469j;
                if (i27 >= amVarArr2.length) {
                    break;
                }
                am amVar = amVarArr2[i27];
                if (amVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, amVar);
                }
                i27++;
            }
        }
        bi[] biVarArr = this.f440470k;
        if (biVarArr != null && biVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                bi[] biVarArr2 = this.f440470k;
                if (i28 >= biVarArr2.length) {
                    break;
                }
                bi biVar = biVarArr2[i28];
                if (biVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, biVar);
                }
                i28++;
            }
        }
        af[] afVarArr = this.f440471l;
        if (afVarArr != null && afVarArr.length > 0) {
            while (true) {
                af[] afVarArr2 = this.f440471l;
                if (i3 >= afVarArr2.length) {
                    break;
                }
                af afVar = afVarArr2[i3];
                if (afVar != null) {
                    codedOutputByteBufferNano.writeMessage(12, afVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
