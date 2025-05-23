package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: a, reason: collision with root package name */
    public String f432368a;

    /* renamed from: b, reason: collision with root package name */
    public int f432369b;

    /* renamed from: c, reason: collision with root package name */
    public int f432370c;

    /* renamed from: d, reason: collision with root package name */
    public long f432371d;

    /* renamed from: e, reason: collision with root package name */
    public long f432372e;

    /* renamed from: f, reason: collision with root package name */
    public int f432373f;

    /* renamed from: g, reason: collision with root package name */
    public int f432374g;

    /* renamed from: h, reason: collision with root package name */
    public c f432375h;

    /* renamed from: i, reason: collision with root package name */
    public int f432376i;

    /* renamed from: j, reason: collision with root package name */
    public int f432377j;

    /* renamed from: k, reason: collision with root package name */
    public r[] f432378k;

    /* renamed from: l, reason: collision with root package name */
    public int f432379l;

    public w() {
        a();
    }

    public w a() {
        this.f432368a = "";
        this.f432369b = 0;
        this.f432370c = 0;
        this.f432371d = 0L;
        this.f432372e = 0L;
        this.f432373f = 0;
        this.f432374g = 0;
        this.f432375h = null;
        this.f432376i = 0;
        this.f432377j = 0;
        this.f432378k = r.b();
        this.f432379l = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f432368a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f432369b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f432370c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f432371d = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.f432372e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f432373f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f432374g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    if (this.f432375h == null) {
                        this.f432375h = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f432375h);
                    break;
                case 72:
                    this.f432376i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f432377j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    r[] rVarArr = this.f432378k;
                    if (rVarArr == null) {
                        length = 0;
                    } else {
                        length = rVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    r[] rVarArr2 = new r[i3];
                    if (length != 0) {
                        System.arraycopy(rVarArr, 0, rVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        r rVar = new r();
                        rVarArr2[length] = rVar;
                        codedInputByteBufferNano.readMessage(rVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    r rVar2 = new r();
                    rVarArr2[length] = rVar2;
                    codedInputByteBufferNano.readMessage(rVar2);
                    this.f432378k = rVarArr2;
                    break;
                case 96:
                    this.f432379l = codedInputByteBufferNano.readUInt32();
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
        if (!this.f432368a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432368a);
        }
        int i3 = this.f432369b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f432370c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        long j3 = this.f432371d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        long j16 = this.f432372e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        int i17 = this.f432373f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.f432374g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        c cVar = this.f432375h;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, cVar);
        }
        int i19 = this.f432376i;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        int i26 = this.f432377j;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i26);
        }
        r[] rVarArr = this.f432378k;
        if (rVarArr != null && rVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                r[] rVarArr2 = this.f432378k;
                if (i27 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i27];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, rVar);
                }
                i27++;
            }
        }
        int i28 = this.f432379l;
        if (i28 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(12, i28);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432368a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432368a);
        }
        int i3 = this.f432369b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f432370c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        long j3 = this.f432371d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        long j16 = this.f432372e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        int i17 = this.f432373f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.f432374g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        c cVar = this.f432375h;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(8, cVar);
        }
        int i19 = this.f432376i;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        int i26 = this.f432377j;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i26);
        }
        r[] rVarArr = this.f432378k;
        if (rVarArr != null && rVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                r[] rVarArr2 = this.f432378k;
                if (i27 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i27];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, rVar);
                }
                i27++;
            }
        }
        int i28 = this.f432379l;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i28);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
