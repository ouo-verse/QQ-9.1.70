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
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f451896a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f451897b;

    public c() {
        a();
    }

    public c a() {
        this.f451896a = "";
        this.f451897b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f451897b = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f451897b, mapFactory, 9, 9, null, 10, 18);
                    }
                } else {
                    this.f451896a = codedInputByteBufferNano.readString();
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
        if (!this.f451896a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451896a);
        }
        Map<String, String> map = this.f451897b;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 2, 9, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451896a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451896a);
        }
        Map<String, String> map = this.f451897b;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 2, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
