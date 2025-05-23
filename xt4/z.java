package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class z extends ExtendableMessageNano<z> {

    /* renamed from: a, reason: collision with root package name */
    public int f448671a;

    /* renamed from: b, reason: collision with root package name */
    public int f448672b;

    /* renamed from: c, reason: collision with root package name */
    public hs4.m f448673c;

    /* renamed from: d, reason: collision with root package name */
    public String f448674d;

    /* renamed from: e, reason: collision with root package name */
    public hs4.f f448675e;

    /* renamed from: f, reason: collision with root package name */
    public long f448676f;

    /* renamed from: g, reason: collision with root package name */
    public int f448677g;

    /* renamed from: h, reason: collision with root package name */
    public long f448678h;

    /* renamed from: i, reason: collision with root package name */
    public hs4.b f448679i;

    /* renamed from: j, reason: collision with root package name */
    public af[] f448680j;

    /* renamed from: k, reason: collision with root package name */
    public int f448681k;

    /* renamed from: l, reason: collision with root package name */
    public hs4.m f448682l;

    /* renamed from: m, reason: collision with root package name */
    public int f448683m;

    public z() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f448671a = readInt32;
                        break;
                    }
                case 16:
                    this.f448672b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    if (this.f448673c == null) {
                        this.f448673c = new hs4.m();
                    }
                    codedInputByteBufferNano.readMessage(this.f448673c);
                    break;
                case 34:
                    this.f448674d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    if (this.f448675e == null) {
                        this.f448675e = new hs4.f();
                    }
                    codedInputByteBufferNano.readMessage(this.f448675e);
                    break;
                case 48:
                    this.f448676f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1) {
                        break;
                    } else {
                        this.f448677g = readInt322;
                        break;
                    }
                case 64:
                    this.f448678h = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    if (this.f448679i == null) {
                        this.f448679i = new hs4.b();
                    }
                    codedInputByteBufferNano.readMessage(this.f448679i);
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    af[] afVarArr = this.f448680j;
                    int length = afVarArr == null ? 0 : afVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    af[] afVarArr2 = new af[i3];
                    if (length != 0) {
                        System.arraycopy(afVarArr, 0, afVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        af afVar = new af();
                        afVarArr2[length] = afVar;
                        codedInputByteBufferNano.readMessage(afVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    af afVar2 = new af();
                    afVarArr2[length] = afVar2;
                    codedInputByteBufferNano.readMessage(afVar2);
                    this.f448680j = afVarArr2;
                    break;
                case 88:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    switch (readInt323) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            this.f448681k = readInt323;
                            break;
                    }
                case 98:
                    if (this.f448682l == null) {
                        this.f448682l = new hs4.m();
                    }
                    codedInputByteBufferNano.readMessage(this.f448682l);
                    break;
                case 104:
                    int readInt324 = codedInputByteBufferNano.readInt32();
                    if (readInt324 != 0) {
                        switch (readInt324) {
                        }
                    }
                    this.f448683m = readInt324;
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
        int i3 = this.f448671a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f448672b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        hs4.m mVar = this.f448673c;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, mVar);
        }
        if (!this.f448674d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448674d);
        }
        hs4.f fVar = this.f448675e;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, fVar);
        }
        long j3 = this.f448676f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        int i17 = this.f448677g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        long j16 = this.f448678h;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        hs4.b bVar = this.f448679i;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, bVar);
        }
        af[] afVarArr = this.f448680j;
        if (afVarArr != null && afVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                af[] afVarArr2 = this.f448680j;
                if (i18 >= afVarArr2.length) {
                    break;
                }
                af afVar = afVarArr2[i18];
                if (afVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, afVar);
                }
                i18++;
            }
        }
        int i19 = this.f448681k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i19);
        }
        hs4.m mVar2 = this.f448682l;
        if (mVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, mVar2);
        }
        int i26 = this.f448683m;
        return i26 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(13, i26) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448671a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f448672b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        hs4.m mVar = this.f448673c;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(3, mVar);
        }
        if (!this.f448674d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448674d);
        }
        hs4.f fVar = this.f448675e;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(5, fVar);
        }
        long j3 = this.f448676f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        int i17 = this.f448677g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        long j16 = this.f448678h;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        hs4.b bVar = this.f448679i;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(9, bVar);
        }
        af[] afVarArr = this.f448680j;
        if (afVarArr != null && afVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                af[] afVarArr2 = this.f448680j;
                if (i18 >= afVarArr2.length) {
                    break;
                }
                af afVar = afVarArr2[i18];
                if (afVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, afVar);
                }
                i18++;
            }
        }
        int i19 = this.f448681k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i19);
        }
        hs4.m mVar2 = this.f448682l;
        if (mVar2 != null) {
            codedOutputByteBufferNano.writeMessage(12, mVar2);
        }
        int i26 = this.f448683m;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public z a() {
        this.f448671a = 0;
        this.f448672b = 0;
        this.f448673c = null;
        this.f448674d = "";
        this.f448675e = null;
        this.f448676f = 0L;
        this.f448677g = 0;
        this.f448678h = 0L;
        this.f448679i = null;
        this.f448680j = af.b();
        this.f448681k = 0;
        this.f448682l = null;
        this.f448683m = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
