package yo4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f450750a;

    /* renamed from: b, reason: collision with root package name */
    public a f450751b;

    /* renamed from: c, reason: collision with root package name */
    public int f450752c;

    /* renamed from: d, reason: collision with root package name */
    public String f450753d;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f450750a = 0;
        this.f450751b = null;
        this.f450752c = 0;
        this.f450753d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 32) {
                            if (readTag != 42) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f450753d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f450752c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        if (this.f450751b == null) {
                            this.f450751b = new a();
                        }
                        codedInputByteBufferNano.readMessage(this.f450751b);
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 10) {
                        switch (readInt32) {
                        }
                    }
                    this.f450750a = readInt32;
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
        int i3 = this.f450750a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        a aVar = this.f450751b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        int i16 = this.f450752c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.f450753d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f450753d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f450750a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        a aVar = this.f450751b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        int i16 = this.f450752c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.f450753d.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f450753d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
