package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ac extends ExtendableMessageNano<ac> {

    /* renamed from: a, reason: collision with root package name */
    public long f448771a;

    /* renamed from: b, reason: collision with root package name */
    public int f448772b;

    /* renamed from: c, reason: collision with root package name */
    public String f448773c;

    /* renamed from: d, reason: collision with root package name */
    public String f448774d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f448775e;

    /* renamed from: f, reason: collision with root package name */
    public w[] f448776f;

    /* renamed from: g, reason: collision with root package name */
    public long f448777g;

    public ac() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ac mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448771a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f448772b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f448773c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f448774d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f448775e = codedInputByteBufferNano.readBool();
            } else if (readTag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                w[] wVarArr = this.f448776f;
                int length = wVarArr == null ? 0 : wVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                w[] wVarArr2 = new w[i3];
                if (length != 0) {
                    System.arraycopy(wVarArr, 0, wVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    w wVar = new w();
                    wVarArr2[length] = wVar;
                    codedInputByteBufferNano.readMessage(wVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                w wVar2 = new w();
                wVarArr2[length] = wVar2;
                codedInputByteBufferNano.readMessage(wVar2);
                this.f448776f = wVarArr2;
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448777g = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f448771a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f448772b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f448773c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448773c);
        }
        if (!this.f448774d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448774d);
        }
        boolean z16 = this.f448775e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        w[] wVarArr = this.f448776f;
        if (wVarArr != null && wVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                w[] wVarArr2 = this.f448776f;
                if (i16 >= wVarArr2.length) {
                    break;
                }
                w wVar = wVarArr2[i16];
                if (wVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, wVar);
                }
                i16++;
            }
        }
        long j16 = this.f448777g;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448771a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f448772b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f448773c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448773c);
        }
        if (!this.f448774d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448774d);
        }
        boolean z16 = this.f448775e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        w[] wVarArr = this.f448776f;
        if (wVarArr != null && wVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                w[] wVarArr2 = this.f448776f;
                if (i16 >= wVarArr2.length) {
                    break;
                }
                w wVar = wVarArr2[i16];
                if (wVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, wVar);
                }
                i16++;
            }
        }
        long j16 = this.f448777g;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ac a() {
        this.f448771a = 0L;
        this.f448772b = 0;
        this.f448773c = "";
        this.f448774d = "";
        this.f448775e = false;
        this.f448776f = w.b();
        this.f448777g = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
