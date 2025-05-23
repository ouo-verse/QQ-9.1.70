package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public l[] f439925a;

    /* renamed from: b, reason: collision with root package name */
    public c[] f439926b;

    /* renamed from: c, reason: collision with root package name */
    public s f439927c;

    public k() {
        a();
    }

    public k a() {
        this.f439925a = l.b();
        this.f439926b = c.b();
        this.f439927c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            if (this.f439927c == null) {
                                this.f439927c = new s();
                            }
                            codedInputByteBufferNano.readMessage(this.f439927c);
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        c[] cVarArr = this.f439926b;
                        if (cVarArr == null) {
                            length = 0;
                        } else {
                            length = cVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        c[] cVarArr2 = new c[i3];
                        if (length != 0) {
                            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            c cVar = new c();
                            cVarArr2[length] = cVar;
                            codedInputByteBufferNano.readMessage(cVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        c cVar2 = new c();
                        cVarArr2[length] = cVar2;
                        codedInputByteBufferNano.readMessage(cVar2);
                        this.f439926b = cVarArr2;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    l[] lVarArr = this.f439925a;
                    if (lVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = lVarArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    l[] lVarArr2 = new l[i16];
                    if (length2 != 0) {
                        System.arraycopy(lVarArr, 0, lVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        l lVar = new l();
                        lVarArr2[length2] = lVar;
                        codedInputByteBufferNano.readMessage(lVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    l lVar2 = new l();
                    lVarArr2[length2] = lVar2;
                    codedInputByteBufferNano.readMessage(lVar2);
                    this.f439925a = lVarArr2;
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
        l[] lVarArr = this.f439925a;
        int i3 = 0;
        if (lVarArr != null && lVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                l[] lVarArr2 = this.f439925a;
                if (i16 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i16];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, lVar);
                }
                i16++;
            }
        }
        c[] cVarArr = this.f439926b;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f439926b;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar);
                }
                i3++;
            }
        }
        s sVar = this.f439927c;
        if (sVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, sVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        l[] lVarArr = this.f439925a;
        int i3 = 0;
        if (lVarArr != null && lVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                l[] lVarArr2 = this.f439925a;
                if (i16 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i16];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, lVar);
                }
                i16++;
            }
        }
        c[] cVarArr = this.f439926b;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f439926b;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, cVar);
                }
                i3++;
            }
        }
        s sVar = this.f439927c;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(3, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
