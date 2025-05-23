package u55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public zv4.c[] f438450a;

    /* renamed from: b, reason: collision with root package name */
    public long f438451b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f438452c;

    /* renamed from: d, reason: collision with root package name */
    public String f438453d;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f438450a = zv4.c.b();
        this.f438451b = 0L;
        this.f438452c = false;
        this.f438453d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                zv4.c[] cVarArr = this.f438450a;
                int length = cVarArr == null ? 0 : cVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                zv4.c[] cVarArr2 = new zv4.c[i3];
                if (length != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    zv4.c cVar = new zv4.c();
                    cVarArr2[length] = cVar;
                    codedInputByteBufferNano.readMessage(cVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                zv4.c cVar2 = new zv4.c();
                cVarArr2[length] = cVar2;
                codedInputByteBufferNano.readMessage(cVar2);
                this.f438450a = cVarArr2;
            } else if (readTag == 16) {
                this.f438451b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f438452c = codedInputByteBufferNano.readBool();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f438453d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        zv4.c[] cVarArr = this.f438450a;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zv4.c[] cVarArr2 = this.f438450a;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                zv4.c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
                }
                i3++;
            }
        }
        long j3 = this.f438451b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        boolean z16 = this.f438452c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        return !this.f438453d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f438453d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        zv4.c[] cVarArr = this.f438450a;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zv4.c[] cVarArr2 = this.f438450a;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                zv4.c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, cVar);
                }
                i3++;
            }
        }
        long j3 = this.f438451b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        boolean z16 = this.f438452c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!this.f438453d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f438453d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
