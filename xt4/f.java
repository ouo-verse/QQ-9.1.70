package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public ag[] f448581a;

    /* renamed from: b, reason: collision with root package name */
    public a f448582b;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f448581a = ag.b();
        this.f448582b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                ag[] agVarArr = this.f448581a;
                int length = agVarArr == null ? 0 : agVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ag[] agVarArr2 = new ag[i3];
                if (length != 0) {
                    System.arraycopy(agVarArr, 0, agVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ag agVar = new ag();
                    agVarArr2[length] = agVar;
                    codedInputByteBufferNano.readMessage(agVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ag agVar2 = new ag();
                agVarArr2[length] = agVar2;
                codedInputByteBufferNano.readMessage(agVar2);
                this.f448581a = agVarArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f448582b == null) {
                    this.f448582b = new a();
                }
                codedInputByteBufferNano.readMessage(this.f448582b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ag[] agVarArr = this.f448581a;
        if (agVarArr != null && agVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ag[] agVarArr2 = this.f448581a;
                if (i3 >= agVarArr2.length) {
                    break;
                }
                ag agVar = agVarArr2[i3];
                if (agVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, agVar);
                }
                i3++;
            }
        }
        a aVar = this.f448582b;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ag[] agVarArr = this.f448581a;
        if (agVarArr != null && agVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                ag[] agVarArr2 = this.f448581a;
                if (i3 >= agVarArr2.length) {
                    break;
                }
                ag agVar = agVarArr2[i3];
                if (agVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, agVar);
                }
                i3++;
            }
        }
        a aVar = this.f448582b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
