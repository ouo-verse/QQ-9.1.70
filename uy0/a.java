package uy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f440582a;

    /* renamed from: b, reason: collision with root package name */
    public long f440583b;

    /* renamed from: c, reason: collision with root package name */
    public String f440584c;

    /* renamed from: d, reason: collision with root package name */
    public long f440585d;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f440582a = 0;
        this.f440583b = 0L;
        this.f440584c = "";
        this.f440585d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f440585d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            this.f440584c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f440583b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f440582a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f440582a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.f440583b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.f440584c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440584c);
        }
        long j16 = this.f440585d;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440582a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.f440583b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.f440584c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440584c);
        }
        long j16 = this.f440585d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
