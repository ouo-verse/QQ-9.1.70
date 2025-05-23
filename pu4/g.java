package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: o, reason: collision with root package name */
    private static volatile g[] f427433o;

    /* renamed from: a, reason: collision with root package name */
    public String f427434a;

    /* renamed from: b, reason: collision with root package name */
    public String f427435b;

    /* renamed from: c, reason: collision with root package name */
    public String f427436c;

    /* renamed from: d, reason: collision with root package name */
    public String f427437d;

    /* renamed from: e, reason: collision with root package name */
    public t f427438e;

    /* renamed from: f, reason: collision with root package name */
    public int f427439f;

    /* renamed from: g, reason: collision with root package name */
    public int f427440g;

    /* renamed from: h, reason: collision with root package name */
    public int f427441h;

    /* renamed from: i, reason: collision with root package name */
    public int f427442i;

    /* renamed from: j, reason: collision with root package name */
    public int f427443j;

    /* renamed from: k, reason: collision with root package name */
    public int f427444k;

    /* renamed from: l, reason: collision with root package name */
    public int f427445l;

    /* renamed from: m, reason: collision with root package name */
    public h f427446m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f427447n;

    public g() {
        a();
    }

    public static g[] b() {
        if (f427433o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427433o == null) {
                    f427433o = new g[0];
                }
            }
        }
        return f427433o;
    }

    public static g d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    public g a() {
        this.f427434a = "";
        this.f427435b = "";
        this.f427436c = "";
        this.f427437d = "";
        this.f427438e = null;
        this.f427439f = 0;
        this.f427440g = 0;
        this.f427441h = 0;
        this.f427442i = 0;
        this.f427443j = 0;
        this.f427444k = 0;
        this.f427445l = 0;
        this.f427446m = null;
        this.f427447n = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f427434a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f427435b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f427436c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f427437d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    if (this.f427438e == null) {
                        this.f427438e = new t();
                    }
                    codedInputByteBufferNano.readMessage(this.f427438e);
                    break;
                case 48:
                    this.f427439f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f427440g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f427441h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f427442i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f427443j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f427444k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f427445l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    if (this.f427446m == null) {
                        this.f427446m = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f427446m);
                    break;
                case 114:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    String[] strArr = this.f427447n;
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
                    this.f427447n = strArr2;
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
        if (!this.f427434a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427434a);
        }
        if (!this.f427435b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427435b);
        }
        if (!this.f427436c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427436c);
        }
        if (!this.f427437d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427437d);
        }
        t tVar = this.f427438e;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, tVar);
        }
        int i3 = this.f427439f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        int i16 = this.f427440g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.f427441h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        int i18 = this.f427442i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i18);
        }
        int i19 = this.f427443j;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i19);
        }
        int i26 = this.f427444k;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i26);
        }
        int i27 = this.f427445l;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i27);
        }
        h hVar = this.f427446m;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, hVar);
        }
        String[] strArr = this.f427447n;
        if (strArr == null || strArr.length <= 0) {
            return computeSerializedSize;
        }
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        while (true) {
            String[] strArr2 = this.f427447n;
            if (i28 >= strArr2.length) {
                return computeSerializedSize + i29 + (i36 * 1);
            }
            String str = strArr2[i28];
            if (str != null) {
                i36++;
                i29 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
            }
            i28++;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427434a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427434a);
        }
        if (!this.f427435b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427435b);
        }
        if (!this.f427436c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427436c);
        }
        if (!this.f427437d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427437d);
        }
        t tVar = this.f427438e;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(5, tVar);
        }
        int i3 = this.f427439f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        int i16 = this.f427440g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.f427441h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        int i18 = this.f427442i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i18);
        }
        int i19 = this.f427443j;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i19);
        }
        int i26 = this.f427444k;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i26);
        }
        int i27 = this.f427445l;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i27);
        }
        h hVar = this.f427446m;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(13, hVar);
        }
        String[] strArr = this.f427447n;
        if (strArr != null && strArr.length > 0) {
            int i28 = 0;
            while (true) {
                String[] strArr2 = this.f427447n;
                if (i28 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i28];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(14, str);
                }
                i28++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
