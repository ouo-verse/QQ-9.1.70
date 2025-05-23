package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class aq extends ExtendableMessageNano<aq> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile aq[] f440204j;

    /* renamed from: a, reason: collision with root package name */
    public String f440205a;

    /* renamed from: b, reason: collision with root package name */
    public int f440206b;

    /* renamed from: c, reason: collision with root package name */
    public String f440207c;

    /* renamed from: d, reason: collision with root package name */
    public String f440208d;

    /* renamed from: e, reason: collision with root package name */
    public String f440209e;

    /* renamed from: f, reason: collision with root package name */
    public an[] f440210f;

    /* renamed from: g, reason: collision with root package name */
    public String f440211g;

    /* renamed from: h, reason: collision with root package name */
    public int f440212h;

    /* renamed from: i, reason: collision with root package name */
    public int f440213i;

    public aq() {
        a();
    }

    public static aq[] b() {
        if (f440204j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440204j == null) {
                    f440204j = new aq[0];
                }
            }
        }
        return f440204j;
    }

    public aq a() {
        this.f440205a = "";
        this.f440206b = 0;
        this.f440207c = "";
        this.f440208d = "";
        this.f440209e = "";
        this.f440210f = an.b();
        this.f440211g = "";
        this.f440212h = 0;
        this.f440213i = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public aq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440205a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f440206b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.f440207c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f440208d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f440209e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                an[] anVarArr = this.f440210f;
                int length = anVarArr == null ? 0 : anVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                an[] anVarArr2 = new an[i3];
                if (length != 0) {
                    System.arraycopy(anVarArr, 0, anVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    an anVar = new an();
                    anVarArr2[length] = anVar;
                    codedInputByteBufferNano.readMessage(anVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                an anVar2 = new an();
                anVarArr2[length] = anVar2;
                codedInputByteBufferNano.readMessage(anVar2);
                this.f440210f = anVarArr2;
            } else if (readTag == 58) {
                this.f440211g = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.f440212h = codedInputByteBufferNano.readInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440213i = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440205a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440205a);
        }
        int i3 = this.f440206b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f440207c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440207c);
        }
        if (!this.f440208d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440208d);
        }
        if (!this.f440209e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440209e);
        }
        an[] anVarArr = this.f440210f;
        if (anVarArr != null && anVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                an[] anVarArr2 = this.f440210f;
                if (i16 >= anVarArr2.length) {
                    break;
                }
                an anVar = anVarArr2[i16];
                if (anVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, anVar);
                }
                i16++;
            }
        }
        if (!this.f440211g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f440211g);
        }
        int i17 = this.f440212h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        int i18 = this.f440213i;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440205a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440205a);
        }
        int i3 = this.f440206b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f440207c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440207c);
        }
        if (!this.f440208d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440208d);
        }
        if (!this.f440209e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440209e);
        }
        an[] anVarArr = this.f440210f;
        if (anVarArr != null && anVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                an[] anVarArr2 = this.f440210f;
                if (i16 >= anVarArr2.length) {
                    break;
                }
                an anVar = anVarArr2[i16];
                if (anVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, anVar);
                }
                i16++;
            }
        }
        if (!this.f440211g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f440211g);
        }
        int i17 = this.f440212h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        int i18 = this.f440213i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
