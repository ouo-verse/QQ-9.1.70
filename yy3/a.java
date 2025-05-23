package yy3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f451553a;

    /* renamed from: b, reason: collision with root package name */
    public String f451554b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f451555c;

    /* renamed from: d, reason: collision with root package name */
    public int f451556d;

    public a() {
        a();
    }

    public a a() {
        this.f451553a = "";
        this.f451554b = "";
        this.f451555c = WireFormatNano.EMPTY_BYTES;
        this.f451556d = 0;
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
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f451556d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f451555c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f451554b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f451553a = codedInputByteBufferNano.readString();
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
        if (!this.f451553a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451553a);
        }
        if (!this.f451554b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451554b);
        }
        if (!Arrays.equals(this.f451555c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f451555c);
        }
        int i3 = this.f451556d;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451553a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451553a);
        }
        if (!this.f451554b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451554b);
        }
        if (!Arrays.equals(this.f451555c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f451555c);
        }
        int i3 = this.f451556d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
