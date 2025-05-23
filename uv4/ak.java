package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ak extends ExtendableMessageNano<ak> {

    /* renamed from: a, reason: collision with root package name */
    public int f440145a;

    /* renamed from: b, reason: collision with root package name */
    public al f440146b;

    /* renamed from: c, reason: collision with root package name */
    public al f440147c;

    /* renamed from: d, reason: collision with root package name */
    public al f440148d;

    /* renamed from: e, reason: collision with root package name */
    public int f440149e;

    /* renamed from: f, reason: collision with root package name */
    public az[] f440150f;

    /* renamed from: g, reason: collision with root package name */
    public bk[] f440151g;

    public ak() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ak mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440145a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.f440146b == null) {
                    this.f440146b = new al();
                }
                codedInputByteBufferNano.readMessage(this.f440146b);
            } else if (readTag == 26) {
                if (this.f440147c == null) {
                    this.f440147c = new al();
                }
                codedInputByteBufferNano.readMessage(this.f440147c);
            } else if (readTag == 34) {
                if (this.f440148d == null) {
                    this.f440148d = new al();
                }
                codedInputByteBufferNano.readMessage(this.f440148d);
            } else if (readTag == 40) {
                this.f440149e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                az[] azVarArr = this.f440150f;
                int length = azVarArr == null ? 0 : azVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                az[] azVarArr2 = new az[i3];
                if (length != 0) {
                    System.arraycopy(azVarArr, 0, azVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    az azVar = new az();
                    azVarArr2[length] = azVar;
                    codedInputByteBufferNano.readMessage(azVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                az azVar2 = new az();
                azVarArr2[length] = azVar2;
                codedInputByteBufferNano.readMessage(azVar2);
                this.f440150f = azVarArr2;
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                bk[] bkVarArr = this.f440151g;
                int length2 = bkVarArr == null ? 0 : bkVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                bk[] bkVarArr2 = new bk[i16];
                if (length2 != 0) {
                    System.arraycopy(bkVarArr, 0, bkVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    bk bkVar = new bk();
                    bkVarArr2[length2] = bkVar;
                    codedInputByteBufferNano.readMessage(bkVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                bk bkVar2 = new bk();
                bkVarArr2[length2] = bkVar2;
                codedInputByteBufferNano.readMessage(bkVar2);
                this.f440151g = bkVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440145a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        al alVar = this.f440146b;
        if (alVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, alVar);
        }
        al alVar2 = this.f440147c;
        if (alVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, alVar2);
        }
        al alVar3 = this.f440148d;
        if (alVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, alVar3);
        }
        int i16 = this.f440149e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        az[] azVarArr = this.f440150f;
        int i17 = 0;
        if (azVarArr != null && azVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                az[] azVarArr2 = this.f440150f;
                if (i18 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i18];
                if (azVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, azVar);
                }
                i18++;
            }
        }
        bk[] bkVarArr = this.f440151g;
        if (bkVarArr != null && bkVarArr.length > 0) {
            while (true) {
                bk[] bkVarArr2 = this.f440151g;
                if (i17 >= bkVarArr2.length) {
                    break;
                }
                bk bkVar = bkVarArr2[i17];
                if (bkVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, bkVar);
                }
                i17++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440145a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        al alVar = this.f440146b;
        if (alVar != null) {
            codedOutputByteBufferNano.writeMessage(2, alVar);
        }
        al alVar2 = this.f440147c;
        if (alVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, alVar2);
        }
        al alVar3 = this.f440148d;
        if (alVar3 != null) {
            codedOutputByteBufferNano.writeMessage(4, alVar3);
        }
        int i16 = this.f440149e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        az[] azVarArr = this.f440150f;
        int i17 = 0;
        if (azVarArr != null && azVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                az[] azVarArr2 = this.f440150f;
                if (i18 >= azVarArr2.length) {
                    break;
                }
                az azVar = azVarArr2[i18];
                if (azVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, azVar);
                }
                i18++;
            }
        }
        bk[] bkVarArr = this.f440151g;
        if (bkVarArr != null && bkVarArr.length > 0) {
            while (true) {
                bk[] bkVarArr2 = this.f440151g;
                if (i17 >= bkVarArr2.length) {
                    break;
                }
                bk bkVar = bkVarArr2[i17];
                if (bkVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, bkVar);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ak a() {
        this.f440145a = 0;
        this.f440146b = null;
        this.f440147c = null;
        this.f440148d = null;
        this.f440149e = 0;
        this.f440150f = az.b();
        this.f440151g = bk.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
