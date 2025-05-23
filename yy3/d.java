package yy3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public e f451562a;

    /* renamed from: b, reason: collision with root package name */
    public String f451563b;

    /* renamed from: c, reason: collision with root package name */
    public String f451564c;

    /* renamed from: d, reason: collision with root package name */
    public String f451565d;

    /* renamed from: e, reason: collision with root package name */
    public String f451566e;

    /* renamed from: f, reason: collision with root package name */
    public long f451567f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f451568g;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f451562a = null;
        this.f451563b = "";
        this.f451564c = "";
        this.f451565d = "";
        this.f451566e = "";
        this.f451567f = 0L;
        this.f451568g = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f451568g = codedInputByteBufferNano.readBytes();
                                        }
                                    } else {
                                        this.f451567f = codedInputByteBufferNano.readInt64();
                                    }
                                } else {
                                    this.f451566e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f451565d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f451564c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f451563b = codedInputByteBufferNano.readString();
                    }
                } else {
                    if (this.f451562a == null) {
                        this.f451562a = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f451562a);
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
        e eVar = this.f451562a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        if (!this.f451563b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f451563b);
        }
        if (!this.f451564c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f451564c);
        }
        if (!this.f451565d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f451565d);
        }
        if (!this.f451566e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f451566e);
        }
        long j3 = this.f451567f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j3);
        }
        if (!Arrays.equals(this.f451568g, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(7, this.f451568g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e eVar = this.f451562a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        if (!this.f451563b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f451563b);
        }
        if (!this.f451564c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f451564c);
        }
        if (!this.f451565d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451565d);
        }
        if (!this.f451566e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451566e);
        }
        long j3 = this.f451567f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j3);
        }
        if (!Arrays.equals(this.f451568g, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(7, this.f451568g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
