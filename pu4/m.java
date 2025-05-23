package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public int f427493a;

    /* renamed from: b, reason: collision with root package name */
    public int f427494b;

    /* renamed from: c, reason: collision with root package name */
    public o[] f427495c;

    /* renamed from: d, reason: collision with root package name */
    public String f427496d;

    /* renamed from: e, reason: collision with root package name */
    public int f427497e;

    public m() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 16) {
                this.f427493a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f427494b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                o[] oVarArr = this.f427495c;
                int length = oVarArr == null ? 0 : oVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                o[] oVarArr2 = new o[i3];
                if (length != 0) {
                    System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    o oVar = new o();
                    oVarArr2[length] = oVar;
                    codedInputByteBufferNano.readMessage(oVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                o oVar2 = new o();
                oVarArr2[length] = oVar2;
                codedInputByteBufferNano.readMessage(oVar2);
                this.f427495c = oVarArr2;
            } else if (readTag == 42) {
                this.f427496d = codedInputByteBufferNano.readString();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427497e = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427493a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f427494b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        o[] oVarArr = this.f427495c;
        if (oVarArr != null && oVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                o[] oVarArr2 = this.f427495c;
                if (i17 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i17];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, oVar);
                }
                i17++;
            }
        }
        if (!this.f427496d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427496d);
        }
        int i18 = this.f427497e;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427493a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f427494b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        o[] oVarArr = this.f427495c;
        if (oVarArr != null && oVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                o[] oVarArr2 = this.f427495c;
                if (i17 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i17];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, oVar);
                }
                i17++;
            }
        }
        if (!this.f427496d.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427496d);
        }
        int i18 = this.f427497e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f427493a = 0;
        this.f427494b = 0;
        this.f427495c = o.b();
        this.f427496d = "";
        this.f427497e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
