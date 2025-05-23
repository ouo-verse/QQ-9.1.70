package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ae extends ExtendableMessageNano<ae> {

    /* renamed from: a, reason: collision with root package name */
    public az f429903a;

    /* renamed from: b, reason: collision with root package name */
    public int f429904b;

    /* renamed from: c, reason: collision with root package name */
    public int f429905c;

    /* renamed from: d, reason: collision with root package name */
    public int f429906d;

    public ae() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ae mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f429903a == null) {
                    this.f429903a = new az();
                }
                codedInputByteBufferNano.readMessage(this.f429903a);
            } else if (readTag == 16) {
                this.f429904b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f429905c = codedInputByteBufferNano.readInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429906d = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        az azVar = this.f429903a;
        if (azVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, azVar);
        }
        int i3 = this.f429904b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f429905c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        int i17 = this.f429906d;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        az azVar = this.f429903a;
        if (azVar != null) {
            codedOutputByteBufferNano.writeMessage(1, azVar);
        }
        int i3 = this.f429904b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f429905c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        int i17 = this.f429906d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ae a() {
        this.f429903a = null;
        this.f429904b = 0;
        this.f429905c = 0;
        this.f429906d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
