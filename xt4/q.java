package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: l, reason: collision with root package name */
    private static volatile q[] f448629l;

    /* renamed from: a, reason: collision with root package name */
    public long f448630a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f448631b;

    /* renamed from: c, reason: collision with root package name */
    public String f448632c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.r f448633d;

    /* renamed from: e, reason: collision with root package name */
    public long f448634e;

    /* renamed from: f, reason: collision with root package name */
    public String f448635f;

    /* renamed from: g, reason: collision with root package name */
    public String f448636g;

    /* renamed from: h, reason: collision with root package name */
    public hs4.i f448637h;

    /* renamed from: i, reason: collision with root package name */
    public int f448638i;

    /* renamed from: j, reason: collision with root package name */
    public hs4.b f448639j;

    /* renamed from: k, reason: collision with root package name */
    public hs4.s f448640k;

    public q() {
        a();
    }

    public static q[] b() {
        if (f448629l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448629l == null) {
                    f448629l = new q[0];
                }
            }
        }
        return f448629l;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f448630a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f448631b = codedInputByteBufferNano.readBytes();
                    break;
                case 26:
                    this.f448632c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.f448633d == null) {
                        this.f448633d = new hs4.r();
                    }
                    codedInputByteBufferNano.readMessage(this.f448633d);
                    break;
                case 40:
                    this.f448634e = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.f448635f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f448636g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    if (this.f448637h == null) {
                        this.f448637h = new hs4.i();
                    }
                    codedInputByteBufferNano.readMessage(this.f448637h);
                    break;
                case 72:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f448638i = readInt32;
                        break;
                    }
                case 82:
                    if (this.f448639j == null) {
                        this.f448639j = new hs4.b();
                    }
                    codedInputByteBufferNano.readMessage(this.f448639j);
                    break;
                case 90:
                    if (this.f448640k == null) {
                        this.f448640k = new hs4.s();
                    }
                    codedInputByteBufferNano.readMessage(this.f448640k);
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
        long j3 = this.f448630a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f448631b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f448631b);
        }
        if (!this.f448632c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448632c);
        }
        hs4.r rVar = this.f448633d;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, rVar);
        }
        long j16 = this.f448634e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        if (!this.f448635f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f448635f);
        }
        if (!this.f448636g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f448636g);
        }
        hs4.i iVar = this.f448637h;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, iVar);
        }
        int i3 = this.f448638i;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i3);
        }
        hs4.b bVar = this.f448639j;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, bVar);
        }
        hs4.s sVar = this.f448640k;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(11, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448630a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f448631b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f448631b);
        }
        if (!this.f448632c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448632c);
        }
        hs4.r rVar = this.f448633d;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(4, rVar);
        }
        long j16 = this.f448634e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        if (!this.f448635f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f448635f);
        }
        if (!this.f448636g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f448636g);
        }
        hs4.i iVar = this.f448637h;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(8, iVar);
        }
        int i3 = this.f448638i;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i3);
        }
        hs4.b bVar = this.f448639j;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(10, bVar);
        }
        hs4.s sVar = this.f448640k;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(11, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public q a() {
        this.f448630a = 0L;
        this.f448631b = WireFormatNano.EMPTY_BYTES;
        this.f448632c = "";
        this.f448633d = null;
        this.f448634e = 0L;
        this.f448635f = "";
        this.f448636g = "";
        this.f448637h = null;
        this.f448638i = 0;
        this.f448639j = null;
        this.f448640k = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
