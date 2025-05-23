package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bg extends ExtendableMessageNano<bg> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile bg[] f440330k;

    /* renamed from: a, reason: collision with root package name */
    public String f440331a;

    /* renamed from: b, reason: collision with root package name */
    public int f440332b;

    /* renamed from: c, reason: collision with root package name */
    public String f440333c;

    /* renamed from: d, reason: collision with root package name */
    public String f440334d;

    /* renamed from: e, reason: collision with root package name */
    public String f440335e;

    /* renamed from: f, reason: collision with root package name */
    public String f440336f;

    /* renamed from: g, reason: collision with root package name */
    public ao[] f440337g;

    /* renamed from: h, reason: collision with root package name */
    public String f440338h;

    /* renamed from: i, reason: collision with root package name */
    public int f440339i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f440340j;

    public bg() {
        a();
    }

    public static bg[] b() {
        if (f440330k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440330k == null) {
                    f440330k = new bg[0];
                }
            }
        }
        return f440330k;
    }

    public bg a() {
        this.f440331a = "";
        this.f440332b = 0;
        this.f440333c = "";
        this.f440334d = "";
        this.f440335e = "";
        this.f440336f = "";
        this.f440337g = ao.b();
        this.f440338h = "";
        this.f440339i = 0;
        this.f440340j = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f440331a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f440332b = codedInputByteBufferNano.readInt32();
                    break;
                case 26:
                    this.f440333c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f440334d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f440335e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f440336f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    ao[] aoVarArr = this.f440337g;
                    int length = aoVarArr == null ? 0 : aoVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    ao[] aoVarArr2 = new ao[i3];
                    if (length != 0) {
                        System.arraycopy(aoVarArr, 0, aoVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        ao aoVar = new ao();
                        aoVarArr2[length] = aoVar;
                        codedInputByteBufferNano.readMessage(aoVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ao aoVar2 = new ao();
                    aoVarArr2[length] = aoVar2;
                    codedInputByteBufferNano.readMessage(aoVar2);
                    this.f440337g = aoVarArr2;
                    break;
                case 66:
                    this.f440338h = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f440339i = codedInputByteBufferNano.readInt32();
                    break;
                case 88:
                    this.f440340j = codedInputByteBufferNano.readBool();
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
        if (!this.f440331a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440331a);
        }
        int i3 = this.f440332b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f440333c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440333c);
        }
        if (!this.f440334d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440334d);
        }
        if (!this.f440335e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440335e);
        }
        if (!this.f440336f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f440336f);
        }
        ao[] aoVarArr = this.f440337g;
        if (aoVarArr != null && aoVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ao[] aoVarArr2 = this.f440337g;
                if (i16 >= aoVarArr2.length) {
                    break;
                }
                ao aoVar = aoVarArr2[i16];
                if (aoVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, aoVar);
                }
                i16++;
            }
        }
        if (!this.f440338h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f440338h);
        }
        int i17 = this.f440339i;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i17);
        }
        boolean z16 = this.f440340j;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(11, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440331a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440331a);
        }
        int i3 = this.f440332b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f440333c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440333c);
        }
        if (!this.f440334d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440334d);
        }
        if (!this.f440335e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440335e);
        }
        if (!this.f440336f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440336f);
        }
        ao[] aoVarArr = this.f440337g;
        if (aoVarArr != null && aoVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ao[] aoVarArr2 = this.f440337g;
                if (i16 >= aoVarArr2.length) {
                    break;
                }
                ao aoVar = aoVarArr2[i16];
                if (aoVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, aoVar);
                }
                i16++;
            }
        }
        if (!this.f440338h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f440338h);
        }
        int i17 = this.f440339i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i17);
        }
        boolean z16 = this.f440340j;
        if (z16) {
            codedOutputByteBufferNano.writeBool(11, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
