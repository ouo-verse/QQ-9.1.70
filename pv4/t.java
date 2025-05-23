package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class t extends ExtendableMessageNano<t> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile t[] f427695f;

    /* renamed from: a, reason: collision with root package name */
    public u f427696a;

    /* renamed from: b, reason: collision with root package name */
    public String f427697b;

    /* renamed from: c, reason: collision with root package name */
    public int f427698c;

    /* renamed from: d, reason: collision with root package name */
    public r[] f427699d;

    /* renamed from: e, reason: collision with root package name */
    public int f427700e;

    public t() {
        a();
    }

    public static t[] b() {
        if (f427695f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427695f == null) {
                    f427695f = new t[0];
                }
            }
        }
        return f427695f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public t mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f427696a == null) {
                    this.f427696a = new u();
                }
                codedInputByteBufferNano.readMessage(this.f427696a);
            } else if (readTag == 18) {
                this.f427697b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f427698c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                r[] rVarArr = this.f427699d;
                int length = rVarArr == null ? 0 : rVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                r[] rVarArr2 = new r[i3];
                if (length != 0) {
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    r rVar = new r();
                    rVarArr2[length] = rVar;
                    codedInputByteBufferNano.readMessage(rVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                r rVar2 = new r();
                rVarArr2[length] = rVar2;
                codedInputByteBufferNano.readMessage(rVar2);
                this.f427699d = rVarArr2;
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427700e = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        u uVar = this.f427696a;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, uVar);
        }
        if (!this.f427697b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427697b);
        }
        int i3 = this.f427698c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        r[] rVarArr = this.f427699d;
        if (rVarArr != null && rVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                r[] rVarArr2 = this.f427699d;
                if (i16 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i16];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, rVar);
                }
                i16++;
            }
        }
        int i17 = this.f427700e;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        u uVar = this.f427696a;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(1, uVar);
        }
        if (!this.f427697b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427697b);
        }
        int i3 = this.f427698c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        r[] rVarArr = this.f427699d;
        if (rVarArr != null && rVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                r[] rVarArr2 = this.f427699d;
                if (i16 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i16];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, rVar);
                }
                i16++;
            }
        }
        int i17 = this.f427700e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public t a() {
        this.f427696a = null;
        this.f427697b = "";
        this.f427698c = 0;
        this.f427699d = r.b();
        this.f427700e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
