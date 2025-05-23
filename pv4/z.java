package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class z extends ExtendableMessageNano<z> {

    /* renamed from: a, reason: collision with root package name */
    public aa[] f427744a;

    /* renamed from: b, reason: collision with root package name */
    public String f427745b;

    public z() {
        a();
    }

    public z a() {
        this.f427744a = aa.b();
        this.f427745b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                aa[] aaVarArr = this.f427744a;
                int length = aaVarArr == null ? 0 : aaVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                aa[] aaVarArr2 = new aa[i3];
                if (length != 0) {
                    System.arraycopy(aaVarArr, 0, aaVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    aa aaVar = new aa();
                    aaVarArr2[length] = aaVar;
                    codedInputByteBufferNano.readMessage(aaVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                aa aaVar2 = new aa();
                aaVarArr2[length] = aaVar2;
                codedInputByteBufferNano.readMessage(aaVar2);
                this.f427744a = aaVarArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427745b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        aa[] aaVarArr = this.f427744a;
        if (aaVarArr != null && aaVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                aa[] aaVarArr2 = this.f427744a;
                if (i3 >= aaVarArr2.length) {
                    break;
                }
                aa aaVar = aaVarArr2[i3];
                if (aaVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aaVar);
                }
                i3++;
            }
        }
        return !this.f427745b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f427745b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        aa[] aaVarArr = this.f427744a;
        if (aaVarArr != null && aaVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                aa[] aaVarArr2 = this.f427744a;
                if (i3 >= aaVarArr2.length) {
                    break;
                }
                aa aaVar = aaVarArr2[i3];
                if (aaVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aaVar);
                }
                i3++;
            }
        }
        if (!this.f427745b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427745b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
