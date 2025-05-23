package su4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public i[] f434776a;

    /* renamed from: b, reason: collision with root package name */
    public f[] f434777b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f434778c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f434779d;

    /* renamed from: e, reason: collision with root package name */
    public hu4.e f434780e;

    /* renamed from: f, reason: collision with root package name */
    public int f434781f;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f434776a = i.b();
        this.f434777b = f.b();
        this.f434778c = WireFormatNano.EMPTY_BYTES;
        this.f434779d = false;
        this.f434780e = null;
        this.f434781f = 0;
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
                i[] iVarArr = this.f434776a;
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
                this.f434776a = iVarArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                f[] fVarArr = this.f434777b;
                int length2 = fVarArr == null ? 0 : fVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                f[] fVarArr2 = new f[i16];
                if (length2 != 0) {
                    System.arraycopy(fVarArr, 0, fVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    f fVar = new f();
                    fVarArr2[length2] = fVar;
                    codedInputByteBufferNano.readMessage(fVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                f fVar2 = new f();
                fVarArr2[length2] = fVar2;
                codedInputByteBufferNano.readMessage(fVar2);
                this.f434777b = fVarArr2;
            } else if (readTag == 26) {
                this.f434778c = codedInputByteBufferNano.readBytes();
            } else if (readTag == 32) {
                this.f434779d = codedInputByteBufferNano.readBool();
            } else if (readTag == 42) {
                if (this.f434780e == null) {
                    this.f434780e = new hu4.e();
                }
                codedInputByteBufferNano.readMessage(this.f434780e);
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f434781f = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        i[] iVarArr = this.f434776a;
        int i3 = 0;
        if (iVarArr != null && iVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                i[] iVarArr2 = this.f434776a;
                if (i16 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i16];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iVar);
                }
                i16++;
            }
        }
        f[] fVarArr = this.f434777b;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                f[] fVarArr2 = this.f434777b;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i3];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, fVar);
                }
                i3++;
            }
        }
        if (!Arrays.equals(this.f434778c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f434778c);
        }
        boolean z16 = this.f434779d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        hu4.e eVar = this.f434780e;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, eVar);
        }
        int i17 = this.f434781f;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        i[] iVarArr = this.f434776a;
        int i3 = 0;
        if (iVarArr != null && iVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                i[] iVarArr2 = this.f434776a;
                if (i16 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i16];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, iVar);
                }
                i16++;
            }
        }
        f[] fVarArr = this.f434777b;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                f[] fVarArr2 = this.f434777b;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i3];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, fVar);
                }
                i3++;
            }
        }
        if (!Arrays.equals(this.f434778c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f434778c);
        }
        boolean z16 = this.f434779d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        hu4.e eVar = this.f434780e;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(5, eVar);
        }
        int i17 = this.f434781f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
