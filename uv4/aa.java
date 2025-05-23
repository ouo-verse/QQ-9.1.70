package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class aa extends ExtendableMessageNano<aa> {

    /* renamed from: a, reason: collision with root package name */
    public bk[] f440103a;

    /* renamed from: b, reason: collision with root package name */
    public long f440104b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f440105c;

    /* renamed from: d, reason: collision with root package name */
    public String f440106d;

    /* renamed from: e, reason: collision with root package name */
    public bk[] f440107e;

    /* renamed from: f, reason: collision with root package name */
    public String f440108f;

    public aa() {
        a();
    }

    public static aa c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (aa) MessageNano.mergeFrom(new aa(), bArr);
    }

    public aa a() {
        this.f440103a = bk.b();
        this.f440104b = 0L;
        this.f440105c = false;
        this.f440106d = "";
        this.f440107e = bk.b();
        this.f440108f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                bk[] bkVarArr = this.f440103a;
                int length = bkVarArr == null ? 0 : bkVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bk[] bkVarArr2 = new bk[i3];
                if (length != 0) {
                    System.arraycopy(bkVarArr, 0, bkVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bk bkVar = new bk();
                    bkVarArr2[length] = bkVar;
                    codedInputByteBufferNano.readMessage(bkVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bk bkVar2 = new bk();
                bkVarArr2[length] = bkVar2;
                codedInputByteBufferNano.readMessage(bkVar2);
                this.f440103a = bkVarArr2;
            } else if (readTag == 16) {
                this.f440104b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f440105c = codedInputByteBufferNano.readBool();
            } else if (readTag == 34) {
                this.f440106d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                bk[] bkVarArr3 = this.f440107e;
                int length2 = bkVarArr3 == null ? 0 : bkVarArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                bk[] bkVarArr4 = new bk[i16];
                if (length2 != 0) {
                    System.arraycopy(bkVarArr3, 0, bkVarArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    bk bkVar3 = new bk();
                    bkVarArr4[length2] = bkVar3;
                    codedInputByteBufferNano.readMessage(bkVar3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                bk bkVar4 = new bk();
                bkVarArr4[length2] = bkVar4;
                codedInputByteBufferNano.readMessage(bkVar4);
                this.f440107e = bkVarArr4;
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440108f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        bk[] bkVarArr = this.f440103a;
        int i3 = 0;
        if (bkVarArr != null && bkVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bk[] bkVarArr2 = this.f440103a;
                if (i16 >= bkVarArr2.length) {
                    break;
                }
                bk bkVar = bkVarArr2[i16];
                if (bkVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bkVar);
                }
                i16++;
            }
        }
        long j3 = this.f440104b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        boolean z16 = this.f440105c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        if (!this.f440106d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440106d);
        }
        bk[] bkVarArr3 = this.f440107e;
        if (bkVarArr3 != null && bkVarArr3.length > 0) {
            while (true) {
                bk[] bkVarArr4 = this.f440107e;
                if (i3 >= bkVarArr4.length) {
                    break;
                }
                bk bkVar2 = bkVarArr4[i3];
                if (bkVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, bkVar2);
                }
                i3++;
            }
        }
        return !this.f440108f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f440108f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bk[] bkVarArr = this.f440103a;
        int i3 = 0;
        if (bkVarArr != null && bkVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bk[] bkVarArr2 = this.f440103a;
                if (i16 >= bkVarArr2.length) {
                    break;
                }
                bk bkVar = bkVarArr2[i16];
                if (bkVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bkVar);
                }
                i16++;
            }
        }
        long j3 = this.f440104b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        boolean z16 = this.f440105c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!this.f440106d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440106d);
        }
        bk[] bkVarArr3 = this.f440107e;
        if (bkVarArr3 != null && bkVarArr3.length > 0) {
            while (true) {
                bk[] bkVarArr4 = this.f440107e;
                if (i3 >= bkVarArr4.length) {
                    break;
                }
                bk bkVar2 = bkVarArr4[i3];
                if (bkVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(5, bkVar2);
                }
                i3++;
            }
        }
        if (!this.f440108f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440108f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
