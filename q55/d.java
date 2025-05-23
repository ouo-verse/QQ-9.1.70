package q55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f428437a;

    /* renamed from: b, reason: collision with root package name */
    public r55.a f428438b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f428439c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f428440d;

    /* renamed from: e, reason: collision with root package name */
    public e f428441e;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f428437a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.f428438b == null) {
                    this.f428438b = new r55.a();
                }
                codedInputByteBufferNano.readMessage(this.f428438b);
            } else if (readTag == 24) {
                this.f428439c = codedInputByteBufferNano.readBool();
            } else if (readTag == 32) {
                this.f428440d = codedInputByteBufferNano.readBool();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f428441e == null) {
                    this.f428441e = new e();
                }
                codedInputByteBufferNano.readMessage(this.f428441e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f428437a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        r55.a aVar = this.f428438b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        boolean z17 = this.f428439c;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z17);
        }
        boolean z18 = this.f428440d;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z18);
        }
        e eVar = this.f428441e;
        return eVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, eVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f428437a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        r55.a aVar = this.f428438b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        boolean z17 = this.f428439c;
        if (z17) {
            codedOutputByteBufferNano.writeBool(3, z17);
        }
        boolean z18 = this.f428440d;
        if (z18) {
            codedOutputByteBufferNano.writeBool(4, z18);
        }
        e eVar = this.f428441e;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(5, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f428437a = false;
        this.f428438b = null;
        this.f428439c = false;
        this.f428440d = false;
        this.f428441e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
