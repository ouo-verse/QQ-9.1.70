package qu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f429593a;

    /* renamed from: b, reason: collision with root package name */
    public int f429594b;

    /* renamed from: c, reason: collision with root package name */
    public i[] f429595c;

    /* renamed from: d, reason: collision with root package name */
    public long f429596d;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429593a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f429594b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                i[] iVarArr = this.f429595c;
                int length = iVarArr == null ? 0 : iVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                i[] iVarArr2 = new i[i3];
                if (length != 0) {
                    System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    i iVar = new i();
                    iVarArr2[length] = iVar;
                    codedInputByteBufferNano.readMessage(iVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                i iVar2 = new i();
                iVarArr2[length] = iVar2;
                codedInputByteBufferNano.readMessage(iVar2);
                this.f429595c = iVarArr2;
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429596d = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429593a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f429594b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        i[] iVarArr = this.f429595c;
        if (iVarArr != null && iVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                i[] iVarArr2 = this.f429595c;
                if (i17 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i17];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, iVar);
                }
                i17++;
            }
        }
        long j3 = this.f429596d;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429593a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f429594b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        i[] iVarArr = this.f429595c;
        if (iVarArr != null && iVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                i[] iVarArr2 = this.f429595c;
                if (i17 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i17];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, iVar);
                }
                i17++;
            }
        }
        long j3 = this.f429596d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f429593a = 0;
        this.f429594b = 0;
        this.f429595c = i.b();
        this.f429596d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
