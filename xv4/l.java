package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public aa f448808a;

    /* renamed from: b, reason: collision with root package name */
    public ab[] f448809b;

    /* renamed from: c, reason: collision with root package name */
    public z[] f448810c;

    public l() {
        a();
    }

    public static l c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (l) MessageNano.mergeFrom(new l(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f448808a == null) {
                    this.f448808a = new aa();
                }
                codedInputByteBufferNano.readMessage(this.f448808a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                ab[] abVarArr = this.f448809b;
                int length = abVarArr == null ? 0 : abVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ab[] abVarArr2 = new ab[i3];
                if (length != 0) {
                    System.arraycopy(abVarArr, 0, abVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ab abVar = new ab();
                    abVarArr2[length] = abVar;
                    codedInputByteBufferNano.readMessage(abVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ab abVar2 = new ab();
                abVarArr2[length] = abVar2;
                codedInputByteBufferNano.readMessage(abVar2);
                this.f448809b = abVarArr2;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                z[] zVarArr = this.f448810c;
                int length2 = zVarArr == null ? 0 : zVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                z[] zVarArr2 = new z[i16];
                if (length2 != 0) {
                    System.arraycopy(zVarArr, 0, zVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    z zVar = new z();
                    zVarArr2[length2] = zVar;
                    codedInputByteBufferNano.readMessage(zVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                z zVar2 = new z();
                zVarArr2[length2] = zVar2;
                codedInputByteBufferNano.readMessage(zVar2);
                this.f448810c = zVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        aa aaVar = this.f448808a;
        if (aaVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aaVar);
        }
        ab[] abVarArr = this.f448809b;
        int i3 = 0;
        if (abVarArr != null && abVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448809b;
                if (i16 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i16];
                if (abVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, abVar);
                }
                i16++;
            }
        }
        z[] zVarArr = this.f448810c;
        if (zVarArr != null && zVarArr.length > 0) {
            while (true) {
                z[] zVarArr2 = this.f448810c;
                if (i3 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i3];
                if (zVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, zVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        aa aaVar = this.f448808a;
        if (aaVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aaVar);
        }
        ab[] abVarArr = this.f448809b;
        int i3 = 0;
        if (abVarArr != null && abVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                ab[] abVarArr2 = this.f448809b;
                if (i16 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i16];
                if (abVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, abVar);
                }
                i16++;
            }
        }
        z[] zVarArr = this.f448810c;
        if (zVarArr != null && zVarArr.length > 0) {
            while (true) {
                z[] zVarArr2 = this.f448810c;
                if (i3 >= zVarArr2.length) {
                    break;
                }
                z zVar = zVarArr2[i3];
                if (zVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, zVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f448808a = null;
        this.f448809b = ab.b();
        this.f448810c = z.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
