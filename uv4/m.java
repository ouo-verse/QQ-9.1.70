package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public bd[] f440430a;

    /* renamed from: b, reason: collision with root package name */
    public int f440431b;

    public m() {
        a();
    }

    public m a() {
        this.f440430a = bd.b();
        this.f440431b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                bd[] bdVarArr = this.f440430a;
                int length = bdVarArr == null ? 0 : bdVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bd[] bdVarArr2 = new bd[i3];
                if (length != 0) {
                    System.arraycopy(bdVarArr, 0, bdVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bd bdVar = new bd();
                    bdVarArr2[length] = bdVar;
                    codedInputByteBufferNano.readMessage(bdVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bd bdVar2 = new bd();
                bdVarArr2[length] = bdVar2;
                codedInputByteBufferNano.readMessage(bdVar2);
                this.f440430a = bdVarArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440431b = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bd[] bdVarArr = this.f440430a;
        if (bdVarArr != null && bdVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bd[] bdVarArr2 = this.f440430a;
                if (i3 >= bdVarArr2.length) {
                    break;
                }
                bd bdVar = bdVarArr2[i3];
                if (bdVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bdVar);
                }
                i3++;
            }
        }
        int i16 = this.f440431b;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bd[] bdVarArr = this.f440430a;
        if (bdVarArr != null && bdVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bd[] bdVarArr2 = this.f440430a;
                if (i3 >= bdVarArr2.length) {
                    break;
                }
                bd bdVar = bdVarArr2[i3];
                if (bdVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bdVar);
                }
                i3++;
            }
        }
        int i16 = this.f440431b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
