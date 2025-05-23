package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.r[] f440435a;

    /* renamed from: b, reason: collision with root package name */
    public String f440436b;

    /* renamed from: c, reason: collision with root package name */
    public d f440437c;

    public p() {
        a();
    }

    public static p c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (p) MessageNano.mergeFrom(new p(), bArr);
    }

    public p a() {
        this.f440435a = pv4.r.b();
        this.f440436b = "";
        this.f440437c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                pv4.r[] rVarArr = this.f440435a;
                int length = rVarArr == null ? 0 : rVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                pv4.r[] rVarArr2 = new pv4.r[i3];
                if (length != 0) {
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    pv4.r rVar = new pv4.r();
                    rVarArr2[length] = rVar;
                    codedInputByteBufferNano.readMessage(rVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pv4.r rVar2 = new pv4.r();
                rVarArr2[length] = rVar2;
                codedInputByteBufferNano.readMessage(rVar2);
                this.f440435a = rVarArr2;
            } else if (readTag == 26) {
                if (this.f440437c == null) {
                    this.f440437c = new d();
                }
                codedInputByteBufferNano.readMessage(this.f440437c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440436b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.r[] rVarArr = this.f440435a;
        if (rVarArr != null && rVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pv4.r[] rVarArr2 = this.f440435a;
                if (i3 >= rVarArr2.length) {
                    break;
                }
                pv4.r rVar = rVarArr2[i3];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
                }
                i3++;
            }
        }
        d dVar = this.f440437c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        return !this.f440436b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f440436b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.r[] rVarArr = this.f440435a;
        if (rVarArr != null && rVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pv4.r[] rVarArr2 = this.f440435a;
                if (i3 >= rVarArr2.length) {
                    break;
                }
                pv4.r rVar = rVarArr2[i3];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, rVar);
                }
                i3++;
            }
        }
        d dVar = this.f440437c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        if (!this.f440436b.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440436b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
