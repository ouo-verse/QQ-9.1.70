package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ba extends ExtendableMessageNano<ba> {

    /* renamed from: m, reason: collision with root package name */
    private static volatile ba[] f430030m;

    /* renamed from: a, reason: collision with root package name */
    public int f430031a;

    /* renamed from: b, reason: collision with root package name */
    public String f430032b;

    /* renamed from: c, reason: collision with root package name */
    public int f430033c;

    /* renamed from: d, reason: collision with root package name */
    public String f430034d;

    /* renamed from: e, reason: collision with root package name */
    public String f430035e;

    /* renamed from: f, reason: collision with root package name */
    public String f430036f;

    /* renamed from: g, reason: collision with root package name */
    public String f430037g;

    /* renamed from: h, reason: collision with root package name */
    public String f430038h;

    /* renamed from: i, reason: collision with root package name */
    public String f430039i;

    /* renamed from: j, reason: collision with root package name */
    public pu4.g f430040j;

    /* renamed from: k, reason: collision with root package name */
    public pu4.g f430041k;

    /* renamed from: l, reason: collision with root package name */
    public long f430042l;

    public ba() {
        a();
    }

    public static ba[] b() {
        if (f430030m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430030m == null) {
                    f430030m = new ba[0];
                }
            }
        }
        return f430030m;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ba mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f430031a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f430032b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f430033c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f430034d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f430035e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f430036f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f430037g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f430038h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f430039i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    if (this.f430040j == null) {
                        this.f430040j = new pu4.g();
                    }
                    codedInputByteBufferNano.readMessage(this.f430040j);
                    break;
                case 90:
                    if (this.f430041k == null) {
                        this.f430041k = new pu4.g();
                    }
                    codedInputByteBufferNano.readMessage(this.f430041k);
                    break;
                case 96:
                    this.f430042l = codedInputByteBufferNano.readInt64();
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
        int i3 = this.f430031a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f430032b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430032b);
        }
        int i16 = this.f430033c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        if (!this.f430034d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430034d);
        }
        if (!this.f430035e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f430035e);
        }
        if (!this.f430036f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f430036f);
        }
        if (!this.f430037g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f430037g);
        }
        if (!this.f430038h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f430038h);
        }
        if (!this.f430039i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f430039i);
        }
        pu4.g gVar = this.f430040j;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, gVar);
        }
        pu4.g gVar2 = this.f430041k;
        if (gVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, gVar2);
        }
        long j3 = this.f430042l;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(12, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f430031a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f430032b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430032b);
        }
        int i16 = this.f430033c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!this.f430034d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430034d);
        }
        if (!this.f430035e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f430035e);
        }
        if (!this.f430036f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f430036f);
        }
        if (!this.f430037g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f430037g);
        }
        if (!this.f430038h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f430038h);
        }
        if (!this.f430039i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f430039i);
        }
        pu4.g gVar = this.f430040j;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(10, gVar);
        }
        pu4.g gVar2 = this.f430041k;
        if (gVar2 != null) {
            codedOutputByteBufferNano.writeMessage(11, gVar2);
        }
        long j3 = this.f430042l;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(12, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ba a() {
        this.f430031a = 0;
        this.f430032b = "";
        this.f430033c = 0;
        this.f430034d = "";
        this.f430035e = "";
        this.f430036f = "";
        this.f430037g = "";
        this.f430038h = "";
        this.f430039i = "";
        this.f430040j = null;
        this.f430041k = null;
        this.f430042l = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
