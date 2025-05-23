package rr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f432118a;

    /* renamed from: b, reason: collision with root package name */
    public String f432119b;

    /* renamed from: c, reason: collision with root package name */
    public h[] f432120c;

    public f() {
        a();
    }

    public f a() {
        this.f432118a = "";
        this.f432119b = "";
        this.f432120c = h.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 42) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                            h[] hVarArr = this.f432120c;
                            if (hVarArr == null) {
                                length = 0;
                            } else {
                                length = hVarArr.length;
                            }
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
                            this.f432120c = hVarArr2;
                        }
                    } else {
                        this.f432119b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432118a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f432118a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432118a);
        }
        if (!this.f432119b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432119b);
        }
        h[] hVarArr = this.f432120c;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f432120c;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, hVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432118a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432118a);
        }
        if (!this.f432119b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432119b);
        }
        h[] hVarArr = this.f432120c;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f432120c;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, hVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
