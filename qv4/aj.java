package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class aj extends ExtendableMessageNano<aj> {

    /* renamed from: a, reason: collision with root package name */
    public int f429928a;

    /* renamed from: b, reason: collision with root package name */
    public int f429929b;

    /* renamed from: c, reason: collision with root package name */
    public String f429930c;

    /* renamed from: d, reason: collision with root package name */
    public String f429931d;

    /* renamed from: e, reason: collision with root package name */
    public String f429932e;

    /* renamed from: f, reason: collision with root package name */
    public at f429933f;

    /* renamed from: g, reason: collision with root package name */
    public String f429934g;

    /* renamed from: h, reason: collision with root package name */
    public String f429935h;

    /* renamed from: i, reason: collision with root package name */
    public nw4.f[] f429936i;

    /* renamed from: j, reason: collision with root package name */
    public String f429937j;

    /* renamed from: k, reason: collision with root package name */
    public int f429938k;

    public aj() {
        a();
    }

    public static aj c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (aj) MessageNano.mergeFrom(new aj(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f429928a = codedInputByteBufferNano.readInt32();
                    break;
                case 16:
                    this.f429929b = codedInputByteBufferNano.readInt32();
                    break;
                case 26:
                    this.f429930c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f429931d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f429932e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    if (this.f429933f == null) {
                        this.f429933f = new at();
                    }
                    codedInputByteBufferNano.readMessage(this.f429933f);
                    break;
                case 58:
                    this.f429934g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f429935h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    nw4.f[] fVarArr = this.f429936i;
                    int length = fVarArr == null ? 0 : fVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    nw4.f[] fVarArr2 = new nw4.f[i3];
                    if (length != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        nw4.f fVar = new nw4.f();
                        fVarArr2[length] = fVar;
                        codedInputByteBufferNano.readMessage(fVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    nw4.f fVar2 = new nw4.f();
                    fVarArr2[length] = fVar2;
                    codedInputByteBufferNano.readMessage(fVar2);
                    this.f429936i = fVarArr2;
                    break;
                case 82:
                    this.f429937j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f429938k = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f429928a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f429929b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f429930c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f429930c);
        }
        if (!this.f429931d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f429931d);
        }
        if (!this.f429932e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f429932e);
        }
        at atVar = this.f429933f;
        if (atVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, atVar);
        }
        if (!this.f429934g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f429934g);
        }
        if (!this.f429935h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f429935h);
        }
        nw4.f[] fVarArr = this.f429936i;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                nw4.f[] fVarArr2 = this.f429936i;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                nw4.f fVar = fVarArr2[i17];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, fVar);
                }
                i17++;
            }
        }
        if (!this.f429937j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f429937j);
        }
        int i18 = this.f429938k;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(11, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429928a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f429929b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f429930c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429930c);
        }
        if (!this.f429931d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429931d);
        }
        if (!this.f429932e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f429932e);
        }
        at atVar = this.f429933f;
        if (atVar != null) {
            codedOutputByteBufferNano.writeMessage(6, atVar);
        }
        if (!this.f429934g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f429934g);
        }
        if (!this.f429935h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f429935h);
        }
        nw4.f[] fVarArr = this.f429936i;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                nw4.f[] fVarArr2 = this.f429936i;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                nw4.f fVar = fVarArr2[i17];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, fVar);
                }
                i17++;
            }
        }
        if (!this.f429937j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f429937j);
        }
        int i18 = this.f429938k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public aj a() {
        this.f429928a = 0;
        this.f429929b = 0;
        this.f429930c = "";
        this.f429931d = "";
        this.f429932e = "";
        this.f429933f = null;
        this.f429934g = "";
        this.f429935h = "";
        this.f429936i = nw4.f.b();
        this.f429937j = "";
        this.f429938k = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
