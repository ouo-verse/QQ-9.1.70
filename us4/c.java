package us4;

import bs4.h;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public a[] f440010a;

    /* renamed from: b, reason: collision with root package name */
    public h[] f440011b;

    /* renamed from: c, reason: collision with root package name */
    public d f440012c;

    public c() {
        a();
    }

    public c a() {
        this.f440010a = a.b();
        this.f440011b = h.b();
        this.f440012c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                a[] aVarArr = this.f440010a;
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
                this.f440010a = aVarArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                h[] hVarArr = this.f440011b;
                int length2 = hVarArr == null ? 0 : hVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                h[] hVarArr2 = new h[i16];
                if (length2 != 0) {
                    System.arraycopy(hVarArr, 0, hVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    h hVar = new h();
                    hVarArr2[length2] = hVar;
                    codedInputByteBufferNano.readMessage(hVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                h hVar2 = new h();
                hVarArr2[length2] = hVar2;
                codedInputByteBufferNano.readMessage(hVar2);
                this.f440011b = hVarArr2;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f440012c == null) {
                    this.f440012c = new d();
                }
                codedInputByteBufferNano.readMessage(this.f440012c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        a[] aVarArr = this.f440010a;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f440010a;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
                }
                i16++;
            }
        }
        h[] hVarArr = this.f440011b;
        if (hVarArr != null && hVarArr.length > 0) {
            while (true) {
                h[] hVarArr2 = this.f440011b;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
                }
                i3++;
            }
        }
        d dVar = this.f440012c;
        return dVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, dVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a[] aVarArr = this.f440010a;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                a[] aVarArr2 = this.f440010a;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aVar);
                }
                i16++;
            }
        }
        h[] hVarArr = this.f440011b;
        if (hVarArr != null && hVarArr.length > 0) {
            while (true) {
                h[] hVarArr2 = this.f440011b;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, hVar);
                }
                i3++;
            }
        }
        d dVar = this.f440012c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
