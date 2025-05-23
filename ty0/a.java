package ty0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f437891a;

    /* renamed from: b, reason: collision with root package name */
    public long f437892b;

    /* renamed from: c, reason: collision with root package name */
    public long f437893c;

    /* renamed from: d, reason: collision with root package name */
    public long f437894d;

    /* renamed from: e, reason: collision with root package name */
    public long f437895e;

    /* renamed from: f, reason: collision with root package name */
    public long f437896f;

    /* renamed from: g, reason: collision with root package name */
    public int f437897g;

    /* renamed from: h, reason: collision with root package name */
    public String f437898h;

    /* renamed from: i, reason: collision with root package name */
    public String f437899i;

    /* renamed from: j, reason: collision with root package name */
    public int f437900j;

    /* renamed from: k, reason: collision with root package name */
    public int f437901k;

    public a() {
        a();
    }

    public a a() {
        this.f437891a = 0L;
        this.f437892b = 0L;
        this.f437893c = 0L;
        this.f437894d = 0L;
        this.f437895e = 0L;
        this.f437896f = 0L;
        this.f437897g = 0;
        this.f437898h = "";
        this.f437899i = "";
        this.f437900j = 0;
        this.f437901k = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f437891a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f437892b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.f437893c = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.f437894d = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.f437895e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f437896f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.f437897g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.f437898h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f437899i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f437900j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f437901k = codedInputByteBufferNano.readUInt32();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f437891a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f437892b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.f437893c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.f437894d;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j18);
        }
        long j19 = this.f437895e;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j19);
        }
        long j26 = this.f437896f;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j26);
        }
        int i3 = this.f437897g;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        if (!this.f437898h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f437898h);
        }
        if (!this.f437899i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f437899i);
        }
        int i16 = this.f437900j;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i16);
        }
        int i17 = this.f437901k;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(11, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f437891a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f437892b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.f437893c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.f437894d;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j18);
        }
        long j19 = this.f437895e;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j19);
        }
        long j26 = this.f437896f;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j26);
        }
        int i3 = this.f437897g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        if (!this.f437898h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f437898h);
        }
        if (!this.f437899i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f437899i);
        }
        int i16 = this.f437900j;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i16);
        }
        int i17 = this.f437901k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
