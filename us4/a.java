package us4;

import bs4.h;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f440006d;

    /* renamed from: a, reason: collision with root package name */
    public String f440007a;

    /* renamed from: b, reason: collision with root package name */
    public String f440008b;

    /* renamed from: c, reason: collision with root package name */
    public h[] f440009c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f440006d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440006d == null) {
                    f440006d = new a[0];
                }
            }
        }
        return f440006d;
    }

    public a a() {
        this.f440007a = "";
        this.f440008b = "";
        this.f440009c = h.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440007a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f440008b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                h[] hVarArr = this.f440009c;
                int length = hVarArr == null ? 0 : hVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                h[] hVarArr2 = new h[i3];
                if (length != 0) {
                    System.arraycopy(hVarArr, 0, hVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    h hVar = new h();
                    hVarArr2[length] = hVar;
                    codedInputByteBufferNano.readMessage(hVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                h hVar2 = new h();
                hVarArr2[length] = hVar2;
                codedInputByteBufferNano.readMessage(hVar2);
                this.f440009c = hVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440007a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440007a);
        }
        if (!this.f440008b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440008b);
        }
        h[] hVarArr = this.f440009c;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f440009c;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440007a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440007a);
        }
        if (!this.f440008b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440008b);
        }
        h[] hVarArr = this.f440009c;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f440009c;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, hVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
