package qt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile j[] f429559d;

    /* renamed from: a, reason: collision with root package name */
    public long f429560a;

    /* renamed from: b, reason: collision with root package name */
    public e[] f429561b;

    /* renamed from: c, reason: collision with root package name */
    public int f429562c;

    public j() {
        a();
    }

    public static j[] b() {
        if (f429559d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429559d == null) {
                    f429559d = new j[0];
                }
            }
        }
        return f429559d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429560a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                e[] eVarArr = this.f429561b;
                int length = eVarArr == null ? 0 : eVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                e[] eVarArr2 = new e[i3];
                if (length != 0) {
                    System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    e eVar = new e();
                    eVarArr2[length] = eVar;
                    codedInputByteBufferNano.readMessage(eVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                e eVar2 = new e();
                eVarArr2[length] = eVar2;
                codedInputByteBufferNano.readMessage(eVar2);
                this.f429561b = eVarArr2;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429562c = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f429560a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        e[] eVarArr = this.f429561b;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f429561b;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
                }
                i3++;
            }
        }
        int i16 = this.f429562c;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f429560a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        e[] eVarArr = this.f429561b;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f429561b;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, eVar);
                }
                i3++;
            }
        }
        int i16 = this.f429562c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f429560a = 0L;
        this.f429561b = e.b();
        this.f429562c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
