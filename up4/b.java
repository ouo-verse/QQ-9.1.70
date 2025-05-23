package up4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
import op4.i;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public i[] f439767a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f439768b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f439769c;

    /* renamed from: d, reason: collision with root package name */
    public int f439770d;

    /* renamed from: e, reason: collision with root package name */
    public np4.c f439771e;

    /* renamed from: f, reason: collision with root package name */
    public c f439772f;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f439767a = i.b();
        this.f439768b = false;
        this.f439769c = WireFormatNano.EMPTY_BYTES;
        this.f439770d = 0;
        this.f439771e = null;
        this.f439772f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        if (this.f439772f == null) {
                                            this.f439772f = new c();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f439772f);
                                    }
                                } else {
                                    if (this.f439771e == null) {
                                        this.f439771e = new np4.c();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f439771e);
                                }
                            } else {
                                this.f439770d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f439769c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f439768b = codedInputByteBufferNano.readBool();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    i[] iVarArr = this.f439767a;
                    if (iVarArr == null) {
                        length = 0;
                    } else {
                        length = iVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    i[] iVarArr2 = new i[i3];
                    if (length != 0) {
                        System.arraycopy(iVarArr, 0, iVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        i iVar = new i();
                        iVarArr2[length] = iVar;
                        codedInputByteBufferNano.readMessage(iVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    i iVar2 = new i();
                    iVarArr2[length] = iVar2;
                    codedInputByteBufferNano.readMessage(iVar2);
                    this.f439767a = iVarArr2;
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
        i[] iVarArr = this.f439767a;
        if (iVarArr != null && iVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                i[] iVarArr2 = this.f439767a;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f439768b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        if (!Arrays.equals(this.f439769c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f439769c);
        }
        int i16 = this.f439770d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        np4.c cVar = this.f439771e;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cVar);
        }
        c cVar2 = this.f439772f;
        if (cVar2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, cVar2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        i[] iVarArr = this.f439767a;
        if (iVarArr != null && iVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                i[] iVarArr2 = this.f439767a;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, iVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f439768b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        if (!Arrays.equals(this.f439769c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f439769c);
        }
        int i16 = this.f439770d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        np4.c cVar = this.f439771e;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(5, cVar);
        }
        c cVar2 = this.f439772f;
        if (cVar2 != null) {
            codedOutputByteBufferNano.writeMessage(6, cVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
