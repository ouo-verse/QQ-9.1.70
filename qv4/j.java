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
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public k f430167a;

    /* renamed from: b, reason: collision with root package name */
    public h f430168b;

    /* renamed from: c, reason: collision with root package name */
    public String f430169c;

    /* renamed from: d, reason: collision with root package name */
    public aw f430170d;

    /* renamed from: e, reason: collision with root package name */
    public xu4.a[] f430171e;

    /* renamed from: f, reason: collision with root package name */
    public String f430172f;

    /* renamed from: g, reason: collision with root package name */
    public String f430173g;

    /* renamed from: h, reason: collision with root package name */
    public String f430174h;

    /* renamed from: i, reason: collision with root package name */
    public nw4.f[] f430175i;

    /* renamed from: j, reason: collision with root package name */
    public String f430176j;

    /* renamed from: k, reason: collision with root package name */
    public at f430177k;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f430167a == null) {
                        this.f430167a = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f430167a);
                    break;
                case 18:
                    if (this.f430168b == null) {
                        this.f430168b = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f430168b);
                    break;
                case 26:
                    this.f430169c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.f430170d == null) {
                        this.f430170d = new aw();
                    }
                    codedInputByteBufferNano.readMessage(this.f430170d);
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    xu4.a[] aVarArr = this.f430171e;
                    int length = aVarArr == null ? 0 : aVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    xu4.a[] aVarArr2 = new xu4.a[i3];
                    if (length != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        xu4.a aVar = new xu4.a();
                        aVarArr2[length] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    xu4.a aVar2 = new xu4.a();
                    aVarArr2[length] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f430171e = aVarArr2;
                    break;
                case 50:
                    this.f430172f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f430173g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f430174h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    nw4.f[] fVarArr = this.f430175i;
                    int length2 = fVarArr == null ? 0 : fVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    nw4.f[] fVarArr2 = new nw4.f[i16];
                    if (length2 != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        nw4.f fVar = new nw4.f();
                        fVarArr2[length2] = fVar;
                        codedInputByteBufferNano.readMessage(fVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    nw4.f fVar2 = new nw4.f();
                    fVarArr2[length2] = fVar2;
                    codedInputByteBufferNano.readMessage(fVar2);
                    this.f430175i = fVarArr2;
                    break;
                case 82:
                    this.f430176j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.f430177k == null) {
                        this.f430177k = new at();
                    }
                    codedInputByteBufferNano.readMessage(this.f430177k);
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
        k kVar = this.f430167a;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, kVar);
        }
        h hVar = this.f430168b;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        if (!this.f430169c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430169c);
        }
        aw awVar = this.f430170d;
        if (awVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, awVar);
        }
        xu4.a[] aVarArr = this.f430171e;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                xu4.a[] aVarArr2 = this.f430171e;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                xu4.a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, aVar);
                }
                i16++;
            }
        }
        if (!this.f430172f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f430172f);
        }
        if (!this.f430173g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f430173g);
        }
        if (!this.f430174h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f430174h);
        }
        nw4.f[] fVarArr = this.f430175i;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                nw4.f[] fVarArr2 = this.f430175i;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                nw4.f fVar = fVarArr2[i3];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, fVar);
                }
                i3++;
            }
        }
        if (!this.f430176j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f430176j);
        }
        at atVar = this.f430177k;
        return atVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(11, atVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        k kVar = this.f430167a;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(1, kVar);
        }
        h hVar = this.f430168b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        if (!this.f430169c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430169c);
        }
        aw awVar = this.f430170d;
        if (awVar != null) {
            codedOutputByteBufferNano.writeMessage(4, awVar);
        }
        xu4.a[] aVarArr = this.f430171e;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                xu4.a[] aVarArr2 = this.f430171e;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                xu4.a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, aVar);
                }
                i16++;
            }
        }
        if (!this.f430172f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f430172f);
        }
        if (!this.f430173g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f430173g);
        }
        if (!this.f430174h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f430174h);
        }
        nw4.f[] fVarArr = this.f430175i;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                nw4.f[] fVarArr2 = this.f430175i;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                nw4.f fVar = fVarArr2[i3];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, fVar);
                }
                i3++;
            }
        }
        if (!this.f430176j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f430176j);
        }
        at atVar = this.f430177k;
        if (atVar != null) {
            codedOutputByteBufferNano.writeMessage(11, atVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f430167a = null;
        this.f430168b = null;
        this.f430169c = "";
        this.f430170d = null;
        this.f430171e = xu4.a.b();
        this.f430172f = "";
        this.f430173g = "";
        this.f430174h = "";
        this.f430175i = nw4.f.b();
        this.f430176j = "";
        this.f430177k = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
