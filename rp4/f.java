package rp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public int f431872a;

    /* renamed from: b, reason: collision with root package name */
    public d f431873b;

    /* renamed from: c, reason: collision with root package name */
    public e f431874c;

    /* renamed from: d, reason: collision with root package name */
    public qp4.f f431875d;

    /* renamed from: e, reason: collision with root package name */
    public h f431876e;

    /* renamed from: f, reason: collision with root package name */
    public b f431877f;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f431872a = 0;
        this.f431873b = null;
        this.f431874c = null;
        this.f431875d = null;
        this.f431876e = null;
        this.f431877f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 58) {
                                    if (readTag != 66) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        if (this.f431877f == null) {
                                            this.f431877f = new b();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f431877f);
                                    }
                                } else {
                                    if (this.f431876e == null) {
                                        this.f431876e = new h();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f431876e);
                                }
                            } else {
                                if (this.f431875d == null) {
                                    this.f431875d = new qp4.f();
                                }
                                codedInputByteBufferNano.readMessage(this.f431875d);
                            }
                        } else {
                            if (this.f431874c == null) {
                                this.f431874c = new e();
                            }
                            codedInputByteBufferNano.readMessage(this.f431874c);
                        }
                    } else {
                        if (this.f431873b == null) {
                            this.f431873b = new d();
                        }
                        codedInputByteBufferNano.readMessage(this.f431873b);
                    }
                } else {
                    this.f431872a = codedInputByteBufferNano.readUInt32();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f431872a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        d dVar = this.f431873b;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
        }
        e eVar = this.f431874c;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
        }
        qp4.f fVar = this.f431875d;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, fVar);
        }
        h hVar = this.f431876e;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, hVar);
        }
        b bVar = this.f431877f;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f431872a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        d dVar = this.f431873b;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2, dVar);
        }
        e eVar = this.f431874c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        qp4.f fVar = this.f431875d;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(4, fVar);
        }
        h hVar = this.f431876e;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(7, hVar);
        }
        b bVar = this.f431877f;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(8, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
