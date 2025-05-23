package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: a, reason: collision with root package name */
    public int f448822a;

    /* renamed from: b, reason: collision with root package name */
    public int f448823b;

    /* renamed from: c, reason: collision with root package name */
    public String f448824c;

    /* renamed from: d, reason: collision with root package name */
    public int f448825d;

    /* renamed from: e, reason: collision with root package name */
    public int f448826e;

    /* renamed from: f, reason: collision with root package name */
    public int f448827f;

    /* renamed from: g, reason: collision with root package name */
    public ab[] f448828g;

    /* renamed from: h, reason: collision with root package name */
    public long f448829h;

    /* renamed from: i, reason: collision with root package name */
    public long f448830i;

    public v() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448822a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f448823b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f448824c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f448825d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f448826e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f448827f = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 58) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                ab[] abVarArr = this.f448828g;
                int length = abVarArr == null ? 0 : abVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ab[] abVarArr2 = new ab[i3];
                if (length != 0) {
                    System.arraycopy(abVarArr, 0, abVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ab abVar = new ab();
                    abVarArr2[length] = abVar;
                    codedInputByteBufferNano.readMessage(abVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ab abVar2 = new ab();
                abVarArr2[length] = abVar2;
                codedInputByteBufferNano.readMessage(abVar2);
                this.f448828g = abVarArr2;
            } else if (readTag == 64) {
                this.f448829h = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448830i = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f448822a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f448823b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f448824c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448824c);
        }
        int i17 = this.f448825d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f448826e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.f448827f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        ab[] abVarArr = this.f448828g;
        if (abVarArr != null && abVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448828g;
                if (i26 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i26];
                if (abVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, abVar);
                }
                i26++;
            }
        }
        long j3 = this.f448829h;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j3);
        }
        long j16 = this.f448830i;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448822a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f448823b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f448824c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448824c);
        }
        int i17 = this.f448825d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f448826e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.f448827f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        ab[] abVarArr = this.f448828g;
        if (abVarArr != null && abVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448828g;
                if (i26 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i26];
                if (abVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, abVar);
                }
                i26++;
            }
        }
        long j3 = this.f448829h;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j3);
        }
        long j16 = this.f448830i;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public v a() {
        this.f448822a = 0;
        this.f448823b = 0;
        this.f448824c = "";
        this.f448825d = 0;
        this.f448826e = 0;
        this.f448827f = 0;
        this.f448828g = ab.b();
        this.f448829h = 0L;
        this.f448830i = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
