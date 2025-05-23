package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f448778a;

    /* renamed from: b, reason: collision with root package name */
    public int f448779b;

    /* renamed from: c, reason: collision with root package name */
    public e[] f448780c;

    /* renamed from: d, reason: collision with root package name */
    public int f448781d;

    /* renamed from: e, reason: collision with root package name */
    public long f448782e;

    /* renamed from: f, reason: collision with root package name */
    public long f448783f;

    /* renamed from: g, reason: collision with root package name */
    public long f448784g;

    /* renamed from: h, reason: collision with root package name */
    public int f448785h;

    /* renamed from: i, reason: collision with root package name */
    public ab[] f448786i;

    /* renamed from: j, reason: collision with root package name */
    public ab[] f448787j;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f448778a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f448779b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    e[] eVarArr = this.f448780c;
                    int length = eVarArr == null ? 0 : eVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    e[] eVarArr2 = new e[i3];
                    if (length != 0) {
                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        e eVar = new e();
                        eVarArr2[length] = eVar;
                        codedInputByteBufferNano.readMessage(eVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    e eVar2 = new e();
                    eVarArr2[length] = eVar2;
                    codedInputByteBufferNano.readMessage(eVar2);
                    this.f448780c = eVarArr2;
                    break;
                case 32:
                    this.f448781d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f448782e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f448783f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.f448784g = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.f448785h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    ab[] abVarArr = this.f448786i;
                    int length2 = abVarArr == null ? 0 : abVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    ab[] abVarArr2 = new ab[i16];
                    if (length2 != 0) {
                        System.arraycopy(abVarArr, 0, abVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        ab abVar = new ab();
                        abVarArr2[length2] = abVar;
                        codedInputByteBufferNano.readMessage(abVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    ab abVar2 = new ab();
                    abVarArr2[length2] = abVar2;
                    codedInputByteBufferNano.readMessage(abVar2);
                    this.f448786i = abVarArr2;
                    break;
                case 82:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    ab[] abVarArr3 = this.f448787j;
                    int length3 = abVarArr3 == null ? 0 : abVarArr3.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    ab[] abVarArr4 = new ab[i17];
                    if (length3 != 0) {
                        System.arraycopy(abVarArr3, 0, abVarArr4, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        ab abVar3 = new ab();
                        abVarArr4[length3] = abVar3;
                        codedInputByteBufferNano.readMessage(abVar3);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    ab abVar4 = new ab();
                    abVarArr4[length3] = abVar4;
                    codedInputByteBufferNano.readMessage(abVar4);
                    this.f448787j = abVarArr4;
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
        long j3 = this.f448778a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f448779b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        e[] eVarArr = this.f448780c;
        int i16 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                e[] eVarArr2 = this.f448780c;
                if (i17 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i17];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
                }
                i17++;
            }
        }
        int i18 = this.f448781d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        long j16 = this.f448782e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        long j17 = this.f448783f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        long j18 = this.f448784g;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j18);
        }
        int i19 = this.f448785h;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i19);
        }
        ab[] abVarArr = this.f448786i;
        if (abVarArr != null && abVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448786i;
                if (i26 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i26];
                if (abVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, abVar);
                }
                i26++;
            }
        }
        ab[] abVarArr3 = this.f448787j;
        if (abVarArr3 != null && abVarArr3.length > 0) {
            while (true) {
                ab[] abVarArr4 = this.f448787j;
                if (i16 >= abVarArr4.length) {
                    break;
                }
                ab abVar2 = abVarArr4[i16];
                if (abVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, abVar2);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448778a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f448779b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        e[] eVarArr = this.f448780c;
        int i16 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                e[] eVarArr2 = this.f448780c;
                if (i17 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i17];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, eVar);
                }
                i17++;
            }
        }
        int i18 = this.f448781d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        long j16 = this.f448782e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        long j17 = this.f448783f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        long j18 = this.f448784g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j18);
        }
        int i19 = this.f448785h;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i19);
        }
        ab[] abVarArr = this.f448786i;
        if (abVarArr != null && abVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448786i;
                if (i26 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i26];
                if (abVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, abVar);
                }
                i26++;
            }
        }
        ab[] abVarArr3 = this.f448787j;
        if (abVarArr3 != null && abVarArr3.length > 0) {
            while (true) {
                ab[] abVarArr4 = this.f448787j;
                if (i16 >= abVarArr4.length) {
                    break;
                }
                ab abVar2 = abVarArr4[i16];
                if (abVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(10, abVar2);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f448778a = 0L;
        this.f448779b = 0;
        this.f448780c = e.b();
        this.f448781d = 0;
        this.f448782e = 0L;
        this.f448783f = 0L;
        this.f448784g = 0L;
        this.f448785h = 0;
        this.f448786i = ab.b();
        this.f448787j = ab.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
