package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public String f449415a;

    /* renamed from: b, reason: collision with root package name */
    public int f449416b;

    /* renamed from: c, reason: collision with root package name */
    public o[] f449417c;

    /* renamed from: d, reason: collision with root package name */
    public int f449418d;

    public k() {
        a();
    }

    public k a() {
        this.f449415a = "";
        this.f449416b = 0;
        this.f449417c = o.b();
        this.f449418d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f449418d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            o[] oVarArr = this.f449417c;
                            if (oVarArr == null) {
                                length = 0;
                            } else {
                                length = oVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            o[] oVarArr2 = new o[i3];
                            if (length != 0) {
                                System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                o oVar = new o();
                                oVarArr2[length] = oVar;
                                codedInputByteBufferNano.readMessage(oVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            o oVar2 = new o();
                            oVarArr2[length] = oVar2;
                            codedInputByteBufferNano.readMessage(oVar2);
                            this.f449417c = oVarArr2;
                        }
                    } else {
                        this.f449416b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f449415a = codedInputByteBufferNano.readString();
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
        if (!this.f449415a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f449415a);
        }
        int i3 = this.f449416b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        o[] oVarArr = this.f449417c;
        if (oVarArr != null && oVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                o[] oVarArr2 = this.f449417c;
                if (i16 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i16];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, oVar);
                }
                i16++;
            }
        }
        int i17 = this.f449418d;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f449415a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f449415a);
        }
        int i3 = this.f449416b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        o[] oVarArr = this.f449417c;
        if (oVarArr != null && oVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                o[] oVarArr2 = this.f449417c;
                if (i16 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i16];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, oVar);
                }
                i16++;
            }
        }
        int i17 = this.f449418d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
