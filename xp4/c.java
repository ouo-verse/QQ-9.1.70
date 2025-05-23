package xp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f448309a;

    /* renamed from: b, reason: collision with root package name */
    public h[] f448310b;

    /* renamed from: c, reason: collision with root package name */
    public a[] f448311c;

    /* renamed from: d, reason: collision with root package name */
    public qp4.a[] f448312d;

    /* renamed from: e, reason: collision with root package name */
    public int f448313e;

    /* renamed from: f, reason: collision with root package name */
    public int f448314f;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f448309a = null;
        this.f448310b = h.b();
        this.f448311c = a.b();
        this.f448312d = qp4.a.b();
        this.f448313e = 0;
        this.f448314f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f448314f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f448313e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                qp4.a[] aVarArr = this.f448312d;
                                if (aVarArr == null) {
                                    length = 0;
                                } else {
                                    length = aVarArr.length;
                                }
                                int i3 = repeatedFieldArrayLength + length;
                                qp4.a[] aVarArr2 = new qp4.a[i3];
                                if (length != 0) {
                                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                                }
                                while (length < i3 - 1) {
                                    qp4.a aVar = new qp4.a();
                                    aVarArr2[length] = aVar;
                                    codedInputByteBufferNano.readMessage(aVar);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                qp4.a aVar2 = new qp4.a();
                                aVarArr2[length] = aVar2;
                                codedInputByteBufferNano.readMessage(aVar2);
                                this.f448312d = aVarArr2;
                            }
                        } else {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            a[] aVarArr3 = this.f448311c;
                            if (aVarArr3 == null) {
                                length2 = 0;
                            } else {
                                length2 = aVarArr3.length;
                            }
                            int i16 = repeatedFieldArrayLength2 + length2;
                            a[] aVarArr4 = new a[i16];
                            if (length2 != 0) {
                                System.arraycopy(aVarArr3, 0, aVarArr4, 0, length2);
                            }
                            while (length2 < i16 - 1) {
                                a aVar3 = new a();
                                aVarArr4[length2] = aVar3;
                                codedInputByteBufferNano.readMessage(aVar3);
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            a aVar4 = new a();
                            aVarArr4[length2] = aVar4;
                            codedInputByteBufferNano.readMessage(aVar4);
                            this.f448311c = aVarArr4;
                        }
                    } else {
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        h[] hVarArr = this.f448310b;
                        if (hVarArr == null) {
                            length3 = 0;
                        } else {
                            length3 = hVarArr.length;
                        }
                        int i17 = repeatedFieldArrayLength3 + length3;
                        h[] hVarArr2 = new h[i17];
                        if (length3 != 0) {
                            System.arraycopy(hVarArr, 0, hVarArr2, 0, length3);
                        }
                        while (length3 < i17 - 1) {
                            h hVar = new h();
                            hVarArr2[length3] = hVar;
                            codedInputByteBufferNano.readMessage(hVar);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        h hVar2 = new h();
                        hVarArr2[length3] = hVar2;
                        codedInputByteBufferNano.readMessage(hVar2);
                        this.f448310b = hVarArr2;
                    }
                } else {
                    if (this.f448309a == null) {
                        this.f448309a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f448309a);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        np4.c cVar = this.f448309a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        h[] hVarArr = this.f448310b;
        int i3 = 0;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f448310b;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f448311c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                a[] aVarArr2 = this.f448311c;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i17];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
                }
                i17++;
            }
        }
        qp4.a[] aVarArr3 = this.f448312d;
        if (aVarArr3 != null && aVarArr3.length > 0) {
            while (true) {
                qp4.a[] aVarArr4 = this.f448312d;
                if (i3 >= aVarArr4.length) {
                    break;
                }
                qp4.a aVar2 = aVarArr4[i3];
                if (aVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar2);
                }
                i3++;
            }
        }
        int i18 = this.f448313e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.f448314f;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f448309a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        h[] hVarArr = this.f448310b;
        int i3 = 0;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f448310b;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, hVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f448311c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                a[] aVarArr2 = this.f448311c;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i17];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, aVar);
                }
                i17++;
            }
        }
        qp4.a[] aVarArr3 = this.f448312d;
        if (aVarArr3 != null && aVarArr3.length > 0) {
            while (true) {
                qp4.a[] aVarArr4 = this.f448312d;
                if (i3 >= aVarArr4.length) {
                    break;
                }
                qp4.a aVar2 = aVarArr4[i3];
                if (aVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, aVar2);
                }
                i3++;
            }
        }
        int i18 = this.f448313e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.f448314f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
