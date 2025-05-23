package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ax extends ExtendableMessageNano<ax> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile ax[] f440257g;

    /* renamed from: a, reason: collision with root package name */
    public int f440258a;

    /* renamed from: b, reason: collision with root package name */
    public String f440259b;

    /* renamed from: c, reason: collision with root package name */
    public String f440260c;

    /* renamed from: d, reason: collision with root package name */
    public String f440261d;

    /* renamed from: e, reason: collision with root package name */
    public int f440262e;

    /* renamed from: f, reason: collision with root package name */
    public int f440263f;

    public ax() {
        a();
    }

    public static ax[] b() {
        if (f440257g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440257g == null) {
                    f440257g = new ax[0];
                }
            }
        }
        return f440257g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ax mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440258a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f440259b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f440260c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f440261d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f440262e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440263f = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440258a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f440259b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440259b);
        }
        if (!this.f440260c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440260c);
        }
        if (!this.f440261d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440261d);
        }
        int i16 = this.f440262e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f440263f;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440258a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f440259b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440259b);
        }
        if (!this.f440260c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440260c);
        }
        if (!this.f440261d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440261d);
        }
        int i16 = this.f440262e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f440263f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ax a() {
        this.f440258a = 0;
        this.f440259b = "";
        this.f440260c = "";
        this.f440261d = "";
        this.f440262e = 0;
        this.f440263f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
