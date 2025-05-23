package yu4;

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
    public int f451269a;

    /* renamed from: b, reason: collision with root package name */
    public String f451270b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f451271c;

    /* renamed from: d, reason: collision with root package name */
    public c[] f451272d;

    /* renamed from: e, reason: collision with root package name */
    public long f451273e;

    /* renamed from: f, reason: collision with root package name */
    public int f451274f;

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
                this.f451269a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.f451270b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f451271c = codedInputByteBufferNano.readBytes();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                c[] cVarArr = this.f451272d;
                int length = cVarArr == null ? 0 : cVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                c[] cVarArr2 = new c[i3];
                if (length != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    c cVar = new c();
                    cVarArr2[length] = cVar;
                    codedInputByteBufferNano.readMessage(cVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                c cVar2 = new c();
                cVarArr2[length] = cVar2;
                codedInputByteBufferNano.readMessage(cVar2);
                this.f451272d = cVarArr2;
            } else if (readTag == 40) {
                this.f451273e = codedInputByteBufferNano.readInt64();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451274f = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f451269a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f451270b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451270b);
        }
        if (!Arrays.equals(this.f451271c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f451271c);
        }
        c[] cVarArr = this.f451272d;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                c[] cVarArr2 = this.f451272d;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
                }
                i16++;
            }
        }
        long j3 = this.f451273e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
        }
        int i17 = this.f451274f;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451269a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f451270b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451270b);
        }
        if (!Arrays.equals(this.f451271c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f451271c);
        }
        c[] cVarArr = this.f451272d;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                c[] cVarArr2 = this.f451272d;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, cVar);
                }
                i16++;
            }
        }
        long j3 = this.f451273e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j3);
        }
        int i17 = this.f451274f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f451269a = 0;
        this.f451270b = "";
        this.f451271c = WireFormatNano.EMPTY_BYTES;
        this.f451272d = c.b();
        this.f451273e = 0L;
        this.f451274f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
