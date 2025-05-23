package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b[] f432392e;

    /* renamed from: a, reason: collision with root package name */
    public String f432393a;

    /* renamed from: b, reason: collision with root package name */
    public String f432394b;

    /* renamed from: c, reason: collision with root package name */
    public u[] f432395c;

    /* renamed from: d, reason: collision with root package name */
    public String f432396d;

    public b() {
        a();
    }

    public static b[] b() {
        if (f432392e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432392e == null) {
                    f432392e = new b[0];
                }
            }
        }
        return f432392e;
    }

    public b a() {
        this.f432393a = "";
        this.f432394b = "";
        this.f432395c = u.b();
        this.f432396d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f432393a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f432394b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                u[] uVarArr = this.f432395c;
                int length = uVarArr == null ? 0 : uVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                u[] uVarArr2 = new u[i3];
                if (length != 0) {
                    System.arraycopy(uVarArr, 0, uVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    u uVar = new u();
                    uVarArr2[length] = uVar;
                    codedInputByteBufferNano.readMessage(uVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                u uVar2 = new u();
                uVarArr2[length] = uVar2;
                codedInputByteBufferNano.readMessage(uVar2);
                this.f432395c = uVarArr2;
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f432396d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f432393a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f432393a);
        }
        if (!this.f432394b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432394b);
        }
        u[] uVarArr = this.f432395c;
        if (uVarArr != null && uVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                u[] uVarArr2 = this.f432395c;
                if (i3 >= uVarArr2.length) {
                    break;
                }
                u uVar = uVarArr2[i3];
                if (uVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, uVar);
                }
                i3++;
            }
        }
        return !this.f432396d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f432396d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f432393a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f432393a);
        }
        if (!this.f432394b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432394b);
        }
        u[] uVarArr = this.f432395c;
        if (uVarArr != null && uVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                u[] uVarArr2 = this.f432395c;
                if (i3 >= uVarArr2.length) {
                    break;
                }
                u uVar = uVarArr2[i3];
                if (uVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, uVar);
                }
                i3++;
            }
        }
        if (!this.f432396d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432396d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
