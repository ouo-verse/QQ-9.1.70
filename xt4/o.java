package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f448606a;

    /* renamed from: b, reason: collision with root package name */
    public int f448607b;

    /* renamed from: c, reason: collision with root package name */
    public hs4.f f448608c;

    /* renamed from: d, reason: collision with root package name */
    public int f448609d;

    /* renamed from: e, reason: collision with root package name */
    public long[] f448610e;

    /* renamed from: f, reason: collision with root package name */
    public String f448611f;

    /* renamed from: g, reason: collision with root package name */
    public int f448612g;

    public o() {
        a();
    }

    public o a() {
        long[] jArr = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f448606a = jArr;
        this.f448607b = 0;
        this.f448608c = null;
        this.f448609d = 0;
        this.f448610e = jArr;
        this.f448611f = "";
        this.f448612g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                long[] jArr = this.f448606a;
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
                this.f448606a = jArr2;
            } else if (readTag == 10) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.f448606a;
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
                this.f448606a = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 16) {
                this.f448607b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                if (this.f448608c == null) {
                    this.f448608c = new hs4.f();
                }
                codedInputByteBufferNano.readMessage(this.f448608c);
            } else if (readTag == 32) {
                this.f448609d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                long[] jArr5 = this.f448610e;
                int length3 = jArr5 == null ? 0 : jArr5.length;
                int i18 = repeatedFieldArrayLength2 + length3;
                long[] jArr6 = new long[i18];
                if (length3 != 0) {
                    System.arraycopy(jArr5, 0, jArr6, 0, length3);
                }
                while (length3 < i18 - 1) {
                    jArr6[length3] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                jArr6[length3] = codedInputByteBufferNano.readUInt64();
                this.f448610e = jArr6;
            } else if (readTag == 42) {
                int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position2 = codedInputByteBufferNano.getPosition();
                int i19 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i19++;
                }
                codedInputByteBufferNano.rewindToPosition(position2);
                long[] jArr7 = this.f448610e;
                int length4 = jArr7 == null ? 0 : jArr7.length;
                int i26 = i19 + length4;
                long[] jArr8 = new long[i26];
                if (length4 != 0) {
                    System.arraycopy(jArr7, 0, jArr8, 0, length4);
                }
                while (length4 < i26) {
                    jArr8[length4] = codedInputByteBufferNano.readUInt64();
                    length4++;
                }
                this.f448610e = jArr8;
                codedInputByteBufferNano.popLimit(pushLimit2);
            } else if (readTag == 50) {
                this.f448611f = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448612g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        long[] jArr2;
        int computeSerializedSize = super.computeSerializedSize();
        long[] jArr3 = this.f448606a;
        int i3 = 0;
        if (jArr3 != null && jArr3.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                jArr2 = this.f448606a;
                if (i16 >= jArr2.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (jArr2.length * 1);
        }
        int i18 = this.f448607b;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i18);
        }
        hs4.f fVar = this.f448608c;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, fVar);
        }
        int i19 = this.f448609d;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i19);
        }
        long[] jArr4 = this.f448610e;
        if (jArr4 != null && jArr4.length > 0) {
            int i26 = 0;
            while (true) {
                jArr = this.f448610e;
                if (i3 >= jArr.length) {
                    break;
                }
                i26 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (jArr.length * 1);
        }
        if (!this.f448611f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f448611f);
        }
        int i27 = this.f448612g;
        return i27 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i27) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long[] jArr = this.f448606a;
        int i3 = 0;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.f448606a;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(1, jArr2[i16]);
                i16++;
            }
        }
        int i17 = this.f448607b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i17);
        }
        hs4.f fVar = this.f448608c;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(3, fVar);
        }
        int i18 = this.f448609d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        long[] jArr3 = this.f448610e;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.f448610e;
                if (i3 >= jArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(5, jArr4[i3]);
                i3++;
            }
        }
        if (!this.f448611f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f448611f);
        }
        int i19 = this.f448612g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
