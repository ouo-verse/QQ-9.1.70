package qp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile a[] f429196f;

    /* renamed from: a, reason: collision with root package name */
    public int f429197a;

    /* renamed from: b, reason: collision with root package name */
    public e f429198b;

    /* renamed from: c, reason: collision with root package name */
    public c[] f429199c;

    /* renamed from: d, reason: collision with root package name */
    public b[] f429200d;

    /* renamed from: e, reason: collision with root package name */
    public d f429201e;

    public a() {
        a();
    }

    public static a[] b() {
        if (f429196f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429196f == null) {
                    f429196f = new a[0];
                }
            }
        }
        return f429196f;
    }

    public a a() {
        this.f429197a = 0;
        this.f429198b = null;
        this.f429199c = c.b();
        this.f429200d = b.b();
        this.f429201e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    if (this.f429201e == null) {
                                        this.f429201e = new d();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f429201e);
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                b[] bVarArr = this.f429200d;
                                if (bVarArr == null) {
                                    length = 0;
                                } else {
                                    length = bVarArr.length;
                                }
                                int i3 = repeatedFieldArrayLength + length;
                                b[] bVarArr2 = new b[i3];
                                if (length != 0) {
                                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                }
                                while (length < i3 - 1) {
                                    b bVar = new b();
                                    bVarArr2[length] = bVar;
                                    codedInputByteBufferNano.readMessage(bVar);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                b bVar2 = new b();
                                bVarArr2[length] = bVar2;
                                codedInputByteBufferNano.readMessage(bVar2);
                                this.f429200d = bVarArr2;
                            }
                        } else {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            c[] cVarArr = this.f429199c;
                            if (cVarArr == null) {
                                length2 = 0;
                            } else {
                                length2 = cVarArr.length;
                            }
                            int i16 = repeatedFieldArrayLength2 + length2;
                            c[] cVarArr2 = new c[i16];
                            if (length2 != 0) {
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length2);
                            }
                            while (length2 < i16 - 1) {
                                c cVar = new c();
                                cVarArr2[length2] = cVar;
                                codedInputByteBufferNano.readMessage(cVar);
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            c cVar2 = new c();
                            cVarArr2[length2] = cVar2;
                            codedInputByteBufferNano.readMessage(cVar2);
                            this.f429199c = cVarArr2;
                        }
                    } else {
                        if (this.f429198b == null) {
                            this.f429198b = new e();
                        }
                        codedInputByteBufferNano.readMessage(this.f429198b);
                    }
                } else {
                    this.f429197a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f429197a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        e eVar = this.f429198b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        c[] cVarArr = this.f429199c;
        int i16 = 0;
        if (cVarArr != null && cVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                c[] cVarArr2 = this.f429199c;
                if (i17 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i17];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
                }
                i17++;
            }
        }
        b[] bVarArr = this.f429200d;
        if (bVarArr != null && bVarArr.length > 0) {
            while (true) {
                b[] bVarArr2 = this.f429200d;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, bVar);
                }
                i16++;
            }
        }
        d dVar = this.f429201e;
        if (dVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, dVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429197a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        e eVar = this.f429198b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        c[] cVarArr = this.f429199c;
        int i16 = 0;
        if (cVarArr != null && cVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                c[] cVarArr2 = this.f429199c;
                if (i17 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i17];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, cVar);
                }
                i17++;
            }
        }
        b[] bVarArr = this.f429200d;
        if (bVarArr != null && bVarArr.length > 0) {
            while (true) {
                b[] bVarArr2 = this.f429200d;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, bVar);
                }
                i16++;
            }
        }
        d dVar = this.f429201e;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(5, dVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
