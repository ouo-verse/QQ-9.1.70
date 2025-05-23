package rq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public e[] f431942a;

    /* renamed from: b, reason: collision with root package name */
    public b[] f431943b;

    public d() {
        a();
    }

    public d a() {
        this.f431942a = e.b();
        this.f431943b = b.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        b[] bVarArr = this.f431943b;
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
                        this.f431943b = bVarArr2;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    e[] eVarArr = this.f431942a;
                    if (eVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = eVarArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    e[] eVarArr2 = new e[i16];
                    if (length2 != 0) {
                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        e eVar = new e();
                        eVarArr2[length2] = eVar;
                        codedInputByteBufferNano.readMessage(eVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    e eVar2 = new e();
                    eVarArr2[length2] = eVar2;
                    codedInputByteBufferNano.readMessage(eVar2);
                    this.f431942a = eVarArr2;
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
        e[] eVarArr = this.f431942a;
        int i3 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f431942a;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
                }
                i16++;
            }
        }
        b[] bVarArr = this.f431943b;
        if (bVarArr != null && bVarArr.length > 0) {
            while (true) {
                b[] bVarArr2 = this.f431943b;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e[] eVarArr = this.f431942a;
        int i3 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f431942a;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, eVar);
                }
                i16++;
            }
        }
        b[] bVarArr = this.f431943b;
        if (bVarArr != null && bVarArr.length > 0) {
            while (true) {
                b[] bVarArr2 = this.f431943b;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
