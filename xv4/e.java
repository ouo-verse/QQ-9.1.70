package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile e[] f448788f;

    /* renamed from: a, reason: collision with root package name */
    public z[] f448789a;

    /* renamed from: b, reason: collision with root package name */
    public int f448790b;

    /* renamed from: c, reason: collision with root package name */
    public int f448791c;

    /* renamed from: d, reason: collision with root package name */
    public int f448792d;

    /* renamed from: e, reason: collision with root package name */
    public String f448793e;

    public e() {
        a();
    }

    public static e[] b() {
        if (f448788f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448788f == null) {
                    f448788f = new e[0];
                }
            }
        }
        return f448788f;
    }

    public e a() {
        this.f448789a = z.b();
        this.f448790b = 0;
        this.f448791c = 0;
        this.f448792d = 0;
        this.f448793e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                z[] zVarArr = this.f448789a;
                int length = zVarArr == null ? 0 : zVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                z[] zVarArr2 = new z[i3];
                if (length != 0) {
                    System.arraycopy(zVarArr, 0, zVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    z zVar = new z();
                    zVarArr2[length] = zVar;
                    codedInputByteBufferNano.readMessage(zVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                z zVar2 = new z();
                zVarArr2[length] = zVar2;
                codedInputByteBufferNano.readMessage(zVar2);
                this.f448789a = zVarArr2;
            } else if (readTag == 16) {
                this.f448790b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                    this.f448791c = readInt32;
                }
            } else if (readTag == 32) {
                this.f448792d = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448793e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        z[] zVarArr = this.f448789a;
        if (zVarArr != null && zVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                z[] zVarArr2 = this.f448789a;
                if (i3 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i3];
                if (zVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, zVar);
                }
                i3++;
            }
        }
        int i16 = this.f448790b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f448791c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i17);
        }
        int i18 = this.f448792d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        return !this.f448793e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f448793e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        z[] zVarArr = this.f448789a;
        if (zVarArr != null && zVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                z[] zVarArr2 = this.f448789a;
                if (i3 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i3];
                if (zVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, zVar);
                }
                i3++;
            }
        }
        int i16 = this.f448790b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f448791c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i17);
        }
        int i18 = this.f448792d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        if (!this.f448793e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f448793e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
