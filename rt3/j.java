package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile j[] f432312d;

    /* renamed from: a, reason: collision with root package name */
    public int f432313a;

    /* renamed from: b, reason: collision with root package name */
    public String f432314b;

    /* renamed from: c, reason: collision with root package name */
    public u[] f432315c;

    public j() {
        a();
    }

    public static j[] b() {
        if (f432312d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432312d == null) {
                    f432312d = new j[0];
                }
            }
        }
        return f432312d;
    }

    public j a() {
        this.f432313a = 0;
        this.f432314b = "";
        this.f432315c = u.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            u[] uVarArr = this.f432315c;
                            if (uVarArr == null) {
                                length = 0;
                            } else {
                                length = uVarArr.length;
                            }
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
                            this.f432315c = uVarArr2;
                        }
                    } else {
                        this.f432314b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432313a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f432313a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f432314b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432314b);
        }
        u[] uVarArr = this.f432315c;
        if (uVarArr != null && uVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                u[] uVarArr2 = this.f432315c;
                if (i16 >= uVarArr2.length) {
                    break;
                }
                u uVar = uVarArr2[i16];
                if (uVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, uVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432313a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f432314b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432314b);
        }
        u[] uVarArr = this.f432315c;
        if (uVarArr != null && uVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                u[] uVarArr2 = this.f432315c;
                if (i16 >= uVarArr2.length) {
                    break;
                }
                u uVar = uVarArr2[i16];
                if (uVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, uVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
