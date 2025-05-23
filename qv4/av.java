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
public final class av extends ExtendableMessageNano<av> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f430015a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f430016b;

    /* renamed from: c, reason: collision with root package name */
    public xu4.a[] f430017c;

    /* renamed from: d, reason: collision with root package name */
    public String f430018d;

    /* renamed from: e, reason: collision with root package name */
    public int f430019e;

    /* renamed from: f, reason: collision with root package name */
    public String f430020f;

    public av() {
        a();
    }

    public static av c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (av) MessageNano.mergeFrom(new av(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public av mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f430015a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.f430016b = codedInputByteBufferNano.readBool();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                xu4.a[] aVarArr = this.f430017c;
                int length = aVarArr == null ? 0 : aVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                xu4.a[] aVarArr2 = new xu4.a[i3];
                if (length != 0) {
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    xu4.a aVar = new xu4.a();
                    aVarArr2[length] = aVar;
                    codedInputByteBufferNano.readMessage(aVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                xu4.a aVar2 = new xu4.a();
                aVarArr2[length] = aVar2;
                codedInputByteBufferNano.readMessage(aVar2);
                this.f430017c = aVarArr2;
            } else if (readTag == 34) {
                this.f430018d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f430019e = codedInputByteBufferNano.readInt32();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430020f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f430015a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.f430016b;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z17);
        }
        xu4.a[] aVarArr = this.f430017c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                xu4.a[] aVarArr2 = this.f430017c;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                xu4.a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
                }
                i3++;
            }
        }
        if (!this.f430018d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430018d);
        }
        int i16 = this.f430019e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        return !this.f430020f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f430020f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f430015a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.f430016b;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        xu4.a[] aVarArr = this.f430017c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                xu4.a[] aVarArr2 = this.f430017c;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                xu4.a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, aVar);
                }
                i3++;
            }
        }
        if (!this.f430018d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430018d);
        }
        int i16 = this.f430019e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        if (!this.f430020f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f430020f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public av a() {
        this.f430015a = false;
        this.f430016b = false;
        this.f430017c = xu4.a.b();
        this.f430018d = "";
        this.f430019e = 0;
        this.f430020f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
