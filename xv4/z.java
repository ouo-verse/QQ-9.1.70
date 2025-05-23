package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class z extends ExtendableMessageNano<z> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile z[] f448856h;

    /* renamed from: a, reason: collision with root package name */
    public long f448857a;

    /* renamed from: b, reason: collision with root package name */
    public int f448858b;

    /* renamed from: c, reason: collision with root package name */
    public String f448859c;

    /* renamed from: d, reason: collision with root package name */
    public String f448860d;

    /* renamed from: e, reason: collision with root package name */
    public int f448861e;

    /* renamed from: f, reason: collision with root package name */
    public ab[] f448862f;

    /* renamed from: g, reason: collision with root package name */
    public int f448863g;

    public z() {
        a();
    }

    public static z[] b() {
        if (f448856h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448856h == null) {
                    f448856h = new z[0];
                }
            }
        }
        return f448856h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448857a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f448858b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f448859c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f448860d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f448861e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                ab[] abVarArr = this.f448862f;
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
                this.f448862f = abVarArr2;
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448863g = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f448857a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f448858b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f448859c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448859c);
        }
        if (!this.f448860d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448860d);
        }
        int i16 = this.f448861e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        ab[] abVarArr = this.f448862f;
        if (abVarArr != null && abVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448862f;
                if (i17 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i17];
                if (abVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, abVar);
                }
                i17++;
            }
        }
        int i18 = this.f448863g;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448857a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f448858b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f448859c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448859c);
        }
        if (!this.f448860d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448860d);
        }
        int i16 = this.f448861e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        ab[] abVarArr = this.f448862f;
        if (abVarArr != null && abVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448862f;
                if (i17 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i17];
                if (abVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, abVar);
                }
                i17++;
            }
        }
        int i18 = this.f448863g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public z a() {
        this.f448857a = 0L;
        this.f448858b = 0;
        this.f448859c = "";
        this.f448860d = "";
        this.f448861e = 0;
        this.f448862f = ab.b();
        this.f448863g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
