package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class av extends ExtendableMessageNano<av> {

    /* renamed from: a, reason: collision with root package name */
    public ax[] f440237a;

    /* renamed from: b, reason: collision with root package name */
    public aw[] f440238b;

    public av() {
        a();
    }

    public av a() {
        this.f440237a = ax.b();
        this.f440238b = aw.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public av mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                ax[] axVarArr = this.f440237a;
                int length = axVarArr == null ? 0 : axVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ax[] axVarArr2 = new ax[i3];
                if (length != 0) {
                    System.arraycopy(axVarArr, 0, axVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ax axVar = new ax();
                    axVarArr2[length] = axVar;
                    codedInputByteBufferNano.readMessage(axVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ax axVar2 = new ax();
                axVarArr2[length] = axVar2;
                codedInputByteBufferNano.readMessage(axVar2);
                this.f440237a = axVarArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                aw[] awVarArr = this.f440238b;
                int length2 = awVarArr == null ? 0 : awVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                aw[] awVarArr2 = new aw[i16];
                if (length2 != 0) {
                    System.arraycopy(awVarArr, 0, awVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    aw awVar = new aw();
                    awVarArr2[length2] = awVar;
                    codedInputByteBufferNano.readMessage(awVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                aw awVar2 = new aw();
                awVarArr2[length2] = awVar2;
                codedInputByteBufferNano.readMessage(awVar2);
                this.f440238b = awVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ax[] axVarArr = this.f440237a;
        int i3 = 0;
        if (axVarArr != null && axVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ax[] axVarArr2 = this.f440237a;
                if (i16 >= axVarArr2.length) {
                    break;
                }
                ax axVar = axVarArr2[i16];
                if (axVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, axVar);
                }
                i16++;
            }
        }
        aw[] awVarArr = this.f440238b;
        if (awVarArr != null && awVarArr.length > 0) {
            while (true) {
                aw[] awVarArr2 = this.f440238b;
                if (i3 >= awVarArr2.length) {
                    break;
                }
                aw awVar = awVarArr2[i3];
                if (awVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, awVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ax[] axVarArr = this.f440237a;
        int i3 = 0;
        if (axVarArr != null && axVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ax[] axVarArr2 = this.f440237a;
                if (i16 >= axVarArr2.length) {
                    break;
                }
                ax axVar = axVarArr2[i16];
                if (axVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, axVar);
                }
                i16++;
            }
        }
        aw[] awVarArr = this.f440238b;
        if (awVarArr != null && awVarArr.length > 0) {
            while (true) {
                aw[] awVarArr2 = this.f440238b;
                if (i3 >= awVarArr2.length) {
                    break;
                }
                aw awVar = awVarArr2[i3];
                if (awVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, awVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
