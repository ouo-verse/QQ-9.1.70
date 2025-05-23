package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class aq extends ExtendableMessageNano<aq> {

    /* renamed from: a, reason: collision with root package name */
    public bs[] f429997a;

    public aq() {
        a();
    }

    public aq a() {
        this.f429997a = bs.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                bs[] bsVarArr = this.f429997a;
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
                this.f429997a = bsVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs[] bsVarArr = this.f429997a;
        if (bsVarArr != null && bsVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bs[] bsVarArr2 = this.f429997a;
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
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs[] bsVarArr = this.f429997a;
        if (bsVarArr != null && bsVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bs[] bsVarArr2 = this.f429997a;
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
        super.writeTo(codedOutputByteBufferNano);
    }
}
