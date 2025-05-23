package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: m, reason: collision with root package name */
    private static volatile e[] f440402m;

    /* renamed from: a, reason: collision with root package name */
    public long f440403a;

    /* renamed from: b, reason: collision with root package name */
    public int f440404b;

    /* renamed from: c, reason: collision with root package name */
    public long f440405c;

    /* renamed from: d, reason: collision with root package name */
    public String f440406d;

    /* renamed from: e, reason: collision with root package name */
    public int f440407e;

    /* renamed from: f, reason: collision with root package name */
    public int f440408f;

    /* renamed from: g, reason: collision with root package name */
    public int f440409g;

    /* renamed from: h, reason: collision with root package name */
    public String f440410h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f440411i;

    /* renamed from: j, reason: collision with root package name */
    public int f440412j;

    /* renamed from: k, reason: collision with root package name */
    public Map<String, String> f440413k;

    /* renamed from: l, reason: collision with root package name */
    public String f440414l;

    public e() {
        a();
    }

    public static e[] b() {
        if (f440402m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440402m == null) {
                    f440402m = new e[0];
                }
            }
        }
        return f440402m;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f440403a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f440404b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f440405c = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.f440406d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f440407e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f440408f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f440409g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.f440410h = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.f440411i = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    this.f440412j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.f440413k = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f440413k, mapFactory, 9, 9, null, 10, 18);
                    break;
                case 98:
                    this.f440414l = codedInputByteBufferNano.readString();
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
        long j3 = this.f440403a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f440404b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.f440405c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.f440406d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440406d);
        }
        int i16 = this.f440407e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f440408f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.f440409g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        if (!this.f440410h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f440410h);
        }
        boolean z16 = this.f440411i;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z16);
        }
        int i19 = this.f440412j;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i19);
        }
        Map<String, String> map = this.f440413k;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 11, 9, 9);
        }
        return !this.f440414l.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.f440414l) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f440403a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f440404b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.f440405c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f440406d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440406d);
        }
        int i16 = this.f440407e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f440408f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.f440409g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        if (!this.f440410h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f440410h);
        }
        boolean z16 = this.f440411i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(9, z16);
        }
        int i19 = this.f440412j;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i19);
        }
        Map<String, String> map = this.f440413k;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 11, 9, 9);
        }
        if (!this.f440414l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f440414l);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f440403a = 0L;
        this.f440404b = 0;
        this.f440405c = 0L;
        this.f440406d = "";
        this.f440407e = 0;
        this.f440408f = 0;
        this.f440409g = 0;
        this.f440410h = "";
        this.f440411i = false;
        this.f440412j = 0;
        this.f440413k = null;
        this.f440414l = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
