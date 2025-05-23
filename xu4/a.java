package xu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile a[] f448704i;

    /* renamed from: a, reason: collision with root package name */
    public int f448705a;

    /* renamed from: b, reason: collision with root package name */
    public String f448706b;

    /* renamed from: c, reason: collision with root package name */
    public String f448707c;

    /* renamed from: d, reason: collision with root package name */
    public String f448708d;

    /* renamed from: e, reason: collision with root package name */
    public int f448709e;

    /* renamed from: f, reason: collision with root package name */
    public String f448710f;

    /* renamed from: g, reason: collision with root package name */
    public int f448711g;

    /* renamed from: h, reason: collision with root package name */
    public String f448712h;

    public a() {
        a();
    }

    public static a[] b() {
        if (f448704i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448704i == null) {
                    f448704i = new a[0];
                }
            }
        }
        return f448704i;
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
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        this.f448705a = readInt32;
                        break;
                }
            } else if (readTag == 18) {
                this.f448706b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f448707c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f448708d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f448709e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 50) {
                this.f448710f = codedInputByteBufferNano.readString();
            } else if (readTag == 56) {
                this.f448711g = codedInputByteBufferNano.readInt32();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448712h = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f448705a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f448706b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448706b);
        }
        if (!this.f448707c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448707c);
        }
        if (!this.f448708d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448708d);
        }
        int i16 = this.f448709e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        if (!this.f448710f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f448710f);
        }
        int i17 = this.f448711g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        return !this.f448712h.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.f448712h) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448705a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f448706b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448706b);
        }
        if (!this.f448707c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448707c);
        }
        if (!this.f448708d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448708d);
        }
        int i16 = this.f448709e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        if (!this.f448710f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f448710f);
        }
        int i17 = this.f448711g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        if (!this.f448712h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f448712h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f448705a = 0;
        this.f448706b = "";
        this.f448707c = "";
        this.f448708d = "";
        this.f448709e = 0;
        this.f448710f = "";
        this.f448711g = 0;
        this.f448712h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
