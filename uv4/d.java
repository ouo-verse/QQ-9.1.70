package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.u f440399a;

    /* renamed from: b, reason: collision with root package name */
    public pv4.u f440400b;

    /* renamed from: c, reason: collision with root package name */
    public pu4.b[] f440401c;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f440399a == null) {
                    this.f440399a = new pv4.u();
                }
                codedInputByteBufferNano.readMessage(this.f440399a);
            } else if (readTag == 18) {
                if (this.f440400b == null) {
                    this.f440400b = new pv4.u();
                }
                codedInputByteBufferNano.readMessage(this.f440400b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                pu4.b[] bVarArr = this.f440401c;
                int length = bVarArr == null ? 0 : bVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                pu4.b[] bVarArr2 = new pu4.b[i3];
                if (length != 0) {
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    pu4.b bVar = new pu4.b();
                    bVarArr2[length] = bVar;
                    codedInputByteBufferNano.readMessage(bVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pu4.b bVar2 = new pu4.b();
                bVarArr2[length] = bVar2;
                codedInputByteBufferNano.readMessage(bVar2);
                this.f440401c = bVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.u uVar = this.f440399a;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, uVar);
        }
        pv4.u uVar2 = this.f440400b;
        if (uVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, uVar2);
        }
        pu4.b[] bVarArr = this.f440401c;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pu4.b[] bVarArr2 = this.f440401c;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                pu4.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.u uVar = this.f440399a;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(1, uVar);
        }
        pv4.u uVar2 = this.f440400b;
        if (uVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, uVar2);
        }
        pu4.b[] bVarArr = this.f440401c;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pu4.b[] bVarArr2 = this.f440401c;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                pu4.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, bVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f440399a = null;
        this.f440400b = null;
        this.f440401c = pu4.b.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
