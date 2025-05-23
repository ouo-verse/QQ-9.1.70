package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class as extends ExtendableMessageNano<as> {

    /* renamed from: a, reason: collision with root package name */
    public int f440218a;

    /* renamed from: b, reason: collision with root package name */
    public int f440219b;

    /* renamed from: c, reason: collision with root package name */
    public qu4.p[] f440220c;

    /* renamed from: d, reason: collision with root package name */
    public qu4.l[] f440221d;

    /* renamed from: e, reason: collision with root package name */
    public qu4.l[] f440222e;

    public as() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public as mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440218a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f440219b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                qu4.p[] pVarArr = this.f440220c;
                int length = pVarArr == null ? 0 : pVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                qu4.p[] pVarArr2 = new qu4.p[i3];
                if (length != 0) {
                    System.arraycopy(pVarArr, 0, pVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    qu4.p pVar = new qu4.p();
                    pVarArr2[length] = pVar;
                    codedInputByteBufferNano.readMessage(pVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                qu4.p pVar2 = new qu4.p();
                pVarArr2[length] = pVar2;
                codedInputByteBufferNano.readMessage(pVar2);
                this.f440220c = pVarArr2;
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                qu4.l[] lVarArr = this.f440221d;
                int length2 = lVarArr == null ? 0 : lVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                qu4.l[] lVarArr2 = new qu4.l[i16];
                if (length2 != 0) {
                    System.arraycopy(lVarArr, 0, lVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    qu4.l lVar = new qu4.l();
                    lVarArr2[length2] = lVar;
                    codedInputByteBufferNano.readMessage(lVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                qu4.l lVar2 = new qu4.l();
                lVarArr2[length2] = lVar2;
                codedInputByteBufferNano.readMessage(lVar2);
                this.f440221d = lVarArr2;
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                qu4.l[] lVarArr3 = this.f440222e;
                int length3 = lVarArr3 == null ? 0 : lVarArr3.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                qu4.l[] lVarArr4 = new qu4.l[i17];
                if (length3 != 0) {
                    System.arraycopy(lVarArr3, 0, lVarArr4, 0, length3);
                }
                while (length3 < i17 - 1) {
                    qu4.l lVar3 = new qu4.l();
                    lVarArr4[length3] = lVar3;
                    codedInputByteBufferNano.readMessage(lVar3);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                qu4.l lVar4 = new qu4.l();
                lVarArr4[length3] = lVar4;
                codedInputByteBufferNano.readMessage(lVar4);
                this.f440222e = lVarArr4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440218a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f440219b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        qu4.p[] pVarArr = this.f440220c;
        int i17 = 0;
        if (pVarArr != null && pVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                qu4.p[] pVarArr2 = this.f440220c;
                if (i18 >= pVarArr2.length) {
                    break;
                }
                qu4.p pVar = pVarArr2[i18];
                if (pVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, pVar);
                }
                i18++;
            }
        }
        qu4.l[] lVarArr = this.f440221d;
        if (lVarArr != null && lVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                qu4.l[] lVarArr2 = this.f440221d;
                if (i19 >= lVarArr2.length) {
                    break;
                }
                qu4.l lVar = lVarArr2[i19];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, lVar);
                }
                i19++;
            }
        }
        qu4.l[] lVarArr3 = this.f440222e;
        if (lVarArr3 != null && lVarArr3.length > 0) {
            while (true) {
                qu4.l[] lVarArr4 = this.f440222e;
                if (i17 >= lVarArr4.length) {
                    break;
                }
                qu4.l lVar2 = lVarArr4[i17];
                if (lVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, lVar2);
                }
                i17++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440218a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f440219b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        qu4.p[] pVarArr = this.f440220c;
        int i17 = 0;
        if (pVarArr != null && pVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                qu4.p[] pVarArr2 = this.f440220c;
                if (i18 >= pVarArr2.length) {
                    break;
                }
                qu4.p pVar = pVarArr2[i18];
                if (pVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, pVar);
                }
                i18++;
            }
        }
        qu4.l[] lVarArr = this.f440221d;
        if (lVarArr != null && lVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                qu4.l[] lVarArr2 = this.f440221d;
                if (i19 >= lVarArr2.length) {
                    break;
                }
                qu4.l lVar = lVarArr2[i19];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, lVar);
                }
                i19++;
            }
        }
        qu4.l[] lVarArr3 = this.f440222e;
        if (lVarArr3 != null && lVarArr3.length > 0) {
            while (true) {
                qu4.l[] lVarArr4 = this.f440222e;
                if (i17 >= lVarArr4.length) {
                    break;
                }
                qu4.l lVar2 = lVarArr4[i17];
                if (lVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(5, lVar2);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public as a() {
        this.f440218a = 0;
        this.f440219b = 0;
        this.f440220c = qu4.p.b();
        this.f440221d = qu4.l.b();
        this.f440222e = qu4.l.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
