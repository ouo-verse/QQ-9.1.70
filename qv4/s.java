package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public bs[] f430196a;

    /* renamed from: b, reason: collision with root package name */
    public int f430197b;

    /* renamed from: c, reason: collision with root package name */
    public int f430198c;

    public s() {
        a();
    }

    public s a() {
        this.f430196a = bs.b();
        this.f430197b = 0;
        this.f430198c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                bs[] bsVarArr = this.f430196a;
                int length = bsVarArr == null ? 0 : bsVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bs[] bsVarArr2 = new bs[i3];
                if (length != 0) {
                    System.arraycopy(bsVarArr, 0, bsVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bs bsVar = new bs();
                    bsVarArr2[length] = bsVar;
                    codedInputByteBufferNano.readMessage(bsVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bs bsVar2 = new bs();
                bsVarArr2[length] = bsVar2;
                codedInputByteBufferNano.readMessage(bsVar2);
                this.f430196a = bsVarArr2;
            } else if (readTag == 16) {
                this.f430197b = codedInputByteBufferNano.readInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430198c = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs[] bsVarArr = this.f430196a;
        if (bsVarArr != null && bsVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bs[] bsVarArr2 = this.f430196a;
                if (i3 >= bsVarArr2.length) {
                    break;
                }
                bs bsVar = bsVarArr2[i3];
                if (bsVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bsVar);
                }
                i3++;
            }
        }
        int i16 = this.f430197b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f430198c;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs[] bsVarArr = this.f430196a;
        if (bsVarArr != null && bsVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bs[] bsVarArr2 = this.f430196a;
                if (i3 >= bsVarArr2.length) {
                    break;
                }
                bs bsVar = bsVarArr2[i3];
                if (bsVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bsVar);
                }
                i3++;
            }
        }
        int i16 = this.f430197b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f430198c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
