package qs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public c[] f429469a;

    /* renamed from: b, reason: collision with root package name */
    public d[] f429470b;

    /* renamed from: c, reason: collision with root package name */
    public long f429471c;

    public b() {
        a();
    }

    public b a() {
        this.f429469a = c.b();
        this.f429470b = d.b();
        this.f429471c = 0L;
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
                c[] cVarArr = this.f429469a;
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
                this.f429469a = cVarArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                d[] dVarArr = this.f429470b;
                int length2 = dVarArr == null ? 0 : dVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                d[] dVarArr2 = new d[i16];
                if (length2 != 0) {
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    d dVar = new d();
                    dVarArr2[length2] = dVar;
                    codedInputByteBufferNano.readMessage(dVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                d dVar2 = new d();
                dVarArr2[length2] = dVar2;
                codedInputByteBufferNano.readMessage(dVar2);
                this.f429470b = dVarArr2;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429471c = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        c[] cVarArr = this.f429469a;
        int i3 = 0;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                c[] cVarArr2 = this.f429469a;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
                }
                i16++;
            }
        }
        d[] dVarArr = this.f429470b;
        if (dVarArr != null && dVarArr.length > 0) {
            while (true) {
                d[] dVarArr2 = this.f429470b;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
                }
                i3++;
            }
        }
        long j3 = this.f429471c;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c[] cVarArr = this.f429469a;
        int i3 = 0;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                c[] cVarArr2 = this.f429469a;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, cVar);
                }
                i16++;
            }
        }
        d[] dVarArr = this.f429470b;
        if (dVarArr != null && dVarArr.length > 0) {
            while (true) {
                d[] dVarArr2 = this.f429470b;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, dVar);
                }
                i3++;
            }
        }
        long j3 = this.f429471c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
