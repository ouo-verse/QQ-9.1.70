package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public long f451461a;

    /* renamed from: b, reason: collision with root package name */
    public String f451462b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f451463c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f451464d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f451465e;

    /* renamed from: f, reason: collision with root package name */
    public String f451466f;

    /* renamed from: g, reason: collision with root package name */
    public String f451467g;

    /* renamed from: h, reason: collision with root package name */
    public String f451468h;

    /* renamed from: i, reason: collision with root package name */
    public String f451469i;

    /* renamed from: j, reason: collision with root package name */
    public String f451470j;

    public g() {
        a();
    }

    public g a() {
        this.f451461a = 0L;
        this.f451462b = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f451463c = bArr;
        this.f451464d = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f451465e = bArr;
        this.f451466f = "";
        this.f451467g = "";
        this.f451468h = "";
        this.f451469i = "";
        this.f451470j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f451461a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f451462b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f451463c = codedInputByteBufferNano.readBytes();
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr = this.f451464d;
                    if (strArr == null) {
                        length = 0;
                    } else {
                        length = strArr.length;
                    }
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
                    this.f451464d = strArr2;
                    break;
                case 42:
                    this.f451465e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    this.f451466f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f451467g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f451468h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f451469i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f451470j = codedInputByteBufferNano.readString();
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
        long j3 = this.f451461a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f451462b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451462b);
        }
        if (!Arrays.equals(this.f451463c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f451463c);
        }
        String[] strArr = this.f451464d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f451464d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i17++;
                    i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (i17 * 1);
        }
        if (!Arrays.equals(this.f451465e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f451465e);
        }
        if (!this.f451466f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f451466f);
        }
        if (!this.f451467g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f451467g);
        }
        if (!this.f451468h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f451468h);
        }
        if (!this.f451469i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f451469i);
        }
        if (!this.f451470j.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f451470j);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f451461a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f451462b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451462b);
        }
        if (!Arrays.equals(this.f451463c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f451463c);
        }
        String[] strArr = this.f451464d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f451464d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i3++;
            }
        }
        if (!Arrays.equals(this.f451465e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f451465e);
        }
        if (!this.f451466f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f451466f);
        }
        if (!this.f451467g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f451467g);
        }
        if (!this.f451468h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f451468h);
        }
        if (!this.f451469i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f451469i);
        }
        if (!this.f451470j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f451470j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
