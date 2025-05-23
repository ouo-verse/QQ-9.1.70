package ws4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f446418a;

    /* renamed from: b, reason: collision with root package name */
    public long f446419b;

    /* renamed from: c, reason: collision with root package name */
    public String f446420c;

    /* renamed from: d, reason: collision with root package name */
    public d f446421d;

    /* renamed from: e, reason: collision with root package name */
    public c f446422e;

    public e() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f446418a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.f446419b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 26) {
                this.f446420c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                if (this.f446421d == null) {
                    this.f446421d = new d();
                }
                codedInputByteBufferNano.readMessage(this.f446421d);
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f446422e == null) {
                    this.f446422e = new c();
                }
                codedInputByteBufferNano.readMessage(this.f446422e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f446418a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        long j3 = this.f446419b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        if (!this.f446420c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f446420c);
        }
        d dVar = this.f446421d;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, dVar);
        }
        c cVar = this.f446422e;
        return cVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, cVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f446418a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        long j3 = this.f446419b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        if (!this.f446420c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f446420c);
        }
        d dVar = this.f446421d;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(4, dVar);
        }
        c cVar = this.f446422e;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(5, cVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f446418a = false;
        this.f446419b = 0L;
        this.f446420c = "";
        this.f446421d = null;
        this.f446422e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
