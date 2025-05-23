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
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f453077d;

    /* renamed from: a, reason: collision with root package name */
    public int f453078a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f453079b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f453080c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f453077d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f453077d == null) {
                    f453077d = new a[0];
                }
            }
        }
        return f453077d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f453078a = readInt32;
                }
            } else if (readTag == 18) {
                this.f453079b = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f453079b, mapFactory, 9, 9, null, 10, 18);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                String[] strArr = this.f453080c;
                int length = strArr == null ? 0 : strArr.length;
                int i3 = repeatedFieldArrayLength + length;
                String[] strArr2 = new String[i3];
                if (length != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length);
                }
                while (length < i3 - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.f453080c = strArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f453078a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        Map<String, String> map = this.f453079b;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 2, 9, 9);
        }
        String[] strArr = this.f453080c;
        if (strArr == null || strArr.length <= 0) {
            return computeSerializedSize;
        }
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            String[] strArr2 = this.f453080c;
            if (i16 >= strArr2.length) {
                return computeSerializedSize + i17 + (i18 * 1);
            }
            String str = strArr2[i16];
            if (str != null) {
                i18++;
                i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
            }
            i16++;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f453078a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        Map<String, String> map = this.f453079b;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 2, 9, 9);
        }
        String[] strArr = this.f453080c;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f453080c;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f453078a = 0;
        this.f453079b = null;
        this.f453080c = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
