package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bc extends ExtendableMessageNano<bc> {

    /* renamed from: a, reason: collision with root package name */
    public int f440312a;

    /* renamed from: b, reason: collision with root package name */
    public int f440313b;

    /* renamed from: c, reason: collision with root package name */
    public int f440314c;

    /* renamed from: d, reason: collision with root package name */
    public int f440315d;

    /* renamed from: e, reason: collision with root package name */
    public int f440316e;

    /* renamed from: f, reason: collision with root package name */
    public long f440317f;

    /* renamed from: g, reason: collision with root package name */
    public String f440318g;

    public bc() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bc mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440312a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f440313b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f440314c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f440315d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f440316e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f440317f = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440318g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440312a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f440313b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f440314c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.f440315d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.f440316e;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        long j3 = this.f440317f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        return !this.f440318g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f440318g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440312a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f440313b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f440314c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.f440315d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.f440316e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        long j3 = this.f440317f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        if (!this.f440318g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f440318g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bc a() {
        this.f440312a = 0;
        this.f440313b = 0;
        this.f440314c = 0;
        this.f440315d = 0;
        this.f440316e = 0;
        this.f440317f = 0L;
        this.f440318g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
