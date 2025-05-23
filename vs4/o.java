package vs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import hs4.t;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public long f443328a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f443329b;

    /* renamed from: c, reason: collision with root package name */
    public int f443330c;

    /* renamed from: d, reason: collision with root package name */
    public t f443331d;

    /* renamed from: e, reason: collision with root package name */
    public int f443332e;

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
                this.f443328a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f443329b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.f443330c = readInt32;
                }
            } else if (readTag == 34) {
                if (this.f443331d == null) {
                    this.f443331d = new t();
                }
                codedInputByteBufferNano.readMessage(this.f443331d);
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                    this.f443332e = readInt322;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f443328a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f443329b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f443329b);
        }
        int i3 = this.f443330c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        t tVar = this.f443331d;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, tVar);
        }
        int i16 = this.f443332e;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f443328a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f443329b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f443329b);
        }
        int i3 = this.f443330c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        t tVar = this.f443331d;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(4, tVar);
        }
        int i16 = this.f443332e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f443328a = 0L;
        this.f443329b = WireFormatNano.EMPTY_BYTES;
        this.f443330c = 0;
        this.f443331d = null;
        this.f443332e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
