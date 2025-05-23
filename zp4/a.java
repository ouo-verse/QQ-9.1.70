package zp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import vp4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public d[] f452990a;

    /* renamed from: b, reason: collision with root package name */
    public int f452991b;

    /* renamed from: c, reason: collision with root package name */
    public int f452992c;

    /* renamed from: d, reason: collision with root package name */
    public int f452993d;

    /* renamed from: e, reason: collision with root package name */
    public int f452994e;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f452990a = d.b();
        this.f452991b = 0;
        this.f452992c = 0;
        this.f452993d = 0;
        this.f452994e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f452994e = codedInputByteBufferNano.readInt32();
                                }
                            } else {
                                this.f452993d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f452992c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f452991b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    d[] dVarArr = this.f452990a;
                    if (dVarArr == null) {
                        length = 0;
                    } else {
                        length = dVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    d[] dVarArr2 = new d[i3];
                    if (length != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        d dVar = new d();
                        dVarArr2[length] = dVar;
                        codedInputByteBufferNano.readMessage(dVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    d dVar2 = new d();
                    dVarArr2[length] = dVar2;
                    codedInputByteBufferNano.readMessage(dVar2);
                    this.f452990a = dVarArr2;
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        d[] dVarArr = this.f452990a;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f452990a;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
                }
                i3++;
            }
        }
        int i16 = this.f452991b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f452992c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f452993d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        int i19 = this.f452994e;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d[] dVarArr = this.f452990a;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f452990a;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, dVar);
                }
                i3++;
            }
        }
        int i16 = this.f452991b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f452992c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f452993d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        int i19 = this.f452994e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
