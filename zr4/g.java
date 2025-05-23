package zr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public long f453108a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f453109b;

    /* renamed from: c, reason: collision with root package name */
    public String f453110c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f453111d;

    /* renamed from: e, reason: collision with root package name */
    public int f453112e;

    /* renamed from: f, reason: collision with root package name */
    public int f453113f;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f453108a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f453109b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                this.f453110c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f453111d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f453111d, mapFactory, 9, 9, null, 10, 18);
            } else if (readTag == 40) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f453112e = readInt32;
                }
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                    this.f453113f = readInt322;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f453108a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f453109b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f453109b);
        }
        if (!this.f453110c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f453110c);
        }
        Map<String, String> map = this.f453111d;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 4, 9, 9);
        }
        int i3 = this.f453112e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        int i16 = this.f453113f;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f453108a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f453109b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f453109b);
        }
        if (!this.f453110c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f453110c);
        }
        Map<String, String> map = this.f453111d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 9, 9);
        }
        int i3 = this.f453112e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        int i16 = this.f453113f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f453108a = 0L;
        this.f453109b = WireFormatNano.EMPTY_BYTES;
        this.f453110c = "";
        this.f453111d = null;
        this.f453112e = 0;
        this.f453113f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
