package wp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
import np4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public c f446035a;

    /* renamed from: b, reason: collision with root package name */
    public pp4.b[] f446036b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f446037c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f446038d;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f446035a = null;
        this.f446036b = pp4.b.b();
        this.f446037c = false;
        this.f446038d = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f446038d = codedInputByteBufferNano.readBytes();
                            }
                        } else {
                            this.f446037c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        pp4.b[] bVarArr = this.f446036b;
                        if (bVarArr == null) {
                            length = 0;
                        } else {
                            length = bVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        pp4.b[] bVarArr2 = new pp4.b[i3];
                        if (length != 0) {
                            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            pp4.b bVar = new pp4.b();
                            bVarArr2[length] = bVar;
                            codedInputByteBufferNano.readMessage(bVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        pp4.b bVar2 = new pp4.b();
                        bVarArr2[length] = bVar2;
                        codedInputByteBufferNano.readMessage(bVar2);
                        this.f446036b = bVarArr2;
                    }
                } else {
                    if (this.f446035a == null) {
                        this.f446035a = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f446035a);
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
        c cVar = this.f446035a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        pp4.b[] bVarArr = this.f446036b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pp4.b[] bVarArr2 = this.f446036b;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                pp4.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f446037c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        if (!Arrays.equals(this.f446038d, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.f446038d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c cVar = this.f446035a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        pp4.b[] bVarArr = this.f446036b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pp4.b[] bVarArr2 = this.f446036b;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                pp4.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f446037c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!Arrays.equals(this.f446038d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.f446038d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
