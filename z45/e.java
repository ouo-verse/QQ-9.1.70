package z45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public long f451902a;

    /* renamed from: b, reason: collision with root package name */
    public int f451903b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f451904c;

    public e() {
        a();
    }

    public e a() {
        this.f451902a = 0L;
        this.f451903b = 0;
        this.f451904c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f451904c = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f451904c, mapFactory, 9, 9, null, 10, 18);
                        }
                    } else {
                        this.f451903b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f451902a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f451902a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f451903b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        Map<String, String> map = this.f451904c;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 3, 9, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f451902a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f451903b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        Map<String, String> map = this.f451904c;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 3, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
