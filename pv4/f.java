package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile f[] f427596f;

    /* renamed from: a, reason: collision with root package name */
    public int f427597a;

    /* renamed from: b, reason: collision with root package name */
    public int f427598b;

    /* renamed from: c, reason: collision with root package name */
    public int f427599c;

    /* renamed from: d, reason: collision with root package name */
    public int f427600d;

    /* renamed from: e, reason: collision with root package name */
    public g f427601e;

    public f() {
        a();
    }

    public static f[] b() {
        if (f427596f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427596f == null) {
                    f427596f = new f[0];
                }
            }
        }
        return f427596f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427597a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f427598b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f427599c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f427600d = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f427601e == null) {
                    this.f427601e = new g();
                }
                codedInputByteBufferNano.readMessage(this.f427601e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427597a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f427598b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f427599c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.f427600d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        g gVar = this.f427601e;
        return gVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, gVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427597a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f427598b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f427599c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.f427600d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        g gVar = this.f427601e;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(5, gVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f427597a = 0;
        this.f427598b = 0;
        this.f427599c = 0;
        this.f427600d = 0;
        this.f427601e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
