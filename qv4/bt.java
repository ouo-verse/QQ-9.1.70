package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bt extends ExtendableMessageNano<bt> {

    /* renamed from: a, reason: collision with root package name */
    public long f430117a;

    /* renamed from: b, reason: collision with root package name */
    public String f430118b;

    /* renamed from: c, reason: collision with root package name */
    public String f430119c;

    /* renamed from: d, reason: collision with root package name */
    public int f430120d;

    /* renamed from: e, reason: collision with root package name */
    public long f430121e;

    /* renamed from: f, reason: collision with root package name */
    public bu[] f430122f;

    public bt() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bt mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f430117a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                this.f430118b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f430119c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f430120d = codedInputByteBufferNano.readInt32();
            } else if (readTag == 40) {
                this.f430121e = codedInputByteBufferNano.readInt64();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                bu[] buVarArr = this.f430122f;
                int length = buVarArr == null ? 0 : buVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bu[] buVarArr2 = new bu[i3];
                if (length != 0) {
                    System.arraycopy(buVarArr, 0, buVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bu buVar = new bu();
                    buVarArr2[length] = buVar;
                    codedInputByteBufferNano.readMessage(buVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bu buVar2 = new bu();
                buVarArr2[length] = buVar2;
                codedInputByteBufferNano.readMessage(buVar2);
                this.f430122f = buVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f430117a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        if (!this.f430118b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430118b);
        }
        if (!this.f430119c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430119c);
        }
        int i3 = this.f430120d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        long j16 = this.f430121e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j16);
        }
        bu[] buVarArr = this.f430122f;
        if (buVarArr != null && buVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bu[] buVarArr2 = this.f430122f;
                if (i16 >= buVarArr2.length) {
                    break;
                }
                bu buVar = buVarArr2[i16];
                if (buVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, buVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f430117a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        if (!this.f430118b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430118b);
        }
        if (!this.f430119c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430119c);
        }
        int i3 = this.f430120d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        long j16 = this.f430121e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j16);
        }
        bu[] buVarArr = this.f430122f;
        if (buVarArr != null && buVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bu[] buVarArr2 = this.f430122f;
                if (i16 >= buVarArr2.length) {
                    break;
                }
                bu buVar = buVarArr2[i16];
                if (buVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, buVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bt a() {
        this.f430117a = 0L;
        this.f430118b = "";
        this.f430119c = "";
        this.f430120d = 0;
        this.f430121e = 0L;
        this.f430122f = bu.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
