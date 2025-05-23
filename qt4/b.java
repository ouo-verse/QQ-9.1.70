package qt4;

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
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f429525a;

    /* renamed from: b, reason: collision with root package name */
    public j[] f429526b;

    /* renamed from: c, reason: collision with root package name */
    public int f429527c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f429528d;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429525a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                j[] jVarArr = this.f429526b;
                int length = jVarArr == null ? 0 : jVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                j[] jVarArr2 = new j[i3];
                if (length != 0) {
                    System.arraycopy(jVarArr, 0, jVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    j jVar = new j();
                    jVarArr2[length] = jVar;
                    codedInputByteBufferNano.readMessage(jVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                j jVar2 = new j();
                jVarArr2[length] = jVar2;
                codedInputByteBufferNano.readMessage(jVar2);
                this.f429526b = jVarArr2;
            } else if (readTag == 80) {
                this.f429527c = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 90) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429528d = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429525a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        j[] jVarArr = this.f429526b;
        if (jVarArr != null && jVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                j[] jVarArr2 = this.f429526b;
                if (i16 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i16];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, jVar);
                }
                i16++;
            }
        }
        int i17 = this.f429527c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        return !Arrays.equals(this.f429528d, WireFormatNano.EMPTY_BYTES) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(11, this.f429528d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429525a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        j[] jVarArr = this.f429526b;
        if (jVarArr != null && jVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                j[] jVarArr2 = this.f429526b;
                if (i16 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i16];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, jVar);
                }
                i16++;
            }
        }
        int i17 = this.f429527c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        if (!Arrays.equals(this.f429528d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(11, this.f429528d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f429525a = 0;
        this.f429526b = j.b();
        this.f429527c = 0;
        this.f429528d = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
