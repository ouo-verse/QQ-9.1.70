package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class an extends ExtendableMessageNano<an> {

    /* renamed from: l, reason: collision with root package name */
    private static volatile an[] f440170l;

    /* renamed from: a, reason: collision with root package name */
    public String f440171a;

    /* renamed from: b, reason: collision with root package name */
    public int f440172b;

    /* renamed from: c, reason: collision with root package name */
    public String f440173c;

    /* renamed from: d, reason: collision with root package name */
    public String f440174d;

    /* renamed from: e, reason: collision with root package name */
    public String f440175e;

    /* renamed from: f, reason: collision with root package name */
    public String f440176f;

    /* renamed from: g, reason: collision with root package name */
    public bj[] f440177g;

    /* renamed from: h, reason: collision with root package name */
    public String f440178h;

    /* renamed from: i, reason: collision with root package name */
    public int f440179i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f440180j;

    /* renamed from: k, reason: collision with root package name */
    public int f440181k;

    public an() {
        a();
    }

    public static an[] b() {
        if (f440170l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440170l == null) {
                    f440170l = new an[0];
                }
            }
        }
        return f440170l;
    }

    public an a() {
        this.f440171a = "";
        this.f440172b = 0;
        this.f440173c = "";
        this.f440174d = "";
        this.f440175e = "";
        this.f440176f = "";
        this.f440177g = bj.b();
        this.f440178h = "";
        this.f440179i = 0;
        this.f440180j = false;
        this.f440181k = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public an mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f440171a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f440172b = codedInputByteBufferNano.readInt32();
                    break;
                case 26:
                    this.f440173c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f440174d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f440175e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f440176f = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    bj[] bjVarArr = this.f440177g;
                    int length = bjVarArr == null ? 0 : bjVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    bj[] bjVarArr2 = new bj[i3];
                    if (length != 0) {
                        System.arraycopy(bjVarArr, 0, bjVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        bj bjVar = new bj();
                        bjVarArr2[length] = bjVar;
                        codedInputByteBufferNano.readMessage(bjVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    bj bjVar2 = new bj();
                    bjVarArr2[length] = bjVar2;
                    codedInputByteBufferNano.readMessage(bjVar2);
                    this.f440177g = bjVarArr2;
                    break;
                case 74:
                    this.f440178h = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f440179i = codedInputByteBufferNano.readInt32();
                    break;
                case 88:
                    this.f440180j = codedInputByteBufferNano.readBool();
                    break;
                case 96:
                    this.f440181k = codedInputByteBufferNano.readUInt32();
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
        if (!this.f440171a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440171a);
        }
        int i3 = this.f440172b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f440173c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440173c);
        }
        if (!this.f440174d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440174d);
        }
        if (!this.f440175e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440175e);
        }
        if (!this.f440176f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f440176f);
        }
        bj[] bjVarArr = this.f440177g;
        if (bjVarArr != null && bjVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bj[] bjVarArr2 = this.f440177g;
                if (i16 >= bjVarArr2.length) {
                    break;
                }
                bj bjVar = bjVarArr2[i16];
                if (bjVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, bjVar);
                }
                i16++;
            }
        }
        if (!this.f440178h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f440178h);
        }
        int i17 = this.f440179i;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i17);
        }
        boolean z16 = this.f440180j;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z16);
        }
        int i18 = this.f440181k;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(12, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440171a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440171a);
        }
        int i3 = this.f440172b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f440173c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440173c);
        }
        if (!this.f440174d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440174d);
        }
        if (!this.f440175e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440175e);
        }
        if (!this.f440176f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440176f);
        }
        bj[] bjVarArr = this.f440177g;
        if (bjVarArr != null && bjVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bj[] bjVarArr2 = this.f440177g;
                if (i16 >= bjVarArr2.length) {
                    break;
                }
                bj bjVar = bjVarArr2[i16];
                if (bjVar != null) {
                    codedOutputByteBufferNano.writeMessage(8, bjVar);
                }
                i16++;
            }
        }
        if (!this.f440178h.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f440178h);
        }
        int i17 = this.f440179i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i17);
        }
        boolean z16 = this.f440180j;
        if (z16) {
            codedOutputByteBufferNano.writeBool(11, z16);
        }
        int i18 = this.f440181k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
