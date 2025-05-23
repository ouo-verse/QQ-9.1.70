package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public ap[] f430199a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f430200b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f430201c;

    /* renamed from: d, reason: collision with root package name */
    public bg f430202d;

    public t() {
        a();
    }

    public static t c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (t) MessageNano.mergeFrom(new t(), bArr);
    }

    public t a() {
        this.f430199a = ap.b();
        this.f430200b = false;
        this.f430201c = false;
        this.f430202d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                ap[] apVarArr = this.f430199a;
                int length = apVarArr == null ? 0 : apVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ap[] apVarArr2 = new ap[i3];
                if (length != 0) {
                    System.arraycopy(apVarArr, 0, apVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ap apVar = new ap();
                    apVarArr2[length] = apVar;
                    codedInputByteBufferNano.readMessage(apVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ap apVar2 = new ap();
                apVarArr2[length] = apVar2;
                codedInputByteBufferNano.readMessage(apVar2);
                this.f430199a = apVarArr2;
            } else if (readTag == 16) {
                this.f430200b = codedInputByteBufferNano.readBool();
            } else if (readTag == 24) {
                this.f430201c = codedInputByteBufferNano.readBool();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f430202d == null) {
                    this.f430202d = new bg();
                }
                codedInputByteBufferNano.readMessage(this.f430202d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ap[] apVarArr = this.f430199a;
        if (apVarArr != null && apVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ap[] apVarArr2 = this.f430199a;
                if (i3 >= apVarArr2.length) {
                    break;
                }
                ap apVar = apVarArr2[i3];
                if (apVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, apVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f430200b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        boolean z17 = this.f430201c;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z17);
        }
        bg bgVar = this.f430202d;
        return bgVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, bgVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ap[] apVarArr = this.f430199a;
        if (apVarArr != null && apVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ap[] apVarArr2 = this.f430199a;
                if (i3 >= apVarArr2.length) {
                    break;
                }
                ap apVar = apVarArr2[i3];
                if (apVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, apVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f430200b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        boolean z17 = this.f430201c;
        if (z17) {
            codedOutputByteBufferNano.writeBool(3, z17);
        }
        bg bgVar = this.f430202d;
        if (bgVar != null) {
            codedOutputByteBufferNano.writeMessage(4, bgVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
