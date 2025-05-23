package yv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public t55.b f451344a;

    /* renamed from: b, reason: collision with root package name */
    public long f451345b;

    /* renamed from: c, reason: collision with root package name */
    public long f451346c;

    /* renamed from: d, reason: collision with root package name */
    public a[] f451347d;

    /* renamed from: e, reason: collision with root package name */
    public String f451348e;

    /* renamed from: f, reason: collision with root package name */
    public String f451349f;

    public h() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f451344a == null) {
                    this.f451344a = new t55.b();
                }
                codedInputByteBufferNano.readMessage(this.f451344a);
            } else if (readTag == 16) {
                this.f451345b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f451346c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                a[] aVarArr = this.f451347d;
                int length = aVarArr == null ? 0 : aVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                a[] aVarArr2 = new a[i3];
                if (length != 0) {
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    a aVar = new a();
                    aVarArr2[length] = aVar;
                    codedInputByteBufferNano.readMessage(aVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                a aVar2 = new a();
                aVarArr2[length] = aVar2;
                codedInputByteBufferNano.readMessage(aVar2);
                this.f451347d = aVarArr2;
            } else if (readTag == 42) {
                this.f451348e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451349f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        t55.b bVar = this.f451344a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        long j3 = this.f451345b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f451346c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        a[] aVarArr = this.f451347d;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f451347d;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
                }
                i3++;
            }
        }
        if (!this.f451348e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f451348e);
        }
        return !this.f451349f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f451349f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        t55.b bVar = this.f451344a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        long j3 = this.f451345b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f451346c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        a[] aVarArr = this.f451347d;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f451347d;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, aVar);
                }
                i3++;
            }
        }
        if (!this.f451348e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451348e);
        }
        if (!this.f451349f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f451349f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f451344a = null;
        this.f451345b = 0L;
        this.f451346c = 0L;
        this.f451347d = a.b();
        this.f451348e = "";
        this.f451349f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
