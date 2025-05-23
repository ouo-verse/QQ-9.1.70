package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public ag[] f448613a;

    /* renamed from: b, reason: collision with root package name */
    public int f448614b;

    /* renamed from: c, reason: collision with root package name */
    public int f448615c;

    /* renamed from: d, reason: collision with root package name */
    public int f448616d;

    /* renamed from: e, reason: collision with root package name */
    public int f448617e;

    /* renamed from: f, reason: collision with root package name */
    public ah[] f448618f;

    /* renamed from: g, reason: collision with root package name */
    public r[] f448619g;

    /* renamed from: h, reason: collision with root package name */
    public hs4.i[] f448620h;

    /* renamed from: i, reason: collision with root package name */
    public q[] f448621i;

    /* renamed from: j, reason: collision with root package name */
    public h[] f448622j;

    /* renamed from: k, reason: collision with root package name */
    public w[] f448623k;

    /* renamed from: l, reason: collision with root package name */
    public String f448624l;

    /* renamed from: m, reason: collision with root package name */
    public a f448625m;

    /* renamed from: n, reason: collision with root package name */
    public String f448626n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f448627o;

    /* renamed from: p, reason: collision with root package name */
    public int f448628p;

    public p() {
        a();
    }

    public static p c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (p) MessageNano.mergeFrom(new p(), bArr);
    }

    public p a() {
        this.f448613a = ag.b();
        this.f448614b = 0;
        this.f448615c = 0;
        this.f448616d = 0;
        this.f448617e = 0;
        this.f448618f = ah.b();
        this.f448619g = r.b();
        this.f448620h = hs4.i.b();
        this.f448621i = q.b();
        this.f448622j = h.b();
        this.f448623k = w.b();
        this.f448624l = "";
        this.f448625m = null;
        this.f448626n = "";
        this.f448627o = false;
        this.f448628p = 0;
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
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    ag[] agVarArr = this.f448613a;
                    int length = agVarArr == null ? 0 : agVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    ag[] agVarArr2 = new ag[i3];
                    if (length != 0) {
                        System.arraycopy(agVarArr, 0, agVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        ag agVar = new ag();
                        agVarArr2[length] = agVar;
                        codedInputByteBufferNano.readMessage(agVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ag agVar2 = new ag();
                    agVarArr2[length] = agVar2;
                    codedInputByteBufferNano.readMessage(agVar2);
                    this.f448613a = agVarArr2;
                    break;
                case 16:
                    this.f448614b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f448615c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f448616d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f448617e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    ah[] ahVarArr = this.f448618f;
                    int length2 = ahVarArr == null ? 0 : ahVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    ah[] ahVarArr2 = new ah[i16];
                    if (length2 != 0) {
                        System.arraycopy(ahVarArr, 0, ahVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        ah ahVar = new ah();
                        ahVarArr2[length2] = ahVar;
                        codedInputByteBufferNano.readMessage(ahVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    ah ahVar2 = new ah();
                    ahVarArr2[length2] = ahVar2;
                    codedInputByteBufferNano.readMessage(ahVar2);
                    this.f448618f = ahVarArr2;
                    break;
                case 58:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    r[] rVarArr = this.f448619g;
                    int length3 = rVarArr == null ? 0 : rVarArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    r[] rVarArr2 = new r[i17];
                    if (length3 != 0) {
                        System.arraycopy(rVarArr, 0, rVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        r rVar = new r();
                        rVarArr2[length3] = rVar;
                        codedInputByteBufferNano.readMessage(rVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    r rVar2 = new r();
                    rVarArr2[length3] = rVar2;
                    codedInputByteBufferNano.readMessage(rVar2);
                    this.f448619g = rVarArr2;
                    break;
                case 66:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    hs4.i[] iVarArr = this.f448620h;
                    int length4 = iVarArr == null ? 0 : iVarArr.length;
                    int i18 = repeatedFieldArrayLength4 + length4;
                    hs4.i[] iVarArr2 = new hs4.i[i18];
                    if (length4 != 0) {
                        System.arraycopy(iVarArr, 0, iVarArr2, 0, length4);
                    }
                    while (length4 < i18 - 1) {
                        hs4.i iVar = new hs4.i();
                        iVarArr2[length4] = iVar;
                        codedInputByteBufferNano.readMessage(iVar);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    hs4.i iVar2 = new hs4.i();
                    iVarArr2[length4] = iVar2;
                    codedInputByteBufferNano.readMessage(iVar2);
                    this.f448620h = iVarArr2;
                    break;
                case 74:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    q[] qVarArr = this.f448621i;
                    int length5 = qVarArr == null ? 0 : qVarArr.length;
                    int i19 = repeatedFieldArrayLength5 + length5;
                    q[] qVarArr2 = new q[i19];
                    if (length5 != 0) {
                        System.arraycopy(qVarArr, 0, qVarArr2, 0, length5);
                    }
                    while (length5 < i19 - 1) {
                        q qVar = new q();
                        qVarArr2[length5] = qVar;
                        codedInputByteBufferNano.readMessage(qVar);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    q qVar2 = new q();
                    qVarArr2[length5] = qVar2;
                    codedInputByteBufferNano.readMessage(qVar2);
                    this.f448621i = qVarArr2;
                    break;
                case 82:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    h[] hVarArr = this.f448622j;
                    int length6 = hVarArr == null ? 0 : hVarArr.length;
                    int i26 = repeatedFieldArrayLength6 + length6;
                    h[] hVarArr2 = new h[i26];
                    if (length6 != 0) {
                        System.arraycopy(hVarArr, 0, hVarArr2, 0, length6);
                    }
                    while (length6 < i26 - 1) {
                        h hVar = new h();
                        hVarArr2[length6] = hVar;
                        codedInputByteBufferNano.readMessage(hVar);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    h hVar2 = new h();
                    hVarArr2[length6] = hVar2;
                    codedInputByteBufferNano.readMessage(hVar2);
                    this.f448622j = hVarArr2;
                    break;
                case 90:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    w[] wVarArr = this.f448623k;
                    int length7 = wVarArr == null ? 0 : wVarArr.length;
                    int i27 = repeatedFieldArrayLength7 + length7;
                    w[] wVarArr2 = new w[i27];
                    if (length7 != 0) {
                        System.arraycopy(wVarArr, 0, wVarArr2, 0, length7);
                    }
                    while (length7 < i27 - 1) {
                        w wVar = new w();
                        wVarArr2[length7] = wVar;
                        codedInputByteBufferNano.readMessage(wVar);
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    w wVar2 = new w();
                    wVarArr2[length7] = wVar2;
                    codedInputByteBufferNano.readMessage(wVar2);
                    this.f448623k = wVarArr2;
                    break;
                case 98:
                    this.f448624l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    if (this.f448625m == null) {
                        this.f448625m = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f448625m);
                    break;
                case 114:
                    this.f448626n = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    this.f448627o = codedInputByteBufferNano.readBool();
                    break;
                case 128:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.f448628p = readInt32;
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
        ag[] agVarArr = this.f448613a;
        int i3 = 0;
        if (agVarArr != null && agVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ag[] agVarArr2 = this.f448613a;
                if (i16 >= agVarArr2.length) {
                    break;
                }
                ag agVar = agVarArr2[i16];
                if (agVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, agVar);
                }
                i16++;
            }
        }
        int i17 = this.f448614b;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i17);
        }
        int i18 = this.f448615c;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i18);
        }
        int i19 = this.f448616d;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i19);
        }
        int i26 = this.f448617e;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i26);
        }
        ah[] ahVarArr = this.f448618f;
        if (ahVarArr != null && ahVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                ah[] ahVarArr2 = this.f448618f;
                if (i27 >= ahVarArr2.length) {
                    break;
                }
                ah ahVar = ahVarArr2[i27];
                if (ahVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, ahVar);
                }
                i27++;
            }
        }
        r[] rVarArr = this.f448619g;
        if (rVarArr != null && rVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                r[] rVarArr2 = this.f448619g;
                if (i28 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i28];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, rVar);
                }
                i28++;
            }
        }
        hs4.i[] iVarArr = this.f448620h;
        if (iVarArr != null && iVarArr.length > 0) {
            int i29 = 0;
            while (true) {
                hs4.i[] iVarArr2 = this.f448620h;
                if (i29 >= iVarArr2.length) {
                    break;
                }
                hs4.i iVar = iVarArr2[i29];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, iVar);
                }
                i29++;
            }
        }
        q[] qVarArr = this.f448621i;
        if (qVarArr != null && qVarArr.length > 0) {
            int i36 = 0;
            while (true) {
                q[] qVarArr2 = this.f448621i;
                if (i36 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i36];
                if (qVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, qVar);
                }
                i36++;
            }
        }
        h[] hVarArr = this.f448622j;
        if (hVarArr != null && hVarArr.length > 0) {
            int i37 = 0;
            while (true) {
                h[] hVarArr2 = this.f448622j;
                if (i37 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i37];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, hVar);
                }
                i37++;
            }
        }
        w[] wVarArr = this.f448623k;
        if (wVarArr != null && wVarArr.length > 0) {
            while (true) {
                w[] wVarArr2 = this.f448623k;
                if (i3 >= wVarArr2.length) {
                    break;
                }
                w wVar = wVarArr2[i3];
                if (wVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, wVar);
                }
                i3++;
            }
        }
        if (!this.f448624l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f448624l);
        }
        a aVar = this.f448625m;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, aVar);
        }
        if (!this.f448626n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f448626n);
        }
        boolean z16 = this.f448627o;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(15, z16);
        }
        int i38 = this.f448628p;
        return i38 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(16, i38) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ag[] agVarArr = this.f448613a;
        int i3 = 0;
        if (agVarArr != null && agVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ag[] agVarArr2 = this.f448613a;
                if (i16 >= agVarArr2.length) {
                    break;
                }
                ag agVar = agVarArr2[i16];
                if (agVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, agVar);
                }
                i16++;
            }
        }
        int i17 = this.f448614b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i17);
        }
        int i18 = this.f448615c;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i18);
        }
        int i19 = this.f448616d;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i19);
        }
        int i26 = this.f448617e;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i26);
        }
        ah[] ahVarArr = this.f448618f;
        if (ahVarArr != null && ahVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                ah[] ahVarArr2 = this.f448618f;
                if (i27 >= ahVarArr2.length) {
                    break;
                }
                ah ahVar = ahVarArr2[i27];
                if (ahVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, ahVar);
                }
                i27++;
            }
        }
        r[] rVarArr = this.f448619g;
        if (rVarArr != null && rVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                r[] rVarArr2 = this.f448619g;
                if (i28 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i28];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, rVar);
                }
                i28++;
            }
        }
        hs4.i[] iVarArr = this.f448620h;
        if (iVarArr != null && iVarArr.length > 0) {
            int i29 = 0;
            while (true) {
                hs4.i[] iVarArr2 = this.f448620h;
                if (i29 >= iVarArr2.length) {
                    break;
                }
                hs4.i iVar = iVarArr2[i29];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(8, iVar);
                }
                i29++;
            }
        }
        q[] qVarArr = this.f448621i;
        if (qVarArr != null && qVarArr.length > 0) {
            int i36 = 0;
            while (true) {
                q[] qVarArr2 = this.f448621i;
                if (i36 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i36];
                if (qVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, qVar);
                }
                i36++;
            }
        }
        h[] hVarArr = this.f448622j;
        if (hVarArr != null && hVarArr.length > 0) {
            int i37 = 0;
            while (true) {
                h[] hVarArr2 = this.f448622j;
                if (i37 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i37];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, hVar);
                }
                i37++;
            }
        }
        w[] wVarArr = this.f448623k;
        if (wVarArr != null && wVarArr.length > 0) {
            while (true) {
                w[] wVarArr2 = this.f448623k;
                if (i3 >= wVarArr2.length) {
                    break;
                }
                w wVar = wVarArr2[i3];
                if (wVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, wVar);
                }
                i3++;
            }
        }
        if (!this.f448624l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f448624l);
        }
        a aVar = this.f448625m;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(13, aVar);
        }
        if (!this.f448626n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f448626n);
        }
        boolean z16 = this.f448627o;
        if (z16) {
            codedOutputByteBufferNano.writeBool(15, z16);
        }
        int i38 = this.f448628p;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i38);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
