package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ac extends ExtendableMessageNano<ac> {

    /* renamed from: a, reason: collision with root package name */
    public ad[] f448522a;

    /* renamed from: b, reason: collision with root package name */
    public int f448523b;

    /* renamed from: c, reason: collision with root package name */
    public u[] f448524c;

    public ac() {
        a();
    }

    public ac a() {
        this.f448522a = ad.b();
        this.f448523b = 0;
        this.f448524c = u.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ac mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                ad[] adVarArr = this.f448522a;
                int length = adVarArr == null ? 0 : adVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ad[] adVarArr2 = new ad[i3];
                if (length != 0) {
                    System.arraycopy(adVarArr, 0, adVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ad adVar = new ad();
                    adVarArr2[length] = adVar;
                    codedInputByteBufferNano.readMessage(adVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ad adVar2 = new ad();
                adVarArr2[length] = adVar2;
                codedInputByteBufferNano.readMessage(adVar2);
                this.f448522a = adVarArr2;
            } else if (readTag == 16) {
                this.f448523b = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                u[] uVarArr = this.f448524c;
                int length2 = uVarArr == null ? 0 : uVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                u[] uVarArr2 = new u[i16];
                if (length2 != 0) {
                    System.arraycopy(uVarArr, 0, uVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    u uVar = new u();
                    uVarArr2[length2] = uVar;
                    codedInputByteBufferNano.readMessage(uVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                u uVar2 = new u();
                uVarArr2[length2] = uVar2;
                codedInputByteBufferNano.readMessage(uVar2);
                this.f448524c = uVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ad[] adVarArr = this.f448522a;
        int i3 = 0;
        if (adVarArr != null && adVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ad[] adVarArr2 = this.f448522a;
                if (i16 >= adVarArr2.length) {
                    break;
                }
                ad adVar = adVarArr2[i16];
                if (adVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, adVar);
                }
                i16++;
            }
        }
        int i17 = this.f448523b;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i17);
        }
        u[] uVarArr = this.f448524c;
        if (uVarArr != null && uVarArr.length > 0) {
            while (true) {
                u[] uVarArr2 = this.f448524c;
                if (i3 >= uVarArr2.length) {
                    break;
                }
                u uVar = uVarArr2[i3];
                if (uVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, uVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ad[] adVarArr = this.f448522a;
        int i3 = 0;
        if (adVarArr != null && adVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ad[] adVarArr2 = this.f448522a;
                if (i16 >= adVarArr2.length) {
                    break;
                }
                ad adVar = adVarArr2[i16];
                if (adVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, adVar);
                }
                i16++;
            }
        }
        int i17 = this.f448523b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i17);
        }
        u[] uVarArr = this.f448524c;
        if (uVarArr != null && uVarArr.length > 0) {
            while (true) {
                u[] uVarArr2 = this.f448524c;
                if (i3 >= uVarArr2.length) {
                    break;
                }
                u uVar = uVarArr2[i3];
                if (uVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, uVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
