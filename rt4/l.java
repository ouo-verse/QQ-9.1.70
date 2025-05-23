package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile l[] f432422h;

    /* renamed from: a, reason: collision with root package name */
    public hs4.r[] f432423a;

    /* renamed from: b, reason: collision with root package name */
    public int f432424b;

    /* renamed from: c, reason: collision with root package name */
    public m f432425c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f432426d;

    /* renamed from: e, reason: collision with root package name */
    public r f432427e;

    /* renamed from: f, reason: collision with root package name */
    public n f432428f;

    /* renamed from: g, reason: collision with root package name */
    public hs4.s[] f432429g;

    public l() {
        a();
    }

    public static l[] b() {
        if (f432422h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432422h == null) {
                    f432422h = new l[0];
                }
            }
        }
        return f432422h;
    }

    public l a() {
        this.f432423a = hs4.r.b();
        this.f432424b = 0;
        this.f432425c = null;
        this.f432426d = false;
        this.f432427e = null;
        this.f432428f = null;
        this.f432429g = hs4.s.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                hs4.r[] rVarArr = this.f432423a;
                int length = rVarArr == null ? 0 : rVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                hs4.r[] rVarArr2 = new hs4.r[i3];
                if (length != 0) {
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    hs4.r rVar = new hs4.r();
                    rVarArr2[length] = rVar;
                    codedInputByteBufferNano.readMessage(rVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                hs4.r rVar2 = new hs4.r();
                rVarArr2[length] = rVar2;
                codedInputByteBufferNano.readMessage(rVar2);
                this.f432423a = rVarArr2;
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f432424b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.f432425c == null) {
                    this.f432425c = new m();
                }
                codedInputByteBufferNano.readMessage(this.f432425c);
            } else if (readTag == 32) {
                this.f432426d = codedInputByteBufferNano.readBool();
            } else if (readTag == 42) {
                if (this.f432427e == null) {
                    this.f432427e = new r();
                }
                codedInputByteBufferNano.readMessage(this.f432427e);
            } else if (readTag == 50) {
                if (this.f432428f == null) {
                    this.f432428f = new n();
                }
                codedInputByteBufferNano.readMessage(this.f432428f);
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                hs4.s[] sVarArr = this.f432429g;
                int length2 = sVarArr == null ? 0 : sVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                hs4.s[] sVarArr2 = new hs4.s[i16];
                if (length2 != 0) {
                    System.arraycopy(sVarArr, 0, sVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    hs4.s sVar = new hs4.s();
                    sVarArr2[length2] = sVar;
                    codedInputByteBufferNano.readMessage(sVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                hs4.s sVar2 = new hs4.s();
                sVarArr2[length2] = sVar2;
                codedInputByteBufferNano.readMessage(sVar2);
                this.f432429g = sVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        hs4.r[] rVarArr = this.f432423a;
        int i3 = 0;
        if (rVarArr != null && rVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                hs4.r[] rVarArr2 = this.f432423a;
                if (i16 >= rVarArr2.length) {
                    break;
                }
                hs4.r rVar = rVarArr2[i16];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
                }
                i16++;
            }
        }
        int i17 = this.f432424b;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i17);
        }
        m mVar = this.f432425c;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, mVar);
        }
        boolean z16 = this.f432426d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        r rVar2 = this.f432427e;
        if (rVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, rVar2);
        }
        n nVar = this.f432428f;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, nVar);
        }
        hs4.s[] sVarArr = this.f432429g;
        if (sVarArr != null && sVarArr.length > 0) {
            while (true) {
                hs4.s[] sVarArr2 = this.f432429g;
                if (i3 >= sVarArr2.length) {
                    break;
                }
                hs4.s sVar = sVarArr2[i3];
                if (sVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, sVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        hs4.r[] rVarArr = this.f432423a;
        int i3 = 0;
        if (rVarArr != null && rVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                hs4.r[] rVarArr2 = this.f432423a;
                if (i16 >= rVarArr2.length) {
                    break;
                }
                hs4.r rVar = rVarArr2[i16];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, rVar);
                }
                i16++;
            }
        }
        int i17 = this.f432424b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i17);
        }
        m mVar = this.f432425c;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(3, mVar);
        }
        boolean z16 = this.f432426d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        r rVar2 = this.f432427e;
        if (rVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, rVar2);
        }
        n nVar = this.f432428f;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(6, nVar);
        }
        hs4.s[] sVarArr = this.f432429g;
        if (sVarArr != null && sVarArr.length > 0) {
            while (true) {
                hs4.s[] sVarArr2 = this.f432429g;
                if (i3 >= sVarArr2.length) {
                    break;
                }
                hs4.s sVar = sVarArr2[i3];
                if (sVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, sVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
