package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: o, reason: collision with root package name */
    private static volatile h[] f448587o;

    /* renamed from: a, reason: collision with root package name */
    public String f448588a;

    /* renamed from: b, reason: collision with root package name */
    public String f448589b;

    /* renamed from: c, reason: collision with root package name */
    public String f448590c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.i f448591d;

    /* renamed from: e, reason: collision with root package name */
    public hs4.b f448592e;

    /* renamed from: f, reason: collision with root package name */
    public String f448593f;

    /* renamed from: g, reason: collision with root package name */
    public String f448594g;

    /* renamed from: h, reason: collision with root package name */
    public int f448595h;

    /* renamed from: i, reason: collision with root package name */
    public int f448596i;

    /* renamed from: j, reason: collision with root package name */
    public d[] f448597j;

    /* renamed from: k, reason: collision with root package name */
    public int f448598k;

    /* renamed from: l, reason: collision with root package name */
    public int f448599l;

    /* renamed from: m, reason: collision with root package name */
    public hs4.a f448600m;

    /* renamed from: n, reason: collision with root package name */
    public String f448601n;

    public h() {
        a();
    }

    public static h[] b() {
        if (f448587o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448587o == null) {
                    f448587o = new h[0];
                }
            }
        }
        return f448587o;
    }

    public h a() {
        this.f448588a = "";
        this.f448589b = "";
        this.f448590c = "";
        this.f448591d = null;
        this.f448592e = null;
        this.f448593f = "";
        this.f448594g = "";
        this.f448595h = 0;
        this.f448596i = 0;
        this.f448597j = d.b();
        this.f448598k = 0;
        this.f448599l = 0;
        this.f448600m = null;
        this.f448601n = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f448588a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f448589b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f448590c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.f448591d == null) {
                        this.f448591d = new hs4.i();
                    }
                    codedInputByteBufferNano.readMessage(this.f448591d);
                    break;
                case 42:
                    if (this.f448592e == null) {
                        this.f448592e = new hs4.b();
                    }
                    codedInputByteBufferNano.readMessage(this.f448592e);
                    break;
                case 50:
                    this.f448593f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f448594g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.f448595h = readInt32;
                        break;
                    }
                case 72:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 100) {
                        switch (readInt322) {
                        }
                    }
                    this.f448596i = readInt322;
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    d[] dVarArr = this.f448597j;
                    int length = dVarArr == null ? 0 : dVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    d[] dVarArr2 = new d[i3];
                    if (length != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        d dVar = new d();
                        dVarArr2[length] = dVar;
                        codedInputByteBufferNano.readMessage(dVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    d dVar2 = new d();
                    dVarArr2[length] = dVar2;
                    codedInputByteBufferNano.readMessage(dVar2);
                    this.f448597j = dVarArr2;
                    break;
                case 88:
                    this.f448598k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f448599l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    if (this.f448600m == null) {
                        this.f448600m = new hs4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f448600m);
                    break;
                case 114:
                    this.f448601n = codedInputByteBufferNano.readString();
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
        if (!this.f448588a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f448588a);
        }
        if (!this.f448589b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448589b);
        }
        if (!this.f448590c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448590c);
        }
        hs4.i iVar = this.f448591d;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, iVar);
        }
        hs4.b bVar = this.f448592e;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, bVar);
        }
        if (!this.f448593f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f448593f);
        }
        if (!this.f448594g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f448594g);
        }
        int i3 = this.f448595h;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i3);
        }
        int i16 = this.f448596i;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i16);
        }
        d[] dVarArr = this.f448597j;
        if (dVarArr != null && dVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                d[] dVarArr2 = this.f448597j;
                if (i17 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i17];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, dVar);
                }
                i17++;
            }
        }
        int i18 = this.f448598k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        int i19 = this.f448599l;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i19);
        }
        hs4.a aVar = this.f448600m;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, aVar);
        }
        return !this.f448601n.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(14, this.f448601n) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f448588a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f448588a);
        }
        if (!this.f448589b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448589b);
        }
        if (!this.f448590c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448590c);
        }
        hs4.i iVar = this.f448591d;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(4, iVar);
        }
        hs4.b bVar = this.f448592e;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(5, bVar);
        }
        if (!this.f448593f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f448593f);
        }
        if (!this.f448594g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f448594g);
        }
        int i3 = this.f448595h;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i3);
        }
        int i16 = this.f448596i;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i16);
        }
        d[] dVarArr = this.f448597j;
        if (dVarArr != null && dVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                d[] dVarArr2 = this.f448597j;
                if (i17 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i17];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, dVar);
                }
                i17++;
            }
        }
        int i18 = this.f448598k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        int i19 = this.f448599l;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i19);
        }
        hs4.a aVar = this.f448600m;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(13, aVar);
        }
        if (!this.f448601n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f448601n);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
