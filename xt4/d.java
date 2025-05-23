package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile d[] f448567k;

    /* renamed from: a, reason: collision with root package name */
    public float f448568a;

    /* renamed from: b, reason: collision with root package name */
    public float f448569b;

    /* renamed from: c, reason: collision with root package name */
    public float f448570c;

    /* renamed from: d, reason: collision with root package name */
    public float f448571d;

    /* renamed from: e, reason: collision with root package name */
    public String f448572e;

    /* renamed from: f, reason: collision with root package name */
    public int f448573f;

    /* renamed from: g, reason: collision with root package name */
    public int f448574g;

    /* renamed from: h, reason: collision with root package name */
    public int f448575h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f448576i;

    /* renamed from: j, reason: collision with root package name */
    public c f448577j;

    public d() {
        a();
    }

    public static d[] b() {
        if (f448567k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448567k == null) {
                    f448567k = new d[0];
                }
            }
        }
        return f448567k;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 13:
                    this.f448568a = codedInputByteBufferNano.readFloat();
                    break;
                case 21:
                    this.f448569b = codedInputByteBufferNano.readFloat();
                    break;
                case 29:
                    this.f448570c = codedInputByteBufferNano.readFloat();
                    break;
                case 37:
                    this.f448571d = codedInputByteBufferNano.readFloat();
                    break;
                case 42:
                    this.f448572e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.f448573f = readInt32;
                        break;
                    }
                case 56:
                    this.f448574g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f448575h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f448576i = codedInputByteBufferNano.readBool();
                    break;
                case 82:
                    if (this.f448577j == null) {
                        this.f448577j = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f448577j);
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
        if (Float.floatToIntBits(this.f448568a) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.f448568a);
        }
        if (Float.floatToIntBits(this.f448569b) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.f448569b);
        }
        if (Float.floatToIntBits(this.f448570c) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.f448570c);
        }
        if (Float.floatToIntBits(this.f448571d) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.f448571d);
        }
        if (!this.f448572e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f448572e);
        }
        int i3 = this.f448573f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
        }
        int i16 = this.f448574g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.f448575h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        boolean z16 = this.f448576i;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z16);
        }
        c cVar = this.f448577j;
        return cVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, cVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (Float.floatToIntBits(this.f448568a) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(1, this.f448568a);
        }
        if (Float.floatToIntBits(this.f448569b) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(2, this.f448569b);
        }
        if (Float.floatToIntBits(this.f448570c) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.f448570c);
        }
        if (Float.floatToIntBits(this.f448571d) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.f448571d);
        }
        if (!this.f448572e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f448572e);
        }
        int i3 = this.f448573f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        int i16 = this.f448574g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.f448575h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        boolean z16 = this.f448576i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(9, z16);
        }
        c cVar = this.f448577j;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(10, cVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f448568a = 0.0f;
        this.f448569b = 0.0f;
        this.f448570c = 0.0f;
        this.f448571d = 0.0f;
        this.f448572e = "";
        this.f448573f = 0;
        this.f448574g = 0;
        this.f448575h = 0;
        this.f448576i = false;
        this.f448577j = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
