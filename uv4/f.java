package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public e[] f440415a;

    /* renamed from: b, reason: collision with root package name */
    public int f440416b;

    /* renamed from: c, reason: collision with root package name */
    public String f440417c;

    /* renamed from: d, reason: collision with root package name */
    public String f440418d;

    public f() {
        a();
    }

    public f a() {
        this.f440415a = e.b();
        this.f440416b = 0;
        this.f440417c = "";
        this.f440418d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                e[] eVarArr = this.f440415a;
                int length = eVarArr == null ? 0 : eVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                e[] eVarArr2 = new e[i3];
                if (length != 0) {
                    System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    e eVar = new e();
                    eVarArr2[length] = eVar;
                    codedInputByteBufferNano.readMessage(eVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                e eVar2 = new e();
                eVarArr2[length] = eVar2;
                codedInputByteBufferNano.readMessage(eVar2);
                this.f440415a = eVarArr2;
            } else if (readTag == 16) {
                this.f440416b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f440417c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440418d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        e[] eVarArr = this.f440415a;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f440415a;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
                }
                i3++;
            }
        }
        int i16 = this.f440416b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f440417c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440417c);
        }
        return !this.f440418d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f440418d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e[] eVarArr = this.f440415a;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f440415a;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, eVar);
                }
                i3++;
            }
        }
        int i16 = this.f440416b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f440417c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440417c);
        }
        if (!this.f440418d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440418d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
