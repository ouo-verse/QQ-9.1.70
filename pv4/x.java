package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class x extends ExtendableMessageNano<x> {

    /* renamed from: a, reason: collision with root package name */
    public String f427717a;

    /* renamed from: b, reason: collision with root package name */
    public String f427718b;

    /* renamed from: c, reason: collision with root package name */
    public String f427719c;

    /* renamed from: d, reason: collision with root package name */
    public String f427720d;

    /* renamed from: e, reason: collision with root package name */
    public String f427721e;

    /* renamed from: f, reason: collision with root package name */
    public pu4.g f427722f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f427723g;

    /* renamed from: h, reason: collision with root package name */
    public int f427724h;

    /* renamed from: i, reason: collision with root package name */
    public o f427725i;

    /* renamed from: j, reason: collision with root package name */
    public u f427726j;

    public x() {
        a();
    }

    public x a() {
        this.f427717a = "";
        this.f427718b = "";
        this.f427719c = "";
        this.f427720d = "";
        this.f427721e = "";
        this.f427722f = null;
        this.f427723g = false;
        this.f427724h = 0;
        this.f427725i = null;
        this.f427726j = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public x mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f427717a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f427718b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f427719c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f427720d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f427721e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    if (this.f427722f == null) {
                        this.f427722f = new pu4.g();
                    }
                    codedInputByteBufferNano.readMessage(this.f427722f);
                    break;
                case 56:
                    this.f427723g = codedInputByteBufferNano.readBool();
                    break;
                case 64:
                    this.f427724h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    if (this.f427725i == null) {
                        this.f427725i = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f427725i);
                    break;
                case 82:
                    if (this.f427726j == null) {
                        this.f427726j = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f427726j);
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
        if (!this.f427717a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427717a);
        }
        if (!this.f427718b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427718b);
        }
        if (!this.f427719c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427719c);
        }
        if (!this.f427720d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427720d);
        }
        if (!this.f427721e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427721e);
        }
        pu4.g gVar = this.f427722f;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, gVar);
        }
        boolean z16 = this.f427723g;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z16);
        }
        int i3 = this.f427724h;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        o oVar = this.f427725i;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, oVar);
        }
        u uVar = this.f427726j;
        return uVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, uVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427717a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427717a);
        }
        if (!this.f427718b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427718b);
        }
        if (!this.f427719c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427719c);
        }
        if (!this.f427720d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427720d);
        }
        if (!this.f427721e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427721e);
        }
        pu4.g gVar = this.f427722f;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(6, gVar);
        }
        boolean z16 = this.f427723g;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        int i3 = this.f427724h;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        o oVar = this.f427725i;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(9, oVar);
        }
        u uVar = this.f427726j;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(10, uVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
