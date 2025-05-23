package st4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile a[] f434734i;

    /* renamed from: a, reason: collision with root package name */
    public int f434735a;

    /* renamed from: b, reason: collision with root package name */
    public String f434736b;

    /* renamed from: c, reason: collision with root package name */
    public String f434737c;

    /* renamed from: d, reason: collision with root package name */
    public String f434738d;

    /* renamed from: e, reason: collision with root package name */
    public String f434739e;

    /* renamed from: f, reason: collision with root package name */
    public int f434740f;

    /* renamed from: g, reason: collision with root package name */
    public long f434741g;

    /* renamed from: h, reason: collision with root package name */
    public int f434742h;

    public a() {
        a();
    }

    public static a[] b() {
        if (f434734i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f434734i == null) {
                    f434734i = new a[0];
                }
            }
        }
        return f434734i;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f434735a = readInt32;
                }
            } else if (readTag == 18) {
                this.f434736b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f434737c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f434738d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f434739e = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                    this.f434740f = readInt322;
                }
            } else if (readTag == 56) {
                this.f434741g = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt323 = codedInputByteBufferNano.readInt32();
                if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2) {
                    this.f434742h = readInt323;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f434735a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f434736b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434736b);
        }
        if (!this.f434737c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434737c);
        }
        if (!this.f434738d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f434738d);
        }
        if (!this.f434739e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f434739e);
        }
        int i16 = this.f434740f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        long j3 = this.f434741g;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        int i17 = this.f434742h;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f434735a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f434736b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434736b);
        }
        if (!this.f434737c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434737c);
        }
        if (!this.f434738d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f434738d);
        }
        if (!this.f434739e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f434739e);
        }
        int i16 = this.f434740f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        long j3 = this.f434741g;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        int i17 = this.f434742h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f434735a = 0;
        this.f434736b = "";
        this.f434737c = "";
        this.f434738d = "";
        this.f434739e = "";
        this.f434740f = 0;
        this.f434741g = 0L;
        this.f434742h = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
