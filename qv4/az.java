package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class az extends ExtendableMessageNano<az> {

    /* renamed from: a, reason: collision with root package name */
    public bs[] f430025a;

    /* renamed from: b, reason: collision with root package name */
    public String f430026b;

    /* renamed from: c, reason: collision with root package name */
    public String f430027c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f430028d;

    /* renamed from: e, reason: collision with root package name */
    public String f430029e;

    public az() {
        a();
    }

    public az a() {
        this.f430025a = bs.b();
        this.f430026b = "";
        this.f430027c = "";
        this.f430028d = false;
        this.f430029e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public az mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                bs[] bsVarArr = this.f430025a;
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
                this.f430025a = bsVarArr2;
            } else if (readTag == 18) {
                this.f430026b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f430027c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f430028d = codedInputByteBufferNano.readBool();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430029e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs[] bsVarArr = this.f430025a;
        if (bsVarArr != null && bsVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bs[] bsVarArr2 = this.f430025a;
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
        if (!this.f430026b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430026b);
        }
        if (!this.f430027c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430027c);
        }
        boolean z16 = this.f430028d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        return !this.f430029e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f430029e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs[] bsVarArr = this.f430025a;
        if (bsVarArr != null && bsVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bs[] bsVarArr2 = this.f430025a;
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
        if (!this.f430026b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430026b);
        }
        if (!this.f430027c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430027c);
        }
        boolean z16 = this.f430028d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        if (!this.f430029e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f430029e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
