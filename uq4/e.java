package uq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile e[] f439835j;

    /* renamed from: a, reason: collision with root package name */
    public String f439836a;

    /* renamed from: b, reason: collision with root package name */
    public String f439837b;

    /* renamed from: c, reason: collision with root package name */
    public String f439838c;

    /* renamed from: d, reason: collision with root package name */
    public String f439839d;

    /* renamed from: e, reason: collision with root package name */
    public int f439840e;

    /* renamed from: f, reason: collision with root package name */
    public float f439841f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f439842g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f439843h;

    /* renamed from: i, reason: collision with root package name */
    public String f439844i;

    public e() {
        a();
    }

    public static e[] b() {
        if (f439835j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f439835j == null) {
                    f439835j = new e[0];
                }
            }
        }
        return f439835j;
    }

    public e a() {
        this.f439836a = "";
        this.f439837b = "";
        this.f439838c = "";
        this.f439839d = "";
        this.f439840e = 0;
        this.f439841f = 0.0f;
        this.f439842g = false;
        this.f439843h = false;
        this.f439844i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 53) {
                                        if (readTag != 56) {
                                            if (readTag != 72) {
                                                if (readTag != 82) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f439844i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f439843h = codedInputByteBufferNano.readBool();
                                            }
                                        } else {
                                            this.f439842g = codedInputByteBufferNano.readBool();
                                        }
                                    } else {
                                        this.f439841f = codedInputByteBufferNano.readFloat();
                                    }
                                } else {
                                    this.f439840e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f439839d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f439838c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f439837b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f439836a = codedInputByteBufferNano.readString();
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
        if (!this.f439836a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f439836a);
        }
        if (!this.f439837b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f439837b);
        }
        if (!this.f439838c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f439838c);
        }
        if (!this.f439839d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f439839d);
        }
        int i3 = this.f439840e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        if (Float.floatToIntBits(this.f439841f) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.f439841f);
        }
        boolean z16 = this.f439842g;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z16);
        }
        boolean z17 = this.f439843h;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z17);
        }
        if (!this.f439844i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f439844i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f439836a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f439836a);
        }
        if (!this.f439837b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f439837b);
        }
        if (!this.f439838c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f439838c);
        }
        if (!this.f439839d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f439839d);
        }
        int i3 = this.f439840e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        if (Float.floatToIntBits(this.f439841f) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(6, this.f439841f);
        }
        boolean z16 = this.f439842g;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        boolean z17 = this.f439843h;
        if (z17) {
            codedOutputByteBufferNano.writeBool(9, z17);
        }
        if (!this.f439844i.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f439844i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
