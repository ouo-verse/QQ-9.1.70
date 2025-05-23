package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ak extends ExtendableMessageNano<ak> {

    /* renamed from: a, reason: collision with root package name */
    public an[] f429939a;

    /* renamed from: b, reason: collision with root package name */
    public al[] f429940b;

    public ak() {
        a();
    }

    public ak a() {
        this.f429939a = an.b();
        this.f429940b = al.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ak mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                an[] anVarArr = this.f429939a;
                int length = anVarArr == null ? 0 : anVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                an[] anVarArr2 = new an[i3];
                if (length != 0) {
                    System.arraycopy(anVarArr, 0, anVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    an anVar = new an();
                    anVarArr2[length] = anVar;
                    codedInputByteBufferNano.readMessage(anVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                an anVar2 = new an();
                anVarArr2[length] = anVar2;
                codedInputByteBufferNano.readMessage(anVar2);
                this.f429939a = anVarArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                al[] alVarArr = this.f429940b;
                int length2 = alVarArr == null ? 0 : alVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                al[] alVarArr2 = new al[i16];
                if (length2 != 0) {
                    System.arraycopy(alVarArr, 0, alVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    al alVar = new al();
                    alVarArr2[length2] = alVar;
                    codedInputByteBufferNano.readMessage(alVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                al alVar2 = new al();
                alVarArr2[length2] = alVar2;
                codedInputByteBufferNano.readMessage(alVar2);
                this.f429940b = alVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        an[] anVarArr = this.f429939a;
        int i3 = 0;
        if (anVarArr != null && anVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                an[] anVarArr2 = this.f429939a;
                if (i16 >= anVarArr2.length) {
                    break;
                }
                an anVar = anVarArr2[i16];
                if (anVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, anVar);
                }
                i16++;
            }
        }
        al[] alVarArr = this.f429940b;
        if (alVarArr != null && alVarArr.length > 0) {
            while (true) {
                al[] alVarArr2 = this.f429940b;
                if (i3 >= alVarArr2.length) {
                    break;
                }
                al alVar = alVarArr2[i3];
                if (alVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, alVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        an[] anVarArr = this.f429939a;
        int i3 = 0;
        if (anVarArr != null && anVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                an[] anVarArr2 = this.f429939a;
                if (i16 >= anVarArr2.length) {
                    break;
                }
                an anVar = anVarArr2[i16];
                if (anVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, anVar);
                }
                i16++;
            }
        }
        al[] alVarArr = this.f429940b;
        if (alVarArr != null && alVarArr.length > 0) {
            while (true) {
                al[] alVarArr2 = this.f429940b;
                if (i3 >= alVarArr2.length) {
                    break;
                }
                al alVar = alVarArr2[i3];
                if (alVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, alVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
