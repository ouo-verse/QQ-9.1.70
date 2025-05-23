package x45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public g[] f447197a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f447198b;

    /* renamed from: c, reason: collision with root package name */
    public long f447199c;

    /* renamed from: d, reason: collision with root package name */
    public long f447200d;

    public b() {
        a();
    }

    public b a() {
        this.f447197a = g.b();
        this.f447198b = false;
        this.f447199c = 0L;
        this.f447200d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                g[] gVarArr = this.f447197a;
                int length = gVarArr == null ? 0 : gVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                g[] gVarArr2 = new g[i3];
                if (length != 0) {
                    System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    g gVar = new g();
                    gVarArr2[length] = gVar;
                    codedInputByteBufferNano.readMessage(gVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                g gVar2 = new g();
                gVarArr2[length] = gVar2;
                codedInputByteBufferNano.readMessage(gVar2);
                this.f447197a = gVarArr2;
            } else if (readTag == 16) {
                this.f447198b = codedInputByteBufferNano.readBool();
            } else if (readTag == 24) {
                this.f447199c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f447200d = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        g[] gVarArr = this.f447197a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f447197a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f447198b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        long j3 = this.f447199c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j16 = this.f447200d;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        g[] gVarArr = this.f447197a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f447197a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, gVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f447198b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        long j3 = this.f447199c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j16 = this.f447200d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
