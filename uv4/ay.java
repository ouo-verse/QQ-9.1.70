package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ay extends ExtendableMessageNano<ay> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile ay[] f440264j;

    /* renamed from: a, reason: collision with root package name */
    public String f440265a;

    /* renamed from: b, reason: collision with root package name */
    public int f440266b;

    /* renamed from: c, reason: collision with root package name */
    public String f440267c;

    /* renamed from: d, reason: collision with root package name */
    public String f440268d;

    /* renamed from: e, reason: collision with root package name */
    public String f440269e;

    /* renamed from: f, reason: collision with root package name */
    public bg[] f440270f;

    /* renamed from: g, reason: collision with root package name */
    public String f440271g;

    /* renamed from: h, reason: collision with root package name */
    public int f440272h;

    /* renamed from: i, reason: collision with root package name */
    public int f440273i;

    public ay() {
        a();
    }

    public static ay[] b() {
        if (f440264j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440264j == null) {
                    f440264j = new ay[0];
                }
            }
        }
        return f440264j;
    }

    public ay a() {
        this.f440265a = "";
        this.f440266b = 0;
        this.f440267c = "";
        this.f440268d = "";
        this.f440269e = "";
        this.f440270f = bg.b();
        this.f440271g = "";
        this.f440272h = 0;
        this.f440273i = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440265a = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f440266b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.f440267c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f440268d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f440269e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                bg[] bgVarArr = this.f440270f;
                int length = bgVarArr == null ? 0 : bgVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bg[] bgVarArr2 = new bg[i3];
                if (length != 0) {
                    System.arraycopy(bgVarArr, 0, bgVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bg bgVar = new bg();
                    bgVarArr2[length] = bgVar;
                    codedInputByteBufferNano.readMessage(bgVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bg bgVar2 = new bg();
                bgVarArr2[length] = bgVar2;
                codedInputByteBufferNano.readMessage(bgVar2);
                this.f440270f = bgVarArr2;
            } else if (readTag == 58) {
                this.f440271g = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.f440272h = codedInputByteBufferNano.readInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440273i = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440265a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440265a);
        }
        int i3 = this.f440266b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f440267c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440267c);
        }
        if (!this.f440268d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440268d);
        }
        if (!this.f440269e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f440269e);
        }
        bg[] bgVarArr = this.f440270f;
        if (bgVarArr != null && bgVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bg[] bgVarArr2 = this.f440270f;
                if (i16 >= bgVarArr2.length) {
                    break;
                }
                bg bgVar = bgVarArr2[i16];
                if (bgVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, bgVar);
                }
                i16++;
            }
        }
        if (!this.f440271g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f440271g);
        }
        int i17 = this.f440272h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        int i18 = this.f440273i;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440265a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440265a);
        }
        int i3 = this.f440266b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f440267c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440267c);
        }
        if (!this.f440268d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440268d);
        }
        if (!this.f440269e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f440269e);
        }
        bg[] bgVarArr = this.f440270f;
        if (bgVarArr != null && bgVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bg[] bgVarArr2 = this.f440270f;
                if (i16 >= bgVarArr2.length) {
                    break;
                }
                bg bgVar = bgVarArr2[i16];
                if (bgVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, bgVar);
                }
                i16++;
            }
        }
        if (!this.f440271g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f440271g);
        }
        int i17 = this.f440272h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        int i18 = this.f440273i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
