package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile d[] f427578k;

    /* renamed from: a, reason: collision with root package name */
    public int f427579a;

    /* renamed from: b, reason: collision with root package name */
    public String f427580b;

    /* renamed from: c, reason: collision with root package name */
    public long f427581c;

    /* renamed from: d, reason: collision with root package name */
    public long f427582d;

    /* renamed from: e, reason: collision with root package name */
    public String f427583e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f427584f;

    /* renamed from: g, reason: collision with root package name */
    public String f427585g;

    /* renamed from: h, reason: collision with root package name */
    public String f427586h;

    /* renamed from: i, reason: collision with root package name */
    public String f427587i;

    /* renamed from: j, reason: collision with root package name */
    public String f427588j;

    public d() {
        a();
    }

    public static d[] b() {
        if (f427578k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427578k == null) {
                    f427578k = new d[0];
                }
            }
        }
        return f427578k;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f427579a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f427580b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f427581c = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.f427582d = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.f427583e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr = this.f427584f;
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
                    this.f427584f = strArr2;
                    break;
                case 58:
                    this.f427585g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f427586h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f427587i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f427588j = codedInputByteBufferNano.readString();
                    break;
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
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427579a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f427580b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427580b);
        }
        long j3 = this.f427581c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j16 = this.f427582d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        if (!this.f427583e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427583e);
        }
        String[] strArr = this.f427584f;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f427584f;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        if (!this.f427585g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f427585g);
        }
        if (!this.f427586h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f427586h);
        }
        if (!this.f427587i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f427587i);
        }
        return !this.f427588j.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f427588j) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427579a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f427580b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427580b);
        }
        long j3 = this.f427581c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j16 = this.f427582d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        if (!this.f427583e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427583e);
        }
        String[] strArr = this.f427584f;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f427584f;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(6, str);
                }
                i16++;
            }
        }
        if (!this.f427585g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427585g);
        }
        if (!this.f427586h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f427586h);
        }
        if (!this.f427587i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f427587i);
        }
        if (!this.f427588j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f427588j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f427579a = 0;
        this.f427580b = "";
        this.f427581c = 0L;
        this.f427582d = 0L;
        this.f427583e = "";
        this.f427584f = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f427585g = "";
        this.f427586h = "";
        this.f427587i = "";
        this.f427588j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
