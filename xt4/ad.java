package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ad extends ExtendableMessageNano<ad> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile ad[] f448525f;

    /* renamed from: a, reason: collision with root package name */
    public int f448526a;

    /* renamed from: b, reason: collision with root package name */
    public String f448527b;

    /* renamed from: c, reason: collision with root package name */
    public int f448528c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f448529d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f448530e;

    public ad() {
        a();
    }

    public static ad[] b() {
        if (f448525f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448525f == null) {
                    f448525f = new ad[0];
                }
            }
        }
        return f448525f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ad mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f448526a = readInt32;
                }
            } else if (readTag == 18) {
                this.f448527b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f448528c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f448529d = codedInputByteBufferNano.readBool();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448530e = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f448526a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f448527b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448527b);
        }
        int i16 = this.f448528c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        boolean z16 = this.f448529d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        boolean z17 = this.f448530e;
        return z17 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448526a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f448527b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448527b);
        }
        int i16 = this.f448528c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        boolean z16 = this.f448529d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        boolean z17 = this.f448530e;
        if (z17) {
            codedOutputByteBufferNano.writeBool(5, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ad a() {
        this.f448526a = 0;
        this.f448527b = "";
        this.f448528c = 0;
        this.f448529d = false;
        this.f448530e = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
