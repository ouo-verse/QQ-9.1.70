package up4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f439761a;

    /* renamed from: b, reason: collision with root package name */
    public int f439762b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f439763c;

    /* renamed from: d, reason: collision with root package name */
    public int f439764d;

    /* renamed from: e, reason: collision with root package name */
    public np4.c f439765e;

    /* renamed from: f, reason: collision with root package name */
    public String f439766f;

    public a() {
        a();
    }

    public a a() {
        this.f439761a = "";
        this.f439762b = 0;
        this.f439763c = WireFormatNano.EMPTY_BYTES;
        this.f439764d = 0;
        this.f439765e = null;
        this.f439766f = "";
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
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f439766f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    if (this.f439765e == null) {
                                        this.f439765e = new np4.c();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f439765e);
                                }
                            } else {
                                int readInt32 = codedInputByteBufferNano.readInt32();
                                if (readInt32 == 0 || readInt32 == 1) {
                                    this.f439764d = readInt32;
                                }
                            }
                        } else {
                            this.f439763c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f439762b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f439761a = codedInputByteBufferNano.readString();
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
        if (!this.f439761a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f439761a);
        }
        int i3 = this.f439762b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!Arrays.equals(this.f439763c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f439763c);
        }
        int i16 = this.f439764d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        np4.c cVar = this.f439765e;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cVar);
        }
        if (!this.f439766f.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f439766f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f439761a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f439761a);
        }
        int i3 = this.f439762b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!Arrays.equals(this.f439763c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f439763c);
        }
        int i16 = this.f439764d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        np4.c cVar = this.f439765e;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(5, cVar);
        }
        if (!this.f439766f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f439766f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
