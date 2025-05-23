package vu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: m, reason: collision with root package name */
    private static volatile c[] f443554m;

    /* renamed from: a, reason: collision with root package name */
    public long f443555a;

    /* renamed from: b, reason: collision with root package name */
    public int f443556b;

    /* renamed from: c, reason: collision with root package name */
    public int f443557c;

    /* renamed from: d, reason: collision with root package name */
    public int f443558d;

    /* renamed from: e, reason: collision with root package name */
    public String f443559e;

    /* renamed from: f, reason: collision with root package name */
    public long f443560f;

    /* renamed from: g, reason: collision with root package name */
    public String f443561g;

    /* renamed from: h, reason: collision with root package name */
    public int f443562h;

    /* renamed from: i, reason: collision with root package name */
    public String f443563i;

    /* renamed from: j, reason: collision with root package name */
    public e f443564j;

    /* renamed from: k, reason: collision with root package name */
    public d[] f443565k;

    /* renamed from: l, reason: collision with root package name */
    public String f443566l;

    public c() {
        a();
    }

    public static c[] b() {
        if (f443554m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f443554m == null) {
                    f443554m = new c[0];
                }
            }
        }
        return f443554m;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f443555a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f443556b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f443557c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f443558d = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f443559e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f443560f = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    this.f443561g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f443562h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f443563i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    if (this.f443564j == null) {
                        this.f443564j = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f443564j);
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    d[] dVarArr = this.f443565k;
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
                    this.f443565k = dVarArr2;
                    break;
                case 98:
                    this.f443566l = codedInputByteBufferNano.readString();
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
        long j3 = this.f443555a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f443556b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f443557c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f443558d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!this.f443559e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f443559e);
        }
        long j16 = this.f443560f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        if (!this.f443561g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f443561g);
        }
        int i18 = this.f443562h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        if (!this.f443563i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f443563i);
        }
        e eVar = this.f443564j;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, eVar);
        }
        d[] dVarArr = this.f443565k;
        if (dVarArr != null && dVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                d[] dVarArr2 = this.f443565k;
                if (i19 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i19];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, dVar);
                }
                i19++;
            }
        }
        return !this.f443566l.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.f443566l) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f443555a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f443556b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f443557c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f443558d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!this.f443559e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f443559e);
        }
        long j16 = this.f443560f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        if (!this.f443561g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f443561g);
        }
        int i18 = this.f443562h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        if (!this.f443563i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f443563i);
        }
        e eVar = this.f443564j;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(10, eVar);
        }
        d[] dVarArr = this.f443565k;
        if (dVarArr != null && dVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                d[] dVarArr2 = this.f443565k;
                if (i19 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i19];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, dVar);
                }
                i19++;
            }
        }
        if (!this.f443566l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f443566l);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f443555a = 0L;
        this.f443556b = 0;
        this.f443557c = 0;
        this.f443558d = 0;
        this.f443559e = "";
        this.f443560f = 0L;
        this.f443561g = "";
        this.f443562h = 0;
        this.f443563i = "";
        this.f443564j = null;
        this.f443565k = d.b();
        this.f443566l = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
