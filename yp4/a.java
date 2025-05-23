package yp4;

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
    public d f450783a;

    /* renamed from: b, reason: collision with root package name */
    public d[] f450784b;

    /* renamed from: c, reason: collision with root package name */
    public int f450785c;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f450783a = null;
        this.f450784b = d.b();
        this.f450785c = 0;
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
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f450785c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        d[] dVarArr = this.f450784b;
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
                        this.f450784b = dVarArr2;
                    }
                } else {
                    if (this.f450783a == null) {
                        this.f450783a = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f450783a);
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
        d dVar = this.f450783a;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
        }
        d[] dVarArr = this.f450784b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f450784b;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar2 = dVarArr2[i3];
                if (dVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar2);
                }
                i3++;
            }
        }
        int i16 = this.f450785c;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d dVar = this.f450783a;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(1, dVar);
        }
        d[] dVarArr = this.f450784b;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f450784b;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar2 = dVarArr2[i3];
                if (dVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, dVar2);
                }
                i3++;
            }
        }
        int i16 = this.f450785c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
