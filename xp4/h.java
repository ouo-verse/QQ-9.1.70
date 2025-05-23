package xp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile h[] f448324i;

    /* renamed from: a, reason: collision with root package name */
    public long f448325a;

    /* renamed from: b, reason: collision with root package name */
    public qp4.e f448326b;

    /* renamed from: c, reason: collision with root package name */
    public String f448327c;

    /* renamed from: d, reason: collision with root package name */
    public String f448328d;

    /* renamed from: e, reason: collision with root package name */
    public rp4.g f448329e;

    /* renamed from: f, reason: collision with root package name */
    public int f448330f;

    /* renamed from: g, reason: collision with root package name */
    public int f448331g;

    /* renamed from: h, reason: collision with root package name */
    public sp4.a[] f448332h;

    public h() {
        a();
    }

    public static h[] b() {
        if (f448324i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448324i == null) {
                    f448324i = new h[0];
                }
            }
        }
        return f448324i;
    }

    public h a() {
        this.f448325a = 0L;
        this.f448326b = null;
        this.f448327c = "";
        this.f448328d = "";
        this.f448329e = null;
        this.f448330f = 0;
        this.f448331g = 0;
        this.f448332h = sp4.a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (readTag != 66) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                                                sp4.a[] aVarArr = this.f448332h;
                                                if (aVarArr == null) {
                                                    length = 0;
                                                } else {
                                                    length = aVarArr.length;
                                                }
                                                int i3 = repeatedFieldArrayLength + length;
                                                sp4.a[] aVarArr2 = new sp4.a[i3];
                                                if (length != 0) {
                                                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                                                }
                                                while (length < i3 - 1) {
                                                    sp4.a aVar = new sp4.a();
                                                    aVarArr2[length] = aVar;
                                                    codedInputByteBufferNano.readMessage(aVar);
                                                    codedInputByteBufferNano.readTag();
                                                    length++;
                                                }
                                                sp4.a aVar2 = new sp4.a();
                                                aVarArr2[length] = aVar2;
                                                codedInputByteBufferNano.readMessage(aVar2);
                                                this.f448332h = aVarArr2;
                                            }
                                        } else {
                                            this.f448331g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f448330f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    if (this.f448329e == null) {
                                        this.f448329e = new rp4.g();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f448329e);
                                }
                            } else {
                                this.f448328d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f448327c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        if (this.f448326b == null) {
                            this.f448326b = new qp4.e();
                        }
                        codedInputByteBufferNano.readMessage(this.f448326b);
                    }
                } else {
                    this.f448325a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f448325a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        qp4.e eVar = this.f448326b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        if (!this.f448327c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448327c);
        }
        if (!this.f448328d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448328d);
        }
        rp4.g gVar = this.f448329e;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gVar);
        }
        int i3 = this.f448330f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        int i16 = this.f448331g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        sp4.a[] aVarArr = this.f448332h;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                sp4.a[] aVarArr2 = this.f448332h;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                sp4.a aVar = aVarArr2[i17];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, aVar);
                }
                i17++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448325a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        qp4.e eVar = this.f448326b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        if (!this.f448327c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448327c);
        }
        if (!this.f448328d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448328d);
        }
        rp4.g gVar = this.f448329e;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(5, gVar);
        }
        int i3 = this.f448330f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        int i16 = this.f448331g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        sp4.a[] aVarArr = this.f448332h;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                sp4.a[] aVarArr2 = this.f448332h;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                sp4.a aVar = aVarArr2[i17];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(8, aVar);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
