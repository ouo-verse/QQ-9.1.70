package qt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile h[] f429550h;

    /* renamed from: a, reason: collision with root package name */
    public int f429551a;

    /* renamed from: b, reason: collision with root package name */
    public long f429552b;

    /* renamed from: c, reason: collision with root package name */
    public long f429553c;

    /* renamed from: d, reason: collision with root package name */
    public e[] f429554d;

    /* renamed from: e, reason: collision with root package name */
    public int f429555e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f429556f;

    /* renamed from: g, reason: collision with root package name */
    public String f429557g;

    public h() {
        a();
    }

    public static h[] b() {
        if (f429550h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429550h == null) {
                    f429550h = new h[0];
                }
            }
        }
        return f429550h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429551a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f429552b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f429553c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                e[] eVarArr = this.f429554d;
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
                this.f429554d = eVarArr2;
            } else if (readTag == 40) {
                this.f429555e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 810) {
                this.f429556f = codedInputByteBufferNano.readBytes();
            } else if (readTag != 818) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429557g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429551a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.f429552b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f429553c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        e[] eVarArr = this.f429554d;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f429554d;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, eVar);
                }
                i16++;
            }
        }
        int i17 = this.f429555e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        if (!Arrays.equals(this.f429556f, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(101, this.f429556f);
        }
        return !this.f429557g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(102, this.f429557g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429551a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.f429552b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f429553c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        e[] eVarArr = this.f429554d;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f429554d;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, eVar);
                }
                i16++;
            }
        }
        int i17 = this.f429555e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        if (!Arrays.equals(this.f429556f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(101, this.f429556f);
        }
        if (!this.f429557g.equals("")) {
            codedOutputByteBufferNano.writeString(102, this.f429557g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f429551a = 0;
        this.f429552b = 0L;
        this.f429553c = 0L;
        this.f429554d = e.b();
        this.f429555e = 0;
        this.f429556f = WireFormatNano.EMPTY_BYTES;
        this.f429557g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
