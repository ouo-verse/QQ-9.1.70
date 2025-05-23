package xs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f448469a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f448470b;

    /* renamed from: c, reason: collision with root package name */
    public long f448471c;

    /* renamed from: d, reason: collision with root package name */
    public int f448472d;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                    switch (readInt32) {
                    }
                }
                this.f448469a = readInt32;
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                long[] jArr = this.f448470b;
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
                this.f448470b = jArr2;
            } else if (readTag == 18) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.f448470b;
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
                this.f448470b = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 24) {
                this.f448471c = codedInputByteBufferNano.readInt64();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448472d = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f448469a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long[] jArr2 = this.f448470b;
        if (jArr2 != null && jArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                jArr = this.f448470b;
                if (i16 >= jArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (jArr.length * 1);
        }
        long j3 = this.f448471c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        int i18 = this.f448472d;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448469a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long[] jArr = this.f448470b;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.f448470b;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(2, jArr2[i16]);
                i16++;
            }
        }
        long j3 = this.f448471c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        int i17 = this.f448472d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f448469a = 0;
        this.f448470b = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f448471c = 0L;
        this.f448472d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
