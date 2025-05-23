package vy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f443690a;

    /* renamed from: b, reason: collision with root package name */
    public long f443691b;

    /* renamed from: c, reason: collision with root package name */
    public d f443692c;

    /* renamed from: d, reason: collision with root package name */
    public String f443693d;

    /* renamed from: e, reason: collision with root package name */
    public long f443694e;

    /* renamed from: f, reason: collision with root package name */
    public String f443695f;

    public f() {
        a();
    }

    public f a() {
        this.f443690a = 0L;
        this.f443691b = 0L;
        this.f443692c = null;
        this.f443693d = "";
        this.f443694e = 0L;
        this.f443695f = "";
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
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f443695f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f443694e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f443693d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            if (this.f443692c == null) {
                                this.f443692c = new d();
                            }
                            codedInputByteBufferNano.readMessage(this.f443692c);
                        }
                    } else {
                        this.f443691b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f443690a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f443690a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f443691b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        d dVar = this.f443692c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        if (!this.f443693d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f443693d);
        }
        long j17 = this.f443694e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        if (!this.f443695f.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f443695f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f443690a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f443691b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        d dVar = this.f443692c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        if (!this.f443693d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f443693d);
        }
        long j17 = this.f443694e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        if (!this.f443695f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f443695f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
