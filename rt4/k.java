package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public b[] f432418a;

    /* renamed from: b, reason: collision with root package name */
    public String f432419b;

    /* renamed from: c, reason: collision with root package name */
    public String f432420c;

    /* renamed from: d, reason: collision with root package name */
    public q[] f432421d;

    public k() {
        a();
    }

    public static k c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (k) MessageNano.mergeFrom(new k(), bArr);
    }

    public k a() {
        this.f432418a = b.b();
        this.f432419b = "";
        this.f432420c = "";
        this.f432421d = q.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                b[] bVarArr = this.f432418a;
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
                this.f432418a = bVarArr2;
            } else if (readTag == 18) {
                this.f432419b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f432420c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                q[] qVarArr = this.f432421d;
                int length2 = qVarArr == null ? 0 : qVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                q[] qVarArr2 = new q[i16];
                if (length2 != 0) {
                    System.arraycopy(qVarArr, 0, qVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    q qVar = new q();
                    qVarArr2[length2] = qVar;
                    codedInputByteBufferNano.readMessage(qVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                q qVar2 = new q();
                qVarArr2[length2] = qVar2;
                codedInputByteBufferNano.readMessage(qVar2);
                this.f432421d = qVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b[] bVarArr = this.f432418a;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f432418a;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
                }
                i16++;
            }
        }
        if (!this.f432419b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432419b);
        }
        if (!this.f432420c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432420c);
        }
        q[] qVarArr = this.f432421d;
        if (qVarArr != null && qVarArr.length > 0) {
            while (true) {
                q[] qVarArr2 = this.f432421d;
                if (i3 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i3];
                if (qVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, qVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b[] bVarArr = this.f432418a;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f432418a;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bVar);
                }
                i16++;
            }
        }
        if (!this.f432419b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432419b);
        }
        if (!this.f432420c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432420c);
        }
        q[] qVarArr = this.f432421d;
        if (qVarArr != null && qVarArr.length > 0) {
            while (true) {
                q[] qVarArr2 = this.f432421d;
                if (i3 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i3];
                if (qVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, qVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
