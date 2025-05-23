package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile j[] f427617g;

    /* renamed from: a, reason: collision with root package name */
    public int f427618a;

    /* renamed from: b, reason: collision with root package name */
    public String f427619b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f427620c;

    /* renamed from: d, reason: collision with root package name */
    public l f427621d;

    /* renamed from: e, reason: collision with root package name */
    public m[] f427622e;

    /* renamed from: f, reason: collision with root package name */
    public k[] f427623f;

    public j() {
        a();
    }

    public static j[] b() {
        if (f427617g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427617g == null) {
                    f427617g = new j[0];
                }
            }
        }
        return f427617g;
    }

    public static j d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f427618a = readInt32;
                }
            } else if (readTag == 18) {
                this.f427619b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f427620c = codedInputByteBufferNano.readBool();
            } else if (readTag == 34) {
                if (this.f427621d == null) {
                    this.f427621d = new l();
                }
                codedInputByteBufferNano.readMessage(this.f427621d);
            } else if (readTag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                m[] mVarArr = this.f427622e;
                int length = mVarArr == null ? 0 : mVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                m[] mVarArr2 = new m[i3];
                if (length != 0) {
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    m mVar = new m();
                    mVarArr2[length] = mVar;
                    codedInputByteBufferNano.readMessage(mVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                m mVar2 = new m();
                mVarArr2[length] = mVar2;
                codedInputByteBufferNano.readMessage(mVar2);
                this.f427622e = mVarArr2;
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                k[] kVarArr = this.f427623f;
                int length2 = kVarArr == null ? 0 : kVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                k[] kVarArr2 = new k[i16];
                if (length2 != 0) {
                    System.arraycopy(kVarArr, 0, kVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    k kVar = new k();
                    kVarArr2[length2] = kVar;
                    codedInputByteBufferNano.readMessage(kVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                k kVar2 = new k();
                kVarArr2[length2] = kVar2;
                codedInputByteBufferNano.readMessage(kVar2);
                this.f427623f = kVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427618a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f427619b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427619b);
        }
        boolean z16 = this.f427620c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        l lVar = this.f427621d;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, lVar);
        }
        m[] mVarArr = this.f427622e;
        int i16 = 0;
        if (mVarArr != null && mVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                m[] mVarArr2 = this.f427622e;
                if (i17 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i17];
                if (mVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, mVar);
                }
                i17++;
            }
        }
        k[] kVarArr = this.f427623f;
        if (kVarArr != null && kVarArr.length > 0) {
            while (true) {
                k[] kVarArr2 = this.f427623f;
                if (i16 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i16];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, kVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427618a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f427619b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427619b);
        }
        boolean z16 = this.f427620c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        l lVar = this.f427621d;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(4, lVar);
        }
        m[] mVarArr = this.f427622e;
        int i16 = 0;
        if (mVarArr != null && mVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                m[] mVarArr2 = this.f427622e;
                if (i17 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i17];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, mVar);
                }
                i17++;
            }
        }
        k[] kVarArr = this.f427623f;
        if (kVarArr != null && kVarArr.length > 0) {
            while (true) {
                k[] kVarArr2 = this.f427623f;
                if (i16 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i16];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, kVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f427618a = 0;
        this.f427619b = "";
        this.f427620c = false;
        this.f427621d = null;
        this.f427622e = m.b();
        this.f427623f = k.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
