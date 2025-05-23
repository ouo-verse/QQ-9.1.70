package xq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f448414a;

    /* renamed from: b, reason: collision with root package name */
    public long f448415b;

    /* renamed from: c, reason: collision with root package name */
    public String f448416c;

    /* renamed from: d, reason: collision with root package name */
    public Map<Integer, String> f448417d;

    public f() {
        a();
    }

    public f a() {
        this.f448414a = 0L;
        this.f448415b = 0L;
        this.f448416c = "";
        this.f448417d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f448417d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f448417d, mapFactory, 5, 9, null, 8, 18);
                            }
                        } else {
                            this.f448416c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f448415b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f448414a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f448414a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f448415b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f448416c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448416c);
        }
        Map<Integer, String> map = this.f448417d;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 4, 5, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f448414a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f448415b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f448416c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448416c);
        }
        Map<Integer, String> map = this.f448417d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 5, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
