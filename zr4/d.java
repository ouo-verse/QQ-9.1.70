package zr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f453090a;

    /* renamed from: b, reason: collision with root package name */
    public long f453091b;

    /* renamed from: c, reason: collision with root package name */
    public int f453092c;

    /* renamed from: d, reason: collision with root package name */
    public int f453093d;

    /* renamed from: e, reason: collision with root package name */
    public long f453094e;

    /* renamed from: f, reason: collision with root package name */
    public long f453095f;

    /* renamed from: g, reason: collision with root package name */
    public long[] f453096g;

    /* renamed from: h, reason: collision with root package name */
    public long f453097h;

    /* renamed from: i, reason: collision with root package name */
    public long f453098i;

    /* renamed from: j, reason: collision with root package name */
    public int f453099j;

    /* renamed from: k, reason: collision with root package name */
    public int f453100k;

    /* renamed from: l, reason: collision with root package name */
    public int f453101l;

    public d() {
        a();
    }

    public d a() {
        this.f453090a = "";
        this.f453091b = 0L;
        this.f453092c = 0;
        this.f453093d = 0;
        this.f453094e = 0L;
        this.f453095f = 0L;
        this.f453096g = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f453097h = 0L;
        this.f453098i = 0L;
        this.f453099j = 0;
        this.f453100k = 0;
        this.f453101l = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f453090a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f453091b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                        switch (readInt32) {
                        }
                    }
                    this.f453092c = readInt32;
                    break;
                case 32:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                        break;
                    } else {
                        this.f453093d = readInt322;
                        break;
                    }
                case 40:
                    this.f453094e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f453095f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 56);
                    long[] jArr = this.f453096g;
                    int length = jArr == null ? 0 : jArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    long[] jArr2 = new long[i3];
                    if (length != 0) {
                        System.arraycopy(jArr, 0, jArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.f453096g = jArr2;
                    break;
                case 58:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.f453096g;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    int i17 = i16 + length2;
                    long[] jArr4 = new long[i17];
                    if (length2 != 0) {
                        System.arraycopy(jArr3, 0, jArr4, 0, length2);
                    }
                    while (length2 < i17) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.f453096g = jArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 64:
                    this.f453097h = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.f453098i = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.f453099j = codedInputByteBufferNano.readInt32();
                    break;
                case 88:
                    this.f453100k = codedInputByteBufferNano.readInt32();
                    break;
                case 96:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2 && readInt323 != 3) {
                        break;
                    } else {
                        this.f453101l = readInt323;
                        break;
                    }
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f453090a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f453090a);
        }
        long j3 = this.f453091b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.f453092c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        int i16 = this.f453093d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        long j16 = this.f453094e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        long j17 = this.f453095f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        long[] jArr2 = this.f453096g;
        if (jArr2 != null && jArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                jArr = this.f453096g;
                if (i17 >= jArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (jArr.length * 1);
        }
        long j18 = this.f453097h;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j18);
        }
        long j19 = this.f453098i;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j19);
        }
        int i19 = this.f453099j;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i19);
        }
        int i26 = this.f453100k;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i26);
        }
        int i27 = this.f453101l;
        return i27 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(12, i27) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f453090a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f453090a);
        }
        long j3 = this.f453091b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.f453092c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int i16 = this.f453093d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        long j16 = this.f453094e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        long j17 = this.f453095f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        long[] jArr = this.f453096g;
        if (jArr != null && jArr.length > 0) {
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.f453096g;
                if (i17 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(7, jArr2[i17]);
                i17++;
            }
        }
        long j18 = this.f453097h;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j18);
        }
        long j19 = this.f453098i;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j19);
        }
        int i18 = this.f453099j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i18);
        }
        int i19 = this.f453100k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i19);
        }
        int i26 = this.f453101l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
