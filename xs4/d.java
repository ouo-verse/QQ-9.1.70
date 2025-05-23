package xs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import zr4.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f448476a;

    /* renamed from: b, reason: collision with root package name */
    public int f448477b;

    /* renamed from: c, reason: collision with root package name */
    public zr4.c[] f448478c;

    /* renamed from: d, reason: collision with root package name */
    public int f448479d;

    /* renamed from: e, reason: collision with root package name */
    public int f448480e;

    /* renamed from: f, reason: collision with root package name */
    public long f448481f;

    /* renamed from: g, reason: collision with root package name */
    public g f448482g;

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
                this.f448476a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f448477b = readInt32;
                }
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                zr4.c[] cVarArr = this.f448478c;
                int length = cVarArr == null ? 0 : cVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                zr4.c[] cVarArr2 = new zr4.c[i3];
                if (length != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    zr4.c cVar = new zr4.c();
                    cVarArr2[length] = cVar;
                    codedInputByteBufferNano.readMessage(cVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                zr4.c cVar2 = new zr4.c();
                cVarArr2[length] = cVar2;
                codedInputByteBufferNano.readMessage(cVar2);
                this.f448478c = cVarArr2;
            } else if (readTag == 32) {
                this.f448479d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f448480e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f448481f = codedInputByteBufferNano.readInt64();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448482g == null) {
                    this.f448482g = new g();
                }
                codedInputByteBufferNano.readMessage(this.f448482g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f448476a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f448477b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        zr4.c[] cVarArr = this.f448478c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                zr4.c[] cVarArr2 = this.f448478c;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                zr4.c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
                }
                i16++;
            }
        }
        int i17 = this.f448479d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f448480e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        long j3 = this.f448481f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j3);
        }
        g gVar = this.f448482g;
        return gVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, gVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f448476a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f448477b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        zr4.c[] cVarArr = this.f448478c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                zr4.c[] cVarArr2 = this.f448478c;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                zr4.c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, cVar);
                }
                i16++;
            }
        }
        int i17 = this.f448479d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f448480e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        long j3 = this.f448481f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j3);
        }
        g gVar = this.f448482g;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(7, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f448476a = false;
        this.f448477b = 0;
        this.f448478c = zr4.c.b();
        this.f448479d = 0;
        this.f448480e = 0;
        this.f448481f = 0L;
        this.f448482g = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
