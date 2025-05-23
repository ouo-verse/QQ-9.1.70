package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ah extends ExtendableMessageNano<ah> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.r[] f429915a;

    /* renamed from: b, reason: collision with root package name */
    public nw4.i f429916b;

    /* renamed from: c, reason: collision with root package name */
    public int f429917c;

    /* renamed from: d, reason: collision with root package name */
    public String f429918d;

    /* renamed from: e, reason: collision with root package name */
    public pv4.f[] f429919e;

    /* renamed from: f, reason: collision with root package name */
    public String f429920f;

    /* renamed from: g, reason: collision with root package name */
    public pv4.t[] f429921g;

    /* renamed from: h, reason: collision with root package name */
    public bq f429922h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f429923i;

    /* renamed from: j, reason: collision with root package name */
    public int f429924j;

    public ah() {
        a();
    }

    public static ah c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ah) MessageNano.mergeFrom(new ah(), bArr);
    }

    public ah a() {
        this.f429915a = pv4.r.b();
        this.f429916b = null;
        this.f429917c = 0;
        this.f429918d = "";
        this.f429919e = pv4.f.b();
        this.f429920f = "";
        this.f429921g = pv4.t.b();
        this.f429922h = null;
        this.f429923i = false;
        this.f429924j = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ah mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    pv4.r[] rVarArr = this.f429915a;
                    int length = rVarArr == null ? 0 : rVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    pv4.r[] rVarArr2 = new pv4.r[i3];
                    if (length != 0) {
                        System.arraycopy(rVarArr, 0, rVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        pv4.r rVar = new pv4.r();
                        rVarArr2[length] = rVar;
                        codedInputByteBufferNano.readMessage(rVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    pv4.r rVar2 = new pv4.r();
                    rVarArr2[length] = rVar2;
                    codedInputByteBufferNano.readMessage(rVar2);
                    this.f429915a = rVarArr2;
                    break;
                case 26:
                    if (this.f429916b == null) {
                        this.f429916b = new nw4.i();
                    }
                    codedInputByteBufferNano.readMessage(this.f429916b);
                    break;
                case 32:
                    this.f429917c = codedInputByteBufferNano.readInt32();
                    break;
                case 42:
                    this.f429918d = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    pv4.f[] fVarArr = this.f429919e;
                    int length2 = fVarArr == null ? 0 : fVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    pv4.f[] fVarArr2 = new pv4.f[i16];
                    if (length2 != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        pv4.f fVar = new pv4.f();
                        fVarArr2[length2] = fVar;
                        codedInputByteBufferNano.readMessage(fVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    pv4.f fVar2 = new pv4.f();
                    fVarArr2[length2] = fVar2;
                    codedInputByteBufferNano.readMessage(fVar2);
                    this.f429919e = fVarArr2;
                    break;
                case 58:
                    this.f429920f = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    pv4.t[] tVarArr = this.f429921g;
                    int length3 = tVarArr == null ? 0 : tVarArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    pv4.t[] tVarArr2 = new pv4.t[i17];
                    if (length3 != 0) {
                        System.arraycopy(tVarArr, 0, tVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        pv4.t tVar = new pv4.t();
                        tVarArr2[length3] = tVar;
                        codedInputByteBufferNano.readMessage(tVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    pv4.t tVar2 = new pv4.t();
                    tVarArr2[length3] = tVar2;
                    codedInputByteBufferNano.readMessage(tVar2);
                    this.f429921g = tVarArr2;
                    break;
                case 74:
                    if (this.f429922h == null) {
                        this.f429922h = new bq();
                    }
                    codedInputByteBufferNano.readMessage(this.f429922h);
                    break;
                case 80:
                    this.f429923i = codedInputByteBufferNano.readBool();
                    break;
                case 88:
                    this.f429924j = codedInputByteBufferNano.readInt32();
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
        pv4.r[] rVarArr = this.f429915a;
        int i3 = 0;
        if (rVarArr != null && rVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                pv4.r[] rVarArr2 = this.f429915a;
                if (i16 >= rVarArr2.length) {
                    break;
                }
                pv4.r rVar = rVarArr2[i16];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
                }
                i16++;
            }
        }
        nw4.i iVar = this.f429916b;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, iVar);
        }
        int i17 = this.f429917c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        if (!this.f429918d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f429918d);
        }
        pv4.f[] fVarArr = this.f429919e;
        if (fVarArr != null && fVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                pv4.f[] fVarArr2 = this.f429919e;
                if (i18 >= fVarArr2.length) {
                    break;
                }
                pv4.f fVar = fVarArr2[i18];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, fVar);
                }
                i18++;
            }
        }
        if (!this.f429920f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f429920f);
        }
        pv4.t[] tVarArr = this.f429921g;
        if (tVarArr != null && tVarArr.length > 0) {
            while (true) {
                pv4.t[] tVarArr2 = this.f429921g;
                if (i3 >= tVarArr2.length) {
                    break;
                }
                pv4.t tVar = tVarArr2[i3];
                if (tVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, tVar);
                }
                i3++;
            }
        }
        bq bqVar = this.f429922h;
        if (bqVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, bqVar);
        }
        boolean z16 = this.f429923i;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z16);
        }
        int i19 = this.f429924j;
        return i19 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(11, i19) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.r[] rVarArr = this.f429915a;
        int i3 = 0;
        if (rVarArr != null && rVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                pv4.r[] rVarArr2 = this.f429915a;
                if (i16 >= rVarArr2.length) {
                    break;
                }
                pv4.r rVar = rVarArr2[i16];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, rVar);
                }
                i16++;
            }
        }
        nw4.i iVar = this.f429916b;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(3, iVar);
        }
        int i17 = this.f429917c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        if (!this.f429918d.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f429918d);
        }
        pv4.f[] fVarArr = this.f429919e;
        if (fVarArr != null && fVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                pv4.f[] fVarArr2 = this.f429919e;
                if (i18 >= fVarArr2.length) {
                    break;
                }
                pv4.f fVar = fVarArr2[i18];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, fVar);
                }
                i18++;
            }
        }
        if (!this.f429920f.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f429920f);
        }
        pv4.t[] tVarArr = this.f429921g;
        if (tVarArr != null && tVarArr.length > 0) {
            while (true) {
                pv4.t[] tVarArr2 = this.f429921g;
                if (i3 >= tVarArr2.length) {
                    break;
                }
                pv4.t tVar = tVarArr2[i3];
                if (tVar != null) {
                    codedOutputByteBufferNano.writeMessage(8, tVar);
                }
                i3++;
            }
        }
        bq bqVar = this.f429922h;
        if (bqVar != null) {
            codedOutputByteBufferNano.writeMessage(9, bqVar);
        }
        boolean z16 = this.f429923i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(10, z16);
        }
        int i19 = this.f429924j;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
