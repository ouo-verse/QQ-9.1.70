package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile h[] f427603k;

    /* renamed from: a, reason: collision with root package name */
    public String f427604a;

    /* renamed from: b, reason: collision with root package name */
    public d f427605b;

    /* renamed from: c, reason: collision with root package name */
    public String f427606c;

    /* renamed from: d, reason: collision with root package name */
    public String f427607d;

    /* renamed from: e, reason: collision with root package name */
    public int f427608e;

    /* renamed from: f, reason: collision with root package name */
    public String f427609f;

    /* renamed from: g, reason: collision with root package name */
    public String f427610g;

    /* renamed from: h, reason: collision with root package name */
    public i f427611h;

    /* renamed from: i, reason: collision with root package name */
    public String f427612i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f427613j;

    public h() {
        a();
    }

    public static h[] b() {
        if (f427603k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427603k == null) {
                    f427603k = new h[0];
                }
            }
        }
        return f427603k;
    }

    public h a() {
        this.f427604a = "";
        this.f427605b = null;
        this.f427606c = "";
        this.f427607d = "";
        this.f427608e = 0;
        this.f427609f = "";
        this.f427610g = "";
        this.f427611h = null;
        this.f427612i = "";
        this.f427613j = false;
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
                    this.f427604a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    if (this.f427605b == null) {
                        this.f427605b = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f427605b);
                    break;
                case 26:
                    this.f427606c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f427607d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f427608e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.f427609f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f427610g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    if (this.f427611h == null) {
                        this.f427611h = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.f427611h);
                    break;
                case 74:
                    this.f427612i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f427613j = codedInputByteBufferNano.readBool();
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
        if (!this.f427604a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427604a);
        }
        d dVar = this.f427605b;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
        }
        if (!this.f427606c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427606c);
        }
        if (!this.f427607d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427607d);
        }
        int i3 = this.f427608e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        if (!this.f427609f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427609f);
        }
        if (!this.f427610g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f427610g);
        }
        i iVar = this.f427611h;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, iVar);
        }
        if (!this.f427612i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f427612i);
        }
        boolean z16 = this.f427613j;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(10, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427604a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427604a);
        }
        d dVar = this.f427605b;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2, dVar);
        }
        if (!this.f427606c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427606c);
        }
        if (!this.f427607d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427607d);
        }
        int i3 = this.f427608e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        if (!this.f427609f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427609f);
        }
        if (!this.f427610g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427610g);
        }
        i iVar = this.f427611h;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(8, iVar);
        }
        if (!this.f427612i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f427612i);
        }
        boolean z16 = this.f427613j;
        if (z16) {
            codedOutputByteBufferNano.writeBool(10, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
