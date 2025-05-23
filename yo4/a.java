package yo4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f450746a;

    /* renamed from: b, reason: collision with root package name */
    public String f450747b;

    /* renamed from: c, reason: collision with root package name */
    public c f450748c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f450749d;

    public a() {
        a();
    }

    public a a() {
        this.f450746a = "";
        this.f450747b = "";
        this.f450748c = null;
        this.f450749d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f450749d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f450749d, mapFactory, 9, 9, null, 10, 18);
                            }
                        } else {
                            if (this.f450748c == null) {
                                this.f450748c = new c();
                            }
                            codedInputByteBufferNano.readMessage(this.f450748c);
                        }
                    } else {
                        this.f450747b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f450746a = codedInputByteBufferNano.readString();
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
        if (!this.f450746a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f450746a);
        }
        if (!this.f450747b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f450747b);
        }
        c cVar = this.f450748c;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
        }
        Map<String, String> map = this.f450749d;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 4, 9, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f450746a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f450746a);
        }
        if (!this.f450747b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f450747b);
        }
        c cVar = this.f450748c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        Map<String, String> map = this.f450749d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
