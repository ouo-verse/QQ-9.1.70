package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class af extends ExtendableMessageNano<af> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile af[] f440121i;

    /* renamed from: a, reason: collision with root package name */
    public int f440122a;

    /* renamed from: b, reason: collision with root package name */
    public int f440123b;

    /* renamed from: c, reason: collision with root package name */
    public String f440124c;

    /* renamed from: d, reason: collision with root package name */
    public String f440125d;

    /* renamed from: e, reason: collision with root package name */
    public long f440126e;

    /* renamed from: f, reason: collision with root package name */
    public String f440127f;

    /* renamed from: g, reason: collision with root package name */
    public int f440128g;

    /* renamed from: h, reason: collision with root package name */
    public String f440129h;

    public af() {
        a();
    }

    public static af[] b() {
        if (f440121i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440121i == null) {
                    f440121i = new af[0];
                }
            }
        }
        return f440121i;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public af mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440122a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f440123b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f440124c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f440125d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f440126e = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 50) {
                this.f440127f = codedInputByteBufferNano.readString();
            } else if (readTag == 56) {
                this.f440128g = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440129h = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440122a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f440123b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f440124c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440124c);
        }
        if (!this.f440125d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440125d);
        }
        long j3 = this.f440126e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!this.f440127f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f440127f);
        }
        int i17 = this.f440128g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        return !this.f440129h.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f440129h) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440122a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f440123b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f440124c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440124c);
        }
        if (!this.f440125d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440125d);
        }
        long j3 = this.f440126e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!this.f440127f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440127f);
        }
        int i17 = this.f440128g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        if (!this.f440129h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f440129h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public af a() {
        this.f440122a = 0;
        this.f440123b = 0;
        this.f440124c = "";
        this.f440125d = "";
        this.f440126e = 0L;
        this.f440127f = "";
        this.f440128g = 0;
        this.f440129h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
