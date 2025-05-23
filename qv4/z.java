package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class z extends ExtendableMessageNano<z> {

    /* renamed from: a, reason: collision with root package name */
    public bk f430211a;

    /* renamed from: b, reason: collision with root package name */
    public pv4.r f430212b;

    /* renamed from: c, reason: collision with root package name */
    public pv4.r f430213c;

    /* renamed from: d, reason: collision with root package name */
    public nw4.i f430214d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f430215e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f430216f;

    /* renamed from: g, reason: collision with root package name */
    public bj f430217g;

    public z() {
        a();
    }

    public static z c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (z) MessageNano.mergeFrom(new z(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430211a == null) {
                    this.f430211a = new bk();
                }
                codedInputByteBufferNano.readMessage(this.f430211a);
            } else if (readTag == 18) {
                if (this.f430212b == null) {
                    this.f430212b = new pv4.r();
                }
                codedInputByteBufferNano.readMessage(this.f430212b);
            } else if (readTag == 26) {
                if (this.f430213c == null) {
                    this.f430213c = new pv4.r();
                }
                codedInputByteBufferNano.readMessage(this.f430213c);
            } else if (readTag == 34) {
                if (this.f430214d == null) {
                    this.f430214d = new nw4.i();
                }
                codedInputByteBufferNano.readMessage(this.f430214d);
            } else if (readTag == 40) {
                this.f430215e = codedInputByteBufferNano.readBool();
            } else if (readTag == 48) {
                this.f430216f = codedInputByteBufferNano.readBool();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f430217g == null) {
                    this.f430217g = new bj();
                }
                codedInputByteBufferNano.readMessage(this.f430217g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bk bkVar = this.f430211a;
        if (bkVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bkVar);
        }
        pv4.r rVar = this.f430212b;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, rVar);
        }
        pv4.r rVar2 = this.f430213c;
        if (rVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, rVar2);
        }
        nw4.i iVar = this.f430214d;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, iVar);
        }
        boolean z16 = this.f430215e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        boolean z17 = this.f430216f;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z17);
        }
        bj bjVar = this.f430217g;
        return bjVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, bjVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bk bkVar = this.f430211a;
        if (bkVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bkVar);
        }
        pv4.r rVar = this.f430212b;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(2, rVar);
        }
        pv4.r rVar2 = this.f430213c;
        if (rVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, rVar2);
        }
        nw4.i iVar = this.f430214d;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(4, iVar);
        }
        boolean z16 = this.f430215e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        boolean z17 = this.f430216f;
        if (z17) {
            codedOutputByteBufferNano.writeBool(6, z17);
        }
        bj bjVar = this.f430217g;
        if (bjVar != null) {
            codedOutputByteBufferNano.writeMessage(7, bjVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public z a() {
        this.f430211a = null;
        this.f430212b = null;
        this.f430213c = null;
        this.f430214d = null;
        this.f430215e = false;
        this.f430216f = false;
        this.f430217g = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
