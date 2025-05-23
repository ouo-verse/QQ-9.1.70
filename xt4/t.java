package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f448647a;

    /* renamed from: b, reason: collision with root package name */
    public int f448648b;

    /* renamed from: c, reason: collision with root package name */
    public hs4.n f448649c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.n f448650d;

    public t() {
        a();
    }

    public static t c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (t) MessageNano.mergeFrom(new t(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448647a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.f448648b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                if (this.f448649c == null) {
                    this.f448649c = new hs4.n();
                }
                codedInputByteBufferNano.readMessage(this.f448649c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448650d == null) {
                    this.f448650d = new hs4.n();
                }
                codedInputByteBufferNano.readMessage(this.f448650d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f448647a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f448648b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        hs4.n nVar = this.f448649c;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, nVar);
        }
        hs4.n nVar2 = this.f448650d;
        return nVar2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, nVar2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f448647a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f448648b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        hs4.n nVar = this.f448649c;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(3, nVar);
        }
        hs4.n nVar2 = this.f448650d;
        if (nVar2 != null) {
            codedOutputByteBufferNano.writeMessage(4, nVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public t a() {
        this.f448647a = false;
        this.f448648b = 0;
        this.f448649c = null;
        this.f448650d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
