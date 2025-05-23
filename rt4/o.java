package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public int f432436a;

    /* renamed from: b, reason: collision with root package name */
    public int f432437b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f432438c;

    /* renamed from: d, reason: collision with root package name */
    public int f432439d;

    /* renamed from: e, reason: collision with root package name */
    public hs4.j f432440e;

    /* renamed from: f, reason: collision with root package name */
    public int f432441f;

    public o() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f432436a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f432437b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.f432438c = codedInputByteBufferNano.readBytes();
            } else if (readTag == 32) {
                this.f432439d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                if (this.f432440e == null) {
                    this.f432440e = new hs4.j();
                }
                codedInputByteBufferNano.readMessage(this.f432440e);
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f432441f = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f432436a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f432437b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!Arrays.equals(this.f432438c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f432438c);
        }
        int i17 = this.f432439d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        hs4.j jVar = this.f432440e;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, jVar);
        }
        int i18 = this.f432441f;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432436a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f432437b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!Arrays.equals(this.f432438c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f432438c);
        }
        int i17 = this.f432439d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        hs4.j jVar = this.f432440e;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(5, jVar);
        }
        int i18 = this.f432441f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f432436a = 0;
        this.f432437b = 0;
        this.f432438c = WireFormatNano.EMPTY_BYTES;
        this.f432439d = 0;
        this.f432440e = null;
        this.f432441f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
