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
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f448321a;

    /* renamed from: b, reason: collision with root package name */
    public i[] f448322b;

    /* renamed from: c, reason: collision with root package name */
    public qp4.a[] f448323c;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    public g a() {
        this.f448321a = null;
        this.f448322b = i.b();
        this.f448323c = qp4.a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            qp4.a[] aVarArr = this.f448323c;
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
                            this.f448323c = aVarArr2;
                        }
                    } else {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        i[] iVarArr = this.f448322b;
                        if (iVarArr == null) {
                            length2 = 0;
                        } else {
                            length2 = iVarArr.length;
                        }
                        int i16 = repeatedFieldArrayLength2 + length2;
                        i[] iVarArr2 = new i[i16];
                        if (length2 != 0) {
                            System.arraycopy(iVarArr, 0, iVarArr2, 0, length2);
                        }
                        while (length2 < i16 - 1) {
                            i iVar = new i();
                            iVarArr2[length2] = iVar;
                            codedInputByteBufferNano.readMessage(iVar);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        i iVar2 = new i();
                        iVarArr2[length2] = iVar2;
                        codedInputByteBufferNano.readMessage(iVar2);
                        this.f448322b = iVarArr2;
                    }
                } else {
                    if (this.f448321a == null) {
                        this.f448321a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f448321a);
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
        np4.c cVar = this.f448321a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        i[] iVarArr = this.f448322b;
        int i3 = 0;
        if (iVarArr != null && iVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                i[] iVarArr2 = this.f448322b;
                if (i16 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i16];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, iVar);
                }
                i16++;
            }
        }
        qp4.a[] aVarArr = this.f448323c;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                qp4.a[] aVarArr2 = this.f448323c;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                qp4.a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f448321a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        i[] iVarArr = this.f448322b;
        int i3 = 0;
        if (iVarArr != null && iVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                i[] iVarArr2 = this.f448322b;
                if (i16 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i16];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, iVar);
                }
                i16++;
            }
        }
        qp4.a[] aVarArr = this.f448323c;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                qp4.a[] aVarArr2 = this.f448323c;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                qp4.a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, aVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
