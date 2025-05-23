package rq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public i f431934a;

    /* renamed from: b, reason: collision with root package name */
    public d f431935b;

    /* renamed from: c, reason: collision with root package name */
    public int f431936c;

    /* renamed from: d, reason: collision with root package name */
    public int f431937d;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f431934a = null;
        this.f431935b = null;
        this.f431936c = 0;
        this.f431937d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f431937d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f431936c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        if (this.f431935b == null) {
                            this.f431935b = new d();
                        }
                        codedInputByteBufferNano.readMessage(this.f431935b);
                    }
                } else {
                    if (this.f431934a == null) {
                        this.f431934a = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.f431934a);
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
        i iVar = this.f431934a;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iVar);
        }
        d dVar = this.f431935b;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
        }
        int i3 = this.f431936c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.f431937d;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        i iVar = this.f431934a;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(1, iVar);
        }
        d dVar = this.f431935b;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2, dVar);
        }
        int i3 = this.f431936c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.f431937d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
