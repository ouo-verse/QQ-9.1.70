package qt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public int f429541a;

    /* renamed from: b, reason: collision with root package name */
    public long f429542b;

    /* renamed from: c, reason: collision with root package name */
    public e[] f429543c;

    /* renamed from: d, reason: collision with root package name */
    public long f429544d;

    /* renamed from: e, reason: collision with root package name */
    public int f429545e;

    /* renamed from: f, reason: collision with root package name */
    public int f429546f;

    public f() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429541a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f429542b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                e[] eVarArr = this.f429543c;
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
                this.f429543c = eVarArr2;
            } else if (readTag == 32) {
                this.f429544d = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.f429545e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429546f = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429541a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.f429542b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        e[] eVarArr = this.f429543c;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f429543c;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
                }
                i16++;
            }
        }
        long j16 = this.f429544d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        int i17 = this.f429545e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.f429546f;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429541a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.f429542b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        e[] eVarArr = this.f429543c;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f429543c;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, eVar);
                }
                i16++;
            }
        }
        long j16 = this.f429544d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        int i17 = this.f429545e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.f429546f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f429541a = 0;
        this.f429542b = 0L;
        this.f429543c = e.b();
        this.f429544d = 0L;
        this.f429545e = 0;
        this.f429546f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
