package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile r[] f451521d;

    /* renamed from: a, reason: collision with root package name */
    public h[] f451522a;

    /* renamed from: b, reason: collision with root package name */
    public String f451523b;

    /* renamed from: c, reason: collision with root package name */
    public int f451524c;

    public r() {
        a();
    }

    public static r[] b() {
        if (f451521d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451521d == null) {
                    f451521d = new r[0];
                }
            }
        }
        return f451521d;
    }

    public r a() {
        this.f451522a = h.b();
        this.f451523b = "";
        this.f451524c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f451524c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f451523b = codedInputByteBufferNano.readString();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    h[] hVarArr = this.f451522a;
                    if (hVarArr == null) {
                        length = 0;
                    } else {
                        length = hVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    h[] hVarArr2 = new h[i3];
                    if (length != 0) {
                        System.arraycopy(hVarArr, 0, hVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        h hVar = new h();
                        hVarArr2[length] = hVar;
                        codedInputByteBufferNano.readMessage(hVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    h hVar2 = new h();
                    hVarArr2[length] = hVar2;
                    codedInputByteBufferNano.readMessage(hVar2);
                    this.f451522a = hVarArr2;
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
        h[] hVarArr = this.f451522a;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f451522a;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, hVar);
                }
                i3++;
            }
        }
        if (!this.f451523b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451523b);
        }
        int i16 = this.f451524c;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        h[] hVarArr = this.f451522a;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f451522a;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, hVar);
                }
                i3++;
            }
        }
        if (!this.f451523b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451523b);
        }
        int i16 = this.f451524c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
