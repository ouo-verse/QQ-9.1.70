package uq4;

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
    public a[] f439826a;

    /* renamed from: b, reason: collision with root package name */
    public d f439827b;

    /* renamed from: c, reason: collision with root package name */
    public g f439828c;

    /* renamed from: d, reason: collision with root package name */
    public e[] f439829d;

    /* renamed from: e, reason: collision with root package name */
    public f f439830e;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f439826a = a.b();
        this.f439827b = null;
        this.f439828c = null;
        this.f439829d = e.b();
        this.f439830e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 26) {
                        if (readTag != 34) {
                            if (readTag != 42) {
                                if (readTag != 50) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    if (this.f439830e == null) {
                                        this.f439830e = new f();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f439830e);
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                e[] eVarArr = this.f439829d;
                                if (eVarArr == null) {
                                    length = 0;
                                } else {
                                    length = eVarArr.length;
                                }
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
                                this.f439829d = eVarArr2;
                            }
                        } else {
                            if (this.f439828c == null) {
                                this.f439828c = new g();
                            }
                            codedInputByteBufferNano.readMessage(this.f439828c);
                        }
                    } else {
                        if (this.f439827b == null) {
                            this.f439827b = new d();
                        }
                        codedInputByteBufferNano.readMessage(this.f439827b);
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    a[] aVarArr = this.f439826a;
                    if (aVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = aVarArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    a[] aVarArr2 = new a[i16];
                    if (length2 != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        a aVar = new a();
                        aVarArr2[length2] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    a aVar2 = new a();
                    aVarArr2[length2] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f439826a = aVarArr2;
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
        a[] aVarArr = this.f439826a;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f439826a;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
                }
                i16++;
            }
        }
        d dVar = this.f439827b;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        g gVar = this.f439828c;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, gVar);
        }
        e[] eVarArr = this.f439829d;
        if (eVarArr != null && eVarArr.length > 0) {
            while (true) {
                e[] eVarArr2 = this.f439829d;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, eVar);
                }
                i3++;
            }
        }
        f fVar = this.f439830e;
        if (fVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, fVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a[] aVarArr = this.f439826a;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f439826a;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aVar);
                }
                i16++;
            }
        }
        d dVar = this.f439827b;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        g gVar = this.f439828c;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(4, gVar);
        }
        e[] eVarArr = this.f439829d;
        if (eVarArr != null && eVarArr.length > 0) {
            while (true) {
                e[] eVarArr2 = this.f439829d;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, eVar);
                }
                i3++;
            }
        }
        f fVar = this.f439830e;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(6, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
