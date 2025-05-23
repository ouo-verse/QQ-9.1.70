package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ag extends ExtendableMessageNano<ag> {

    /* renamed from: a, reason: collision with root package name */
    public bs[] f429908a;

    /* renamed from: b, reason: collision with root package name */
    public String f429909b;

    /* renamed from: c, reason: collision with root package name */
    public String f429910c;

    /* renamed from: d, reason: collision with root package name */
    public String f429911d;

    /* renamed from: e, reason: collision with root package name */
    public az f429912e;

    /* renamed from: f, reason: collision with root package name */
    public int f429913f;

    /* renamed from: g, reason: collision with root package name */
    public int f429914g;

    public ag() {
        a();
    }

    public ag a() {
        this.f429908a = bs.b();
        this.f429909b = "";
        this.f429910c = "";
        this.f429911d = "";
        this.f429912e = null;
        this.f429913f = 0;
        this.f429914g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ag mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                bs[] bsVarArr = this.f429908a;
                int length = bsVarArr == null ? 0 : bsVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bs[] bsVarArr2 = new bs[i3];
                if (length != 0) {
                    System.arraycopy(bsVarArr, 0, bsVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bs bsVar = new bs();
                    bsVarArr2[length] = bsVar;
                    codedInputByteBufferNano.readMessage(bsVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bs bsVar2 = new bs();
                bsVarArr2[length] = bsVar2;
                codedInputByteBufferNano.readMessage(bsVar2);
                this.f429908a = bsVarArr2;
            } else if (readTag == 18) {
                this.f429909b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f429910c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f429911d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                if (this.f429912e == null) {
                    this.f429912e = new az();
                }
                codedInputByteBufferNano.readMessage(this.f429912e);
            } else if (readTag == 48) {
                this.f429913f = codedInputByteBufferNano.readInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429914g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bs[] bsVarArr = this.f429908a;
        if (bsVarArr != null && bsVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bs[] bsVarArr2 = this.f429908a;
                if (i3 >= bsVarArr2.length) {
                    break;
                }
                bs bsVar = bsVarArr2[i3];
                if (bsVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bsVar);
                }
                i3++;
            }
        }
        if (!this.f429909b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f429909b);
        }
        if (!this.f429910c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f429910c);
        }
        if (!this.f429911d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f429911d);
        }
        az azVar = this.f429912e;
        if (azVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, azVar);
        }
        int i16 = this.f429913f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        int i17 = this.f429914g;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bs[] bsVarArr = this.f429908a;
        if (bsVarArr != null && bsVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bs[] bsVarArr2 = this.f429908a;
                if (i3 >= bsVarArr2.length) {
                    break;
                }
                bs bsVar = bsVarArr2[i3];
                if (bsVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bsVar);
                }
                i3++;
            }
        }
        if (!this.f429909b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f429909b);
        }
        if (!this.f429910c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429910c);
        }
        if (!this.f429911d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429911d);
        }
        az azVar = this.f429912e;
        if (azVar != null) {
            codedOutputByteBufferNano.writeMessage(5, azVar);
        }
        int i16 = this.f429913f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        int i17 = this.f429914g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
