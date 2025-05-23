package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile k[] f432316d;

    /* renamed from: a, reason: collision with root package name */
    public int f432317a;

    /* renamed from: b, reason: collision with root package name */
    public b[] f432318b;

    /* renamed from: c, reason: collision with root package name */
    public String f432319c;

    public k() {
        a();
    }

    public static k[] b() {
        if (f432316d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432316d == null) {
                    f432316d = new k[0];
                }
            }
        }
        return f432316d;
    }

    public k a() {
        this.f432317a = 0;
        this.f432318b = b.b();
        this.f432319c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f432319c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        b[] bVarArr = this.f432318b;
                        if (bVarArr == null) {
                            length = 0;
                        } else {
                            length = bVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        b[] bVarArr2 = new b[i3];
                        if (length != 0) {
                            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            b bVar = new b();
                            bVarArr2[length] = bVar;
                            codedInputByteBufferNano.readMessage(bVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        b bVar2 = new b();
                        bVarArr2[length] = bVar2;
                        codedInputByteBufferNano.readMessage(bVar2);
                        this.f432318b = bVarArr2;
                    }
                } else {
                    this.f432317a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f432317a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        b[] bVarArr = this.f432318b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f432318b;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
                }
                i16++;
            }
        }
        if (!this.f432319c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f432319c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432317a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        b[] bVarArr = this.f432318b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f432318b;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bVar);
                }
                i16++;
            }
        }
        if (!this.f432319c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432319c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
