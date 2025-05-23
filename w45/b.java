package w45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile b[] f444593g;

    /* renamed from: a, reason: collision with root package name */
    public String f444594a;

    /* renamed from: b, reason: collision with root package name */
    public String f444595b;

    /* renamed from: c, reason: collision with root package name */
    public int f444596c;

    /* renamed from: d, reason: collision with root package name */
    public String f444597d;

    /* renamed from: e, reason: collision with root package name */
    public int f444598e;

    /* renamed from: f, reason: collision with root package name */
    public a f444599f;

    public b() {
        a();
    }

    public static b[] b() {
        if (f444593g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f444593g == null) {
                    f444593g = new b[0];
                }
            }
        }
        return f444593g;
    }

    public b a() {
        this.f444594a = "";
        this.f444595b = "";
        this.f444596c = 0;
        this.f444597d = "";
        this.f444598e = 0;
        this.f444599f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f444594a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f444595b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f444596c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.f444597d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f444598e = readInt32;
                }
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f444599f == null) {
                    this.f444599f = new a();
                }
                codedInputByteBufferNano.readMessage(this.f444599f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f444594a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f444594a);
        }
        if (!this.f444595b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f444595b);
        }
        int i3 = this.f444596c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f444597d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f444597d);
        }
        int i16 = this.f444598e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        a aVar = this.f444599f;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f444594a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f444594a);
        }
        if (!this.f444595b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f444595b);
        }
        int i3 = this.f444596c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f444597d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f444597d);
        }
        int i16 = this.f444598e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        a aVar = this.f444599f;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(6, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
