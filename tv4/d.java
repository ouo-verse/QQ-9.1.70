package tv4;

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
    public long f437568a;

    /* renamed from: b, reason: collision with root package name */
    public long f437569b;

    /* renamed from: c, reason: collision with root package name */
    public long f437570c;

    /* renamed from: d, reason: collision with root package name */
    public b[] f437571d;

    /* renamed from: e, reason: collision with root package name */
    public a[] f437572e;

    /* renamed from: f, reason: collision with root package name */
    public long f437573f;

    /* renamed from: g, reason: collision with root package name */
    public String f437574g;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f437568a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f437569b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f437570c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                b[] bVarArr = this.f437571d;
                int length = bVarArr == null ? 0 : bVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                b[] bVarArr2 = new b[i3];
                if (length != 0) {
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    b bVar = new b();
                    bVarArr2[length] = bVar;
                    codedInputByteBufferNano.readMessage(bVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                b bVar2 = new b();
                bVarArr2[length] = bVar2;
                codedInputByteBufferNano.readMessage(bVar2);
                this.f437571d = bVarArr2;
            } else if (readTag == 42) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                a[] aVarArr = this.f437572e;
                int length2 = aVarArr == null ? 0 : aVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                a[] aVarArr2 = new a[i16];
                if (length2 != 0) {
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    a aVar = new a();
                    aVarArr2[length2] = aVar;
                    codedInputByteBufferNano.readMessage(aVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                a aVar2 = new a();
                aVarArr2[length2] = aVar2;
                codedInputByteBufferNano.readMessage(aVar2);
                this.f437572e = aVarArr2;
            } else if (readTag == 48) {
                this.f437573f = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f437574g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f437568a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f437569b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f437570c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        b[] bVarArr = this.f437571d;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f437571d;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, bVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f437572e;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f437572e;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, aVar);
                }
                i3++;
            }
        }
        long j18 = this.f437573f;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j18);
        }
        return !this.f437574g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f437574g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f437568a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f437569b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f437570c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        b[] bVarArr = this.f437571d;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f437571d;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, bVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f437572e;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f437572e;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, aVar);
                }
                i3++;
            }
        }
        long j18 = this.f437573f;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j18);
        }
        if (!this.f437574g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f437574g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f437568a = 0L;
        this.f437569b = 0L;
        this.f437570c = 0L;
        this.f437571d = b.b();
        this.f437572e = a.b();
        this.f437573f = 0L;
        this.f437574g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
