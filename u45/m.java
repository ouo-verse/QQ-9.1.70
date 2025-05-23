package u45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile m[] f438255h;

    /* renamed from: a, reason: collision with root package name */
    public int f438256a;

    /* renamed from: b, reason: collision with root package name */
    public int f438257b;

    /* renamed from: c, reason: collision with root package name */
    public String f438258c;

    /* renamed from: d, reason: collision with root package name */
    public String f438259d;

    /* renamed from: e, reason: collision with root package name */
    public String f438260e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f438261f;

    /* renamed from: g, reason: collision with root package name */
    public String f438262g;

    public m() {
        a();
    }

    public static m[] b() {
        if (f438255h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f438255h == null) {
                    f438255h = new m[0];
                }
            }
        }
        return f438255h;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f438256a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f438257b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f438258c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f438259d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f438260e = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 48);
                int[] iArr = this.f438261f;
                int length = iArr == null ? 0 : iArr.length;
                int i3 = repeatedFieldArrayLength + length;
                int[] iArr2 = new int[i3];
                if (length != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                }
                while (length < i3 - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.f438261f = iArr2;
            } else if (readTag == 50) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.f438261f;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int i17 = i16 + length2;
                int[] iArr4 = new int[i17];
                if (length2 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length2);
                }
                while (length2 < i17) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.f438261f = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f438262g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f438256a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f438257b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f438258c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f438258c);
        }
        if (!this.f438259d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f438259d);
        }
        if (!this.f438260e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f438260e);
        }
        int[] iArr2 = this.f438261f;
        if (iArr2 != null && iArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                iArr = this.f438261f;
                if (i17 >= iArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (iArr.length * 1);
        }
        return !this.f438262g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f438262g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f438256a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f438257b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f438258c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f438258c);
        }
        if (!this.f438259d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f438259d);
        }
        if (!this.f438260e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f438260e);
        }
        int[] iArr = this.f438261f;
        if (iArr != null && iArr.length > 0) {
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.f438261f;
                if (i17 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(6, iArr2[i17]);
                i17++;
            }
        }
        if (!this.f438262g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f438262g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f438256a = 0;
        this.f438257b = 0;
        this.f438258c = "";
        this.f438259d = "";
        this.f438260e = "";
        this.f438261f = WireFormatNano.EMPTY_INT_ARRAY;
        this.f438262g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
