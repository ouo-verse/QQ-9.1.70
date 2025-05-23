package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: o, reason: collision with root package name */
    private static volatile g[] f430141o;

    /* renamed from: a, reason: collision with root package name */
    public int f430142a;

    /* renamed from: b, reason: collision with root package name */
    public int f430143b;

    /* renamed from: c, reason: collision with root package name */
    public String f430144c;

    /* renamed from: d, reason: collision with root package name */
    public String f430145d;

    /* renamed from: e, reason: collision with root package name */
    public String f430146e;

    /* renamed from: f, reason: collision with root package name */
    public int f430147f;

    /* renamed from: g, reason: collision with root package name */
    public String f430148g;

    /* renamed from: h, reason: collision with root package name */
    public int f430149h;

    /* renamed from: i, reason: collision with root package name */
    public String f430150i;

    /* renamed from: j, reason: collision with root package name */
    public String f430151j;

    /* renamed from: k, reason: collision with root package name */
    public String f430152k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f430153l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f430154m;

    /* renamed from: n, reason: collision with root package name */
    public at f430155n;

    public g() {
        a();
    }

    public static g[] b() {
        if (f430141o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430141o == null) {
                    f430141o = new g[0];
                }
            }
        }
        return f430141o;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f430142a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f430143b = readInt32;
                        break;
                    }
                case 26:
                    this.f430144c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f430145d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f430146e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                        break;
                    } else {
                        this.f430147f = readInt322;
                        break;
                    }
                    break;
                case 58:
                    this.f430148g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2 && readInt323 != 3) {
                        break;
                    } else {
                        this.f430149h = readInt323;
                        break;
                    }
                case 74:
                    this.f430150i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f430151j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f430152k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f430153l = codedInputByteBufferNano.readBool();
                    break;
                case 104:
                    this.f430154m = codedInputByteBufferNano.readBool();
                    break;
                case 114:
                    if (this.f430155n == null) {
                        this.f430155n = new at();
                    }
                    codedInputByteBufferNano.readMessage(this.f430155n);
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
        int i3 = this.f430142a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f430143b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        if (!this.f430144c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430144c);
        }
        if (!this.f430145d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430145d);
        }
        if (!this.f430146e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f430146e);
        }
        int i17 = this.f430147f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i17);
        }
        if (!this.f430148g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f430148g);
        }
        int i18 = this.f430149h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i18);
        }
        if (!this.f430150i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f430150i);
        }
        if (!this.f430151j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f430151j);
        }
        if (!this.f430152k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f430152k);
        }
        boolean z16 = this.f430153l;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z16);
        }
        boolean z17 = this.f430154m;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, z17);
        }
        at atVar = this.f430155n;
        return atVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(14, atVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f430142a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f430143b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        if (!this.f430144c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430144c);
        }
        if (!this.f430145d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430145d);
        }
        if (!this.f430146e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f430146e);
        }
        int i17 = this.f430147f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        if (!this.f430148g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f430148g);
        }
        int i18 = this.f430149h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        if (!this.f430150i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f430150i);
        }
        if (!this.f430151j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f430151j);
        }
        if (!this.f430152k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f430152k);
        }
        boolean z16 = this.f430153l;
        if (z16) {
            codedOutputByteBufferNano.writeBool(12, z16);
        }
        boolean z17 = this.f430154m;
        if (z17) {
            codedOutputByteBufferNano.writeBool(13, z17);
        }
        at atVar = this.f430155n;
        if (atVar != null) {
            codedOutputByteBufferNano.writeMessage(14, atVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f430142a = 0;
        this.f430143b = 0;
        this.f430144c = "";
        this.f430145d = "";
        this.f430146e = "";
        this.f430147f = 0;
        this.f430148g = "";
        this.f430149h = 0;
        this.f430150i = "";
        this.f430151j = "";
        this.f430152k = "";
        this.f430153l = false;
        this.f430154m = false;
        this.f430155n = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
