package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile l[] f430183c;

    /* renamed from: a, reason: collision with root package name */
    public bb[] f430184a;

    /* renamed from: b, reason: collision with root package name */
    public int f430185b;

    public l() {
        a();
    }

    public static l[] b() {
        if (f430183c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430183c == null) {
                    f430183c = new l[0];
                }
            }
        }
        return f430183c;
    }

    public l a() {
        this.f430184a = bb.b();
        this.f430185b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                bb[] bbVarArr = this.f430184a;
                int length = bbVarArr == null ? 0 : bbVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bb[] bbVarArr2 = new bb[i3];
                if (length != 0) {
                    System.arraycopy(bbVarArr, 0, bbVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bb bbVar = new bb();
                    bbVarArr2[length] = bbVar;
                    codedInputByteBufferNano.readMessage(bbVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bb bbVar2 = new bb();
                bbVarArr2[length] = bbVar2;
                codedInputByteBufferNano.readMessage(bbVar2);
                this.f430184a = bbVarArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430185b = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bb[] bbVarArr = this.f430184a;
        if (bbVarArr != null && bbVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bb[] bbVarArr2 = this.f430184a;
                if (i3 >= bbVarArr2.length) {
                    break;
                }
                bb bbVar = bbVarArr2[i3];
                if (bbVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bbVar);
                }
                i3++;
            }
        }
        int i16 = this.f430185b;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bb[] bbVarArr = this.f430184a;
        if (bbVarArr != null && bbVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bb[] bbVarArr2 = this.f430184a;
                if (i3 >= bbVarArr2.length) {
                    break;
                }
                bb bbVar = bbVarArr2[i3];
                if (bbVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bbVar);
                }
                i3++;
            }
        }
        int i16 = this.f430185b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
