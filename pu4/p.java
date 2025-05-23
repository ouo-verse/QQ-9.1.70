package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile p[] f427506g;

    /* renamed from: a, reason: collision with root package name */
    public long f427507a;

    /* renamed from: b, reason: collision with root package name */
    public g f427508b;

    /* renamed from: c, reason: collision with root package name */
    public String f427509c;

    /* renamed from: d, reason: collision with root package name */
    public k[] f427510d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f427511e;

    /* renamed from: f, reason: collision with root package name */
    public long f427512f;

    public p() {
        a();
    }

    public static p[] b() {
        if (f427506g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427506g == null) {
                    f427506g = new p[0];
                }
            }
        }
        return f427506g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427507a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.f427508b == null) {
                    this.f427508b = new g();
                }
                codedInputByteBufferNano.readMessage(this.f427508b);
            } else if (readTag == 26) {
                this.f427509c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                k[] kVarArr = this.f427510d;
                int length = kVarArr == null ? 0 : kVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                k[] kVarArr2 = new k[i3];
                if (length != 0) {
                    System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    k kVar = new k();
                    kVarArr2[length] = kVar;
                    codedInputByteBufferNano.readMessage(kVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                k kVar2 = new k();
                kVarArr2[length] = kVar2;
                codedInputByteBufferNano.readMessage(kVar2);
                this.f427510d = kVarArr2;
            } else if (readTag == 40) {
                this.f427511e = codedInputByteBufferNano.readBool();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427512f = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f427507a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        g gVar = this.f427508b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        if (!this.f427509c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427509c);
        }
        k[] kVarArr = this.f427510d;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f427510d;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, kVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f427511e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        long j16 = this.f427512f;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427507a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        g gVar = this.f427508b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        if (!this.f427509c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427509c);
        }
        k[] kVarArr = this.f427510d;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f427510d;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, kVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f427511e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        long j16 = this.f427512f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f427507a = 0L;
        this.f427508b = null;
        this.f427509c = "";
        this.f427510d = k.b();
        this.f427511e = false;
        this.f427512f = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
