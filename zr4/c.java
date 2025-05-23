package zr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile c[] f453081i;

    /* renamed from: a, reason: collision with root package name */
    public String f453082a;

    /* renamed from: b, reason: collision with root package name */
    public int f453083b;

    /* renamed from: c, reason: collision with root package name */
    public a[] f453084c;

    /* renamed from: d, reason: collision with root package name */
    public a[] f453085d;

    /* renamed from: e, reason: collision with root package name */
    public int f453086e;

    /* renamed from: f, reason: collision with root package name */
    public int f453087f;

    /* renamed from: g, reason: collision with root package name */
    public String f453088g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f453089h;

    public c() {
        a();
    }

    public static c[] b() {
        if (f453081i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f453081i == null) {
                    f453081i = new c[0];
                }
            }
        }
        return f453081i;
    }

    public c a() {
        this.f453082a = "";
        this.f453083b = 0;
        this.f453084c = a.b();
        this.f453085d = a.b();
        this.f453086e = 0;
        this.f453087f = 0;
        this.f453088g = "";
        this.f453089h = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f453082a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f453083b = readInt32;
                }
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                a[] aVarArr = this.f453084c;
                int length = aVarArr == null ? 0 : aVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                a[] aVarArr2 = new a[i3];
                if (length != 0) {
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    a aVar = new a();
                    aVarArr2[length] = aVar;
                    codedInputByteBufferNano.readMessage(aVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                a aVar2 = new a();
                aVarArr2[length] = aVar2;
                codedInputByteBufferNano.readMessage(aVar2);
                this.f453084c = aVarArr2;
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                a[] aVarArr3 = this.f453085d;
                int length2 = aVarArr3 == null ? 0 : aVarArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                a[] aVarArr4 = new a[i16];
                if (length2 != 0) {
                    System.arraycopy(aVarArr3, 0, aVarArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    a aVar3 = new a();
                    aVarArr4[length2] = aVar3;
                    codedInputByteBufferNano.readMessage(aVar3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                a aVar4 = new a();
                aVarArr4[length2] = aVar4;
                codedInputByteBufferNano.readMessage(aVar4);
                this.f453085d = aVarArr4;
            } else if (readTag == 40) {
                this.f453086e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 48) {
                this.f453087f = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 58) {
                this.f453088g = codedInputByteBufferNano.readString();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f453089h = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f453089h, mapFactory, 9, 9, null, 10, 18);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f453082a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f453082a);
        }
        int i3 = this.f453083b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        a[] aVarArr = this.f453084c;
        int i16 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                a[] aVarArr2 = this.f453084c;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i17];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
                }
                i17++;
            }
        }
        a[] aVarArr3 = this.f453085d;
        if (aVarArr3 != null && aVarArr3.length > 0) {
            while (true) {
                a[] aVarArr4 = this.f453085d;
                if (i16 >= aVarArr4.length) {
                    break;
                }
                a aVar2 = aVarArr4[i16];
                if (aVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar2);
                }
                i16++;
            }
        }
        int i18 = this.f453086e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i18);
        }
        int i19 = this.f453087f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        if (!this.f453088g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f453088g);
        }
        Map<String, String> map = this.f453089h;
        return map != null ? computeSerializedSize + InternalNano.computeMapFieldSize(map, 8, 9, 9) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f453082a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f453082a);
        }
        int i3 = this.f453083b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        a[] aVarArr = this.f453084c;
        int i16 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                a[] aVarArr2 = this.f453084c;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i17];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, aVar);
                }
                i17++;
            }
        }
        a[] aVarArr3 = this.f453085d;
        if (aVarArr3 != null && aVarArr3.length > 0) {
            while (true) {
                a[] aVarArr4 = this.f453085d;
                if (i16 >= aVarArr4.length) {
                    break;
                }
                a aVar2 = aVarArr4[i16];
                if (aVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, aVar2);
                }
                i16++;
            }
        }
        int i18 = this.f453086e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i18);
        }
        int i19 = this.f453087f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        if (!this.f453088g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f453088g);
        }
        Map<String, String> map = this.f453089h;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 8, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
